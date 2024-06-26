package org.automation.pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BillPage extends BasePage {

	public By newBillBtn = By.xpath("//button[@class='btn btn-outline-dark']");
	public By recurringBtn = By.xpath("//div[text()='Recurring']");
	public By alertMessage = By.xpath("//div[@class='alert-message']");
	public By transactionsLink = By.xpath("//div[text()='Transactions']");
	public By amtTbx = By.xpath("//input[@name=\"amount\"]");
	public By selectedCustomer= By.xpath("(//div[@data-field=\"name\"]/../../../..  //div[@class='d-none empty-d-block'])[2]");
	public By suggestionList = By.xpath("//div[@class=\"border rounded-3 mb-1 p-2 position-relative clone\"]");
	By customerField= By.xpath("//div[@class='modal-content']//label[text()='Customer']");
	By moreOptionsField= By.xpath("//div[@class=\"modal-body\"] //label[text()='More options']");
	By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
	By closeIcon = By.cssSelector("button.btn-close");
	By closeBillBtn = By.xpath("//span[text()='Bill']/../../../../.. //button");
	By userNumber = By.xpath("//input[@name='userPhone']");
	By filterBtn = By.xpath("//a[@class='collapsed']");
	By fromDatePicker = By.cssSelector("[name='dateRange']");
	By customerName = By.cssSelector("[name='custName']");
	By UserPhoneField = By.xpath("//input[@name='userPhone']");
	By UserEmailField = By.cssSelector("[name='email']");
	By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
	By customerNumberResult = By.xpath("//td[@class='text-nowrap']/p");
	By fromMonth = By.xpath("//th[@class='month'])[1]");
	By previousMonthArrow = By.xpath("//th[@class='prev available']");
	By toMonth = By.xpath("(//th[@class='month'])[2]");
	By nextMonthArrow = By.xpath("//th[@class='next available']");
	By unpaidBill = By.xpath("//div[@class='badge bg-danger']/../../..");
	By refNo=By.xpath("//tr[@class='none-workingEffect']/td[2]/p[1]");
	By toastCloseBtn = By.xpath("//button[@class='toast-close-button']");
	By toastMessage = By.xpath("//div[@class='toast-message']");
	By refundBtn = By.xpath("//button[@title='Refund']");
	By reasonField = By.xpath("(//input[@name='reason'])[3]");
	By processFullRefund = By.xpath("//button[@name='refundAll']");
	By refundHeader = By.xpath("//h4[@class='text-center color-inherit py-2']");
	By billGrid = By.xpath("//tr[@class='none-workingEffect']");
	By infoMessage = By.xpath("//div[@class='no-result-icon']/following-sibling::p");
	By billViewPopupTitleHeader = By.xpath("//h4[@class='modal-title']");
	By paidBill1= By.xpath("//tr//td//div//div[not(contains(text(),'NOT PAID')) and not(@class='text-danger') and not(contains(text(),'PARTIAL')) and not(@class='text-warning')]/../../..");
	By memoNote=By.xpath("(//tr[@class='none-workingEffect']/td[2]/a)[1]");
	By name=By.xpath("//td[@class='text-nowrap']/p[1]");
	By customerNames=By.xpath("//td[@class='text-nowrap']/p[1]");
	By bill=By.xpath("(//tr[@class='none-workingEffect'])[1]");
	By customerHeader = By.xpath("//span[text()='Customer']");
	By popUpHeader = By.cssSelector(".modal-title span");
	By subTotalBox = By.xpath("//input[@name='subTotal']");
	By customerNumber = By.xpath("//input[@name='phone']");
	By createBtn =By.xpath("//button[@class='btn btn-primary fs-p50']");
	By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
	public By addBillDescription = By.xpath("//textarea[@name='amount_description']");
	By addBillPrice = By.xpath("//th[text()='Price']");
	By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
	By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
	By refNoTextBox = By.xpath("//input[@name='refNo']");
	By autoGenToggleBtn= By.xpath("(//input[@name='autoGenerate'])[1]");
	By autoGenClass=By.xpath("(//input[@name='autoGenerate'])[1]/../../../..");
//	By closeIcon = By.xpath("(//button[@class='btn-close'])[2]");
	By customerEmail=By.xpath("(//input[@name='email'])[2]");
	By moreToggleBtn = By.xpath("(//input[@name='captureCustomerInfo'])[1]");
	By custName=By.xpath("(//input[@name='custName'])[2]");
	By memoTextField=By.xpath("//textarea[@name='memo']");
	By price1=By.xpath("//input[@name='items[0].price']");
	By price2=By.xpath("//input[@name='items[1].price']");
	By description1=By.xpath("//input[@name='items[0].description']");
	By description2=By.xpath("//input[@name='items[1].description']");
	public By amtInput = By.xpath("//input[@name='amount']");
	By closeCustomerBtn=By.xpath("//span[text()='Customer']/../..//button");
	By customerBtn= By.xpath("//span[text()='Bill']/../../../../../../div[2]/div/div/form/div[5]/div");
	public By phoneNoTbx = By.xpath("//input[@placeholder='Phone number']");
	public By emailTbx = By.xpath("//input[@placeholder='Email']");
	public By searchTbx = By.xpath("//input[@placeholder='Search']");
	By goBtnPhnNo = By.xpath("//input[@placeholder='Phone number']/..//button");
	By goBtnEmail = By.xpath("//input[@placeholder='Email']/..//button");
	By searcherName=By.xpath("(//div[@data-field='alias'])[2]");

	public String getPopUpTitle() {
		WebdriverWaits.waitForElementVisible(popUpHeader,5);
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


	public void CloseBillPopup() {
		click(closeBillBtn);
	}

	public void switchOnMoreToggleBtn() {
		By moreClass=By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..");
		if(getAttribute(moreClass, "class").equalsIgnoreCase("mb-2 link-check checked"))
			click(moreToggleBtn);
	}

	public void switchOffMoreToggleBtn() {
		By moreClass=By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..");
		if(!getAttribute(moreClass, "class").equalsIgnoreCase("mb-2 link-check checked"))
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

	public boolean isDescriptionDisplayed() {
		return isWebElementVisible(addBillDescription);
	}

	public boolean isPricePresent() {
		return isElementEnabled(addBillPrice);
	}

	public void enterCustomerEmail(String string) {
		sendKeys(emailTbx, string);
	}

	public void enterCustomerPhnNo(String phnNo){
		click(phoneNoTbx);
		pressKeys(phoneNoTbx, phnNo);
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

	public String getToolTipMessagePhoneNumber() {
		return getToolTipMessage(phoneNoTbx);
	}

	public String getToolTipMessageEmail() {
		return getToolTipMessage(emailTbx);
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

	public boolean isAleartMessageDisplayed() {
		return isElementPresent(alertMessage, "Alert Message Section");
	}

	public boolean isFilterBtnPresent() {
		return isElementPresent(filterBtn, "Filter Button");
	}

	public void clickOnTransactions() {
		click(transactionsLink);
	}

	public String getPageHeader() {
		return getText_custom(pageHeader);
	}

	public void closeBtn() {
		click(closeIcon);
	}

	public String getpPaidBillAmount() {
		scrollToElement(paidBill1);
		WebdriverWaits.waitForElementUntilVisible(paidBill1, 5);
		return getText_custom(paidBill1).replace("$", "");
	}

	public void clickOnNewBill() {
		WebdriverWaits.waitForElementClickable(newBillBtn, 5);
		click(newBillBtn);
	}

	public String getToastMessage() {
		return getText_custom(toastMessage);
	}

	public void clickOnFilter() {
		click(filterBtn);
	}

	public boolean isDateFieldPresent() {
		return isElementPresent(fromDatePicker, "From Date Picker");
	}

	public boolean isCustomerNamePresent() {
		return isElementPresent(customerName, "Customer Name Textbox");
	}

	public boolean isUserPhoneFieldPresent() {
		return isElementPresent(UserPhoneField, "User Phone Field");
	}

	public boolean isEmailFieldPresent() {
		return isElementPresent(UserEmailField, "User Email Field");
	}

	public void clickOnApply() {
		scrollToElement(applyBtn);
		WebdriverWaits.fluentWait_ElementIntactable(10, 100, applyBtn);
		click(applyBtn);
	}

	public String getCustomerPhoneNumber() {
		return getText_custom(customerNumberResult);
	}

	public void enterUserNumber(String string) {
		sendKeys(userNumber, string);
	}

	public void clickOnFirstTransaction() {
		WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
		click(unpaidBill);
	}

	public String getFirstRefNoBillDisplayed() {
		return getText_custom(refNo);
	}

	public void closeToastBtn() {
		WebdriverWaits.waitForElementClickable(toastCloseBtn, 5);
		click(toastCloseBtn);
	}

	public void openUnpaidBill() {
		WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
		click(unpaidBill);
	}


	public void clickOnFirstUnPaidBills() {
		WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
		click(unpaidBill);
	}

	public void clickOnRefund() {
		click(refundBtn);
	}

	public void enterReason(String string) {
		sendKeys(reasonField, string);
	}

	public void clickOnProcessFullRefund() {
		click(processFullRefund);
	}

	public String getRefundHeader() {
		return getText_custom(refundHeader);
	}

	public int getCountOfAllBill() {
		ScrollDownThePageMax();
		WebdriverWaits.sleep(2000);
		int count = countWebElements(billGrid);
		scrollToPageTop(newBillBtn);
			return count;
		//return getListOfWebElements(billGrid).stream().allMatch(a->a.isDisplayed());
	}

//	public void enterCustomerName(String string) {
//		sendKeys_withClear(customerName, string);
//	}

	public boolean isTransactionDisplayed() {
		return isElementPresent(transactionsLink, "Transactions Link");
	}


	public long countOfUserPhonePresent(String string) {
		ScrollDownThePageMax();
		By userPhoneOnBill = By.xpath("//p[text()='" + string + "']");
		long count = getAllMatchingCount(userPhoneOnBill, string);
		scrollToPageTop(newBillBtn);
		return count;
	}

	public void enterUserEmail(String string) {
		sendKeys(UserEmailField, string);
	}

	public long countOfUserEmailPresent(String string) {
		ScrollDownThePageMax();
		By userEmailOnBill = By.xpath("//p[text()='" + string + "']");
		scrollToPageTop(newBillBtn);
		long count=getAllMatchingCount(userEmailOnBill, string);
		return count;
	}

	public void enterFrom(String fromDate,String toDate) {
		String date=fromDate+" - "+toDate;
		sendKeys(fromDatePicker, date);
		getDriver().findElement(fromDatePicker).sendKeys(Keys.ENTER);
	}

	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}

	public String getEmailToolTiptMessage(){
		WebdriverWaits.sleep(500);
		return getToolTipMessage(UserEmailField);
	}

	public void clickOnBill() {
		click(billGrid);
	}

	public boolean isBillViewPopUpHeaderPresent() {
		return isElementPresent(billViewPopupTitleHeader, "Bill View Popup Title Header");
	}

	public boolean isRefNoPresent(String refNo2) {
		By refNo=By.xpath("//p[text()='"+refNo2+"']");
		return isElementPresent(refNo, "Ref No.");
	}

	public void clickOnFirstPaidBills() {
		clickOnFilter();
		enterCustomerName("Ana");
		clickOnApply();
		click(bill);

	}

	public String getToolTipMemo(){
		WebdriverWaits.waitForElementUntilVisible(memoNote, 5);
		return getToolTipMessage(memoNote);
	}

	public String getToolTipUserPhone() {
		WebdriverWaits.sleep(2000);
		return getToolTipMessage(UserPhoneField);
	}

	public long countOfPartialCustName(String string) {
		return getAllMatchingCount(name,string);
	}

	public boolean verifyRecordsDateRange(List<String> billDate,String fromDate, String toDate) {
		for(String s:billDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate actualDate = LocalDate.parse(s, formatter);
		LocalDate fromdate=LocalDate.parse(fromDate,formatter);
		LocalDate todate=LocalDate.parse(toDate, formatter);
		if(!actualDate.isBefore(fromdate) && !actualDate.isAfter(todate))
		{
			continue;
		}
		else
			return false;
		}
		return true;

	}

	public List<String> getDateOfBill() {
		By billDate=By.xpath("//tr[@class='none-workingEffect']/td[2]/p[2]");
		List<WebElement> allDates = getListOfWebElements(billDate);
		List<String> date = allDates.stream().map(str->str.getText().split(" ")[0]).collect(Collectors.toList());
		return date;
	}

	public boolean checkFieldContains(String string) {
		List<String> custList = getListOfString(customerNames).stream().map(m->m.toLowerCase()).collect(Collectors.toList());
		String str = string.toLowerCase();
		return custList.stream().allMatch(a->a.contains(str));
	}

	public boolean isNewBillBtnDisplayed() {
		return isWebElementVisible(newBillBtn);
	}

	public boolean isTransactionLinkDisplayed() {
		return  isWebElementVisible(transactionsLink);
	}

	public boolean isAmountTbxDisplayed() {
		return isWebElementVisible(amtTbx);
	}

	public boolean isCustomerFieldDisplayed() {
		return isWebElementVisible(customerField);
	}

	public boolean isMoreOptionDisplayed() {
		return isWebElementVisible(moreOptionsField);
	}

	public void enterAmount(String amt) throws InterruptedException {
		WebdriverWaits.waitForElementUntilVisible(amtInput, 5);
    	clear_custom(amtInput);
		pressKeys(amtInput,amt);
	}

	public void getAmtValue(){

	}

	public String getSelectedCustomer() {
		return getText_custom(selectedCustomer);
	}

	public void clickCustomer(){
		click(customerBtn);
	}

	public String getCustomerHeader() {
		return getText_custom(customerHeader);
	}

	public void closeCustomerPopup() {
		click(closeCustomerBtn);
	}

	public void clickOnGoBtnPhoneNo() {
		click(goBtnPhnNo);
	}

	public void clickOnGoBtnEmail() {
		click(goBtnEmail);
	}

	public void searchCustomer(String customer) {
		WebdriverWaits.fluentWait_ElementIntactable(5,500,searchTbx);
		click(searchTbx);
		sendKeys_withClear(searchTbx,customer);
	}

	public String getSearchedCustomer() {
		return  getText_custom(searcherName);
	}
}
