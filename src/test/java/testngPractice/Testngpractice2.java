package testngPractice;

import org.testng.annotations.Test;

public class Testngpractice2 extends TestngBaseClass
{
	@Test
	public void class2_Test1()
	{
		System.out.println(Thread.currentThread().getId());
		System.out.println(" class2_Test  case 1 is passed");
		
	}
	
	@Test
	public void class2_Test2()
	{
		System.out.println(Thread.currentThread().getId());
		System.out.println("class2_Test  case 1 is passed");
		
	}

}
