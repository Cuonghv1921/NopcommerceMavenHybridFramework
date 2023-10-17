package testcases.featureRegister;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.userPageObject.UserHomePageObject;
import pageObject.userPageObject.UserRegisterPageObject;
import utilities.DataFakerHelper;

public class Register_01 extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private DataFakerHelper fakeData;
    private String firstName, lastName, password, emailAddress;
    private String invalidEmail, invalidPassword;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();
        fakeData = DataFakerHelper.getDataFakerHelper();

        firstName = fakeData.getFirstName();
        lastName = fakeData.getLastName();
        password = fakeData.getPassword();
        emailAddress = fakeData.getEmailAddress();
        invalidEmail = "abc@";
        invalidPassword = "1234";
    }

    @Test
    public void Register_01_TC_01_Register_With_Empty_Data() {
        userRegisterPageObject.clickToRegisterButton();

        Assert.assertEquals(userRegisterPageObject.getFirstNameErrorMsg(), "First name is required.");
        Assert.assertEquals(userRegisterPageObject.getLastNameErrorMsg(), "Last name is required.");
        Assert.assertEquals(userRegisterPageObject.getEmailErrorMsg(), "Email is required.");
        Assert.assertEquals(userRegisterPageObject.getPasswordErrorMsg(), "Password is required.");
        Assert.assertEquals(userRegisterPageObject.getConfirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void Register_01_TC_02_Register_With_Invalid_Email() {
        userRegisterPageObject.inputToEmailTextbox(invalidEmail);

        Assert.assertEquals(userRegisterPageObject.getEmailErrorMsg(), "Wrong email");
    }

    @Test
    public void Register_01_TC_03_Register_With_Password_Less_6() {
        userRegisterPageObject.inputToPasswordTextbox(invalidPassword);

        Assert.assertEquals(userRegisterPageObject.getPasswordErrorMsg(),
                "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_01_TC_04_Register_With_Confirm_Password_Not_Match() {
        userRegisterPageObject.inputToPasswordTextbox(password);
        userRegisterPageObject.inputToConfirmPasswordTextbox(invalidPassword);

        Assert.assertEquals(userRegisterPageObject.getConfirmPasswordErrorMsg(),
                "The password and confirmation password do not match.");
    }

    @Test
    public void Register_01_TC_05_Register_With_Valid_Data() {
        userRegisterPageObject.inputToFirstNameTextbox(firstName);
        userRegisterPageObject.inputToLastNameTextbox(lastName);
        userRegisterPageObject.inputToEmailTextbox(emailAddress);
        userRegisterPageObject.inputToPasswordTextbox(password);
        userRegisterPageObject.inputToConfirmPasswordTextbox(password);
        userRegisterPageObject.clickToRegisterButton();

        Assert.assertEquals(userRegisterPageObject.getRegisterSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_01_TC_06_Register_With_Existing_Email() {
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();
        userRegisterPageObject.inputToFirstNameTextbox(firstName);
        userRegisterPageObject.inputToLastNameTextbox(lastName);
        userRegisterPageObject.inputToEmailTextbox(emailAddress);
        userRegisterPageObject.inputToPasswordTextbox(password);
        userRegisterPageObject.inputToConfirmPasswordTextbox(password);
        userRegisterPageObject.clickToRegisterButton();

        Assert.assertEquals(userRegisterPageObject.getCommonErrorMsg(), "The specified email already exists");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
