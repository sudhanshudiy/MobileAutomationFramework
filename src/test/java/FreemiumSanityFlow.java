import base.factories.DriverFactory;
import constants.DriverTypes;
import dataProviders.UserData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Activity.ActivityPage;
import pages.Courses.Courses;
import pages.FreemiumBlockerScreen;
import pages.FreemiumSignUpPage;
import util.CommonPageActions;

public class FreemiumSanityFlow {

    private AppiumDriver driver;

    @BeforeClass(description = "starting IOS Driver")
    public void startDriver() {
        driver = DriverFactory.initDriver(DriverTypes.IOS);
    }

    @Test(priority = 1, description = "Launch DIY app and verify home page", groups = "regression, sanity", alwaysRun = true)
    public void verifyHomePage() {
        FreemiumBlockerScreen freemiumBlockerScreen = new FreemiumBlockerScreen(driver);
        freemiumBlockerScreen.clickJoinInForFree();
    }

    @Test(priority = 2, description = "Launch DIY app and verify home page", groups = "regression, sanity", alwaysRun = true,
            dataProviderClass = UserData.class, dataProvider = "singUpDetails")
    public void verifyFreemiumSignUpPage(String firstname, String dob, String signupname, String password, String email) {
        FreemiumSignUpPage freemiumSignUpPage = new FreemiumSignUpPage(driver);
        freemiumSignUpPage.signUpWithDetails(firstname, dob, signupname, password, email);
        freemiumSignUpPage.tapJoinNow();
    }

    @Test(priority = 3, description = "Verify all the restrictions for a freemium user", groups = "regression, sanity", alwaysRun = true,
            dataProviderClass = UserData.class, dataProvider = "singUpDetails")
    public void verifyFreemiumRestrictions(String firstname, String dob, String signupname, String password, String email) {
        Courses courses = new Courses(driver);
        courses.verifyCoursesPageHeader();
        ActivityPage activityPage = new ActivityPage(driver);
        activityPage.verifyPageAndPost();
        CommonPageActions.paywallScreen(driver);
    }
}
