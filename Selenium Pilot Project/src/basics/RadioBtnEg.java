package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioBtnEg {
	
WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/radio.html");	
		
	}
	
	@Test
	public void RdBtn() {
		// Find which radio button is selected by default
		WebElement RdBtn1 = driver.findElement(By.xpath("//*[@for='Unchecked']/child::input"));
		WebElement RdBtn2 = driver.findElement(By.xpath("//*[@for='Checked']/child::input"));
		
		if(RdBtn1.isSelected()) {
			System.out.println("Radio Btn1 is checked by default");
		}else {
			System.out.println("Radio Btn2 is  checked by default");
		}
		
	}
	
	@AfterTest
	public void CloseBrow() {
		driver.quit();
	}

}
