package org.automation.pageObjects;


import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class UserPage extends BasePage {
	By messageIcon=By.xpath("//i[@class='fal fa-paper-plane fa-2x']");
	By header=By.xpath("//h1[@class='header-title mb-0']");
	By rewardPoint =By.xpath("//div[@class='d-flex justify-content-center gap-3 fs-1']");

public void clickOnMessage() {
	click(messageIcon);
}

public String getHeader() {
	return getText_custom(header);
}

public void clickOnRewardPoint() {
	click(rewardPoint);
}
}
