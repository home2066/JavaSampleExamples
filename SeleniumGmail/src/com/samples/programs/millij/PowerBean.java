package com.samples.programs.millij;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class PowerBean {
	 @SheetColumn("USAGE_DATE")
	private String USAGE_DATE;

	 @SheetColumn("USAGE_KWH")
	private double  USAGE_KWH;

	public PowerBean() {
			// TODO Auto-generated constructor stub
	}

	public PowerBean(String uSAGE_DATE, double uSAGE_KWH) {
		
		USAGE_DATE = uSAGE_DATE;
		USAGE_KWH = uSAGE_KWH;
	}

	public String getUSAGE_DATE() {
		return USAGE_DATE;
	}

	public void setUSAGE_DATE(String uSAGE_DATE) {
		USAGE_DATE = uSAGE_DATE;
	}

	public double getUSAGE_KWH() {
		return USAGE_KWH;
	}

	public void setUSAGE_KWH(double uSAGE_KWH) {
		USAGE_KWH = uSAGE_KWH;
	}

	@Override
	public String toString() {
		return "PowerBean [USAGE_DATE=" + USAGE_DATE + ", USAGE_KWH=" + USAGE_KWH + "]";
	}
	
	
	

}
