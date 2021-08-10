package com.problemstatements.pages;

import com.problemstatements.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTip extends BaseClass {

    @FindBy(xpath = "//input[@id='age']")
    WebElement toolTip;

    public ToolTip(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String tooltip() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTip).build();
        actions.perform();

        return toolTip.getAttribute("title");
    }
}
