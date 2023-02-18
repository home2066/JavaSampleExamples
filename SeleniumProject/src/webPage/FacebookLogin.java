package webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
		
	public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver","D://PRIYA//selenium jars and drivers//drivers//chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			 
			WebElement uName = driver.findElement(By.xpath("//*[@id='email']"));
			uName.sendKeys("supriyavenkatesan@gmail.com"); 
			//String urn = uName.getAttribute("value");
		  
			WebElement pwd = driver.findElement(By.xpath("//*[@id='pass']"));
			pwd.sendKeys("Tanu190473");
			//String pwrd = pwd.getAttribute("value");
			
			//LogIn Button
		    WebElement logInBtn = driver.findElement(By.xpath("//*[@name='login']"));
			//Validating presence of element 
			if(logInBtn.isDisplayed())
			{
			//Performing action on web element
			logInBtn.click();
			System.out.println("Logged in successfully");
			} 
			else
			{
			 System.out.println("Login button is not selected");
			} 
		 
			driver.findElement(By.xpath("//*[text()='Forgot password?']")).isSelected();
		
			WebElement srchuName = driver.findElement(By.xpath("//*[@id='identify_email']"));
		    //String srn = srchuName.getAttribute("value");
		
			//System.out.println("the value in srchuName is :" +srn);
			//System.out.println("the value in uName is :" +urn);
		
			if(srchuName.isDisplayed())
			{
				driver.findElement(By.xpath("//*[@id='did_submit']")).click();
				System.out.println("Your account is available in Facebook");
			}
			else {
				System.out.println("Your account is not available in Facebook. So please create new account");
			}
		
			driver.quit();
}
}