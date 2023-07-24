package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class DashBoardPage extends BasePage {

	By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
	By validationMessage=By.xpath("//p[@class='alert-content']");
	By billBtn = By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-file-alt']");
	By myStoreBtn=By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-store']");
	
	public void clickProfile() {
		clickBtn(profileLink);
	}

	public String getValidationMessage() {
		return getText_custom(validationMessage);
	}
	
	public void clickOnBill() {
		click(billBtn);
	}

	public void clickOnMyStore() {
		click(myStoreBtn);
		
	}
}


