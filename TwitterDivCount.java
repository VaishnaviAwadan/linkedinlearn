package scripts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

//Added a comment after staging
//Add comment in a file
//Changes made for assignment.

public class TwitterDivCount {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
  @Test
  public void loginToNicheTourism() throws InterruptedException {
	driver.get("https://www.twitter.com");   
	List<WebElement> allDivElements = driver.findElements(By.xpath("//div"));
	System.out.println("Total Div elements on Twitter.com are -" + allDivElements.size());
	 
	for (WebElement oneElement: allDivElements) {
		System.out.println(oneElement.getText() + " - " +oneElement.getAttribute("div"));
		
	}
  }
  

  @AfterClass
  public void afterClass() {
	  //close the browser.
	  driver.quit();
  }


}
