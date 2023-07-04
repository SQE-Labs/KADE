package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class PrivacyPolicyPage extends BasePage {

    //Locators
    By privacyPolicyLink = By.linkText("Privacy Policy");
    By ourCommitmentToPrivacyHeading = By.xpath("//div/strong[text()='OUR COMMITMENT TO PRIVACY']");
    By kadePayLink = By.linkText("info@KadePay.com");


    //Methods

    /**
     * Method for click 'Privacy Policy' link
     */
    public void clickPrivacyPolicyLink(){
        clickBtn(privacyPolicyLink);
    }

    /**
     * Method for check presence of 'OUR COMMITMENT TO PRIVACY ' Heading
     */
    public void checkPresenceOfOurCommitmentToPrivacyHeading(){
        isElementPresent(ourCommitmentToPrivacyHeading,"OUR COMMITMENT TO PRIVACY ");
    }

    /**
     * Method for check presence of kade pay link -'info@KadePay.com'
     */
    public void checkPresenceOfKadePayLink(){
        isElementPresent( kadePayLink,"Kade Pay Link");
    }

}

