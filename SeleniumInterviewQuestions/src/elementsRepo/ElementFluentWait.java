package elementsRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementFluentWait {

	@FindBy(xpath = "//*[text()='Wait for Text Change']/following-sibling::*")
	public static WebElement WaitForTextChangeHome;
	
	@FindBy(id = "alert")
	public static WebElement ClickAlert;
}
