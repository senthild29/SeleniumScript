package advanced;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/*
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent; */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class UploadFileExample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/upload.html");

		Thread.sleep(3000);

		//Creating an Action class in order to click the "choose File" button using keyboard
		//Reason mouse action click() is not working on the webpage due to change in code.
		
		Actions buttonclick = new Actions(driver);
				
		WebElement button1 = driver.findElement(By.name("filename"));
		
		//Instructing code to click the "Choose File" button using keyboard.
		buttonclick.moveToElement(button1).click().build().perform();
		
		//Using stringselection class we are transferring the actual url to plain text
		StringSelection urlpath = new StringSelection("C:\\Users\\Senthil\\Downloads\\testleaf.xlsx");

		//Using ToolKit class we are setting content to clipboard, urlpath refers to transferred text
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(urlpath, null);

		// Creating new object for Robot inorder to perform keyboard action for windows based app/tool
		Robot copypasteactions = new Robot();

		// using this robot class doing keyboard action to press CTRL + V 
		copypasteactions.keyPress(KeyEvent.VK_CONTROL);
		copypasteactions.keyPress(KeyEvent.VK_V);
		

		// using this robot class doing keyboard action to Release CTRL + V in order to past the content
		copypasteactions.keyRelease(KeyEvent.VK_V);
		copypasteactions.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		
		// using this robot class doing keyboard action to Press and Release ENTER key in order to upload the file.
		copypasteactions.keyPress(KeyEvent.VK_ENTER);
		copypasteactions.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

	}

}
