package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private AppiumDriver driver;

    public ProfilePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='diya05']")
    private WebElement userName;

    @FindBy(xpath = "XCUIElementTypeSearchField[@name='Search Nicknames or Hashtags']")
    private WebElement searchBar;

    @FindBy(xpath = "(//XCUIElementTypeImage[@name='profile-mode-gems'])[1]")
    private WebElement gems;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Button'])[1]")
    private WebElement accountSettings;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Button'])[2]")
    private WebElement postButton;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='profile-mode-gems'])[2]")
    private WebElement modGems;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='profile-mode-posts'])[2]")
    private WebElement modPosts;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='profile-mode-followers'])[2]")
    private WebElement modFollowers;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='profile-mode-likes'])[2]")
    private WebElement modLikes;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='profile-mode-achievements'])[2]")
    private WebElement modAchievements;

    //------------Profile Settings Actions------------

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Change Avatar']")
    private WebElement changeAvatar;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Edit Bio']")
    private WebElement editBio;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Change Password']")
    private WebElement changePassword;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Community Guidelines']")
    private WebElement communityGuidelines;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Privacy Policy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Parent Dashboard']")
    private WebElement parentDashBoard;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Switch User']")
    private WebElement switchUsers;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Rate Us ★★★★★']")
    private WebElement rateUs;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Sign Out All Users']")
    private WebElement signOutAllUsers;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name='Cancel']")
    private WebElement cancel;
    
    private boolean isEnabled() {
        return userName.isEnabled();
    }


    private void waitForVisibility(WebElement nfcElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(nfcElement));
    }

    private void clickNfc() {
        accountSettings.click();
    }

    public void waitBeforeClicking() {
        waitForVisibility(userName);
        isEnabled();
        clickNfc();
    }
}
