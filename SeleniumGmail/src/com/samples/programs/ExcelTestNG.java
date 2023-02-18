package com.samples.programs;

import org.testng.annotations.Test;

public class ExcelTestNG {
  
	@Test(dataProvider = "DataExcel", dataProviderClass = ExcelDataProvider.class)
  
	public void ReadingExcel() {
	  
  }
}
