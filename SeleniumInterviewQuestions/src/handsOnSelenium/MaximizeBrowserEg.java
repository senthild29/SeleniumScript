package handsOnSelenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MaximizeBrowserEg {
	
	@Test
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.google.co.in/");
		//driver.manage().window().maximize();
		
		/*
		 * // Method# 2 create an object for Dimension class and pass the height and
		 * width parameters Dimension dimen = new Dimension(1920, 1080); //Pass the
		 * dimension obejct to setSize() driver.manage().window().setSize(dimen);
		 */
		
		
	}

}
