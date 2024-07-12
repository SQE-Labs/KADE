package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentsPage extends BasePage {

    //Locators
    By othersBtn =By.xpath("//button[text()='Other']");
    By cashBtn = By.xpath("div.bg-white.w-100.border");
    By paidLabel = By.cssSelector("div.bg-success");

    //Actions
    public void clickOthersBtn(){
        click(othersBtn);
    }

    public void clickCashBtn(){
        moveToWebElement(cashBtn);
        click(cashBtn);
    }

    public boolean isPaidLabelDisplayed(){
        return isWebElementVisible(paidLabel);
    }
}
