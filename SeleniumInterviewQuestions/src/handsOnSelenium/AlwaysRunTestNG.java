package handsOnSelenium;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class AlwaysRunTestNG {

	@Test(timeOut = 1000)
	public void WaitForPromotion() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Promotion Granted");
	}
	
	//using alwaysRun attribute, below method is executed even dependent method did fail
	@Test(dependsOnMethods = "WaitForPromotion", alwaysRun = true)
	public void SwithCompany() {
		System.out.println("Joined new Company");
	}
}
