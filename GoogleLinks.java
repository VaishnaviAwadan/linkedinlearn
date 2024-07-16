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

//Adding comments demo of files modified after commit.

public class GoogleLinks {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
  @Test
  public void loginToNicheTourism() throws InterruptedException {
	driver.get("https://www.google.com");   
	List<WebElement> allGoogleLinks = driver.findElements(By.xpath("//a"));
	System.out.println("Total Links on Google.com are -" + allGoogleLinks.size());
	 
	for (WebElement oneElement: allGoogleLinks) {
		System.out.println(oneElement.getText() + " - " +oneElement.getAttribute("href"));
		 //Thread.sleep(3000);
	}
  }
  

  @AfterClass
  public void afterClass() {
	  //close the browser.
	  driver.quit();
  }


}

