package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.session.KadeSession;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;

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


    /*
    Receive Payment popup locators
     */
    By balanceDue=By.xpath("//span[text()='Balance Due:']//following-sibling::span");
    By totalAmount= By.xpath("//span[contains(text(),'Total')]");
    By receiveAmountTbx = By.xpath("//input[@name='amount']");
    By creditCardBtn = By.xpath("//button[text()='Credit Card']");
    By othersBtn =By.xpath("//button[text()='Other']");

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

    public boolean isPaidLabelDisplayed(){
        WebdriverWaits.waitForElementVisible(paidLabel,5);
        return isWebElementVisible(paidLabel);
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

    public void enterCardNumber(String cardNumber){
        pressKeys(cardNumberTbx,cardNumber);
    }

    public Editable getCardNumberTextbox(){
        return Editable.getElementBy(cardNumberTbx);
    }
    public void enterExpirationDate(String expiryDate){
        pressKeys(expirationDateTbx,expiryDate);
    }

    public Editable getExpirationDateTextbox(){
        return Editable.getElementBy(expirationDateTbx);
    }

    public void enterCvcNumber(String cvcNumber){
        pressKeys(cvcTbx,cvcNumber);
    }

    public Editable getCvcNumberTextbox(){
        return Editable.getElementBy(cvcTbx);
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

    public boolean isCreditCardBtnDisplayed(){
        return isWebElementVisible(creditCardBtn);
    }

    public boolean isOtherBtnDisplayed(){
        return isWebElementVisible(othersBtn);
    }

    public Clickable getPaymentTypePanelHeader() {
        return Clickable.getElementBy(paymentTypeHeader,"Payment Type Header");
    }

    public boolean isVenmoPaymentTypeDisplayed() {
        return isWebElementVisible(venmoPaymentLogo);
    }

    public boolean isZellePaymentTypeDisplayed() {
        return isWebElementVisible(zellePaymentLogo);
    }

    public boolean isCashPaymentTypeDisplayed() {
        return isWebElementVisible(cashPaymentType);
    }

    public boolean isMemoTextboxDisplayed() {
        return isWebElementVisible(memoTextbox);
    }

    public boolean isVoidBtnDisplayed() {
        return isWebElementVisible(voidBtn);
    }

    public boolean isPaymentLogoDisplayed(){
        return isWebElementVisible(paymentLogo);
    }

    public Clickable getPaymentLogo(){
        return Clickable.getElementBy(paymentLogo,"Payment type logo");
    }

    public void payByCreditCard(){
        WebdriverWaits.sleep(10);
        switchToCreditCardFrame();
        enterCardNumber("4111111111111111");
        enterExpirationDate("0230");
        enterCvcNumber("123");
        selectCountry("Australia");
        switchToDefaultWindow();
        clickProcessBtn();
    }

    public void payByVenmo() {
        WebdriverWaits.waitForElementVisible(paymentPopupTitle,5);
        clickElementByJS(venmoPaymentType);
    }

    public void payByZelle() {
        WebdriverWaits.waitForElementVisible(paymentPopupTitle,5);
        clickElementByJS(zellePaymentType);
    }

    public void enterAmount(String amount) {
        pressKeys(receiveAmountTbx,amount);
    }

    public Editable getReceivingAmountTextbox(){
        return Editable.getElementBy(receiveAmountTbx);
    }

    public Clickable getOtherButton(){
        return Clickable.getElementBy(othersBtn);
    }

    public String getReceivingAmountFromPaymentTypePanel() {
        return getText_custom(receivingAmtPaymentTypePanel);
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
}
