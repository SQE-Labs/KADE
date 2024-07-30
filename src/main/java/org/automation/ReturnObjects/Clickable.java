package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class Clickable extends PerformActions {
    ActionEngine actionEngine = new ActionEngine();
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
        PerformActions action = new PerformActions() {
            @Override
            void clickElement() {
                WebdriverWaits.waitForElementUntilVisible(target, 5);
                WebdriverWaits.waitForElementClickable(target, 5);
                actionEngine.clickBy(target, label);
            }
        };
        action.clickElement();
    }

    public void clickbyJS() {
        PerformActions action = new PerformActions() {
            @Override
            void clickElement() {
                WebdriverWaits.waitForElementUntilVisible(target, 5);
                WebdriverWaits.waitForElementClickable(target, 5);
                actionEngine.clickElementByJS(target);
            }
        };
        action.clickElement();
    }


    public void clickIfExist() {
        if (actionEngine.isElementPresent_custom(target, label)) {
            PerformActions action = new PerformActions() {
                @Override
                void clickElement() {
                    WebdriverWaits.waitForElementUntilVisible(target, 5);
                    WebdriverWaits.waitForElementClickable(target, 5);
                    actionEngine.clickBy(target, label);
                }
            };
            action.clickElement();
        }
    }

    public Boolean isDisplayed(){
        return actionEngine.isElementPresent(target, label);
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
