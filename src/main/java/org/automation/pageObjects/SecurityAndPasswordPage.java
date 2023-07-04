package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SecurityAndPasswordPage extends BasePage{

	By editEmailIcon = By.xpath("(//button[@class='btn btn-outline-secondary'])[1]");
	By popupHeader = By.xpath("//h4[@class='modal-title']");
	By popupCloseBtn = By.xpath("//button[@class='btn-close']");
	
	public void clickOnEditEmailIcon() {
		click(editEmailIcon);
	}
	
	public String getHeaderText() {
		return getText_custom(popupHeader);
		}
	
	public void closePopup() {
		click(popupCloseBtn);
	}
}
