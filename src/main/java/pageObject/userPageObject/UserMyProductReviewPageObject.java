package pageObject.userPageObject;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
    private WebDriver driver;
    public UserMyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get review title")
    public String getReviewTitle(String productName) {
        return getElementText(UserMyProductReviewPageUI.REVIEW_TITLE, productName);
    }

    @Step("Get review body")
    public String getReviewBody(String productName) {
        return getElementText(UserMyProductReviewPageUI.REVIEW_BODY, productName);
    }
}
