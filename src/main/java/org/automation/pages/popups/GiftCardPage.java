package org.automation.pages.popups;

import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class GiftCardPage extends BasePage {

    //Locators
    By GiftCardLabel = By.className("mb-0");
    By NoGiftCardMsg = By.xpath("//div[@class = ' card']/div/p");



    public GiftCardPage()
    {
        super();
    }

    //To get label
    public Editable getGiftCardLabel() { return Editable.getElementBy(GiftCardLabel, "Gift Card Label"); }

    //To get No Gift Card Message
    public Editable getNoGiftCardMsg() { return Editable.getElementBy(NoGiftCardMsg, "No Gift Card Msg"); }


}
