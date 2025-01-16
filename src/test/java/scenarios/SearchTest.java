package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.testng.annotations.Test;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class SearchTest extends BaseTest {
    @Test(description = " SP01, SP02 : Verify that 'Search' popup appears after clicking on 'Search' tab, on Left Panel.")
    public void verifySearchPopupAppearsAfterClickingSearchTab() throws IOException, UnsupportedFlavorException {

        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);


        //Click on Search Tab & Verify Search Popup appears
        session.getSidePannel().getSearchTab().click();
        Assertions.assertTrue(session.getSearchPage().SearchPopup().isDisplayed());


        //Verify Search Label
        String actualSearchLabel = session.getSearchPage().getSearchLabel().getText();
        String expectedSearchLabel = "Search by reference Id, phone or email";
        Assertions.assertEquals(expectedSearchLabel, actualSearchLabel);

    }
    @Test(description = " SP03 : Verify that 'bill or transaction' popup appears after searching with a reference ID in 'Search by Reference ID, Phone, or Email' field.")
    public void verifyBillOrTransactionAppearsAfterSearchingByReferenceId() throws Exception {

        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);
        //Calling method to perform the testcase
        session.getSearchPage().performSearchAndVerify("Bills");
        session.getSearchPage().performSearchAndVerify("Transactions");


    }

    @Test(description = " SP04, SP05 : Verify that user is directed to specific cutomer's page using phone number")
    public void verifyUserDirectedToCustomerPageUsingPhoneNumber()
    {

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


        //Click on Search Tab & enter random Reference ID in Search Box
        session.getSidePannel().getSearchTab().click();
        session.getSearchPage().getClickSearchBox().click();
        String RandomReferenceID = RandomGenerator.requiredCharacters(10);
        session.getSearchPage().getEditableClickSearchBox().setText(RandomReferenceID);
        session.getSearchPage().getClickSearchIcon().click();

        //Compare Validation Message
        String ReferenceValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(ReferenceValidation, Constants.expectedSearchValidation);

        //Click on Search Tab & enter random Mobile number in Search Box
        session.getSearchPage().getClickSearchBox().sendkeysClear(session.getSearchPage().ClickSearchBox,RandomGenerator.requiredNumber(10));
        String PhoneValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(PhoneValidation,Constants.expectedSearchValidation);

        //Click on Search Tab & Enter EmailId
        session.getSearchPage().getClickSearchBox().sendkeysClear(session.getSearchPage().ClickSearchBox,RandomGenerator.generateRandomEmail());
        String EmailValidation = session.getSearchPage().getReferenceValidation().getText();
        Assertions.assertEquals(EmailValidation,Constants.expectedSearchValidation);


    }
}
