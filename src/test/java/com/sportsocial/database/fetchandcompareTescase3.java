package com.sportsocial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.mysql.cj.jdbc.Driver;

public class fetchandcompareTescase3 {

	public static void main(String[] args) throws SQLException 
	{
		String mobilename="rex 60";
		String  price="27860";
		String brand="MIo9";
		//boolean flag=false;

		ArrayList<String> arr1=new ArrayList<String>();
		//ArrayList<String> arr2=new ArrayList<String>();
		//ArrayList<String> arr3=new ArrayList<String>();
		Driver dbdriver=new Driver();

		DriverManager.registerDriver(dbdriver);

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Niranjan", "root", "root");
		
		Statement stment = con.createStatement();

		ResultSet res = stment.executeQuery("select * from mobiles;");

		while(res.next())
		{
		    arr1.add(res.getString("mobilename") +" || " + res.getString("price")+ " || " + res.getString("brand"));
			

		}
		if(arr1.contains(mobilename +" || "+ price + " || " + brand ))
		{
			System.out.println("data is present");
		}
		else
		{
			int result = stment.executeUpdate("insert into mobiles values('"+mobilename+"', '" + price+"','"+ brand+"');");

			if(result==1)
			{
				System.out.println("data base updated");

			} 
		}

		/*for (int i = 0; i < arr1.size(); i++)
		{
			if(arr1.get(i).equals(mobilename) && arr2.get(i).equals(price) && arr3.get(i).equals(brand))
			{
				flag=true;

			}

		}
		if(flag==false)
		{
			int result = stment.executeUpdate("insert into mobiles values('"+mobilename +"', '" + price+"','"+ brand+"');");

			if(result==1)
			{
				System.out.println("databaseupdated");

			} 
		}
			else
			{
				System.out.println("the data already exit");
			}*/
		


	}


}












