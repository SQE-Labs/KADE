package org.automation.pages.popups;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    //Locators
    By SearchRow = By.xpath("//a[@class = 'sidebar-link']");
    By SearchPopup = By.cssSelector(".modal-content");



    public SearchPage()
    {
        super();
    }

    public Clickable SearchPopup() {
        return Clickable.getElementBy(SearchPopup,"Find or Add Customer");
    }



}
