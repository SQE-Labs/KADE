package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class BillViewPopup extends BasePage
{
	By closeBtn=By.xpath("(//button[@class='btn-close'])[2]");
	By deleteBtn = By.xpath("//button[@class='btn btn-outline-danger ']");
	By tickIcon = By.xpath("//i[@class='fa fa-check']");
	By qrCodeIcon= By.xpath("//i[@class='far fa-qrcode fa-fw']");
	By qrCode = By.xpath("//div[@class='d-flex justify-content-center bg-light p-1']");
	By closeQrPopup = By.xpath("//a[@class='stretched-link btn btn-danger m-2']");
	By invite=By.xpath("//i[@class='fal fa-megaphone fa-fw ']");
	By inviteCode=By.cssSelector("[class='d-none loaded-d-block fs-1']");
	By lable=By.xpath("//div[text()='Paid']");
	By amountAndDayLink = By.xpath("//div[@class='text-end']/div/span");
	By editBtn=By.cssSelector("button.btn.btn-link.btn.btn-link.px-1");
	
	public String getLableText(){
		WebdriverWaits.waitForElementUntilVisible(lable, 5);
		return getText_custom(lable);
	}
	
	public boolean isLinkPresent() {
		WebdriverWaits.waitForElementUntilVisible(amountAndDayLink, 5);
		return isElementPresent(amountAndDayLink, "Amount and Day Link");
	}
	
	public void clickOnAmountLink() {
		click(amountAndDayLink);
	}
	
	public void clickOnCloseBtn() {
		WebdriverWaits.waitForElementUntilVisible(closeBtn, 10);
		WebdriverWaits.waitForElementClickable(closeBtn, 10);
		click(closeBtn);
	}

	public void clickOnDeleteBtn() {
		click(deleteBtn);
	}
	
	public void clickOnConfirmIcon() {
		click(tickIcon);
	}
	
	public void clickOnQrCode() {
		click(qrCodeIcon);
	}

	public boolean isQrPresent() {
		return isElementPresent(qrCode, "QR Code on popup");
	}
	
	public void closeQrCodePopup() {
		click(closeQrPopup);
	}

	public void clickOnInvite() {
		click(invite);
	}
	
	public boolean isInviteCodePresent() {
		WebdriverWaits.waitForElementUntilVisible(inviteCode, 5);
		return isElementPresent(inviteCode,"Invite Code");
	}
	
	public boolean isFourDigitInviteCodePresent() {
		return getText_custom(inviteCode).length()==4;
	}
	
	public void clickOnEditBtn() {
		click(editBtn);
	}
}
