package org.automation.pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCardDashboardPage extends BasePage{

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
	
	public void clickOnConfigurationLink() {
		click(configurationLink);
	}
	
	public String getInfoMessage() {
		return getText_custom(infoMessage);
	}
	
	public void clickOnIssueAGiftCard() {
		WebdriverWaits.waitForElementClickable(issueGiftCardBtn, 5);
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
		WebdriverWaits.waitForElementUntilVisible(applyBtn, 5);
		click(applyBtn, "Apply Button");
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
		WebdriverWaits.waitForElementUntilVisible(resultMessage, 10);
		return getText_custom(resultMessage);
	}

	public void enterDate(String dateRange) {
		sendKeys(datePicker, dateRange);
	}

	public List<String> getGiftIssuedate() {
		WebdriverWaits.sleep(3000);
		List<WebElement> allDates = getDriver().findElements(issueDate);
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
		moveToWebElement(datePicker);
		String id=getAttribute(datePicker, "aria-describedby");
		By tipId=By.id(id);
		return getText_custom(tipId);
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

	
	
	
}
