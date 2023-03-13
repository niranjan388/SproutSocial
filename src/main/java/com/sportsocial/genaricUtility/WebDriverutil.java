package com.sportsocial.genaricUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This Class consist of open,Maximize  the browser  close the browser
 * We are mentioned the implicitly  wait 
 * We can Handle drop down 
 * @author Admin
 *
 */


//Updated Base Class
public class WebDriverutil 
{
	WebDriver driver;
	String browser;
	String url;
	String Timeunit;
	Select sc;
	
	long Time;

	/**
	 * This Method will open the browser and maximize
	 * @return 
	 * @return
	 */
	
	
	public  WebDriver openBrowser (String browser,Propertiefileutil propertyfile,JavaUtil javautil)
	{
		
		
		
		url=propertyfile.readValuefromPropertyfile( PropertieFileKeys.URL.convertToString());
	
		Timeunit=propertyfile.readValuefromPropertyfile( PropertieFileKeys.IMPLICITLYWAIT.convertToString());
		Time=javautil.stringtointeger(Timeunit);

		if("chrome".equals(browser))
		{
		    WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();

		}
		else if("firefox".equals(browser))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else
		{
			System.out.println("Please enter the which browser want to launch");
		}

		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
		return driver;
	}
	
	
	
	
	/**
	 * This Method will close the browser 
	 */
	public void closeBrowser()

	{
		driver.quit();
	}

	/**
	 * This Method is used to select by visibility text
	 * @param ele
	 * @return
	 */
	public void dropdown(WebElement ele,String text)

	{
		 sc=new Select(ele);

		sc.selectByVisibleText(text);
	}
	
	/**
	 * This Method is used to select by visibility text
	 * @param ele
	 * @return
	 */
	public void dropdown(WebElement ele,int index)

	{
		
		sc.selectByIndex(index);
	}
	/**
	 * This Method will handle Mouse Actions 
	 * @return
	 */
	public Actions mouseAction() 
	{
		Actions act=new Actions(driver);
		
		act.perform();
		return act;

	}


	public Point getElementlocation(WebElement element)
	{
		Point loc = element.getLocation();
		return loc;
	}
	/**
	 * This Method is used to Window Scroll action for particular element 
	 * @param element
	 */
	public void windowScrollBy(WebElement element)
	{  
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("arguments[0].scrollIntoView();",element);
		
	}
	/**
	 * This Method is used to take screenshot 
	 * @return 
	 * @return 
	 */
	public String  takescreenshot(String testcasename)
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		JavaUtil javautil=new JavaUtil();
		String d = javautil.getSystemdata();
		String testname = testcasename+d;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot"+d+testname+".jpeg");
		
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();

	}

	/**
	 * This method will switch to frame by index
	 * @param index
	 */
	public void switchtoframe(int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame by address of the frame 
	 * @param element
	 */
	public void switchtoframe(WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch to frame by name of the frame 
	 * @param name
	 */
	public void switchtoframe(String name) 
	{
		driver.switchTo().frame(name);
	}
	/**
	 * This Method is used to switch to alert popup
	 * @return
	 */
	public Alert SwitchToAlert()
	{
		return  driver.switchTo().alert();

	}
	/**
	 * This Method is used to Switch the window
	 * @param Expetd_url
	 */

	public void switchToWindow(String Expetd_url)
	{
		Set<String> window_ids = driver.getWindowHandles();

		for(String window_id :window_ids)
		{
			String  Window_url=driver.switchTo().window(window_id).getCurrentUrl();
			if(Window_url.equals(Expetd_url))
			{
				
				break;
			}
		}
	}
	/**
	 * This Method is used to wait for the element 
	 * @param time
	 * @param ele
	 */

	public void  waitforLoad(Duration time,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	/**
	 *This Method is used to wait for element to be click 
	 * @param duration
	 * @param ele
	 * @param pollingtime
	 * @throws InterruptedException
	 */

	public void customWait(int duration,WebElement ele,long pollingtime) throws InterruptedException
	{
		int count=0;
		while(count<duration)
		{


			try
			{  
				ele.click();
				break;
			}
			catch (Exception e) {
				Thread.sleep(pollingtime);
				count++;
			}
		}
	}
		


	}

