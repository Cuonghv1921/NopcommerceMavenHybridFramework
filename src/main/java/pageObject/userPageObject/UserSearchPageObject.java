package pageObject.userPageObject;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElementUIs.userPageUIs.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
    private WebDriver driver;
    public UserSearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter keyword to search text box: {0}")
    public void inputToSearchKeywordTextbox(String keyWord) {
        sendKeyToElement(UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyWord);
    }

    @Step("Click to Search button")
    public void clickToSearchButton() {
        clickToElement(UserSearchPageUI.SEARCH_BUTTON);
    }

    @Step("Get Search warning results message")
    public String getWarningResultsMsg() {
        return getElementText(UserSearchPageUI.SEARCH_SESULT_WARNING_MSG);
    }

    @Step("Get Search no results message")
    public String getNoResultsMsg() {
        return getElementText(UserSearchPageUI.SEARCH_NO_SESULT_MSG);
    }

    @Step("Get number of products in results search")
    public int getNumberOfProductsInSearchResults() {
        return getElementSize(UserSearchPageUI.PRODUCT_ITEM);
    }

    @Step("Check to Advanced search checkbox")
    public void checkToAdvancedSearchCheckbox() {
        if(!isElementSelected(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX)) {
            checkToDefaultCheckboxRadio(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        }
    }

    @Step("Select categories: {0}")
    public void selectAdvancedSearchCategories(String categoryType) {
        selectItemDefaultDropdown(UserSearchPageUI.ADVANCED_SEARCH_CATEGORY_DROPDOWN, categoryType);
    }

    @Step("Check to Automatically search sub categories checkbox")
    public void checkToAAutomaticallySearchCheckbox() {
        if(!isElementSelected(UserSearchPageUI.ADVANCED_SEARCH_SUB_CATEGORY_CHECKBOX)) {
            checkToDefaultCheckboxRadio(UserSearchPageUI.ADVANCED_SEARCH_SUB_CATEGORY_CHECKBOX);
        }
    }

    @Step("Select Manufacturer: {0}")
    public void selectManufacturerSearch(String manufacturerType) {
        selectItemDefaultDropdown(UserSearchPageUI.ADVANCED_SEARCH_MANUFACTURER_DROPDOWN, manufacturerType);
    }
}
