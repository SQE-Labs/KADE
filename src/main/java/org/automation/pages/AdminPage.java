package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class AdminPage extends BasePage {
    By adminDashboardBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(2)");
    By adminTransactionBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(3)");
    By findStoreLink =By.xpath("//a[@href='/Admin/Stores']");
    By dashboardPageTitle = By.cssSelector(".header-title.mb-0");
    By filterIcon = By.cssSelector(".a.collapsed[href=\"#_2NQ\"]");
    By findStoreBtn = By.cssSelector("a[href=\"/Admin/Stores\"]");
    By storeNameField = By.cssSelector("input[name=\"name\"].form-control.max-20c");
    By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
    By clickStore = By.cssSelector(".d-flex.flex-column.overflow-hidden .ms-2.text-truncate");
    By blockBtn = By.cssSelector(".fal.fa-circle.custom-check-off ");
    By statusTextBox = By.cssSelector(".form-control[maxlength=\"250\"]");
    By updateStatusBtn = By.cssSelector("#_3SA");
    By deleteBtn = By.cssSelector("button[href=\".-deleteStore-\"]");
    By deleteStoreNameField = By.cssSelector("input[name=\"name\"][required]");
    By clickPermanentDeleteBtn = By.cssSelector("button#_48E.display-none.btn.btn-outline-danger[type=\"submit\"]");

    public Clickable getDashboardButton() {return Clickable.getElementBy(adminDashboardBtn, "Admin Dashboard button ");}
    public Clickable getTransactionButton() {return Clickable.getElementBy(adminTransactionBtn, "Admin Transaction button ");}
    public Clickable getFindStoreLink() {return Clickable.getElementBy(findStoreLink, "Find store Link ");}
    public Clickable getAdminPageTitle() {return Clickable.getElementBy(dashboardPageTitle, "Admin Page Title");}
    public Clickable getFilterIcon() {return Clickable.getElementBy(filterIcon, "Filter Icon");}
    public Clickable clickFindStores() { return Clickable.getElementBy(findStoreBtn);}
    public Editable sendStoreName(){return Editable.getElementBy(storeNameField);}
    public Clickable clickApplyBtn() {WebdriverWaits.waitForElementUntilVisible(applyBtn,100); return Clickable.getElementBy(applyBtn);}
    public Clickable clickStoreBtn() {WebdriverWaits.waitForElementUntilVisible(clickStore,100); return Clickable.getElementBy(clickStore);}
    public Clickable clickBlockBtn(){WebdriverWaits.waitForElementUntilVisible(blockBtn,100); return Clickable.getElementBy(blockBtn);}
    public Editable editStatusTextBox(){ WebdriverWaits.waitForElementUntilVisible(statusTextBox,100); return Editable.getElementBy(statusTextBox);}
    public Clickable clickUpdateStatusBtn(){WebdriverWaits.waitForElementUntilVisible(updateStatusBtn,100); return Clickable.getElementBy(updateStatusBtn);}
    public Clickable clickDeleteBtn(){WebdriverWaits.waitForElementUntilVisible(deleteBtn,100); return Clickable.getElementBy(deleteBtn);}
    public Editable editDeleteStoreNameBox(){ WebdriverWaits.waitForElementUntilVisible(deleteStoreNameField,100); return Editable.getElementBy(deleteStoreNameField);}
    public Clickable clickPermanentDeleteBtn(){WebdriverWaits.waitForElementUntilVisible(clickPermanentDeleteBtn,100); return Clickable.getElementBy(clickPermanentDeleteBtn);}
}

