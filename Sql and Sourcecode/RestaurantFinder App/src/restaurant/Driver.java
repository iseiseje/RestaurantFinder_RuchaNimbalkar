package restaurant;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection myconn3 = null;
		PreparedStatement myStmt3 = null;
		ResultSet myRs3 = null;
		

		try{
			
			//1. Get a connection to database
			
				Connection Myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_finder_database", "root","1234");
								
			//2. Create Statement
				
				Statement Mystat = Myconn.createStatement();
							
			//3. Execute a sql query
				
				ResultSet Myrs = Mystat.executeQuery("Select * from restaurants");
				
			//4. Process the result set
				while(Myrs.next()){
					
					System.out.println(Myrs.getString("r_name")+ ' ' + Myrs.getString("cuisine"));
				}	
			//5. Inserting Data into database
					Connection Myconn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_finder_database", "root","1234");
					
					Statement Mystat2 = Myconn2.createStatement();
					
				/*	String sql1= "INSERT INTO restaurants "+ "(idrestaurants, name, cuisine, hours, address, zip, rating)" + " VALUES ('984067', 'Gateway To India', 'Indian', ' 11:00 AM – 3:00 PM, 5:00 – 9:00 PM', '2603 6th Ave, Tacoma, WA', '98406', '4.2')";
					
					Mystat2.executeUpdate(sql1);
					
					System.out.println("Update");
					
			*/

					String sql2= "Update restaurants"+ " set rating = '4.3' " + " where idrestaurants=984067";
					
					Mystat2.executeUpdate(sql2);
					
					System.out.println("Update Complete");
					
					
					
					
					
						// 1. Get a connection to database
						Connection myconn31 = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_finder_database", "root","1234");
						
						// 2. Prepare statement
						myStmt3 = myconn31.prepareStatement("select * from restaurants where rating > ? and cuisine=?");
						
						// 3. Set the parameters
						myStmt3.setDouble(1,2.2);
						myStmt3.setString(2, "Italian");
						
						// 4. Execute SQL query
						myRs3 = myStmt3.executeQuery();
						
						// 5. Display the result set
						display(myRs3);
					
						//
						// Reuse the prepared statement: 
						//

						System.out.println("\n\nReuse the prepared statement:  rating > 3.1,  cuisine = Indian");
						
						// 6. Set the parameters
						myStmt3.setDouble(1, 3.1);
						myStmt3.setString(2, "Indian");
						
						// 7. Execute SQL query
						myRs3 = myStmt3.executeQuery();
						
						// 8. Display the result set
						display(myRs3);


					}
					catch (Exception exc) {
						exc.printStackTrace();
					}
		
					finally {
							
								if (myRs3 != null) {
									try {
										myRs3.close();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
						
								if (myStmt3 != null) {
									try {
										myStmt3.close();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
						
								if (myconn3 != null) {
									try {
										myconn3.close();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

						}
		
				
	
			}
	
	
	private static void display(ResultSet myRs3) throws SQLException {
		while (myRs3.next()) {
			String name = myRs3.getString("name");
			String address = myRs3.getString("address");
			Double rating = myRs3.getDouble("rating");
			String cuisine = myRs3.getString("cuisine");
			
			System.out.printf("%s, %s, %.1f, %s\n",name, address, rating, cuisine);
		}
	}

	
	
	

}		


