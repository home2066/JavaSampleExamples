package com.samples.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class PowerCalculate {
		
private static final String usage_St_Time = null;
private static final String usage_End_Time = null;

@Test
  public void gettingFile() throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\PRIYA\\IntervalData.xlsx");
				
		XSSFWorkbook exwb = new XSSFWorkbook(fis);
				
		XSSFSheet sheet = exwb.getSheet("DataPower");
		
		int rowCount = sheet.getLastRowNum();
		
		String dateValue = "";
		double dateCount = 0.0;
		
		for(int i=1; i<=rowCount; i++)
			{			
			Row row = sheet.getRow(i);			
			int cellCount = row.getLastCellNum();
				
			String temp = row.getCell(1).toString();  
	           
	        for(int j=1; j<=cellCount; j++)
				{				
					switch(j) {
						case 1 :
							Cell usage_Dt = row.getCell(j);
							//System.out.println("The value of usage date is : " +usage_Dt);
							break;
					
						case 2 :
							Cell revision_Dt = row.getCell(j);
							//System.out.println("The value of revision date is " +revision_Dt);
							break;
				
						case 3 :
							Cell usage_St_Time = row.getCell(j);
							DataFormatter dataFormat1 = new DataFormatter();
							String usage_STime =  dataFormat1.formatCellValue(usage_St_Time);
							//System.out.println("The value of usage Start Time is " +usage_STime);
							break;
						
						case 4 :
							Cell usage_End_Time = row.getCell(j);
							DataFormatter dataFormat2 = new DataFormatter();
							String usage_ETime =  dataFormat2.formatCellValue(usage_End_Time);
							//System.out.println("The value of usage End Time is " +usage_ETime);
							break;
					
						case 5 :
							double new_usage_Kwh = row.getCell(j).getNumericCellValue();
							//System.out.println("The value of usage Kwh per each 15min interval is " +new_usage_Kwh);
							
							 if (temp.equals(dateValue)) {
								 dateCount = dateCount + new_usage_Kwh;
								 //dateValue = temp;
					         }else {
					        	 System.out.println(dateValue);
					 			System.out.println(dateCount);
					 			
					        	 dateValue =temp;
					        	 dateCount = new_usage_Kwh;
					         }
						break;
					}	
				}
		     }
		exwb.close();
	}
}