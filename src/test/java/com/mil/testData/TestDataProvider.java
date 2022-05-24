package com.mil.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	public static String FILE_PATH = "M:\\eclipse-workspace\\HRMOrangePomGenerics\\src\\main\\java\\com\\mil\\utils\\HrmTestData.xlsx";
	static String sheetName = "testData"; // will provide from properties file later.
	public static Workbook book;
	public static Sheet sheet;

	@DataProvider(name="provideTestData")
	public Object[][] provideTestData() {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("testData");
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0; i<sheet.getLastRowNum();i++) {
		for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
			data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
	}

}
