package org.automation.pages;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage extends BasePage {
	//Locators
	By transactionRow = By.xpath("//div[contains(@class,'row bg-white ')]");
	By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
	By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
	By storesCombobox = By.xpath("//span[@role='combobox']");
	By continueBtn = By.xpath("//button[@type='submit']");
	By uniqueTransactionId = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate']");
    By transactionID = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate mb-1 max-15c']");
    By store = By.xpath("//span[@class='fs-pn15 mb-2']");
    By payment = By.xpath("//div[@class='fs-pn25']");
    By customerName = By.xpath("//div[@class='d-flex mb-2']");
    By transactionAmmount = By.xpath("//div[@class='d-flex align-items-center']");
    By customNameONRecipt = By.xpath("//a[@class='text-truncate']");
	By time = By.xpath("//span[@class='fs-pn25 mb-2']");
	By informationMessage= By.xpath("//p[text()='There are no payments available yet!']");
	By newBillTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[1]");
	By newChargeTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[2]");
	By filterIcon = By.xpath("//div[@class='d-flex flex-wrap'] //button[3]");
	By terminalAlertMessage = By.xpath("//p[text()='Terminal charges are not accepted']");
	By currentPaidBill = By.xpath("//div[contains(@class,'row bg-white ')][1]");
	By refundButton = By.cssSelector("[title='Refund']");
	By refundRefenceNo = By.cssSelector("[name='refNo']");
	By refundReason = By.cssSelector("[name='reason']");
	By processFullRefund  = By.cssSelector("[name='refundAll']");
	By refundAmountOnReceipt = By.cssSelector("[class=\"d-flex align-items-end\"]");
	By refundLabel= By.xpath("//h4[text()='** Refund **']");
	By verifyButton = By.cssSelector("button.btn.btn-outline-success");
	By partialRefundLink = By.xpath("//button[text()='Partial refund']");
	By selectPaymentInfo = By.cssSelector("div[id='_B1Q'] p");
	By paymentCheckBox = By.xpath(" //label[@class='custom-checkbox']");
	By validationMessage = By.xpath("//p[text()='Select at least one payment to refund']");
	By processRefundButton = By.xpath("//button[text()='Process Refund']");
	By refundAmountField = By.cssSelector("[name='refunds[0].amount']");
    By verifyButtonOnPopup = By.xpath("//button[@class='btn btn-success']");
    By informationMessageOnVerifyPopup = By.xpath("//div[@class='alert-message']");
    By verifyByStoreMssg = By.xpath("//span[@class='badge rounded-pill bg-info px-2']");


	public Clickable getContinueButton(){
		return Clickable.getElementBy(continueBtn,"Continue Button");
	}

	public Clickable getLastTransactionRow(){
		return Clickable.getElementBy(transactionRow,"Last Transaction");
	}

	public Clickable getBillAmount() {
		return Clickable.getElementBy(billAmount,"Bill Amount");
	}

	public Clickable getUniqueTransactionId(){
		return Clickable.getElementBy(uniqueTransactionId,"Transaction ID");
	}

	public Clickable getCloseTransactionPopupButton(){
		return Clickable.getElementBy(closeTransactionPopupBtn,"Close button");
	}
	public Clickable getTransactionID(){
		return  Clickable.getElementBy(transactionID, "transaction ID");
	}

	public Clickable getTransactionAmmount(){
		return  Clickable.getElementBy(transactionAmmount, "transaction Amount");
	}

	public Clickable getPaymentTypeOnTransaction(){
		return  Clickable.getElementBy(payment, "Payment Type");
	}

	public Clickable getStore(){
		return  Clickable.getElementBy(store, "Store Type");
	}

	public Clickable getCustomeName(){
		return  Clickable.getElementBy(customNameONRecipt, "Customer Name");
	}

	public Clickable getCustomerNameOnTransactionPage(){
		return  Clickable.getElementBy(customerName, "Customer Name");
	}
	public void clickStoresDropdown() {
		click(storesCombobox);
	}


	public void selectStore(String store) {
		clickStoresDropdown();
		click(By.xpath("//li[contains(text(),'" + store + "')]"));
		getContinueButton().click();
	}

	public Clickable getTimeOnTransactionPage(){
		return  Clickable.getElementBy(time, "transaction time ");
	}

	public boolean matchPattern(String transID){
		if (transID.startsWith("T-")) {
			transID = transID.substring(2);
		}
		boolean checkflag = true ;
		// Check if the transaction ID contains only digits on Transaction Page
		if (!transID.matches("\\d+")) {
			checkflag = false;
		}
		return checkflag;
	}

	public boolean matchTimePattern(String time){
		boolean isValid = time.matches("^(0?[1-9]|1[0-2]):([0-5][0-9]) (AM|PM)$");
        boolean check = true ;
		// Print the result
		if (!isValid) {
			check =false;
		}
		return check;
	}
	public Clickable getInformationMessage() {
		return Clickable.getElementBy(informationMessage, "Information message label");
	}

	public Clickable getNewBillTab() {
		return Clickable.getElementBy(newBillTab, "New Bill Tab");
	}

	public Clickable getNewChargeTab() {
		return Clickable.getElementBy(newChargeTab, "New Charge Tab");
	}

	public Clickable getFilterIcon() {
		return Clickable.getElementBy(filterIcon, "Filter Icon");
	}

	public Clickable getTerminalAlertMessage() {
		return Clickable.getElementBy(terminalAlertMessage , " Alert Message");
	}
	public Clickable getCurrentPaidBill() {
		return Clickable.getElementBy(currentPaidBill , " CurrentPaidBill");
	}
	public Clickable getRefundButton() {
		return Clickable.getElementBy(refundButton, "Refund Button");
	}
	public Editable getRefundReferenceNo() {
		return Editable.getElementBy(refundRefenceNo, "Refund Reference No Field");
	}

	public Editable getRefundReason() {
		return Editable.getElementBy(refundReason, "Refund Reason Field");
	}
	public Clickable getFullRefundButton() {
		return Clickable.getElementBy(processFullRefund, "Process Full Refund");
	}
	public Clickable getRefundAmountOnReceipt() {
		return Clickable.getElementBy(refundAmountOnReceipt, "Refund Amount On Receipt");
	}
	public Clickable getRefundLabel() {
		return Clickable.getElementBy(refundLabel, "Refund Label");
	}
	public Clickable getVerifyButton() {
		return Clickable.getElementBy(verifyButton, "Verify Button");
	}
	public Clickable getPartialRefundLink() {
		return Clickable.getElementBy(partialRefundLink, "Partial Refund Link");
	}
	public Clickable getSelectPaymentInformationMessage() {
		return Clickable.getElementBy(selectPaymentInfo, "Select payments which are refunded from the list below");
	}
	public Clickable getVisaPaymentCheckbox() {
		return Clickable.getElementBy(paymentCheckBox, "Payment Checkbox");
	}
	public Clickable getRefundValidationMessage() {
		return Clickable.getElementBy(validationMessage, "Select atleast one payment method");
	}
	public Clickable getProcessRefundButton() {
		return Clickable.getElementBy(processRefundButton, "Process Refund Button");
	}
	public Editable getRefundAmountField(){
		return Editable.getElementBy(refundAmountField,"Refund Amount");
	}

	public Clickable getVerifyButtonOnPopup(){
		return Clickable.getElementBy(verifyButtonOnPopup,"Verify Button on Popup");
	}

	public Clickable getInformationMessageOnVerifyPopup(){
		return Clickable.getElementBy(informationMessageOnVerifyPopup,"Verify information message on Popup");
	}


	public Clickable getVerifiedByStoreMssg(){
		return Clickable.getElementBy(verifyByStoreMssg,"Verify store message on Transaction Receipt");
	}






}





