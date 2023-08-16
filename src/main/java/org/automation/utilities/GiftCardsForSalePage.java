package org.automation.utilities;

import java.util.List;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardsForSalePage extends BasePage {
	By filterBtn=By.xpath("//i[@class='me-2 fa-fw fas fa-filter']");
	By statusDropdown = By.xpath("//select[@name='status']");
	By availableQty=By.xpath("//tbody/tr/td[5]");
	By copyUrl=By.xpath("(//button[@class='btn btn-link mx-2'])[1]");
	By addLink=By.xpath("//a[@class='btn btn-link']");
	By toastMessage=By.xpath("//div[@class='toast-message']");
	
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

	public void selectStatusByText(String string) {
		selectByText(statusDropdown, string);
	}

	public boolean areQuantityMoreThanZero() {
		return getListOfString(availableQty).stream().map(m->Integer.valueOf(m)).allMatch(a->a>0);

	}

	public boolean areQuantityMoreThanEqualToZero() {
		return getListOfString(availableQty).stream().map(m->Integer.valueOf(m)).allMatch(a->a>=0);
	}
	
	public void clickOnCopyUrl() {
		click(copyUrl);
	}

	public String getCopyUrlToolTipMessage() {
		return getToolTipMessage(copyUrl);
	}

	public void clickOnAddLink() {
		click(addLink);
	}

	public String getToastMessage() {
		return getText_custom(toastMessage);
	}

}
