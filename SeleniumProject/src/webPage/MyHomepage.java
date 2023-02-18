package webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomepage {


	public static void main(String[] args)  {

		 // setting the driver path
		 System.setProperty("webdriver.chrome.driver",
				"D://PRIYA//selenium jars and drivers//drivers//chromedriver.exe");

		 // creating the driver instance
		 WebDriver driver = new ChromeDriver();
		
    	 //Navigate to web page 
		 driver.get("https://the-internet.herokuapp.com/login");
		 
		 //Maximize the window 
		 driver.manage().window().maximize();
		  
		 //Retrieving the page title 
		 String title = driver.getTitle();
		 System.out.println("the page title is :" +title);
		
		 //Locating web element 
		  WebElement uName = driver.findElement(By.xpath("//*[@id='username']")); 
		  uName.sendKeys("tomsmith");
		  
		  WebElement pswd  = driver.findElement(By.xpath("//*[@id='password']")); 
		  pswd.sendKeys("SuperSecretPassword!"); 
		  
		  WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
		
		  //Validating presence of element 
			 if(loginBtn.isDisplayed())
			 {
				//Performing action on web element
				loginBtn.click();
				System.out.println("Logged in successfully");
			 }else 
			 {
				System.out.println("Login button is not selected");
			 }
		  
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 WebElement logoutBtn = driver.findElement(By.xpath("//*[text()=' Logout']")); 		  
		 
		
		 if(logoutBtn.isDisplayed())
	     {
			 
		  //Performing action on web element 
		  logoutBtn.click();
		  System.out.println("LogOut Successful!");
		  }else
		  {
		  System.out.println("Incorrect login...."); 
		  }
		  
		  //Closing browser session
		     driver.quit();
	   }

}
