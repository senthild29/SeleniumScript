package handsOnSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RerunFailedCases {

	@Test
	public void FirstTestCase() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void SecondTestCase() {
		Assert.assertEquals(false, true);
	}
}
