package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ButtonEG {
	
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrow() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Button.html");
			
	}
	
	@Test
	public void ExploreBtn() {
		// Find coordinates (X and Y) of button
		WebElement Btn1 = driver.findElement(By.id("position"));
		Point getLoc = Btn1.getLocation();
		int xpos = getLoc.getX();
		int ypos = getLoc.getY();
		System.out.println("X coordinate => "+xpos + " and Y coordinate => "+ypos);
		
		// Find color of a button
		WebElement Btn2 = driver.findElement(By.id("color"));
		String btncolor = Btn2.getCssValue("background-color");
		System.out.println("Color of Button is => "+btncolor);
		
		// Find size of a button
		WebElement Btn3 = driver.findElement(By.id("size"));
		Dimension getSize = Btn3.getSize();
		System.out.println("Height of button => "+getSize.getHeight());
		System.out.println("Width of button => "+getSize.getWidth());
	}
	
	@AfterTest
	public void CloseBrow() {
		driver.quit();
	}

}
