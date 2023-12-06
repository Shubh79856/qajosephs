package com.remosys.liquorcartDev.BaseLayer;

import com.remosys.liquorcartDev.driverUtility.DriverUtility;
import com.remosys.liquorcartDev.pageLayer.AccountsPage;
import com.remosys.liquorcartDev.pageLayer.HomePage;
import com.remosys.liquorcartDev.pageLayer.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

   public WebDriver driver;
   DriverUtility du;
   public Properties prop;
   public LoginPage loginPage;
   public HomePage homePage;
   public AccountsPage accountsPage;

    @BeforeTest
    public void setUp(){
        du=new DriverUtility();
        prop = du.loadConfig();
         driver = du.initDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
