package advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\\\Senthil\\\\Testing\\\\Selenium_Setup\\\\Drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		
		WebElement framehome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[10]/a/img"));
		framehome.click();
		
		driver.switchTo().frame(0); //Instructing script to switch from native browser to frames, since there is no attributes like(id, name) we are using giving zero(0)
		//refers to 1st frame.
		
		WebElement button1 = driver.findElement(By.id("Click"));
		button1.click();
		
		String gettext = driver.findElement(By.id("Click")).getText(); //getText is used to get the text of a button 
		System.out.println("Text inside click me button is : "+gettext);
		
		driver.switchTo().defaultContent(); // Switching back to native browser from frames 
				
		driver.switchTo().frame(1); //now instructing script to switch to the 1st frame
		
		driver.switchTo().frame("frame2"); //since it's a nested frame, we are navigating to frame(nested frame) inside a frame
		WebElement button2 = driver.findElement(By.id("Click1"));
		button2.click();
		
		// To identify the number of frames in a webpage/HTML script, we have to use fineElements()
		driver.switchTo().defaultContent(); // Switching back to native browser
		
		List<WebElement> noofframes = driver.findElements(By.tagName("iframe"));
		int framescount = noofframes.size();
		System.out.println("Total no of Frames in this page is : "+framescount);
		
		
		
		
		

	}

}
