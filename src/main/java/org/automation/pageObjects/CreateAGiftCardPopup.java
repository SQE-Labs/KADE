package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class CreateAGiftCardPopup extends BasePage{
	By popupHeader=By.xpath("//h4[@class='modal-title']");
	By closeBtn=By.xpath("//button[@class='btn-close']");
	By findBtn=By.xpath("//i[@class='fal fa-search me-1']");
	By custPhoneNumber = By.xpath("//input[@name='id']");
	By warnningMessage=By.xpath("//h4[@class='text-danger ']");
	By continueBtn=By.xpath("//button[@class='ms-2 btn btn-outline-dark']");
	By initialAmountTbx=By.xpath("//input[@name='initialAmount']");
	By messageBox=By.xpath("//textarea[@name='greetingMessage']");   
	By refNoBox=By.xpath("//input[@name='referenceNo']"); 
	By continueWithoutSearchBox=By.xpath("//button[@class='btn btn-outline-primary']");	
	
	public String getPopupTitle() {
		return getText_custom(popupHeader);
	}
	
	public void clickOnCloseBtn() {
		click(closeBtn);
	}
	
	public void clickOnFind() {
		click(findBtn);
	}
	
	public void enterCustomerPhoneNumber(String string) {
		sendKeys(custPhoneNumber, string);
	}
	
	public String getCustomerPhoneNumberToolTipMessage() {
		moveToWebElement(custPhoneNumber);
		String id=getAttribute(custPhoneNumber, "aria-describedby");
		return getText_custom(By.id(id));
	}
	
	public String getWariningMessage() {
		return getText_custom(warnningMessage);
	}
	
	public boolean isContinueBtnPresent() {
		return isElementPresent(continueBtn,"Continue button");
	}
	
	public boolean isInitialAmountPresent() {
		return isElementPresent(initialAmountTbx,"Initial Amount Textbox");
	}
	
	public boolean isMessageBoxPresent() {
		return isElementPresent(messageBox,"Message Textbox");
	}
	
	public boolean isRefNoTextBoxPresent() {
		return isElementPresent(refNoBox,"Reference No Textbox");
	}
	
	public void clickOnContinueWithoutSearch() {
		click(continueWithoutSearchBox);
	}
	
}
