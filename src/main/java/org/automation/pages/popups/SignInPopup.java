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
    By signInPhoneField = By.xpath("//input[@name='userName' and @data-f-type='phone']");
    By googleIcon = By.cssSelector("[value='Google']");
    By appleIcon = By.cssSelector("[aria-label='Sign in with Apple']");
    By pleaseReviewValidation = By.cssSelector(".alert-content");
    By changeLink = By.cssSelector("[class='btn-link btn p-0 -change-']");
    By iDontKnowPassword = By.cssSelector(".mx-3.-forgotpwd-");
    By signInPasswordField = By.cssSelector("[name='password']");
    By signInButton = By.xpath("(//button[@class='btn btn-primary'])[4]");
    By showPassowrd = By.xpath("//span[text()='Show password']");


    public Clickable getSignInPopupTitle() {
        return Clickable.getElementBy(signInTitle, "Sign In Button");
    }

    public Clickable getPhoneLabelofSignIn() {
        return Clickable.getElementBy(phoneNumberfieldLabel, "Field Label");
    }
    public Editable getPhoneFieldOfSignIn() {
        return Editable.getElementBy(signInPhoneField, "Phone Field ");
    }
    public Clickable getPhoneField() {
        return Clickable.getElementBy(signInPhoneField, "Phone Field ");
    }
    public Clickable getSignInContinue() {
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
    public Editable getSignInPasswordField() {
        return Editable.getElementBy(signInPasswordField, "Sign In Password Field");
    }

    public Clickable getSignInButton() {
        return Clickable.getElementBy(signInButton, "Sign In Button");
    }
    public Clickable getShowPassword() {
        return Clickable.getElementBy(showPassowrd, "Show Password");
    }


}
