package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class AddGiftCardPage extends BasePage{

	By saveChangesBtn=By.xpath("//button[@class='btn btn-primary']");
	
	public void clickOnSaveChange() {
		click(saveChangesBtn);
	}
}
