package handsOnSelenium;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickSearchTermEg {

	@Test
	public void ClickSearchSuggestion() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");

		WebElement TxtBox = driver.findElement(By.name("q"));
		TxtBox.sendKeys("game of thrones");
		Thread.sleep(2000);

		//Find list of element using driver.findElements and store it to List<WebElement>
		java.util.List<WebElement> AllItems = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		//Scenario# 1, click on the search suggestion using index().

		//Method# 1 Using get(index), find and click on the search term.
		AllItems.get(2).click();

		//Method# 2 Iterate the element using for loop and click on the same.
		int position=0;
		for (WebElement webElement : AllItems) {
			System.out.println(webElement.getText()); 
			position++; 
			if(position==3) {
				webElement.click(); break; }

		}

		//Scenario# 2, click on the search suggestion using specific word
		for (WebElement webElement : AllItems) {
			if(webElement.getText().contains("cast")) {
				webElement.click();
				break;
			}

		}

	}
}
