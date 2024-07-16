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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

//change and will be staged before commiting.

public class HandlingWebElements {
	WebDriver driver;

//@Test
	public void checkboxAndRadioButtonTest() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
		Thread.sleep(5000);
		//Select Airbags as an option		
		WebElement airbags = driver.findElement(By.name("airbags"));
		
		//isSelected() returns true if the element is selected and false if it is not
		if (!airbags.isSelected()) {
			airbags.click();
		}
		
		Thread.sleep(3000);
		//Uncheck the checkbox
		if (airbags.isSelected()) {
			airbags.click();
		}
		Thread.sleep(5000);		
	}
	
@Test
public void handlingDropDowns() throws InterruptedException {
	driver.get("https://cookbook.seleniumacademy.com/Config.html");
	WebElement make = driver.findElement(By.name("make"));
	make.sendKeys("Audi");
	//driver.findElement(By.name("make")).sendKeys("Mercedes");
	//driver.findElement(By.xpath("make")).sendKeys("Audi");
	//driver.findElement(By.xpath("")).findElement(By.xpath("")).click();
	
  //  driver.findElements(By.tagName("option")); //It searches the entire page for the first option tag
//	driver.findElement(By.tagName("select")).findElements(By.tagName("option"));//It searches only inside select element.
	
	List<WebElement> allOptions = make.findElements(By.tagName("option"));
	System.out.println("Total options in the dropdown: " + allOptions.size());

	Thread.sleep(3000);
	
	
	Select makeSelect = new Select(make);
	
	makeSelect.selectByIndex(2);
	Thread.sleep(3000);
	makeSelect.selectByValue("mercedes");
	Thread.sleep(3000);
	makeSelect.selectByVisibleText("Honda");
	Thread.sleep(3000);		
	
	List<WebElement> allopt = makeSelect.getOptions();
	
	String CurrentElementSelected = makeSelect.getFirstSelectedOption().getText(); 
	assertEquals(CurrentElementSelected, "Honda");				
}


//@Test
public void handlingMultiSelect() throws InterruptedException {
	driver.get("https://cookbook.seleniumacademy.com/Config.html");
	WebElement color = driver.findElement(By.name("color"));
	Select colorSelect = new Select(color);
	colorSelect.selectByIndex(2);
	Thread.sleep(2000);		
	colorSelect.selectByValue("bl");
	Thread.sleep(2000);
	colorSelect.selectByVisibleText("White");
	Thread.sleep(2000);
	
	List<WebElement> allSelectedOptions = colorSelect.getAllSelectedOptions();
	
	
	
	colorSelect.deselectByIndex(2);
	Thread.sleep(2000);		
	colorSelect.deselectByValue("bl");
	Thread.sleep(2000);
	colorSelect.deselectByVisibleText("White");
	Thread.sleep(2000);
	
	
	colorSelect.selectByIndex(2);				
	colorSelect.selectByValue("bl");		
	colorSelect.selectByVisibleText("White");
	colorSelect.deselectAll();
	Thread.sleep(2000);
}


@BeforeClass
public void beforeClass() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}

@AfterClass
public void afterClass() {
	// Close the browser
	driver.quit();
}
}