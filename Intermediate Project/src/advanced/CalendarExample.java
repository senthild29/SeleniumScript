package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Calendar.html");
		driver.manage().window().maximize();
		
		// Different ways to select a date using calendar
		
		// 1st Method, If we have textbox, we can enter the date using sendKeys
	/* WebElement txtbx = driver.findElement(By.id("datepicker"));
		txtbx.sendKeys("04/10/2021"+Keys.ENTER); */
		
		//2nd Method by finding elements using locators like id, name, xpath.. etc
		WebElement txtbx = driver.findElement(By.id("datepicker"));
		txtbx.click();
		
		WebElement nxtbtn = driver.findElement(By.xpath("//a[@title ='Next']"));
		nxtbtn.click();
		
		WebElement selectdt = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[7]/a"));
		selectdt.click();
		

	}

}
