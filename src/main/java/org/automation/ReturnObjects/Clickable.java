package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Clickable extends ActionEngine {
    ActionEngine actionEngine = new ActionEngine();
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    private By target = null;
    private String label;

    public Clickable(By by) {
        new Clickable(by, "");
    }

    public Clickable(By billBtn, String label) {
        this.target = billBtn;
        this.label = label;
    }

    public void click() {
        performClickOperation(() -> clickBy(target, label));
    }

    public void clickbyJS() {
        performClickOperation(() -> clickElementByJS(target));
    }


    public void clickIfExist() {
        if (isElementPresent_custom(target, label)) {
            performClickOperation(() -> clickBy(target, label));
        }
    }

    public Boolean isDisplayed(){
        return isElementPresent(target, label);
    }

    public boolean isEnabled(){
        return isElementEnabled(target);
    }

    public String getText() {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        return getElementText(target);
    }

    private void performClickOperation(Runnable action) {
        WebdriverWaits.waitForElementUntilVisible(target, 10);
        WebdriverWaits.waitForElementClickable(target, 10);
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(target));
        action.run();
    }

    public static Clickable getElementByClassName(String byName) {
        return new Clickable(By.name(byName), "");
    }

    public static Clickable getElementBy(By by, String label) {
        return new Clickable(by, label);
    }

    public static Clickable getElementBy(By by) {
        return getElementBy(by, "");
    }


}
