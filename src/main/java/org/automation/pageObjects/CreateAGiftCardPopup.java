package org.automation.pageObjects;

import java.util.List;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class CreateAGiftCardPopup extends BasePage {
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
	By createBtn=By.xpath("(//button[@class='btn btn-outline-primary ms-auto'])[2]");
	By advancedLink=By.xpath("//button[@class='p-0 mb-1 btn btn-link collapsed']");
	By cardNoTbx=By.xpath("//input[@name='cardNo'] [@class='form-control']");
	By fundingSourceTbx=By.cssSelector("[name='fundSource']");
	By memoTbx=By.xpath("//textarea[@name='memo'] [@class='form-control']");
	By startDate=By.xpath("//input[@name='startDate']");
	By expDate=By.xpath("//input[@name='expDate']");
	By selectList=By.xpath("//select[@name='fundSource']");
	By alertMessage=By.xpath("//div[@class='alert-message']");
	By toastMessage=By.xpath("//div[@class='toast-message']");
	By closeToast=By.xpath("//button[@class='toast-close-button']");
		
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
		WebdriverWaits.waitForElementUntilVisible(custPhoneNumber, 5);
		sendKeys(custPhoneNumber, string);
	}
	
	public String getCustomerPhoneNumberToolTipMessage() {
		return getToolTipMessage(custPhoneNumber);
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

	public void clickOnCreate() {
		click(createBtn);
	}
	
	public String getInitialAmountToolTipMessage() {
		return getToolTipMessage(initialAmountTbx);
	}
	
	public void enterInitialAmt(String amt) {
		sendKeys_withClear(initialAmountTbx, amt);
	}

	public void clickOnAdvancedLink() {
		click(advancedLink);
	}

	public boolean isCardNoFieldPresent() {
		return isElementPresent(cardNoTbx, "Card no. Textbox");
	}

	public boolean isFundingSourceFieldPresent() {
		return isElementPresent(fundingSourceTbx, "Funding Source Textbox");
	}

	public boolean isMemoFieldPresent() {
		return isElementPresent(memoTbx, "Memo Textbox");
	}

	public boolean isStartDateFieldPresent() {
		return isElementPresent(startDate, "Start Date datepicker");
	}

	public boolean isExpDateFieldPresent() {
		return isElementPresent(expDate, "Exp date datepicker");
	}

	public void enterCardNo(String string) {
		sendKeys(cardNoTbx, string);
	}

	public String getCardNo() {
		return getAttributevalue(cardNoTbx, "value");
	}

	public String getTagOfFundingSource() {
		return getTag(fundingSourceTbx);
	}
	
	public List<String> getSelectList() {
		click(selectList);
		return getListOfString(selectList);
	}
	
	public void enterStartDate(String date) {
		sendKeys(startDate, date);
	}

	public String getStartDateToolTipMessage() {
		return getToolTipMessage(startDate);
	}

	public void enterExpDate(String date) {
		scrollToElement(expDate);
	sendKeys(expDate, date);
	}

	public String getExpDateToolTipMessage() {
		scrollToElement(expDate);
		return getToolTipMessage(expDate);
	}

	public void enterRefNo(String string) {
		sendKeys(refNoBox, string);
	}

	public String getAleartMesssage() {
		return getText_custom(alertMessage);
	}

	public String getToastMesssage() {
		return getText_custom(toastMessage);
	}

	public void closeToastMessage() {
		click(closeToast);
	}

	public void clickOnFundingSource() {
		click(fundingSourceTbx);
	}
}
