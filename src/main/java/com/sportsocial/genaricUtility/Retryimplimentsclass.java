package com.sportsocial.genaricUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryimplimentsclass  implements IRetryAnalyzer

{

	@Override
	public boolean retry(ITestResult result) 
	{
		int count=0;
		int retryLimit=4;
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
