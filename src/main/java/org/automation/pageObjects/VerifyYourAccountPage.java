package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class VerifyYourAccountPage extends BasePage {

    // Locators
    By emailOrPhoneFieldOnVerifyAccountPage = By.xpath("//input[@name='email_phone']");
    By securityCodeField = By.xpath("//input[@name='otp']");
    By continueButton = By.xpath("//button[@class='btn-lg btn btn-primary']");
    By resendSecurityCode = By.xpath("//button[@class='btn btn-link']");


    // Methods
    public boolean checkPresenceOfEmailOrPhoneFieldOnVerifyAccountPage(){
       return isElementPresent(emailOrPhoneFieldOnVerifyAccountPage,"Email or Phone");
    }

    public boolean checkPresenceOfSecurityCodeField(){
       return isElementPresent(securityCodeField,"Security Code");
    }

    public boolean checkPresenceOfContinueButton(){
        return isElementPresent(continueButton,"Continue");
    }

    public void clickResendSecurityCode(){
        clickBtn(resendSecurityCode);
    }

    public void EnterSecurityCode(String securityCode) {
    sendKeys(securityCodeField,securityCode);
    }

    public void clickContinueButton(){
        clickBtn(continueButton);
    }


}
