package Selfpractice;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.cj.jdbc.Driver;
	public class ExecuteDeleteQuerryUsingJDBC {
	

		public static void main(String[] args) throws SQLException {
		
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("delete from student where sno=104;");//practice
			 if	(result==1)	{
				 System.out.println("data has been update");
			 }
			 else  {
				 System.out.println("data has not been updated");
			 }
				 
					
			
		}

	}
