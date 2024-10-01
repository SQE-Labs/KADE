package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.data.StoreAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.BillPage;
import org.automation.pages.DashBoardPage;
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

import java.util.*;

public class TransactionTest extends BaseTest {

    @Test(description = "trs1 Verify that list of transactions appears, on 'Transaction' page through Store Manager.")
    public void verifyUserIsAbleToViewTransactionList() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        TransactionsPage transactions = session.getTransactionsPage();
        DashBoardPage dashBoard = session.getDashBoardPage();
        BillPage bill = session.getBillPage();

        String amt = "2,111.00";
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Click on the bill created
        session.getBillPage().getUnpaidBillWithoutDescription().click();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = session.getBillPage().getBillPopupHeader().getText();
        Assertions.assertEquals(expectedPopupHeader, "Bill");
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
        Assertions.assertEquals(actualTitle, "Receive Payment");
        String expectedBalanceDue = session.getPaymentsPage().getBalanceDue().getText();
        Assertions.assertEquals(expectedBalanceDue, "$" + amt);
        String expectedTotalAmount = session.getPaymentsPage().getTotalAmount().getText().split(" ")[1];
        Assertions.assertEquals(expectedTotalAmount, "$" + amt);
        String expectedReceivingAmount = session.getPaymentsPage().getReceivingAmountTextbox().getAttribute("value");
        Assertions.assertEquals(expectedReceivingAmount, "$" + amt);
        Assertions.assertTrue(session.getPaymentsPage().getCreditCardBtn().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getOthersButton().isDisplayed());

        // Click on Other btn
        session.getPaymentsPage().getOthersButton().click();
        // Verify Payment type panel
        String actualPaymentTypeHeader = session.getPaymentsPage().getPaymentTypePanelHeader().getText();
        Assertions.assertEquals(actualPaymentTypeHeader, "Payment type");
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
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
        session.getDashBoardPage().getTransactionButton().click();
        transactions.selectStore(bills.getStore());

        // Payment Amount
        String actualTotalPayment = transactions.getTransactionAmmount().getText();
        Assertions.assertEquals(actualTotalPayment, expectedTotalAmount);

        // Payment Type
        String actualPaymentType = transactions.getPaymentTypeOnTransaction().getText();
        Assertions.assertEquals(actualPaymentType, expectedPaymentType);

        // By Store
        String expectedPaymentBy = "By Store";
        System.out.println(transactions.getStore().getText());
        Assertions.assertEquals(transactions.getStore().getText(), expectedPaymentBy);

        //Transaction ID .
        boolean checkflag = transactions.matchPattern(transactions.getTransactionID().getText());
        System.out.println(checkflag);
        Assertions.assertTrue(checkflag);

        // time
        boolean checkTime = transactions.matchTimePattern(transactions.getTimeOnTransactionPage().getText());
        Assertions.assertTrue(checkTime);

    }

    @Test(description = "trs1 Verify that card payment is done by the customer that's appear on Transaction List, on 'Transaction' page through Store Manager.")
    public void verifyCardPaymentViewOnTransactionListByCustomer() {
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
        String expectedPaymentMethod = session.getPaymentsPage().getSavedCreditCard().getText().replaceAll("\\s.*", "");
        session.getPaymentsPage().getSavedCreditCard().click();
        session.getPaymentsPage().swipeToPay();
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();

        // logout customer .

        session.getDashBoardPage().getSignOutButton().click();

        // login as store manager
        session.getLoginPage().performSignIn("6465551114", "Test@123");


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
        Assertions.assertEquals(actualTotalPayment, expectedTotalPayment);

        // Customer Name
        transactions.getLastTransactionRow().click();
        String expectedCustomerNAme = transactions.getCustomeName().getText();
        transactions.getCloseTransactionPopupButton().click();

        Assertions.assertEquals(transactions.getCustomerNameOnTransactionPage().getText(), expectedCustomerNAme);

        // check Time
        boolean checkTime = transactions.matchTimePattern(transactions.getTimeOnTransactionPage().getText());
        Assertions.assertTrue(checkTime);
    }

    @Test(description = "TRS2 : Verify that appropriate information message appears when no transaction is available, on 'Transaction' page.")
    public void verifyInfoMessageAppearsWhenNoTransactionIsAvailable() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransaction2);
        String expectedInformationMessage = "There are no payments available yet!";

        // Verify the information message when no transaction is available.
        Assertions.assertEquals(session.getTransactionsPage().getInformationMessage().getText(), expectedInformationMessage);
    }

    @Test(description = "TRS3 : Verify that 'New Bill' & '" +
            "' buttons and filter icon appear, on 'Transaction' page.")
    public void verifyNewBillNewChargeButtonsAndFilterOnTransactionPage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransaction2);

        // Verifying  New Bill, New Charge, Filter icon is displayed
        Assertions.assertTrue(transactions.getNewBillTab().isDisplayed());
        Assertions.assertTrue(transactions.getNewChargeTab().isDisplayed());
        Assertions.assertTrue(transactions.getFilterIcon().isDisplayed());
    }

    @Test(description = "TRS4 : Verify that store manager is not able to do the new charge payment, when stripe payment is not configured.")
    public void newChargePaymentWithoutStripeConfiguration() {
        String amount = "100.00";

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransaction2);

        // Clicking on 'New Charge' Tab
        transactions.getNewChargeTab().click();
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Verify Alert message is displayed
        String expectedInformationMessage = "Terminal charges are not accepted";
        Assertions.assertTrue(transactions.getTerminalAlertMessage().isDisplayed());
        Assertions.assertEquals(transactions.getTerminalAlertMessage().getText(), expectedInformationMessage);
    }

    @Test(description = "TRS5 (a) :Verify that store manager is able to charge a customer manually, after stripe payment is configured for a store.")
    public void chargeManuallyAfterStripeConfigured() {
        String amount = "100.00";

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransactions);

        transactions.getNewChargeTab().click();

        // Enter amount in new charge popup
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Making new charge payment manually with Credit Card
        session.getPaymentsPage().payByCreditCard();

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$" + amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
    }

    @Test(description = "TRS5 (b): Verify that store manager is able to charge a customer when terminal is configured for a store.")
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
        Assertions.assertTrue(session.getNewChargePopup().getTerminalPopup().isDisplayed());
        WebdriverWaits.sleep(5000);

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$" + amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
    }

    @Test(description = "TRS 5 (c): Verify that the store manager can manually do new charge payment, after cancelling the terminal automatic payment deduction process, on 'Transaction' page.")
    public void newChargePaymentManuallyAfterCancelingTerminalAutomaticPaymentDeduction() {
        String amount = "1,000.00";
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        session.getTransactionsPage().selectStore("Automation Transaction 3");

        transactions.getNewChargeTab().click();

        // Enter amount in new charge popup
        session.getNewChargePopup().getNewChargeAmountField().setText(amount);
        session.getNewChargePopup().getNewChargeConfirmButton().click();

        // Waiting for Automatic Terminal Payment
        Assertions.assertTrue(session.getNewChargePopup().getTerminalPopup().isDisplayed());

        // Canceling automatic terminal payment
        session.getNewChargePopup().getTerminalCancelButton().click();

        // Paying through credit card after canceling terminal payment
        session.getNewChargePopup().getManualChargeTab().click();
        session.getPaymentsPage().payByCreditCard();

        // Verify the Send Receipt Popup is Displayed
        Assertions.assertTrue(session.getSendTheReceiptPopup().getSendReceiptTitle().isDisplayed());
        Assertions.assertEquals(session.getSendTheReceiptPopup().getAmountField().getText(), "$" + amount);
        Assertions.assertEquals(session.getSendTheReceiptPopup().getSuccessMessageField().getText(), "Processed successfully!");
    }

    @Test(description = "TRS7 (a): Verify that store manager is able to refund full transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyRefundFullTransactionOnTransactionPage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        String amt = "4,999.00";

        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsForTransactionCheck().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Login as Customer
        session.getLoginPage().performSignIn(KadeUserAccount.Customer.getUserName(), KadeUserAccount.Customer.getPassword());
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
        session.getLoginPage().performSignIn(KadeUserAccount.Default.getUserName(), KadeUserAccount.Default.getPassword());

        // go to transaction Page .
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransactions3);
        TransactionsPage transaction = session.getTransactionsPage();
        transaction.getCurrentPaidBill().click();
        Assertions.assertTrue(transaction.getRefundButton().isDisplayed());
        transaction.getRefundButton().click();
        WebdriverWaits.sleep(2000);
        transaction.getRefundReferenceNo().setText("1111");
        transaction.getRefundReason().setText("Refund Checking");
        transaction.getFullRefundButton().click();
        Assertions.assertEquals(transaction.getRefundAmountOnReceipt().getText(), "$" + amt);
        Assertions.assertTrue(transaction.getRefundLabel().isDisplayed());
        Assertions.assertTrue(transaction.getVerifyButton().isDisplayed());

    }

    @Test(description = "TRS7 (b): Verify that store manager is able to refund partial transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToRefundPartialPayment() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        RandomGenerator randomGenerator = new RandomGenerator();

        String amt = "4,999.00";
        String refundReason = "Extra fair testing";
        String refundAmmount = "50.00";
        String refundReferenceNo = randomGenerator.requiredDigits(4);

        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsForTransactionCheck().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Login as Customer
        session.getLoginPage().performSignIn(KadeUserAccount.Customer.getUserName(), KadeUserAccount.Customer.getPassword());
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
        session.getLoginPage().performSignIn(KadeUserAccount.Default.getUserName(), KadeUserAccount.Default.getPassword());

        // go to transaction Page .
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransactions3);
        TransactionsPage transaction = session.getTransactionsPage();
        transaction.getCurrentPaidBill().click();

        // Verify Refund Button
        Assertions.assertTrue(transaction.getRefundButton().isDisplayed());

        transaction.getRefundButton().click();
        WebdriverWaits.sleep(2000);
        transaction.getRefundReferenceNo().setText(refundReferenceNo);
        transaction.getRefundReason().setText(refundReason);

        // Clicking on partial refund link.
        transaction.getPartialRefundLink().click();
        WebdriverWaits.sleep(2000);

        // Verify the validation message when no payment checkbox is selected.
        transaction.getProcessRefundButton().click();
        String actual = transaction.getRefundValidationMessage().getText();
        Assertions.assertEquals(actual, "Select at least one payment to refund");

        transaction.getVisaPaymentCheckbox().click();

        // Verify that Refund Amount field is displayed after selecting the checkbox
        Assertions.assertTrue(transaction.getRefundAmountField().isDisplayed());
        transaction.getProcessRefundButton().click();
        String tooltip = transaction.getRefundAmountField().getToolTipMessage();
        Assertions.assertEquals(tooltip, "This field is required.");

        transaction.getRefundAmountField().setText(refundAmmount);
        transaction.getProcessRefundButton().click();

    }


    @Test(description = "TRS8 Verify that store manager is able to verify the transactions on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToVerifyTransaction() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        RandomGenerator randomGenerator = new RandomGenerator();

        String amt = "4,999.00";
        String refundReason = "Extra fair testing";
        String refundAmmount = "50.00";
        String refundReferenceNo = randomGenerator.requiredDigits(4);

        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsForTransactionCheck().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Login as Customer
        session.getLoginPage().performSignIn(KadeUserAccount.Customer.getUserName(), KadeUserAccount.Customer.getPassword());
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
        session.getLoginPage().performSignIn(KadeUserAccount.Default.getUserName(), KadeUserAccount.Default.getPassword());

        // go to transaction Page .
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransactions3);
        TransactionsPage transaction = session.getTransactionsPage();
        transaction.getCurrentPaidBill().click();

        // Verify Refund Button
        Assertions.assertTrue(transaction.getRefundButton().isDisplayed());

        transaction.getRefundButton().click();
        WebdriverWaits.sleep(2000);
        transaction.getRefundReferenceNo().setText(refundReferenceNo);
        transaction.getRefundReason().setText(refundReason);

        // Clicking on partial refund link.
        transaction.getPartialRefundLink().click();
        WebdriverWaits.sleep(2000);

        // Verify the validation message when no payment checkbox is selected.
        transaction.getProcessRefundButton().click();
        String actual = transaction.getRefundValidationMessage().getText();
        Assertions.assertEquals(actual, "Select at least one payment to refund");

        transaction.getVisaPaymentCheckbox().click();

        // Verify that Refund Amount field is displayed after selecting the checkbox
        Assertions.assertTrue(transaction.getRefundAmountField().isDisplayed());
        transaction.getProcessRefundButton().click();
        String tooltip = transaction.getRefundAmountField().getToolTipMessage();
        Assertions.assertEquals(tooltip, "This field is required.");

        transaction.getRefundAmountField().setText(refundAmmount);
        transaction.getProcessRefundButton().click();

        // verify transactions
        transaction.getVerifyButton().click();
        // Assertions on Verify Assertion Popup .
        transaction.getVerifyButtonOnPopup().isDisplayed();
        Assertions.assertEquals(transaction.getInformationMessageOnVerifyPopup().getText(), "Each transaction can be verified only once.");

        transaction.getVerifyButtonOnPopup().click();

        Assertions.assertEquals(transaction.getVerifiedByStoreMssg().getText(), "Verified by the store");

    }

    @Test(description = "Verify that store manager is able to filter the transaction on 'Transactions' page.")
    public void verifyThatTransactionListAppears() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        RandomGenerator randomGenerator = new RandomGenerator();

        //Step 1: Click on 'Bill' sub-Tab
        session.getDashBoardPage().getBillButton().click();

        //Step 2: Enter Amount
        String amt = "4999.00";
        String ammountFrom = "10.00";
        String ammountTo = "100.00";
        //Step 3: Enter Customer Email
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetailsForTransactionCheck().setAmount(amt).setCustomerEmail(customerEmail);

        //Step 4: Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Step 5: Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click(); // Signing out

        //Step 6: Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");

        //Step 7: Click on Notification Icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 8: Click on First Notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 9: Click on 'Pay Now' Button
        session.getPaymentsPage().getPayNowButton().click();

        //Step 10: Click on 'Change Payment Method' Button
        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();

        //Step 11: Select 'Bank Account' Method
        session.getPaymentsPage().getSavedBankAccount().click();

        //Verify that Selected Bank Method is Displayed
        Assertions.assertTrue(session.getPaymentsPage().getSelectedBankDisplay().isDisplayed());

        //Step 12: Swipe to Pay
        session.getPaymentsPage().swipeToPay();

        System.out.println(session.getPaymentsPage().getProcessSuccessMsg().getText());

        //Verify that success message appears after Payment is made successfully
        Assertions.assertEquals(session.getPaymentsPage().getProcessSuccessMsg().getText(), "$4,999.00 PAID");
        Assertions.assertTrue(session.getPaymentsPage().getRateYourExperienceLink().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getViewReceiptLink().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getBlueCloseButton().isDisplayed());

        //Step 13: Close the Pop-up
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();
        session.getDashBoardPage().getSignOutButton().click();


        KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationTransactions3);

        List<WebElement> eleOfAllTrans = session.getTransactionsPage().getTransactionID().getListOfWebElements();
        System.out.println("size of ids" + eleOfAllTrans.size());
        List<String> listOfAllTransactionID = new ArrayList<>();
        for (int i = 0; i < eleOfAllTrans.size(); i++) {
            listOfAllTransactionID.add(eleOfAllTrans.get(i).getText());
        }
        System.out.println(listOfAllTransactionID);

        List<WebElement> ele1 = session.getTransactionsPage().getTransactionID().getListOfWebElements();
        List<String> transactionIDBeforeFilterApply = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            transactionIDBeforeFilterApply.add(ele1.get(i).getText());
        }

        session.getTransactionsPage().getFilterIcon().click();
        Assertions.assertTrue(transactions.getFilterTitle().isDisplayed());
        WebdriverWaits.sleep(3000);
        session.getTransactionsPage().getApplyButtonOnPopup().click();

        // transactionids
        List<WebElement> ele2 = session.getTransactionsPage().getTransactionID().getListOfWebElements();
        List<String> transactionIDAfterFilterApply = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            transactionIDAfterFilterApply.add(ele2.get(i).getText());
        }
        // Convert lists to sets for comparison
        Set<String> setBeforeFilter = new HashSet<>(transactionIDBeforeFilterApply);
        System.out.println(setBeforeFilter);
        Set<String> setAfterFilter = new HashSet<>(transactionIDAfterFilterApply);
        System.out.println(setAfterFilter);
        // Check  setAfterFilter contains all elements from setBeforeFilter
        Assertions.assertTrue(setAfterFilter.containsAll(setBeforeFilter));

        session.getTransactionsPage().getFilterIcon().click();
        // Click on Download button

        WebdriverWaits.sleep(3000);
        String fileStatus = ActionEngine.isFileDownloaded("Transactions.xlsx");
        System.out.println("fileStatus :" + fileStatus);

        if (fileStatus.equalsIgnoreCase("File Present")) {
            String deletStatus = ActionEngine.deleteFile("Transactions.xlsx");
            System.out.println("deleteStatus :" + deletStatus);
        }
        transactions.getDownloadButton().click();
        WebdriverWaits.sleep(3000);
        String fileDownloadStatus = ActionEngine.isFileDownloaded("Transactions.xlsx");
        System.out.println("fileDownloadStatus: " + fileDownloadStatus);
        Assertions.assertEquals(ActionEngine.isFileDownloaded("Transactions.xlsx"), "File Present");

        session.getTransactionsPage().getFilterIcon().click();
        WebdriverWaits.sleep(3000);
        transactions.getDateRangeField().click();

        List<WebElement> dateList2 = transactions.getListCallenderTime().getListOfWebElements();
        List<String> dateList = new ArrayList<>();
        for (WebElement element : dateList2) {
            String text = element.getText().trim();
            dateList.add(text);
        }

        List<String> expectedList = Arrays.asList("Empty", "Last 30 Days", "This Month", "Custom Range", "Yesterday", "Last Month", "Last 7 Days");

        for (String expectedItem : expectedList) {
            Assertions.assertTrue(dateList.contains(expectedItem));
        }

        //Asertions for Calender
        Assertions.assertTrue(transactions.getCalender1().isDisplayed());
        Assertions.assertTrue(transactions.getCalender2().isDisplayed());

        transactions.getPaymentStatusDropdown().click();
        transactions.getPendingPayments().click();
        transactions.getApplyButtonOnPopup().click();
        WebdriverWaits.sleep(3000);

        Assertions.assertTrue(transactions.getPendingPaymentIcon().isDisplayed());

        transactions.getFilterIcon().click();
        transactions.getPaymentStatusDropdown().click();
        transactions.getFailedPayments().click();
        transactions.getApplyButtonOnPopup().click();
        WebdriverWaits.sleep(3000);

        Assertions.assertTrue(transactions.getExcalamatrySign().isDisplayed());

        transactions.getFilterIcon().click();
        transactions.getPaymentStatusDropdown().click();
        WebdriverWaits.sleep(2000);
        transactions.getUnverifiedPayments().click();
        transactions.getApplyButtonOnPopup().click();
        WebdriverWaits.sleep(2000);

        Assertions.assertTrue(transactions.getQuotionmarkSign().isDisplayed());

        transactions.getFilterIcon().click();
        transactions.getPaymentStatusDropdown().click();
        transactions.getClearPaymentField().click();
        WebdriverWaits.sleep(2000);
        transactions.getPaymentLinkField().click();
        transactions.getQrCodeSeletct().click();
        transactions.getApplyButtonOnPopup().click();

        WebdriverWaits.sleep(2000);

        Assertions.assertTrue(transactions.getQrCodeSign().isDisplayed());

        transactions.getFilterIcon().click();
        transactions.getPaymentLinkField().click();
        transactions.getQrClearField().click();

        transactions.getAmmountFieldFrom().setText(ammountFrom);
        transactions.getAmmountFieldTo().setText(ammountTo);

        transactions.getApplyButtonOnPopup().click();
        WebdriverWaits.sleep(5000);

        List<WebElement> ammountList = transactions.getAmmountList().getListOfWebElements();
        List<Double> ammountList1 = new ArrayList<>();
        for (WebElement element : ammountList) {
            String text = element.getText().trim();
            ammountList1.add(Double.parseDouble(text.substring(1)));
        }
        System.out.println(ammountList1);
        boolean flag = false;
        System.out.println(Integer.parseInt(ammountFrom.split("\\.")[0]));

        for (int i = 0; i < ammountList1.size(); i++) {
            double temp = ammountList1.get(i);
            if(temp>=Integer.parseInt(ammountFrom.split("\\.")[0]) && temp<=Integer.parseInt(ammountTo.split("\\.")[0])){
                flag =true;
            }
        }
        Assert.assertTrue(flag, "The amount does not lie between the applied filter");


    }




}






