package com.problemstatements.pages;

import com.problemstatements.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Road_Travel_Guidelines extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Pune police portal.']")
    WebElement police_portal;

    public Road_Travel_Guidelines(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Scrolling horizontally till element gets found
    public String visiting_Pune_Portal() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", police_portal);
        Thread.sleep(2000);
        police_portal.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }
}
