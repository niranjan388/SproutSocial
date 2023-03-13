package com.sportsocial.genaricUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class used to convert from string to other data type
 * @author Admin
 *
 */
public class JavaUtil
{
	/**
	 * This method will convert from string to Long
	 * @param Time
	 * @return
	 */
	public  int stringtointeger(String Time) 
	{
		return  Integer.parseInt(Time);
	}
 /**
  * This method is used to get the Random Number
  * @param number
  * @return
  */
	public int getradomNo(int number)
	{
		Random radomnum=new Random();
	  return  radomnum.nextInt(number);
	}
	/**
	 * This Method is used to get the system date in the dd_MM_YYYY_HH_mm_ss formate
	 * @return
	 */
	public String getSystemdata()
	{
		Date d = new Date();
	     SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
	     String d1 = sdf.format(d);
	     return d1;
	}
	
}
