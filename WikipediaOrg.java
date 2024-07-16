package scripts;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

//This file is changed but will be commited directly without staging

public class WikipediaOrg {
	WebDriver driver;
	
	
  @Test
  public void loginToSTCToursimWebsite() throws InterruptedException {

	     driver.get("https://www.wikipedia.org/");
	     driver.findElement(By.id("js-link-box-en")).click();
	     WebElement user = driver.findElement(By.xpath("//input[@name='search']"));
	     //Thread.sleep(5000);
	     user.sendKeys("Selenium");
	     
	     driver.findElement(By.xpath("//*@id=\"searchform\"])/div/button")).click()
;
	     
	     
	     String expectedTitle= "selenium";
	     String actualTitle = driver.getTitle();
	     
	     System.out.println("ExpectedTitle: " + expectedTitle);
	     System.out.println("ActualTitle: " + actualTitle);
	     
	     if(expectedTitle.equals(actualTitle)) {
	    	 System.out.println("Test passed");
	     }
	       
	    		
  }
  
  @BeforeMethod
  public void beforeMethod() {
		
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  //close the browser.
   // driver.quit();
  }


}
