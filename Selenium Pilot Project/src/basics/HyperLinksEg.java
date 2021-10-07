package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HyperLinksEg {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");	
		
	}
	
	@Test
	public void Links() {
		
		//Find where the link redirects without clicking it
		WebElement link1 = driver.findElement(By.partialLinkText("without"));
		String getAtt = link1.getAttribute("href");
		System.out.println("Link will redirect to => "+getAtt);
		
		// How many links available in this page
		List<WebElement> link2 = driver.findElements(By.tagName("a"));
		int totallinks = link2.size();
		System.out.println("No of links in this page => "+totallinks);
		
		// Verify link is broken		
		WebElement link3 = driver.findElement(By.partialLinkText("broken"));
		link3.click();
		String verifyBroken = driver.getTitle();
		System.out.println("Link is not working getting "+verifyBroken);
	}

	@AfterTest
	public void CloseBrow() {
		driver.quit();
	}
}
