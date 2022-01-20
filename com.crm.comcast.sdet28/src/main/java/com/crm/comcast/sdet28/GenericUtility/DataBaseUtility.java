package com.crm.comcast.sdet28.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.NonRegisteringDriver;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */

public class DataBaseUtility {
	Connection connection= null;
	/**
	 * METHOD WILL DO THE CONNECTION TO DATABASE
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable  {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
	}
	/**
	 * THIS METHOD WILL CLOSE THE DATABASE CONNECTION
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		connection.close();
	}
	/**
	 * THIS METHOD WILL FETCH ALL THE DATA FROM DATABSE
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * THIS METHOD WILL UPDATE THE DATA IN DATABASE AND IT WILL VERIFY
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String querry) throws Throwable {
		boolean flag = false;
		int result = connection.createStatement().executeUpdate(querry);
		if (result==1) {
			System.out.println("data is updated in database");
			flag=true;
		}else {
			System.out.println("data is not updated in database");
		}
		return flag;
		
	}
	/**
	 * THIS METHOD WILL VERIFY THE GIVEN DATA IS PRESNT IN THE DATABASE OR NOT
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
		public String getTheData(String querry,int columnNumber,String expectedData) throws Throwable {
			boolean flag = false;
			String actualData = null;
			ResultSet result = connection.createStatement().executeQuery(querry);
			while(result.next()) {
			String data = result.getString(columnNumber);
			if(data.equals(expectedData));
			actualData= data;
			flag=true;
			break;
		}
		

	if(flag==true) {
		System.out.println("Data is present in the database");
		return actualData;
	}else {
		System.out.println("Data is not present in database");
		return actualData;
	}
		
}
}	
		
		
		
	

