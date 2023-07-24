package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class RefundPage extends BasePage{
	By refundBtn=By.xpath("//button[@title='Refund']");
	By refNoTextBox=By.xpath("//input[@name='refNo']");
	By reasonTextBox=By.xpath("(//input[@name='reason'])[2]");
	By processFullRefundBtn= By.xpath("//button[@name='refundAll']");
	By partialRefundBtn=By.cssSelector("button.btn.btn-link.collapsed.btn-sm.p-0");
	By checkBoxBtn=By.xpath("//i[@class='fal fa-square custom-check-off ']");
	By closeValidatioBtn=By.xpath("//button[@class='btn-close']");
	By refundAmountTextBox=By.xpath("//input[@name='refunds[0].amount']");
	By processRefundBtn=By.xpath("(//button[@class='btn btn-outline-danger'])[2]");
	
	public boolean isRefNoTextBoxPresent() {
		return isElementEnabled(refNoTextBox);
	}

	public boolean isReasonTextBoxPresent() {
		return isElementEnabled(reasonTextBox);
	}
	
	public boolean isRefundBtnPresent() {
		return isElementEnabled(refundBtn);
	}
	public void clickOnRefund() {
		WebdriverWaits.waitForElementUntilVisible(refundBtn, 5);
		click(refundBtn);
	}

	public void clickOnProcessFullRefund() {
		click(processFullRefundBtn);
	}

	public String getReasonToolTip() {
		moveToWebElement(reasonTextBox);
		String toolTipId=getAttribute(reasonTextBox, "aria-describedby");
        By toolTipMessage =By.id(toolTipId);
    		return getElementText(toolTipMessage);
	}

	public void clickOnPartialRefundLink() {
		scrollToElement(partialRefundBtn);
		click(partialRefundBtn);
	}

	public boolean isCheckBoxPresent() {
		return isElementPresent(checkBoxBtn,"Check Box");
	}

	public void closeValidationMessage() {
		click(closeValidatioBtn);
	}

	public void checkCheckBox() {
		scrollToElement(checkBoxBtn);
		WebdriverWaits.waitForElementUntilVisible(checkBoxBtn, 5);
		click(checkBoxBtn);
	}

	public boolean isRefundAmountTextBoxPresent() {
		return isElementPresent(refundAmountTextBox,"Refund Amount textbox");
	}

	public void enterRefundAmount(int amount) {
		scrollToElement(refundAmountTextBox);
		clear_custom(refundAmountTextBox);
		sendKeysUsingJavaScript(refundAmountTextBox, "document.getElementsByName('refunds[0].amount')[0].value="+amount);
	}

	public String getRefundToolTipMessage() {
		moveToWebElement(refundAmountTextBox);
		String toolTipId=getAttribute(refundAmountTextBox, "aria-describedby");
        By toolTipMessage =By.id(toolTipId);
    		return getElementText(toolTipMessage);
	}

	public void clickOnProcessRefund() {
		scrollToElement(processRefundBtn);
		WebdriverWaits.waitForElementUntilVisible(processRefundBtn, 5);
		click(processRefundBtn);
	}

	public void removeMouseFromTextBox() {
		moveToWebElement(By.xpath("//h4[@class='text-danger text-center mb-2']"));
	}
	
	
}
