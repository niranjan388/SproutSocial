package DailyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Avedaapplication 
{
	@Test
	public void fetchalloptions()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.aveda.com/#");
		
		Actions sct=new Actions(driver);
		//div[@class='site-header__menu-desktop']//div[@id='node-96']/div/ul/li
		
		//div[@class='site-header__menu-desktop']//div[@id='node-96']/div/ul/li/a
		
		driver.findElements(By.xpath("//div[@class='site-header__menu-desktop']//div[@id='node-96']/div/ul/li/a"));
		
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='site-header__menu-desktop']//div[@id='node-96']/div/ul/li/a[text()='MAKEUP']"));
		sct.moveToElement(ele);
	List<WebElement> items = driver.findElements(By.xpath("//div[@class='menu__content menu__content--lvl-2 js-nav-category-trigger-content']//ul[@class='menu menu--lvl-3']/li/a"));
	
	for (WebElement webElement : items)
	{
		System.out.println(webElement.getText());
		
	}
	}

}
