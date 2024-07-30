package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class Editable extends ActionEngine {

    private By target = null;

    public Editable(By billBtn) {
        this.target = billBtn;
    }

    public void setText(String text){
        PerformActions action = new PerformActions() {
            @Override
            void setText(String text){
                WebdriverWaits.waitForElementUntilVisible(target, 5);
                clear_custom(target);
                pressKeys(target, text);
                click(target);
            }
        };
        action.setText(text);
    }

    public String getText(){
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        return getElementText(target);
    }

    public static Editable getElementByClassName(String byName){
        return new Editable(By.name(byName));
    }

    public static Editable getElementBy(By xpath){
        return new Editable(xpath);
    }

}
