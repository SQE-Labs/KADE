package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;

public class PaymentsPage extends BasePage {

    /*
    Receive Payment Locators
     */
    By cashBtn = By.xpath("//button[@name='payType']");
    By paidLabel = By.xpath("//div[contains(text(),'Paid')]");
    By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
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
    By venmoPaymentType= By.xpath("(//button[@name='payType'])[1]");
    By venmoPaymentLogo = By.xpath("//span[text()='Venmo']");
    By zellePaymentLogo = By.xpath("//span[text()='Zelle']");
    By zellePaymentType = By.xpath("(//button[@name='payType'])[2]");
    By cashPaymentType = By.xpath("//span[text()='Cash']");
    By memoTextbox=By.xpath("//textarea[@name='message']");
    By receivingAmtPaymentTypePanel = By.xpath("//span[@data-field='amount']");


    //Actions
    public void clickOthersBtn(){
        click(othersBtn);
    }

    public void clickCashBtn(){
        WebdriverWaits.waitForElementVisible(paymentPopupTitle,5);
        moveToWebElement(cashBtn);
        clickElementByJS(cashBtn);
    }

    public boolean isPaidLabelDisplayed(){
        WebdriverWaits.waitForElementVisible(paidLabel,5);
        return isWebElementVisible(paidLabel);
    }

    public String getReceivedPaymentTitle(){
        return getText_custom(paymentPopupTitle);
    }

    public void closeReceivedPopup(){
        click(closeIcon);
    }

    public void clickCreditCardBtn(){
        click(creditCardBtn);
    }

    public void enterCardNumber(String cardNumber){
        pressKeys(cardNumberTbx,cardNumber);
    }

    public void enterExpirationDate(String expiryDate){
        pressKeys(expirationDateTbx,expiryDate);
    }

    public void enterCvcNumber(String cvcNumber){
        pressKeys(cvcTbx,cvcNumber);
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
    public String getBalanceDue() {
        return getText_custom(balanceDue);
    }

    public String getTotalAmount(){
        return getText_custom(totalAmount).split(" ")[1];
    }

    public String getReceivingAmount(){
        return getAttribute(receiveAmountTbx,"value");
    }

    public boolean isCreditCardBtnDisplayed(){
        return isWebElementVisible(creditCardBtn);
    }

    public boolean isOtherBtnDisplayed(){
        return isWebElementVisible(othersBtn);
    }

    public String getPaymentTypePanelHeader() {
        return getText_custom(paymentTypeHeader);
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

    public void payByCreditCard(String cardNo, String expDate, String cvcNo, String country){
        WebdriverWaits.sleep(10);
        switchToCreditCardFrame();
        enterCardNumber(cardNo);
        enterExpirationDate(expDate);
        enterCvcNumber(cvcNo);
        selectCountry(country);
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

    public String getReceivingAmountFromPaymentTypePanel() {
        return getText_custom(receivingAmtPaymentTypePanel);
    }

    public String getTotalPaidAmount() {
        return getText_custom(totalPaidAmt).split(":")[1];
    }
}
