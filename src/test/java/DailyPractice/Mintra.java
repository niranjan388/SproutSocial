package DailyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mintra
{
	@Test
	public void MintraTshirt()
	
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		WebElement price = driver.findElement(By.xpath("//h3[text()='Huetrap']/following-sibling::div//span[@class='product-discountedPrice']"));
		
	}

}
