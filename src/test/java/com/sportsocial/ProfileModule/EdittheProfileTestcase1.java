package com.sportsocial.ProfileModule;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import com.sportsocial.POM.EditProfilePage;

import com.sportsocial.POM.ProfilePage;



import com.sportsocial.genaricUtility.FilePaths;

import com.sportsocial.genaricUtility.TestngBaseClass;

public class EdittheProfileTestcase1 extends TestngBaseClass
{
	
   @Test
	public  void main() throws MalformedURLException 
	{	
	  
	
	   
		String  editFirstname=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 1);
		String editLastname=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 2);
		String editUsername=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 3);
		String editBirthday=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 4);
		String editgender=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 5);
		String editnumber=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 6);
		

      ProfilePage profilepage=new ProfilePage(driver);
      EditProfilePage editprofile=new EditProfilePage(driver);
      
      
    
      commonpage.clickonprofileModule();
      profilepage.clickoneditprofile();
      editprofile.changeprofileinfo(webdriverutil, editFirstname, editLastname,editUsername, editBirthday,editgender,editnumber);
		
	}


}
