package testngPractice;

import org.testng.annotations.Test;

public class Testngpractice3_1 extends TestngBaseClass
{
	@Test
	public void class3_Test1()
	{
		System.out.println(Thread.currentThread().getId());
		System.out.println(" class3_Test  case 1 is passed");
		
	}
	
	@Test
	public void class3_Test2()
	{
		System.out.println(Thread.currentThread().getId());
		System.out.println("class3_Test  case 1 is passed");
		
	}

}
