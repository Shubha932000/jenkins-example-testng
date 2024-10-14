package com.planetpope.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing on test start
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Print success details
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Print failure details
        System.out.println("Test Failed: " + result.getName());
        System.out.println("Error Message: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Print skipped details
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Summary: Print passed, failed, skipped tests and total duration
        System.out.println("\n======= Test Summary =======");
        System.out.println("Total Passed: " + context.getPassedTests().size());
        System.out.println("Total Failed: " + context.getFailedTests().size());
        System.out.println("Total Skipped: " + context.getSkippedTests().size());
        System.out.println("Total Duration: " + (context.getEndDate().getTime() - context.getStartDate().getTime()) + " ms");

        // Print failed test case names
        if (context.getFailedTests().size() > 0) {
            System.out.println("\nFailed Tests:");
            context.getFailedTests().getAllResults().forEach(result -> {
                System.out.println(" - " + result.getName());
            });
        }
    }

    // Other listener methods can be left empty if not needed
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

    @Override
    public void onStart(ITestContext context) { }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) { }
}
