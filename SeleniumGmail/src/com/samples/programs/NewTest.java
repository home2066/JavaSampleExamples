package com.samples.programs;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(@Optional("chrome") String browsername) {
		switch (browsername.toLowerCase()) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default :
			System.err.print("Browser is invalid"   +browsername);
			break;
		}
		driver.manage().window().maximize();
	}

	@Parameters({"url", "sleepTime"})
	@Test
	public void openUrl(String url, long sleepTime) throws Exception {
		driver.get(url);
		Thread.sleep(sleepTime);
	}

	@Parameters({"user", "pswd", "sleepTime"})
	@Test
	public void userLogin(String user, String pswd, long sleepTime) throws Exception {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pswd);
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		Thread.sleep(sleepTime);
	}

	@Test
	public void verifyUser() {
		WebElement element = driver.findElement(By.xpath("//*[text()='Paul Collings']"));
		System.out.println("The User name is " +element.getText());
		assertTrue(element.isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
