package com.sportsocial.genaricUtility;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.mysql.cj.jdbc.Driver;
/**
 * This Class   will connect to DataBase
 * We can read the data from DataBase
 * We can modify the data into DataBase 
 * @author Admin
 *
 */
public class DataBaseutil
{
	Driver dbdriver;
	String databasename ="mobiles";
	java.sql.Connection connection;
	Statement statement;
	ResultSet Result;
	int ModifyResult;
	/**
	 * This Method will connect to the database
	 */
	public void connectToDataBase(String databaseurl,String username,String password)
	{
		try {
			 dbdriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	  connection = DriverManager.getConnection(databaseurl,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	/**
	 * This method will   Execute the  Query
	 * @param Query
	 * @param coloumName
	 */
	public void executeQuerytoread(String Query)
	{
		try {
			 Result = statement.executeQuery(Query);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * This Method will give data based on the coloumn name 
	 * @param coloumnName
	 */
	public void readDatafromDB(String coloumnName)
	{
		try {
			if(Result.next())
			{
				System.out.println(Result.getString(coloumnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	/**
	 * This MEthod will write the data into DataBase by Executing Query
	 * @param Query
	 */
		public void WriteDatatoDataBase(String Query)
		{
			try {
				ModifyResult = statement.executeUpdate(Query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ModifyResult>=1)
			{
				System.out.println("DataBase Updated");
			}
			
		}
		public void disconnetFromDataBase()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
