package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardDetailsPage extends BasePage {

	By infoIcon=By.xpath("//i[@class='fal fa-info-square']");
	By editIcon=By.xpath("//i[@class='far fa-edit']");
	By fundingSourceTbx=By.name("fundSource");
	By refNoTbx=By.id("referenceNo");
	By memoTbx=By.name("memo");
	By startDateTbx=By.name("startDate");
	By expDate=By.name("expDate");
	By closeBtn=By.xpath("//button[@class='btn-close ms-2']");
	By cardNo=By.xpath("//h3[@class='text-info']");
	By startDate=By.xpath("//div[@class='d-flex justify-content-between'][2]");
	By issueOnDate=By.xpath("//div[@class='d-flex justify-content-between'][2]/span[1]");
	By issueByDate=By.xpath("//div[@class='d-flex justify-content-between'][2]/span[2]");
	By fundingSource=By.xpath("//div[@class='d-flex justify-content-between'][3]/span[1]");
	By refNo=By.xpath("//div[@class='d-flex justify-content-between'][3]/span[2]");
	By issueAmt=By.xpath("//div[@class='d-flex justify-content-between'][4]/span[1]");
	By userProfileName=By.xpath("//a[@class='text-truncate']");
	By externalLink=By.xpath("//i[@class='fas fa-external-link']");
	By activeBtn=By.xpath("//button[@class='btn dropdown-toggle badge me-2  btn-success']");
	By blockBtn=By.xpath("//button[@class='btn btn-outline-danger btn-sm w-100']");
	
	public void clickOnInfoIcon() {
		click(infoIcon);
	}
	
	public void clickOnEditIcon() {
		click(editIcon);
	}

	public boolean isFundingSourceTbxPresent() {
		return isElementPresent(fundingSource,"Funding Source Textbox");
	}
	
	public boolean isRefNoTbxPresent() {
		return isElementPresent(refNoTbx,"Funding Source Textbox");
	}
	
	public boolean isMemoTbxPresent() {
		return isElementPresent(memoTbx,"Funding Source Textbox");
	}
	
	public boolean isStartDateTbxPresent() {
		return isElementPresent(startDate,"Funding Source Textbox");
	}
	
	public boolean isExpDateTbxPresent() {
		return isElementPresent(expDate,"Funding Source Textbox");
	}
	

	public String getCardNo(){
		return getText_custom(cardNo);
	}

	public void clickOnClose() {
		click(closeBtn);
	}
		
	public boolean isStartDatePresent() {
		return isElementPresent(startDate,"Start Date");
	}
	
	public boolean isIssueOnDatePresent() {
		return isElementPresent(issueOnDate,"Issue On Date");
	}
	
	public boolean isIssueByDatePresent() {
		return isElementPresent(issueByDate,"Issue By Date");
	}
	
	public boolean isFundingSourcePresent() {
		return isElementPresent(fundingSource,"Funding Source");
	}
	
	public boolean isRefNoPresent() {
		return isElementPresent(refNo,"Ref No");
	}
	
	public boolean isIssueAmtPresent() {
		return isElementPresent(issueAmt,"Ref No");
	}

	public String getUserName() {
		return getText_custom(userProfileName);
		}

	public void clickOnUserName() {
		click(userProfileName);
	}

	public void clickOnExternalLink() {
		click(externalLink);
	}

	public void clickOnActiveBtn() {
		click(activeBtn);
	}
	
	public boolean isBlockBtnPresent() {
		return isElementPresent(blockBtn,"Block Button");
	}
}
