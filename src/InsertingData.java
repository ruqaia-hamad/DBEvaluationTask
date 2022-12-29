import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertingData {

	public long addFakeStudents(int number) {
		
		
		System.out.println("************************************");
		System.out.println("          RAMDOM USERS              ");
		System.out.println("************************************");
		long startTime = System.currentTimeMillis();

		Connection conn = null;
		PreparedStatement stmt = null;
		Random rand = new Random();

		try {
			// Step 1: Load the JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Step 2: Establish the connection to the database
			String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";
			String username = "sa";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);

			// Step 3: Create the SQL insert statement
			String sql = "INSERT INTO Students (id, fname, lname, birthdate) VALUES (?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			// Step 4: Bind the values to the parameters
			for (int i = 0; i < number; i++) {
				int id = (int) (i + Math.random());
				String fname = "YourName" + i;
				String lname = "yourLastName" + i;
				// Date birthdate = new Date();

				stmt.setInt(1, id);
				stmt.setString(2, fname);
				stmt.setString(3, lname);
				stmt.setDate(4, new Date(startTime));

				// Step 5: Execute the insert statement
				stmt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Step 6: Close the resources
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	
	}
	
	

	public long addFakeSubjects(int number) {
		System.out.println("\n");
		System.out.println("\n");
	System.out.println("************************************");
	System.out.println("          RAMDOM SUBJECT            ");
	System.out.println("************************************");
		long startTime = System.currentTimeMillis();

		Connection conn = null;
		PreparedStatement stmt = null;
		Random rand = new Random();

		try {
			// Step 1: Load the JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Step 2: Establish the connection to the database
			String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";
			String username = "sa";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);

			// Step 3: Create the SQL insert statement
			String sql = "INSERT INTO Subjects (id, title, description) VALUES (?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			// Step 4: Bind the values to the parameters
			for (int i = 0; i < number; i++) {
				int id = (int) (i + Math.random());
				String title = "fakeproduct" + i;
				String decription = "very long desc for a product" + i;
				stmt.setInt(1, id);
				stmt.setString(2,  title);
				stmt.setString(3, decription);
			

				stmt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
