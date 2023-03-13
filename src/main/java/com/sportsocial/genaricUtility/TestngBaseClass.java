package com.sportsocial.genaricUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;

import com.sportsocial.POM.CommonPage;
import com.sportsocial.POM.LoginAction;
/**
 * This Class consist of @Beforeclass @BeforeMethod @After class @AfterMethod
 * Created Global variables  for POM Classes
 * Created Objects for genaricUtility
 * @author Admin
 *
 */
public class TestngBaseClass
{

	protected   Propertiefileutil propertyfile=new Propertiefileutil();
	protected	ExcelUtil excelfile=new ExcelUtil();
	protected	WebDriverutil webdriverutil=new WebDriverutil();
	protected	JavaUtil javautil=new JavaUtil();
	
	protected WebDriver driver;
   static  WebDriver edriver;
	protected LoginAction  loginaction;
	protected CommonPage commonpage;
	
	/**
	 * This Method is used to open the application
	 * Open the properties Files 
	 * Open the Excel Files
	 * 
	 */
		@BeforeClass
	public void OpenApllication()
	{
         
		propertyfile.openThePropertyfile(FilePaths.PROPERTY_FILEPATH);
		String browser = propertyfile.readValuefromPropertyfile(PropertieFileKeys.BROWSER.convertToString());
		excelfile.openExcelFile(FilePaths.EXCEL_FILEPATH);
		driver = webdriverutil.openBrowser(browser,propertyfile,javautil);	
	    ThreadLocalclass.setwebdriverutil(webdriverutil);
	
	}
		

 /**
  * This Method is used to Login to The Application
  * Fetching the Data from Property File
  */
	@BeforeMethod
	public void LogintoApp()
	{
		String email=propertyfile.readValuefromPropertyfile(PropertieFileKeys.EMAIL.convertToString());
		String password=propertyfile.readValuefromPropertyfile(PropertieFileKeys.PASSWORD.convertToString());
		
		 commonpage=new CommonPage(driver); 
		 loginaction=new LoginAction(driver);
		 commonpage.clickonSigninButton();
		 loginaction.logintoapplication(email, password);
		 
		 
		 
	}

	/**
	 * This Method is used to Logout from the application
	 */
	@AfterMethod
	public void LogoutAppl()
	{   
		
		
		commonpage.clickonlogoutButton();
	}
   
	/**
	 * This Method is used to Close the Apllication and close the Property file
	 * Close the Excel File
	 */
	
	@AfterClass
	public void closetheApplication()
	{
		excelfile.closeExcelfile();
		propertyfile.closethePropertyfile();
		webdriverutil.closeBrowser();
	}

}
