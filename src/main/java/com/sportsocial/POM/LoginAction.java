package com.sportsocial.POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class consist of LoginAction for the application
 * @author Admin
 *
 */
public class LoginAction 
{
	
	@FindBy(name="email")   private WebElement emailTextFiled;
	@FindBy(name="password")   private WebElement passwordTextFiled;
	@FindBy(name="submit")   private WebElement loginButton;

	
	public LoginAction(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
/**
 * This Method is used to login To the application 
 * @param emailid
 * @param password
 */
	public void logintoapplication(String emailid,String password)
	{
		emailTextFiled.sendKeys(emailid);
		passwordTextFiled.sendKeys(password);
		loginButton.click();
	}
	
}
