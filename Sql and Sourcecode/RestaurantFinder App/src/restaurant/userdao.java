package restaurant;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.*;
import java.io.*;
import java.sql.*;


public class userdao {

	private static Connection myconn;
	
	public userdao() throws Exception {

		// connect to database
			myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_finder_database", "root","1234");
				System.out.println("DB connection successful for Userdao : ");
		
		
		}
	
	private static Users convertRowToUser(ResultSet myRs) throws SQLException {
		
		String uid = myRs.getString("userid");
		String lastName = myRs.getString("lastname");
		String firstName = myRs.getString("firstname");
		String email = myRs.getString("email");
		boolean admin = myRs.getBoolean("is_admin");
		
		Users tempUser = new Users(uid, lastName, firstName, email, admin);
		
		return tempUser;
	}
	
	public static List<Users> getUsers(boolean admin, String userId) throws Exception {
		List<Users> list = new ArrayList<Users>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myconn.createStatement();
			
			String sql = null;
			
			if (admin) {
				// get all users
				sql = "select * from users order by lastname";
			}
			else {
				// only the current user
				sql = "select * from users where id=" + userId + " order by lastname";
			}
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				Users tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
			
	
		
	/**
	 * Return true if user's password is authenticated.
	 * 
	 * @param theUser
	 * @return
	 */
	public boolean authenticate(Users theUser) throws Exception {
		
		boolean result = false;
		System.out.println("Password Check 2" );
		String plainTextPassword = theUser.getPassword();
		
		System.out.println("Password entered " );
		// get the password from database for this user
		String id =theUser.getId();
		String PasswordFromDatabase = getPassword(id);
		System.out.println("matches to Password from database" );
		
		// compare the passwords
		result = (plainTextPassword).equals(PasswordFromDatabase);
		
		return result;
	}

	private String getPassword(String id) throws Exception {
		
		String ePassword = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		System.out.println("Password Check 5" );
		
		try {
				myStmt = myconn.prepareStatement("Select password from users where userid = ? ");
				
				myStmt.setString(1,id);
				System.out.println("Password Check 5.1" );
				
				System.out.println("Password Check 5.2" );
						
				myRs = myStmt.executeQuery();
								
				System.out.println("Password Check 5.3" );
				
				if (myRs.next()) {
					ePassword = myRs.getString("password");
					System.out.println("Password Check 5.1.2" );
				}
				else {
					throw new Exception("User id not found: " + id);
				}

				System.out.println("Password Check 6" );
				return ePassword;		
			}
			finally {
				DAOUtils.close(myStmt, myRs);
			}		
		
	}
	
public String getadmin(String id) throws Exception {
		
		String admin1 = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		System.out.println("Admin check" );
		
		try {
				myStmt = myconn.prepareStatement("Select is_admin from users where userid = ? ");
				
				myStmt.setString(1,id);
										
				myRs = myStmt.executeQuery();
								
				System.out.println("Admin check 2" );
				
				if (myRs.next()) {
					admin1 = myRs.getString("is_admin");
					System.out.println("Admin check 3" );
				}
				else {
					throw new Exception("User id not found: " + id);
				}

				System.out.println("Admin Check 4" );
				return admin1;		
			}
			finally {
				DAOUtils.close(myStmt, myRs);
			}		
		
	}


	public void changePassword(Users user) throws Exception {

		// get plain text password
		String plainTextPassword = user.getPassword();
		
		
		// update the password in the database
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myconn.prepareStatement("update users"
					+ " set password=?"
					+ " where userid=?");
			
			// set params
			myStmt.setString(1, plainTextPassword);
			myStmt.setString(2, user.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		

	}	
}



