package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardDashboardPage extends BasePage{

	By configurationLink = By.xpath("//button[text()='Configuration']");
	By infoMessage = By.xpath(" //div[@class='card-header pb-0']");
	By issueGiftCardBtn=By.xpath("(//button[@class='btn btn-link'])[2]");
	By giftCardForSaleLink = By.xpath("//a[@class='btn btn-link']");
	
	public void clickOnConfigurationLink() {
		click(configurationLink);
	}
	
	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}
	
	public void clickOnIssueAGiftCard() {
		click(issueGiftCardBtn);
	}

	public boolean isIssueAGiftCardLinkPresent() {
		return isElementPresent(issueGiftCardBtn,"Issue Gift Card Link");
	}
	
	public boolean isGiftCardForSaleLinkPresent() {
		return isElementPresent(giftCardForSaleLink,"Gift Card For Sale Link");
	}
}
