import java.sql.*;

import java.util.*;

public class DatabaseConnectivity {

	 public static void cratingTable(){

	   
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

	      
	        String user = "sa";
	        String pass = "root";

	        
	        String sql = "CREATE TABLE Students (id INT, fname VARCHAR(8), lname VARCHAR(8), birthdate DATE)";

	   
	        Connection con = null;

	        // Try block to check for exceptions
	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

	            DriverManager.registerDriver(driver);

	            con = DriverManager.getConnection(url, user,
	                    pass);

	            Statement st = con.createStatement();

	       
	            int m = st.executeUpdate(sql);
	            if (m > 0)
	                System.out.println(
	                        "Created successfully : " + sql);
	            else
	                System.out.println("creating table failed");

	            con.close();
	        }

	        // Catch block to handle exceptions
	        catch (Exception ex) {
	            // Display message when exceptions occurs
	            System.err.println(ex);
	        }
	    }
	 
	 public static void cratingTableSubject(){

		   
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

	      
	        String user = "sa";
	        String pass = "root";
	        
	        String sql = "CREATE TABLE Subjects(id INT, title VARCHAR(8), description VARCHAR(250))";

	        Connection con = null;

	        // Try block to check for exceptions
	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            // Registering drivers
	            DriverManager.registerDriver(driver);

	            // Reference to connection interface
	            con = DriverManager.getConnection(url, user,
	                    pass);

	            Statement st = con.createStatement();

	            // Executing query
	            int m = st.executeUpdate(sql);
	            if (m >  0)
	                System.out.println(
	                        "Created successfully : " + sql);
	            else
	                System.out.println("creating table failed");

	            // Closing the connections
	            con.close();
	        }


	        catch (Exception ex) {
	        
	            System.err.println(ex);
	        }
	    }
	}




