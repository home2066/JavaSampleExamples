package com.samples.programs.millij;

import java.io.File;
import java.util.List;

import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;

public class readExcel {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  final File xlsxFile = new File("D:/Priya/temp1.xls");
		    final XlsReader reader = new XlsReader();
		    try {
				List<PowerBean> beans = reader.read(PowerBean.class, xlsxFile);
				
				for (PowerBean team: beans) {
					System.out.println(team.toString());
				}
				
			} catch (SpreadsheetReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
