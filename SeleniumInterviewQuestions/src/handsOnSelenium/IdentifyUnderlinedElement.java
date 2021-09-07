package handsOnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IdentifyUnderlinedElement {

	@Test
	public void UnderlineElement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(2000);

		//Identify the element to hover
		WebElement underline = driver.findElement(By.xpath("//*[text()='Privacy']"));

		// Before hovering get the CSS value of element 
		String beforehover = underline.getCssValue("text-decoration");
		System.out.println("CSS Value Before Hovering => " +beforehover);

		// Perform mouse hover action using Actions class
		Actions action = new Actions(driver);
		action.moveToElement(underline).build().perform();
		
		//After hovering get the CSS value of element to check whether it is underlined or not
		String afterHover = underline.getCssValue("text-decoration");

		System.out.println("CSS Value After Hovering =>" +afterHover);

	}

}
