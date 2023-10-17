package pageObject.userPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserCategoriesPageUI;
import pageElementUIs.userPageUIs.UserDesktopsProductPageUI;

public class UserCategoriesPageObject extends BasePage {
    private WebDriver driver;
    public UserCategoriesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Desktop link")
    public UserDesktopProductPageObject clickToDesktopLink() {
        clickToElement(UserCategoriesPageUI.DESKTOPS_LINK);
        return PageGeneratorManager.getUserDesktopProductsPageObject(driver);
    }

    public UserNoteBookProductsPageObject clickToNoteBooksLink() {
        clickToElement(UserCategoriesPageUI.NOTEBOOK_LINK);
        return PageGeneratorManager.getUserNoteBookProductsPageObject(driver);
    }
}
