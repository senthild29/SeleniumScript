package basics;


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
		// Select a values from drop down
		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		Select selectvalues = new Select(dd1);
		
		// We can select values by Index, Value and VisibleText
		selectvalues.selectByIndex(1);
		selectvalues.selectByValue("2");
		selectvalues.selectByVisibleText("Loadrunner");
	}
}
