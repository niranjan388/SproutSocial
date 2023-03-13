package testngPractice;


import org.testng.annotations.Test;

public class Testngpractice1 extends TestngBaseClass
{
	
	
	@Test
	public void class1_Test1()
	{
	    System.out.println(Thread.currentThread().getId());
		System.out.println(" class1_Test  case 1 is passed");
  System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void class1_Test2()
	{
		System.out.println(Thread.currentThread().getId());
		System.out.println("class1_Test  case 1 is passed");
		
	}
	

}
