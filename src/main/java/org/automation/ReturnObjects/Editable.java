package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.*;

import java.util.List;

public class Editable extends ActionEngine {

    private By target = null;
    private String label;

    public Editable(By billBtn, String label) {
        this.target = billBtn;
        this.label = label;
    }

    public void setText(String text, Boolean cleanText) {
        if (cleanText) {
            clear_custom(target);
        }
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        pressKeys(target, text);
        click(target);
    }

    public void setText(String text) {
        setText(text, true);
    }

    public String getText() {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        return getElementText(target);
    }

    public Boolean isDisplayed() {
        return isElementPresent(target, "");
    }

    public String getAttribute(String nameOfAttribute) {
        return getAttribute(target, nameOfAttribute);
    }

    public static Editable getElementByClassName(String byName, String nameOfElement) {
        return new Editable(By.name(byName), nameOfElement);
    }

    public static Editable getElementBy(By xpath) {
        return new Editable(xpath, "");
    }

    public static Editable getElementBy(By xpath, String nameOfElement) {
        return new Editable(xpath, nameOfElement);
    }

    // Method to get list of web elements
    public List<WebElement> getListOfWebElements() {
        return getDriver().findElements(target);
    }

    public String getToolTipMessage() {
        return getToolTipMessage(target);
    }


    public void cleanByJS() {
        WebElement element = getDriver().findElement(target);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", element);
    }

    }




