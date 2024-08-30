package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.BillPage;
import org.automation.pages.DashBoardPage;
import org.automation.pages.TransactionsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TransactionTest extends BaseTest {

    @Test(description = "trs1 Verify that list of transactions appears, on 'Transaction' page through Store Manager.")
    public void verifyUserIsAbleToViewTransactionList(){
        KadeSession session =  KadeSession.login(KadeUserAccount.Default);
        TransactionsPage transactions =session.getTransactionsPage();
        DashBoardPage dashBoard = session.getDashBoardPage();
        BillPage bill = session.getBillPage();

        String amt = "2,111.00";
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);

        //Click on the bill created
        session.getBillPage().getUnpaidBillWithoutDescription().click();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = session.getBillPage().getBillPopupHeader().getText();
        Assertions.assertEquals(expectedPopupHeader,"Bill");
        Assertions.assertTrue(session.getBillPage().getShareButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getQRCodeButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getEditBillButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getProcessPaymentButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getDeleteButton().isDisplayed());
//        Assertions.assertTrue(session.getBillPage().getUniqueRefNo().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getBillTime().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getNotPaidLabel().isDisplayed());

        // Click on Process payment button in Bill popup
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements
        String actualTitle = session.getPaymentsPage().getReceivedPaymentTitle().getText();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = session.getPaymentsPage().getBalanceDue().getText();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= session.getPaymentsPage().getTotalAmount().getText().split(" ")[1];
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= session.getPaymentsPage().getReceivingAmountTextbox().getAttribute("value");
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getCreditCardBtn().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getOthersButton().isDisplayed());

        // Click on Other btn
        session.getPaymentsPage().getOthersButton().click();
        // Verify Payment type panel
        String actualPaymentTypeHeader = session.getPaymentsPage().getPaymentTypePanelHeader().getText();
        Assertions.assertEquals(actualPaymentTypeHeader,"Payment type");
        Assertions.assertTrue(session.getPaymentsPage().getVenmoButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getCashButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getZelleButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getMomoTextbox().isDisplayed());

        //Selecting cash payment method.
        session.getPaymentsPage().getCashButton().click();
        String expectedPaymentType = session.getPaymentsPage().getPaymentType().getText();
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());

        //Close Receive Payment popup
        session.getPaymentsPage().getCloseReceivedPopupButton().click();;
        session.getDashBoardPage().getTransactionButton().click();
        transactions.selectStore(bills.getStore());

       // Payment Amount
        String actualTotalPayment = transactions.getTransactionAmmount().getText();
        Assertions.assertEquals(actualTotalPayment,expectedTotalAmount);

        // Payment Type
        String actualPaymentType = transactions.getPaymentTypeOnTransaction().getText();
        Assertions.assertEquals(actualPaymentType,expectedPaymentType);

       // By Store
        String expectedPaymentBy = "By Store";
        System.out.println(transactions.getStore().getText());
        Assertions.assertEquals(transactions.getStore().getText(),expectedPaymentBy);

        //Transaction ID .
        boolean checkflag = transactions.matchPattern(transactions.getTransactionID().getText());
        System.out.println(checkflag);
        Assertions.assertTrue(checkflag);

        // time
       boolean checkTime = transactions.matchTimePattern(transactions.getTimeOnTransactionPage().getText());
        Assertions.assertTrue(checkTime);

    }

    @Test(description = "trs1 Verify that card payment is done by the customer that's appear on Transaction List, on 'Transaction' page through Store Manager.")
    public void cardPaymentViewOnTransactionListByCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        String amt = "4999.00";

        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");
        session.getNotificationPage().getNotificationIcon().click();
        session.getNotificationPage().getFirstNotification().click();
        session.getPaymentsPage().getPayNowButton().click();
        String expectedTotalPayment = session.getBillPage().getActiveBillAmmount().getText();
        session.getPaymentsPage().getChangePaymentButton().clickbyJS();
        String expectedPaymentMethod = session.getPaymentsPage().getSavedCreditCard().getText().replaceAll("\\s.*","");
        session.getPaymentsPage().getSavedCreditCard().click();
        session.getPaymentsPage().swipeToPay();
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();

        // logout customer .
        session.getDashBoardPage().getSignOutButton().click();

        // login as store manager
        session.getLoginPage().performSignIn("6465551114","Test@123");


        // got to transaction Page .
        session.getDashBoardPage().getTransactionButton().click();
        transactions.selectStore(bills.getStore());

        // Transaction ID
        boolean checkflag = transactions.matchPattern(transactions.getTransactionID().getText());
        System.out.println(checkflag);
        Assertions.assertTrue(checkflag);


        // Payment Type
        Assertions.assertEquals(transactions.getPaymentTypeOnTransaction().getText(), expectedPaymentMethod);

        // Payment Amount
        String actualTotalPayment = transactions.getTransactionAmmount().getText();
        Assertions.assertEquals(actualTotalPayment,expectedTotalPayment);

        // Customer Name
        transactions.getLastTransactionRow().click();
        String expectedCustomerNAme = transactions.getCustomeName().getText();
        transactions.getCloseTransactionPopupButton().click();

        Assertions.assertEquals(transactions.getCustomerNameOnTransactionPage().getText(),expectedCustomerNAme);

        // check Time
        boolean checkTime = transactions.matchTimePattern(transactions.getTimeOnTransactionPage().getText());
        Assertions.assertTrue(checkTime);
      }

    @Test(description = "TRS2 : Verify that appropriate information message appears when no transaction is available, on 'Transaction' page.")
    public void verifyInfoMessageAppearsWhenNoTransactionIsAvailable() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore("Automation Transaction 2");
        String expectedInformationMessage = "There are no payments available yet!";

        // Verify the information message when no transaction is available.
        Assertions.assertEquals(session.getTransactionsPage().getInformationMessage().getText(),
                expectedInformationMessage);
         }

     @Test (description = "TRS3 : Verify that 'New Bill' & 'New Charge' buttons and filter icon appear, on 'Transaction' page.")
     public void verifyNewBillNewChargeButtonsAndFilterOnTransactionPage() {
         KadeSession session = KadeSession.login(KadeUserAccount.Default);
         session.getDashBoardPage().getTransactionButton().click();
         TransactionsPage transactions = session.getTransactionsPage();
         session.getTransactionsPage().selectStore("Automation Transaction 2");

         // Verifying  New Bill, New Charge, Filter icon is displayed
         Assertions.assertTrue(transactions.getNewBillTab().isDisplayed());
         Assertions.assertTrue(transactions.getNewChargeTab().isDisplayed());
         Assertions.assertTrue(transactions.getFilterIcon().isDisplayed());
    }

    @Test(description = "TRS4 : Verify that store manager is not able to do the new charge payment, when stripe payment is not configured.")
    public void  newChargePaymentWithoutStripeConfiguration () {
        String amount = "100.00";

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore("Automation Transaction 2");

        // Clicking on 'New Charge' Tab
        transactions.getNewChargeTab().click();
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Verify Alert message is displayed
        String expectedInformationMessage = "Terminal charges are not accepted";
        Assertions.assertTrue(transactions.getTerminalAlertMessage().isDisplayed());
        Assertions.assertEquals(transactions.getTerminalAlertMessage().getText(),expectedInformationMessage);
    }
    @Test (description = "TRS5 (a) :Verify that store manager is able to charge a customer manually, after stripe payment is configured for a store.")
    public void chargeManuallyAfterStripeConfigured() {
        String amount = "100.00";

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore("Automation Transactions");

        transactions.getNewChargeTab().click();

        // Enter amount in new charge popup
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Making new charge payment manually with Credit Card
        session.getPaymentsPage().payByCreditCard();

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$"+amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
       }

    @Test (description = "TRS5 (b): Verify that store manager is able to charge a customer when terminal is configured for a store.")
    public void newChargerWithTerminal() {
        String amount = "100.00";
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore("Automation Transaction 3");

        transactions.getNewChargeTab().click();

        // Enter amount in new charge popup
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Waiting for Automatic Terminal Payment
        WebdriverWaits.waitForElementUntilVisible(session.getNewChargePopup().terminal, 10);
        WebdriverWaits.waitForElementInVisible(session.getNewChargePopup().terminal, 5);

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$"+amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
    }
    @Test (description = "TRS 5 (c): Verify that the store manager can manually do new charge payment, after cancelling the terminal automatic payment deduction process, on 'Transaction' page.")
    public void newChargePaymentManuallyAfterCancelingTerminalAutomaticPaymentDeduction() {
        String amount = "1000.00";
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore("Automation Transaction 3");

        transactions.getNewChargeTab().click();

        // Enter amount in new charge popup
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Waiting for Automatic Terminal Payment
        WebdriverWaits.waitForElementUntilVisible(session.getNewChargePopup().terminal, 10);

        // Canceling automatic terminal payment
        session.getNewChargePopup().getTerminalCancelButton().click();

        // Paying through credit card after canceling terminal payment
        session.getNewChargePopup().getManualChargeTab().click();
        session.getPaymentsPage().payByCreditCard();

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$"+amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
           }

        @Test (description = "TRS7 (a): Verify that store manager is able to refund full transaction on 'Transaction details' popup of 'Transaction' page.")
        public void verifyRefundFullTransactionOnTransactionPage(){
            KadeSession session = KadeSession.login(KadeUserAccount.Default);
            session.getDashBoardPage().getBillButton().click();
            TransactionsPage transactions = session.getTransactionsPage();
            String amt = "4999.00";

            String customerEmail = "yonro@yopmail.com";
            BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsForTransactionCheck().setAmount(amt).setCustomerEmail(customerEmail);

            //Creating Bill
            session.getBillPage().createBill(bills);
            session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

            //Logout as Store manager
            session.getDashBoardPage().getSignOutButton().click();

            //Login as Customer
            session.getLoginPage().performSignIn(customerEmail, "Test@123");
            session.getNotificationPage().getNotificationIcon().click();
            session.getNotificationPage().getFirstNotification().click();
            session.getPaymentsPage().getPayNowButton().click();
            session.getPaymentsPage().getChangePaymentButton().clickbyJS();
            session.getPaymentsPage().getSavedCreditCard().click();
            session.getPaymentsPage().swipeToPay();
            session.getPaymentsPage().getBlueCloseButton().clickByMouse();

            // logout customer .
            session.getDashBoardPage().getSignOutButton().click();

            // login as store manager
            session.getLoginPage().performSignIn("6465551114","Test@123");


            // go to transaction Page .
            session.getDashBoardPage().getTransactionButton().click();
            session.getTransactionsPage().selectStore("Automation Transaction 3");
            TransactionsPage transaction = session.getTransactionsPage();
            transaction.getCurrentPaidBill().click();
            transaction.getRefundButton().click();
            WebdriverWaits.sleep(2000);
            transaction.getRefundReferenceNo().setText("1111");
            transaction.getRefundReason().setText("Refund Checking");
            transaction.getFullRefundButton().click();
        }
    }





