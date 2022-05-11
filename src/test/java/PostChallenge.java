import base.BaseTest;
import base.factories.DriverFactory;
import constants.DriverTypes;
import dataProviders.UserData;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Courses;
import pages.KidsSignIn;

public class PostChallenge extends BaseTest {

    AppiumDriver driver;

    @BeforeClass
    @Step("Initialized IOS Driver")
    public void init(){
        driver = DriverFactory.initDriver(DriverTypes.IOS);
    }

    @Test(description = "login ", groups = "regression, sanity, smoke", enabled = true)
    @Step("User Logging In") @Severity(SeverityLevel.BLOCKER)
    public void login(){
        Courses courses = new Courses(driver);
        courses.nonLoggedUser();
    }

    @Test(description = " Move to Activity page", groups = "regression, sanity, smoke", dataProvider = "user credentials",
            dataProviderClass = UserData.class, enabled = true)
    @Step("Move to activity Page")
    public void activityPagePostSignIn(String username, String password) {
        KidsSignIn kidsSignIn = new KidsSignIn(driver);
        kidsSignIn.setPreSignIn();
        kidsSignIn.enterDetails(username, password);
    }
}
