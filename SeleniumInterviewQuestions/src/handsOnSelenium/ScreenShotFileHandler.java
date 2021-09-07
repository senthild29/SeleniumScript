package handsOnSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShotFileHandler {

	@Test
	public void SnapShotFileHandler() throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Alert.html");

		WebElement ConfirmBox = driver.findElement(By.xpath("//button[text()='Confirm Box']"));

		//Take Screen shot
		//Using TakesScreenShot interface we are going to take screen shot, assign driver 
		//Since driver is a WebDriver type, it cannot be saved into TakesScreenShot interface. So type cast the same in order to use it.
		TakesScreenshot screen = (TakesScreenshot) driver;

		//Using getScreenShotAs() get screen shot and save it in a FILE output type
		File getScreenShot = screen.getScreenshotAs(OutputType.FILE);

		//Create a object for File and mention the location of screen shot to be saved
		File PrintScreenShot = new File("F:\\Senthil\\Testing\\Tutorials\\Log Files\\FileHandlerScreenShot.jpg");
		
			//Using Selenium built-in Class FileHandler mention from and To parameters of screen shot file
		FileHandler.copy(getScreenShot, PrintScreenShot);

		ConfirmBox.click();


	}
}
