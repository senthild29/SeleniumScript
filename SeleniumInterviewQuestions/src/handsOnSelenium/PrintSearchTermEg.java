package handsOnSelenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintSearchTermEg {
	
	@Test
	public void PrintGoogleSearch() throws InterruptedException {		

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.co.in/");
		
		WebElement TxtBox = driver.findElement(By.name("q"));
	//	driver.switchTo().activeElement().sendKeys("daniel craig movies");
		TxtBox.sendKeys("daniel craig movies");
		Thread.sleep(2000);
		
		//Identify the elements using findelements and print the statement inside for each loop
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//following::li"));
		
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
				
	}

}
