package org.automation.pages;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class AddGiftCardPage extends BasePage {

	By saveChangesBtn = By.xpath("//div[@class='mt-1']/button");
	By giftCardAmt = By.xpath("//input[@name='amount']");
	By giftCardSalePrice = By.xpath("//input[@name='salePrice']");
	By RefNoTbx = By.xpath("//input[@name='referenceNo']");
	By fundingSource = By.cssSelector("[name='fundSource']");
	By availableQtyTbx = By.xpath("//input[@name='qty']");
	By saleDateRange = By.xpath("//input[@name='saleDateRange']");
	By startDate = By.xpath("//input[@name='startInDays']");
	By expInDate = By.xpath("//input[@name='expireInDays']");
	By memoTbx = By.xpath("//textarea[@name='memo']");
	By closeValidation = By.xpath("(//button[@class='btn-close'])[2]");
	By currentDate = By.xpath("(//tr[2]/td[3])[1]");
	By nextMonthDay = By.xpath("(//tr[2]/td[3])[2]");
	By alertMessage = By.xpath("//div[@class='alert-message']");

	public void clickOnSaveChange() {
		scrollToElement(saveChangesBtn);
		WebdriverWaits.sleep(500);
		WebdriverWaits.waitForElementClickable(saveChangesBtn, 5);
		click(saveChangesBtn);
	}

	public String getGiftCardAmtToolTipMessage() {
		click(closeValidation);
		scrollToElement(giftCardAmt);
		WebdriverWaits.sleep(500);
		return getToolTipMessage(giftCardAmt);
	}

	public String getGiftCardSalePriceTipMessage() {
		scrollToElement(giftCardSalePrice);
		WebdriverWaits.sleep(500);
		return getToolTipMessage(giftCardSalePrice);
	}

	public String getAvailableQtyForSaleTipMessage() {
		scrollToElement(availableQtyTbx);
		WebdriverWaits.sleep(500);
		return getToolTipMessage(availableQtyTbx);
	}

	public void enterGiftCardAmt(String string) {
		sendKeys(giftCardAmt, string);
	}

	public void enterGiftCardSaleprice(String string) {
		sendKeys(giftCardSalePrice, string);
	}

	public void enterAvailableQty(String string) {
		sendKeys(availableQtyTbx, string);
	}

	public String getTextAvailableQty() {
		return getAttribute(availableQtyTbx, "value");
	}

	public void clickOnDateRange() {
		click(saleDateRange);
	}

	public void selectCurrentDate() {
		scrollToElement(saveChangesBtn);
		click(currentDate);
	}

	public void selectNextMonthDate() {
		scrollToElement(saveChangesBtn);
		click(nextMonthDay);
	}

	public String getSaleDateRange() {
		return getText_custom(saleDateRange);
	}

	public void isAleartMessagePresent() {
		isElementPresent(alertMessage, "Aleart Message");
	}

	public String getAlertMessage() {
		return getText_custom(alertMessage);
	}
}
