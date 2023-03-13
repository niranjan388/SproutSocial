package DailyPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement 
{
	@Test
	public void shadow() throws AWTException
	{
		
	WebDriverManager.chromedriver().setup();	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://google.com");
	
	JavascriptExecutor jss=(JavascriptExecutor)driver;
	
	 WebElement ele = (WebElement) jss.executeScript("return document.querySelector('body > ntp-app').shadowRoot.querySelector('#realbox').shadowRoot.querySelector('#input')");
	
	 ele.click();
	 ele.sendKeys("flipkart");
	Robot rbt=new Robot();
	
	rbt.keyPress(KeyEvent.VK_ENTER);
	rbt.keyRelease(KeyEvent.VK_ENTER);
	
	System.out.println("opended");
	
	}

}
