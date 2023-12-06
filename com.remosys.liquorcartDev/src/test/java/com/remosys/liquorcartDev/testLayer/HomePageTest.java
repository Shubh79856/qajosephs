package com.remosys.liquorcartDev.testLayer;

import com.remosys.liquorcartDev.BaseLayer.BaseTest;
import com.remosys.liquorcartDev.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.*;



public class HomePageTest extends BaseTest {

    @BeforeClass
    public void homePagePreCondition()
    {
         homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test
    public void homePageTitleTest() {
        String homePageTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle, AppConstants.TITLE_HOME_PAGE);
    }
}
