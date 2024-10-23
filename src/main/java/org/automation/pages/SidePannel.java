package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import static org.automation.ReturnObjects.Clickable.getElementBy;

public class SidePannel extends BasePage {

	By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
	By validationMessage=By.xpath("//p[@class='alert-content']");
	public By billBtn = By.cssSelector(".sidebar-nav > li:nth-child(3)");
	By transactionsButton=By.cssSelector(".sidebar-nav > li:nth-child(2)");
	By myStoreBtn=By.cssSelector(".fa-fw.fas.fa-store");
	By giftCardsDashboardTab=By.xpath("//a[text()='Gift Cards Dashboard']");
	By pageHeader=By.xpath("//h1[@class='header-title mb-0']");
	By reportBtn=By.xpath("(//a[@class='sidebar-link'])[11]");
	By signOutBtn = By.xpath("//a[text()='Sign out']");
	By qrCodeDashboardBtn = By.xpath("//a[text()='QR Code Dashboard']");
	By manageBusinessAcc = By.xpath("//a[@class='sidebar-link collapsed' and text()='Manage Business']");

	public SidePannel() {

	}

	public void expandManageBusinessAccordion() {
	try{
		expandManageBusinessAccordionBttn().clickIfExist(true, 0);
		Thread.sleep(2000);
		}  catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
	}

	public Clickable expandManageBusinessAccordionBttn(){
		return  Clickable.getElementBy(manageBusinessAcc, "Expand Manage Business Accordion");
	}

	public Clickable getBillButton(){
		return  Clickable.getElementBy(billBtn, "Bill Button");
	}
	public Clickable getMyStoresTab(){
		return getElementBy(myStoreBtn);
	}

	public Clickable getGiftCardsDashboardTab(){
		return Clickable.getElementBy(giftCardsDashboardTab,"Gift Card Dashboard Tab");
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

	public Clickable getTransactionButton() {
		return Clickable.getElementBy(transactionsButton,"Transactions Button");
	}

    public Clickable getSignOutButton() {
		WebdriverWaits.sleep(3000);
		return Clickable.getElementBy(signOutBtn,"Sign Out Button");
    }

    public Clickable getQrCodeDashboardButton() {
		return Clickable.getElementBy(qrCodeDashboardBtn , "Qr code dashboard button");
    }
}


