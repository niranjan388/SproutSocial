package com.sportsocial.Homemodule;


import org.testng.annotations.Test;


import com.sportsocial.POM.Uploadstatus;

import com.sportsocial.genaricUtility.FilePaths;

import com.sportsocial.genaricUtility.TestngBaseClass;

public class UpdatestatusTestcase_2 extends TestngBaseClass
{
	Uploadstatus uploadstatus;
	String ExceptedstatusText;
	
	 @Test(groups = "smoke")
	public void Updatestatus() 
	{

		 ExceptedstatusText=excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 1);
		String Exceptedstatusphoto=excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 2);
	
		 uploadstatus=new Uploadstatus(driver);
		
		uploadstatus.shareThepost(ExceptedstatusText, Exceptedstatusphoto);
		  
	}
		 @Test(groups = "smoke" ,dependsOnMethods = "Updatestatus")
			public void Verifythestatus()
			{

				
				
				uploadstatus.verifythepost(ExceptedstatusText);     
			

	}

}
