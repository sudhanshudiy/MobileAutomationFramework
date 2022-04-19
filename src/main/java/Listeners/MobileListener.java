package Listeners;

import Interface.ILogger;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class MobileListener implements ITestNGListener, ITestListener, IAnnotationTransformer, ISuiteListener, IReporter, ILogger{

    @Override
    public void onTestStart(ITestResult result) {
        log.info(" starting suite ...........::::" + result.getName() + " and started at in milliSeconds ::" + result.getStartMillis());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("total test cases skipped :::" + result.getSkipCausedBy().size());
        Set<ITestResult> iTestResultSet = result.getTestContext().getSkippedTests().getAllResults();
        if (!iTestResultSet.isEmpty()){
            iTestResultSet.forEach(System.out::println);
        }
    }


    @Override
    public void onFinish(ISuite suite) {
        log.info("Finishing test case for the test suite.......:::: " + suite.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
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
    private boolean isTestConfigured(ITestAnnotation iTestAnnotation){
        return iTestAnnotation.getAlwaysRun();
    }
}
