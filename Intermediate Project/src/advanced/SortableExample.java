package advanced;

import java.awt.ItemSelectable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SortableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		
		Actions moveitem = new Actions(driver);
		
	
		List<WebElement>  items = driver.findElements(By.xpath("//*[@id=\"sortable\"]/li"));
		System.out.println("no of items in the list "+items.size()); 
		
		// Method 1 storing the element in a variable which we gonna drag and drop
		WebElement fromelement = items.get(6);
		WebElement toelement = items.get(0);
		
		moveitem.clickAndHold(fromelement).moveToElement(toelement).release(fromelement).build().perform();
		// OR
		
		/*moveitem.moveToElement(toelement);
		moveitem.release(fromelement);
		moveitem.build().perform();*/
		
		// Method 2, using variable(items) which declared to find list of items.
		 //and declaring the items to be moved to index (0), (1).. etc  inside dragAndDrop ()
		moveitem.dragAndDrop(items.get(6), items.get(0)).build().perform();
		
		
		

		
			
			
		
		

	}

}
