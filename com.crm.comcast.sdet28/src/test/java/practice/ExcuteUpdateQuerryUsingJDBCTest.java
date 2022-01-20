package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExcuteUpdateQuerryUsingJDBCTest {

	public static void main(String[] args) throws SQLException {
		
		//Register the driverS
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		
		 //Issue the create statement
		Statement statement = connection.createStatement();
		
		  //Execute the query
	  int result = statement.executeUpdate("insert into student values(104, 'Rahul' 'MYSQL');");
	  if(result==1)
	  {
	  System.out.println("Date base has been updated");
	  }
	  else
	  {
		  System.out.println("Date base has not been updated");
	  }
		
	//Close the data base connection
		connection.close();

	}

}
