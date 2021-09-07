package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipEXample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/home.html");
		
		WebElement tooltiphome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[20]/a/img"));
		tooltiphome.click();
		
		WebElement textbox = driver.findElement(By.id("age"));
		String gettooltip = textbox.getAttribute("title");
		System.out.println("Tool tip of textbox is : "+gettooltip);
		

	}

}
