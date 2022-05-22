package pages;

import base.Interface.ILogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CommonPageActions;

import java.time.Duration;

public class PostPage implements ILogger {

    private AppiumDriver driver;
    private CommonPageActions pageActions;

    public PostPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
        pageActions = new CommonPageActions();
    }

    @FindBy(xpath = "//XCUIElementTypeImage[@name='post-comment']")
    private WebElement commentButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='post actions heart']")
    private WebElement mainLikeButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='global more']")
    private WebElement reportPost;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Post by kidiy']")
    private WebElement pageHeader;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='comments send']")
    private WebElement postComment;



    public void writeComment() {
        new CommonPageActions().TouchActions(driver, 78,758, 1);
    }
}
