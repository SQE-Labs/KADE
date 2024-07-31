package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class Editable extends ActionEngine {

    private By target = null;
    private String label;

    public Editable(By billBtn, String label) {
        this.target = billBtn;
        this.label = label;
    }

    public void setText(String text) {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        clear_custom(target);
        pressKeys(target, text);
        click(target);
    }

    public String getText() {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        return getElementText(target);
    }

    public Boolean isDisplayed(){
        return isElementPresent(target, "");
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

}
