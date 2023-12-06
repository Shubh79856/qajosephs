package com.remosys.liquorcartDev.testLayer;

import com.remosys.liquorcartDev.BaseLayer.BaseTest;
import com.remosys.liquorcartDev.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTest {

    /*
    @Test(priority = 0)
    public void clickSigInTest()
    {
        loginPage.doClickSigIn();
    }
    */


    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage.doClickSigIn();
        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(loginPageTitle, AppConstants.TITLE_LOGIN_PAGE);
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
         homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        boolean signOutBtnExist = homePage.isSignOutBtnExist();
        Assert.assertTrue(signOutBtnExist);

    }

}
