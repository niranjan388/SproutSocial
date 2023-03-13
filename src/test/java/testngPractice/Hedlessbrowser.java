package testngPractice;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Hedlessbrowser 
{
	public static void main(String[] args) 
		
	
	{
    HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        
        // open demo site webpage
        unitDriver.get("https://demoqa.com/");
		
	//Print the title of the page
        System.out.println("Title of the page is -> " + unitDriver.getTitle());
        
    }
}
	


