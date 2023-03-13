package com.sportsocial.genaricUtility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadLocalclass
{
	public static ThreadLocal<WebDriverutil> webdriverutil=new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
public static WebDriverutil   getwebdriverutil()
{
	return webdriverutil.get();
}


public static void setwebdriverutil(WebDriverutil swebdriverutil)
{
	 webdriverutil.set(swebdriverutil);
	
}


public static ExtentTest   gettest()
{
	return test.get();
}


public static void settest(ExtentTest stest)
{
	test.set(stest);
	
}
}
