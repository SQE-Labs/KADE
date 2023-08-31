package org.automation.pageObjects;

import java.util.List;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

	By registerNewBuissnessBtn = By.xpath("(//a[@class='sidebar-link'])[5]");
	By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
	By buisnessLegalNameTbx = By.cssSelector("[name='profile.business.name']");
	By nameOfTheStoreTbx = By.cssSelector("[name='name']");
	By typeOfBuisnessDropDown = By.cssSelector("[name='profile.business.type']");
	By locationDescriptionTbx = By.xpath("//input[@name='description']");
	By storeAddressTbx = By.cssSelector("[name='fulladdress']");
	By phoneTbx = By.cssSelector("[name='phone']");
	By timeZone=By.xpath("//select[@name='timeZone']");
	By currencyOfTheStoreDropDown = By.xpath("//select[@name='currencyType']");
	By taxRateTbx = By.xpath("//input[@name='taxRate']");
	By saveBtn = By.xpath("//div[@class='mb-3 pt-2 d-flex']/button");
	By validationMessage = By.xpath("//p[@class='alert-content']");
	By closeValidationBtn = By.xpath("//button[@class='btn-close']");
	By firstSearchResult=By.cssSelector("li.select2-results__option.select2-results__option--highlighted");
	By typeOfBusinessTbx=By.xpath("//span[@class='select2-search select2-search--dropdown']/input");
	By typeOfBusinessDropdown=By.xpath("//b[@role='presentation']");
	By typeOfBusinessInfoMessage=By.cssSelector("[aria-live='assertive']");
	By storeAddressSuggestionList=By.xpath("//div[@class='pac-item']");
	By suggestion=By.xpath("//span[@class='pac-item-query']");
	By label=By.cssSelector("p.display-5.text-truncate.w-100");
	By typeOfBuisnessRunningOptn=By.cssSelector("[name='profile.business.classification']");
	
	public void clickOnRegisterNewBuissnessBtn() {
		click(registerNewBuissnessBtn);
	}

	public String getPageHeader() {
		return getText_custom(pageHeader);
	}

	public void clickOnSaveBtn() {
		ScrollDownThePageMax();
		WebdriverWaits.sleep(1000);
		// WebdriverWaits.waitForElementUntilVisible(saveBtn, 5);
		click(saveBtn);
	}

//	public String getBuisnessLegalNameToolTipMessage() {
//		WebdriverWaits.waitForElementUntilVisible(buisnessLegalNameTbx, 5);
//		WebdriverWaits.sleep(1500);
//		scrollToElement(buisnessLegalNameTbx);
//		return getToolTipMessage(buisnessLegalNameTbx);
//	}
//
//	public String getNameOfStoreToolTipMessage() {
//		WebdriverWaits.waitForElementUntilVisible(nameOfTheStoreTbx, 5);
//		return getToolTipMessage(nameOfTheStoreTbx);
//	}
//
//	public String getStoreAddressToolTipMessage() {
//		WebdriverWaits.waitForElementUntilVisible(storeAddressTbx, 5);
//		return getToolTipMessage(storeAddressTbx);
//	}
//
//	public String getPhoneToolTipMessage() {
//		WebdriverWaits.waitForElementUntilVisible(phoneTbx, 5);
//		return getToolTipMessage(phoneTbx);
//	}
//
//	public String getValidationMessage() {
//		return getText_custom(validationMessage);
//	}
//
//	public void clickOnCloseValidationMessage() {
//		click(closeValidationBtn);
//	}

	public boolean isValidationMessageDisplayed() {
		return isElementPresent(validationMessage, "Validation message");
	}

	public void enterBisnessLegalName(String string) {
		sendKeys_withClear(buisnessLegalNameTbx, string);
	}

	public String getBuisnessLegalNameText() {
		return getAttributevalue(buisnessLegalNameTbx, "value");
	}

	public String getNameOfStoreAutoPopulation() {
		return getAttributevalue(nameOfTheStoreTbx, "value");
	}

	public void closeValidationMessage() {
		click(validationMessage);
	}

	public void clickOnNameOfStore() {
		click(nameOfTheStoreTbx);
	}

	public void enterNameOfStore(String string) {
		sendkeysClear(nameOfTheStoreTbx, string);
	}

	public String getTypeOfBuisnessSelectedOption() {
		return getSelectedOptionOfDropdown(typeOfBuisnessDropDown);
	}

	public List<String> getAllOptionsOfTypesOfBuisness() {
		return getAllOptionsOfDropDown(typeOfBuisnessDropDown);
	}

	public void selectTypeOfBuisnessOption(String string) {
		selectDropDownByVisibleText_custom(typeOfBuisnessDropDown, string);
	}

	public void clickOnTypeOfBuisness() {
		click(typeOfBusinessDropdown);
	}

	public void enterTypeOfBuisness(String string) {
		WebdriverWaits.sleep(5000);
		sendKeys(typeOfBusinessTbx, string);
	}

	public void selectFirstSearchResult() {
		click(firstSearchResult);
	}

	public String getTypeOfBusinessInfoMessage() {
		return getText_custom(typeOfBusinessInfoMessage);
	}

	public void enterLocationDescription(String string) {
		sendKeys(locationDescriptionTbx, string);
	}

	public String getLocationDescriptionText() {
		return getAttributevalue(locationDescriptionTbx, "value");
	}

	public void enterStoreAddress(String string) {
		sendKeys_withClear(storeAddressTbx, string);
	}

	public  List<String> getStoreAddressSuggestionList() {
		return getListOfString(storeAddressSuggestionList);
	}

	public String getStoreAddressToolTipMessage() {
		return getToolTipMessage(storeAddressTbx);
	}

	public String getPhoneText() {
		return getAttributevalue(phoneTbx,"value");
	}

	public void enterPhone(String string) {
		sendKeys_withClear(phoneTbx, string);
	}

	public String getPhoneToolTipMessage() {
		return getToolTipMessage(phoneTbx);
	}

	public String getValidationMessage() {
		return getText_custom(validationMessage);
	}

	public String SelectedLocalSystemTimeZone() {
		return getSelectedOptionOfDropdown(timeZone);
	}

	public void selectLocalSystemTimeZoneByIndex(int i) {
		selectDropDownByIndex_custom(timeZone, i);
	}
	
	public String getSelectedCurrency() {
		return getSelectedOptionOfDropdown(currencyOfTheStoreDropDown);
	}

	public void selectCurrencyByText(String currency) {
		selectDropDownByVisibleText_custom(currencyOfTheStoreDropDown, currency);
	}

	public String getTaxRateText() {
		return getAttributevalue(taxRateTbx,"value");
	}

	public void enterTaxRate(String string) {
		sendkeysClear(taxRateTbx, string);
	}

	public void clickOnFirstSuggestion() {
		click(suggestion);
	}

	public String getLabel() {
		return getText_custom(label);
	}

	public String getTypeOfBuisnessRunningSelectedOptn() {
		return getSelectedOptionOfDropdown(typeOfBuisnessRunningOptn);
	}

	
}
