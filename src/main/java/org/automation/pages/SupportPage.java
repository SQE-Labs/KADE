package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SupportPage extends BasePage {

    //locators

    By crossIcon = By.xpath("//button[@class='btn ']");

    //Methods

    /**
     * Method for click Cross icon
     */
    public void clickCrossIcon(){
        clickBtn(crossIcon);
    }

    /**
     * Method to verify Cross icon
     */
    public Boolean checkPresenceOfCrossIcon(){
        return isElementPresent(crossIcon, "Cross Icon");
    }
}
