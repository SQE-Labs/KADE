package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class Clickable extends ActionEngine{

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

    private void performClickOperation(Runnable action) {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        WebdriverWaits.waitForElementClickable(target, 5);
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
