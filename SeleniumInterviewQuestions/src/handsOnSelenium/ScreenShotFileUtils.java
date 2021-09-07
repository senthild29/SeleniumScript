package handsOnSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShotFileUtils {

	@Test
	public void ScreenShotFileUtils() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();

		WebElement AlertBox = driver.findElement(By.xpath("//button[text()='Alert Box']"));

		//SCreenShot Function
		//Using TakesScreenShot interface we are going to take screen shot, assign driver 
		//Since driver is a WebDriver type, it cannot be saved into TakesScreenShot interface. So type cast the same in order to use it.
		TakesScreenshot ScreenShot = (TakesScreenshot) driver;

		//Using getScreenshotAs() capturing screen shot and saving in a file.
		File getScreenShot = ScreenShot.getScreenshotAs(OutputType.FILE);

		//Using File class creating object and mentioned the path to save the screen shot file
		File pasteScreenShot = new File("F:\\Senthil\\Testing\\Tutorials\\Log Files\\FileUtilScreenShot.jpg");

		//Using FileUtils(common-io-pacjage)  mention from and To parameters of screen shot file to paste the contens
		FileUtils.copyFile(getScreenShot, pasteScreenShot);

		AlertBox.click();
	}

}
