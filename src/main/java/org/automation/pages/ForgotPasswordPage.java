package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends BasePage {

    // Locators
    By pageHeading = By.xpath("//h1[text()='Forgot password']");
    By emailPhoneTextFieldLabel = By.xpath("//label[text()='Enter your email or phone number you signed up with']");
    By emailPhoneTextField = By.name("phone_email");
    By continueButton = By.xpath("//button[text()='Continue']");
    By signInLinkLabel = By.xpath("//p[contains(text(),'Already have an account?')]");
    By signInLink = By.linkText("Sign-in");

    //Methods

    /**
     * Method for check presence of Forgot Password Page heading
     */
    public boolean checkPresenceOfHeading(){
        return isElementPresent(pageHeading,"Forget Password Heading");
    }

    /**
     * Method for check presence of Email or Phone Text field label
     */
    public void checkPresenceOfEmailPhoneTextFieldLabel() {
        isElementPresent(emailPhoneTextFieldLabel,"Phone Email Text field Label");
    }

    /**
     * Method for check presence of Email or Phone Text field
     */
    public void checkPresenceOfEmailPhoneTextField() {
        isElementPresent(emailPhoneTextField,"Email Phone Text field");
    }

    /**
     * Method for check presence of 'Continue' button
     */
    public void checkPresenceOfContinueButton() {
        isElementPresent(continueButton,"Continue Button");
    }

    /**
     * Method for check presence of 'Sign-in' Label
     */
    public void checkPresenceOfSignInLinkLabel() {
        isElementPresent(signInLinkLabel,"Sign-in Label");
    }

    /**
     * Method for check presence of 'Sign-in' link
     */
    public void checkPresenceOfSignInLink() {
        isElementPresent(signInLink,"Sign-in Link");
    }

}
