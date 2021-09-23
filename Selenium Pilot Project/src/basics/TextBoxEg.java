package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxEg {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Edit.html");
			
	}
	
	@Test
	public void ExploreEditBtn() {
		// Enter text
		WebElement emailBox = driver.findElement(By.id("email"));
		emailBox.sendKeys("test@gmail.com");

		// Append a text
		WebElement ApndBox = driver.findElement(By.xpath("//input[@type='text'][@value='Append ']"));
		ApndBox.sendKeys("Successfully");

		// Get Text
		WebElement getTxt = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		String TxtBoxMsg = getTxt.getAttribute("value");
		System.out.println("Text present in text box => " + TxtBoxMsg);

		// Clear Text
		WebElement ClrTxt = driver.findElement(By.xpath("//input[@value='Clear me!!']"));
		ClrTxt.clear();

		// Check Txt Box is enabled
		WebElement ChkDsbl = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean isenab = ChkDsbl.isEnabled();	
		System.out.println("Does Check box is enabled => "+isenab);
	}

	@AfterTest
	public void CloseBrow() {
		driver.quit();
	}
}
