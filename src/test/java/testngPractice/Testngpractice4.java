package testngPractice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testngpractice4 

{
	
	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Before class 4");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class 4");
	}
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite 4 ");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite 4");
	}
	
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Before Method 4");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method 4");
	}
	
	

	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test 4 ");
	}
	
	@org.testng.annotations.AfterTest
	public void afterTest()
	{
		System.out.println("After Test 4 ");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Test  case 4  is passed");
	}
	

}
