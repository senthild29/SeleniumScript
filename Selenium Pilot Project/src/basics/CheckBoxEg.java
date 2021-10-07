package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxEg {
	
WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/checkbox.html");	
		
	}
	
	@Test
	public void CheckBox() {
		
		// Find Check box is selected or not		
		WebElement ChkBox1 = driver.findElement(By.xpath("//*[text()='Confirm Selenium is checked']/following::input[1]"));
		boolean checkselec = ChkBox1.isSelected();
		System.out.println("Does the checkbox is selected => "+checkselec);
		
		// De-select selected check box		
		WebElement ChkBox2 = driver.findElement(By.xpath("//*[text()='DeSelect only checked']/following::input[1]"));
		WebElement ChkBox3 = driver.findElement(By.xpath("//*[text()='DeSelect only checked']/following::input[2]"));
		
		if(ChkBox2.isSelected()) {
			ChkBox2.click();
		}
		
		if(ChkBox3.isSelected()) {
			ChkBox3.click();
		}
		
		// Select all CheckBoxes		
		List<WebElement> allbox = driver.findElements(By.xpath("//*[text()='Select all below checkboxes ']/following::input"));
		
		for (WebElement chkbox : allbox) {
			chkbox.click();			
		}
	}
	
	
	@AfterTest
	public void CloseBrow() {
		driver.quit();
	}

}
