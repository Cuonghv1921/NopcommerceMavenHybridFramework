package pageObject.userPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserLogInPageUI;

public class UserLogInPageObject extends BasePage {
    private WebDriver driver;
    public UserLogInPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter value to Email text box {0}")
    public void inputToEmailTextbox(String textValue) {
        sendKeyToElement(UserLogInPageUI.EMAIL_TEXTBOX, textValue);
    }

    @Step("Enter value to Password text box {0}")
    public void inputToPasswordTextbox(String textValue) {
        sendKeyToElement(UserLogInPageUI.PASSWORD_TEXTBOX, textValue);
    }

    @Step("Click to Login button")
    public void clickToLoginButton() {
        clickToElement(UserLogInPageUI.LOGIN_BUTTON);
    }

    @Step("Login successfully with Email = {0} and Password = {1}")
    public UserHomePageObject loginWithValidEmailAndPassword(String emailAddress, String password) {
        inputToEmailTextbox(emailAddress);
        inputToPasswordTextbox(password);
        clickToElement(UserLogInPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    @Step("Verify Email error message")
    public String getEmailErrorMsg() {
        return getElementText(UserLogInPageUI.EMAIL_ERROR_MSG);
    }

    @Step("Verify Summary error message")
    public String getSummaryErrorMsg() {
        return getElementText(UserLogInPageUI.SUMMARY_ERROR);
    }
}
