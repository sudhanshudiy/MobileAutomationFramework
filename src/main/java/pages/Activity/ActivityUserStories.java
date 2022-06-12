package pages.Activity;

import base.Interface.ILogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityUserStories implements ILogger {

    private AppiumDriver driver;

    public ActivityUserStories(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Follow']")
    private WebElement followUser;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Following']")
    private WebElement followingUser;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='volume on']")
    private WebElement volumeOn;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='volume off']")
    private WebElement volumeOff;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='global close']")
    private WebElement globalClose;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='post actions heart']")
    private WebElement likeStory;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='post actions comment']")
    private WebElement commentStory;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='global more']")
    private WebElement additionalOptions;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='comments send']")
    private WebElement commentSend;

    private void waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void verifyUserStoryActions() {
        log.info("Performing free user story actions .......:---:....");

        //Following or follow user
        if (followUser.isDisplayed()){followUser.click();}
        else {followingUser.click();}

        //Volume on and Off
        if (volumeOn.isEnabled()){volumeOn.click();}
        else {volumeOff.click();}

        //like on story
        likeStory.click();
    }

    private void commentingOnStory(){
        commentStory.click();
        commentStory.sendKeys("Testing Freemium User comment action");
        commentSend.click();
    }
}
