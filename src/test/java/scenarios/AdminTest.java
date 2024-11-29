package scenarios;

import org.automation.base.BaseTest;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.data.StoreAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.BillPage;
import org.automation.pages.SidePannel;
import org.automation.pages.TransactionsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.*;



public class AdminTest extends BaseTest {
    @Test(description = "To Delete Stores")
    public void ToDeleteStores() {

        KadeSession session = KadeSession.login(KadeUserAccount.Admin);
        session.getAdminPage().getDashboardButton().click();
        session.getAdminPage().getFindStoreLink().click();
        session.getAdminPage().getFilterIcon().click();
        session.getAdminPage().getStoreName().setText("Zencode");
        session.getAdminPage().getApplyBtn().click();
        List<WebElement> storeElements = getDriver().findElements(By.xpath("//span[contains(text(),'Zencode')]"));
        int elementcount = storeElements.size();
        while(elementcount > 0){
            session.getAdminPage().getFirstResult().click();
            session.getAdminPage().getBlockBtn().clickbyJS();
            WebdriverWaits.sleep(2000);
            session.getAdminPage().getEditStatusTextBox().setText("Deletion of Store");
            session.getAdminPage().getUpdateStatusBtn().clickbyJS();
            WebdriverWaits.sleep(3000);
            String storename= session.getAdminPage().getStoreNameText().getText();
            session.getAdminPage().getDeleteBtn().clickbyJS();
            session.getAdminPage().getEditDeleteStoreNameBox().setText(storename);
            session.getAdminPage().getPermanentDeleteBtn().clickbyJS();

            // Delete Functionality here

            session.getAdminPage().getFilterIcon().click();
            session.getAdminPage().getStoreName().setText("Zencode");
            session.getAdminPage().getApplyBtn().click();

            storeElements = getDriver().findElements(By.xpath("//span[contains(text(),'Zencode')]"));
            elementcount = storeElements.size();
        }
    }


}
