package handsOnSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

	@Test
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");

		// Example# 1 => Wait for button to appear
		//Click on WaittoAppearHome button
		WebElement WaitoAppearHome = driver.findElement(By.xpath("//*[text()='Wait to Appear']/following-sibling::*"));
		WaitoAppearHome.click();

		//Created new object for ExplicitWait using WebDriverWait class
		WebDriverWait ExpliWait = new WebDriverWait(driver, 10);

		//Set the condition using until()
		WebElement AppElement = ExpliWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));

		//Once button appeared after wait getting the text of button
		System.out.println("Text of newly appeared button => "+AppElement.getText());

		//Coming back to home page
		driver.navigate().back();

		//Example# 2 => Wait for text to change on button and then click the button to display popup
		WebElement WaitTxtChgHome = driver.findElement(By.xpath("//*[text()='Wait for Text Change']/following-sibling::*"));
		WaitTxtChgHome.click();

		//Using until (), set condition to wait for text to change on button
		WebElement WaitoClick = ExpliWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click ME!']")));

		//Clicking on text changed button to dispaly popup
		WaitoClick.click();

		//Using Alert interface handling alert popup
		Alert handlealert = driver.switchTo().alert();
		handlealert.accept();

		driver.quit();

	}

}
