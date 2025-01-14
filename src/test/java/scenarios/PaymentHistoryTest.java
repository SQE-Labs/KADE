package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class PaymentHistoryTest extends BaseTest {
    @Test(description = "Verify that user get directed to 'Payment History' page, after clicking on 'Payment History' tab")
    public void verifyUserDirectedToPaymentHistoryPageAfterClickingOnPaymentHistoryTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.Customer);

        //TestCase 1
        //Click on Payment History Tab & Verify Payment History Page appears
        session.getSidePannel().getPaymentHistoryTab().click();
        String ActualTitle = session.getPaymentHistoryPage().getPaymentHistoryTitle().getText();
        Assertions.assertEquals(Constants.PaymentHistoryTitle, ActualTitle);


    }

    @Test(description = "Verify that appropriate message displayed after clicking on Payment History Tab when no payments are made")
    public void verifyMessageDisplayedWhenNoPaymentsAreMade()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);

        //TestCase 2
        //Click on Payment History Tab when No payments are made & Verify Message Displayed
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getPaymentHistoryTab().click();
        String ActualMessage = session.getPaymentHistoryPage().getNoPaymentMessage().getText();
        Assertions.assertEquals(Constants.NoPaymentsMessage, ActualMessage);

    }

}
