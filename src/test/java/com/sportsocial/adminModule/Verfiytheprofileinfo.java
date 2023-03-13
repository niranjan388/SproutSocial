package com.sportsocial.adminModule;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.sportsocial.POM.EditProfilePage;
import com.sportsocial.POM.PersonalInfo;
import com.sportsocial.POM.ProfilePage;
import com.sportsocial.genaricUtility.FilePaths;
import com.sportsocial.genaricUtility.TestngBaseClass;
@Listeners(com.sportsocial.genaricUtility.ListernersClass.class)
public class Verfiytheprofileinfo  extends TestngBaseClass
{
	
  @Test
	public  void Verifytheprofile() 
	{
		
		String  editFirstname=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 1);
		String editLastname=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 2);
		String editUsername=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 3);
		String editBirthday=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 4);
		String editgender=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 5);
		String editnumber=excelfile.getExcelData( FilePaths.EDITPROFILE_SHEET, 2, 6);
	
      ProfilePage profilepage=new ProfilePage(driver);
      EditProfilePage editprofile=new EditProfilePage(driver);
      PersonalInfo profileinfo=new PersonalInfo(driver);
      
      
     
      commonpage.clickonprofileModule();
      profilepage.clickoneditprofile();
      editprofile.changeprofileinfo(webdriverutil, editFirstname, editLastname,editUsername, editBirthday,editgender,editnumber);
      commonpage.clickonHomeModule();
       String Actualusername = profileinfo.getUsernameText();
       
       String ActualmobileNo = profileinfo.getContactText();
       String Actualgender=profileinfo.getGenderText();
       Assert.assertEquals(Actualusername, editUsername,"Username are different ");
       Assert.assertEquals(ActualmobileNo, editnumber,"Mobilenumbers  are different ");
       Assert.assertEquals(Actualgender, editgender,"Gender  are different ");
       
      
	}

}
