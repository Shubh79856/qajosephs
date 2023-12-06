package com.remosys.liquorcartDev.testLayer;

import com.remosys.liquorcartDev.BaseLayer.BaseTest;
import org.testng.annotations.*;



public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accSetup() {
       homePage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
         accountsPage = homePage.clickAccountLink();

    }

    @Test
    public void accountsPageTitleTest(){
        String accountsPageTitle = accountsPage.getAccountsPageTitle();
        System.out.println(accountsPageTitle);
        System.out.println("m1 running");

    }

    @Test
    public void m1()
    {
        System.out.println("m2 running");
    }
}
