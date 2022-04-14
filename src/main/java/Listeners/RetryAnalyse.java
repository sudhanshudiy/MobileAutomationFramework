package Listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyse implements IRetryAnalyzer {

    int retryCount =0;
    int maxCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxCount){
            retryCount++;
            return true;
        }
        return false;
    }
}