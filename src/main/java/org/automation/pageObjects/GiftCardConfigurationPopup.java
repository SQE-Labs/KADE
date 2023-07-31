package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GiftCardConfigurationPopup extends BasePage{
By issueGiftCardToggle=By.xpath("//div[@class='link-check']/label");
By referenceNoToggle=By.xpath("//label[@class='custom-checkbox']");
By fundingSourceToggle=By.xpath("//label[@class='custom-checkbox mx-1']");
By saveConfigurationBtn = By.xpath("//button[@class='btn btn-outline-primary ms-auto mt-3']");
By popupTitle=By.xpath("//h4[@class='modal-title']");
By maxGiftCardAmtTbx=By.xpath("//input[@name='maximumGCAmount']");
By closeBtn= By.xpath("//button[@class='btn-close']");
By fundingSourceTbx=By.xpath("//textarea[@name='fundSourceList']");

	public void switchOnIssueGiftCardToggle(){
		if(getAttribute(issueGiftCardToggle, "class").equalsIgnoreCase("custom-checkbox mb-3")) {
		click(issueGiftCardToggle);}
	}
	
	public void switchOffIssueGiftCardToggle(){
		if(getAttribute(issueGiftCardToggle, "class").equalsIgnoreCase("custom-checkbox mb-3 checked")) {
		click(issueGiftCardToggle);}
	}
	
	public void clickOnSaveConfigurationBtn() {
		click(saveConfigurationBtn);
	}

	public String getPopupTitle() {
		return getText_custom(popupTitle);
	}

	public void clickOnClose() {
		click(closeBtn);
	}
	
	public void isAllElementPresent() {
	Assert.assertTrue(isElementPresent(issueGiftCardToggle, "Accepting and issuing Gift Cards toggle button"));
	Assert.assertTrue(isElementPresent(referenceNoToggle, "Reference No. toggle button"));
	Assert.assertTrue(isElementPresent(fundingSourceToggle, "funding source toggle button"));
	}

	public void switchOnRefNoToggle() {
		if(getText_custom(referenceNoToggle).equalsIgnoreCase("Optional Reference No."))
			click(referenceNoToggle);
	}
	
	public void switchOffRefNoToggle() {
		if(getText_custom(referenceNoToggle).equalsIgnoreCase("Mandatory Reference No."))
			click(referenceNoToggle);
	}

	public String getRefNoLabel() {
		return getText_custom(referenceNoToggle);
	}

	public void switchOnFundingSourceToggle() {
		if(getText_custom(fundingSourceToggle).equalsIgnoreCase("Optional funding source"))
			click(fundingSourceToggle);
	}

	public void switchOffFundingSourceToggle() {
		if(getText_custom(fundingSourceToggle).equalsIgnoreCase("Restricted funding source"))
			click(fundingSourceToggle);
	}

	public String getFundingSourceLabel() {
		return getText_custom(fundingSourceToggle);
	}

	public boolean isFundingSourcePresent() {
		return isElementPresent(fundingSourceTbx, "Funding Source TextBox");
	}

	public void clearMaxGiftCardTbx() {
		clear_custom(maxGiftCardAmtTbx);		
	}

	public String getMaxGiftCardToolTipMessage() {
		moveToWebElement(maxGiftCardAmtTbx);
		String id=getAttribute(maxGiftCardAmtTbx, "aria-describedby");
		return getText_custom(By.id(id));
	}

	public void enterMaxGiftCardAmount(int i) {
		clearMaxGiftCardTbx();
		sendKeysUsingJavaScript(maxGiftCardAmtTbx, "document.getElementsByName('maximumGCAmount')[0].value="+i);
	}
}
