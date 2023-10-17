package testcases.featureSearch;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.userPageObject.UserHomePageObject;
import pageObject.userPageObject.UserLogInPageObject;
import pageObject.userPageObject.UserRegisterPageObject;
import pageObject.userPageObject.UserSearchPageObject;
import utilities.DataFakerHelper;

public class Search_01 extends BaseTest {
    private WebDriver driver;
    private DataFakerHelper dataHelper;
    private String emptyKeyWord, doesNotExistKeyWord, relativeProductName, exactProductName1, exactProductName2,
            categoryType_1, manufacturerType_1, manufacturerType_2;
    private UserHomePageObject userHomePageObject;
    private UserRegisterPageObject userRegisterPageObject;
    private UserLogInPageObject userLogInPageObject;
    private UserSearchPageObject userSearchPageObject;

    @Parameters({"browserName", "pageUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        dataHelper = DataFakerHelper.getDataFakerHelper();
        driver = getBrowserDriver(browserName, pageUrl);
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userRegisterPageObject = userHomePageObject.clickToRegisterLink();
        userRegisterPageObject.createAccount();
        userHomePageObject = PageGeneratorManager.getHomePageObject(driver);
        userLogInPageObject = userHomePageObject.clickToLoginLink();
        userHomePageObject = userLogInPageObject.loginWithValidEmailAndPassword(GlobalConstants.EMAIL_ADDRESS, GlobalConstants.PASSWORD);

        emptyKeyWord = "";
        doesNotExistKeyWord = "macbook pro 20250";
        relativeProductName = "lenovo";
        exactProductName1 = "Lenovo Thinkpad X1 Carbon Laptop";
        exactProductName2 = "Apple Macbook Pro";
        categoryType_1 = "Computers";
        manufacturerType_1 = "HP";
        manufacturerType_2 = "Apple";
    }

    @Test
    public void Search_01_TC_01_Search_With_Empty_Data() {
        userSearchPageObject = userHomePageObject.clickToFooterSearchLink();
        userSearchPageObject.inputToSearchKeywordTextbox(emptyKeyWord);
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getWarningResultsMsg(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_01_TC_02_Search_With_Data_Not_Exist() {
        userSearchPageObject.inputToSearchKeywordTextbox(doesNotExistKeyWord);
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNoResultsMsg(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_01_TC_03_Search_With_Relative_Product_Name() {
        userSearchPageObject.inputToSearchKeywordTextbox(relativeProductName);
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNumberOfProductsInSearchResults(), 2);
    }

    @Test
    public void Search_01_TC_04_Search_With_Exact_Product_Name() {
        userSearchPageObject.inputToSearchKeywordTextbox(exactProductName1);
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNumberOfProductsInSearchResults(), 1);
    }

    @Test
    public void Search_01_TC_05_Advance_Search_With_Parent_Categories() {
        userSearchPageObject.inputToSearchKeywordTextbox(exactProductName2);
        userSearchPageObject.checkToAdvancedSearchCheckbox();
        userSearchPageObject.selectAdvancedSearchCategories(categoryType_1);
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNoResultsMsg(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_01_TC_06_Advance_Search_With_Sub_Categories() {
        userSearchPageObject.inputToSearchKeywordTextbox(exactProductName2);
        userSearchPageObject.checkToAdvancedSearchCheckbox();
        userSearchPageObject.selectAdvancedSearchCategories(categoryType_1);
        userSearchPageObject.checkToAAutomaticallySearchCheckbox();
        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNumberOfProductsInSearchResults(), 1);
    }

    @Test
    public void Search_01_TC_07_Advance_Search_With_Incorrect_Manufacturer() {
        userSearchPageObject.inputToSearchKeywordTextbox(exactProductName2);
        userSearchPageObject.checkToAdvancedSearchCheckbox();
        userSearchPageObject.selectAdvancedSearchCategories(categoryType_1);
        userSearchPageObject.checkToAAutomaticallySearchCheckbox();
        userSearchPageObject.selectManufacturerSearch(manufacturerType_1);

        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNoResultsMsg(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_01_TC_08_Advance_Search_With_Correct_Manufacturer() {
        userSearchPageObject.inputToSearchKeywordTextbox(exactProductName2);
        userSearchPageObject.checkToAdvancedSearchCheckbox();
        userSearchPageObject.selectAdvancedSearchCategories(categoryType_1);
        userSearchPageObject.checkToAAutomaticallySearchCheckbox();
        userSearchPageObject.selectManufacturerSearch(manufacturerType_2);

        userSearchPageObject.clickToSearchButton();

        Assert.assertEquals(userSearchPageObject.getNumberOfProductsInSearchResults(), 1);
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
