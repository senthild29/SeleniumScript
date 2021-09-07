package handsOnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintSrchResultURLEg {
	
	@Test
	public void PrintSrchTermResults() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.navigate().to("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		WebElement TxtBox = driver.findElement(By.name("q"));
		TxtBox.sendKeys("ICC Test Championship"+Keys.ENTER);
		
		Thread.sleep(3000);
		
		//Identified the anchor tag using findElements
		//List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		//Write a xpath to identify the small link
		List<WebElement> smalllinks =	driver.findElements(By.xpath("//div//cite"));
		
				
		System.out.println("No of small link => "+smalllinks.size());
		
		//Get the attribute "href" and print the URL using for loop
		/*
		 * for (WebElement webElement : links) {
		 * System.out.println(webElement.getAttribute("href"));
		 * 
		 * }
		 */
		
		//get the url of small link using getText() and print the same using for loop
		for (WebElement webElement : smalllinks) {
			System.out.println(webElement.getText());
			
		}
	}

}
