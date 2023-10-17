package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final long longTimeOut = GlobalConstants.LONG_TIMEOUT;
    private final long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;

    public void openPageUrl(String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlertPresence().accept();
    }

    public void cancelAlert() {
        waitForAlertPresence().dismiss();
    }

    public String getAlertText() {
        return waitForAlertPresence().getText();
    }

    public void sendKeyToAlert(String textValue) {
        waitForAlertPresence().sendKeys(textValue);
    }

    public void switchToWindowByID(String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            break;
        }
    }

    public void switchToWindowByTitle(String tabTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(tabTitle)) {
                break;
            }
        }
    }

    public void closeAllTabWithoutParent(String parentID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    private By getByLocator(String byLocator) {
        String[] locatorPart = byLocator.split("=", 2);
        if (locatorPart[0].trim().equalsIgnoreCase("xpath")) {
            return By.xpath(locatorPart[1].trim());
        } else if (locatorPart[0].trim().equalsIgnoreCase("id")) {
            return By.id(locatorPart[1].trim());
        } else if (locatorPart[0].trim().equalsIgnoreCase("css")) {
            return By.cssSelector(locatorPart[1].trim());
        } else if (locatorPart[0].trim().equalsIgnoreCase("class")) {
            return By.className(locatorPart[1].trim());
        } else {
            throw new RuntimeException("Invalid by Locator.");
        }
    }

    private String getDynamicLocator(String dynamicLocator, String... dynamicValues) {
        dynamicLocator = String.format(dynamicLocator, (Object[]) dynamicValues);
        return dynamicLocator;
    }

    private WebElement getWebElement(String byLocator) {
        WebElement element = driver.findElement(getByLocator(byLocator));
        scrollToElement(element);
        highlightElement(element);
        return element;
    }

    public List<WebElement> getListWebElement(String byLocator) {
        return driver.findElements(getByLocator(byLocator));
    }

    public List<WebElement> getListWebElement(String byLocator, String... dynamicValues) {
        return driver.findElements(getByLocator(getDynamicLocator(byLocator, dynamicValues)));
    }

    public void clickToElement(String byLocator) {
        waitForElementClickale(byLocator);
        getWebElement(byLocator).click();
    }

    public void clickToElement(String byLocator, String... dynamicValues) {
        waitForElementClickale(getDynamicLocator(byLocator, dynamicValues));
        getWebElement(getDynamicLocator(byLocator, dynamicValues)).click();
    }

    public void upLoadFile(String byLocator, String fileNames) {
        WebElement element = getWebElement(byLocator);
        element.sendKeys(fileNames);
    }

    public void sendKeyToElement(String byLocator, String textValue) {
        waitForElementVisible(byLocator);
        WebElement element = getWebElement(byLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendKeyToElement(String byLocator, String textValue, String... dynamicValues) {
        waitForElementVisible(getDynamicLocator(byLocator, dynamicValues));
        WebElement element = getWebElement(getDynamicLocator(byLocator, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemDefaultDropdown(String byLocator, String textItem) {
        waitForElementVisible(byLocator);
        Select select = new Select(getWebElement(byLocator));
        select.selectByVisibleText(textItem);
    }

    public void selectItemDefaultDropdown(String byLocator, String textItem, String... dynamicValues) {
        waitForElementVisible(getDynamicLocator(byLocator, dynamicValues));
        Select select = new Select(getWebElement(getDynamicLocator(byLocator, dynamicValues)));
        select.selectByVisibleText(textItem);
    }

    public String getFirstSelectedItemDefaultDropdown(String byLocator) {
        waitForElementVisible(byLocator);
        Select select = new Select(getWebElement(byLocator));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(String byLocator) {
        waitForElementVisible(byLocator);
        Select select = new Select(getWebElement(byLocator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(String parentXpath, String childXpath,
                                           String expectTextItem) {
        getWebElement(parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));

        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectTextItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementAttribute(String byLocator, String attributeName) {
        waitForElementPresent(byLocator);
        return getWebElement(byLocator).getAttribute(attributeName);
    }

    public String getElementAttribute(String byLocator, String attributeName, String... dynamicValues) {
        waitForElementPresent(getDynamicLocator(byLocator, dynamicValues));
        return getWebElement(getDynamicLocator(byLocator, dynamicValues)).getAttribute(attributeName);
    }

    public String getElementText(String byLocator) {
        waitForElementVisible(byLocator);
        return getWebElement(byLocator).getText();
    }

    public String getElementText(String byLocator, String... dynamicValues) {
        waitForElementVisible(getDynamicLocator(byLocator, dynamicValues));
        return getWebElement(getDynamicLocator(byLocator, dynamicValues)).getText();
    }

    public String getElementCssValue(String byLocator, String propertyName) {
        waitForElementVisible(byLocator);
        return getWebElement(byLocator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(String byLocator) {
        return getListWebElement(byLocator).size();
    }

    public int getElementSize(String byLocator, String... dynamicValues) {
        return getListWebElement(getDynamicLocator(byLocator, dynamicValues)).size();
    }

    public void checkToDefaultCheckboxRadio(String byLocator) {
        waitForElementClickale(byLocator);
        WebElement element = getWebElement(byLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefaultCheckboxRadio(String byLocator, String... dynamicValues) {
        waitForElementClickale(getDynamicLocator(byLocator, dynamicValues));
        WebElement element = getWebElement(getDynamicLocator(byLocator, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void unCheckToDefaultCheckboxRadio(String byLocator) {
        waitForElementClickale(byLocator);
        WebElement element = getWebElement(byLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(String byLocator) {
        waitForElementVisible(byLocator);
        WebElement element = driver.findElement(getByLocator(byLocator));
        scrollToElement(element);
        highlightElement(element);
        return getWebElement(byLocator).isDisplayed();
    }

    public boolean isElementUnDisplay(String byLocator) {
        overideImplicitWait(shortTimeOut);
        int numberOfElements = getElementSize(byLocator);
        overideImplicitWait(longTimeOut);
        if (numberOfElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUnDisplay(String byLocator, String... dynamicValues) {
        overideImplicitWait(shortTimeOut);
        int numberOfElements = getElementSize(getDynamicLocator(byLocator, dynamicValues));
        overideImplicitWait(longTimeOut);
        if (numberOfElements == 0) {
            return true;
        } else {
            return isElementDisplay(getDynamicLocator(byLocator, dynamicValues));
        }
    }

    public void overideImplicitWait(long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeOut));
    }

    public boolean isElementEnable(String byLocator) {
        waitForElementPresent(byLocator);
        return getWebElement(byLocator).isEnabled();
    }

    public boolean isElementSelected(String byLocator) {
        waitForElementVisible(byLocator);
        return getWebElement(byLocator).isSelected();
    }

    public void switchToFrameIframe(String byLocator) {
        waitForElementPresent(byLocator);
        driver.switchTo().frame(getWebElement(byLocator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(String byLocator) {
        waitForElementVisible(byLocator);
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(byLocator)).perform();
    }

    public void pressKeyBoardToElement(String byLocator, Keys keyValue, String... dynamicValues) {
        waitForElementVisible(getDynamicLocator(byLocator, dynamicValues));
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(getDynamicLocator(byLocator, dynamicValues)), keyValue).perform();
    }

    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
//        sleepInSecond(1);
//        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
//                originalStyle);
    }

    public void clickToElementByJS(String byLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(byLocator));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void removeAttributeInDOM(String byLocator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(byLocator));
    }

    public boolean areJQueryAndJSLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(String byLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
                getWebElement(byLocator));
    }

    public boolean isImageLoaded(String byLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(byLocator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementPresent(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(byLocator)));
    }

    public void waitForAllElementsPresent(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(byLocator)));
    }

    public void waitForElementVisible(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(byLocator)));
    }

    public void waitForElementVisible(String byLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(byLocator, dynamicValues))));
    }

    public void waitForAllElementVisible(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(byLocator)));
    }

    public void waitForAllElementVisible(String byLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(byLocator, dynamicValues))));
    }

    public void waitForElementInvisible(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(byLocator)));
    }

    public void waitForElementInvisible(String byLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(byLocator, dynamicValues))));
    }

    public void waitForAllElementInvisible(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(byLocator)));
    }

    public void waitForElementClickale(String byLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(byLocator)));
    }

    public void waitForElementClickale(String byLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(byLocator, dynamicValues))));
    }
}
