

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Student {
	



private int id;
private String fname;
private String lname;
private String birthdate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getBirthdate() {
	return birthdate;
}
public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}



public void addingStudent() throws Throwable {
	 // Creating the connection using Oracle DB
    // Note: url syntax is standard, so do grasp
    String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

    String user = "sa";
    String pass = "root";

    // Entering the data
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Student ID");
  id = scanner.nextInt();

    System.out.println("Enter Student first name ");
    fname = scanner.next();

    System.out.println("Enter Student last name ");
  lname = scanner.next();
    
   
    System.out.print("Enter your birthdate (YYYY-MM-DD): ");
   birthdate = scanner.next();


    // Inserting data using SQL query
    
    String sql = "insert into Students values(" + id
            + ",'" + fname + "','" + lname + "','" + birthdate + "')";


    // Connection class object
    Connection con = null;

    // Try block to check for exceptions
    try {

        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        // Registering drivers
        DriverManager.registerDriver(driver);

        // Reference to connection interface
        con = DriverManager.getConnection(url, user,
                pass);

        // Creating a statement
        Statement st = con.createStatement();

        // Executing query
        int m = st.executeUpdate(sql);
        if (m >=  1)
            System.out.println(
                    "inserted successfully : " + sql);
        else
            System.out.println("insertion failed");

        // Closing the connections
        con.close();
    }

    // Catch block to handle exceptions
    catch (Exception ex) {
        // Display message when exceptions occurs
        System.err.println(ex);
    }
}






public void listTop100() throws Throwable {
	 // Creating the connection using Oracle DB
  // Note: url syntax is standard, so do grasp
  String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

  String user = "sa";
  String pass = "root";

  // Entering the data
  Scanner scanner = new Scanner(System.in);

 

  String sql = "SELECT * FROM Students where id<100 ORDER BY id  ";


  // Connection class object
  Connection con = null;

  // Try block to check for exceptions
  try {

      Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      // Registering drivers
      DriverManager.registerDriver(driver);

      // Reference to connection interface
      con = DriverManager.getConnection(url, user,
              pass);

      // Creating a statement
      Statement st = con.createStatement();

      // Executing query
      ResultSet m = st.executeQuery(sql);
      // iterate through the java resultset
      while (m.next())
      {
        int id = m.getInt("id");
        String fname = m.getString("fname");
        String lname = m.getString("lname");
        Date birthdate = m.getDate("birthdate");
      
        
        // print the results
        System.out.format("%s, %s, %s, %s\n", id, fname, lname, birthdate);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }


      // Closing the connections
      con.close();
  }



public void listTop1000000() throws Throwable {
	 // Creating the connection using Oracle DB
  // Note: url syntax is standard, so do grasp
  String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

  String user = "sa";
  String pass = "root";

  // Entering the data
  Scanner scanner = new Scanner(System.in);

 

  String sql = "SELECT * FROM Students  where id<1000000 ORDER BY id ";


  // Connection class object
  Connection con = null;

  // Try block to check for exceptions
  try {

      Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      // Registering drivers
      DriverManager.registerDriver(driver);

      // Reference to connection interface
      con = DriverManager.getConnection(url, user,
              pass);

      // Creating a statement
      Statement st = con.createStatement();

      ResultSet m = st.executeQuery(sql);
      // iterate through the java resultset
      while (m.next())
      {
        int id = m.getInt("id");
        String fname = m.getString("fname");
        String lname = m.getString("lname");
        Date birthdate = m.getDate("birthdate");
      
        
        // print the results
        System.out.format("%s, %s, %s, %s\n", id, fname, lname, birthdate);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }

  // Catch block to handle exceptions

}

public void listTop100000() throws Throwable {
	 // Creating the connection using Oracle DB
  // Note: url syntax is standard, so do grasp
  String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

  String user = "sa";
  String pass = "root";

  // Entering the data
  Scanner scanner = new Scanner(System.in);

 

  String sql = "SELECT * FROM Students  where id<100000 ORDER BY id ";


  // Connection class object
  Connection con = null;

  // Try block to check for exceptions
  try {

      Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      // Registering drivers
      DriverManager.registerDriver(driver);

      // Reference to connection interface
      con = DriverManager.getConnection(url, user,
              pass);

      // Creating a statement
      Statement st = con.createStatement();

      // Executing query
      ResultSet m = st.executeQuery(sql);
      // iterate through the java resultset
      while (m.next())
      {
        int id = m.getInt("id");
        String fname = m.getString("fname");
        String lname = m.getString("lname");
        Date birthdate = m.getDate("birthdate");
      
        
        // print the results
        System.out.format("%s, %s, %s, %s\n", id, fname, lname, birthdate);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
}
}





