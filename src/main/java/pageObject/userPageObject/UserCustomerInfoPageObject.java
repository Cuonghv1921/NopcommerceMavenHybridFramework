package pageObject.userPageObject;

import commons.BasePage;
import guiDataModel.DataModel.CustomerInfor;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;
    public static CustomerInfor _CustomerInfor;
    public UserCustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Check to select Male gender")
    public void selectMaleGender() {
        checkToDefaultCheckboxRadio(UserCustomerInfoPageUI.GENDER_MALE_CHECKBOX);
    }

    @Step("Check to select Female gender")
    public void selectFemaleGender() {
        checkToDefaultCheckboxRadio(UserCustomerInfoPageUI.GENDER_FEMALE_CHECKBOX);
    }

    @Step("Enter to First name text box: {0}")
    public void inputToFirstNameTextbox(String textValue) {
        sendKeyToElement(UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, textValue);
    }

    @Step("Enter to Last name text box: {0}")
    public void inputToLastNameTextbox(String textValue) {
        sendKeyToElement(UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, textValue);
    }

    @Step("Select Date of Birth Day field: {0}")
    public void selectDobDayField(String day) {
        selectItemDefaultDropdown(UserCustomerInfoPageUI.DOB_DAY_DROPDOWN, day);
    }

    @Step("Select Date of Birth Month field: {0}")
    public void selectDobMonthField(String month) {
        selectItemDefaultDropdown(UserCustomerInfoPageUI.DOB_MONTH_DROPDOWN, month);
    }

    @Step("Select Date of Birth Year field: {0}")
    public void selectDobYearField(String year) {
        selectItemDefaultDropdown(UserCustomerInfoPageUI.DOB_YEAR_DROPDOWN, year);
    }

    @Step("Enter to Email text box: {0}")
    public void inputToEmailTextbox(String textValue) {
        sendKeyToElement(UserCustomerInfoPageUI.EMAIL_TEXTBOX, textValue);
    }

    @Step("Enter to Company name text box: {0}")
    public void inputToCompanyNameTextbox(String textValue) {
        sendKeyToElement(UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, textValue);
    }

    @Step("Check to select Newletter")
    public void checkToNewsletterCheckbox() {
        if (!isElementSelected(UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX)) {
            checkToDefaultCheckboxRadio(UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
        }
    }

    @Step("Click to Save button")
    public void clickToSaveButton() {
        clickToElement(UserCustomerInfoPageUI.SAVE_BUTTON);
    }

    //Get data to save to model
    @Step("Get selected gender")
    public String getSelectedGender() {
        if (isElementSelected(UserCustomerInfoPageUI.GENDER_MALE_CHECKBOX)) {
            return "Male";
        }
        return "Female";
    }

    @Step("Get first name value to verify")
    public String getFirstNameTextboxValue() {
        return getElementAttribute(UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get last name value to verify")
    public String getLastNameTextboxValue() {
        return getElementAttribute(UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Email value to verify")
    public String getEmailTextboxValue() {
        return getElementAttribute(UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    @Step("Get Company name value to verify")
    public String getCompanyNameTextboxValue() {
        return getElementAttribute(UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }

    @Step("Get date of birth")
    public String getDateOfBirthValue() {
        String dateOfBirth_Day = getFirstSelectedItemDefaultDropdown(UserCustomerInfoPageUI.DOB_DAY_DROPDOWN);
        String dateOfBirth_Month = getFirstSelectedItemDefaultDropdown(UserCustomerInfoPageUI.DOB_MONTH_DROPDOWN);
        String dateOfBirth_Year = getFirstSelectedItemDefaultDropdown(UserCustomerInfoPageUI.DOB_YEAR_DROPDOWN);
        return dateOfBirth_Day + "/" + dateOfBirth_Month + "/" + dateOfBirth_Year;
    }

    @Step("Verify new letter selected")
    public boolean isNewLetterSelected() {
        if (isElementSelected(UserCustomerInfoPageUI.GENDER_MALE_CHECKBOX)) {
            return true;
        }
        return false;
    }

    @Step("Save to data model to verify data of the page")
    public void saveToDataModel() {
        _CustomerInfor = new CustomerInfor();
        _CustomerInfor.setGender(getSelectedGender());
        _CustomerInfor.setFirstName(getFirstNameTextboxValue());
        _CustomerInfor.setLastName(getLastNameTextboxValue());
        _CustomerInfor.setDateOfbirth(getDateOfBirthValue());
        _CustomerInfor.setEmailAddress(getEmailTextboxValue());
        _CustomerInfor.setCompanyName(getCompanyNameTextboxValue());
        _CustomerInfor.setNewLetter(isNewLetterSelected());
    }

    @Step("Get update Customer info sucess message")
    public String getCustomerInfoUpdateSuccessMsg() {
        return getElementText(UserCustomerInfoPageUI.UPDATE_CUSTOMER_SUCCESS_MSG);
    }

    @Step("Click to Close update customer info success message")
    public void clickCustomerInfoSuccessMsgCloseButton() {
        clickToElement(UserCustomerInfoPageUI.UPDATE_CUSTOMER_SUCCESS_MSG_CLOSE_BUTTON);
    }
}
