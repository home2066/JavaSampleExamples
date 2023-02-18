package com.samples.programs.venu;

import java.io.File;
import java.util.List;

import io.github.millij.poi.ss.reader.XlsReader;

public class ExcelRead {

	public static void main (String ar[]) throws Exception {
		
		final File xlsxFile = new File("D:\\PRIYA\\test_v1.xls");
	    final XlsReader reader = new XlsReader();
	   List<ExcelBean> list =  reader.read(ExcelBean.class, xlsxFile);
	    
	    
	   for(int i = 0; i<list.size(); i++) {
		   ExcelBean b = list.get(i);
		   String name = b.getName();
		   String pwd = b.getPassword();
		   
		   System.out.println(name + "    "+ pwd);
	   }
			   
			   
			   //List<Employee> employees = reader.read(Employee.class, xlsxFile);
	
	}
	
}
