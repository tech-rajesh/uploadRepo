package hrmLogin;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogicExample implements IRetryAnalyzer {

	
	int counter = 0;
	int retryCount = 2;   //how many retry
	
	
	public boolean retry(ITestResult result) {
		
	
		if(counter < retryCount) {
			
			counter++;
			return true;
		}
		
		
		
		return false;
	}

	
	
	
	
}
