package com.remosys.liquorcartDev.genericUtilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public String randomString() {
        String randomNumber = "s" + Math.random();
        return randomNumber;
    }

    /**
     * Getting the WebElement value from the By locator
     * @param locator
     * @return WebElement
     */
    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * To perform the click action on the WebElement
     * @param locator
     */
    public void doClick(By locator) {
        getElement(locator).click();
    }

    /**
     * To perform the click action on the WebElement before applying some wait
     * @param locator,timeOut
     */
    public void doClickWithWait(By locator, int timeOut) {
        waitForElementPresence(locator, timeOut).click();
    }

    /**
     * To get the text of the WebElement
     * @param locator
     * @return String
     */
    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    /**
     * To get the text of the WebElement before applying some wait
     * @param locator,timeOut
     * @return String
     */
    public String getElementTextWithWait(By locator, int timeOut) {
        return waitForElementPresence(locator, timeOut).getText();
    }

    /**
     * To send the keys to the text fields
     * @param locator
     * @param value
     */
    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    /**
     * To send the keys to the text fields by applying some wait on it
     * @param locator
     * @param value
     */
    public void doSendKeysWithWait(By locator, int timeOut, String value) {
        waitForElementPresence(locator, timeOut).sendKeys(value);
    }

    /**
     * Waiting for the expected title untill then it will wait for the given amount of time
     * @param timeOut
     * @param titleFraction
     * @return
     */
    public String waitForTitleContains(int timeOut, String titleFraction) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
            return driver.getTitle();
        } else {
            return null;
        }
    }

    /**
     * Waiting for the expected title contains untill then it will wait for the given amount of time
     * @param timeOut
     * @param titleValue
     * @return
     */
    public String waitForTitleIs(int timeOut, String titleValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleIs(titleValue))) {
            return driver.getTitle();
        } else {
            return null;
        }
    }


    /**
     *    ************** WAITS Methods ********************************
     */

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementPresence(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but also
     * has a height and width that is greater than 0.
     * Default polling time = 500 ms
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but also
     * has a height and width that is greater than 0.
     * Default polling time = customized
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * An expectation for checking that all elements present on the web page that match the locator are visible.
     * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
     * @param locator
     * @param timeOut
     * @return
     */
    public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }



}
