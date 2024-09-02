package org.automation.pages;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

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

     //Enter email or phone in 'Email or Phone' field
    public Editable enterEmailOrPhone(){
        return Editable.getElementBy(emailOrPhoneField,"Email and Phone Fields");
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


}

