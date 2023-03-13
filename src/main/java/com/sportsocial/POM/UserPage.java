package com.sportsocial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage
{
	@FindBy(xpath="//div[@id='clip2']/a/img") private WebElement coverpic;
	@FindBy(xpath="//input[@type='file']") private WebElement Uploadpic;
	@FindBy(xpath="//input[@type='submit']") private WebElement submit;
	

	
	public UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This Method is used to upload the cover Photo
	 */
	public void ClickonCoverphoto()
	{
		coverpic.click();
	}
	public void uploadcoverpic(String photoPath)
	{
		Uploadpic.sendKeys(photoPath);
		submit.click();
	}
}
