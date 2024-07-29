package org.automation.ReturnObjects;

import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.base.BaseTest.getDriver;

public class Clickable extends PerformActions{

    private By target = null;

    public Clickable(By billBtn) {
        this.target = billBtn;
    }

    public void click(){
        PerformActions action = new PerformActions() {
            @Override
            void clickElement(){
                WebdriverWaits.waitForElementUntilVisible(target, 5);
                WebdriverWaits.waitForElementClickable(target, 5);
                getDriver().findElement(target).click();
            }
        };
        action.clickElement();
    }

    public static Clickable getElementByClassName(String byName){
        return new Clickable(By.name(byName));
    }

    public static Clickable getElementByxPath(By xpath){
        return new Clickable(xpath);
    }



}
