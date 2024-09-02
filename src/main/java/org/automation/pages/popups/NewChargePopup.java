package org.automation.pages.popups;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class NewChargePopup extends BasePage {
    //Locators
    By newChargeAmountField = By.xpath("//input[@lbl-title='Amount']");
    By newChargeConfirm = By.xpath("//button[@name='method' and @type= 'submit']");
    By terminal = By.xpath("//h4[text()='Initializing the terminal...']");
    By terminalCancelButton = By.xpath("//div[@class='text-center']/button[text()='Cancel']");
    By manualChargeTab = By.xpath("//div[text()='Manual']");

    public Editable getNewChargeAmountField() {
        return Editable.getElementBy(newChargeAmountField, "New  charge amount field");
    }

    public Clickable getNewChargeConfirmButton() {
        return Clickable.getElementBy(newChargeConfirm, "New charge confirm button");
    }

    public Clickable getTerminalCancelButton() {
        return Clickable.getElementBy(terminalCancelButton, "Terminal Cancel Button");
    }
    public Clickable getManualChargeTab() {
        return Clickable.getElementBy(manualChargeTab, "Manual Charge Tab");
    }

    public Clickable getTerminalPopup() {
        return Clickable.getElementBy(terminal, "Terminal Popup");
    }
}





