package DailyPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sportsocial.POM.PracticePOMClasses;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon 
{
	@Test
	public void selectoption()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_3c01r1321r_e&adgrpid=60612964962&hvpone=&hvptwo=&hvadid=486380734071&hvpos=&hvnetw=g&hvrand=1787662067522778674&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062012&hvtargid=kwd-32679660&hydadcr=14454_2154375&gclid=Cj0KCQiA6LyfBhC3ARIsAG4gkF-agHkhfSMOQH5D52wv8pP77Bwi86nQ8rtRpTQMJUPttgjXRObGK04aAk3EEALw_wcB");
		PracticePOMClasses pss=new PracticePOMClasses(driver);
		pss.selectoption("Books");
		pss.search("supper books");
	}

}
