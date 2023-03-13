	package com.sportsocial.genaricUtility;
/**
 * THis enum consist of All property file keys
 * @author Admin
 *
 */
public enum PropertieFileKeys
{ 
	
	 URL("url"),EMAIL("email"),PASSWORD("password"),BROWSER("browser"),IMPLICITLYWAIT("implicitlyWait");
	private String keys;
	
	private PropertieFileKeys(String keys) 
	{
		this.keys=keys;
	}
	  public String convertToString()
  {
	  return keys.toString();
  }
}
