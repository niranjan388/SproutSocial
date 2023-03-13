package testngPractice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testngpractice3
{
	
	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Before class 3");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class 3");
	}
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite 3");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite 3");
	}
	
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Before Method 3");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method 3");
	}
	
	

	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test 3");
	}
	
	@org.testng.annotations.AfterTest
	public void afterTest()
	{
		System.out.println("After Test 3");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Test  case 3 is passed");
	}
	
	

}
