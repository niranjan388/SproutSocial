package com.sportsocial.database;



import org.testng.annotations.Test;

import com.sportsocial.genaricUtility.DataBaseutil;
import com.sportsocial.genaricUtility.TestngBaseClass;

public class readdatafromdbtestcase1 extends TestngBaseClass
{
	DataBaseutil database=new DataBaseutil();

	@Test
	public  void ReadDatafromdatabase()  
	{

		database.connectToDataBase("jdbc:mysql://localhost:3306/Niranjan", "root", "root");
		database.executeQuerytoread("select*from login_Creditinal");
		database.readDatafromDB("username");
		database.readDatafromDB("password");
		database.disconnetFromDataBase();  
    
		
	}

}
