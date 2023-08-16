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

	By newBillBtn = By.xpath("//button[@class='btn btn-outline-dark']");
	By alertMessage = By.xpath("//div[@class='alert-message']");
	By transactionsLink = By.xpath("//a[text()='Transactions']");
	By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
	By closeIcon = By.cssSelector("button.btn-close");
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
		WebdriverWaits.waitForElementUntilVisible(applyBtn, 5);
		click(applyBtn);
	}

	public String getCustomerPhoneNumber() {
		return getText_custom(customerNumberResult);
	}

	public void enterUserNumber(String string) {
		sendKeys(userNumber, string);
	}

	public void clickOnFirstTransaction() {
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
		click(unpaidBill);
	}


	public void clickOnFirstUnPaidBills() {
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

	public void enterCustomerName(String string) {
		sendKeys_withClear(customerName, string);
	}

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

	}
