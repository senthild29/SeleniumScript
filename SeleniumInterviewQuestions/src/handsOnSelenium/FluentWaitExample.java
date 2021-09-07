package handsOnSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import elementsRepo.ElementFluentWait;

public class FluentWaitExample {

	@Test
	public void TestFluentWait() throws IOException {

		FileInputStream File = new FileInputStream("configFile.properties");
		Properties getFile = new Properties();		
		getFile.load(File);

		String Prop = getFile.getProperty("BrowserProperty");
		String BrowLoc = getFile.getProperty("BrowserLocation");

		System.setProperty(Prop, BrowLoc);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/");
		driver.manage().window().maximize();

		PageFactory.initElements(driver, ElementFluentWait.class);

		ElementFluentWait.WaitForTextChangeHome.click();

		//Crerated object for Fluentwait using Wait Interface
		Wait<WebDriver> FluWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); //ensure we are selecting excpetion belongs to elenium(org.qa)

		//Create a new function to use condition, like we did use the builtin expectedCondition in ExplicitWait()
		//Pass WebDriver and WebElement to the function
		WebElement AlertBtn = FluWait.until(new Function<WebDriver, WebElement>() {

			//Hover the mouse on new Function and click on add Implemented Method to add the below lines
			//Note method apply is the default name we cannot change the name.
			//Pass WebDriver and driver and return the same
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath("//*[text()='Click ME!']"));
			}

		});

		//After wait click on button to get the alert
		AlertBtn.click();

		//Use alert interface to handle the alert
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.accept();		

	}

}
