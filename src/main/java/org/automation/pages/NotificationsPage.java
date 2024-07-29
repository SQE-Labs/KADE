package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class NotificationsPage extends BasePage {

    // Locators
    By notificationIcon= By.xpath("//a[@data-bs-toggle='dropdown']");


    //PerformActions
    public void clickNotificationIcon() {
        click(notificationIcon);
    }

    public void clickNotificationByIndex(String number) {
        By notification = By.xpath("(//div[@class='list-group']/a)["+number+"]");
        click(notification);
    }
}
