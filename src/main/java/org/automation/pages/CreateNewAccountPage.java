package org.automation.pages;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.event.CaretListener;

public class CreateNewAccountPage extends BasePage {

    // Locators
    By appLogo = By.xpath("//span[@class='app-name-logo']");
    By createNewAccountTitle = By.xpath("//div[@class='card-header text-center']");
    By emailOrPhoneLabel = By.xpath("//input[@name='phone_email']");
    By emailOrPhoneField = By.xpath("//input[@name='phone_email']");
    By signUpButton = By.xpath("//button[@class='btn-lg btn btn-primary']");
    By alreadyHaveAnAccountLabel = By.xpath("//p[contains(text(),'Already have an account?')]");
    By signInLink = By.xpath("//a[@class='ms-2']");
    By checkBox=By.xpath("//i[@class='fal fa-square custom-check-off ']");
    By businessAccountButton = By.xpath("//a[text()='Business Account']");
    By personalAccountButton = By.xpath("//a[text()='Personal Account']");
    By existingPhoneValidation = By.xpath("//p[text()='This phone number is already registered.']");
    By existingEmailValidation = By.xpath("//p[text()='This email is already registered.']");
    By crossIcon = By.cssSelector(".btn-close");
    By verifyAccountTitle = By.xpath("//h1[text()='Verify your account']");
    By securityCodeLabel = By.xpath("//label[text()='Security Code']");
    By securityCodeField = By.cssSelector("[name=\"otp\"]");
    By continueButton = By.xpath("//button[text()='Continue']");
    By setYourPasswordTitle = By.xpath("//h1[text()='Set your password']");
    By submitButton = By.xpath("//button[text()='Submit']");
    By passwordField = By.cssSelector("[name='password']");
    By confirmPasswordField = By.cssSelector("[name='confirmPassword']");
    By showPassword = By.cssSelector("[class='ms-2 text-start']");
    By successMessage = By.xpath("//p[@class='text-success fs-3']/.");
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
    // Sign In Popup Locators



    // Methods
     public Clickable getKadelogo() {
         return Clickable.getElementBy(appLogo, "App Logo");
     }

     public Clickable getCreateNewAccountTitle() {
        return Clickable.getElementBy(createNewAccountTitle, "Create New Account Title ");
    }

       public Clickable getEmailOrPhoneNumberLabel(){
           return Clickable.getElementBy (emailOrPhoneLabel,"Email or Phone Label");
    }

    //Method for check presence of 'Already have an account? Sign-in' label
      public Clickable getPresenceOfAlreadyHaveAnAccountTitle(){
        return Clickable.getElementBy(alreadyHaveAnAccountLabel,"Already have an account? Sign-in");
    }

     // Method for check presence of 'Email or Phone' field
    public Editable getEmailOrPhoneField(){
       return Editable.getElementBy(emailOrPhoneField,"Email or Phone field");
    }

         // Verify the 'Sign-in' link label
    public Clickable getSignInLink(){
        return Clickable.getElementBy(signInLink,"Sign-in");
    }

    // Verify 'Sign up' button
    public Clickable getSignUpButton(){
       return Clickable.getElementBy(signUpButton,"Sign up");
    }

       public Clickable getReceiveTextEmailNotificationCheckBox() {
       return Clickable.getElementBy(checkBox,"ReceiveTextEmail Notification CheckBox");
   }

    public Clickable getBusinessAccountButton() {
         return Clickable.getElementBy(businessAccountButton,"Business Account Button");
             }

    public Clickable getPersonalAccountButton() {
        return Clickable.getElementBy(personalAccountButton,"Personal Account Button");
            }
    public Clickable getExistingPhoneValidationMessage(){
         return Clickable.getElementBy(existingPhoneValidation, " Phone Validation");
    }
    public Clickable getExistingEmailValidation(){
        return Clickable.getElementBy(existingEmailValidation, "Email Validation");
    }
    public Clickable getCrossICon(){
         return Clickable.getElementBy(crossIcon,"Cross icon");
    }
    public Clickable getVerifyAccountTitle(){
        return Clickable.getElementBy(verifyAccountTitle, " Verify Account Title");
    }
    public Clickable getSecurityCodeLabel(){
        return Clickable.getElementBy(securityCodeLabel,"Security Code label");
    }
    public Editable getSecurityCodeField(){
         return Editable.getElementBy(securityCodeField, "Security code field");
    }
    public Clickable getContinueButton(){
        return Clickable.getElementBy(continueButton, "Continue Button");
    }
    public Clickable getSetPasswordTitle() {
        return Clickable.getElementBy(setYourPasswordTitle,"set your password");
    }
    public Clickable getSubmitButton() {
        return Clickable.getElementBy(submitButton,"Submit Button");
    }
    public Editable getPasswordField(){
        return Editable.getElementBy(passwordField, "Password Field");
    }
    public Editable getConfirmPasswordField(){
        return Editable.getElementBy(confirmPasswordField, "Confirm Password Field");
    }
    public Clickable getShowPasswordLink(){
        return Clickable.getElementBy(showPassword,"Show Password link");
    }
    public Clickable getSuccessMessage(){
        return Clickable.getElementBy(successMessage,"Success Message");
    }
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

