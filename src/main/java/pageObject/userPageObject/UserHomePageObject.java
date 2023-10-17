package pageObject.userPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to 'Register' link")
    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickale(UserHomePageUI.HEADER_REGISTER_LINK);
        clickToElement(UserHomePageUI.HEADER_REGISTER_LINK);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

    @Step("Click to 'Login' link")
    public UserLogInPageObject clickToLoginLink() {
        if(isElementDisplay(UserHomePageUI.HEADER_LOGIN_LINK)) {
            waitForElementClickale(UserHomePageUI.HEADER_LOGIN_LINK);
            clickToElement(UserHomePageUI.HEADER_LOGIN_LINK);
        } else {
            openPageUrl(GlobalConstants.USER_LOGIN_PAGE_URL);
        }
        return PageGeneratorManager.getUserLogInPageObject(driver);
    }

    @Step("Click to 'My Account' link")
    public UserMyAccountPageObject clickToMyAccountLink() {
        waitForElementClickale(UserHomePageUI.HEADER_MYACCOUNT_LINK);
        clickToElement(UserHomePageUI.HEADER_MYACCOUNT_LINK);
        return PageGeneratorManager.getUserMyAccountPageObject(driver);
    }

    @Step("Verify Log out link display")
    public boolean isLogOutLinkDisplay() {
        return isElementDisplay(UserHomePageUI.HEADER_LOGOUT_LINK);
    }

    @Step("Click to 'Log out' link")
    public UserHomePageObject clickToLogOutLink() {
        waitForElementClickale(UserHomePageUI.HEADER_LOGOUT_LINK);
        clickToElement(UserHomePageUI.HEADER_LOGOUT_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    @Step("Click to 'Computer' link")
    public UserCategoriesPageObject clickToComputerLink() {
        waitForElementClickale(UserHomePageUI.CATEGORIES_COMPUTER_LINK);
        clickToElement(UserHomePageUI.CATEGORIES_COMPUTER_LINK);
        return PageGeneratorManager.getUserCategoriesPageObject(driver);
    }

    @Step("Click to Search link at the footer of the home page")
    public UserSearchPageObject clickToFooterSearchLink() {
        clickToElement(UserHomePageUI.FOOTER_SEARCH_LINK);
        return PageGeneratorManager.getUserSearchPageObject(driver);
    }
}
