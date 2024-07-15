package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PaymentsPage extends BasePage {

    //Locators
    By othersBtn =By.xpath("//button[text()='Other']");
    By cashBtn = By.xpath("//button[@name='payType']");
    By paidLabel = By.xpath("//div[contains(text(),'Paid')]");
    By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
    By closeIcon =By.xpath("(//button[@class=\"btn-close\"])[1]");
    By creditCardBtn = By.xpath("//button[text()='Credit Card']");
    By creditCardInfoPopupTitle = By.xpath("//h5[text()='Credit card information']");
    By cardNumberTbx = By.id("Field-numberInput");
    By expirationDateTbx = By.id("Field-expiryInput");
    By cvcTbx = By.id("Field-cvcInput");
    By countryDropDown = By.id("Field-countryInput");
    By processBtn = By.xpath("//button[@type=\"submit\" and contains(text(),'Process')]");
    By creditCardInfoFrame = By.xpath("//h5[text()='Credit card information']/../..//iframe");


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

    public void clickCreditCardBtn(){
        click(creditCardBtn);
    }

    public void enterCardNumber(String cardNumber){
        pressKeys(cardNumberTbx,cardNumber);
    }

    public void enterExpirationDate(String expiryDate){
        pressKeys(expirationDateTbx,expiryDate);
    }

    public void enterCvcNumber(String cvcNumber){
        pressKeys(cvcTbx,cvcNumber);
    }

    public void selectCountry(String country){
        selectDropDownByVisibleText_custom(countryDropDown,country);
    }

    public void clickProcessBtn(){
        click(processBtn);
    }


    public void switchToCreditCardFrame() {
        switchToFrame(creditCardInfoFrame);
    }
}
