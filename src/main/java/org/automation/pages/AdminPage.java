package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class AdminPage extends BasePage {
    By adminDashboardBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(2)");
    By adminTransactionBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(3)");
    By findStoreLink =By.xpath("//a[@href='/Admin/Stores']");
    By dashboardPageTitle = By.cssSelector(".header-title.mb-0");
    By filterIcon = By.cssSelector(".ps-1.pt-2>a");
    By findStoreBtn = By.cssSelector("a[href=\"/Admin/Stores\"]");
    By storeNameField = By.cssSelector("input[name=\"name\"].form-control.max-20c");
    By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
    By clickStore = By.cssSelector(".d-flex.flex-column.overflow-hidden .ms-2.text-truncate");
    By blockBtn = By.cssSelector(".fal.fa-circle.custom-check-off ");
    By statusTextBox = By.cssSelector(".form-control[maxlength=\"250\"]");
    By updateStatusBtn = By.xpath("//button[text()='Update Status']");
    By deleteBtn = By.cssSelector("button[href=\".-deleteStore-\"]");
    By deleteStoreNameField = By.cssSelector("input[name=\"name\"][required]");
    By clickPermanentDeleteBtn = By.xpath("//button[text()='Delete Permanently']");
    By clickFirstResult = By.xpath("(//span[contains(text(),'Zencode')])[1]");
    By getStoreName = By.cssSelector(" .d-flex .ms-2.text-truncate:nth-child(1)");

    public Clickable getStoreNameText() { return Clickable.getElementBy(getStoreName,"Get Store Name");}
    public Clickable getDashboardButton() {return Clickable.getElementBy(adminDashboardBtn, "Admin Dashboard button ");}
    public Clickable getTransactionButton() {return Clickable.getElementBy(adminTransactionBtn, "Admin Transaction button ");}
    public Clickable getFindStoreLink() {return Clickable.getElementBy(findStoreLink, "Find store Link ");}
    public Clickable getAdminPageTitle() {return Clickable.getElementBy(dashboardPageTitle, "Admin Page Title");}
    public Clickable getFilterIcon() {return Clickable.getElementBy(filterIcon, "Filter Icon");}
    public Clickable getFindStores() { return Clickable.getElementBy(findStoreBtn);}
    public Editable getStoreName(){return Editable.getElementBy(storeNameField);}
    public Clickable getApplyBtn() {WebdriverWaits.waitForElementUntilVisible(applyBtn,100); return Clickable.getElementBy(applyBtn);}
    public Clickable getStoreBtn() {WebdriverWaits.waitForElementUntilVisible(clickStore,100); return Clickable.getElementBy(clickStore);}
    public Clickable getBlockBtn(){WebdriverWaits.waitForElementUntilVisible(blockBtn,100); return Clickable.getElementBy(blockBtn);}
    public Editable getEditStatusTextBox(){ WebdriverWaits.waitForElementUntilVisible(statusTextBox,200); return Editable.getElementBy(statusTextBox);}
    public Clickable getUpdateStatusBtn(){return Clickable.getElementBy(updateStatusBtn);}
    public Clickable getDeleteBtn(){ return Clickable.getElementBy(deleteBtn);}
    public Editable getEditDeleteStoreNameBox(){ return Editable.getElementBy(deleteStoreNameField);}
    public Clickable getPermanentDeleteBtn(){return Clickable.getElementBy(clickPermanentDeleteBtn);}
    public Clickable getFirstResult(){ return Clickable.getElementBy(clickFirstResult, "Click First Search Result");}


    public void selectedStoreDeleted(String storeName1) throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Admin);
        session.getAdminPage().getFindStoreLink().click();
        session.getAdminPage().getFilterIcon().click();
        session.getAdminPage().getStoreName().setText(storeName1);
        System.out.println(storeName1);
        session.getAdminPage().getApplyBtn().click();
        session.getAdminPage().getStoreBtn().click();
        session.getAdminPage().getBlockBtn().clickbyJS();
        Thread.sleep(1000);
        session.getAdminPage().getEditStatusTextBox().setText("This needs to delete");
        session.getAdminPage().getUpdateStatusBtn().clickbyJS();
        session.getAdminPage().getDeleteBtn().clickbyJS();
        session.getAdminPage().getEditDeleteStoreNameBox().setText(storeName1);
        session.getAdminPage().getPermanentDeleteBtn().clickbyJS();
    }
}

