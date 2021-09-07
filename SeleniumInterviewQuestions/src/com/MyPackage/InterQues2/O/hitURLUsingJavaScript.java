package com.MyPackage.InterQues2.O;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hitURLUsingJavaScript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("window.location='https://en.wikipedia.org/wiki/Main_Page' ");
		driver.quit();
	}

}
