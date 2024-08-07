package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.session.KadeSession;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PaymentsPage extends BasePage {

    /*
    Receive Payment Locators
     */
    By cashBtn = By.xpath("//button[@name='payType']");
    By paidLabel = By.xpath("//div[contains(text(),'Paid')]");
    public By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
    By closeIcon =By.xpath("(//button[@class=\"btn-close\"])[1]");
    By creditCardInfoPopupTitle = By.xpath("//h5[text()='Credit card information']");
    By cardNumberTbx = By.id("Field-numberInput");
    By expirationDateTbx = By.id("Field-expiryInput");
    By cvcTbx = By.id("Field-cvcInput");
    By countryDropDown = By.id("Field-countryInput");
    By processBtn = By.xpath("//button[@type=\"submit\" and contains(text(),'Process')]");
    By creditCardInfoFrame = By.xpath("//h5[text()='Credit card information']/../..//iframe");
    By voidBtn = By.xpath("//button[text()='Void']");
    By paymentLogo = By.xpath("//span[@class='payment-logo-bg me-1']");
    By totalPaidAmt = By.xpath("//h4[contains(text(),'Total paid')]");
    By voidedTag=By.xpath("//h6[text()='VOIDED']");
    By changeButton=By.xpath("//div[contains(text(),'Change')]");
    By swipeBtn = By.xpath("//input[@type='range']");
    By closeBtn = By.xpath("//a[text()='Close']");


    /*
    Receive Payment popup locators
     */
    By balanceDue=By.xpath("//span[text()='Balance Due:']//following-sibling::span");
    By totalAmount= By.xpath("//span[contains(text(),'Total')]");
    By receiveAmountTbx = By.xpath("//input[@name='amount']");
    By creditCardBtn = By.xpath("//button[text()='Credit Card']");
    By othersBtn =By.xpath("//button[text()='Other']");
    By savedCreditcard=By.xpath("//div[contains(@class,'-paymethodbox-')] //span[contains(text(),'Visa')]");


    /*
    Payment Type Panel
     */
    public By paymentTypeHeader = By.xpath("//h5[@class='offcanvas-title' and text()='Payment type']");
    By venmoPaymentType= By.xpath("(//button[@name='payType'])[1]/..");
    By venmoPaymentLogo = By.xpath("//span[text()='Venmo']");
    By zellePaymentLogo = By.xpath("//span[text()='Zelle']");
    By zellePaymentType = By.xpath("(//button[@name='payType'])[2]/..");
    By cashPaymentType = By.xpath("//span[text()='Cash']/../../..");
    By memoTextbox=By.xpath("//textarea[@name='message']");
    By receivingAmtPaymentTypePanel = By.xpath("//span[@data-field='amount']");
    By payNowButton = By.xpath("//button[@type='button' and text()='Pay Now']");

    public PaymentsPage(){
    }

    public void clickCashBtn(){
        WebdriverWaits.waitForElementVisible(paymentPopupTitle,5);
        moveToWebElement(cashBtn);
        clickElementByJS(cashBtn);
    }

    public Clickable getCashButton(){
        return Clickable.getElementBy(cashPaymentType,"Cash Button");
    }
    //PerformActions
    public void clickOthersBtn(){
        click(othersBtn);
    }

    public Clickable getOthersButton(){
        return Clickable.getElementBy(othersBtn,"Other button");
    }

    public Editable getAmountTextbox(){
        return Editable.getElementBy(receiveAmountTbx,"Receiving amount textbox");
    }

    public Clickable getPaidLabel(){
        return Clickable.getElementBy(paidLabel,"Paid label on Bill");
    }

    public Clickable getReceivedPaymentTitle(){
        return Clickable.getElementBy(paymentPopupTitle,"Receive Payment Popup Title");
    }

    public Clickable getReceivedPaymentPopupTitle(){
        return Clickable.getElementBy(paymentPopupTitle,"Received Payment Title");
    }

    public void closeReceivedPopup(){
        click(closeIcon);
    }

    public void clickCreditCardBtn(){
        click(creditCardBtn);
    }
    public Clickable getCreditCardButton(){
        return Clickable.getElementBy(creditCardBtn,"Credit card button");
    }

    public Editable getCardNumberTextbox(){
        return Editable.getElementBy(cardNumberTbx,"Card Number textbox");
    }

    public Editable getExpirationDateTextbox(){
        return Editable.getElementBy(expirationDateTbx,"Expiration Date textbox");
    }

    public Editable getCvcTextbox(){
        return Editable.getElementBy(cvcTbx,"CVC textbox");
    }

    public void selectCountry(String country){
        selectDropDownByVisibleText_custom(countryDropDown,country);
    }

    public void clickProcessBtn(){
        click(processBtn);
    }

    public void switchToCreditCardFrame() {
        switchToFrame(creditCardInfoFrame);
    }


    public Clickable getBalanceDue() {
        return Clickable.getElementBy(balanceDue, "Balance Due Field");
    }

    public Clickable getTotalAmount(){
        return Clickable.getElementBy(totalAmount,"Total amount element");
    }

    public Clickable getReceivingAmount(){
        return Clickable.getElementBy(receiveAmountTbx,"value");
    }

    public Clickable getPaymentTypePanelHeader() {
        return Clickable.getElementBy(paymentTypeHeader,"Payment Type Header");
    }

    public Clickable getPaymentLogo(){
        return Clickable.getElementBy(paymentLogo,"Payment type logo");
    }

    public void payByCreditCard(){
        WebdriverWaits.sleep(10);
        switchToCreditCardFrame();
        getCardNumberTextbox().setText("4111111111111111");
        getExpirationDateTextbox().setText("0230");
        getCvcTextbox().setText("123");
        selectCountry("Australia");
        switchToDefaultWindow();
        getProcessPaymentButton().click();
    }

    private Clickable getProcessPaymentButton() {
        return Clickable.getElementBy(processBtn,"Process Payment Button");
    }

    public Editable getReceivingAmountTextbox(){
        return Editable.getElementBy(receiveAmountTbx);
    }

    public Clickable getOtherButton(){
        return Clickable.getElementBy(othersBtn);
    }

    public Clickable getReceivingAmountFromPaymentTypePanel() {
        return Clickable.getElementBy(receivingAmtPaymentTypePanel,"Receiving Amount Payment Type Panel");
    }

    public Clickable getTotalPaidAmount() {
        return Clickable.getElementBy(totalPaidAmt,"Total Paid Amount");
    }

    public Clickable getZelleButton() {
        WebdriverWaits.waitForElementVisible(paymentPopupTitle,5);
        return  Clickable.getElementBy(zellePaymentType);
    }

    public Clickable getCloseReceivedPopupButton() {
        return Clickable.getElementBy(closeIcon, "Close Received Button");
    }

    public Clickable getVenmoButton() {
        return Clickable.getElementBy(venmoPaymentType);
    }

    public Clickable getCreditCardBtn() {
        return Clickable.getElementBy(creditCardBtn);
    }

    public Clickable getVoidButton() {
        return Clickable.getElementBy(voidBtn,"Void Button");
    }
    public Clickable getVoidedTag() {
        return Clickable.getElementBy(voidedTag,"Voided Tag");
    }

    public Clickable getMomoTextbox() {
        return Clickable.getElementBy(memoTextbox,"Memo Textbox");
    }

    public Clickable getPayNowButton() {
        return Clickable.getElementBy(payNowButton,"Pay Now Button");
    }

    public Clickable getChangePaymentButton() {
        return Clickable.getElementBy(changeButton,"change Payment type button");
    }

    public Clickable getSavedCreditCard() {
        return Clickable.getElementBy(savedCreditcard,"Saved Credit card");
    }

    public void swipeToPay() {
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(swipeBtn);
        actions.moveToElement(elm).moveByOffset(-100,0).clickAndHold().moveByOffset(200, 0).release().perform();
    }

    public Clickable getCloseButton() {
        return Clickable.getElementBy(closeBtn, "Close Button");
    }
}
