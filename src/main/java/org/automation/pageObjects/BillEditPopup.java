package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class BillEditPopup extends BasePage{

	By subTotalField =By.xpath("//input[@name='subTotal']");
	By updateBtn =By.xpath("//button[@class='btn btn-primary ms-2 mr-0']");
	
	public void enterAmountOnSubTotalField(String value ) {
		sendKeys_withClear(subTotalField, value);
	}
	
	public void clickOnUpdate() {
		click(updateBtn);
	}
}
