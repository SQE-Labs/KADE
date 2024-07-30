package org.automation.ReturnObjects;

import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.utilities.ActionEngine.*;

public class Clickable extends PerformActions {

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
                clickBy(target, label);
            }
        };
        action.clickElement();
    }


    public void clickIfExist() {
        if (isElementPresent_custom(target, label)) {
            PerformActions action = new PerformActions() {
                @Override
                void clickElement() {
                    WebdriverWaits.waitForElementUntilVisible(target, 5);
                    WebdriverWaits.waitForElementClickable(target, 5);
                    clickBy(target, label);
                }
            };
            action.clickElement();
        }
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
