package com.remosys.liquorcartDev.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {

    private WebDriver driver;

    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }

    /**
     *  By locators
     */
    private By accountLink = By.xpath("//ul[@class='header links']//li[contains(@class,'account')]//a[contains(text(),'Account')]");


    /**
     *  Actions
     */
    public void clickAccountLink(){
        driver.findElement(accountLink).click();
    }

    public String getAccountsPageTitle(){
      return driver.getTitle();
    }

}
