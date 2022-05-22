package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import util.CommonPageActions;

import java.time.Duration;

public class FreemiumBlockerScreen {

    private AppiumDriver driver;
    private CommonPageActions pageActions;

    public FreemiumBlockerScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
        pageActions = new CommonPageActions();
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    private WebElement signIn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Join for FREE']")
    private WebElement joinButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='The Social learning app for Kids']")
    private WebElement pageHeader;

    private void waitForVisibility(WebElement pageHeader) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }


    private void joinInFree() {joinButton.click();}

    public void clickJoinInForFree(){
        pageHeader.isEnabled();
        //Join In Free button Coordinates
        pageActions.TouchActions(driver, 209, 766, 2);
    }

    public void clickSignIn(){
        waitForVisibility(pageHeader);
        pageHeader.isEnabled();
        //Sign In Free button Coordinates
        pageActions.TouchActions(driver, 59, 766, 2);
    }
}
