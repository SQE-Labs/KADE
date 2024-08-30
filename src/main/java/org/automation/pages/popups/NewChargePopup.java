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

    public Editable getNewChargeAmountField() {
        return Editable.getElementBy(newChargeAmountField, "New  charge amount field");
    }

    public Clickable getNewChargeConfirmButton() {
        return Clickable.getElementBy(newChargeConfirm, "New charge config button");
    }

}





