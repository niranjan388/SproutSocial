package com.sportsocial.UserModule;


import org.testng.annotations.Test;


import com.sportsocial.POM.Uploadstatus;

import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.TestngBaseClass;


public class PostthestatusTestcase1 extends TestngBaseClass
{
	
  @Test
	public  void Poststatus()
  {

		String ExceptedstatusText = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 1);
		String Exceptedstatusphoto = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 2);
		Uploadstatus uploadstatus = new Uploadstatus(driver);
	
		commonpage.clickonuserModule();
		uploadstatus.shareThepost(ExceptedstatusText, Exceptedstatusphoto);

	}

}
