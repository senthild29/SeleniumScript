package handsOnSelenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunIRetryAnalyzer implements IRetryAnalyzer {
	
	
	int retryCount =0;
	int maxlimit= 3;

	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount<maxlimit) {
			retryCount++;
			return true;
		}
		
		return false;
	}

}
