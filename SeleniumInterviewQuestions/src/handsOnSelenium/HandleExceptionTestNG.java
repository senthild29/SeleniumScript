package handsOnSelenium;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class HandleExceptionTestNG {

	@Test(timeOut = 1000, expectedExceptions = ThreadTimeoutException.class)
	public void HandleException() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Hello World");
	}
}
