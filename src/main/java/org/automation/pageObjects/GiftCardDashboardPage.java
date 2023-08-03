package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class GiftCardDashboardPage extends BasePage{

	By configurationLink = By.xpath("//button[text()='Configuration']");
	By infoMessage = By.xpath(" //div[@class='card-header pb-0']");
	By issueGiftCardBtn=By.xpath("(//button[@class='btn btn-link'])[2]"); 
	By giftCardForSaleLink = By.xpath("//a[@class='btn btn-link']");
	By giftCardNo=By.xpath("//a[@class='btn btn-link btn btn-link']");
	
	public void clickOnConfigurationLink() {
		click(configurationLink);
	}
	
	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}
	
	public void clickOnIssueAGiftCard() {
		WebdriverWaits.waitForElementClickable(issueGiftCardBtn, 5);
		click(issueGiftCardBtn);
	}

	public boolean isIssueAGiftCardLinkPresent() {
		WebdriverWaits.waitForElementUntilVisible(issueGiftCardBtn, 5);
		return isElementPresent(issueGiftCardBtn,"Issue Gift Card Link");
	}
	
	public boolean isGiftCardForSaleLinkPresent() {
		WebdriverWaits.waitForElementUntilVisible(issueGiftCardBtn, 5);
		return isElementPresent(giftCardForSaleLink,"Gift Card For Sale Link");
	}

	public void clickOnGiftCard() {
		click(giftCardNo);
	}

	public String getGiftCard() {
		return getText_custom(giftCardNo);
	}
}
