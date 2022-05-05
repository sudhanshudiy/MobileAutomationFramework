package base.Listeners;

import base.factories.DriverFactory;
import base.Interface.ILogger;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class MobileListener implements ITestNGListener, ITestListener, IAnnotationTransformer, ISuiteListener, IReporter, ILogger {

    @Override
    public void onTestStart(ITestResult result) {
        log.info(" starting suite ...........::::" + result.getName() + " and started at in milliSeconds ::" + result.getStartMillis());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
       // Set<ITestResult> iTestResultSet = result.getTestContext().getFailedTests().getAllResults();
        //System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        AppiumDriver driver = DriverFactory.initDriver(DriverTypes.ANDROID);
        if (driver instanceof WebDriver) {
         //   System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveFailureScreenShot(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("total test cases skipped :::" + result.getSkipCausedBy().size());
        Set<ITestResult> iTestResultSet = result.getTestContext().getSkippedTests().getAllResults();
        if (!iTestResultSet.isEmpty()) {
            Set<ITestResult> set = result.getTestContext().getSkippedTests().getAllResults();
          //  set.stream().forEach();
        }
    }


    @Override
    public void onFinish(ISuite suite) {
        log.info("Finishing test case for the test suite.......:::: " + suite.getName().toUpperCase());
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.isSuccess())
            log.info("Test Passed successfully");
        else{
            log.error("Test failed ::: " + result.getTestContext().getFailedTests());
        }
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        xmlSuites.forEach(System.out::println);
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (isTestConfigured(annotation))
            annotation.setAlwaysRun(true);
        annotation.setRetryAnalyzer(RetryAnalyse.class);
    }


    /**
     * @param iTestAnnotation
     * @return
     */
    private boolean isTestConfigured(ITestAnnotation iTestAnnotation) {
        return iTestAnnotation.getAlwaysRun();
    }

    @Attachment
    public byte[] saveFailureScreenShot(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void getTestMethodName(ITestResult iTestResult){
        Set<ITestResult> iTestResultSet = iTestResult.getTestContext().getFailedTests().getAllResults();
        iTestResultSet.stream().forEach(System.out::println);
    }
}
