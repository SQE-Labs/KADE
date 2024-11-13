package org.automation.pages;

import org.automation.base.BasePage;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.automation.ReturnObjects.Clickable;
import org.openqa.selenium.WebElement;

public class GiftCardConfigurationPopup extends BasePage {
	By  configurationBtn = By.cssSelector("button[data-action='/Giftcards/_configurationGC/3334']");
By issueGiftCardToggle=By.cssSelector("i.far.fa-toggle-on.fa-rotate-180.custom-check-off");
By disabledText= By.cssSelector("span.custom-check-off");
By enabledText = By.cssSelector("span.fs-6.custom-check-on");
By referenceNoDisabledText= By.xpath("//span[text()='Reference No. is optional']");
By referenceNoEnabledText= By.xpath("//span[text()='Reference No. is mandatory']");
By fundingSourceDisabledText= By.xpath("//span[text()='Funding source is optional']");
By fundingSourceEnabledText = By.xpath("//span[text()='Funding source is restricted']");
By fundingSourceOnToggle = By.xpath("(//i[contains(@class, 'far') and contains(@class, 'fa-toggle-on') and contains(@class, 'custom-check-on')])[3]");
By fundingSourceOffToggle = By.xpath("(//i[contains(@class, 'far') and contains(@class, 'fa-toggle-on') and contains(@class, 'fa-rotate-180') and contains(@class, 'custom-check-off')])[3]");
By amtText= By.xpath("//label[text()='Maximum allowed gift card amount:']");
By referenceNoToggle=By.cssSelector("input[name=\"ReferenceNo\"] ~ i:nth-child(2)");
By referenceToggleOff = By.xpath("(//i[contains(@class, 'far') and contains(@class, 'fa-toggle-on') and contains(@class, 'fa-rotate-180') and contains(@class, 'custom-check-off')])[2]");
By referenceToggeleOn = By.xpath("(//i[contains(@class, 'far') and contains(@class, 'fa-toggle-on') and contains(@class, 'custom-check-on')])[2]");
By fundingSourceToggle=By.xpath("//label[@class='custom-checkbox mx-2 mx-1']");
By saveConfigurationBtn = By.xpath("//button[@class='btn btn-outline-primary ms-auto mt-3']");
By popupTitle=By.cssSelector("h5.modal-title");
By maxGiftCardAmtTbx=By.xpath("//input[@name='maximumGCAmount']");
By closeBtn= By.xpath("//button[@class='btn-close']");
By fundingSourceTbx=By.xpath("//textarea[@name='fundSourceList']");
	By saveBtn= By.cssSelector("button.btn.btn-outline-primary.ms-auto.mt-3");

	public WebElement getReferenceEnabledElement(){
		 return getElement(referenceNoEnabledText);
	 }
	 public WebElement getFundingResourceElement(){
		 return getElement(referenceNoEnabledText);
	 }

	public Clickable clickConfigurationBtn(){
		return Clickable.getElementBy(configurationBtn,"Configuration");
	}
	public Clickable switchOnIssueGiftCardToggle(){return Clickable.getElementBy(issueGiftCardToggle,"Disabled");}
	public Clickable getDisableText(){return Clickable.getElementBy(disabledText);}
	public Clickable clickOnSaveConfigurationBtn() {WebdriverWaits.waitForElementUntilVisible(saveBtn,100);return Clickable.getElementBy(saveBtn);}
	public Clickable getPopupTitle() {return Clickable.getElementBy(popupTitle);}
	public Clickable switchOffRefeNoToggle() {WebdriverWaits.waitForElementUntilVisible(referenceToggleOff,1000);return  Clickable.getElementBy(referenceToggleOff);}
	public Clickable getEnabledText() {WebdriverWaits.waitForElementUntilVisible(enabledText,100);return  Clickable.getElementBy(enabledText);}
	public Clickable getFundingSourceEnabledText() {WebdriverWaits.waitForElementUntilVisible(fundingSourceEnabledText,100);return  Clickable.getElementBy(fundingSourceEnabledText);}
	public Clickable getFundingSourceDiabledText(){WebdriverWaits.waitForElementUntilVisible(fundingSourceDisabledText,100);return  Clickable.getElementBy(fundingSourceDisabledText);}
	public Clickable getReferenceDisabledNoText() {WebdriverWaits.waitForElementUntilVisible(referenceNoDisabledText,100);return  Clickable.getElementBy(referenceNoDisabledText);}
	public Clickable getEnabledReferenceNotext(){WebdriverWaits.waitForElementUntilVisible(referenceNoEnabledText,100);return  Clickable.getElementBy(referenceNoEnabledText);}
	public Clickable getAmtText() {WebdriverWaits.waitForElementUntilVisible(amtText,100);return  Clickable.getElementBy(amtText);}
	public Clickable switchOnRefeNoToggele(){WebdriverWaits.waitForElementUntilVisible(referenceToggeleOn,100);return  Clickable.getElementBy(referenceToggeleOn);}
	public Clickable switchOnFundingSourceToggele(){WebdriverWaits.waitForElementUntilVisible(fundingSourceOnToggle,100);return  Clickable.getElementBy(fundingSourceOnToggle);}
	public Clickable switchoffFundingSourceToggele(){WebdriverWaits.waitForElementUntilVisible(fundingSourceOffToggle,100);return  Clickable.getElementBy(fundingSourceOffToggle);}





	public void switchOffIssueGiftCardToggle(){
		if(getAttribute(issueGiftCardToggle, "class").equalsIgnoreCase("custom-checkbox mx-2 mb-3 checked")) {
		click(issueGiftCardToggle);}
	}


     
	public void clickOnClose() {
		click(closeBtn);
	}
	
	public void isAllElementPresent() {
	Assertions.assertTrue(isElementPresent(issueGiftCardToggle, "Accepting and issuing Gift Cards toggle button"));
	Assertions.assertTrue(isElementPresent(referenceNoToggle, "Reference No. toggle button"));
	Assertions.assertTrue(isElementPresent(fundingSourceToggle, "funding source toggle button"));
	}


	
	public Clickable switchOffRefNoToggle() {
		return  Clickable.getElementBy(referenceNoToggle);
	}

	public String getRefNoLabel() {
		return getText_custom(referenceNoToggle);
	}

	public Clickable  switchOnFundingSourceToggle() {return  Clickable.getElementBy(fundingSourceToggle) ;}

	public void enterFundingSource(String string) {
		sendKeys(fundingSourceTbx, string);
	}
	
	public void switchOffFundingSourceToggle() {
		if(getText_custom(fundingSourceToggle).equalsIgnoreCase("Restricted funding source")) {
			click(fundingSourceToggle);}
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

	public String getFundingSourceToolTipMessage() {
		moveToWebElement(fundingSourceTbx);
		String id=getAttribute(fundingSourceTbx, "aria-describedby");
		return getText_custom(By.id(id));
	}
	
	public void enterMaxGiftCardAmount(int i) {
		clearMaxGiftCardTbx();
		sendKeysUsingJavaScript(maxGiftCardAmtTbx, "document.getElementsByName('maximumGCAmount')[0].value="+i);
	}
	
	public void clearFundingSource() {
		clear_custom(fundingSourceTbx);
	}

	public String getToastMessage() {
		By toastMessage=By.xpath("//div[contains(text(),'Gift card configuration for store has been updated.')]");
		return getText_custom(toastMessage);
	}
}
