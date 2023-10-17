package commons;

import org.openqa.selenium.WebDriver;
import pageObject.userPageObject.*;

public class PageGeneratorManager {

    public static UserHomePageObject getHomePageObject(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserLogInPageObject getUserLogInPageObject(WebDriver driver) {
        return new UserLogInPageObject(driver);
    }

    public static UserMyAccountPageObject getUserMyAccountPageObject(WebDriver driver) {
        return new UserMyAccountPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerInfoPageObject(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserAddressPageObject getUserAddressPageObject(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }

    public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {
        return new UserChangePasswordPageObject(driver);
    }

    public static UserCategoriesPageObject getUserCategoriesPageObject(WebDriver driver) {
        return new UserCategoriesPageObject(driver);
    }

    public static UserDesktopProductPageObject getUserDesktopProductsPageObject(WebDriver driver) {
        return new UserDesktopProductPageObject(driver);
    }

    public static UserProductDetailsPageObject getUserProductDetailsPageObject(WebDriver driver) {
        return  new UserProductDetailsPageObject(driver);
    }

    public static UserProductReviewPageObject getUserProductReviewPageObject(WebDriver driver) {
        return  new UserProductReviewPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductReviewPageObject(WebDriver driver) {
        return  new UserMyProductReviewPageObject(driver);
    }

    public static UserSearchPageObject getUserSearchPageObject(WebDriver driver) {
        return  new UserSearchPageObject(driver);
    }

    public static UserNoteBookProductsPageObject getUserNoteBookProductsPageObject(WebDriver driver) {
        return  new UserNoteBookProductsPageObject(driver);
    }
}
