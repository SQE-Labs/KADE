package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardDashboardPage extends BasePage{

	By configurationLink = By.xpath("//button[text()='Configuration']");
	By infoMessage = By.xpath(" //div[@class='card-header pb-0']");
	
	public void clickOnConfigurationLink() {
		click(configurationLink);
	}
	
	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}
}
