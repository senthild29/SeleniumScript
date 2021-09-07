package handsOnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AuthPopupEg {
	
	
	@Test
	public void AuthPop() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Pass the credentials in the URL 
		driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		}

}
