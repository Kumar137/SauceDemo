package com.saucedemo.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

public class Listener implements ISuiteListener, ITestListener {

    public ExtentReports rep = ExtentManager.getInstance();
    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentManager.test = rep.startTest(result.getName().toUpperCase());
        System.out.println(ExtentManager.test.getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentManager.test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
        rep.endTest(ExtentManager.test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentManager.test.log(LogStatus.INFO,result.getThrowable());
        ExtentManager.test.log(LogStatus.FAIL, ExtentManager.test.addScreenCapture(GenericUtils.takeScreenshot(result.getTestName()+""+result.getEndMillis())));
        rep.endTest(ExtentManager.test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentManager.test.log(LogStatus.SKIP, result.getThrowable());
        rep.endTest(ExtentManager.test);
        rep.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
