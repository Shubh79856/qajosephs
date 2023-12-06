package com.remosys.liquorcartDev.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;


    }

    /**
     *  By locators
     */

   private By username = By.xpath("//li[contains(@class,'welcome')]//span[contains(text(),'Hi')]");
   private By signOut = By.xpath("//a[text()='Sign Out']");
   private By accountLink = By.xpath("//ul[@class='header links']//li[contains(@class,'account')]//a[contains(text(),'Account')]");

    /**
     *  All actions
     */
    
    public String getUsername(){

        return driver.findElement(username).getText();
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public boolean isSignOutBtnExist(){
        return driver.findElement(signOut).isDisplayed();
    }

    public AccountsPage clickAccountLink(){
        driver.findElement(accountLink).click();
        return new AccountsPage(driver);
    }





}
