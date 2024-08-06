package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class NotificationsPage extends BasePage {

    // Locators
    By notificationIcon= By.xpath("//a[@data-bs-toggle='dropdown']");
    By firstNotification = By.xpath("(//div[@class='list-group']/a)['1']");

    //PerformActions
    public Clickable getNotificationIcon(){
        return Clickable.getElementBy(notificationIcon,"Notification Icon");
    }

    public Clickable getFirstNotification() {
        return Clickable.getElementBy(firstNotification,"First Notification");
    }
}
