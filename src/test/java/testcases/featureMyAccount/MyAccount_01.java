package testcases.featureMyAccount;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.userPageObject.*;
import utilities.DataFakerHelper;

import static pageObject.userPageObject.UserAddressPageObject._Address;
import static pageObject.userPageObject.UserCustomerInfoPageObject._CustomerInfor;
import static pageObject.userPageObject.UserProductDetailsPageObject._ProductDetails;
import static pageObject.userPageObject.UserProductReviewPageObject._ProductReview;

public class MyAccount_01 extends BaseTest {

    private WebDriver driver;
    private DataFakerHelper dataHelper;
    private String firstName, lastName, dob_Day, dob_Month, dob_Year, emailAddress, companyName,
            country, state, city, address1, address2, postcode, phoneNumber, faxNumber, password,
            reviewtitle, reviewBody;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLogInPageObject userLogInPageObject;
    private UserMyAccountPageObject userMyAccountPageObject;
    private UserCustomerInfoPageObject userCustomerInfoPageObject;
    private UserAddressPageObject userAddressPageObject;
    private UserChangePasswordPageObject userChangePasswordPageObject;
    private UserCategoriesPageObject userCategoriesPageObject;
    private UserDesktopProductPageObject userDesktopProductPageObject;
    private UserProductDetailsPageObject userProductDetailsPageObject;
    private UserProductReviewPageObject userProductReviewPageObject;
    private UserMyProductReviewPageObject userMyProductReviewPageObject;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        dataHelper = DataFakerHelper.getDataFakerHelper();
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();
        userRegisterPageObject.createAccount();
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userLogInPageObject = userHomePageObject.clickToLoginLink();
        userHomePageObject = userLogInPageObject.loginWithValidEmailAndPassword(GlobalConstants.EMAIL_ADDRESS, GlobalConstants.PASSWORD);
        userMyAccountPageObject = userHomePageObject.clickToMyAccountLink();

        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        dob_Day = dataHelper.getDay();
        dob_Month = dataHelper.getMonth();
        dob_Year = dataHelper.getYear();
        emailAddress = dataHelper.getEmailAddress();
        companyName = dataHelper.getCompanyName();
        country = dataHelper.getCountryName();
        state = dataHelper.getState();
        city = dataHelper.getCityName();
        address1 = dataHelper.getStreetAddress();
        address2 = dataHelper.getStreetAddress();
        postcode = dataHelper.getPostCode();
        phoneNumber = dataHelper.getPhoneNumber();
        faxNumber = dataHelper.getPhoneNumber();
        password = dataHelper.getPassword();
        reviewtitle = "Review title";
        reviewBody = "Review body";
    }

    //@Test
    public void MyAccount_01_TC_01_Verify_Update_Info() {
        userCustomerInfoPageObject = userMyAccountPageObject.clickToCustomerInfoLink();
        userCustomerInfoPageObject.selectMaleGender();
        userCustomerInfoPageObject.inputToFirstNameTextbox(firstName);
        userCustomerInfoPageObject.inputToLastNameTextbox(lastName);
        userCustomerInfoPageObject.selectDobDayField(dob_Day);
        userCustomerInfoPageObject.selectDobMonthField(dob_Month);
        userCustomerInfoPageObject.selectDobYearField(dob_Year);
        userCustomerInfoPageObject.inputToEmailTextbox(emailAddress);
        userCustomerInfoPageObject.inputToCompanyNameTextbox(companyName);
        userCustomerInfoPageObject.clickToSaveButton();
        userCustomerInfoPageObject.saveToDataModel();

        Assert.assertEquals(userCustomerInfoPageObject.getCustomerInfoUpdateSuccessMsg(),
                "The customer info has been updated successfully.");
        userCustomerInfoPageObject.clickCustomerInfoSuccessMsgCloseButton();
        Assert.assertEquals(userCustomerInfoPageObject.getFirstNameTextboxValue(), _CustomerInfor.getFirstName());
        Assert.assertEquals(userCustomerInfoPageObject.getLastNameTextboxValue(), _CustomerInfor.getLastName());
        Assert.assertEquals(userCustomerInfoPageObject.getDateOfBirthValue(), _CustomerInfor.getDateOfbirth());
        Assert.assertEquals(userCustomerInfoPageObject.getEmailTextboxValue(), _CustomerInfor.getEmailAddress());
        Assert.assertEquals(userCustomerInfoPageObject.getCompanyNameTextboxValue(), _CustomerInfor.getCompanyName());
    }

    //@Test
    public void MyAccount_01_TC_02_Verify_Update_Address() {
        userMyAccountPageObject = PageGeneratorManager.getUserMyAccountPageObject(driver);
        userAddressPageObject = userMyAccountPageObject.clickToAddressLink();
        userAddressPageObject.clickToAddNewAddressButton();
        userAddressPageObject.inputToFirstNameTextBox(firstName);
        userAddressPageObject.inputToLastNameTextBox(lastName);
        userAddressPageObject.inputToEmailTextBox(emailAddress);
        userAddressPageObject.inputToCompanyTextBox(companyName);
        userAddressPageObject.selectCountryDropdown(country);
        userAddressPageObject.selectStateProvinceDropdown(state);
        userAddressPageObject.inputToCityTextBox(city);
        userAddressPageObject.inputToAddress1TextBox(address1);
        userAddressPageObject.inputToAddress2TextBox(address2);
        userAddressPageObject.inputPostCodeTextBox(postcode);
        userAddressPageObject.inputToPhoneNumberTextBox(phoneNumber);
        userAddressPageObject.inputToFaxNumberTextBox(faxNumber);
        userAddressPageObject.saveToDataModel();
        userAddressPageObject.clickToSaveButton();

        Assert.assertEquals(userAddressPageObject.getSummaryAddNewAddressSuccessMsg(),
                "The new address has been added successfully.");
        userAddressPageObject.clickAddressSuccessMsgCloseButton();
        Assert.assertEquals(userAddressPageObject.getSummaryFullNameValue(), _Address.getAddressFullName());
        Assert.assertEquals(userAddressPageObject.getSummaryEmailValue(), _Address.getAddressEmailAddress());
        Assert.assertEquals(userAddressPageObject.getSummaryCompanyValue(), _Address.getAddressCompany());
        Assert.assertEquals(userAddressPageObject.getSummaryCountryValue(), _Address.getAddressCountry());
        Assert.assertEquals(userAddressPageObject.getSummaryCityStateZipValue(), _Address.getAddressCityStateZip());
        Assert.assertEquals(userAddressPageObject.getSummaryAddress1Value(), _Address.getAddressAddress1());
        Assert.assertEquals(userAddressPageObject.getSummaryAddress2Value(), _Address.getAddressAddress2());
        Assert.assertEquals(userAddressPageObject.getSummaryPhoneNumberValue(), _Address.getAddressPhoneNumber());
        Assert.assertEquals(userAddressPageObject.getSummaryFaxNumberValue(), _Address.getAddressFaxNumber());
    }

    //@Test
    public void MyAccount_01_TC_03_Change_Password_And_Login() {
        userMyAccountPageObject = PageGeneratorManager.getUserMyAccountPageObject(driver);
        userChangePasswordPageObject = userMyAccountPageObject.clickToChangePasswordLink();
        userChangePasswordPageObject.inputToOldPasswordTextbox(GlobalConstants.PASSWORD);
        userChangePasswordPageObject.inputToNewPasswordTextbox(password);
        userChangePasswordPageObject.inputToConfirmPasswordTextbox(password);
        userChangePasswordPageObject.clickToChangePasswordButton();
        Assert.assertEquals(userChangePasswordPageObject.getChangePasswordSuccessMsg(),
                "Password was changed");
        userChangePasswordPageObject.clickToChangePasswordSuccessCloseButton();


        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userHomePageObject = userHomePageObject.clickToLogOutLink();
        userLogInPageObject = userHomePageObject.clickToLoginLink();

        //Log in failed with old password
        userLogInPageObject.inputToEmailTextbox(GlobalConstants.EMAIL_ADDRESS);
        userLogInPageObject.inputToPasswordTextbox(GlobalConstants.PASSWORD);
        userLogInPageObject.clickToLoginButton();
        Assert.assertEquals(userLogInPageObject.getSummaryErrorMsg(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        //Log in success with new password
        userLogInPageObject.loginWithValidEmailAndPassword(GlobalConstants.EMAIL_ADDRESS, password);
        Assert.assertTrue(userHomePageObject.isLogOutLinkDisplay());
    }

    @Test
    public void MyAccount_01_TC_04_Add_And_Check_Review() {
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userCategoriesPageObject = userHomePageObject.clickToComputerLink();
        userDesktopProductPageObject = userCategoriesPageObject.clickToDesktopLink();
        userProductDetailsPageObject = userDesktopProductPageObject.clickToFirstProduct();
        userProductDetailsPageObject.saveToDataModel();
        userProductReviewPageObject = userProductDetailsPageObject.clickToAddReview();
        userProductReviewPageObject.inputToReviewTitleTextBox(reviewtitle);
        userProductReviewPageObject.inputToReviewBodyTextArea(reviewBody);
        userProductReviewPageObject.saveToDataModel();
        userProductReviewPageObject.clickToSubmitReviewButton();

        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userMyAccountPageObject = userHomePageObject.clickToMyAccountLink();
        userMyProductReviewPageObject = userMyAccountPageObject.clickToMyProductReview();

        Assert.assertEquals(userMyProductReviewPageObject.getReviewTitle(_ProductDetails.getProductName()), _ProductReview.getReviewTitle());
        Assert.assertEquals(userMyProductReviewPageObject.getReviewBody(_ProductDetails.getProductName()), _ProductReview.getReviewBody());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
