package testngPractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sportsocial.genaricUtility.NewBaseclass;

public class Extentpractice  extends NewBaseclass
{
	@Test
	public void test1()
	{
		System.out.println("TestCase Passes");
		test.log(Status.INFO, "Test case executed sucessfully");
	}

}
