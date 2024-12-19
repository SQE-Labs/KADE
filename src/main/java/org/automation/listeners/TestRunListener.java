package org.automation.listeners;


import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.utilities.Screenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.*;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public final class TestRunListener extends BaseTest implements ITestListener, ISuiteListener,   IRetryAnalyzer{

    private static final int maxRetryCount = 3;
    private int retryCount = 2;

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Execution of the test [" + result.getName() + "] started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test [" + result.getName() + "] passed");
        result.setAttribute("SuccessScreenshot", Screenshot.takeScreenShot("Success_" + result.getName()));
        if (Boolean.getBoolean("remoteDriver")) {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript(
                    "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\"}}");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Log.error("Test [" + result.getName() + "] failed", result.getThrowable());
        result.setAttribute("failureScreenshot", Screenshot.takeScreenShot("Failure_" + result.getName()));
        if (Boolean.getBoolean("remoteDriver")) {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript(
                    "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\"}}");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test [" + result.getName() + "] skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.error("Test [" + result.getName() + "] failed within success percentage", result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("About to begin executing Test [" + context.getName() + "]");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("About to end executing Test [" + context.getName() + "]");
        extent.setSystemInfo(context.getName(), getPassPercentage(context) + "%");
        extent.flush();
    }

    @Override
    public void onStart(ISuite suite) {
        Log.info("About to begin executing Suite [" + suite.getName() + "]");
    }

    @Override
    public void onFinish(ISuite suite) {
        Log.info("About to end executing Suite [" + suite.getName() + "]");

    }

    private int getPassPercentage(ITestContext context) {
        int totalTests = context.getAllTestMethods().length;
        int passedTests = context.getPassedTests().size();
        return (passedTests * 100) / totalTests;
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;  // Indicate to retry the test
        }
        return false; // Do not retry after max attempts
    }
}

