package com.sportsocial.genaricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Properties;
/**
 * This class consist of open the PropertyFile
 * Read the data from Property file
 * @author Admin
 *
 */
public class Propertiefileutil 
{
	
	private FileInputStream fis;
	private Properties	 pr;
	/**
	 * This Method is used to open the PropertyFile
	 * @param propertyFilePath
	 * @param keys
	 */
	public void openThePropertyfile(String propertyFilePath) 
	{
		
		 try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 pr=new Properties();
		
			try {
				pr.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	/**	
	 * This Method is used to read the data from property file
	 * @param Keys
	 * @return
	 */
	public String readValuefromPropertyfile(String Keys)
	{
		
		String data=pr.getProperty(Keys);
		return data;
		
	}
	/**
	 * This method is used to close the Property file
	 */
	public void closethePropertyfile()
	{
		 
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
