import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session.KadeSession;

public class PaymentsAndRefundTest extends KadeSession {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();
    PaymentsPage payments = new PaymentsPage();
    TransactionsPage transactions= new TransactionsPage();

//    @BeforeMethod
    public void loginApplication() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager(){
        dashboard.clickOnBill();
        String amt = "1,999.00";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        bill.createBill(bills);

        bill.closeLogoConfigPopup();

        //Click on the bill created
        bill.clickUnpaidBill(); // locator fix

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
        bill.clickProcessPaymentBtn();

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
        payments.clickOthersBtn();
        // Verify Payment type panel
        String actualPaymentTypeHeader = payments.getPaymentTypePanelHeader();
        Assertions.assertEquals(actualPaymentTypeHeader,"Payment type");
        Assertions.assertTrue(payments.isVenmoPaymentTypeDisplayed());
        Assertions.assertTrue(payments.isCashPaymentTypeDisplayed());
        Assertions.assertTrue(payments.isZellePaymentTypeDisplayed());
        Assertions.assertTrue(payments.isMemoTextboxDisplayed());

        //Selecting cash payment method.
        payments.clickCashBtn();
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());

        //Close Receive Payment popup
        payments.closeReceivedPopup();
        bill.clickTransactionsLink();
        transactions.clickLastTransaction();
        Assertions.assertEquals(transactions.getBillAmount(),bills.getAmount());
        Assertions.assertTrue(transactions.isUniqueTransactionIdDisplayed());
        transactions.clickCloseTransactionPopup();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
    public void cardPaymentThroughStoreManager(){
        dashboard.clickOnBill();

        //Create Bill
        String amt = "2,499.00";
        BillsPage billsDetails= ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        bill.createBill(billsDetails);
        bill.closeLogoConfigPopup();
        //Open Bill Details popup
        bill.clickUnpaidBill();

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

        bill.clickProcessPaymentBtn();
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
        payments.clickCreditCardBtn();
        payments.payByCreditCard("4111111111111111","0230","123","Australia");
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        payments.closeReceivedPopup();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Venmo through Store manager.")
    public void payByVenmoThroughStoreManager(){
        dashboard.clickOnBill();
        //Create Bill
        String amt = "1,199.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        bill.createBill(defaultBill);
        bill.closeLogoConfigPopup();
        bill.clickUnpaidBill();
        bill.clickProcessPaymentBtn();

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

        payments.clickOthersBtn();
        //Pay by Venmo
        payments.payByVenmo();
        //Verify Payment done
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        payments.closeReceivedPopup();
    }

    @Test(description = "Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();


//        dashboard.clickOnBill();

        //Create Bill
        String amt = "900.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getBillPage().createBill(defaultBill);

        bill.closeLogoConfigPopup();

        // Experiment
        session.getBillPage().getcloseLogoPopupBtn().click();

        bill.clickUnpaidBill();
        bill.clickProcessPaymentBtn();

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

        payments.clickOthersBtn();
        //Pay by Venmo
        payments.payByZelle();
        //Verify Payment done
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        payments.closeReceivedPopup();
    }

    @Test(description = "Bill  Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager(){
        dashboard.clickOnBill();

        String amt = "2,999.00";
        BillsPage billsDetail = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        bill.createBill(billsDetail);

        bill.closeLogoConfigPopup();
        bill.clickUnpaidBill();

        bill.clickProcessPaymentBtn();
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
        payments.enterAmount(updatedAmt1);
        payments.clickOthersBtn();

        //Verify Updated Amount on Payment Type Panel
        Assertions.assertEquals(payments.getReceivingAmountFromPaymentTypePanel(),"$"+updatedAmt1);
        payments.clickCashBtn();

        //Verify Paid Amount
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+updatedAmt1);
        Assertions.assertEquals(payments.getBalanceDue(),"$2,499.00");

        String updatedAmt2 = "350.99";
        //Update Receiving amount
        payments.enterAmount("$"+updatedAmt2);
        payments.clickOthersBtn();

        //Process payment through Venmo
        payments.payByZelle();
        //Verify Total Paid Amount(500.00+350.99)
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$850.99");
        Assertions.assertEquals(payments.getBalanceDue(),"$2,148.01");

        String updatedAmt3 = "1,000.00";
        //Update Receiving amount
        payments.enterAmount("$"+updatedAmt3);
        payments.clickOthersBtn();
        //Process payment through Venmo
        payments.payByVenmo();
        //Verify Total Paid Amount (500.00+350.99+1000.00)
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$1,850.99");
        Assertions.assertEquals(payments.getBalanceDue(),"$1,148.01");

        // Pay Remaining Amount
        payments.clickCreditCardBtn();
        payments.payByCreditCard("4111111111111111","0230","123","Australia");
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        //Verify Total Paid Amount (Full Payment)

        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amt);
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        payments.closeReceivedPopup();
    }
}