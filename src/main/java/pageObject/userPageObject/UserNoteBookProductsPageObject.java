package pageObject.userPageObject;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElementUIs.userPageUIs.UserNoteBookProductsPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNoteBookProductsPageObject extends BasePage {
    private WebDriver driver;

    public UserNoteBookProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Select product sort type: {0}")
    public void selectProductSortType(String sortType) {
        selectItemDefaultDropdown(UserNoteBookProductsPageUI.PRODUCT_SORT_TYPE_DROPDOWN, sortType);
    }

    @Step("Select number of product display: {0}")
    public void selectNumberOfProductDisplay(String numberOfProduct) {
        selectItemDefaultDropdown(UserNoteBookProductsPageUI.NUMBER_OF_PRODUCT_DISPLAY, numberOfProduct);
    }

    @Step("Get total number of product display in a page: {0}")
    public int getNumberOfProductDisplay() {
        int numberOfProduct = 0;
        if (areJQueryAndJSLoadedSuccess()) {
            numberOfProduct = getElementSize(UserNoteBookProductsPageUI.PRODUCT_ITEM);
        }
        return numberOfProduct;
    }

    @Step("Get all product name")
    public List getProductsName() {
        List<WebElement> productItems = new ArrayList<WebElement>();
        List<String> productNames = new ArrayList<String>();
        if (areJQueryAndJSLoadedSuccess()) {
            productItems = getListWebElement(UserNoteBookProductsPageUI.PRODUCT_NAME);
            for (WebElement productItem : productItems) {
                productNames.add(productItem.getText());
            }
        }
        return productNames;
    }

    @Step("Get all product price")
    public List getProductsPrice() {
        List<WebElement> productItems = new ArrayList<WebElement>();
        List<Float> productPrices = new ArrayList<Float>();
        if (areJQueryAndJSLoadedSuccess()) {
            productItems = getListWebElement(UserNoteBookProductsPageUI.PRODUCT_PRICE);
            for (WebElement productItem : productItems) {
                float price = Float.parseFloat(productItem.getText().replace("$", "").replace(",", ""));
                productPrices.add(price);
            }
        }
        return productPrices;
    }

    @Step("Sort items by ascending order")
    public List<String> listProductsNameSortByASC(List<String> listItems) {
        Collections.sort(listItems);
        return listItems;
    }

    @Step("Sort items by descending order")
    public List<String> listProducstNameSortByDESC(List<String> listItems) {
        Collections.sort(listItems, Collections.reverseOrder());
        return listItems;
    }

    @Step("Sort items by ascending order")
    public List<String> listProductsPriceSortByASC(List<String> listItems) {
        Collections.sort(listItems);
        return listItems;
    }

    @Step("Sort items by descending order")
    public List<String> listProductsPriceSortByDESC(List<String> listItems) {
        Collections.sort(listItems, Collections.reverseOrder());
        return listItems;
    }

    @Step("Verify Next page icon display")
    public boolean isNextPageIconDisplay() {
        if (isElementUnDisplay(UserNoteBookProductsPageUI.NEXT_PAGE_ICON)) {
            return false;
        } else {
            return true;
        }
    }

    @Step("Click to Next page icon")
    public void clickToNextPageIcon() {
        clickToElement(UserNoteBookProductsPageUI.NEXT_PAGE_ICON);
    }

    @Step("Verify Previous page icon display")
    public boolean isPreviousPageIconDisplay() {
        if (isElementUnDisplay(UserNoteBookProductsPageUI.PREVIOUS_PAGE_ICON)) {
            return false;
        } else {
            return true;
        }
    }
}
