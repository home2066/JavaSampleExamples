package com.samples.programs;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider
	public Object[][] excelData() throws Exception {
		
		File read_file = new File("D:\\PRIYA\\IntervalData.xlsx");
		
		FileInputStream fis = new FileInputStream(read_file);
		
		XSSFWorkbook exwb = new XSSFWorkbook(fis);
				
		XSSFSheet sheet = exwb.getSheet("DataPower");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		
		int noOfCol = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[noOfRows][noOfCol];
		
		for(int i=0; i < noOfRows; i++)
		{
			for(int j=0; j < noOfCol; j++)
			{
				DataFormatter dataFormat1 = new DataFormatter();
				
				obj[i][j] = dataFormat1.formatCellValue(sheet.getRow(i).getCell(j));
				
				System.out.println(obj[i][j]);
			}
		}
	exwb.close();
	fis.close();
	
//	for (Object[] dataArr : obj)
//	{
//		System.out.println(Arrays.toString(dataArr));
//	}
	return obj;
}
}
