package com.sportsocial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PracticePOMClasses

{
	
	@FindBy(xpath="//select[@aria-describedby='searchDropdownDescription']") private WebElement dropdown;
    @FindBy(id="twotabsearchtextbox") private WebElement seachbar;
    @FindBy(xpath="//div[@class='nav-search-submit nav-sprite']") private WebElement searchbutton;
    
    
    
    
    
    public PracticePOMClasses(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	}


	public void selectoption(String option)
    {
    	Select sc = new Select(dropdown);
    	sc.selectByVisibleText(option);
    }
	public void search(String text)
    {
		seachbar.sendKeys(text);
		searchbutton.click();
    
    }
	
 }
