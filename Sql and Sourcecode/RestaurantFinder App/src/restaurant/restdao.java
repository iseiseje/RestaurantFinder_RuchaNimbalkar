package restaurant;

import java.util.*;


import java.sql.*;
import java.io.*;

public class restdao {
	
	
	private static Connection myconn;
	
	
	public restdao() throws Exception {
		
		
		// connect to database
		myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_finder_database", "root","1234");
		System.out.println("DB connection successful : ");

		
	}
	
	public void delete(int rid) throws SQLException {
		
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myconn.prepareStatement("delete from restaurants where id=?");
			
			// set parameter
			myStmt.setInt(1, rid);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	

	
/*Update Restaurant data method*/	
	public void updaterest(rest thehotel) throws SQLException {
		PreparedStatement myStmt = null;
		

		try {
			// prepare statement
			myStmt = myconn.prepareStatement("update restaurants"
					+ " set r_name= ?, cuisine= ?, addr= ?, zip= ?, rating= ?, r_range= ?"
					+ " where id = ?");
			
			// set parameters
			
			myStmt.setString(1, thehotel.getRName());
			myStmt.setString(2, thehotel.getcuisine());
			myStmt.setString(3, thehotel.getaddr());
			myStmt.setInt(4, thehotel.getzip());
			myStmt.setDouble(5, thehotel.getrating());
			myStmt.setString(6, thehotel.getrange());
			myStmt.setInt(7, thehotel.getId());
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	

	
	/*Add restaurant method */
	public void add_rest(rest newrest) throws Exception {
		
		PreparedStatement myStmt = null;
		

		try {
			// prepare statement
			myStmt = myconn.prepareStatement("INSERT INTO restaurants "+ "(id, r_name, cuisine, addr, zip, rating,r_range)" + 
			" VALUES (?, ?, ?, ?, ?, ?,?)");
					
			
			// set parameters
			myStmt.setInt(1, newrest.getId());
			myStmt.setString(2, newrest.getRName());
			myStmt.setString(3, newrest.getcuisine());
			myStmt.setString(4, newrest.getaddr());
			myStmt.setInt(5, newrest.getzip());
			myStmt.setDouble(6, newrest.getrating());
			myStmt.setString(7, newrest.getrange());
			
			
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public static List<rest> getAllrest() throws Exception {
		List<rest> list = new ArrayList<rest>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myconn.createStatement();
			myRs = myStmt.executeQuery("select * from restaurants");
			
			while (myRs.next()) {
				rest tempr= convertRowTorest(myRs);
				list.add(tempr);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public static  List<rest> searchrestaurants(String zip, String cuisine) throws Exception {
		List<rest> list = new ArrayList<rest>();

		PreparedStatement myStmt = null ;
		ResultSet myRs= null ;

		try {
			
			
			
			myStmt = myconn.prepareStatement("Select * from restaurants where zip = ? and cuisine = ?");
			
			myStmt.setString(1, zip);
			switch (cuisine)
			{
					case "Indian":
									myStmt.setString(2, "Indian");
									break;
									
					case "Korean":
									myStmt.setString(2, "Korean");
									break;
									
					case "Thai":
									myStmt.setString(2, "Thai");
									break;
									
					case "Italian":
									myStmt.setString(2, "Italian");
									break;
									
					case "Swiss":
									myStmt.setString(2, "Swiss");
									break;
					
					case "Japanese":
									myStmt.setString(2, "Japanese");
									break;
									
					case "Indonesian":
									myStmt.setString(2, "Indonesian");
									break;
									
					case "American":
									myStmt.setString(2, "American");
									break;
									
											
			}
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				rest tempe = convertRowTorest(myRs);
				list.add(tempe);
			}
			
			return list;
		}
		
		finally {
			close(myStmt, myRs);
		}
	}
	
	private static rest convertRowTorest(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String name = myRs.getString("r_name");
		String cuisine = myRs.getString("cuisine");
		String addr = myRs.getString("addr");
		int zip = myRs.getInt("zip");
		Double rating = myRs.getDouble("rating");
		String range =myRs.getString("r_range");
		
		rest tempe1  = new rest(id, name, cuisine,addr, zip,rating,range);
		
		return tempe1;
	}

	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	
	
	public List<Reviews> getreview(int rid) throws Exception {
		List<Reviews> list = new ArrayList<Reviews>();
		
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myconn.prepareStatement("select  UserId,Reviewscol from reviews where RestaurantId = ?");
			
			
			myStmt.setInt(1, rid);
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				
				
				String UserId = myRs.getString("UserId");
				String  review = myRs.getString("Reviewscol");
				Reviews temp = new Reviews(rid,UserId,review);
								
				list.add(temp);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	




	public static void main(String[] args) throws Exception {
		
		restdao dao = new restdao();
		System.out.println(dao.searchrestaurants("98","Italian"));
		System.out.println(dao.getAllrest());

		

	}

	

}
