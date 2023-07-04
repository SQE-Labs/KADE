package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class TermsOfUseAgreementPage extends BasePage {

    //Locators
    By termsOfUseLink = By.linkText("Terms Of Use");
    By userAgreementHeading = By.xpath("//h2[text()='User Agreement']");

    //Methods

    /**
     * Method for click 'Terms of Use' link
     */
    public void clickTermsOfUseLink(){
        clickBtn(termsOfUseLink);
    }

    /**
     * Method for check presence of 'User Agreement' Sub heading
     */
    public void checkPresenceOfSubHeading(){
        isElementPresent(userAgreementHeading,"");
    }


}
