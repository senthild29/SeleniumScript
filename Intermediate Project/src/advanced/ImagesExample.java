package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImagesExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();

		
		WebElement imagehome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a/img"));
		imagehome.click();
		Thread.sleep(2000);

		WebElement image1 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));
		image1.click();
		Thread.sleep(2000);

		WebElement imagehome2= driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a/img"));
		imagehome2.click();
		Thread.sleep(2000);
		
		// Idenfity image is broken, we using CSS attribute "naturalWidth"
		WebElement imagebroken = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));

		//Using if condition to identify whether image is broken
		if(imagebroken.getAttribute("naturalWidth").equals("0")){
			System.out.println("Image is Broken");
		}
		else {
			System.out.println("Image is not broken");
		}
      
		Thread.sleep(2000);

		// Creating action class to click the image using keyboard
		Actions clickimage = new Actions(driver);

		// Identifying web element to click using keyboard
		WebElement image3 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img"));		
		clickimage.moveToElement(image3).click().build().perform();
		Thread.sleep(2000);
		driver.close();
	}

}
