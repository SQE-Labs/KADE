package org.automation.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.automation.base.BasePage;

public class AdminPage extends BasePage {
By adminDashboardBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(2)");
By adminTransactionBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(3)");
By findStoreLink =By.xpath("//a[@href='/Admin/Stores']");
By dashboardPageTitle = By.cssSelector(".header-title.mb-0");
By filterIcon = By.cssSelector(".ps-1.pt-2>a");

    public Clickable getDashboardButton() {return Clickable.getElementBy(adminDashboardBtn, "Admin Dashboard button ");}
    public Clickable getTransactionButton() {return Clickable.getElementBy(adminTransactionBtn, "Admin Transaction button ");}
    public Clickable getFindStoreLink() {return Clickable.getElementBy(findStoreLink, "Find store Link ");}
    public Clickable getAdminPageTitle() {return Clickable.getElementBy(dashboardPageTitle, "Admin Page Title");}
    public Clickable getFilterIcon() {return Clickable.getElementBy(filterIcon, "Filter Icon");}

}
