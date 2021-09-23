package basics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownEg {

WebDriver driver;
	
	@BeforeTest
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Dropdown.html");
			
	}
	
	@Test
	public void ExploreDropDown() {
		// Select a value from drop down
		// We can select values by using Index, Value and VisibleText
		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		
		Select selectvalues = new Select(dd1);
		
		selectvalues.selectByIndex(1);
		selectvalues.selectByValue("2");
		selectvalues.selectByVisibleText("Loadrunner");
		
		// Find number of options in dropdown
		WebElement dd2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));
		
		Select findoptions = new Select(dd2);
		
		List<WebElement> getoptions = findoptions.getOptions();
		System.out.println("No of Options in drop down => "+getoptions.size());
	}
}
