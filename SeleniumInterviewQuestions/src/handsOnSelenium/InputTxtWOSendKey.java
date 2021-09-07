package handsOnSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InputTxtWOSendKey {
	
	@Test
	public void InputText() throws AWTException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		WebElement SrchBox = driver.findElement(By.name("q"));
		
		JavascriptExecutor exec = (JavascriptExecutor)driver;
		
		//Method# 1 
		//Identify the element using driver.findElement(), send text using JavascriptExecutor Interface
		exec.executeScript("arguments[0].value='chennai' ", SrchBox);
			
		//Method# 2
		// Identify the element and send text using JavascriptExecutor Interface
		exec.executeScript("document.getElementsByName('q')[0].value='chennai' ", "");
		
		//Method# 3
		//Using Robot Class
		Robot act = new Robot();
		act.keyPress(KeyEvent.VK_H);
		act.keyRelease(KeyEvent.VK_H);
		act.keyPress(KeyEvent.VK_E);
		act.keyRelease(KeyEvent.VK_E);
		act.keyPress(KeyEvent.VK_L);
		act.keyRelease(KeyEvent.VK_L);
		act.keyPress(KeyEvent.VK_L);
		act.keyRelease(KeyEvent.VK_L);
		act.keyPress(KeyEvent.VK_O);
		act.keyRelease(KeyEvent.VK_O);
		
	}

}
