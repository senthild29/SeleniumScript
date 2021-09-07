package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		
		WebElement drophome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[14]/a/img"));
		drophome.click();
		
		// 1. Identifying the webelement dragggable
		WebElement drag = driver.findElement(By.id("draggable"));
		
		// 2. Identifying the webelement droppable
		WebElement drop = driver.findElement(By.id("droppable"));
		
		// In order to perform the drag and drop action, we have to use a class called Actions
		
		// 3.Creating object for Actions
		Actions dragdrop = new Actions(driver); // now control moved to drag and drop
		
		//4. 1st Method of drag and drop
		dragdrop.dragAndDrop(drag, drop).build().perform();
		
		// 5. 2nd method of drag and drop
		//dragdrop.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
		

	}

}
