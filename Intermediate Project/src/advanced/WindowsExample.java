package advanced;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		
		WebElement windowshome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[11]/a/img"));
		windowshome.click();
		
		String oldwindow = driver.getWindowHandle(); //It’s a method in selenium to find the current window(parent/old window).
		
		WebElement button1 = driver.findElement(By.id("home"));
		button1.click();
		
		Set<String>allwindow = driver.getWindowHandles(); //It's a method to find the old and newly opened windows(both parent and child windows)
		
		//To change the control to new pop-up window from old window we are using for each loop
		for (String popupwindow : allwindow) {
			driver.switchTo().window(popupwindow);
			}
		
		//Once jumped to pop-up window, we are clicking the editbox button and closing the pop-up windows        
        WebElement editbox = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
        Thread.sleep(2000);
        editbox.click();
        Thread.sleep(2000);
        driver.close(); 
        
     // To move the control back to old window
        driver.switchTo().window(oldwindow);
        
        // To find the count of opened windows
        WebElement button2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
        button2.click();
        int countofwindo= driver.getWindowHandles().size();       
        System.out.println("Count of opened windows is : "+countofwindo);
        
        // To close the newly opened windows, and not close old window
        WebElement button3 = driver.findElement(By.id("color"));
        button3.click();
         Thread.sleep(2000);
         
         Set<String> allwindow3 = driver.getWindowHandles(); // Method to find all windows new and old windows(both parent and child)
         for (String popup2 : allwindow3) {
          if(!popup2.equals(oldwindow)) {
        	  driver.switchTo().window(popup2); //Switching control to new window(child)
        	     Thread.sleep(2000);
        	driver.close();
        	}
			
	}
           
	}

}
