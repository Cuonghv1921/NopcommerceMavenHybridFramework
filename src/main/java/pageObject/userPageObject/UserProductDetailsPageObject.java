package pageObject.userPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import guiDataModel.DataModel.ProductDetails;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserProductDetailsPageUI;

public class UserProductDetailsPageObject extends BasePage {
    private WebDriver driver;
    public static ProductDetails _ProductDetails;
    public UserProductDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to add review product")
    public UserProductReviewPageObject clickToAddReview() {
        clickToElement(UserProductDetailsPageUI.ADD_REVIEW_LINK);
        return PageGeneratorManager.getUserProductReviewPageObject(driver);
    }

    @Step("Get product name")
    public String getProductDetailName() {
        return getElementText(UserProductDetailsPageUI.PRODUCT_NAME);
    }

    @Step("Save product details data to data model")
    public void saveToDataModel() {
        _ProductDetails = new ProductDetails();
        _ProductDetails.setProductName(getProductDetailName());
    }
}
