package com.samples.programs;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTestNGFile {
	
	String baseUrl = "https://www.demo.guru99.com/V4/";
	String driverPath = "D://PRIYA//selenium jars and drivers//drivers//geckodriver.exe";
	public WebDriver driver;
 
	
	@BeforeTest
	public void setUpBrowser() {
		
		System.setProperty("webdriver.gecko.driver",driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
	
	@Test (priority = 0)
  public void gettingFile() throws Exception {
	 				
		FileInputStream fis = new FileInputStream("D:\\PRIYA\\testdata.xlsx");
				
		XSSFWorkbook wb = new XSSFWorkbook(fis);
				
		XSSFSheet sheet = wb.getSheet("Guru99TestData");
		
		int rowCount = sheet.getLastRowNum();
		
		for(int i=1; i<=rowCount;i++)
		{
			String user_Name = sheet.getRow(i).getCell(0).getStringCellValue();
            // @FindBy(name="uid") WebElement user_Name;
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
	}
		@Test (priority = 1)
		public void getPageTitle() {
			
			String expectedTitle = "Guru99 Bank Manager HomePage";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
		}
		
		@AfterTest
		public void closeBrowser() {
			
			driver.close();
		}
}

