import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable, IllegalAccessException, ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		System.out.println("\t\t++++++++++++++++++++++++++++++++++");
		System.out.println("\t\t+ WELCOME TO THE SYSTEM          +");
		System.out.println("\t\t++++++++++++++++++++++++++++++++++\n");
		System.out.println("Please Choose Number From Menu:       \n");
		System.out.println(" =====================================");
		System.out.println("|  [1] Create  Student table          |");
		System.out.println("|  [2] Create  Subject table          |");
		System.out.println("|  [3] Adding random users & subjects |");
		System.out.println("|  [4] Show top 50 subjects           |");
		System.out.println("|  [5] Show top 100 students          |");
		System.out.println("|  [6] Add new Student                |");
		System.out.println("|  [7] Add new Subject                |");
		System.out.println("|  [8] Show top 100000                |");
		System.out.println("|  [9] Show top 10000                 |");
		System.out.println("|  [10]EXIT                           |");
		System.out.println(" =====================================");
		Integer num=sc.nextInt();
		boolean isExitMenu = true;
	
		switch(num) {
		case 1:
			DatabaseConnectivity dbcon=new DatabaseConnectivity();
	        dbcon.cratingTable();
			break;
	
		case 2:
			DatabaseConnectivity dbcon2=new DatabaseConnectivity();
			dbcon2.cratingTableSubject();	
			break;
			
			

		case 3:
	
		InsertingData insertdata=new InsertingData();
		insertdata.addFakeStudents(100);
        insertdata.addFakeSubjects(100);
			break;
			
		case 4:
			Subject subjects=new Subject();
			subjects.listTopTen();
				break;
				
		case 5:
			Student student22=new Student();
			student22.listTop100();
			break;
		case 6:
			Student student=new Student();
			student.addingStudent();
			break;
		case 7:
			Subject subject=new Subject();
			subject.addingSubject();
			break;
		case 8:
			Student stud=new Student();
			stud.listTop1000000();
			break;
		case 9:
			Student studn=new Student();
			studn.listTop100000();
			break;
		case 10:
			System.out.println("THANK YOU");
			isExitMenu = false;
			break;


	
		}
		
	}

}
