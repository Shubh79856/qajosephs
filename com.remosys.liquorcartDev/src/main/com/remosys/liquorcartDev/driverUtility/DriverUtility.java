package com.remosys.liquorcartDev.driverUtility;

import com.remosys.liquorcartDev.constants.AppConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverUtility {


    public WebDriver driver;

    /**
     * This method is used to initialize the driver on the basis of browser name from config file
     *
     * @param prop : Properties class reference
     * @return driver
     * @throws IOException
     */
    public WebDriver initDriver(Properties prop) {

        String browserName = prop.getProperty("browser").toLowerCase();
        System.out.println("Browser name is :" + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {

//            ChromeOptions op = new ChromeOptions();
//			op.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(op);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please pass the correct browser name : " + browserName);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;

    }


    /**
     * This method is used to initialize the config.properties file
     *
     * @return prop
     */
    public Properties loadConfig() {
        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(AppConstants.PROPERTIES_FILE_PATH);
            prop.load(fis);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
