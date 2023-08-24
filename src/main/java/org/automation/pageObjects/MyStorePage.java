package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

	By registerNewBuissnessBtn = By.xpath("//a[@class='btn btn-primary']");
	By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
	
	
	public void clickOnRegisterNewBuissnessBtn() {
		click(registerNewBuissnessBtn);
	}

	public String getPageHeader() {
		return getText_custom(pageHeader);
	}

}
