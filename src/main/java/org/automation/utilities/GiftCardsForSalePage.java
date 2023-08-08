package org.automation.utilities;

import java.util.List;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardsForSalePage extends BasePage {
	By filterBtn=By.xpath("//i[@class='me-2 fa-fw fas fa-filter']");
	By statusDropdown = By.xpath("//select[@name='status']");
	
	public void clickOnFilterLink() {
		WebdriverWaits.waitForElementVisible(filterBtn, 5);
		click(filterBtn);
	}
	
	public boolean isStatusDropdownDisplayed() {
		return isElementPresent(statusDropdown, "Status Dropdown");
	}

	public void clickOnStatus() {
		click(statusDropdown);
	}

	public boolean areStatusOptionMatching(List<String> options) {
		return getAllOptionsOfDropDown(statusDropdown).equals(options);
		
	}

	public boolean defaultSelectedOption(String option) {
		return getSelectedOptionOfDropdown(statusDropdown).equalsIgnoreCase(option);
	}
	
}
