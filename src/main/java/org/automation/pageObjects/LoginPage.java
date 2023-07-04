package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    // Locators
    By userNameField = By.name("userName");
    By passwordField = By.name("passWord");
    By forgotPasswordLink = By.linkText("Forgot password?");
    By signInButton = By.xpath("//div[@class='text-center ']/button[text()='Sign in']");
    By signUpLink = By.linkText("Sign up");
    By validation = By.xpath("//p[@class='alert-content']");
    By termsOfUse = By.linkText("Terms Of Use");
    // Methods
    /**
     * Method to Enter UserName
     * @param userNameText need to be set
     */
    public void enterUsername(String userNameText) {

        sendKeys(userNameField, userNameText);
    }

    /**
     * Method to Enter Password
     * @param passNameText need to be set
     */
    public void enterPassword(String passNameText) {
        sendKeys(passwordField, passNameText);
    }

    /**
     * Method to Click 'Sign in' Button
     */
    public void clickSignInButton() {
        clickBtn(signInButton);
    }

    /**
     * Method to perform Sign In
     * @param userName need to be set
     * @param password need to be set
     */
    public void performSignIn(String userName, String password) {
    	sendKeys_withClear(userNameField, userName);
        sendKeys_withClear(passwordField,password);
        clickSignInButton();
    }

    /**
     * Method to Click 'Forgot Password' link
     */
    public void clickForgotPasswordLink(){
        clickBtn(forgotPasswordLink);
    }


    public void clickSignUpLink(){
        clickBtn(signUpLink);
    }


    public String getAttribute() {
    	return getAttributevalue(userNameField, "class");
    }
  
    public String getValidationMessage() {
    	return getText_custom(validation);
    }
    	
    public void clickOnTermsOfUse() {
    	clickBtn(termsOfUse);
    }
}