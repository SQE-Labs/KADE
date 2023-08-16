package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class AddGiftCardPage extends BasePage{

	By saveChangesBtn=By.xpath("//div[@class='mt-1']/button");
	By giftCardAmt=By.xpath("//input[@name='amount']");
	By giftCardSalePrice=By.xpath("//input[@name='salePrice']");
	By RefNoTbx=By.xpath("//input[@name='referenceNo']");
	By fundingSource=By.cssSelector("[name='fundSource']");
	By availableQtyTbx=By.xpath("//input[@name='qty']");
	By saleDateRange=By.xpath("//input[@name='saleDateRange']");
	By startDate=By.xpath("//input[@name='startInDays']");
	By expInDate=By.xpath("//input[@name='expireInDays']");
	By memoTbx=By.xpath("//textarea[@name='memo']");
	By closeValidation=By.xpath("(//button[@class='btn-close'])[2]");
	By currentDate=By.xpath("//td[@class='today active start-date available']");
	By nextMonthDay=By.xpath("(//div[@class='drp-calendar right'] //td[@class='available'])[15]");
	By aleartMessage=By.xpath("//div[@class='alert-message']");
	
	
	public void clickOnSaveChange() {
		scrollToElement(saveChangesBtn);
		WebdriverWaits.sleep(500);
		WebdriverWaits.waitForElementClickable(saveChangesBtn, 5 );
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
		ScrollDownThePageMax();
			click(currentDate);
	}
	
	public void selectNextMonthDate() {
		click(nextMonthDay);
	}

	public String getSaleDateRange() {
		return getText_custom(saleDateRange);
	}

	public void isAleartMessagePresent() {
			isElementPresent(aleartMessage, "Aleart Message");
	}
	
	public String getAleartMessage() {
		return getText_custom(aleartMessage);
	}
	}
