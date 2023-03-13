package com.sportsocial.genaricUtility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersClass  implements ITestListener
{
	ExtentReports report;
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) 
	{
	   test=report.createTest(result.getMethod().getMethodName());
	   
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Success");
		test.log(Status.PASS, result.getName());
		 ThreadLocalclass.settest(test);
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		
		test.log(Status.INFO, "Test case is failed"+""+result.getName());
	 String testcasename = result.getName();
	 String screen = ThreadLocalclass.getwebdriverutil().takescreenshot(testcasename);
     test.addScreenCaptureFromPath(screen);
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.skip(result.getMethod().getMethodName());
		test.log(Status.SKIP ,result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtendRepots/report.html");
		  spark.config().setDocumentTitle("Extent Html Report");
		  spark.config().setReportName("Test Case Exection Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  
		   report=new ExtentReports();
		   report.attachReporter(spark);
		
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
		
	}

}
