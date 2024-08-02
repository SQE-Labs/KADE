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
	By uniqueTransactionId = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate']");

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
		return Clickable.getElementBy(closeTransactionPopupBtn,"Close button for transaction popup");
	}
	public void clickStoresDropdown() {
		click(storesCombobox);
	}

	public void selectStore(String store) {
		clickStoresDropdown();
		click(By.xpath("//li[contains(text(),'" + store + "')]"));
		getContinueButton().click();
	}
}
