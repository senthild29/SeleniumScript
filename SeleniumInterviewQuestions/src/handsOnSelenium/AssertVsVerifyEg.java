package handsOnSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertVsVerifyEg {

	@AfterTest
	public void assertEg() { //Hard Assertion
		
		System.out.println("Before Assertion");
		Assert.assertEquals(true, false);// Assert.fail();
		System.out.println("After Assertion");
	}
	
	@Test
	public void VerifyEg() { // Soft Assertion
		System.out.println("Before Soft Assertion/Verify");
		
		// Create object for SoftAssert
		SoftAssert asst = new SoftAssert();
		
		//Specify the condition using that object
		asst.assertEquals(true, false); // Assert.fail();
		
		System.out.println("After Soft Assertion/Verify");
	}
}
