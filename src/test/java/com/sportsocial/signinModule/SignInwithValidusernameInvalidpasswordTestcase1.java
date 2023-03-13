package com.sportsocial.signinModule;

import com.sportsocial.POM.CommonPage;
import com.sportsocial.POM.LoginAction;

import com.sportsocial.genaricUtility.PropertieFileKeys;
import com.sportsocial.genaricUtility.TestngBaseClass;

public class SignInwithValidusernameInvalidpasswordTestcase1 extends TestngBaseClass
 {
 
	public void main()
	{
		
		
		String Emailid=propertyfile.readValuefromPropertyfile(PropertieFileKeys.EMAIL.convertToString());
		String Password=propertyfile.readValuefromPropertyfile(PropertieFileKeys.PASSWORD.convertToString());
		
		LoginAction login=new LoginAction(driver);
		CommonPage commonpage=new CommonPage(driver);
		
		commonpage.clickonSigninButton();
		login.logintoapplication(Emailid, Password);
		
		try {
		System.out.println(webdriverutil.SwitchToAlert().getText());
		webdriverutil.SwitchToAlert().accept();
		}catch (Exception e) {
			System.out.println("alert is not present");
		}
			
	}
}
