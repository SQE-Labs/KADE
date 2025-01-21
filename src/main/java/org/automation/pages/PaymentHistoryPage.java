package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class PaymentHistoryPage extends BasePage {
    //Locators
    public By PaymentHistoryTitle = By.cssSelector(".header-title");
    By NoPaymentMessage = By.cssSelector("div[class= 'card'] div p");
    By BillIdCustomer = By.xpath("(//div[@class='mb-1']/span)[1]");
    By CopyBillIdCustomer = By.xpath("(//div[@class='col-7']/div/span)[1]");
    public By transactionsButton = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");
    public By ClickPaidTransaction = By.xpath("//div[@class='mb-1']  //span[text()='TR-25392']");
    By StoreName = By.xpath("//span[@class='ms-2 text-truncate']");
    By TotalPaidAmount = By.xpath("//span[@class='fs-4 mt-n1 me-2']");
    By TransactionDateTime = By.xpath("//div[@class='mb-1']/span[@class='fs-pn15']");
    By PaymentMethodImage = By.cssSelector(".payment-logo-bg");
    By PaymentMethodText = By.xpath("//div[@class='fs-pn25 me-1']/span[@class='text-nowrap']");
    By AmountPaid = By.cssSelector(".ms-1");
    By CustomerImg = By.xpath("//a[@class='me-1']/img");
    By ClickTransaction = By.xpath("(//div[@class='container-fluid ']/div/div/div)[1]");
    By CopyTransaction = By.xpath("(//span[contains(text(),'TR')])[2]");
    public By Amountfield = By.xpath("//input[@lbl-title='Amount']");
    By  CustomerTransaction = By.xpath("(//div[@class='col-12 max-45c loaded']/div)[1]");
    By MakePaymentBtn = By.xpath("//button[contains(text(),'Make payments')]");
    public By CloseButton = By.cssSelector(".btn-pill");



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

    //To click on Paid Transaction
    public Clickable getClickPaidTransaction() { return Clickable.getElementBy(ClickPaidTransaction, "Paid Payment Transaction"); }

    //To get store name
    public Editable getStoreName() { return Editable.getElementBy(StoreName, "Store Name"); }

    //To get Total amount paid
    public Editable getTotalAmountPaid() { return Editable.getElementBy(TotalPaidAmount, "Total Paid Amount"); }

    //To get date and time of transaction
    public Editable getTransactionDateTime() { return Editable.getElementBy(TransactionDateTime, "Transaction Date"); }

    //To get image of payment method
    public Editable getPaymentMethodImage() { return Editable.getElementBy(PaymentMethodImage, "Payment Method"); }

    //To get PAyment Method Text
    public Editable getPaymentMethodText() { return Editable.getElementBy(PaymentMethodText, "Payment Method"); }

    //Get status to check that amount is paid or not
    public Editable getAmountPaid() { return Editable.getElementBy(AmountPaid, "Amount Paid"); }

    //To get the image of customer
    public Editable getCustomerImg() { return Editable.getElementBy(CustomerImg, "Customer Image"); }

    //To click on any Transaction under Payment History Page
    public Clickable getClickTransaction() { return Clickable.getElementBy(ClickTransaction, "Click Transaction"); }

    //To Copy transaction id
    public Clickable getCopyTransaction() { return Clickable.getElementBy(CopyTransaction, "Copy Transaction"); }

    //To get Amount field
    public Editable getAmountfield() { return Editable.getElementBy(Amountfield, "Amount field"); }

    //To click on transaction
    public Clickable getCustomerTransaction() { return Clickable.getElementBy(CustomerTransaction, "Customer transaction"); }

    //To click on Make Payment
    public Clickable getMakePaymentBtn() { return Clickable.getElementBy(MakePaymentBtn, "Make payment button"); }

    //To click on close button
    public Clickable getCloseButton() { return Clickable.getElementBy(CloseButton, "Close"); }

    //To scroll and click on desired element
    public void scroll(By elementLocator, int maxScrollAttempts) {
        int scrollAttempts = 0;
            while (scrollAttempts < maxScrollAttempts) {
                try {
                    // Check if the element is present and visible
                    WebElement element = getDriver().findElement(elementLocator);
                    if (element.isDisplayed()) {
                        // Scroll the element into view and click it
                        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                        // Click the element
                        getClickPaidTransaction().clickByMouse();
                        System.out.println("Element clicked successfully.");
                        return;
                    }
                } catch (NoSuchElementException e) {
                    // Element not found yet, proceed to scroll
                    System.out.println("Element not found. Scrolling attempt: " + (scrollAttempts + 1));
                }

                // Scroll down by a fixed amount
                ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 7000);");
                scrollAttempts++;
            }



    }



}
