package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class PaymentHistoryPage extends BasePage {
    //Locators
    public By PaymentHistoryTitle = By.cssSelector(".header-title");
    By NoPaymentMessage = By.cssSelector("div[class= 'card'] div p");
    By BillIdCustomer = By.xpath("(//div[@class='mb-1']/span)[1]");
    By CopyBillIdCustomer = By.xpath("(//div[@class='col-7']/div/span)[1]");
    public By transactionsButton = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");



    public PaymentHistoryPage()
    {
        super();
    }

    //To click on Payment History Tab
    public Clickable getPaymentHistoryTitle() { return Clickable.getElementBy(PaymentHistoryTitle, "Payment History Title"); }

    //To get the message appears on Payment History PAge when No Payments are made
    public Editable getNoPaymentMessage(){ return Editable.getElementBy(NoPaymentMessage, "No payment message"); }

    //To get the Bill id of Customer
    public Clickable getBillIdCustomer(){ return Clickable.getElementBy(BillIdCustomer, "Bill Id"); }

    //To copy bill id of customer
    public Clickable getCopyBillIdCustomer(){ return Clickable.getElementBy(CopyBillIdCustomer, "Bill Id"); }

    //To click on Transaction tab
    public Clickable getTransactionsButton() { return Clickable.getElementBy(transactionsButton, "Transaction History"); }


}
