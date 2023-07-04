package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class BillPage extends BasePage {

	By newBillBtn = By.xpath("//button[@class='btn btn-outline-dark']");
	By alertMessage = By.xpath("//div[@class='alert-message']");
	By transactionsLink= By.xpath("//a[text()='Transactions']");
	By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
	By closeIcon = By.xpath("//button[@class='btn-close']");
	By popUpHeader = By.xpath("//h4[@class='modal-title']");
	By subTotalBox = By.xpath("//input[@name='subTotal']");
	By customerNumber = By.xpath("//input[@name='phone']");
	By createBtn =By.xpath("//button[@class='btn btn-primary fs-p50']");
	By toastMessage = By.xpath("//div[@class='toast-message']");
	By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
	By addBillDescription = By.xpath("//th[text()='Description']");
	By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
	By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
	
	public boolean billButtonPresent() {
		return isElementPresent_custom(newBillBtn, "New Bill Button");
	}
	
	public boolean isAleartMessageDisplayed() {
		return isElementPresent(alertMessage, "Alert Message Section");
	}
	
	public void clickOnTransactions() {
		click(transactionsLink);
	}
	
	public String getPageHeader() {
		return getText_custom(pageHeader);
	}
	
	public void getBackToPreviousPage() {
		goBackToPreviousPage();
	}
	
	public void closeBtn() {
		click(closeIcon);
	}
	
	public void isAlertNotVisible() {
		isElementPresent_custom(alertMessage, "Alert Message");
	}
	
	public void clickOnNewBill() {
		click(newBillBtn);
	}

	public String getPopUpTitle() {
		return getText_custom(popUpHeader);
	}
	
	public void enterSubTotalAmount(String amount) {
		sendKeys(subTotalBox, amount);
	}
	
	public void enterPhoneNumber(String number) {
		sendKeys(customerNumber, number);
	}
	
	public void clickOnCreate() {
		click(createBtn);
	}
	
	public String getSuccessMessage() {
		return getText_custom(toastMessage);
	}

	public void clickOnAddBillDetail() {
		click(addBillDetails);
		}
	
	public boolean billDetailsHeader() {
		return isElementPresent(addBillDescription, "Add Bill Details description");
	}

	public void clickOnAddMoreRow() {
		click(addMoreRowLink);
	}

	public void moveToSubTotal() {
		moveToWebElement(subTotalBox);
		
	}
	
	public String getToolTipMessage() {
		return getText_custom(toolTipMessage);
	}
}
