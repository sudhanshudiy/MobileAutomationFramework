package pages;

import base.Interface.ILogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CommonPageActions;

import java.time.Duration;

public class PaywallScreen implements ILogger {

    private AppiumDriver driver;
    private CommonPageActions pageActions;

    public PaywallScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
        pageActions = new CommonPageActions();
    }

    @FindBy(xpath = "//XCUIElementTypeWindow[@name='intercom window']")
    private WebElement intercomWindow;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Get DIY Plus']")
    private WebElement getDiyPlus;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='global close']")
    private WebElement closeButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Subscribe to DIY']")
    private WebElement pageHeader;


    public void verifyScreenAndClose() {

        if (pageHeader.isEnabled() && pageHeader.isDisplayed()) {

            log.info("Pay wall screen displayed");
            //Closing screen
            closeButton.click();
        }
    }
}
