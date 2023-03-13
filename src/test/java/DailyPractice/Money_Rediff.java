package DailyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Money_Rediff
{
	@Test
	public void HandleDynamicWebTable()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		String Exp="NIFTY NEXT 50";
		
		List<WebElement> index = driver.findElements(By.xpath("//b[text()='NSE INDICES']/parent::h2/following::div[@id='div_nseindices']//ul//a"));
		
		for (WebElement webElement : index) 
		{
			if(webElement.getText().equals(Exp))
			{
			String price = driver.findElement(By.xpath("//b[text()='NSE INDICES']/parent::h2/following-sibling::div[@id='div_nseindices']//a[.='"+webElement.getText()+"']/parent::li/following-sibling::li[@class='alignR']")).getText();
			System.out.println(price);
			break;
			}
		}
	}

}
