package com.sportsocial.adminModule;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sportsocial.POM.UserPage;
import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.TestngBaseClass;
@Listeners(com.sportsocial.genaricUtility.ListernersClass.class)
public class ChangeprofilePhotoTestcase1 extends TestngBaseClass {
	
  @Test
	public void changeprofilephoto() {

		String PhotoPath = excelfile.getExcelData(FilePaths.HOME_MODULE_SHEET, 2, 1);
		System.out.println(PhotoPath);
		commonpage.clickonuserModule();
		UserPage userpage=new UserPage(driver);
		userpage.ClickonCoverphoto();
		userpage.uploadcoverpic(PhotoPath);
			
	}

}
