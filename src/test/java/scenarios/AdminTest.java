package scenarios;

import org.automation.base.BaseTest;

import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;



public class AdminTest extends BaseTest {
    @Test(description = "To Delete Stores")
    public void ToDeleteStores() {

        KadeSession session = KadeSession.login(KadeUserAccount.Admin);
        session.getAdminPage().getDashboardButton().click();
        session.getAdminPage().getFindStoreLink().click();
        session.getAdminPage().getFilterIcon().click();
        session.getAdminPage().getStoreName().setText("My Store");
        session.getAdminPage().getApplyBtn().click();
        String ownerEmail = session.getAdminPage().getOwnweEmail().getText();
        if (ownerEmail.equals("test1114@yopmail.com")){

            List<WebElement> storeElements = getDriver().findElements(By.cssSelector(".ms-2.text-truncate"));
            int elementcount = storeElements.size();
            while (elementcount > 0) {

                session.getAdminPage().getFirstResult().clickByMouse();
                session.getAdminPage().getBlockBtn().clickbyJS();
                WebdriverWaits.sleep(2000);
                session.getAdminPage().getEditStatusTextBox().setText("Deletion of Store");
                session.getAdminPage().getUpdateStatusBtn().clickbyJS();
                WebdriverWaits.sleep(3000);
                String storename = session.getAdminPage().getStoreNameText().getText();
                session.getAdminPage().getDeleteBtn().clickbyJS();
                session.getAdminPage().getEditDeleteStoreNameBox().setText(storename);
                session.getAdminPage().getPermanentDeleteBtn().clickbyJS();

                // Delete Functionality here

                session.getAdminPage().getFilterIcon().click();
                session.getAdminPage().getStoreName().setText("My store");
                session.getAdminPage().getApplyBtn().click();

                storeElements = getDriver().findElements(By.cssSelector(".ms-2.text-truncate"));
                elementcount = storeElements.size();
            }
        }
    }
    }



