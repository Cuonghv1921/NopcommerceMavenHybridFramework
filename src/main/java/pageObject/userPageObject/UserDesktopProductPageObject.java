package pageObject.userPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserDesktopsProductPageUI;

public class UserDesktopProductPageObject extends BasePage {
    private WebDriver driver;
    public UserDesktopProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to first product in product list")
    public UserProductDetailsPageObject clickToFirstProduct() {
        clickToElement(UserDesktopsProductPageUI.FIRST_PRODUCT_LINK);
        return PageGeneratorManager.getUserProductDetailsPageObject(driver);
    }
}
