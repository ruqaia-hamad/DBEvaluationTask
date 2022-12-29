import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;


public class Subject {
int id;
String title;
String description;


public void addingSubject() throws Throwable {
	 // Creating the connection using Oracle DB
   // Note: url syntax is standard, so do grasp
   String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

   String user = "sa";
   String pass = "root";

   // Entering the data
   Scanner scanner = new Scanner(System.in);

   System.out.println("Enter Subject ID");
 id= scanner.nextInt();

   System.out.println("Enter Subject title ");
   title= scanner.next();

   System.out.println("Enter Ssubject description ");
  description = scanner.next();



   // Inserting data using SQL query
   
   String sql = "insert into Students values(" + id
           + ",'" + title + "','" + description  + "')";


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

public void listTopTen() throws Throwable {
	
  String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

  String user = "sa";
  String pass = "root";

  // Entering the data
  Scanner scanner = new Scanner(System.in);

 

  String sql = "SELECT * FROM Subjects where id<51 ORDER BY id ";


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
        String title = m.getString("title");
        String description = m.getString("description");
      
      
        
        // print the results
        System.out.format("%s, %s,  %s\n", id, title,description);
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





