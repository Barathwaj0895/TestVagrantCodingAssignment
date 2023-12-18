package main.java.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * This class has been created by Barathwaj Ravisankar on May 12, 2022
 * This class has been modified by Barathwaj Ravisankar on December 18, 2023
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while (count < retryCount) {
            count++;
            // Allow for multiple retries
            return true;
        }
        // Retry count exceeded, return false
        return false;
    }
}
