package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.data.KadeUserAccount;
import org.automation.utilities.WebdriverWaits;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

import static org.automation.ReturnObjects.Clickable.getElementByxPath;

public class DashBoardPage extends BasePage {

	By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
	By validationMessage=By.xpath("//p[@class='alert-content']");
	public By billBtn = By.cssSelector(".sidebar-nav > li:nth-child(11)");
	By myStoreBtn=By.xpath("//i[@class='align-middle me-2 fa-fw fas fa-store']");
	By giftCardsDashboardTab=By.xpath("(//a[@class='sidebar-link'])[9]");
	By pageHeader=By.xpath("//h1[@class='header-title mb-0']");
	By reportBtn=By.xpath("(//a[@class='sidebar-link'])[11]");
	By whichStorePopup = By.xpath("//p[text()='Which store?']");
	By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
	By storesCombobox=By.xpath("//span[@role='combobox']");
	By continueBtn=By.xpath("//button[@type='submit']");
	By signOutBtn = By.xpath("//a[text()='Sign out']");

	public Clickable getBillButton(){
		return getElementByxPath(billBtn);
	}

	protected Clickable getBillButton2(){
		return new Clickable(billBtn);
	}

	public void clickProfile() {
		clickBtn(profileLink);
	}

	public String getValidationMessage() {
		return getText_custom(validationMessage);
	}
	
	public void clickOnBill() {
		moveToWebElement(billBtn);
		click(billBtn);
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


