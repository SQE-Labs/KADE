package org.automation.pageObjects;

import java.awt.*;
import java.nio.file.Paths;
import java.util.List;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

	By registerNewBusinessBtn=By.partialLinkText("Register new business");
	By skipStripeAccountBtn=By.cssSelector(".btn-lg.fw-bold.w-100.btn.btn-outline-primary");
	By skipStripeAccountPopUpBtn=By.xpath("//div[@class='modal-content']//button[text()='Skip']");
	By deleteStoreBtn=By.xpath("//button[text()='Delete the store']");
	By deleteStoreIcon = By.cssSelector(".fa.fa-check");
	By storeLogo=By.xpath("(//img[contains(@alt,'')])[3]");
	By businessNameTbx=By.xpath("//input[@name='name']");
	By storeAddressField=By.cssSelector(".form-control.pac-target-input");
	By storeAddressOption=By.xpath("(//div[@class='pac-item'])[1]");
	By phoneTbx=By.xpath("//input[@name='phone']");
	By timeZoneField=By.xpath("//select[@name='timeZone']");
	By timeZoneOption=By.xpath("//option[text()='(GMT-05:00) Eastern Time (US & Canada)']");
	By taxRateTbx=By.xpath("//input[@name='taxRate']");
	By saveBtn=By.xpath("//button[text()='Save']");
	By stripeBtn=By.cssSelector(".img-fluid.h-100");
	By testStripeBtn=By.partialLinkText("Create a test Stripe account");
	By bankTransferToggleBtn=By.xpath("(//i[@class='far fa-toggle-on fa-rotate-180 custom-check-off '])[3]");
	By configureCreditCardTerminal=By.xpath("//button[@class='btn btn-link']");
	By creditCardTerminalOption=By.xpath("//span[text()=' Tap-To-Pay on phone']");
	By creditSaveBtn=By.xpath("//button[text()='Save']");
	By skipForNowBtn=By.xpath("//button[text()='Skip for now']");
	By continueBtn=By.xpath("//button[text()='Continue']");
	By configureLink=By.xpath("//div[contains(@class,'row')]//div[3]//div[1]//a[1]");
	By modifyBtn=By.xpath("//button[text()='Modify']");

	public void clickRegisterNewBusinessBtn() {
		click(registerNewBusinessBtn);
	}
	public void clickSkipStripeAccountBtn() {
		WebdriverWaits.waitForElementClickable(skipStripeAccountBtn, 5);
		click(skipStripeAccountBtn);
	}
	public void clickSkipStripeAccountPopUpBtn() {
		WebdriverWaits.waitForElementClickable(skipStripeAccountPopUpBtn, 5);
		clickElementByJS(skipStripeAccountPopUpBtn);
	}
	public void clickDeleteStoreBtn(){
		WebdriverWaits.waitForElementUntilVisible(deleteStoreBtn, 5);
		clickElementByJS(deleteStoreBtn);
	}
	public void clickDeleteStoreIcon(){
		WebdriverWaits.waitForElementUntilVisible(deleteStoreIcon, 5);
		clickElementByJS(deleteStoreIcon);
	}
	public void clickStoreLogo(){
		clickElementByJS(storeLogo);
	}
	public void uploadImageAsAttachment(String relativePath) throws AWTException {
		String projectPath = System.getProperty("user.dir");
		String absolutePath = Paths.get(projectPath, relativePath).toString();
		uploadImageFile(absolutePath);
	}
	public void enterBusinessName(String businessName) {
		WebdriverWaits.waitForElementUntilVisible(businessNameTbx, 2);
		clear_custom(businessNameTbx);
		pressKeys(businessNameTbx, businessName);
		click(businessNameTbx);
	}
	public void selectStoreAddress(String storeAddressName){
		WebdriverWaits.waitForElementUntilVisible(storeAddressField, 2);
		clear_custom(storeAddressField);
		pressKeys(storeAddressField, storeAddressName);
		click(storeAddressField);
		click(storeAddressOption);
	}
	public void enterPhone(String phone){
		WebdriverWaits.waitForElementUntilVisible(phoneTbx, 2);
		clear_custom(phoneTbx);
		pressKeys(phoneTbx, phone);
		click(phoneTbx);
	}
	public void selectTimeZone(){
		click(timeZoneField);
		click(timeZoneOption);
	}
	public void enterTax(String taxRate){
		WebdriverWaits.waitForElementUntilVisible(taxRateTbx, 2);
		clear_custom(taxRateTbx);
		pressKeys(taxRateTbx, taxRate);
		click(taxRateTbx);
	}
	public void clickSaveBtn(){
		WebdriverWaits.waitForElementUntilVisible(saveBtn, 5);
		moveToWebElement(saveBtn);
		clickElementByJS(saveBtn);
	}
	public void clickStripeBtn(){
		click(stripeBtn);
	}
	public void clickTestStripeBtn(){
		click(testStripeBtn);
	}
	public void enableBankTransfer(){
		click(bankTransferToggleBtn);
	}
	public void clickConfigureCreditCardTerminals(){
		click(configureCreditCardTerminal);
	}
	public void selectCreditCardTerminal(){
		click(creditCardTerminalOption);
	}
	public void clickCreditSaveBtn(){
		click(creditSaveBtn);
	}
	public void clickSkipForNowBtn(){
		click(skipForNowBtn);
	}
	public void clickContinueBtn(){
		moveToWebElement(continueBtn);
		click(continueBtn);
	}
	public void clickConfigureLink(){
		click(configureLink);
	}
	public void clickModifyBtn(){
		click(modifyBtn);
	}
}
