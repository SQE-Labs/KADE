package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class Homepage extends BasePage {

    // Locators
    By signOut = By.linkText("Sign out");
    By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
    By nameField = By.xpath("//input[@name='contactName']");

    public void clickSignOutButton(){
        clickBtn(signOut);
    }

    public void clickProfileLink(){
        clickBtn(profileLink);
    }
}

