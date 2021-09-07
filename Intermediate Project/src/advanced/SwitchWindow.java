package advanced;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.india.gov.in/online-registration");
		Thread.sleep(3000);
		
		String window1 = driver.getWindowHandle();
		
		WebElement servc = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a/img"));
		servc.click();
		
		Set<String> window2 = driver.getWindowHandles();
		for (String newindow : window2) {
			driver.switchTo().window(newindow);
			}
		Thread.sleep(2000);
      WebElement button1 = driver.findElement(By.className("state-services"));
      button1.click();
      driver.close();
      
      driver.switchTo().window(window1);
      
      WebElement singin = driver.findElement(By.className("loginlinks"));
      singin.click();
      
	}

}
