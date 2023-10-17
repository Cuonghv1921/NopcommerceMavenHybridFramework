package testcases.featureLogin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.userPageObject.UserHomePageObject;
import pageObject.userPageObject.UserLogInPageObject;
import pageObject.userPageObject.UserRegisterPageObject;
import utilities.DataFakerHelper;

public class Login_01 extends BaseTest {

    private WebDriver driver;
    private DataFakerHelper dataHelper;
    private String invalidEmail, invalidPassword;
    private String emailAddress, password;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLogInPageObject userLogInPageObject;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        dataHelper = DataFakerHelper.getDataFakerHelper();
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();
        userRegisterPageObject.createAccount();
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);

        emailAddress = dataHelper.getEmailAddress();
        password = dataHelper.getPassword();
        invalidEmail = "bac@";
        invalidPassword = "1234";
    }

    @Test
    public void Login_01_TC_01_Login_With_Empty_Data() {
        userLogInPageObject = userHomePageObject.clickToLoginLink();
        userLogInPageObject.clickToLoginButton();

        Assert.assertEquals(userLogInPageObject.getEmailErrorMsg(), "Please enter your email");
    }

    @Test
    public void Login_01_TC_02_Login_With_Invalid_Email() {
        userLogInPageObject.inputToEmailTextbox(invalidEmail);
        userLogInPageObject.clickToLoginButton();

        Assert.assertEquals(userLogInPageObject.getEmailErrorMsg(), "Wrong email");
    }

    @Test
    public void Login_01_TC_03_Login_With_UnRegistered_Email() {
        userLogInPageObject.inputToEmailTextbox(emailAddress);
        userLogInPageObject.inputToPasswordTextbox(password);
        userLogInPageObject.clickToLoginButton();

        Assert.assertEquals(userLogInPageObject.getSummaryErrorMsg(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_01_TC_04_Login_With_Valid_Email_And_Empty_Password() {
        userLogInPageObject.inputToEmailTextbox(GlobalConstants.EMAIL_ADDRESS);
        userLogInPageObject.clickToLoginButton();

        Assert.assertEquals(userLogInPageObject.getSummaryErrorMsg(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_01_TC_05_Login_With_Valid_Email_And_Wrong_Password() {
        userLogInPageObject.inputToEmailTextbox(GlobalConstants.EMAIL_ADDRESS);
        userLogInPageObject.inputToPasswordTextbox(password);
        userLogInPageObject.clickToLoginButton();

        Assert.assertEquals(userLogInPageObject.getSummaryErrorMsg(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_01_TC_06_Login_With_Valid_Credentials() {
        userLogInPageObject.inputToEmailTextbox(GlobalConstants.EMAIL_ADDRESS);
        userLogInPageObject.inputToPasswordTextbox(GlobalConstants.PASSWORD);
        userLogInPageObject.clickToLoginButton();

        Assert.assertTrue(userHomePageObject.isLogOutLinkDisplay());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
