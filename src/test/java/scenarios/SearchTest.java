package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class SearchTest extends BaseTest {
    @Test(description = "Verify that 'Search' popup appears after clicking on 'Search' tab, on Left Panel.")
    public void verifySearchPopupAppearsAfterClickingSearchTab() throws IOException, UnsupportedFlavorException {
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);
        //TestCase 1
        //Click on Search Tab
        session.getSidePannel().getSearchTab().click();
        //Verify Search Popup appears
        Assertions.assertTrue(session.getSearchPage().SearchPopup().isDisplayed());

        //TestCase 2
        //Verify Search Label
        String actualSearchLabel = session.getSearchPage().getSearchLabel().getText();
        String expectedSearchLabel = "Search by reference Id, phone or email";
        Assertions.assertEquals(expectedSearchLabel, actualSearchLabel);

    }
    @Test(description = "Verify that 'bill or transaction' popup appears after searching with a reference ID in 'Search by Reference ID, Phone, or Email' field.")
    public void verifyBillOrTransactionAppearsAfterSearchingByReferenceId() throws IOException, UnsupportedFlavorException {

        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);
        //Test case 3
        //Open Bill Page
        session.getSidePannel().getBillButton().click();
        //Click On ReferenceId
        session.getSearchPage().getSearchBillReferenceId().clickByMouse();
        WebdriverWaits.waitForElementUntilVisible(session.getSearchPage().CopyReferenceId,5);
        //Copy ReferenceId
        session.getSearchPage().getCopyReferenceId().clickByMouse();
        //Close Bill Popup
        session.getSearchPage().getCloseBillButton().click();
        //Click on Search Tab
        session.getSidePannel().getSearchTab().click();
        //Click on Search Box
        session.getSearchPage().getClickSearchBox().click();
        //Get copied text from clipboard
        String copiedText = session.getSearchPage().getClipboardText();
        WebElement Searchbox = session.getSearchPage().getClickSearchBox().getElement(session.getSearchPage().ClickSearchBox);
        //Paste Copied Text
        Searchbox.sendKeys(copiedText);
        //Click on Search Icon
        session.getSearchPage().getClickSearchIcon().click();
        //Get BillId from popup
        session.getSearchPage().getBillid().click();
        String CopiedBillId = session.getSearchPage().getClipboardText();
        Assertions.assertEquals(copiedText, CopiedBillId);
        //Close Bill Popup
        session.getSearchPage().getCloseBillButton().click();
        //Click on Transaction Tab
        session.getSidePannel().getTransactionButton().click();
        //Click On ReferenceId
        System.out.println(session.getSearchPage().getSearchTransReferenceId().click());
        //Click on Search Tab
        session.getSidePannel().getSearchTab().click();
        //Click on Search Box
        session.getSearchPage().getClickSearchBox().click();
        //Get copied text from clipboard
        String copiedTransId = session.getSearchPage().getClipboardText();
        WebElement Searchbox2 = session.getSearchPage().getClickSearchBox().getElement(session.getSearchPage().ClickSearchBox);
        //Paste Copied Text
        Searchbox2.sendKeys(copiedTransId);
        //Click on Search Icon
        session.getSearchPage().getClickSearchIcon().click();
        //Get Transaction Id
        session.getSearchPage().getTransactionId().click();
        String CopyActualTransactionId = session.getSearchPage().getClipboardText();
        Assertions.assertEquals(CopyActualTransactionId,copiedTransId);

    }
}
