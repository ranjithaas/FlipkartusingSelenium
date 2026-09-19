package org.flipkart.Config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    public static final int MAX_RETRY = 5;
    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count  < MAX_RETRY){

            count++;
            System.out.println("Retrying test " + iTestResult.getName() + " with count " + count);
            return true;
        }
        return false;
    }
}
