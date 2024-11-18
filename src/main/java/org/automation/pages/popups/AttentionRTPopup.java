package org.automation.pages.popups;
import org.automation.base.BasePage;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class AttentionRTPopup extends BasePage {
    By attentionCrossIcon = By.cssSelector("div.modal-content .btn-close");
    By attentionTitle = By.xpath("//H4[text()='Attention!']");


    public Clickable getAttentionPopupTitle() {
        return Clickable.getElementBy(attentionTitle,"AttentionTitle");
    }
    public Clickable getAttentionCrossIcon() {
        return Clickable.getElementBy(attentionCrossIcon,"Attention Cross Icon");
    }


}
