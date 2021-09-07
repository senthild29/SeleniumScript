package advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		
		WebElement selectablehome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[15]/a/img"));
		selectablehome.click();
		
		List<WebElement> selectables = driver.findElements(By.xpath("//*[@id=\"selectable\"]/li"));
		
		// 1. Creating an Action class, in order to interact using Keyboard or Mouse
		Actions selectitems = new Actions(driver);
		
		// there are 2 ways we can achieve this, using Keyboard and Using Mouse
		//2. Using Keyboard
		selectitems.keyDown(Keys.CONTROL).click(selectables.get(0)).click(selectables.get(2)).click(selectables.get(4)).build().perform();
		
		//3. Using Mouse
		selectitems.clickAndHold(selectables.get(1));
		selectitems.clickAndHold(selectables.get(3));
		selectitems.build().perform();
		

	}

}
