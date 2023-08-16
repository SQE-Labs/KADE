package test;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class CardNoPopup extends BasePage{
	By closeBtn=By.xpath("//button[@class='btn-close ms-2']");
	By cardNo=By.xpath("//h3[@class='text-info']");
	By infoIcon=By.xpath("//i[@class='fal fa-info-square']");
	By startDate=By.xpath("//div[@class='d-flex justify-content-between'][2]");
	By issueOnDate=By.xpath("//div[@class='d-flex justify-content-between'][2]/span[1]");
	By issueByDate=By.xpath("//div[@class='d-flex justify-content-between'][2]/span[2]");
	By fundingSource=By.xpath("//div[@class='d-flex justify-content-between'][3]/span[1]");
	By RefNo=By.xpath("//div[@class='d-flex justify-content-between'][3]/span[2]");
	By issueAmt=By.xpath("//div[@class='d-flex justify-content-between'][4]/span[1]");
	By userProfileName=By.xpath("//a[@class='text-truncate']");
	By externalLink=By.xpath("//i[@class='fas fa-external-link']");
	
	public String getCardNo(){
		return getText_custom(cardNo);
	}

	public void clickOnClose() {
		click(closeBtn);
	}
	
	public void clickOnInfoIcon() {
		click(infoIcon);
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
		return isElementPresent(RefNo,"Ref No");
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
}
