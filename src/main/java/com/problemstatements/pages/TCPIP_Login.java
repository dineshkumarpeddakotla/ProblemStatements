package com.problemstatements.pages;

import com.problemstatements.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TCPIP_Login extends BaseClass {

    @FindBy(linkText = "Login")
    WebElement login_btn;

    @FindBy(xpath = "//input[@id='txt_uid']")
    WebElement input_id;

    @FindBy(xpath = "//input[@id='txt_pwd']")
    WebElement input_pwd;

    @FindBy(xpath = "//button[normalize-space()='SIGN IN']")
    WebElement login;

    public TCPIP_Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login() throws InterruptedException {
        login_btn.click();
        Thread.sleep(3000);
        input_id.sendKeys("dineshkumar.icon@gmail.com");
        Thread.sleep(1000);
        input_pwd.sendKeys("Dinnu@247");
        Thread.sleep(2000);
        login.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
    }
}
