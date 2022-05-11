package pages;

import base.Interface.ILogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KidsSignIn implements ILogger {

    private AppiumDriver driver;

    public KidsSignIn(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeTextField[@value= 'Nickname']")
    private WebElement nickName;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value= 'Password' ]")
    private WebElement password;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name= 'Kid Sign In' ]")
    private WebElement pageHeader;

    @FindBy(xpath = "//*[@name= 'Sign In']")
    private MobileElement SignIn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name= 'Full access. FREE for 14 days.']")
    private WebElement PreSignInHeader;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name= 'paywall-background']")
    private MobileElement payWallHeader;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name= 'DIY Highlights!']")
    private MobileElement diyHighLights;

    private boolean isEnabled() {
        return pageHeader.isEnabled();
    }

    private void waitForVisibility(WebElement pageHeader) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    private boolean waiting() {
        boolean isElementPresent;

        try {
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.visibilityOf(diyHighLights));
            MobileElement mobileElement = (MobileElement) driver.findElementByXPath(String.valueOf(diyHighLights));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void userName(String username) {
        nickName.sendKeys(username);
    }

    private void setPassword(String pass) {
        password.sendKeys(pass);
    }

    private void setSignIn() {
        SignIn.click();
    }

    private void waitBeforeClickingTrailButton() {
        waitForVisibility(pageHeader);
        isEnabled();
    }

    public void setPreSignIn() {
        if (waiting()) {
            setSignIn();
        } else {
            log.error("failed to locate the Sign In Element!!");
        }
    }

    public void enterDetails(String name, String password) {
        waitBeforeClickingTrailButton();
        userName(name);
        setPassword(password);
        setSignIn();
    }
}
