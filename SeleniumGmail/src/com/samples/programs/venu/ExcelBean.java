package com.samples.programs.venu;

import javax.annotation.meta.Exclusive;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class ExcelBean {

	@SheetColumn("User Name")
	private String name;
	
	@SheetColumn("Password")
	private String password;

	public ExcelBean() {
	}

	public ExcelBean(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
