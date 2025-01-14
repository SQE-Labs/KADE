package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
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
        //Click on Search Tab & Verify Search Popup appears
        session.getSidePannel().getSearchTab().click();
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
        //Open Bill Page & Click on Reference ID
        session.getSidePannel().getBillButton().click();
        session.getSearchPage().getSearchBillReferenceId().clickByMouse();
        WebdriverWaits.waitForElementUntilVisible(session.getSearchPage().CopyReferenceId,5);

        //Copy ReferenceId & close Bill Popup
        session.getSearchPage().getCopyReferenceId().clickByMouse();
        session.getSearchPage().getCloseBillButton().click();

        //Click on Search Tab & Search Box
        session.getSidePannel().getSearchTab().click();
        session.getSearchPage().getClickSearchBox().click();

        //Get copied text from clipboard
        String copiedText = session.getSearchPage().getClipboardText();
        WebElement Searchbox = session.getSearchPage().getClickSearchBox().getElement(session.getSearchPage().ClickSearchBox);

        //Paste Copied Text & Click Search Icon
        Searchbox.sendKeys(copiedText);
        session.getSearchPage().getClickSearchIcon().click();

        //Get BillId from popup
        session.getSearchPage().getBillid().click();
        String CopiedBillId = session.getSearchPage().getClipboardText();
        Assertions.assertEquals(copiedText, CopiedBillId);

        //Close Bill Popup
        session.getSearchPage().getCloseBillButton().click();

        //Click on Transaction Tab and on Reference ID
        session.getSidePannel().getTransactionButton().click();
        System.out.println(session.getSearchPage().getSearchTransReferenceId().click());

        //Click on Search Tab & Search Box
        session.getSidePannel().getSearchTab().click();
        session.getSearchPage().getClickSearchBox().click();

        //Get copied text from clipboard
        String copiedTransId = session.getSearchPage().getClipboardText();
        WebElement Searchbox2 = session.getSearchPage().getClickSearchBox().getElement(session.getSearchPage().ClickSearchBox);

        //Paste Copied Text & Click on Search Icon
        Searchbox2.sendKeys(copiedTransId);
        session.getSearchPage().getClickSearchIcon().click();

        //Get Transaction Id
        session.getSearchPage().getTransactionId().click();
        String CopyActualTransactionId = session.getSearchPage().getClipboardText();
        Assertions.assertEquals(CopyActualTransactionId,copiedTransId);

    }

    @Test(description = "Verify that user is directed to specific cutomer's page using phone number")
    public void verifyUserDirectedToCustomerPageUsingPhoneNumber()
    {
        //TestCase 4
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);
        //Click On Bill Tab
        session.getSidePannel().getBillButton().click();

        //Get User Email
        session.getSearchPage().getUserProfile().click();
        String Useremail = session.getSearchPage().getUseremail().getText();

        //Click on Search Tab & enter User email in Search Box
        session.getSidePannel().getSearchTab().click();
        session.getSearchPage().getClickSearchBox().click();
        session.getSearchPage().getEditableClickSearchBox().setText(Useremail);
        session.getSearchPage().getClickSearchIcon().click();

        //Get the email displayed after clicking Search Icon and Compare
        String VerifyUserEmail = session.getSearchPage().getVerifyUserEmail().getText();
        Assertions.assertEquals(VerifyUserEmail,Useremail);

        //Test Case 5

        //Click on Search Tab & enter random Reference ID in Search Box
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getSearchTab().click();
        session.getSearchPage().getClickSearchBox().click();
        String RandomReferenceID = RandomGenerator.requiredCharacters(10);
        session.getSearchPage().getEditableClickSearchBox().setText(RandomReferenceID);
        session.getSearchPage().getClickSearchIcon().click();

        //Compare Validation Message
        String ReferenceValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(ReferenceValidation,"Nothing found!");

        //Click on Search Tab & enter random Mobile number in Search Box
        session.getSearchPage().getClickSearchBox().sendkeysClear(session.getSearchPage().ClickSearchBox,RandomGenerator.requiredNumber(10));
        String PhoneValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(PhoneValidation,"Nothing found!");

        //Click on Search Tab & Enter EmailId
        session.getSearchPage().getClickSearchBox().sendkeysClear(session.getSearchPage().ClickSearchBox,RandomGenerator.generateRandomEmail());
        String EmailValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(EmailValidation,"Nothing found!");


    }
}
