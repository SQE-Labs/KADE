package org.automation.pageObjects;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewBillPopUp extends BasePage {
	By popUpHeader = By.xpath("//h4[@class='modal-title']");
	By subTotalBox = By.xpath("//input[@name='subTotal']");
	By customerNumber = By.xpath("//input[@name='phone']");
	By createBtn =By.xpath("//button[@class='btn btn-primary fs-p50']");
	By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
	By addBillDescription = By.xpath("//th[text()='Description']");
	By addBillPrice = By.xpath("//th[text()='Price']");
	By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
	By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
	By refNoTextBox = By.xpath("//input[@name='refNo']");
	By autoGenToggleBtn= By.xpath("(//input[@name='autoGenerate'])[1]");
	By autoGenClass=By.xpath("(//input[@name='autoGenerate'])[1]/../../../..");
	By closeIcon = By.xpath("(//button[@class='btn-close'])[2]");
	By customerEmail=By.xpath("(//input[@name='email'])[2]");
	By moreToggleBtn = By.xpath("(//input[@name='captureCustomerInfo'])[1]");
	By custName=By.xpath("(//input[@name='custName'])[2]");
	By memoTextField=By.xpath("//textarea[@name='memo']");
	By price1=By.xpath("//input[@name='items[0].price']");
	By price2=By.xpath("//input[@name='items[1].price']");
	By description1=By.xpath("//input[@name='items[0].description']");
	By description2=By.xpath("//input[@name='items[1].description']");
	
	public String getPopUpTitle() {
		return getText_custom(popUpHeader);
	}
	
	public void enterSubTotalAmount(int i) {
		WebdriverWaits.waitForElementUntilVisible(subTotalBox, 5);
		sendKeysUsingJavaScript(subTotalBox, "document.getElementsByName('subTotal')[0].value="+i);
	}
	
	public void enterPhoneNumber(String number) {
		sendKeys(customerNumber, number);
	}
	
	public void clickOnCreate() {
		click(createBtn);
	}
	public void clickOnAddBillDetail() {
		click(addBillDetails);
		}
	
	public boolean billDetailsHeader() {
		return isElementPresent(addBillDescription, "Add Bill Details description");
	}

	public void clickOnAddMoreRow() {
		click(addMoreRowLink);
	}

	public void moveToSubTotal() {
		moveToWebElement(subTotalBox);
		
	}
	
	public String getToolTipMessage() {
		return getText_custom(toolTipMessage);
	}
	
	public void switchOffAutoGenToggle() {
		if(getAttribute(autoGenClass, "class").equalsIgnoreCase("mb-2 link-check checked")) {
		WebdriverWaits.waitForElementClickable(autoGenToggleBtn, 5);
		click(autoGenToggleBtn);}
	}

	public void switchOnAutoGenToggle() {
		if(!getAttribute(autoGenClass, "class").equalsIgnoreCase("mb-2 link-check checked")) {
			WebdriverWaits.waitForElementClickable(autoGenToggleBtn, 5);
			click(autoGenToggleBtn);
			}	
	}
	
	public boolean isReferenceNoTextboxPresent() {
		return isElementPresent(refNoTextBox, "Reference No Text Box");
	}


	public void clickOnCloseBtn() {
		WebdriverWaits.waitForElementClickable(closeIcon, 5);
		click(closeIcon);
	}

	public void switchOnMoreToggleBtn() {
		if(getDriver().findElement(By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..")).getAttribute("class").equalsIgnoreCase("mb-2 link-check checked"))
		click(moreToggleBtn);
	}
	
	public void switchOffMoreToggleBtn() {
		if(!getDriver().findElement(By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..")).getAttribute("class").equalsIgnoreCase("mb-2 link-check checked"))
			click(moreToggleBtn);
	}
	
	public boolean isCustNamePresent() {
		return isElementPresent(custName,"Customer Name");
	}
	
	public boolean isMemoPresent() {
		return isElementPresent(memoTextField,"Memo");
	}

	public boolean isRefNoTextFieldPresent() {
		return isElementPresent(refNoTextBox, "Ref No textbox");
	}

	public boolean isDescriptionPresent() {
		return isElementPresent(addBillDescription, "Bill Description");
	}

	public boolean isPricePresent() {
		return isElementEnabled(addBillPrice);
	}

	public void enterCustomerEmail(String string) {
		sendKeys(customerEmail, string);
	}

	public void enterMemo(String string) {
		sendKeys(memoTextField, string);
	}

	public void enterCustomerName(String string) {
		sendKeys(custName, string);
		}
	
	public void createBill(int billAmount,String phoneNo,String email,String custName,String memo) {
		switchOnAutoGenToggle();
		enterSubTotalAmount(billAmount);
		enterPhoneNumber(phoneNo);
		enterCustomerEmail(email);
		switchOnMoreToggleBtn();
		enterCustomerName(custName);	
		enterMemo(memo);
		clickOnCreate();
	}

	public void isElementsPresent() {
		Assert.assertTrue(isElementPresent(subTotalBox,"Sub Total Field"));
		Assert.assertTrue(isElementPresent(customerNumber,"Customer Number Field"));
		Assert.assertTrue(isElementPresent(customerEmail,"Customer Email Field"));
	}

	public String getToolTipMessagePhoneNumber() {
		moveToWebElement(customerNumber);
		String tipId = getAttributevalue(customerNumber, "aria-describedby");
		By id=By.id(tipId);
		return getText_custom(id);
	}

	public String getToolTipMessageEmail() {
		moveToWebElement(customerEmail);
		String tipId = getAttributevalue(customerEmail, "aria-describedby");
		By id=By.id(tipId);
		return getText_custom(id);
	}

	public void enterBillDetailValue1(String description,int price) {
		sendKeys(description1, description);
		sendKeysUsingJavaScript(price1, "document.getElementsByName('items[0].price')[0].value="+price);
	}
	
	public void enterBillDetailValue2(String description,int price) {
		sendKeys(description2, description);
		sendKeysUsingJavaScript(price1, "document.getElementsByName('items[1].price')[0].value="+price);
	}

	public Object getSubTotalValue() {
		return getText_custom(subTotalBox);
	}
	
	
}
