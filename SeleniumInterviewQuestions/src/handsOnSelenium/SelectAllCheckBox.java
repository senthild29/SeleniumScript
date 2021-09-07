package handsOnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectAllCheckBox {
	
	@Test
	public void checkboxEg() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.navigate().to("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		//Identify all the checkbox in a page using Xpath
		List<WebElement> allBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//Click on the checkbox using for loop
		for (WebElement listbox : allBox) {
			listbox.click();
		}
	}

}
