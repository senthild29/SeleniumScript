package handsOnSelenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShotRobotClass {
	
	@Test
	public void ScreenShotRobot() throws AWTException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("http://www.leafground.com/pages/Alert.html");
				
		WebElement AlertBox = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		AlertBox.click();
		
		//Screen Shot Using Robot Class(java.awt) package
		
		//Create  new object for Robot(java.awt) class
		Robot act = new Robot();
		
		//Get the screensize using Toolkit class and store it in a Dimension
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Create object for Rectangle class and assign variable of dimension.
		Rectangle getscreen = new Rectangle(screensize);
		
		//Like getScreenshotAs() used in FileUtils/FileHanlder, using createScreenCapture() capture the screen shot
		BufferedImage printScreen = act.createScreenCapture(getscreen);
		
		//Create a object for File class(java.io) and mention the path of screen shot to be saved
		File PasteToFile = new File("F:\\Senthil\\Testing\\Tutorials\\Log Files\\RobotScreenShot.jpg");
		
		//Using ImageIO.write(), pass the source file, file format and destination file to print the screen shot
		ImageIO.write(printScreen, "jpg", PasteToFile);
		
	}

}
