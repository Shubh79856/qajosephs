package com.remosys.liquorcartDev.pageLayer;

import com.remosys.liquorcartDev.constants.AppConstants;
import com.remosys.liquorcartDev.genericUtilities.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private By btnSignIn = By.xpath("//a[text()='Sign In']");

    /*
    By Locators
     */
    private By email = By.id("email");
    private By password = By.id("pass");
    private By btnLogin = By.xpath("//button[@name='send']//span[text()='Sign In']");
    private By forgotPwd = By.xpath("//a//span[text()='Forgot Your Password?']");

    /**
     * Constructor to initialize the driver of the Login page class
     * Creating other class objects
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    /**
     *  Defining all the Actions of the Login Page
      */

    public String getLoginPageTitle() {
        //     return driver.getTitle();
        // avoid the use of driver/findElement in the code
        return eleUtil.waitForTitleIs(10, AppConstants.TITLE_LOGIN_PAGE);
    }

    public void doClickSigIn() {
        driver.findElement(btnSignIn).click();
    }

    public String getLoginPageURL() {
        return driver.getCurrentUrl();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwd).isDisplayed();
    }

    public HomePage doLogin(String un, String pwd) {

        eleUtil.doClick(btnSignIn);
        eleUtil.doSendKeys(email,un);
        eleUtil.doSendKeys(password,pwd);
        eleUtil.doClick(btnLogin);
        return new HomePage(driver);
    }

}
