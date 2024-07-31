package org.automation.pages;
import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class TransactionsPage extends BasePage {
	//Locators
	By transactionRow = By.xpath("//div[contains(@class,'row bg-white ')]");
	By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
	By memoMessage = By.xpath("//div[@class='mt-1 text-info']");
	By billPaymentTime = By.xpath("(//div[@class='col-7'] //span[@class='fs-pn15'])[1]");
	By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
	By storesCombobox = By.xpath("//span[@role='combobox']");
	By continueBtn = By.xpath("//button[@type='submit']");

	public void clickContinueBtn() {
		click(continueBtn);
	}
	public void clickLastTransaction(){
		click(transactionRow,"Last Transaction");
	}

	public Clickable getLastTransactionRow(){
		return Clickable.getElementBy(transactionRow,"Last Transaction");
	}

	public String getBillAmount() {
		WebdriverWaits.sleep(5000);
		WebdriverWaits.waitForElementVisible(billAmount,5);
		return getText_custom(billAmount);
	}

	public String getMemoMessage(){
		return getText_custom(memoMessage);
	}

	public boolean isUniqueTransactionIdDisplayed() {
		return isWebElementVisible(transactionRow);
	}

	public String getBillPaymentTime() {
		return getText_custom(billPaymentTime);
	}

	public void clickCloseTransactionPopup() {
		click(closeTransactionPopupBtn);
	}

	public Clickable getCloseTransactionPopupButton(){
		return Clickable.getElementBy(closeTransactionPopupBtn,"Close button for transaction popup");
	}
	public void clickStoresDropdown() {
		click(storesCombobox);
	}
	public void selectStore(String store) {
		clickStoresDropdown();
		click(By.xpath("//li[contains(text(),'" + store + "')]"));
		clickContinueBtn();
	}
}
