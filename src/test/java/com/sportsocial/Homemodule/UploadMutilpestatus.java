package com.sportsocial.Homemodule;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sportsocial.POM.Uploadstatus;
import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.PropertieFileKeys;
import com.sportsocial.genaricUtility.TestngBaseClass;

public class UploadMutilpestatus extends TestngBaseClass
{
	 
	 @Test(dataProvider = "getdata")
	public  void UploadMutilpestatu(String ExceptedText,String Exceptedphoto,String Comment)
	{
		
		String email2=excelfile.getExcelData(FilePaths.CREATE_ACCOUNT_SHEET, 3, 9);
		String password2=excelfile.getExcelData(FilePaths.CREATE_ACCOUNT_SHEET, 3, 10);
		
	
		String Emailid=propertyfile.readValuefromPropertyfile(PropertieFileKeys.EMAIL.convertToString());
		String Password=propertyfile.readValuefromPropertyfile(PropertieFileKeys.PASSWORD.convertToString());
		String ExceptedstatusText=ExceptedText+javautil.getradomNo(100); 
		  String Exceptedstatusphoto=Exceptedphoto; 
		  
		commonpage.clickonlogoutButton();
		 
		  commonpage.clickonSigninButton();
		  loginaction.logintoapplication(Emailid, Password);
          Uploadstatus uploadstatus=new Uploadstatus(driver);
		   uploadstatus.shareThepost(ExceptedstatusText, Exceptedstatusphoto);
		  commonpage.clickonlogoutButton(); 
		  commonpage.clickonSigninButton();
		  loginaction.logintoapplication(email2, password2);
		  uploadstatus.verifythepost(ExceptedstatusText);
		  uploadstatus.commenttopost(ExceptedstatusText, Exceptedstatusphoto, Comment);
		 
		
		
	}

	 @DataProvider
	 public String[][] getdata()
	 {
		 String[][] arr=excelfile.getDataforDataprovider(FilePaths.HOME_MODULE_SHEET);
				 return arr;
		 
		 
	 }

}
