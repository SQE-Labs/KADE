package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

	// Locators
	By registerNewBusinessBtn = By.xpath("//a[@class='btn btn-primary']");


	// Methods
	/**
	 * Method to click on 'Register new Business' button
	 */
	public void clickOnRegisterNewBusinessBtn() {
		click(registerNewBusinessBtn);
	}



}
