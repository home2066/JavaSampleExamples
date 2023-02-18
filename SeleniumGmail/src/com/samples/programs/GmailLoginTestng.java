package com.samples.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLoginTestng {
	
	@Test(dataProvider = "loginData")
	public void loginMail(String[] s) throws Exception {
		WebDriverManager.chromedriver().setup();;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");		
		 
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(s[0]); 
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(s[1]); 
		driver.findElement(By.xpath("//*[text()= ' Login']")).click();
				
		Thread.sleep(2000);  

	  	driver.quit();
   }

	
	@DataProvider
	public String[][] loginData() {
		String[][] obj = new String[][] {
			
			{"tomsmith","SuperSecretPassword!"},
			
			{"tomsmith123","SuperSecretPassword!@#$%"}
		};
		
		return obj;
		
	}

//	public void loginMail(String userName, String pswd) throws Exception {
//			WebDriverManager.chromedriver().setup();;
//			WebDriver driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			
//			driver.get("https://the-internet.herokuapp.com/login");		
//			String title = driver.getTitle();
//			System.out.println("the page title is :" +title);
//			 
//			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(userName); 
//			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pswd); 
//			driver.findElement(By.xpath("//*[text()= ' Login']")).click();
//			Assert.assertTrue(driver.findElement(By.partialLinkText("//*[text()= 'Welcome']")).isDisplayed());
//			driver.findElement(By.xpath("//*[text()=' Logout']")).click();
//			
//			Thread.sleep(5000);  
//
//		  	driver.quit();
//	   }
	
//	@DataProvider(name = "LoginUserDetails")
//	public Object[][] loginData() {
//		Object[][] obj = new Object[2][2];
//		obj[0][0] = "tomsmith"; 
//		obj[0][1] = "SuperSecretPassword!";
//		
//		obj[1][0] = "tomsmith123"; 
//		obj[1][1] = "SuperSceretPassword@%&";
//		
//		return obj;
//		
//	}

}

