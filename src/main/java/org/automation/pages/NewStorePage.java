package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class NewStorePage extends BasePage {
	By backBtn = By.xpath("//i[@class='fal fa-chevron-circle-left']");
	By typeOfBusinessDropDown = By.name("profile.business.classification");
	By websiteTextBox = By.name("profile.business.website");
	By saveBtn = By.className("btn-lg fw-bold btn btn-primary");

	public void selectByVisibleText(String text) {
		click(typeOfBusinessDropDown);
		selectDropDownByVisibleText_custom(typeOfBusinessDropDown, text);
	}
	
	public void enterWebsite(String website) {
		sendKeys(websiteTextBox, website);
	}
	
	public void clickOnSave() {
		click(saveBtn);
	} 
}
