package com.sportsocial.signinModule;



import org.testng.ITestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sportsocial.POM.CommonPage;
import com.sportsocial.POM.LoginAction;
import com.sportsocial.genaricUtility.ExcelUtil;
import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.TestngBaseClass;


public class SiginwithMutilpleData extends TestngBaseClass
{
	@Test(dataProvider ="getData")
	public void sigin(String username, String Password ,String Mobile)
	
	{
		
		  commonpage.clickonSigninButton();
		 
		  loginaction.logintoapplication(username, Password); 
		  String Title =driver.getTitle(); org.testng.Assert.assertEquals(Title,
		  "Welcome To Biobook - Sign up, Log in, Post");
		 commonpage.clickonlogoutButton();
		

	}

@DataProvider
public String[][] getData()
{
	
	String[][] arr = excelfile.getDataforDataprovider(FilePaths.CRENDENTIALS_SHEET);
	
	return arr;
	
}
}
