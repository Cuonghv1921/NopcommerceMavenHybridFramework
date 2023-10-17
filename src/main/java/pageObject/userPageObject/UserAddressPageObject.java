package pageObject.userPageObject;

import commons.BasePage;
import guiDataModel.DataModel.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
    private WebDriver driver;
    public static Address _Address;
    public UserAddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Add new Address button")
    public void clickToAddNewAddressButton() {
        clickToElement(UserAddressPageUI.ADD_NEW_BUTTON);
    }

    @Step("Enter to First name text box: {0}")
    public void inputToFirstNameTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.FIRST_NAME_TEXTBOX, textValue);
    }

    @Step("Enter to Last name text box: {0}")
    public void inputToLastNameTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.LAST_NAME_TEXTBOX, textValue);
    }

    @Step("Enter to Email text box: {0}")
    public void inputToEmailTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.EMAIL_TEXTBOX, textValue);
    }

    @Step("Enter to Company text box: {0}")
    public void inputToCompanyTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.COMPANY_TEXTBOX, textValue);
    }

    @Step("Select Country: {0}")
    public void selectCountryDropdown(String textValue) {
        selectItemDefaultDropdown(UserAddressPageUI.COUNTRY_DROPDOWN, textValue);
    }

    @Step("Select State / province: {0}")
    public void selectStateProvinceDropdown(String textValue) {
        selectItemDefaultDropdown(UserAddressPageUI.STATE_PROVINCE_DROPDOWN, textValue);
    }

    @Step("Enter to City text box: {0}")
    public void inputToCityTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.CITY_TEXTBOX, textValue);
    }

    @Step("Enter to Address 1 text box: {0}")
    public void inputToAddress1TextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.ADDRESS_1_TEXTBOX, textValue);
    }

    @Step("Enter to Address 2 text box: {0}")
    public void inputToAddress2TextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.ADDRESS_2_TEXTBOX, textValue);
    }

    @Step("Enter to PostCode text box: {0}")
    public void inputPostCodeTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.POST_CODE_TEXTBOX, textValue);
    }

    @Step("Enter to Phone number text box: {0}")
    public void inputToPhoneNumberTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.PHONE_NUMBER_TEXTBOX, textValue);
    }

    @Step("Enter to Fax number text box: {0}")
    public void inputToFaxNumberTextBox(String textValue) {
        sendKeyToElement(UserAddressPageUI.FAX_NUMBER_TEXTBOX, textValue);
    }

    @Step("Click to Save button")
    public void clickToSaveButton() {
        clickToElement(UserAddressPageUI.SAVE_BUTTON);
    }

    //Get data when adding data to all fields

    private String getFaxNumberValue() {
        return getElementAttribute(UserAddressPageUI.FAX_NUMBER_TEXTBOX, "value");
    }

    private String getPhoneNumberValue() {
        return getElementAttribute(UserAddressPageUI.PHONE_NUMBER_TEXTBOX, "value");
    }

    private String getPostCodeValue() {
        return getElementAttribute(UserAddressPageUI.POST_CODE_TEXTBOX, "value");
    }

    private String getAddress2Value() {
        return getElementAttribute(UserAddressPageUI.ADDRESS_2_TEXTBOX, "value");
    }

    private String getAddress1Value() {
        return getElementAttribute(UserAddressPageUI.ADDRESS_1_TEXTBOX, "value");
    }

    private String getCityValue() {
        return getElementAttribute(UserAddressPageUI.CITY_TEXTBOX, "value");
    }

    private String getStateProvinceValue() {
        return getFirstSelectedItemDefaultDropdown(UserAddressPageUI.STATE_PROVINCE_DROPDOWN);
    }

    private String getCountryValue() {
        return getFirstSelectedItemDefaultDropdown(UserAddressPageUI.COUNTRY_DROPDOWN);
    }

    private String getCompanyValue() {
        return getElementAttribute(UserAddressPageUI.COMPANY_TEXTBOX, "value");
    }

    private String getLastNameValue() {
        return getElementAttribute(UserAddressPageUI.LAST_NAME_TEXTBOX, "value");
    }

    private String getEmailValue() {
        return getElementAttribute(UserAddressPageUI.EMAIL_TEXTBOX, "value");
    }

    private String getFirstNameValue() {
        return getElementAttribute(UserAddressPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    //Get data after Add address successfully
    @Step("Get full name value")
    public String getSummaryFullNameValue() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_NAME);
    }

    @Step("Get Email value")
    public String getSummaryEmailValue() {
        return getTextExcludePrefix(getElementText(UserAddressPageUI.ADDRESS_SUMMARY_EMAIL));
    }

    @Step("Get Company value")
    public String getSummaryCompanyValue() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_COMPANY);
    }

    @Step("Get Country value")
    public String getSummaryCountryValue() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_COUNTRY);
    }

    @Step("Get City - State - Zip value")
    public String getSummaryCityStateZipValue() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_CITY_STATE_ZIP);
    }

    @Step("Get Address 1 value")
    public String getSummaryAddress1Value() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_ADDRESS_1);
    }

    @Step("Get Address 2 value")
    public String getSummaryAddress2Value() {
        return getElementText(UserAddressPageUI.ADDRESS_SUMMARY_ADDRESS_2);
    }

    @Step("Get Phone number value")
    public String getSummaryPhoneNumberValue() {
        return getTextExcludePrefix(getElementText(UserAddressPageUI.ADDRESS_SUMMARY_PHONE));
    }

    @Step("Get Fax number value")
    public String getSummaryFaxNumberValue() {
        return getTextExcludePrefix(getElementText(UserAddressPageUI.ADDRESS_SUMMARY_FAX));
    }

    @Step("Get add new address success message")
    public String getSummaryAddNewAddressSuccessMsg() {
        return getElementText(UserAddressPageUI.ADD_ADDRESS_SUCCESS_MSG);
    }

    @Step("Click to update address success message close button")
    public void clickAddressSuccessMsgCloseButton() {
        clickToElement(UserAddressPageUI.UPDATE_ADDRESS_SUCCESS_MSG_CLOSE_BUTTON);
    }

    @Step("Save data to data model")
    public void saveToDataModel() {
        _Address = new Address();
        _Address.setAddressFirstName(getFirstNameValue());
        _Address.setAddressLastName(getLastNameValue());
        _Address.setAddressFullName(getFirstNameValue() + " " + getLastNameValue());
        _Address.setAddressEmailAddress(getEmailValue());
        _Address.setAddressCompany(getCompanyValue());
        _Address.setAddressCountry(getCountryValue());
        _Address.setAddressCity(getCityValue());
        _Address.setAddressStateProvince(getStateProvinceValue());
        _Address.setAddressPostCode(getPostCodeValue());
        _Address.setAddressCityStateZip(getCityValue()
                + ", " + getStateProvinceValue() + ", " + getPostCodeValue());
        _Address.setAddressAddress1(getAddress1Value());
        _Address.setAddressAddress2(getAddress2Value());
        _Address.setAddressPhoneNumber(getPhoneNumberValue());
        _Address.setAddressFaxNumber(getFaxNumberValue());
    }

    public String getTextExcludePrefix(String textValue) {
        String[] splitText = textValue.split(":");
        return splitText[1].trim();
    }
}
