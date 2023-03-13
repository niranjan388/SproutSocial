package com.sportsocial.database;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class propertyfileTestcase4 {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		
		Properties pr=new Properties();
		pr.load(fis);
		
		System.out.println(pr.get("username"));
	
	
		 
		

	}

}
