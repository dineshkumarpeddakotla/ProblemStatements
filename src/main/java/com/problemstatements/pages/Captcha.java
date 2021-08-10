package com.problemstatements.pages;

import com.problemstatements.base.BaseClass;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Captcha extends BaseClass {

    @FindBy(xpath = "//*[@id=\"ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_BackNoise1\"]/span")
    WebElement backGroundNoise;
    @FindBy(xpath = "//*[@id=\"ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_BackNoise1_DropDown\"]/div/ul/li[1]")
    WebElement none;
    @FindBy(id = "ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_LineNoise1")
    WebElement lineNose;
    @FindBy(xpath = "//*[@id='ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_LineNoise1_DropDown']/div/ul/li[1]")
    WebElement lineNoiseNone;
    @FindBy(id = "ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_FontWarp1")
    WebElement fontWrapper;
    @FindBy(xpath = "//*[@id='ctl00_ConfiguratorPlaceholder_ConfigurationPanel1_FontWarp1_DropDown']/div/ul/li[1]")
    WebElement frontNone;
    @FindBy(name = "ctl00$ConfiguratorPlaceholder$ConfigurationPanel1$Button1")
    WebElement updateChanges;
    @FindBy(className = "imageClass")
    WebElement captcha;
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookie;
    @FindBy(name = "ctl00$ContentPlaceholder1$RadCaptcha1$CaptchaTextBox")
    WebElement captchaTextBox;
    @FindBy(id = "ctl00_ContentPlaceholder1_btnVerify")
    WebElement submit;
    @FindBy(id = "ctl00_ContentPlaceholder1_lblCorrectCode")
    WebElement successMsg;

    public Captcha(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean readCaptcha() throws InterruptedException, TesseractException, IOException {
        Thread.sleep(5000);
        acceptCookie.click();
        Thread.sleep(600);
        backGroundNoise.click();
        Thread.sleep(600);
        none.click();
        Thread.sleep(600);
        lineNose.click();
        Thread.sleep(600);
        lineNoiseNone.click();
        Thread.sleep(600);
        updateChanges.click();
        Thread.sleep(600);

        File src = captcha.getScreenshotAs(OutputType.FILE);
        String path = "./screenshots/captcha.png";
        FileHandler.copy(src, new File(path));
        ITesseract image = new Tesseract();
        image.setDatapath("C://Users//dinnu//Testing//ProblemStatements//src//main//tessdata");

        String imageTxt = image.doOCR(new File(path));
        System.out.println(imageTxt);
        String text =imageTxt.replaceAll(" ", "");
        System.out.println(text);
        captchaTextBox.sendKeys(text);
        submit.click();

        return successMsg.isDisplayed();
    }
}
