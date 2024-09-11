package org.automation.pages.popups;
import org.automation.base.BasePage;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class NewAccountPopup extends BasePage {
    // Business Account locators
    By phoneFieldLabel = By.xpath("//div[@class='mb-3 -row- pt-3']/label[1]");
    By useEmailLink = By.xpath("//button[text()='Use email']");
    By mobilePhoneField = By.cssSelector("[name='phone']");
    By emailBusinessField = By.cssSelector("[name='email']");
    By fullname= By.cssSelector("[name='name']");
    By startOverLink = By.xpath("//button[text()='Start Over']");
    By resendCode = By.xpath("//button[text()='Resend the code']");
    By ContinueButtonBusiness = By.xpath("(//button[@type='submit'][text()='Continue'])[2]");
    By securityCodeSendInfoMsg = By.cssSelector(".p-2.mb-2.fs-pn15");
    By securityCodeAlertMessage = By.xpath("//p[text()='Invalid security code']");
    By stripePageTitle = By.cssSelector(".header-title.mb-0");
    By signInButton = By.xpath("//button[text()='Sign in']");

    // Business Account methods

    public Clickable getMobilePhoneFieldLabel() {
        return Clickable.getElementBy(phoneFieldLabel, "MobilePhone Number field");
    }
    public Clickable getUseEmailLink() {
        return Clickable.getElementBy(useEmailLink, "Use Email Link");
    }
    public Clickable getBusinessAccountCheckbox() {
        return Clickable.getElementBy(useEmailLink, "Use Email Link");
    }
    public Editable getMobilePhoneField() {
        return Editable.getElementBy(mobilePhoneField, "MobilePhoneField");
    }
    public Editable getEmailBusinessAccountField(){
        return Editable.getElementBy(emailBusinessField, "Email Business Account Field");
    }
    public Editable getFullName(){
        return Editable.getElementBy(fullname, "Full Name");
    }
    public Clickable getStartOverLink(){
        return Clickable.getElementBy(startOverLink,"Start Over Link");
    }
    public Clickable getResendCode(){
        return Clickable.getElementBy(resendCode,"Resend Code Link");
    }
    public Clickable getContinueButtonOfBusinessAccount(){
        return Clickable.getElementBy(ContinueButtonBusiness,"Resend Code Link");
    }
    public Clickable getCodeSendToInformationMessage(){
        return Clickable.getElementBy(securityCodeSendInfoMsg,"security code send to information message");
    }
    public Clickable getSecurityCodeAlertMessage(){
        return Clickable.getElementBy(securityCodeAlertMessage,"security code send to Alert Message");
    }

    public Clickable getStripePageTitle(){
        return Clickable.getElementBy(stripePageTitle,"New Business Page Title");
    }
    public Clickable getSignInButton() {
        return Clickable.getElementBy(signInButton, "Sign In Button");
    }


}
