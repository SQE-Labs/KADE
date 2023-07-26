package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

	By registerNewBuissnessBtn = By.xpath("//a[@class='btn btn-primary']");
	
	public void clickOnRegisterNewBuissnessBtn() {
		click(registerNewBuissnessBtn);
	}
}
