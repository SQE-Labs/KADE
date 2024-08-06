package org.automation.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GiftCardDashboardPage extends BasePage {

	By configurationLink = By.xpath("//button[text()='Configuration']");
	By infoMessage = By.xpath(" //div[@class='card-header pb-0']");
	By issueGiftCardBtn=By.xpath("(//button[@class='btn btn-link'])[2]"); 
	By giftCardForSaleLink = By.xpath("//a[@class='btn btn-link']");
	By giftCardNo=By.xpath("//a[@class='btn btn-link btn btn-link']");
	By filterLink=By.xpath("//a[@class='collapsed']");
	By userNameField=By.xpath("//input[@name='userName']");
	By userPhoneEmailField=By.xpath("//input[@name='userPhone']");
	By datePicker=By.xpath("//input[@name='dateRange']");
	By giftCardStatus=By.xpath("//select[@name='status']");
	By minAmount=By.xpath("//input[@name='minAmount']");
	By maxAmount=By.xpath("//input[@name='maxAmount']");
	By cardNo=By.xpath("//input[@name='cardNo']");
	By allGiftCardStatus=By.xpath("//table/tbody/tr //td[text()='Active']");
	By applyBtn=By.xpath("//button[@class='btn-sm btn btn-outline-primary']");
	By cardHolderName = By.xpath("//a[@class='d-flex align-items-center']/span");
	By resultMessage = By.xpath("//div[@class='w-100 align-items-center d-flex flex-column']/p");
	By issueDate =By.xpath("//*[@class=\"tb006 table table-striped table-hover sortable_table\"]/tbody/tr/td[2]");
	By validationClose=By.xpath("//button[@class='btn-close']");
	By status=By.xpath("//tbody/tr/td[9]");
	By amount=By.xpath("//tbody/tr/td[6]");
	By cardNoViewed=By.xpath("//tbody/tr/td[1]/a");
	By totalCountAndAmt=By.xpath("//h6/span");
	By GiftCardGrid=By.xpath("//a[@class='d-flex align-items-center']");
	By row=By.xpath("//p[text()='Card No.']");
	
	public void clickOnConfigurationLink() {
		click(configurationLink);
	}
	
	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}
	
	public void clickOnIssueAGiftCard() {
		WebdriverWaits.fluentWait_ElementIntactable(10, 100, issueGiftCardBtn);
		click(issueGiftCardBtn);
	}

	public boolean isIssueAGiftCardLinkPresent() {
		WebdriverWaits.waitForElementUntilVisible(issueGiftCardBtn, 5);
		return isElementPresent(issueGiftCardBtn,"Issue Gift Card Link");
	}
	
	public boolean isGiftCardForSaleLinkPresent() {
		WebdriverWaits.waitForElementUntilVisible(issueGiftCardBtn, 5);
		return isElementPresent(giftCardForSaleLink,"Gift Card For Sale Link");
	}

	public void clickOnGiftCard() {
		click(giftCardNo);
	}

	public String getGiftCard() {
		return getText_custom(giftCardNo);
	}

	public void clickOnFilter() {
		click(filterLink);
	}

	public boolean isUserNameFieldPresent() {
		return isElementPresent(userNameField, "User Name Field");
	}
	
	public boolean isUserPhoneEmailFieldPresent() {
		return isElementPresent(userPhoneEmailField, "User Phone/Email Field");
	}
	
	public boolean isDateFieldPresent() {
		return isElementPresent(datePicker, "Date Picker");
	}
	
	public boolean isGiftCardStatusPresent() {
		return isElementPresent(giftCardStatus	, "Gift Card Status");
	}
	
	public boolean isMinAmountFieldPresent() {
		return isElementPresent(minAmount, "Min Amount Field");
	}
		
	public boolean isMaxAmountFieldPresent() {
		return isElementPresent(maxAmount, "Max Amount Field");
	}
	
	public boolean isCardNoFieldPresent() {
		return isElementPresent(cardNo, "Card No Field");
	}

	public boolean isAllGiftCardStatus(String status) {
		return areAllELementTextMatches(allGiftCardStatus, status);
		}

	public void clickOnApply() {
		scrollToElement(applyBtn);
		WebdriverWaits.fluentWait_ElementIntactable(10, 10, applyBtn);
		click(applyBtn);
	}
	
	public void enterUserName(String name) {
		sendKeys(userNameField, name);
	}

	public boolean isAllCardHolderName(String name) {
		WebdriverWaits.sleep(3000);
		return areAllELementTextMatches(cardHolderName, name);
	}

	public void enterUserPhoneEmail(String string) {
		sendKeys(userPhoneEmailField,string);
	}
	
	public String getResultNotFoundMessage() {
		WebdriverWaits.sleep(2000);
		return getText_custom(resultMessage);
	}

	public void enterDate(String dateRange) {
		sendKeys_withClear(datePicker, dateRange);
	}

	public List<String> getGiftIssuedate() {
		WebdriverWaits.sleep(2000);
		List<WebElement> allDates = getListOfWebElements(issueDate);
		List<String> date = allDates.stream().map(str->str.getText()).collect(Collectors.toList());
		return date;
	}

	public boolean areAllGiftCardOfRange(List<String> giftIssuedate, String startDate, String endDate) {
		
		for(String s:giftIssuedate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			LocalDate actualDate = LocalDate.parse(s, formatter);
			LocalDate fromdate=LocalDate.parse(startDate,formatter);
			LocalDate todate=LocalDate.parse(endDate, formatter);
			if(!actualDate.isBefore(fromdate) && !actualDate.isAfter(todate))
			{
				continue;
			}
			else
				return false;
			}

		return true;
	}

	public String getDateRangeToolTipMessage() {
		WebdriverWaits.waitForElementUntilVisible(datePicker, 5);
		return getToolTipMessage(datePicker);
	}

	public void clickOnCloseValidation() {
		click(validationClose);
	}

	public String getSelectedGiftCardStatus() {
		return getSelectedOptionOfDropdown(giftCardStatus);
	}

	public void clickOnGiftCardStatusField() {
		click(giftCardStatus);
	}

	public List<String> getAllGiftCardStatusOptions() {
		return getAllOptionsOfDropDown(giftCardStatus);
	}

	public void selectGiftCardStatues(String string) {
		selectByText(giftCardStatus,string);
	}

	public boolean checkStatus(String text) {
		WebdriverWaits.sleep(3000);
		return getListOfString(status).stream().allMatch(m->m.equalsIgnoreCase(text));
	}

	public void enterMinAmount(String string) {
		sendKeys(minAmount, string);
	}

	public boolean checkAmtGreaterThanMinAmt(String string) {
		WebdriverWaits.sleep(2000);
		int amt=Integer.valueOf(string);
		List<String> amtList=getListOfString(amount).stream().map(m->m.replace("$", "")).map(a->a.substring(0,a.indexOf("."))).collect(Collectors.toList());
		for (int i=0;i<amtList.size();i++) {
			String value =amtList.get(i);
			if(value.contains(",")) {
				String updatedVal=value.replace(",", "");
				amtList.set(i,updatedVal);
			}}
		return amtList.stream().map(a->Integer.valueOf(a)).allMatch(m->m>=amt);
}

	public void enterMaxAmount(String string) {
		sendKeys(maxAmount, string);
	}

	public boolean checkAmtLessThanMaxAmt(String string) {
		WebdriverWaits.sleep(2000);
		int amt=Integer.valueOf(string);
		List<String> amtList=getListOfString(amount).stream().map(m->m.replace("$", "")).map(a->a.substring(0,a.indexOf("."))).collect(Collectors.toList());
		for (int i=0;i<amtList.size();i++) {
			String value =amtList.get(i);
			if(value.contains(",")) {
				String updatedVal=value.replace(",", "");
				amtList.set(i,updatedVal);
			}}
		return amtList.stream().map(a->Integer.valueOf(a)).allMatch(m->m<=amt);
	}

	public boolean checkAmtBetweenMinAndMaxAmt(String string1, String string2) {
		WebdriverWaits.sleep(2000);
		int min=Integer.valueOf(string1);
		int max=Integer.valueOf(string2);
		List<String> amtList=getListOfString(amount).stream().map(m->m.replace("$", "")).map(a->a.substring(0,a.indexOf("."))).collect(Collectors.toList());
		for (int i=0;i<amtList.size();i++) {
			String value =amtList.get(i);
			if(value.contains(",")) {
				String updatedVal=value.replace(",", "");
				amtList.set(i,updatedVal);
			}}
		return amtList.stream().map(a->Integer.valueOf(a)).allMatch(m->m>=min && m<=max);
	}

	public void enterCardNo(String card) {
		sendKeys(cardNo, card);
	}

	public boolean checkCardNo(String cardNo2) {
		WebdriverWaits.sleep(3000);
		return getListOfString(cardNoViewed).stream().allMatch(a->a.equalsIgnoreCase(cardNo2));
	}

	public String getCardNoToolTipMessage() {
		clickOnCloseValidation();
		WebdriverWaits.waitForElementUntilVisible(cardNo, 5);
		return getToolTipMessage(cardNo);
	}

	public boolean isotalCountAndTotalAmtDisplayed() {
		return isElementPresent(totalCountAndAmt, "Total Count and Total Amount");
	}

	public void clickOnGiftCardForSaleLink() {
		click(giftCardForSaleLink);
	}
	
	public int getFilterResultCount() {
		WebdriverWaits.sleep(3000);
		return getListOfString(GiftCardGrid).size();
	}
}
