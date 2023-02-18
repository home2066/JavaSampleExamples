package com.samples.programs;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru99Login {

	public static void main(String args[]) throws IOException, InterruptedException {
		
			System.setProperty("webdriver.gecko.driver","D://PRIYA//selenium jars and drivers//drivers//geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.demo.guru99.com/V4/");
			driver.manage().window().maximize();
						
			String expectedTitle = "Guru99 Bank Manager HomePage";
			String actualTitle = null;
			actualTitle = driver.getTitle();
					
			if(actualTitle.contentEquals(expectedTitle))
			{
				System.out.println("Your Actual Web Page Title is : " +actualTitle);	
			}
			else
			{
				System.out.println("Your Expected Web Page Title is : " +expectedTitle);
			}
		
			FileInputStream fis = new FileInputStream("D:\\PRIYA\\testdata.xlsx");
					
			XSSFWorkbook wb = new XSSFWorkbook(fis);
					
			XSSFSheet sheet = wb.getSheet("Guru99TestData");
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i=1; i<=rowCount;i++)
			{
				String user_Name = sheet.getRow(i).getCell(0).getStringCellValue();
                driver.findElement(By.xpath("//*[@name='uid']")).sendKeys(user_Name);
				
				String password = sheet.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
				 
				WebElement logInBtn = driver.findElement(By.xpath("//*[@name='btnLogin']"));
                
				if(logInBtn.isDisplayed())
    			{
    				String user1 = "mngr449120";
    				String pass1 = "pYjydar";
    				
    				if((user_Name.equals(user1)) && (password.equals(pass1)))
    				{
    					logInBtn.click();
    					System.out.println("Logged in successfully");
    					
    				}else {
    					try {
    						driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
    						driver.switchTo().alert().accept();
    						Thread.sleep(3000);
    					}catch(NoAlertPresentException e) {
    						System.out.println("NoAlertPresentException is handled");
    					} 
    				}	
    			}
			}
		fis.close();
		driver.quit();
	}
}