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

public class Paging_01 extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePageObject;
    private UserCategoriesPageObject userCategoriesPageObject;
    private UserNoteBookProductsPageObject userNoteBookProductsPageObject;
    private String numberOfProductsOnPage_1, numberOfProductsOnPage_2;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userCategoriesPageObject = userHomePageObject.clickToComputerLink();
        userNoteBookProductsPageObject = userCategoriesPageObject.clickToNoteBooksLink();

        numberOfProductsOnPage_1 = "3";
        numberOfProductsOnPage_2 = "6";
    }

    @Test
    public void Paging_01_TC_01_Display_With_2_Pages() {
        userNoteBookProductsPageObject.selectNumberOfProductDisplay(numberOfProductsOnPage_1);
        Assert.assertEquals(userNoteBookProductsPageObject.getNumberOfProductDisplay(), 3);
        Assert.assertTrue(userNoteBookProductsPageObject.isNextPageIconDisplay());
        userNoteBookProductsPageObject.clickToNextPageIcon();
        Assert.assertTrue(userNoteBookProductsPageObject.isPreviousPageIconDisplay());
    }

    @Test
    public void Paging_01_TC_02_Display_With_6_Products() {
        userNoteBookProductsPageObject.selectNumberOfProductDisplay(numberOfProductsOnPage_2);
        Assert.assertEquals(userNoteBookProductsPageObject.getNumberOfProductDisplay(), 6);
        Assert.assertFalse(userNoteBookProductsPageObject.isNextPageIconDisplay());
        Assert.assertFalse(userNoteBookProductsPageObject.isPreviousPageIconDisplay());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
