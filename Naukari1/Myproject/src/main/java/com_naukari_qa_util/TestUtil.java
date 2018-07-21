package com_naukari_qa_util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com_naukari_qa_Base.TestBase;

public class TestUtil extends TestBase
{
	
	public static long implicitwait=20;
	public static String  Test_Sheet_Path = "G:\\Javaprogramming\\Naukari\\src\\main\\java\\com_naukari_qa_testdata\\Naukaridata.xlsx";
	 static  Sheet sheet;	 
	static Workbook book;
	
	public static Object[][]getTestData(String sheetname)
	{
		FileInputStream file= null;
		try {
			file = new FileInputStream(Test_Sheet_Path);
		} catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
			try {
				book =  WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
				// sheet.getRow(0).getLastCellNum());
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
						data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
						// System.out.println(data[i][k]);
					}
				}
				return data;
		 
		
	}
	
	public static void switchWindow()
	{
	String parent= driver.getWindowHandle();
	System.out.println("Parent id=" + parent);
	String ParentTitle = driver.getTitle();
	Set<String>allwindow= driver.getWindowHandles();
	for(String child: allwindow)
	{
		if(!parent.equalsIgnoreCase(child))
		{
			driver.switchTo().window(child);
			driver.close();
		}
	}
	driver.switchTo().window(parent);
	}
	
	
	
}
