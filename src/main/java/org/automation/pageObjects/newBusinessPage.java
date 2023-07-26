package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class newBusinessPage extends BasePage {
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
	By saveBtn = By.xpath("//button[text()='Save']");
	//By saveBtn = By.cssSelector("button[type='submit'].btn-primary");
	
	public void enterBusinessLegalName(String string) {
		sendKeys(businessLegalNameTbx, string);
	}

	public void selectTypeOfBusiness(String string) {
		click(typeOfBusinessDropDown);
		clickOnElementByText(typeOfBusinessOptions, string);
		}

	public void enterLocationDescription(String string) {
		sendKeys(locationDescription, string);
	}

	public void enterStoreAddress(String string) {
		sendKeys(storeAddressComboBox, string);
		clickOnFirstElement(storeAddressOptions);
		
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

	public void clickOnSave() throws InterruptedException {
		ScrollDownThePageMax();
		WebdriverWaits.fluentWait_ElementIntactable(10, 500, saveBtn);
		click(saveBtn);
	}
	
	
	
}
