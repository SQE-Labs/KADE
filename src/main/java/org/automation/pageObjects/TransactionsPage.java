package org.automation.pageObjects;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class TransactionsPage extends BasePage {
	//Locators
	By transactionIds =By.xpath("//div[@class='modal-content'] //span[contains(@class,'badge position-relative bg-light text-dark p-1 px-2 text-truncate')]");
	By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
	By memoMessage = By.xpath("//div[@class='mt-1 text-info']");
	By billPaymentTime = By.xpath("(//div[@class='col-7'] //span[@class='fs-pn15'])[1]");
	By transactionRow = By.xpath("//div[@class='d-flex flex-column']");
	By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
	By storesCombobox = By.xpath("//span[@role='combobox']");
	By continueBtn = By.xpath("//button[@type='submit']");
	By lastTransaction = By.xpath("//div[contains(@class,'row bg-white ')]");

	public String getBillAmount() {
		WebdriverWaits.waitForElementVisible(billAmount,5);
		return getText_custom(billAmount);
	}

	public String getMemoMessage(){
		return getText_custom(memoMessage);
	}

	public boolean isUniqueTransactionIdDisplayed() {
		WebdriverWaits.waitForElementVisible(transactionIds,5);
		return isWebElementVisible(transactionIds);
	}

	public String getBillPaymentTime() {
		return getText_custom(billPaymentTime);
	}

	public void clickCloseTransactionPopup() {
		click(closeTransactionPopupBtn);
	}

	public void clickStoresDropdown() {
		click(storesCombobox);
	}

	public void selectStore(String store) {
		click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
	}

	public void clickContinueBtn() {
		click(continueBtn);
	}

	public void clickLastTransaction() {
		WebdriverWaits.waitForElementClickable(lastTransaction,5);
		click(lastTransaction);
	}
}
