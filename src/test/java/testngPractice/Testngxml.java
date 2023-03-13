package testngPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Testngxml
{
	   
	   
	@Test
	public void Test1() throws MalformedURLException, InterruptedException {
		

		   URL u=new URL("http://192.168.139.1:4466/wd/hub");
		   DesiredCapabilities cap=new DesiredCapabilities();
		   cap.setBrowserName("chrome");
		   cap.setPlatform(Platform.WINDOWS);
		   WebDriver driver=new RemoteWebDriver(u,cap);
		   driver.get("http://www.facebook.com");
		System.out.println("Test 1");
		Thread.sleep(3000);
		driver.quit();
	}
	

}
