package com.sportsocial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This Class is used to fetch the personal info like username ,gender,Mobile Number 
 * @author Admin
 *
 */
public class PersonalInfo
{
	@FindBy(xpath="//label[.='Username']/../following-sibling::td/b") private  WebElement usernameText;
	@FindBy(xpath="//label[.='Birthday']/../following-sibling::td/b") private  WebElement BirthdayText;
	@FindBy(xpath="//label[.='Gender']/../following-sibling::td/b") private  WebElement GenderText;
	@FindBy(xpath="//label[.='Contact']/../following-sibling::td/b") private  WebElement ContactText;
	@FindBy(xpath="//label[.='Email']/../following-sibling::td/b") private  WebElement EmailText;
	
	public PersonalInfo(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
  /**
   * This Method  is used to get the User name
   * @return
   */
	public String getUsernameText()
	{
		return usernameText.getText();
	
	}
	/**
	 * This Method is used to get the Birthday
	 * @return
	 */

	public String getBirthdayText() {
		return BirthdayText.getText();
	}/**
	*This Method is used to get the Gender
   */
	public String getGenderText() {
		return GenderText.getText();
	}
	/**
	 * This Method is used to get the Mobile Number
	 * @return
	 */

	public String getContactText() {
		return ContactText.getText();
	}
	/**
	 * This Method is used to get the Email Id 
	 * @return
	 */

	public String getEmailText() {
		return EmailText.getText();
	}
	
	
}
