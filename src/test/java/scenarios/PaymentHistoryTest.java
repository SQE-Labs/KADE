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
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getPaymentHistoryTab().clickByMouse();
        String ActualMessage = session.getPaymentHistoryPage().getNoPaymentMessage().getText();
        Assertions.assertEquals(Constants.NoPaymentsMessage, ActualMessage);

    }

    @Test(description = " PH03, PH04 : Verify that records get updated everytime on 'Payment History' page when user make any transactions")
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

    @Test(description = " PH05 : Verify that appropriate details appears on 'Payments' tiles, on 'Payment History'  page.")
    public void verifyAppropriateDetailsAppearsOnPaymentTiles()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.Customer);
        //To click on desired transaction
        session.getPaymentHistoryPage().scroll(session.getPaymentHistoryPage().ClickPaidTransaction,25);
        WebdriverWaits.sleep(1000);

        //To get store name
        String StoreName = session.getPaymentHistoryPage().getStoreName().getText();
        System.out.println(StoreName);

        //To get Total paid amount
        String TotalPaidAmount = session.getPaymentHistoryPage().getTotalAmountPaid().getText();
        System.out.println(TotalPaidAmount);
        //To get transaction date & time
        String TransactionDateTime = session.getPaymentHistoryPage().getTransactionDateTime().getText();
        System.out.println(TransactionDateTime);

        //To check payment method image is displayed or not
        session.getPaymentHistoryPage().getPaymentMethodImage().isDisplayed();

        //To get Payment Method
        String PaymentMethodText = session.getPaymentHistoryPage().getPaymentMethodText().getText();
        System.out.println(PaymentMethodText);

        //To check 'Paid' label appears
        String ActualAmountStatus = session.getPaymentHistoryPage().getAmountPaid().getText();
        Assertions.assertEquals(ActualAmountStatus,Constants.ExpectedAmountStatus);

        //To check Customer image is displayed or not
        session.getPaymentHistoryPage().getCustomerImg().isDisplayed();
        


    }

    @Test(description = " PH06 : Verify that user get directed to '<REF- No>' page i.e Bill detail page, after clicking on any payment, on 'Payment History' page.")
    public void VerifyUserDirectedToREFNoPageAfterClickingPaymentHistory() throws IOException, UnsupportedFlavorException {

        KadeSession session = KadeSession.login(KadeUserAccount.Customer);

        //To click on any Transaction
        session.getPaymentHistoryPage().getClickTransaction().click();

        //To copy transaction id on clipboard
        session.getPaymentHistoryPage().getClickTransaction().clickByMouse();

        //To get clipboard data
        String TransactionID = session.getSearchPage().getClipboardText();

        //To display Transaction ID, which shows that user get directed to '<REF- No>' page after clicking on any payment
        System.out.println(TransactionID);


    }

    @Test(description = "PH07 : Verify that 'Partially Paid' label appears and left amount can be paid using 'Make payments' button on 'Transaction Detail' Page, when customer pays partial bill amount.")
    public void VerifyPartialPaidLabelDisplayedAndMakePaymentButtonWorkingProperly() throws IOException, UnsupportedFlavorException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        // Click on 'Bill' sub-Tab
        session.getSidePannel().getBillButton().click();
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsPaymentHistory().setAmount(Constants.amt).setCustomerEmail(Constants.customerEmail);

        // Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 2);

        // Logout as Store manager
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getSignOutButton().click();

        // Login as Customer
        session.getLoginPage().performSignIn(Constants.customerEmail, Constants.Password);

        // Click on Notification Icon
        session.getNotificationPage().getNotificationIcon().click();

        // Click on First Notification
        session.getNotificationPage().getFirstNotification().click();

        // Click on 'Pay Now' Button
        session.getPaymentsPage().getPayNowButton().click();

        // Click on 'Swipe to Pay' field
        session.getPaymentsPage().getSwipeToPayButton().clickbyJS();
        WebdriverWaits.waitForElementUntilVisible(session.getPaymentHistoryPage().Amountfield, 5);

        // Enter Amount
        session.getPaymentsPage().getMoreAmountField().setText("100.00");

        // Click on 'Update' Button
        session.getPaymentsPage().getAmountUpdateButton().click();

        // Swipe to Pay the Partial Amount
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.sleep(5000);

        //Navigate back to Payment History page & Refresh
        getDriver().navigate().back();
        getDriver().navigate().back();
        getDriver().navigate().refresh();

        //Click on partially paid transaction
        session.getPaymentHistoryPage().getCustomerTransaction().click();

        //To check that Partially Paid label appears
        String ActualAmountStatus = session.getPaymentHistoryPage().getAmountPaid().getText();
        Assertions.assertEquals(ActualAmountStatus,Constants.expectedAmountStatus);

        //To click on Make Payment button
        session.getPaymentHistoryPage().getMakePaymentBtn().click();

        //Swipe to Pay left amount
        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().swipeBtn,30);
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.waitForElementUntilVisible(session.getPaymentHistoryPage().CloseButton,5);

        session.getPaymentHistoryPage().getCloseButton().click();


    }
}
