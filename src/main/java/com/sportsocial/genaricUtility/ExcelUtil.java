package com.sportsocial.genaricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/** 
 * In this class we will get the data from Excel
 * @author Admin
 *
 */
public class ExcelUtil 
{ 
	FileInputStream fisexcel;
	Workbook book;
	FileOutputStream fisout;
	DataFormatter df;

	public void openExcelFile(String filepathString)
	{
		try {
			fisexcel = new FileInputStream(filepathString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fisexcel);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This Method is used to close the ExcelFile
	 */
	public void closeExcelfile()
	{
		try {
			fisexcel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 *In This method returns data form Excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public  String getExcelData(String sheet,int row ,int cell)
	{
		df=new DataFormatter();

		String exceldata = df.formatCellValue(book.getSheet(sheet).getRow(row).getCell(cell));

		return exceldata;

	}
	/**
	 * This Method will give last Row number
	 * @param filepathString
	 * @param sheet
	 * @return
	 */
	public int getExcelData(String sheet)
	{


		return book.getSheet(sheet).getLastRowNum();
	}
	/**
	 * This Method will give Last cell number
	 * @param sheet
	 * @param row
	 * @return
	 */
	public int getExcelData(String sheet,int row)
	{

		return book.getSheet(sheet).getRow(row).getLastCellNum();	
	}
	/**
	 * THis method is used to write and save  the data in Excel
	 * @param filePath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param Value
	 */

	public void opentheExcelFiletoWriteData (String filePath,String sheet,int row,int cell,String Value)
	{

		book.getSheet(sheet).getRow(row).createCell(cell).setCellValue(Value);
		try {
			fisout=new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			book.write(fisout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This Method is used to fetch the Multiple  data to the data provider
	 * @return 
	 */
	public String[][] getDataforDataprovider(String Sheet)
	{

		int lastrow = getExcelData(Sheet);

		int lastcell= getExcelData(Sheet,0);
		String[][] arr=new String[lastrow][lastcell];

		for (int i = 0; i < lastrow; i++) 
		{

			for (int j = 0; j < lastcell; j++) 
			{
				arr[i][j]=(getExcelData(Sheet, i+1, j));

			}

		}
		return arr;
	}


	/**
	 * This method is used to read multiple     data from Excel 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public ArrayList<String> readMutilpledata(String sheet) 
	{

		ArrayList<String> arr=new ArrayList<>();
		int lastrow = getExcelData(sheet);
		for (int i = 0; i <lastrow ; i++) 

		{
			int lastcell = getExcelData(sheet, i);
			for (int j = 0; j < lastcell; j++) 
			{

				String value = getExcelData(sheet, i, j);      
				arr.add(value);

			}

		}

		return arr;
	}

}
