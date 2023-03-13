package com.sportsocial.adminModule;


import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.sportsocial.POM.Uploadstatus;

import com.sportsocial.genaricUtility.FilePaths;

import com.sportsocial.genaricUtility.TestngBaseClass;
@Listeners(com.sportsocial.genaricUtility.ListernersClass.class)
public class VerifythestatusanddelectTest2 extends TestngBaseClass
{
	
	
 @Test
	public  void Verifythestatusandselect() 
	{
		

		String ExceptedstatusText=excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 1, 0)+javautil.getradomNo(100);
	
		String Exceptedstatusphoto=excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 1, 1);
		

		Uploadstatus uploadstatus=new Uploadstatus(driver);
	    commonpage.clickonuserModule();
		uploadstatus.shareThepost(ExceptedstatusText, Exceptedstatusphoto);
		uploadstatus.verifythepost(ExceptedstatusText); 
		uploadstatus.deletethepost(ExceptedstatusText);
		

	}

}
