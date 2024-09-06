package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class SecurityAndPasswordPage extends BasePage {

	By editEmailIcon = By.xpath("(//button[@class='btn btn-outline-secondary'])[1]");
	By popupHeader = By.xpath("//h4[@class='modal-title']");
	By popupCloseBtn = By.xpath("//div[@class='modal-header']/button");
	By sendSecurityCodeBtn=By.xpath("//div[@class='modal-footer'] //button[text()='Send Security Code']");
	By newEmailTbx =By.xpath("//input[@placeholder='email@gmail.com']");
	By currentOTP=By.xpath("(//div[@class='mb-3 ']/input)[1]");
	By otp=By.xpath("(//div[@class='mb-3 ']/input)[2]");
	By saveBtn=By.xpath("//button[@class='display-none -otp- btn btn-primary']");
	By validationMessage=By.xpath("//div[@class='alert-message']/p");
	By differentEmailLink=By.xpath("(//button[@class='btn btn-link'])[2]");
	By editCellPhoneIcon=By.xpath("(//button[@class='btn btn-outline-secondary'])[2]");
	By newCellPhone=By.xpath("(//input[@name='phone'])[2]");
	By differentPhoneLink=By.xpath("(//button[@class='btn btn-link'])[2]");
	By closeValidationIcon=By.xpath("(//button[@class='btn-close'])[2]");
	By resetYourPasswordBtn=By.xpath("//div[@class='col-sm-10']/a");
	By deleteAccountButton = By.xpath("//button[text()='Close and delete my account']");
	By tickIcon = By.cssSelector("[class='btn btn-outline-success']");
	public void clickOnEditEmailIcon() {
		click(editEmailIcon);
	}
	
	public String getHeaderText() {
		return getText_custom(popupHeader);
		}
	
	public void closePopup() {
		WebdriverWaits.sleep(500);
		click(popupCloseBtn);
	}
	
	public String getNewEmailToolTipMessage() {
		WebdriverWaits.sleep(500);
		return getToolTipMessage(newEmailTbx);
	}

	public void clickOnSendSecurityCodeBtn() {
		click(sendSecurityCodeBtn);
	}

	public void enterNewEmail(String string) {
		sendKeys_withClear(newEmailTbx, string);
	}

	public boolean isElementPresent() {
		WebdriverWaits.waitForElementUntilVisible(currentOTP, 5);
		return isElementPresent(currentOTP, "Current Email OTP textbox") && isElementPresent(otp, "OTP textbox");
	}

	public void clickOnSaveBtn() {
		click(saveBtn);
	}

	public String getCurrentEmaiOtplToolTipMessage() {
		click(popupHeader);
		return getToolTipMessage(currentOTP);
	}

	public String getNewEmailOtpToolTipMessage() {
		return getToolTipMessage(otp);
	}

	public void enterCurrentEmailOtp(int i) {
		sendKeysUsingJavaScript(currentOTP, "document.getElementsByName('current_OTP')[0].value="+i);
	}

	public void enterCurrentCellPhoneOtp(int i) {
		sendKeysUsingJavaScript(otp, "document.getElementsByName('current_otp')[0].value="+i);
	}
	
	public void enterNewEmailOtp(int i) {
		sendKeysUsingJavaScript(otp, "document.getElementsByName('otp')[0].value="+i);
	}

	public String getValidationlToolTipMessage() {
		WebdriverWaits.waitForElementUntilVisible(validationMessage, 5);
		return getText_custom(validationMessage);
	}

	public void clickDifferentEmailLink() {
		click(differentEmailLink);
	}

	public boolean isNewEmailPresent() {
		return isElementPresent(newEmailTbx, "New Email Tbx");
	}

	public void clickOnEditCellPhoneIcon() {
		click(editCellPhoneIcon);
	}

	public String getNewCellPhoneToolTipMessage() {
		WebdriverWaits.waitForElementUntilVisible(newCellPhone, 5);
		return getToolTipMessage(newCellPhone);
	}

	public void enterNewCellPhoneNumber(String string) {
		sendKeys(newCellPhone, string);
	}

	public void enterNewCellPhoneOtp(int i) {
		sendKeysUsingJavaScript(otp, "document.getElementsByName('otp')[0].value="+i);
	}

	public void clickDifferentCellPhoneLink() {
		click(differentPhoneLink);	
		}

	public boolean isNewCellPhoneTbxPresent() {
		return isElementPresent(newCellPhone, "New cell phone tbx");
	}

	public void clickResetYourPassword() {
		click(resetYourPasswordBtn);
	}

	public String getTitleOfPage(String string) {
		WebdriverWaits.waitForPageTitle(string, 5);
		return getPageTitle();
	}
	public Clickable getDeleteAccountButton(){
		return Clickable.getElementBy(deleteAccountButton,"Close and Delete account Button");
	}
	public Clickable getTickIcon(){
		return Clickable.getElementBy(tickIcon,"Tick Icon");
	}



}
