package pageObject.userPageObject;

import commons.BasePage;
import guiDataModel.DataModel.ProductReview;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
    private WebDriver driver;
    public static ProductReview _ProductReview;
    public UserProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter value to review title text box")
    public void inputToReviewTitleTextBox(String textValue) {
        sendKeyToElement(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, textValue);
    }

    @Step("Enter value to review body text area")
    public void inputToReviewBodyTextArea(String textValue) {
        sendKeyToElement(UserProductReviewPageUI.REVIEW_BODY_TEXTAREA, textValue);
    }

    @Step("Click to Submit review button")
    public void clickToSubmitReviewButton() {
        clickToElement(UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    //Get data to save to data model
    @Step("Get review title value")
    public String getReviewTitleValue() {
        return getElementAttribute(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, "value");
    }

    @Step("Get review body value")
    public String getReviewBodyValue() {
        return getElementAttribute(UserProductReviewPageUI.REVIEW_BODY_TEXTAREA, "value");
    }

    @Step("Save data to data model")
    public void saveToDataModel() {
        _ProductReview = new ProductReview();
        _ProductReview.setReviewTitle(getReviewTitleValue());
        _ProductReview.setReviewBody(getReviewBodyValue());
    }
}
