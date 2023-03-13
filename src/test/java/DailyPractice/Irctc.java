package DailyPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc 
{
	WebDriver driver;
	@Test
public void trainsListFrom5to6am() throws InterruptedException {
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/nget/booking/train-list");
		
	try {
	driver.findElement(By.xpath("//div[@role='dialog']//a[@class='fa fa-window-close pull-right loginCloseBtn ng-tns-c19-13']")).click();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
		
//		Thread.sleep(3000);
//		WebElement click = driver.findElement(By.xpath("//div[@role='dialog']//a[@class='fa fa-window-close pull-right loginCloseBtn ng-tns-c19-13']"));
//		Actions ac=new Actions(driver);
//		ac.click(click);
		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", click);
			
		driver.findElement(By.xpath("//div[@class='form-group ui-float-label']//p-autocomplete[@id='origin']//input")).sendKeys("KSR BENGALURU - SBC");
		driver.findElement(By.xpath("//div[@class='form-group ui-float-label']//p-autocomplete[@id='destination']//input")).sendKeys("MYSURU JN - MYS");
		driver.findElement(By.xpath("//div[@class='col-xs-12 remove-padding']/div/span/label[.='Flexible With Date']")).click();
		driver.findElement(By.xpath("//div[@class='col-xs-12 remove-padding']/div/button[.='Search']")).click();
		Thread.sleep(3000);
		
		List<WebElement> Ftrain = driver.findElements(By.xpath("//div[@class='col-xs-5 hidden-xs']"));
		List<WebElement> Ttrain = driver.findElements(By.xpath("//div[@class='col-xs-5 hidden-xs']/following-sibling::div/span[@class='pull-right']"));
		List<WebElement> time = driver.findElements(By.xpath("//div[@class='col-xs-5 hidden-xs']/following-sibling::div/span/strong"));
		
		int count=0;
			for (int i = 0; i < Ftrain.size(); i++) {
				//System.out.println(train.get(i).getText()+"-->"+time.get(i).getText());
				String tr = time.get(i).getText().substring(0, 2);
				int ch = Integer.parseInt(tr);
				if (ch>= 9 && ch<=18) {
					System.out.println(Ftrain.get(i).getText()+"----->"+Ttrain.get(i).getText());
					count++;
				}
			}
			System.out.println(count);
			
			driver.quit();
		}
	
	
	
	@Test
	public void Searchfortrains()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input")).sendKeys("mysuru");
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/input")).sendKeys("KSR BENGALURU - SBC");
		driver.findElement(By.xpath("//button[.='Search']")).click();
	}

}
