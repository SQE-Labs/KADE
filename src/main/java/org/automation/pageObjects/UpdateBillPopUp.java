package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UpdateBillPopUp extends BasePage{
	By updateBtn=By.xpath("//button[text()='Update']");
	By subTotalTextBox=By.cssSelector("[name='subTotal']");
	By sendToCustomerTbx = By.cssSelector("[name='phone']");
	By sendEmailToCustomerTbx = By.xpath("(//input[@name='email'])[2]");
	By closeBtn = By.xpath("(//button[@class='btn-close'])[2]");
	By addBillDetailLink = By.cssSelector("button.btn-sm.float-end");
	By descriptionTbx =  By.xpath("(//table[@class='table table-borderless table-sm mb-2 fs-pn15']/tbody/tr/td[1])[1]");
	By priceTbx=By.xpath("(//table[@class='table table-borderless table-sm mb-2 fs-pn15']/tbody/tr/td[2])[1]");
	By moreToggleBtn=By.xpath("(//input[@name='captureCustomerInfo'])[1]");
	By customerNameTbx=By.xpath("(//input[@name='custName'])[2]");
	By memoTbx=By.xpath("//textarea[@name='memo']");

	
	public void isAllFieldPresent() {
		Assert.assertTrue(isElementPresent(updateBtn, "Update Button"));
		Assert.assertTrue(isElementPresent(sendToCustomerTbx, "Send To Customer TextBox"));
		Assert.assertTrue(isElementPresent(sendEmailToCustomerTbx,"Send Email to Customer TextBox"));
		Assert.assertTrue(isElementPresent(subTotalTextBox, "Sub Total Text Box"));
	}
	
	public void clickOnClose() {
		click(closeBtn);
	}

	public void enterSubTotalAmount(int	i) {
		clear_custom(subTotalTextBox);
		sendKeysUsingJavaScript(subTotalTextBox, "document.getElementsByName('subTotal')[0].value="+i);
	}
	
	public void clickOnUpdateBtn() {
		click(updateBtn);
	}
	
	public String getSubTotalToolTipMsg() {
		moveToWebElement(subTotalTextBox);
		String id=getAttributevalue(subTotalTextBox, "aria-describedby");
		By tipMessage=By.id(id);
		return getText_custom(tipMessage);
	}
	
	public void clickOnAddBillDetailLink() {
		click(addBillDetailLink);
	}
	
	public boolean isDescriptionFieldDisplayed() {
		return isElementPresent(descriptionTbx, "Description Text Box");
	}
	
	public boolean isPriceFieldDisplayed() {
		return isElementPresent(priceTbx, "Price Text Box");
	}
	
	public void switchOnMoreDetailsToggle() {
		By toggleClass=By.xpath("(//input[@name='captureCustomerInfo'])[1]/../../../..");
		if(getAttribute(toggleClass, "class").equalsIgnoreCase("mb-2 link-check checked"))
			click(moreToggleBtn);
	}
	
	public boolean isCustomerNameDisplayed() {
		return isElementPresent(customerNameTbx, "Customer Name Text Box");
	}
	
	public boolean isMemoTbxDisplayed() {
		return isElementPresent(memoTbx, "Memo Text Box");
	}
}
