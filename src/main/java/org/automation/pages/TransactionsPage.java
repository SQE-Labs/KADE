package org.automation.pages;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

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
	By newChargeAmountField = By.xpath("//input[@lbl-title='Amount']");
	By newChargeConfirm = By.xpath("//button[@name='method' and @type= 'submit']");
	By terminalAlertMessage = By.xpath("//p[text()='Terminal charges are not accepted']");
    // New charge credit card
	By creditCardInfoPopup = By.xpath("//h5[text()='Credit card information']/../..//iframe");
	By cardNumberTbx = By.id("Field-numberInput");
	By expirationDateTbx = By.id("Field-expiryInput");
	By cvcTbx = By.id("Field-cvcInput");
	By countryDropDown = By.id("Field-countryInput");
	By processBtn = By.xpath("//button[@type=\"submit\" and contains(text(),'Process')]");
	By sendReceiptTitle = By.xpath("//h5[text()='Send the receipt']");

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

	// Enter Amount in New Charge Field.
	public Editable getNewChargeAmountField() {
		return Editable.getElementBy(newChargeAmountField, "New  charge amount field");
	}

	public Clickable getNewChargeConfirmButton() {
		return Clickable.getElementBy(newChargeConfirm, "New charge config button");
		}

	public Clickable getTerminalAlertMessage() {
		return Clickable.getElementBy(terminalAlertMessage , " Alert Message");
	}

	public void switchToCreditCardPopup() {
		switchToFrame(creditCardInfoPopup);
	}
	public Editable getCardNumberTextbox() {
		return Editable.getElementBy(cardNumberTbx, "Card Number textbox");
	}

	public Editable getExpirationDateTextbox() {
		return Editable.getElementBy(expirationDateTbx, "Expiration Date textbox");
	}

	public Editable getCvcTextbox() {
		return Editable.getElementBy(cvcTbx, "CVC textbox");
	}

	public void selectCountry(String country) {
		selectDropDownByVisibleText_custom(countryDropDown, country, "Country Dropdown");
	}

	public void clickProcessBtn() {
		click(processBtn);
	}

	public void payByCreditCard() {
		switchToCreditCardPopup();
		getCardNumberTextbox().setText("4111111111111111");
		getExpirationDateTextbox().setText("0830");
		getCvcTextbox().setText("123");
		selectCountry("Australia");
		switchToDefaultWindow();
		clickProcessBtn();
	}

	public Clickable getSendReceiptTitle() {
		return Clickable.getElementBy(sendReceiptTitle);
	}


}





