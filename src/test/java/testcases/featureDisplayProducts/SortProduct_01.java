package testcases.featureDisplayProducts;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.userPageObject.UserCategoriesPageObject;
import pageObject.userPageObject.UserHomePageObject;
import pageObject.userPageObject.UserNoteBookProductsPageObject;

public class SortProduct_01 extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserCategoriesPageObject userCategoriesPageObject;
    private UserNoteBookProductsPageObject userNoteBookProductsPageObject;
    private String sortByAtoZ, sortByZtoA, sortLowtoHigh, sortHightoLow;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userCategoriesPageObject = userHomePageObject.clickToComputerLink();
        userNoteBookProductsPageObject = userCategoriesPageObject.clickToNoteBooksLink();

        sortByAtoZ = "Name: A to Z";
        sortByZtoA = "Name: Z to A";
        sortLowtoHigh = "Price: Low to High";
        sortHightoLow = "Price: High to Low";
    }

    //@Test
    public void SortProduct_01_TC_01_Sort_With_Name_AZ_Order() {
        userNoteBookProductsPageObject.selectProductSortType(sortByAtoZ);

        Assert.assertTrue(userNoteBookProductsPageObject.getProductsName().
                equals(userNoteBookProductsPageObject.listProductsNameSortByASC(userNoteBookProductsPageObject.getProductsName())));
    }

    //@Test
    public void SortProduct_01_TC_02_Sort_With_Name_ZA_Order() {
        userNoteBookProductsPageObject.selectProductSortType(sortByZtoA);

        Assert.assertTrue(userNoteBookProductsPageObject.getProductsName().
                equals(userNoteBookProductsPageObject.listProducstNameSortByDESC(userNoteBookProductsPageObject.getProductsName())));
    }

    @Test
    public void SortProduct_01_TC_03_Sort_With_Price_AZ_Order() {
        userNoteBookProductsPageObject.selectProductSortType(sortLowtoHigh);

        Assert.assertTrue(userNoteBookProductsPageObject.getProductsPrice().
                equals(userNoteBookProductsPageObject.listProductsPriceSortByASC(userNoteBookProductsPageObject.getProductsPrice())));
    }

    @Test
    public void SortProduct_01_TC_04_Sort_With_Price_ZA_Order() {
        userNoteBookProductsPageObject.selectProductSortType(sortHightoLow);

        Assert.assertTrue(userNoteBookProductsPageObject.getProductsPrice().
                equals(userNoteBookProductsPageObject.listProductsPriceSortByDESC(userNoteBookProductsPageObject.getProductsPrice())));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
