package com.sportsocial.database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class writethedatatodbTestcase2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Niranjan", "root", "root");
		Statement statement = connection.createStatement();
		
		 int result = statement.executeUpdate("insert into login_Creditinal values('abc12','Nq123');");
		
		if(result==1)
		{
			System.out.println("databaseupdated");
			
		}
      connection.close();
	}

}
