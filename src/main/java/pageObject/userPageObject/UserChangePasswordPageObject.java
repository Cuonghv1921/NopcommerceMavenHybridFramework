package pageObject.userPageObject;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
    private WebDriver driver;
    public UserChangePasswordPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Enter to Old password text box: {0}")
    public void inputToOldPasswordTextbox(String textValue) {
        sendKeyToElement(UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, textValue);
    }

    @Step("Enter to New password text box: {0}")
    public void inputToNewPasswordTextbox(String textValue) {
        sendKeyToElement(UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, textValue);
    }

    @Step("Enter to Confirm password text box: {0}")
    public void inputToConfirmPasswordTextbox(String textValue) {
        sendKeyToElement(UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, textValue);
    }

    @Step("Click to Change password button")
    public void clickToChangePasswordButton() {
        clickToElement(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    @Step("Get Change password success message")
    public String getChangePasswordSuccessMsg() {
        return getElementText(UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MSG);
    }

    @Step("Click to close change password success messsage")
    public void clickToChangePasswordSuccessCloseButton() {
        clickToElement(UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MSG_CLOSE_BUTTON);
    }
}
