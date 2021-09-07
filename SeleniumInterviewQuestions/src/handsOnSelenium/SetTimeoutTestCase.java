package handsOnSelenium;

import org.testng.annotations.Test;

public class SetTimeoutTestCase {

	@Test(timeOut = 1000)
	public void CheckTimeOut() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Hello World");
	}
}
