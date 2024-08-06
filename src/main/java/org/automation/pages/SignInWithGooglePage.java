package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SignInWithGooglePage extends BasePage {

    //Locators
    By signInWithGoogleIcon = By.xpath("//span[@class='google-logo me-2']");
    By signInToContinueToKadeButton = By.xpath("//button[text()='Kade']");
    By emailField = By.id("identifierId");
    By nextButton = By.xpath("//span[contains(text(),'Next')]");
    By passwordField = By.xpath("//input[@name='Passwd']");



    //Methods

    public void clickSignInWithGoogleIcon(){
        clickBtn(signInWithGoogleIcon);
    }

    public boolean checkPresenceOfKadeButton(){
        return isElementPresent(signInToContinueToKadeButton,"Kade Button");
    }

    public void enterEmailOrPhone(String EmailOrPhone){
    sendKeys(emailField,"bhardwajaarju7833@gmail.com");
    }

    public void clickNextButton(){
        clickBtn(nextButton);
    }

    public void enterPassword(String Password){
        sendKeys(passwordField,"246%*#aBc");
    }



}
