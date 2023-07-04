package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class CreateNewAccountPage extends BasePage {

    // Locators
    By appLogoNameHeading = By.xpath("//span[@class='app-name-logo']");
    By createNewAccountHeading = By.xpath("//div[@class='card-header text-center']");
    By emailOrPhoneLabel = By.xpath("//input[@name='phone_email']");
    By emailOrPhoneField = By.xpath("//input[@name='phone_email']");
    By signUpButton = By.xpath("//button[@class='btn-lg btn btn-primary']");
    By alreadyHaveAnAccountLabel = By.xpath("//p[contains(text(),'Already have an account?')]");
    By signInLink = By.xpath("//a[@class='ms-2']");

    // Methods
    /**
     * Method for check presence of 'Kade' logo
     * @return 'TRUE'
     */
    public boolean checkPresenceOfappLogoNameHeading() {
       return isElementPresent(appLogoNameHeading,"Kade");
    }

    /**
     * Method for check presence of 'Create A New Account' heading
     * @return 'TRUE'
     */
    public boolean checkPresenceOfCreateNewAccountHeading(){
        return isElementPresent(createNewAccountHeading,"Create New Account");
    }

    /**
     * Method for check Presence of 'Email Or Phone' field
     * @return 'True'
     */
    public boolean checkPresenceOfEmailOrPhoneLabel(){
        return isElementPresent(emailOrPhoneLabel,"");
    }

    /**
     *  Method for check presence of 'Already have an account? Sign-in' label
     * @return 'True'
     */

    public boolean checkPresenceOfAlreadyHaveAnAccountLabel(){
        return isElementPresent(alreadyHaveAnAccountLabel,"Already have an account? Sign-in");
    }

    /**
     * Method for check presence of 'Email or Phone' field
     * @return 'True'
     */
    public boolean checkPresenceOfEmailOrPhoneField(){
       return isElementPresent(emailOrPhoneField,"Email or Phone field");
    }

    /**
     * Method for enter email or phone in 'Email or Phone' field
     * @param emailOrPhoneText
     */
    public void enterEmailOrPhone(String emailOrPhoneText){
        sendKeys(emailOrPhoneField,emailOrPhoneText);
    }

    /**
     * Method for check presence of 'Sign-in' link
     * @return 'True'
     */
    public boolean checkPresenceOfSignInLink(){
        return isElementPresent(signInLink,"Sign-in");
    }

    /**
     * Method for check prsence of 'Sign up' button
     * @return 'True'
     */
    public boolean checkPresenceOfSignUpButton(){
       return isElementPresent(signUpButton,"Sign up");
    }

    /**
     * Method for click 'Sign up' button
     */
    public void clickSignUpButton() throws InterruptedException {
        clickBtn(signUpButton);
    }




}



