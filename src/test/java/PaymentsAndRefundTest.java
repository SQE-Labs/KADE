import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.automation.session.KadeSession;

public class PaymentsAndRefundTest extends KadeSession {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();
    PaymentsPage payments = new PaymentsPage();
    TransactionsPage transactions= new TransactionsPage();

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String amt = "1,999.00";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(bills);
//        WebdriverWaits.sleep(5000);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist();

        //Click on the bill created
        session.getBillPage().getUnpaidBillButton().click();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = bill.getBillPopupHeader();
        Assertions.assertEquals(expectedPopupHeader,"Bill");
        Assertions.assertTrue(bill.isShareBtnDisplayed());
        Assertions.assertTrue(bill.isQrCodeBtnDisplayed());
        Assertions.assertTrue(bill.isEditBtnDisplayed());
        Assertions.assertTrue(bill.isProcessPaymentBtnDisplayed());
        Assertions.assertTrue(bill.isDeleteBillBtnDisplayed());
        Assertions.assertTrue(bill.isUniqueRefNoDisplayed());
        Assertions.assertTrue(bill.isBillPopupTimeDisplayed());
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed());

        // Click on Process payment button in Bill popup
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = payments.getBalanceDue();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= payments.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= payments.getReceivingAmount();
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());

        // Click on Other btn
        session.getPaymentsPage().getOthersButton().click();
        // Verify Payment type panel
        String actualPaymentTypeHeader = payments.getPaymentTypePanelHeader();
        Assertions.assertEquals(actualPaymentTypeHeader,"Payment type");
        Assertions.assertTrue(payments.isVenmoPaymentTypeDisplayed());
        Assertions.assertTrue(payments.isCashPaymentTypeDisplayed());
        Assertions.assertTrue(payments.isZellePaymentTypeDisplayed());
        Assertions.assertTrue(payments.isMemoTextboxDisplayed());

        //Selecting cash payment method.
        session.getPaymentsPage().getCashButton().click();
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());

        //Close Receive Payment popup
        session.getPaymentsPage().getCloseReceivedPopupButton().click();;
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(bills.getStore());
        session.getTransactionsPage().getLastTransactionRow().click();
        Assertions.assertEquals(transactions.getBillAmount(),"$"+bills.getAmount());
        Assertions.assertTrue(transactions.isUniqueTransactionIdDisplayed());
        session.getTransactionsPage().getCloseTransactionPopupButton().click();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
    public void cardPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Create Bill
        String amt = "2,499.00";
        BillsPage billsDetails= ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(billsDetails);
        WebdriverWaits.sleep(5000);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist();
        //Open Bill Details popup
        session.getBillPage().getUnpaidBillButton().click();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = bill.getBillPopupHeader();
        Assertions.assertEquals(expectedPopupHeader,"Bill");
        Assertions.assertTrue(bill.isShareBtnDisplayed());
        Assertions.assertTrue(bill.isQrCodeBtnDisplayed());
        Assertions.assertTrue(bill.isEditBtnDisplayed());
        Assertions.assertTrue(bill.isProcessPaymentBtnDisplayed());
        Assertions.assertTrue(bill.isDeleteBillBtnDisplayed());
        Assertions.assertTrue(bill.isUniqueRefNoDisplayed());
        Assertions.assertTrue(bill.isBillPopupTimeDisplayed());
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed());

        session.getBillPage().getProcessPaymentButton().click();
        // Verify popup title and elements
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = payments.getBalanceDue();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= payments.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= payments.getReceivingAmount();
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());

        //Process Payment by Credit Card
        session.getPaymentsPage().getCreditCardBtn().click();
        session.getPaymentsPage().payByCreditCard();
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Venmo through Store manager.")
    public void payByVenmoThroughStoreManager(){
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        //Create Bill
        String amt = "1,199.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(defaultBill);
        WebdriverWaits.sleep(5000);

        session.getBillPage().getCloseLogoPopupBtn().click();
        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = payments.getBalanceDue();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= payments.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= payments.getReceivingAmount();
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());

        session.getPaymentsPage().getOthersButton().click();
        //Pay by Venmo
        session.getPaymentsPage().getVenmoButton().click();
        //Verify Payment done
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        //Create Bill
        String amt = "900.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getBillPage().createBill(defaultBill);
        WebdriverWaits.sleep(5000);

        session.getBillPage().getCloseLogoPopupBtn().click();

        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements of Receive Payment popup
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = payments.getBalanceDue();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= payments.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= payments.getReceivingAmount();
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());

        session.getPaymentsPage().getOthersButton().click();
        //Pay by Venmo
        session.getPaymentsPage().getZelleButton().click();
        //Verify Payment done
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "Bill  Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        String amt = "2,999.00";
        BillsPage billsDetail = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getBillPage().createBill(billsDetail);
        WebdriverWaits.sleep(5000);

        session.getBillPage().getCloseLogoPopupBtn().clickIfExist();
        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements of Receive Payment popup
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");
        String expectedBalanceDue = payments.getBalanceDue();
        Assertions.assertEquals(expectedBalanceDue,"$"+amt);
        String expectedTotalAmount= payments.getTotalAmount();
        Assertions.assertEquals(expectedTotalAmount,"$"+amt);
        String expectedReceivingAmount= payments.getReceivingAmount();
        Assertions.assertEquals(expectedReceivingAmount,"$"+amt);
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());

        String updatedAmt1 = "500.00";
        //Update Receiving amount
        session.getPaymentsPage().getReceivingAmountTextbox().setText(updatedAmt1);
        session.getPaymentsPage().getOthersButton().click();

        //Verify Updated Amount on Payment Type Panel
        Assertions.assertEquals(payments.getReceivingAmountFromPaymentTypePanel(),"$"+updatedAmt1);
        session.getPaymentsPage().getCashButton().click();

        //Verify Paid Amount
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+updatedAmt1);
        Assertions.assertEquals(payments.getBalanceDue(),"$2,499.00");

        String updatedAmt2 = "350.99";
        //Update Receiving amount
        session.getPaymentsPage().getReceivingAmountTextbox().setText(updatedAmt2);
        session.getPaymentsPage().getOthersButton().click();

        //Process payment through Venmo
        session.getPaymentsPage().getZelleButton().click();

        //Verify Total Paid Amount(500.00+350.99)
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$850.99");
        Assertions.assertEquals(payments.getBalanceDue(),"$2,148.01");

        String updatedAmt3 = "1,000.00";
        //Update Receiving amount
        session.getPaymentsPage().getReceivingAmountTextbox().setText(updatedAmt3);
        session.getPaymentsPage().getOthersButton().click();
        //Process payment through Venmo
        session.getPaymentsPage().getVenmoButton().click();
        //Verify Total Paid Amount (500.00+350.99+1000.00)
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$1,850.99");
        Assertions.assertEquals(payments.getBalanceDue(),"$1,148.01");

        // Pay Remaining Amount
        session.getPaymentsPage().getCreditCardBtn().click();
        session.getPaymentsPage().payByCreditCard();
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        //Verify Total Paid Amount (Full Payment)

        WebdriverWaits.sleep(5000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amt);
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }
}