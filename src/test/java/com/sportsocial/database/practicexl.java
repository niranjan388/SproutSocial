package com.sportsocial.database;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class practicexl {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdataforautomation.xlsx");
		String res = WorkbookFactory.create(fis).getSheet("Home_Module").getRow(2).getCell(1).getStringCellValue();
		
		System.out.println(res);

	}

}
