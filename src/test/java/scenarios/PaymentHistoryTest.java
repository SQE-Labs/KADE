package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class PaymentHistoryTest extends BaseTest {
    @Test(description = " PH01 : Verify that user get directed to 'Payment History' page, after clicking on 'Payment History' tab")
    public void verifyUserDirectedToPaymentHistoryPageAfterClickingOnPaymentHistoryTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.Customer);

        //Click on Payment History Tab & Verify Payment History Page appears
        session.getSidePannel().getPaymentHistoryTab().click();
        String ActualTitle = session.getPaymentHistoryPage().getPaymentHistoryTitle().getText();
        Assertions.assertEquals(Constants.PaymentHistoryTitle, ActualTitle);


    }

    @Test(description = " PH02 : Verify that appropriate message displayed after clicking on Payment History Tab when no payments are made")
    public void verifyMessageDisplayedWhenNoPaymentsAreMade()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);

        //Click on Payment History Tab when No payments are made & Verify Message Displayed
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getPaymentHistoryTab().click();
        String ActualMessage = session.getPaymentHistoryPage().getNoPaymentMessage().getText();
        Assertions.assertEquals(Constants.NoPaymentsMessage, ActualMessage);

    }

    @Test(description = " PH03 : Verify that records get updated everytime on 'Payment History' page when user make any transactions")
    public void verifyRecordsGetUpdatedAfterMakingTransaction() throws IOException, UnsupportedFlavorException {


        //Open an account where you can create stores or make transactions
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        // Click on 'Bill' sub-Tab
        session.getSidePannel().getBillButton().click();
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsPaymentHistory().setAmount(Constants.amt).setCustomerEmail(Constants.customerEmail);

        //Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);


        // Logout as Store manager
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getSignOutButton().click();

        // Login as Customer
        session.getLoginPage().performSignIn(Constants.customerEmail, "Test@123");

        //Click on Notification icon
        session.getNotificationPage().getNotificationIcon().click();

        //click on first notification
        session.getNotificationPage().getFirstNotification().click();

        // click 'pay now' button
        session.getPaymentsPage().getPayNowButton().click();
        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().swipeBtn,30);

        //Swipe to Pay
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().closeBlueBtn,30);
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();

        //Copy customer Bill id & store it
        session.getPaymentHistoryPage().getBillIdCustomer().clickByMouse();
        session.getPaymentHistoryPage().getCopyBillIdCustomer().click();
        String CustomerBillId = session.getSearchPage().getClipboardText();

        //Logout as Customer
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getSignOutButton().click();

        //Again Login as Store Manager
        session.login(KadeUserAccount.Default);
        session.getPaymentHistoryPage().getTransactionsButton().click();

        //Copy Store Transaction Reference Id & store it
        session.getBillPage().getStoresDropdown().click();
        session.getBillPage().selectStore(bills.getStore());
        session.getBillPage().getContinueButton().click();
        session.getSearchPage().getSearchTransReferenceId().click();
        String storeBillId = session.getSearchPage().getClipboardText();

        //Verify Customer Bill id & Store Bill id are same
        Assertions.assertEquals(CustomerBillId, storeBillId);

    }

}
