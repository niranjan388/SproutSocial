package com.sportsocial.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * This class consist of update status and verify the status and comment to the
 * status
 * 
 * @author Admin
 *
 */
public class Uploadstatus 
{
	WebDriver driver;
	@FindBy(className = "post-text")
	private WebElement statusText;
	@FindBy(name = "image")
	private WebElement statusPhoto;
	@FindBy(className = "btn-share")
	private WebElement ShareButton;
	@FindBy(xpath = "//div[@id='right-nav1']/div/p")
	private List<WebElement> allStatusText;
	@FindBy(xpath = "//div[@id='right-nav1']/div/center/img")
	private List<WebElement> allStatusPhoto;
	@FindBy(name = "post_comment")
	private WebElement commentButton;
	@FindBy(xpath = "//button[@class='btn-delete']")
	private WebElement postdelectbutton;
	String commentBoxXpath = "//p[.='%s']/../following-sibling::form/div/input[@type='text']";
	String delectbuttonXpath = "//p[.='%s']/preceding-sibling::div/a/button";

	public Uploadstatus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private WebElement StringToWebElemet(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * This Method is used to post the status
	 * 
	 * @param expstatusText
	 * @param expstatusPhoto
	 */

	public void shareThepost(String expstatusText, String expstatusPhoto) {
		statusText.sendKeys(expstatusText);
		statusPhoto.sendKeys(expstatusPhoto);
		ShareButton.click();
	}

	/**
	 * This method is used to verify the status
	 * 
	 * @param expstatusText
	 * @param expstatusPhoto
	 */

	public void verifythepost(String expstatusText) {

		boolean flag = false;
		for (int i = 0; i < allStatusText.size(); i++) {
			String ActualstatusText = allStatusText.get(i).getText();

			if (ActualstatusText.equals(expstatusText)) {
				flag = true;
				break;
			}

		}
		Assert.assertEquals(flag, true, "Not able to verify the status");

	}

	/**
	 * This Method is used to comment for the particular post
	 * 
	 * @param ExceptedstatusText
	 * @param Exceptedstatusphoto
	 * @param commentforpost
	 * @throws InterruptedException
	 */
	public void commenttopost(String ExceptedstatusText, String Exceptedstatusphoto, String commentforpost) {
		boolean flag = false;
		for (int i = 0; i < allStatusText.size(); i++) {

			if (allStatusText.get(i).getText().equals(ExceptedstatusText)) {

				StringToWebElemet(commentBoxXpath, ExceptedstatusText).sendKeys(commentforpost);

				commentButton.click();

				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true, " Not able to comment for the post");

	}

	/**
	 * This method is used to delete the post
	 * 
	 * @param ExceptedstatusText
	 */
	public void deletethepost(String ExceptedstatusText) {
		boolean flag = false;
		for (int i = 0; i < allStatusText.size(); i++) {
			if (allStatusText.get(i).getText().equals(ExceptedstatusText)) {
				StringToWebElemet(delectbuttonXpath, ExceptedstatusText).click();
				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true,"Not able to delect the post");

	}
/**
 * This Method is used to delete the number of post to deleted
 * @param no
 */
	public void deleteallpost(int no) {
		for (int i = 0; i < no; i++) {
			postdelectbutton.click();
		}

	}

}
