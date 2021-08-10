package com.problemstatements;

import com.beust.jcommander.Parameter;
import com.problemstatements.base.BaseClass;
import com.problemstatements.pages.Captcha;
import com.problemstatements.pages.Road_Travel_Guidelines;
import com.problemstatements.pages.TCPIP_Login;
import com.problemstatements.pages.ToolTip;
import com.problemstatements.utility.Log;
import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestProblemStatements extends BaseClass {

    @Test
    @Parameters("url")
    public void openPunePortal(String url) throws InterruptedException {
        Log.info("navigate to url :" + url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Road_Travel_Guidelines rtg = new Road_Travel_Guidelines(driver);
        String actualTitle = rtg.visiting_Pune_Portal();
        String expectedTitle = "Pune Police - Digital Pass";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    @Parameters("url")
    public void tcpip_loginToApplication(String url) throws InterruptedException {
        Log.info("navigate to url :" + url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TCPIP_Login login = new TCPIP_Login(driver);
        login.login();
    }

    @Test
    @Parameters("url")
    public void testCaptcha(@Optional("https://demos.telerik.com/aspnet-ajax/captcha/examples/overview/defaultcs.aspx") String url) throws InterruptedException, TesseractException, IOException {
        Log.info("navigate to url :" + url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Captcha captcha = new Captcha(driver);
        Boolean displayed = captcha.readCaptcha();

        Assert.assertTrue(displayed);
    }

    @Test
    @Parameters("url")
    private void testToolTip(@Optional("https://jqueryui.com/tooltip/") String url) {
        Log.info("navigate to url :" + url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ToolTip toolTip = new ToolTip(driver);
        String actualTitle = toolTip.tooltip();
        String expectedTitle = "We ask for your age only for statistical purposes.";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
