package advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompletionExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		
		// Selecting Auto completion home 
		
		WebElement autohome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[17]/a/img"));
		autohome.click();
		
		// Identifying textbox 
		
		WebElement textbox = driver.findElement(By.id("tags"));
		textbox.sendKeys("a");
        Thread.sleep(3000);
		
		// Identifying the list of elements inside text box and grouping the same
		List<WebElement>listelements = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
		System.out.println("Number of items in the list : "+listelements.size());
		
		
		for (WebElement webElement : listelements) {
			if (webElement.getText().equals("Protractor")) {
				webElement.click();
				break;
			}
		}
		
		

	}

}
