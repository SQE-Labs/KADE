package org.automation.ReturnObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;

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

    public void scrollPopupAndClick(){scrollPopupAndClick(() -> clickBy(target, label));}

    public String getText() {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        return getElementText(target);
    }

    public void clickIfExist(Boolean untillDispaeared, int numberOfRetry) {
        if (!untillDispaeared) {
            do {
                if (isElementPresent_custom(target, label, false)) {
                    performClickOperation(() -> clickByWithoutFailing(target, label));
                    numberOfRetry--;
                }
            }
            while (numberOfRetry > 0);
        } else {
            do {
                if (isElementPresent_custom(target, label, false)) {
                    performClickOperation(() -> clickByWithoutFailing(target, label));
                }
                if (!isElementPresent_custom(target, label, false)) {
                    break;
                }
                numberOfRetry--;
            } while (numberOfRetry > 0);
        }

    }

    public void clickIfExist() {
        clickIfExist(false, 0);
    }

    public void scrollPopupAndClick(Runnable action){
        WebElement popupContainer = getDriver().findElement(By.xpath("(//div[@class='modal-content'])[1]"));
        WebElement element = getDriver().findElement(target);
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        WebdriverWaits.waitForElementClickable(target, 5);
        js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", popupContainer, element);
        if (element.isDisplayed() && element.isEnabled()) {
            action.run();
            System.out.println("Action performed successfully on element: " + target);
        } else {
            System.err.println("Element is not fully visible or not interactable: " + target);
        }
    }

    public Boolean isDisplayed() {
        return isElementPresent(target, label);
    }

    public String getAttribute(String nameOfAttribute) {
        return getAttribute(target, nameOfAttribute);
    }

    public boolean isEnabled(){
        return isElementEnabled(target);
    }

    private void performClickOperation(Runnable action) {
        WebdriverWaits.waitForElementUntilVisible(target, 5);
        WebdriverWaits.waitForElementClickable(target, 5);
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

    public List<WebElement> getListOfWebElements() {
        return super.getListOfWebElements(target);
    }

    public void clickByMouse(){
        clickByMouseActions(target);
    }

    public String getToolTipMessage(){
        return getToolTipMessage(target);
    }
    public String getCssValue(String attribute){
        return getCssValue(target,attribute);
    }

}
