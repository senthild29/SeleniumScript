package advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperlinksExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		// Clicking home page link
		WebElement homepage = driver.findElement(By.linkText("Go to Home Page"));
		homepage.click();
		Thread.sleep(2000);
		
		// going back to home page
		driver.navigate().back();
	
		// Finding where link is supposed to go without clicking it
		WebElement findlink = driver.findElement(By.partialLinkText("Find where"));
		String findele = findlink.getAttribute("href");
		System.out.println("Link goes to : "+findele);
		
		// Verifying whether the link is broken using getTitle()
		WebElement brokenlink = driver.findElement(By.partialLinkText("Verify"));
		brokenlink.click();
		
		String pagetitle = driver.getTitle();
		
		if(pagetitle.contains("404")) {
			
			System.out.println("This page you have trying to access is broken and getting :"+pagetitle);
		
		}
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		// Clicking another link to go to homepage
		WebElement homepage2= driver.findElement(By.linkText("Go to Home Page"));
		homepage2.click();
			
		// going back to home page
		driver.navigate().back();
		
		// Finding how many links are available in this web page
		List<WebElement> nooflinks = driver.findElements(By.tagName("a"));
		System.out.println("No of link in this web page : "+nooflinks.size());
				
		Thread.sleep(2000);
		
		//Closing browser
		driver.close();
	}

}
