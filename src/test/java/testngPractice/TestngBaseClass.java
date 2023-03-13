package testngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBaseClass 
{
	public WebDriver driver;
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@Parameters ("Browser")
	@BeforeClass
	public void Beforeclass(String Browser)
	{
		
		if(Browser.equals("chrome"))
		{   
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("chrome");
		}
		else if(Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("firefox");
		}
		else
		{
			System.out.println("Please enter the Browser");
		}
		System.out.println("Lanched the browser");
		
		
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterclass()
	{ 
		driver.quit();
		System.out.println("After class");
	}
	
	
	@org.testng.annotations.AfterTest
	public void afterTest()
	{
		
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}
	
	
	
	
	
	
	

	
	
	
	

	

}
