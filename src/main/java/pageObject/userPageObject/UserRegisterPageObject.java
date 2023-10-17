package pageObject.userPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;
    public UserRegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void createAccount() {
        inputToFirstNameTextbox("Test");
        inputToLastNameTextbox("User");
        inputToEmailTextbox(GlobalConstants.EMAIL_ADDRESS);
        inputToPasswordTextbox(GlobalConstants.PASSWORD);
        inputToConfirmPasswordTextbox(GlobalConstants.PASSWORD);
        clickToRegisterButton();
    }

    @Step("Click to 'Male' Checkbox")
    public void checkToMaleCheckbox() {
        checkToDefaultCheckboxRadio(UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name text box with value: {0}")
    public void inputToFirstNameTextbox(String textValue) {
        sendKeyToElement(UserRegisterPageUI.FIRSTNAME_TEXTBOX, textValue);
    }

    @Step("Enter to Last Name text box with value: {0}")
    public void inputToLastNameTextbox(String textValue) {
        sendKeyToElement(UserRegisterPageUI.LASTNAME_TEXTBOX, textValue);
    }

    @Step("Enter to Email text box with value: {0}")
    public void inputToEmailTextbox(String textValue) {
        sendKeyToElement(UserRegisterPageUI.EMAIL_TEXTBOX, textValue);
    }

    @Step("Enter to Password text box with value: {0}")
    public void inputToPasswordTextbox(String textValue) {
        sendKeyToElement(UserRegisterPageUI.PASSWORD_TEXTBOX, textValue);
    }

    @Step("Enter to Confirm Password text box with value: {0}")
    public void inputToConfirmPasswordTextbox(String textValue) {
        sendKeyToElement(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, textValue);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Verify First Name error message display")
    public String getFirstNameErrorMsg() {
        return getElementText(UserRegisterPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
    }

    @Step("Verify Last Name error message display")
    public String getLastNameErrorMsg() {
        return getElementText(UserRegisterPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
    }

    @Step("Verify Email error message display")
    public String getEmailErrorMsg() {
        return getElementText(UserRegisterPageUI.EMAIL_REQUIRED_ERROR_MSG);
    }

    @Step("Verify Password error message display")
    public String getPasswordErrorMsg() {
        return getElementText(UserRegisterPageUI.PASSWORD_REQUIRED_ERROR_MSG);
    }

    @Step("Verify Confirm Password error message display")
    public String getConfirmPasswordErrorMsg() {
        return getElementText(UserRegisterPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
    }

    @Step("Verify common error message display")
    public String getCommonErrorMsg() {
        return getElementText(UserRegisterPageUI.COMMON_ERROR_MSG);
    }

    @Step("Verify Register success message display")
    public String getRegisterSuccessMsg() {
        return getElementText(UserRegisterPageUI.REGISTER_SUCCESS_MSG);
    }
}
