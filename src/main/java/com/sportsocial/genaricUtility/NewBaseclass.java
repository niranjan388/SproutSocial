package com.sportsocial.genaricUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sportsocial.POM.CommonPage;
import com.sportsocial.POM.LoginAction;

public class NewBaseclass 
{

	protected   Propertiefileutil propertyfile=new Propertiefileutil();
	protected	ExcelUtil excelfile=new ExcelUtil();
	protected	WebDriverutil webdriverutil=new WebDriverutil();
	protected	JavaUtil javautil=new JavaUtil();
	
	protected WebDriver driver;
   static  WebDriver edriver;
	protected LoginAction  loginaction;
	protected CommonPage commonpage;
	protected ExtentReports report;
	protected ExtentTest test ;

	@BeforeTest
	public void Extentreport()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtendRepots/report.html");
		  spark.config().setDocumentTitle("Extent Html Report");
		  spark.config().setReportName("Test Case Exection Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  
		   report=new ExtentReports();
		   report.attachReporter(spark);
	}
	
	@BeforeClass
	public void OpenApllication()
	{
         
		propertyfile.openThePropertyfile(FilePaths.PROPERTY_FILEPATH);
		String browser = propertyfile.readValuefromPropertyfile(PropertieFileKeys.BROWSER.convertToString());
		excelfile.openExcelFile(FilePaths.EXCEL_FILEPATH);
	   
		driver = webdriverutil.openBrowser(browser,propertyfile,javautil);	
	    ThreadLocalclass.setwebdriverutil(webdriverutil);
	    
		edriver=driver;
	}
 /**
  * This Method is used to Login to The Application
  * Fetching the Data from Property File
  */
	@BeforeMethod
	public void LogintoApp(ITestResult result)
	{
		String email=propertyfile.readValuefromPropertyfile(PropertieFileKeys.EMAIL.convertToString());
		String password=propertyfile.readValuefromPropertyfile(PropertieFileKeys.PASSWORD.convertToString());
		test=report.createTest(result.getMethod().getMethodName());
		 commonpage=new CommonPage(driver); 
		 loginaction=new LoginAction(driver);
		 commonpage.clickonSigninButton();
		 test.log(Status.INFO, "Login into application");
		 loginaction.logintoapplication(email, password);
		 
		 
		 
		 
		 
	}

	/**
	 * This Method is used to Logout from the application
	 */
	@AfterMethod
	public void LogoutAppl()
	{   
		
		 test.log(Status.INFO, "Logout  application");
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
	
	@AfterTest
	public void  endExtentreport()
	{
		report.flush();
		
	}
	
	
}
