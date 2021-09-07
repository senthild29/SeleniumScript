package handsOnSelenium;

import org.testng.annotations.Test;

public class ExecTestCaseMulti {

	@Test(invocationCount = 4)
	public void MultipleTimes() {
		System.out.println("Hello World");
	}
}
