package com.sportsocial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class consist of Profile Page modules
 * @author Admin
 *
 */
public class ProfilePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[.='Edit Profile']") private WebElement editprofileButton;
	@FindBy(name="firstname") private WebElement firstnameTextfiled;
	@FindBy(name="lastname") private WebElement lastnameTextfiled;
	@FindBy(xpath="//input[@name='birthday']") private WebElement birthdayTextfiled;
	@FindBy(name="save") private WebElement saveButton;
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
/**
 * This Method used to click on edit profile Button
 */
	 public void  clickoneditprofile()
	 {
		 editprofileButton.click();
	 }
	 

}
