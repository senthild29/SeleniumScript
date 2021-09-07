package handsOnSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.runtime.Location;


public class RefreshBrowserEg {

	FileInputStream File;
	Properties prop;
	WebDriver driver;

	@Test
	public void RefreshPage() throws IOException, AWTException {

		File = new FileInputStream("configFile.properties");
		prop = new Properties();

		prop.load(File);

		String BrowProp = prop.getProperty("BrowserProperty");
		String BrowLoc = prop.getProperty("BrowserLocation");

		System.setProperty(BrowProp, BrowLoc);
		driver = new ChromeDriver();		
		//driver.navigate().to("https://www.google.co.in/");

		driver.get("https://www.google.co.in/");

		WebElement txtBox = driver.findElement(By.name("q"));
		txtBox.sendKeys("Weather in Chennai");

		//Method# 1 Refresh browser using navigate().refresh()
		driver.navigate().refresh();

		//Method# 2 Refresh the browser using driver.getCurrentUrl()
		driver.get(driver.getCurrentUrl());


		//Method 3 Using JavaScriptExecutor		
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		exec.executeScript("history.go(0)");


		//Method# 4 Using Robot Class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5); robot.keyRelease(KeyEvent.VK_F5);

	}
}
