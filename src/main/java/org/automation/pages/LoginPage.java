package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    // Locators
    public By userNameField = By.cssSelector("[name='userName']");
    By passwordField =By.cssSelector("[name='passWord']");
    By forgotPasswordLink = By.linkText("Forgot password?");
    By signInButton = By.xpath("//div[@class='text-center ']/button[text()='Sign in']");
    By signUpLink = By.linkText("Sign up");
    By validation = By.xpath("//p[@class='alert-content']");
    By termsOfUse = By.linkText("Terms Of Use");
    By popupTitle = By.xpath("//h5[normalize-space()='New Account']");
    // Methods
    public Editable getUserNameTextbox(){
        return Editable.getElementBy(userNameField,"User Name Textbox");
    }

    public Editable getPasswordTextbox(){
        return Editable.getElementBy(passwordField,"Password Field");
    }

    public Clickable getSignInButton(){
       WebdriverWaits.sleep(3000);
        return Clickable.getElementBy(signInButton,"Sign In Button");
    }

    public void performSignIn(String userName, String password) {
    	sendKeys_withClear(userNameField, userName);
    	sendKeys_withClear(passwordField,password);
        getSignInButton().click();
        WebdriverWaits.sleep(3000);
    }

    public Clickable getForgotPasswordLink(){
        return Clickable.getElementBy(forgotPasswordLink,"Forgot password link");
    }

    public Clickable getSignUpLink(){
       return Clickable.getElementBy(signUpLink,"Signup Link");
    }
  
    public Clickable getValidationMessage() {
    	return Clickable.getElementBy(validation,"Validation Message");
    }


    public Clickable getTermOfUseButton(){
        return Clickable.getElementBy(termsOfUse,"Term of Use Button");
    }

    public Clickable getNewAccountPopupTitle(){
        return Clickable.getElementBy(popupTitle, " New Account Popup title");
    }
}