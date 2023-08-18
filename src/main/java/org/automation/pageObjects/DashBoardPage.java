package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashBoardPage extends BasePage {

	By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
	By validationMessage=By.xpath("//p[@class='alert-content']");
	By billBtn = By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-file-alt']");
	By myStoreBtn=By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-store']");
	By giftCardsDashboardTab=By.xpath("(//a[@class='sidebar-link'])[9]");
	By pageHeader=By.xpath("//h1[@class='header-title mb-0']");
	
	
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

	public void clickOnGiftCardsDashboard() {
		WebdriverWaits.fluentWait_ElementIntactable(5, 10, giftCardsDashboardTab);
		click(giftCardsDashboardTab);
	}
	
	public String getPageHeader() {
		return getText_custom(pageHeader);
	}
}


