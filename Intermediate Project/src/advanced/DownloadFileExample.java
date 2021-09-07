package advanced;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFileExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		
		WebElement downloadhome = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[18]/a/img"));
		downloadhome.click();
		Thread.sleep(2000);
		
		WebElement downloadexcel = driver.findElement(By.linkText("Download Excel"));
		downloadexcel.click();
		Thread.sleep(3000);
		
		//To confirm the file download, we have a class in Java called File	
		//Creating new object with file download location and variable name filelocation 
		File filelocation = new File("C:\\Users\\Senthil\\Downloads");
		
		//we have to get the list of files available/downloaded in the above path, using listFiles(), mtehod 
		File[] getallfiles = filelocation.listFiles(); //storing all available files in getallfiles  variable from the above location
		
		//Using for each loop, to identify our downloaded file 
		for (File file : getallfiles) {
			if (file.getName().equals("testleaf.xlsx")){
				System.out.println("File available in downloads");
				break;
			}
							
			}
			
		}
		
	}


