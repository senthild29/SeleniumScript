package handsOnSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollOpsEg {

	@Test
	public void OpenBrowser() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/index.htm");
		driver.manage().window().maximize();

		//Scenario# 1 => Scroll Down to a random position and scroll up
		//type case driver to JavascriptExecutor Interface
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		
		//Horizontal scroll down to Y coordinate 990
		exec.executeScript("window.scroll(0,990)", "");
		Thread.sleep(3000);

		//Horizontal scroll up to Y coordinate -990
		exec.executeScript("window.scroll(0,-990)", "");

		//Scenario# 2 => Scroll down to botton of the page.
		exec.executeScript("window.scroll(0, document.body.scrollHeight)", "");
		Thread.sleep(3000); 
		exec.executeScript("window.scroll(0, 0)", "");


		//Scenario# 3 => Scroll down to specific element
		// Iedntify the web Element
		WebElement BrowLib = driver.findElement(By.xpath("//a[@title='Browse Complete Library']"));
		// Pass the webElement to condition
		exec.executeScript("arguments[0].scrollIntoView(true);", BrowLib);
		Thread.sleep(2000);

		//Scenario# 4 => Using Robot class
		Robot scr = new Robot();
		scr.keyPress(KeyEvent.VK_PAGE_UP);
		scr.keyRelease(KeyEvent.VK_PAGE_UP);


	}

}
