package org.automation.pages.popups;

import org.automation.ReturnObjects.Clickable;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class SendTheReceiptPopup {

    public By sendReceiptTitle = By.xpath("//h5[text()='Send the receipt']");
    By amountField = By.cssSelector("h3.text-success.display-3");
    By successMessage = By.cssSelector("div.text-center > p");


    public Clickable getSendReceiptTitle() {

        return Clickable.getElementBy(sendReceiptTitle);
    }

    public Clickable getAmountField() {
        return Clickable.getElementBy(amountField);
    }

    public Clickable getSuccessMessageField() {
        return Clickable.getElementBy(successMessage);
    }

}
