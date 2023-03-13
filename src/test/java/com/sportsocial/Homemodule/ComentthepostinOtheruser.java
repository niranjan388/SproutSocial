package com.sportsocial.Homemodule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.sportsocial.POM.Uploadstatus;
import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.TestngBaseClass;

@Listeners(com.sportsocial.genaricUtility.ListernersClass.class)
public class ComentthepostinOtheruser extends TestngBaseClass {

	Uploadstatus uploadstatus;
	String ExceptedstatusText;
	String Exceptedstatusphoto;
	

	@Test(priority = 1 ) // retryAnalyzer = com.sportsocial.genaricUtility.Retryimplimentsclass.class
	public void updatethepost() {
		uploadstatus = new Uploadstatus(driver);
		ExceptedstatusText = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 0) + javautil.getradomNo(100);
		Exceptedstatusphoto = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 1);

		uploadstatus.shareThepost(ExceptedstatusText, Exceptedstatusphoto);

	}

	@Test(priority = 2)
	public void commentforpostbyothers() {
		String email2 = excelfile.getExcelData(FilePaths.CREATE_ACCOUNT_SHEET, 3, 9);

		String password2 = excelfile.getExcelData(FilePaths.CREATE_ACCOUNT_SHEET, 3, 10);

		String commentforpost = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 3);
		commonpage.clickonlogoutButton();

		commonpage.clickonSigninButton();
		loginaction.logintoapplication(email2, password2);
		uploadstatus.commenttopost(ExceptedstatusText, Exceptedstatusphoto, commentforpost);
		

	}

}
