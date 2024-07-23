package org.automation.pageObjects;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class TransactionsPage extends BasePage {
	//Locators
	By transactionIds =By.cssSelector("div.row div:nth-child(1) div div:nth-child(1)");
	By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
	By memoMessage = By.xpath("//div[@class='mt-1 text-info']");
	By billPaymentTime = By.xpath("(//div[@class='col-7'] //span[@class='fs-pn15'])[1]");
	By transactionRow = By.xpath("//div[@class='d-flex flex-column']");
	By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");

	public void clickLastTransaction(){
		click(transactionIds);
	}

	public String getBillAmount() {
		WebdriverWaits.waitForElementVisible(billAmount,5);
		return getText_custom(billAmount);
	}

	public String getMemoMessage(){
		return getText_custom(memoMessage);
	}

	public boolean isUniqueTransactionIdDisplayed() {
		return isWebElementVisible(transactionIds);
	}

	public String getBillPaymentTime() {
		return getText_custom(billPaymentTime);
	}

	public void clickCloseTransactionPopup() {
		click(closeTransactionPopupBtn);
	}
}
