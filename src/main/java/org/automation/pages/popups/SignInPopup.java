package org.automation.pages.popups;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class SignInPopup extends BasePage {
    By signInTitle = By.xpath("//h5[text()='Sign-in']");
    By switchToEmailLink = By.xpath("//button[text()='switch to email']");
    By continueButton = By.xpath("//div[@class='text-center mt-3 px-2 mb-3']/button[text()='Continue']");
    By phoneNumberfieldLabel = By.xpath("//div[@class='-phone-div-   mb-2']/label");
    By phoneField = By.xpath("//input[@name='userName' and @data-f-type='phone']");
    By googleIcon = By.cssSelector("[value='Google']");
    By appleIcon = By.cssSelector("[aria-label='Sign in with Apple']");
    By pleaseReviewValidation = By.xpath("//p[text()='Please review the highlighted field(s)']");
    By changeLink = By.cssSelector("[class='btn-link btn p-0 -change-']");
    By iDontKnowPassword = By.cssSelector(".mx-3.-forgotpwd-");
    By passwordField = By.cssSelector("[name='password']");
    By signInButton = By.xpath("(//button[@class='btn btn-primary'])[4]");
    By showPassword = By.xpath("//span[text()='Show password']");
    By informationMessage = By.cssSelector(".fw-bold.fst-italic");
    By securityCodeLabel = By.cssSelector("label[class='mb-2']");
    By newPasswordLabel= By.xpath("//label[text()='New password']");
    By securityCodeField = By.xpath("(//input[@name='otp'])[2]");
    By newPasswordField = By.xpath("//input[@name='password']");
    By emailField = By.xpath("//input[@name='userName' and @type='email']");


    public Clickable getSignInPopupTitle() {
        return Clickable.getElementBy(signInTitle, "Sign In Button");
    }

    public Clickable getPhoneLabel() {
        return Clickable.getElementBy(phoneNumberfieldLabel, "Field Label");
    }
    public Editable getPhoneNumberField() {
        return Editable.getElementBy(phoneField, "Phone Field ");
    }
    public Clickable getPhoneField() {
        return Clickable.getElementBy(phoneField, "Phone Field ");
    }
    public Clickable getContinueButton() {
        return Clickable.getElementBy(continueButton, "Sign In Button");
    }
    public Clickable getSwitchToEmailLink() {
        return Clickable.getElementBy(switchToEmailLink, "Switch to Email Link");
    }
    public Clickable getSignInWithGoogleImage() {
        return Clickable.getElementBy(googleIcon, "Sign In with Google Icon");
    }
    public Clickable getSignInWithAppleImage() {
        return Clickable.getElementBy(appleIcon, "Sign In with Apple Icon");
    }
    public Clickable getPleaseReviewValidation() {
        return Clickable.getElementBy(pleaseReviewValidation, "Please review validation message");
    }
    public Clickable getChangeLink() {
        return Clickable.getElementBy(changeLink, "change Link");
    }
    public Clickable getIdontKnowPasswordLink() {
        return Clickable.getElementBy(iDontKnowPassword, "i Dont know password Link");
    }
    public Editable getPasswordField() {
        return Editable.getElementBy(passwordField, "Sign In Password Field");
    }

    public Clickable getSignInButton() {
        return Clickable.getElementBy(signInButton, "Sign In Button");
    }
    public Clickable getShowPassword() {
        return Clickable.getElementBy(showPassword, "Show Password");
    }
    public Clickable getInformationMessage() {
        return Clickable.getElementBy(informationMessage, "A security code was sent to");
    }
    public Clickable getSecurityCodeLabel() {
        return Clickable.getElementBy(securityCodeLabel, "Security Code Field Label");
    }
    public Clickable getNewPasswordLabel() {
        return Clickable.getElementBy(newPasswordLabel, "New Password Field Label");
    }
    public Editable getSecurityCodeField() {
        return Editable.getElementBy(securityCodeField, "Security Code Field");
    }
    public Editable getNewPasswordField() {
        return Editable.getElementBy(newPasswordField, "New Password Field");
    }
    public Editable getEmailField() {
        return Editable.getElementBy(emailField, "Email Field");
    }




}
