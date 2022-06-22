import base.BaseTest;
import base.factories.DriverFactory;
import constants.DriverTypes;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Activity.ActivityPage;
import pages.Activity.ActivityUserStories;
import pages.Library.Library;
import pages.Freemium.DiyPlus;
import pages.Freemium.FreemiumBlockerScreen;
import pages.Freemium.ParentDetailsOnTrial;
import pages.Freemium.PaywallScreen;
import pages.NonLogged.KidsSignIn;

public class FreemiumE2E extends BaseTest {

    private AppiumDriver driver;
    private Library library;
    private ActivityPage activityPage;
    private ActivityUserStories activityUserStories;

    @BeforeClass(description = "starting IOS Driver")
    @Attachment
    @Step("Initialise Appium Driver")
    public void startDriver() {
        driver = DriverFactory.initDriver(DriverTypes.IOS);
        library = new Library(driver);
        activityPage = new ActivityPage(driver);
        activityUserStories = new ActivityUserStories(driver);
    }

    @Test(priority = 1, description = "Launch DIY app and SignIn", groups = "regression, sanity", alwaysRun = true)
    @Severity(SeverityLevel.BLOCKER)
    @Attachment
    @Step("verify SignIn Actions")
    public void verifyHomePage() {
        FreemiumBlockerScreen freemiumBlockerScreen = new FreemiumBlockerScreen(driver);
        freemiumBlockerScreen.clickSignIn();
    }

    @Test(priority = 2, description = "Launch DIY app and verify home page", groups = "regression, sanity", alwaysRun = true)
    @Severity(SeverityLevel.CRITICAL)
    @Attachment
    @Step("verify HomePage")
    public void verifyFreemiumSignUpPage() {
        KidsSignIn kidsSignIn = new KidsSignIn(driver);
        kidsSignIn.enterDetails("freemium1122", "123456");
    }

    @Test(priority = 3, description = "Verify all the restrictions on Activity Page", groups = "regression, sanity", alwaysRun = true/*,
            dataProviderClass = UserData.class, dataProvider = "singUpDetails"*/)
    @Severity(SeverityLevel.CRITICAL)
    @Attachment
    @Step("verify Freemium Cases")
    public void verifyFreemiumRestrictionsOnActivityTab(/*String firstname, String dob, String signupname, String password, String email*/) {
        library.verifyPageHeader();
        activityPage.moveToPage();
        activityPage.verifyPageHeader();
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name='kidiy'])").click();
        activityUserStories.verifyUserStoryActions();
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name='kidiy'])").click();
        activityUserStories.volumeActions();
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name='kidiy'])").click();
        activityUserStories.likePost();
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name='kidiy'])").click();
        PaywallScreen paywallScreen = new PaywallScreen(driver);
        paywallScreen.verifyScreenAndClose();
        activityUserStories.commentingOnStory("STORY");
    }

    @Test(priority = 4, description = "Verify signup for trail flow", groups = "regression, sanity", alwaysRun = true/*,
            dataProviderClass = UserData.class, dataProvider = "singUpDetails"*/)
    @Severity(SeverityLevel.CRITICAL)
    @Attachment
    @Step("verify Freemium Cases")
    public void verifyFreemiumRestrictionsOnParentPage(/*String firstname, String dob, String signupname, String password, String email*/) {
        library.verifyPageAndClickStickyCTA();
        DiyPlus diyPlus = new DiyPlus(driver);
        diyPlus.verifyPageHeaderAndClick();
        ParentDetailsOnTrial parentDetailsOnTrial = new ParentDetailsOnTrial(driver);
        parentDetailsOnTrial.enterParentSignUpDetails("sudhanshu", "singh", "sudhanshu12@google.com");
    }
}
