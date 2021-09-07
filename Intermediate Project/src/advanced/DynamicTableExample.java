package advanced;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class DynamicTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Senthil\\Testing\\Selenium_Setup\\Drivers_2.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		// Finding no of columns using findElement by tagName "th" 
		List<WebElement> cols = driver.findElements(By.tagName("th"));
		int countcols = cols.size();
		System.out.println("No of Columns in this table is : "+countcols);
		
		// Finding no of rowss using findElement by tagName "tr" 
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println("No of Rows in this table is : "+rows.size());
		
		//Creating X-path for Dynamic values to get the progress value
		WebElement progvalue = driver.findElement(By.xpath("//td[normalize-space()=\"Learn to interact with Elements\"]//following::td[1]"));
		String getval = progvalue.getText();
		System.out.println("Progress Value of Learn to Interact with Elements is : "+getval);
		
		
		//Creating x-Path to get the list of values under progress tab
		List<WebElement> progresslist = driver.findElements(By.xpath("//td[2]"));
		
		//Creating new object to store the values converted to Integer from String
		List<Integer> storevalues = new ArrayList<Integer>();
		
		//Converting String to Integer Values and storing it to variable "storevalues" 
		for (WebElement webElement : progresslist) {
			String values = webElement.getText().replace("%", "");
			storevalues.add(Integer.parseInt(values));
		}
		System.out.println("List of Progress Value is : "+storevalues);
		
		//Finding least values using "collections" in Java and storing it in variable "smallvalue"
		int smallvalue = java.util.Collections.min(storevalues);
		System.out.println("Smallest num is : "+smallvalue);
		
		
		//Now converting the Integer to String in order to get the x-path and click the next cell of least value
		String convertedstring = Integer.toString(smallvalue)+"%";
		
		//Expected X-path //td[normalize-space()="30%"]//following::td[1]//input to click on check box. Derived from web page
		
		//Now creating our own X-path same as above, in order to check the correctness of x-path we are using print statement
		String findxpath = "//td[normalize-space()="+"\""+convertedstring+"\""+"]"+"//following::td[1]"+"//input";
		
		System.out.println(findxpath);
		
		//Once identified the correct x-path, clicking the checkbox
		WebElement chkbox = driver.findElement(By.xpath(findxpath));
		chkbox.click();
		
	}

}
