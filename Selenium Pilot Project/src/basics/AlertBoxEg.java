package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertBoxEg {

WebDriver driver;
	
	@BeforeTest
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Alert.html");
			
	}
	
	@Test
	public void Alert() {
		
		// 1. Alert Box
		WebElement Alert1 = driver.findElement(By.xpath("//*[text()='Alert Box']"));
		Alert1.click();
		
		// To handle alert use Alert interface and instruct driver to switch to alert
		org.openqa.selenium.Alert alert_box = driver.switchTo().alert();
		alert_box.accept();
	
		// 2. Confirm Box		
		WebElement Alert2 = driver.findElement(By.xpath("//*[text()='Confirm Box']"));
		Alert2.click();
		
		org.openqa.selenium.Alert confirm_box = driver.switchTo().alert();
		confirm_box.dismiss();
		
		// 3. Prompt Box
		WebElement Alert3 = driver.findElement(By.xpath("//*[text()='Prompt Box']"));
		Alert3.click();
		
		org.openqa.selenium.Alert prompt_box = driver.switchTo().alert();
		prompt_box.sendKeys("Hello World");
		prompt_box.accept();
		
	}
	
}
