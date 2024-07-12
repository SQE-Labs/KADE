package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class PaymentsPage extends BasePage {

    //Locators
    By othersBtn =By.xpath("//button[text()='Other']");
    By cashBtn = By.xpath("//button[@name='payType']");
    By paidLabel = By.xpath("//div[contains(text(),'Paid')]");
    By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
    By closeIcon =By.xpath("(//button[@class=\"btn-close\"])[1]");


    //Actions
    public void clickOthersBtn(){
        click(othersBtn);
    }

    public void clickCashBtn(){
        WebdriverWaits.waitForElementVisible(By.xpath("//h5[text()='Payment type']"),5);
        moveToWebElement(cashBtn);
        clickElementByJS(cashBtn);
    }

    public boolean isPaidLabelDisplayed(){
        WebdriverWaits.waitForElementVisible(paidLabel,5);
        return isWebElementVisible(paidLabel);
    }

    public String getReceivedPaymentTitle(){
        return getText_custom(paymentPopupTitle);
    }

    public void closeReceivedPopup(){
        click(closeIcon);
    }

}
