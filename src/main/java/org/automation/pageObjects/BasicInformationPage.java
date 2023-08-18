package org.automation.pageObjects;

import java.awt.AWTException;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class BasicInformationPage extends BasePage {

    // Locators
    By nameField = By.xpath("//input[@name='contactName']");
    By saveChangesButton = By.xpath("//button[@class='btn btn-primary']");
    By successMessage=By.xpath("//div[@class='toast-message']");
    By addressField = By.xpath("//input[@name='fullAddress']");
    By addressList = By.xpath("//div[@class='pac-item']");
    By editIcon = By.cssSelector("i.fal.fa-edit");
    By aleartMessage = By.xpath("//div[@class='alert-message']/p");
    By alertHeader = By.cssSelector("h4.alert-heading");
    By securityAndPasswordBtn = By.xpath("//a[text()='Security and Password']");
    
    public boolean checkPresenceOfNameField(){
      return isElementPresent(nameField,"Name");
    }

    public void clearDataFromNameField(){
        clear_custom(nameField);
    }

    public void moveToNameField() {
      moveToWebElement(nameField);
    }

    public void clickOnSaveChangesButton(){
        clickBtn(saveChangesButton);
    }

    
    public String getNameToolTipMessage() {
    	String toolTipId=getAttribute(nameField, "aria-describedby");
        By toolTipMessage =By.id(toolTipId);
    		return getElementText(toolTipMessage);
    }
    
    public String getAddressToolTipMessage() {
   		return getToolTipMessage(addressField);
    }
    
    
    public void enterUserName(String name) {
    	sendKeys_withClear(nameField, name);
    }
    
    public String getSuccessMessage() {
    	return getText_custom(successMessage);
    }
    
    public void enterAddress(String address) {
    	sendKeys_withClear(addressField, address);
    }

	public void moveToAddressField() {
		moveToWebElement(addressField);
		
	}
	
	public void selectFirstAddress(String address) {
		sendKeys_withClear(addressField, address);
		selectFirst(addressList);
	}
	
	public void uploadImage(String location) throws AWTException {
		click(editIcon);
		uploadImageFile(location);
	}
	
	public void uploadOtherFile(String location) throws AWTException {
		click(editIcon);
		uploadImageFile(location);
	}
	
	public String getAleartMessage() {
		WebdriverWaits.waitForElementUntilVisible(alertHeader, 5);
		return getText_custom(aleartMessage);
	}
	
	public void clickOnSecurityAndPassword() {
		click(securityAndPasswordBtn);
	}
}
