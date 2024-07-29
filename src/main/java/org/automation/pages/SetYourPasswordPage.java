package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SetYourPasswordPage extends BasePage {

    // Locators
    By passwordField = By.xpath("//input[@name='password']");
    By confirmPasswordField = By.xpath("//input[@name='confirmPassword']");
    By submitButton = By.xpath("//button[@class='btn-lg btn btn-primary']");

    // Methods

    public boolean checkPresenceOfPasswordField(){
        return isElementPresent(passwordField,"Password");
    }

    public boolean checkPresenceOfConfirmPasswordField(){
        return isElementPresent(confirmPasswordField,"Confirm Password");
    }

    public boolean checkPresenceSubmitButton(){
        return isElementPresent(submitButton,"Submit");
    }

    public void setPasswordField(String setPassword){
        sendKeys(passwordField,setPassword);
    }

    public void setConfirmPasswordField(String setConfirmPassword){
        sendKeys(confirmPasswordField,setConfirmPassword);
    }

    public void clickSubmitButton(){
        clickBtn(submitButton);
    }

}
