package com.samples.programs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class MailLogin {

	public static void main(String[] args) throws InterruptedException {
						
			/*System.setProperty("webdriver.gecko.driver","D://PRIYA//selenium jars and drivers//drivers//geckodriver.exe");
			WebDriver driver = new FirefoxDriver(); */
			
			System.setProperty("webdriver.chrome.driver","D://PRIYA//selenium jars and drivers//drivers//chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			
			
			driver.get("https://outlook.live.com/owa/"); 
			driver.manage().window().maximize();  
			
			//driver.navigate().refresh();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			WebElement SgnIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='auxiliary-actions']//a[@href='https://outlook.live.com/owa/?nlp=1']")));
			SgnIn.click();
			
			WebElement userId = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i0116']")));                                                                                                                     
			userId.click();
			userId.sendKeys("kakumanipujitha25@outlook.com");                                                                                                      

			WebElement userNxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idSIButton9']")));                                                      
			userNxt.click();                                                                                                                                        

			WebElement userPswd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i0118']")));                                                         
			userPswd.click();
			userPswd.sendKeys("Gopal@190473");                                                                                                  

			WebElement pswdNxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idSIButton9']")));                                                          
			pswdNxt.click();
			
			WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idSIButton9']")));                                                      
			yesBtn.click();                                                                                                                                        
			
			Thread.sleep(3000);
			
			//CHECKING FOR ANY UNREAD MAILS IN INBOX
			//WebElement unRdMsg = wait.until(ExpectedConditions.alertIsPresent());
			yesBtn.
			
			//COMPOSING AN E-MAIL 
		WebElement newMsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='New message']"))); 
			////*[contains(text(), 'New message')]
			newMsg.click();                                                                                                                                        
                                                                                                                      
			WebElement sndToPrsn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='textbox']")));  
			sndToPrsn.sendKeys("kpujitha417@gmail.com");
			
			sndToPrsn.sendKeys(Keys.ENTER);
			sndToPrsn.sendKeys(Keys.TAB);
			System.out.println("Done here");	
			
			WebElement sbjtle = driver.findElement(By.xpath("//input[@placeholder='Add a subject']"));                                  
			sbjtle.sendKeys("hey buddy");                                                                                              

			WebElement emlBdy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Message body') and @role='textbox']")));                                         
			emlBdy.sendKeys("Did you get my mail? Let me know if you get my mail. Thank you");                                                                                               

			WebElement sndMail = driver.findElement(By.xpath("//*[text()='Send']"));                                            
			sndMail.click(); 
		
			//CHECKING THE SENT ITEMS WHETHER THE MAIL IS SENT OR NOT
			WebElement sntItems = driver.findElement(By.xpath("//*[text()='Sent Items']"));
			sntItems.click();
			
			//CREATING AN ACTION CLASS
			Actions act = new Actions(driver);
			
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				System.out.println("Exception in sleep");
			}
			
			WebElement sntMailed = driver.findElement(By.xpath("//*[@data-convid][position()=1]"));
			//sntMailed.click();
			act.moveToElement(sntMailed).doubleClick().build().perform();
			
			// TAKING A SCREENSHOT
			//String screenshotBase64 = ((TakesScreenshot) sntMailed).getScreenshotAs(OutputType.BASE64);
			//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			System.out.println("parent id " + driver.getWindowHandle());
			
			
		//	Set allwindows = driver.getWindowHandles();
		
			
			
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
			System.out.println("The Output File is Stored in" +srcFile);
			File f = new File("./image.png");
			
			try {
				FileUtils.copyFile(srcFile,f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
						
			System.out.println("Done");
			
//			driver.close();	
	}
		
}
