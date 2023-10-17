package pageObject.userPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserMyAccountPageUI;

public class UserMyAccountPageObject extends BasePage {
    private WebDriver driver;

    public UserMyAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Customer info link")
    public UserCustomerInfoPageObject clickToCustomerInfoLink() {
        clickToElement(UserMyAccountPageUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
    }

    @Step("Click to Address link")
    public UserAddressPageObject clickToAddressLink() {
        clickToElement(UserMyAccountPageUI.ADDRESS_LINK);
        return PageGeneratorManager.getUserAddressPageObject(driver);
    }

    @Step("Click to Change Password link")
    public UserChangePasswordPageObject clickToChangePasswordLink() {
        clickToElement(UserMyAccountPageUI.CHANGE_PASSWORD_LINK);
        return PageGeneratorManager.getUserChangePasswordPageObject(driver);
    }

    public UserMyProductReviewPageObject clickToMyProductReview() {
        clickToElement(UserMyAccountPageUI.PRODUCT_REVIEW_LINK);
        return PageGeneratorManager.getUserMyProductReviewPageObject(driver);
    }
}
