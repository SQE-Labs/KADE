package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class DashBoardPage extends BasePage {

	By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
	By validationMessage=By.xpath("//p[@class='alert-content']");
	public By billBtn = By.cssSelector(".sidebar-nav > li:nth-child(10)");
	By myStoreBtn=By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-store']");
	By giftCardsDashboardTab=By.xpath("(//a[@class='sidebar-link'])[9]");
	By pageHeader=By.xpath("//h1[@class='header-title mb-0']");
	By reportBtn=By.xpath("(//a[@class='sidebar-link'])[11]");
	By whichStorePopup = By.xpath("//p[text()='Which store?']");
	By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
	By storesCombobox=By.xpath("//span[@role='combobox']");
	By continueBtn=By.xpath("//button[@type='submit']");
	By signOutBtn = By.xpath("//a[text()='Sign out']");


	public void clickProfile() {
		clickBtn(profileLink);
	}

	public String getValidationMessage() {
		return getText_custom(validationMessage);
	}
	
	public void clickOnBill() {
		moveToWebElement(billBtn);
		click(billBtn);
//		WebdriverWaits.waitForElementVisible(whichStorePopup,5);
//		if(isWebElementVisible(whichStorePopup)){
//			WebdriverWaits.waitForElementVisible(whichStorePopup,5);
//			moveToWebElement(newBusinessCard);
//			click(newBusinessCard);
//		}
	}

	public void clickOnMyStores() {
		click(myStoreBtn);
		
	}

	public void clickOnGiftCardsDashboard() {
		WebdriverWaits.fluentWait_ElementIntactable(5, 10, giftCardsDashboardTab);
		click(giftCardsDashboardTab);
	}
	
	public String getPageHeader() {
		return getText_custom(pageHeader);
	}

	public void clickOnReports() {
		click(reportBtn);
	}

	public void signOut() {
		click(signOutBtn);
	}
}


