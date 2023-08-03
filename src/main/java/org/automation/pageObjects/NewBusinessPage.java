package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class NewBusinessPage extends BasePage {
	By businessLegalNameTbx = By.name("profile.business.name");
	By typeOfBusinessDropDown = By.cssSelector("span.select2-selection.select2-selection--single");
	By typeOfBusinessOptions = By.xpath("//ul[@class='select2-results__options']/li");
	By locationDescription = By.name("description");
	By storeAddressComboBox = By.name("fulladdress");
	By storeAddressOptions = By.xpath("//div[@class='pac-item']");
	By phoneTbx = By.name("phone");
	By timeZoneField = By.name("timeZone");
	By currencyOfTheStoreField = By.name("currencyType");
	By taxRate = By.name("taxRate");
	By saveBtn = By.xpath("//button[contains(text(),'Save')]");
	By validationMessage = By.xpath("//p[@class='alert-content']");
	By backBtn = By.xpath("//i[@class='fal fa-chevron-circle-left']");
	By nameOfStoreField = By.xpath("//input[@name='name']");
	By typeOfBusinessField = By.xpath("//span[@class='select2-selection select2-selection--single']");
	By LocationDescriptionField = By.xpath("//input[@name='description']");
	By TellUsMoreAboutHeading = By.xpath("//h4[contains(text(),'Tell us more about ')]");
	By DeleteTheStoreButton = By.xpath("//button[@class='btn btn-outline-danger ms-3 btn-lg fw-bold']");
	By ConfirmationButton = By.xpath("//button[@class='btn btn-outline-success']");
	By SoleProprietorshipOption = By.xpath("//li[@id='select2-profilebusinesstype-o3-result-1h72-soleProprietorship']");
	By IndividualOption = By.xpath("//li[@id='select2-profilebusinesstype-o3-result-yku8-individual']");
	By CorporationOption = By.xpath("//li[@id='select2-profilebusinesstype-o3-result-abcs-Corporation']");
	By LLCOption = By.xpath("//li[@id='select2-profilebusinesstype-o3-result-xfhm-LLC']");
	By PartnershipOption = By.xpath("//li[@id='select2-profilebusinesstype-o3-result-rz33-Partnership']");
	By PleaseReviewHighlightedField = By.xpath("//p[@class='alert-content']");

	
	public void enterBusinessLegalName(String string) {
		sendKeys(businessLegalNameTbx, string);
	}

	public void clearBusinessLegalNameField(){
		clear_custom(businessLegalNameTbx);
	}

	public void selectTypeOfBusiness(String string) {
		click(typeOfBusinessDropDown);
		clickOnElementByText(typeOfBusinessOptions, string);
		}

	public void enterLocationDescription(String string) {
		sendKeys(locationDescription, string);
	}

	public void enterStoreAddressClickFirst(String string) {
		sendKeys(storeAddressComboBox, string);
		clickOnFirstElement(storeAddressOptions);
	}

	public void enterStoreAddress(String string) {
		sendKeys(storeAddressComboBox, string);
	}


	public void enterPhone(String string) {
		sendKeys(phoneTbx, string);
	}

	public void selectCurrencyOfStore(String string) {
		selectDropDownByVisibleText_custom(currencyOfTheStoreField, string);
	}

	public void enterTaxRate(String string) {
		sendKeys_withClear(taxRate, string);
	}

	public void clickOnSave()  {
		ScrollDownThePageMax();
		click(saveBtn);
	}
	
	public void clickBackArrowBtn(){
	if(isElementPresent(backBtn,"Back Button")){
		click(backBtn);
		clearAllFields();

	}
	}

	public void clickOnNameOfStoreField(){
		click(nameOfStoreField);
	}

	public void clearNameOfStoreField() {
		clear_custom(nameOfStoreField);
	}

	public void clearAllFields(){
		clear_custom(businessLegalNameTbx);
		clear_custom((nameOfStoreField));
		clear_custom((locationDescription));
		clear_custom(storeAddressComboBox);
		clear_custom(phoneTbx);
	}

	public void enterNameOfStore(String string) {
		sendKeys(nameOfStoreField, string);
	}

	public void clickOnTypeOfBusinessField(){
		click(typeOfBusinessField);
	}

	public boolean checkPresenceOfDefaultIndividualOption() {
		return getText_custom(typeOfBusinessField).equalsIgnoreCase("Individual");
	}

	public boolean checkPresenceOfSoleProprietorship() {
		return isElementPresent(SoleProprietorshipOption, "Type of business");
	}

	public boolean checkPresenceOfCorporation(){
		return isElementPresent(CorporationOption,"Type of business");
	}

	public boolean checkPresenceOfLLC(){
		return isElementPresent(LLCOption,"Type of business");
	}

	public boolean checkPresenceOfPartnership(){
		return isElementPresent(PartnershipOption,"Type of business");
	}

	public String getDropdownOption(){
		 return getText_List(typeOfBusinessField);
	}

	public String getBusinessLegalName() {
		return getAttributevalue(businessLegalNameTbx,"value");
	}

	public String getNameOfStore() {
		return getAttributevalue(nameOfStoreField,"value");
	}

	public boolean checkPresenceOfTellUsMoreAboutHeading(){
		return isElementPresent(TellUsMoreAboutHeading,"Tell us more about Heading");
	}

	public String getLocationDescription() {
		return getAttributevalue(LocationDescriptionField,"value");
	}

	public void clickDeleteTheStoreButton(){
		click(DeleteTheStoreButton);
	}

	public void clickConfirmationButton(){
		click(ConfirmationButton);
	}
}
