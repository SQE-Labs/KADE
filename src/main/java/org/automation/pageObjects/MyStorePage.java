package org.automation.pageObjects;

import java.util.List;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {

    By registerNewBusinessBtn=By.partialLinkText("Register new business");
	By skipStripeAccountBtn=By.cssSelector(".btn-lg.fw-bold.w-100.btn.btn-outline-primary");
	By skipStripeAccountPopUpBtn=By.xpath("//div[@class='modal-content']//button[text()='Skip']");
	By deleteStoreBtn=By.xpath("//button[text()='Delete the store']");
	By deleteStoreIcon = By.cssSelector(".fa.fa-check");

	public void clickRegisterNewBusinessBtn() {
		click(registerNewBusinessBtn);
	}
	public void clickSkipStripeAccountBtn() {
		click(skipStripeAccountBtn);
	}
	public void clickSkipStripeAccountPopUpBtn() {
		WebdriverWaits.waitForElementClickable(skipStripeAccountPopUpBtn, 5);
		clickElementByJS(skipStripeAccountPopUpBtn);
	}
	public void clickDeleteStoreBtn(){
		WebdriverWaits.waitForElementUntilVisible(deleteStoreBtn, 5);
		click(deleteStoreBtn);
	}
	public void clickDeleteStoreIcon(){
		WebdriverWaits.waitForElementUntilVisible(deleteStoreIcon, 5);
		click(deleteStoreIcon);
	}

}
