package webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonHome {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D://PRIYA//selenium jars and drivers//drivers//geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.guru99.com/selenium-tutorial.html";
			
		String expectedTitle = "Selenium Tutorial";
		String actualTitle = null;

		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.amazon.com/");
		
		actualTitle = driver.getTitle();
		
		if(actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Your Actual Web Page Title is : " +actualTitle);	
		}
		else
		{
			System.out.println("Your Expected Web Page Title is : " +expectedTitle);
		}
		
		
		driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
		
	    driver.findElement(By.xpath("//*[@name='site-search']"));
		
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		
 //div[@id='nav-xshop']/a[@href='/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice']		
		
/*		WebElement custServ = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']"));
		
		if(custServ.isDisplayed())
		{
			custServ.click();
			System.out.println("Customer Service is available at your service");
		}
		else {
			System.out.println("Customer Service is not available");
		}
*/		
		
		
		
	//	driver.quit();
	}

}
