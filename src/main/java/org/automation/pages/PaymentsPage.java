package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.nio.file.Paths;

public class PaymentsPage extends BasePage {

    /*
    Receive Payment Locators
     */
    By cashBtn = By.xpath("//button[@name='payType']");
    By paidLabel = By.xpath("//div[contains(text(),'Paid')]");
    public By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
    By closeIcon = By.xpath("(//button[@class=\"btn-close\"])[1]");
    By cardNumberTbx = By.id("Field-numberInput");
    By expirationDateTbx = By.id("Field-expiryInput");
    By cvcTbx = By.id("Field-cvcInput");
    By countryDropDown = By.id("Field-countryInput");
    By processBtn = By.xpath("//button[@type=\"submit\" and contains(text(),'Process')]");
    By creditCardInfoFrame = By.xpath("//h5[text()='Credit card information']/../..//iframe");
    By voidBtn = By.xpath("//button[text()='Void']");
    By paymentLogo = By.xpath("//span[@class='payment-logo-bg me-1']");
    By totalPaidAmt = By.xpath("//h4[contains(text(),'Total paid')]");
    By voidedTag = By.xpath("//h6[text()='VOIDED']");
    By changeButton = By.xpath("//div[contains(text(),'Change')]");
    By swipeBtn = By.xpath("//input[@type='range']");
    By closeBtn = By.xpath("//a[text()='Close']");


    /*
    Receive Payment popup locators
     */
    By balanceDue = By.xpath("//span[text()='Balance Due:']//following-sibling::span");
    By totalAmount = By.xpath("//span[contains(text(),'Total')]");
    By receiveAmountTbx = By.xpath("//input[@name='amount']");
    By creditCardBtn = By.xpath("//button[text()='Credit Card']");
    By othersBtn = By.xpath("//button[text()='Other']");
    By savedCreditcard = By.xpath("//div[contains(@class,'-paymethodbox-')] //span[contains(text(),'Visa')]");


    /*
    Payment Type Panel
     */
    public By paymentTypeHeader = By.xpath("//h5[@class='offcanvas-title' and text()='Payment type']");
    By venmoPaymentType = By.xpath("(//button[@name='payType'])[1]/..");
    By zellePaymentType = By.xpath("(//button[@name='payType'])[2]/..");
    By cashPaymentType = By.xpath("//span[text()='Cash']/../../..");
    By memoTextbox = By.xpath("//textarea[@name='message']");
    By receivingAmtPaymentTypePanel = By.xpath("//span[@data-field='amount']");
    By payNowButton = By.xpath("//button[@type=\"button\" and text()='Pay Now']");

    By rejectButton = By.xpath("//button[text()='Reject']");
    By rejectReason = By.xpath("(//i[contains(@class,'fal fa-circle custom-check-off')])[1]");
    By submitButton = By.xpath("//button[text()='Submit']");
    By rejectToastMessage = By.xpath("//div[@class='toast-message']");
    By confirmationPopUp = By.xpath("//h5[text()='Confirmation']");

    // By savedCreditcard = By.xpath("//div[contains(@class,'-paymethodbox-')] //span[contains(text(),'Visa')]");
    By savedBankAccount = By.xpath("(//span[text()='Bank Account 6789'])[1]");
    By SavedVenmoCard = By.xpath("//div//span[text()='Venmo']");
    By iMadeMyPaymentButtonVenmo = By.xpath("//div/div/button[text()='I made the payment']");
    By personalMessageVenmo = By.xpath("//textarea[@placeholder='Personal message']");
    By screenshotButton = By.xpath("//button[text()='Do you have a screenshot?']");
    By confirmVenmoCheckbox = By.xpath(" //span[@class='ms-1']");
    By venmoSubmitButton = By.xpath(" //button[text()='Submit']");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By selectedBankDisplay = By.xpath("//div[@class='-placeholder- link-empty']");

    // Assertion elements of Venmo Card
    By qrVenmoPopup = By.xpath("//div[@class='fs-4 text-center py-2 ']");
    By venmoPopup = By.xpath("(//h5[@class='modal-title'])[1]");
    By copyLink = By.xpath("//span[text()='Copy']");
    By getUploadedImage = By.xpath("//div[@class='my-2 display-none']/img");
    By processSuccessMsg = By.xpath("//span[@class='fs-4']");
    By rateYourExperienceLink = By.xpath("//div[@class='col-sm fs-4 pb-2']");
    By viewReceipt = By.xpath("//div[@class='mt-4']/child::div/a[1]");
    By closeBlueBtn = By.xpath("//a[text()='Close']");
    By tapToPayMoreLink = By.partialLinkText("Tap to pay more");
    //By tapToPayMoreLink=By.xpath("//a[text()='Tap to pay more']");
    By moreAmountTbx = By.xpath("//input[@lbl-title='Amount']");
    By updateButton = By.xpath("(//button[contains(text(),'Update')])[2]");
    By swipeButton = By.xpath("//a[contains(@class,' -updateamount-')]");
    By savedZellePaymentButton = By.xpath("//div//span[text()='Zelle']");
    By zellePopup = By.xpath("//h5[@class='modal-title']//span");
    By zelleCopyLink = By.xpath("//span[text()='Copy']");


    public PaymentsPage() {
    }

    public void clickCashBtn() {
        WebdriverWaits.waitForElementVisible(paymentPopupTitle, 5);
        moveToWebElement(cashBtn);
        clickElementByJS(cashBtn);
    }

    public Clickable getCashButton() {
        return Clickable.getElementBy(cashPaymentType, "Cash Button");
    }

    public Clickable getOthersButton() {
        return Clickable.getElementBy(othersBtn, "Other button");
    }

    public Editable getAmountTextbox() {
        return Editable.getElementBy(receiveAmountTbx, "Receiving amount textbox");
    }

    public Clickable getPaidLabel() {
        return Clickable.getElementBy(paidLabel, "Paid label on Bill");
    }

    public boolean isPaidLabelDisplayed() {
        WebdriverWaits.waitForElementVisible(paidLabel, 5);
        return isWebElementVisible(paidLabel);
    }

    public Clickable getReceivedPaymentTitle() {
        return Clickable.getElementBy(paymentPopupTitle, "Receive Payment Popup Title");
    }

    public Clickable getCreditCardButton() {
        return Clickable.getElementBy(creditCardBtn, "Credit card button");
    }


    public Editable getCardNumberTextbox() {
        return Editable.getElementBy(cardNumberTbx, "Card Number textbox");
    }

    public Editable getExpirationDateTextbox() {
        return Editable.getElementBy(expirationDateTbx, "Expiration Date textbox");
    }

    public Editable getCvcTextbox(){
        return Editable.getElementBy(cvcTbx,"CVC textbox");
    }

    public void selectCountry(String country) {
        selectDropDownByVisibleText_custom(countryDropDown, country);
    }

    public void clickProcessBtn() {
        click(processBtn);
    }

    public void switchToCreditCardFrame() {
        switchToFrame(creditCardInfoFrame);
    }

    public Clickable getBalanceDue() {
        return Clickable.getElementBy(balanceDue, "Balance Due Field");
    }

    public Clickable getTotalAmount() {
        return Clickable.getElementBy(totalAmount, "Total amount element");
    }

    public Clickable getReceivingAmount() {
        return Clickable.getElementBy(receiveAmountTbx, "value");
    }

    public Clickable getPaymentTypePanelHeader() {
        return Clickable.getElementBy(paymentTypeHeader, "Payment Type Header");
    }


    public Clickable getPaymentLogo() {
        return Clickable.getElementBy(paymentLogo, "Payment type logo");
    }

    public void payByCreditCard() {
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

    public Editable getReceivingAmountTextbox() {
        return Editable.getElementBy(receiveAmountTbx);
    }

    public Clickable getReceivingAmountFromPaymentTypePanel() {
        return Clickable.getElementBy(receivingAmtPaymentTypePanel, "Receiving Amount Payment Type Panel");
    }

    public Clickable getChangePaymentMethodButton() {
        return Clickable.getElementBy(changeButton, "change Payment Method button");
    }

    public Clickable getTotalPaidAmount() {
        return Clickable.getElementBy(totalPaidAmt, "Total Paid Amount");
    }

    public Clickable getZelleButton() {
        WebdriverWaits.waitForElementVisible(paymentPopupTitle, 5);
        return Clickable.getElementBy(zellePaymentType);
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
        return Clickable.getElementBy(voidBtn, "Void Button");
    }

    public Clickable getVoidedTag() {
        return Clickable.getElementBy(voidedTag, "Voided Tag");
    }

    public Clickable getMomoTextbox() {
        return Clickable.getElementBy(memoTextbox, "Memo Textbox");
    }

    public Clickable getPayNowButton() {
        return Clickable.getElementBy(payNowButton, "Pay Now Button");
    }

    public Clickable getChangePaymentButton() {
        return Clickable.getElementBy(changeButton, "change Payment type button");
    }

    public Clickable getSavedCreditCard() {
        return Clickable.getElementBy(savedCreditcard, "Saved Credit card");
    }

    public void swipeToPay() {
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(swipeBtn);
        actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
    }

    public Clickable getCloseButton() {
        return Clickable.getElementBy(closeBtn, "Close Button");
    }

    public Clickable getSavedBankAccount() {
        return Clickable.getElementBy(savedBankAccount, "Saved Bank Account Card");
    }

    public Clickable getSavedVenmoCard() {
        return Clickable.getElementBy(SavedVenmoCard, "Venmo Card");
    }

    public Clickable getIMadeMyPaymentButton() {
        return Clickable.getElementBy(iMadeMyPaymentButtonVenmo);
    }

    public Editable getVenmoPaymentText() {
        return Editable.getElementBy(personalMessageVenmo);
    }

    public Clickable getScreenshotButton() {
        return Clickable.getElementBy(screenshotButton);
    }

    // For Attaching image for Venmo payment Screenshot
    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void uploadVenmoImageScreenshot() throws AWTException {
        uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
    }

    public Clickable getCheckButton() {
        return Clickable.getElementBy(checkBtn, "Check Button");
    }

    public Clickable getConfirmVenmoCheckbox() {
        return Clickable.getElementBy(confirmVenmoCheckbox);
    }

    public Clickable getVenmoSubmitButton() {
        return Clickable.getElementBy(venmoSubmitButton);
    }


    //Assertion for Venmo
    public Clickable getVenmoPopup() {
        return Clickable.getElementBy(venmoPopup);
    }

    public Clickable getVenmoQrCode() {
        return Clickable.getElementBy(qrVenmoPopup);
    }

    public Clickable getCopyLink() {
        return Clickable.getElementBy(copyLink);
    }

    public Clickable getUploadedImage() {
        return Clickable.getElementBy(getUploadedImage);
    }


    public Clickable getRejectButton() {
        return Clickable.getElementBy(rejectButton, "Reject Button");
    }

    public Clickable getRejectReason() {
        return Clickable.getElementBy(rejectReason, "Reject Reason");
    }

    public Clickable getSubmitButton() {
        return Clickable.getElementBy(submitButton, "Submit Button");
    }

    public Editable getRejectToastMessage() {
        return Editable.getElementBy(rejectToastMessage, "Reject Toast Message");
    }

    public Editable getConfirmationPopUpTitle() {
        return Editable.getElementBy(confirmationPopUp, "Confirmation Pop Up");
    }

    public Clickable getSelectedBankDisplay() {
        return Clickable.getElementBy(selectedBankDisplay);
    }

    public Clickable getProcessSuccessMsg() {
        return Clickable.getElementBy(processSuccessMsg);
    }

    public Clickable getRateYourExperienceLink() {
        return Clickable.getElementBy(rateYourExperienceLink);
    }

    public Clickable getViewReceiptLink() {
        return Clickable.getElementBy(viewReceipt);
    }

    public Clickable getBlueCloseButton() {
        return Clickable.getElementBy(closeBlueBtn);
    }

    public Clickable getTapToPayMoreLink() {
        return Clickable.getElementBy(tapToPayMoreLink, "Tap To Pay More Link");
    }

    public Clickable getSwipeToPayButton() {
        return Clickable.getElementBy(swipeButton, "Swipe To Pay Button");
    }

    public Clickable getAmountUpdateButton() {
        return Clickable.getElementBy(updateButton, "Amount Update Button");
    }

    public Editable getMoreAmountField() {
        return Editable.getElementBy(moreAmountTbx, "More Amount Field");
    }

    // Zelle Payment Methods
    public Clickable getSavedZelleCard() {
        return Clickable.getElementBy(savedZellePaymentButton);
    }

    public Clickable getZellePopup() {
        return Clickable.getElementBy(zellePopup);
    }

    public Clickable getZelleCopyLink() {
        return Clickable.getElementBy(zelleCopyLink);
    }
}
