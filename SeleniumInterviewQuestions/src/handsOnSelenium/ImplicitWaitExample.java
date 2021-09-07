package handsOnSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitWaitExample {
	
	@Test
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.navigate().to("https://www.india.gov.in/online-registration");
		String oldwindow = driver.getWindowHandle();
		
		WebElement Register = driver.findElement(By.xpath("//*[text()='Register']"));
		Register.click();
		
		WebElement UN = driver.findElement(By.id("edit-name"));
		UN.sendKeys("TestUser");
		
		WebElement PWD = driver.findElement(By.id("edit-mail"));
		PWD.sendKeys("admin1");
		
		WebElement svcIcn = driver.findElement(By.xpath("//a[@class='howDiID']/child::img[1]"));
		svcIcn.click();
		
		Set<String> NewWindow = driver.getWindowHandles();
		
		for (String popup : NewWindow) {
			driver.switchTo().window(popup);
				}
		
		WebElement txtbox = driver.findElement(By.id("kw"));
		txtbox.sendKeys("Vaccine"+Keys.ENTER);
		
		driver.navigate().back();
		WebElement btn2 = driver.findElement(By.xpath("//a[contains(text(), 'Services from')]"));
		btn2.click();
		
		driver.switchTo().window(oldwindow);
		driver.quit();
	}

}
