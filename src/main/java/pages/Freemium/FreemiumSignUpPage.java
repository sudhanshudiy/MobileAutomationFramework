package pages.Freemium;

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
import java.util.List;

public class FreemiumSignUpPage {

    private AppiumDriver driver;
    private CommonPageActions pageActions;

    public FreemiumSignUpPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);
        pageActions = new CommonPageActions();
    }

    @FindBy(xpath = "//*[@value='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@value='Birthday']")
    private WebElement birthday;

    @FindBy(xpath = "//*[@value='Create a Username']")
    private WebElement createUser;

    @FindBy(xpath = "//*[@value='Create a Password']")
    private WebElement createPassword;

    @FindBy(xpath = "//XCUIElementTypeTextField[@value='Parent Email']")
    private WebElement parentEmail;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Learning is FREE on DIY']")
    private WebElement pageHeader;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    private WebElement datePickerDone;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private WebElement datePickerCancel;


    private void waitForVisibility(WebElement pageHeader) {
        System.out.println(driver.getPageSource());
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    /**Free User sign up details
     * @param firstname
     * @param birthDay
     * @param userName
     * @param password
     * @param parentemail
     */
    public void signUpWithDetails(String firstname, String birthDay, String userName, String password, String parentemail){
        waitForVisibility(pageHeader);
        pageHeader.isEnabled();
        firstName.sendKeys(firstname);
        new CommonPageActions().singleTapAction(driver, birthday);
        List<WebElement> list =  driver.findElementsByXPath("//XCUIElementTypePicker");
        list.stream().forEach(System.out::println);
        /*birthday.sendKeys(birthDay);
        createUser.sendKeys(userName);
        createPassword.sendKeys(password);
        parentEmail.sendKeys(parentemail);
        driver.hideKeyboard();*/
    }

    public void tapJoinNow(){
        //Tap on join Now button
        pageActions.TouchActions(driver, 159, 776, 2);
    }
}
