package pages.Activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStories {

    private AppiumDriver driver;

    public ActivityStories(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Follow']")
    private WebElement follow;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='volume on']")
    private WebElement volume;

    @FindBy(xpath = "//*[@name= 'postcamera' ]")
    private WebElement postCamera;

    @FindBy(xpath = "//*[@name= 'My Feed' ]")
    private WebElement myFeed;

    @FindBy(xpath = "//*[@name= 'Community' ]")
    private WebElement community;

    @FindBy(xpath = "//*[@name= 'What's New' ]")
    private WebElement whatNew;

    @FindBy(xpath = "//*[@name= 'All' ]")
    private WebElement allButton;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Activity'])[1]")
    private WebElement pageHeader;

    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=''])[1]")
    private WebElement firstStory;


    private boolean isEnabled() {
        return pageHeader.isEnabled();
    }

    private boolean isVisible() {
        return pageHeader.isDisplayed();
    }

    private void waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        System.out.println("pagesource" + driver.getPageSource());
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    private void click(WebElement webElement) {
        webElement.click();
    }

    public void verifyUserStories() {
        waitForVisibility(pageHeader);
        firstStory.click();
    }
}
