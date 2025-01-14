package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class PaymentHistoryPage extends BasePage {
    //Locators
    public By PaymentHistoryTitle = By.cssSelector(".header-title");
    By NoPaymentMessage = By.cssSelector("div[class= 'card'] div p");


    public PaymentHistoryPage()
    {
        super();
    }

    //To click on Payment History Tab
    public Clickable getPaymentHistoryTitle() { return Clickable.getElementBy(PaymentHistoryTitle, "Payment History Title"); }

    //To get the message appears on Payment History PAge when No Payments are made
    public Editable getNoPaymentMessage(){ return Editable.getElementBy(NoPaymentMessage, "No payment message"); }


}
