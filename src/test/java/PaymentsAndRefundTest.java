import org.automation.base.BaseTest;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pageObjects.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentsAndRefundTest extends BaseTest {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();
    PaymentsPage payments = new PaymentsPage();
    TransactionsPage transactions= new TransactionsPage();

    @BeforeMethod
    public void loginApplication() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(description = "PYMT1 : Bill Creation and Successful Bill Payment by Cash through Store Manager.")
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
//        bill.clickTransactionsLink();
//        transactions.clickLastTransaction();
//        Assertions.assertEquals(transactions.getBillAmount(),bills.getAmount());
//        Assertions.assertTrue(transactions.isUniqueTransactionIdDisplayed());
//        transactions.clickCloseTransactionPopup();
    }

    @Test(description = "PYMT2 : Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
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
        payments.payByCreditCard();
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        payments.closeReceivedPopup();
    }

    @Test(description = "PYMT3 : Bill Creation and Successful Bill Payment by Venmo through Store manager.")
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

    @Test(description = "PYMT4 : Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager(){
        dashboard.clickOnBill();
        //Create Bill
        String amt = "900.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        bill.createBill(defaultBill);
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

        payments.clickOthersBtn();
        //Pay by Venmo
        payments.payByZelle();
        //Verify Payment done
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        payments.closeReceivedPopup();
    }

    @Test(description = "PYMT6 : Bill Creation and pay the bill by multiple payment mode through Store manager.")
    public void paymentByMultipleModeThroughStoreManager(){
        dashboard.clickOnBill();

        String amt = "2,999.00";
        String updatedAmt1 = "500.00";
        String updatedAmt2 = "350.99";
        String updatedAmt3 = "1,000.00";
        BillsPage billsDetail = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        //Creating Bill
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

        //Update Receiving amount
        payments.enterAmount(updatedAmt1);
        payments.clickOthersBtn();

        //Verify Updated Amount on Payment Type Panel
        Assertions.assertEquals(payments.getReceivingAmountFromPaymentTypePanel(),"$"+updatedAmt1);
        payments.clickCashBtn();

        //Verify Paid Amount
        float amount = Float.parseFloat(amt.replace(",", ""));
        float updateAmount1 = Float.parseFloat(updatedAmt1.replace(",", ""));
        float expBalanceDue1= amount - updateAmount1;
        String expectedBalanceDue1 = bill.convertToNumberFormat(expBalanceDue1);
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+updatedAmt1);
        Assertions.assertEquals(payments.getBalanceDue(),"$"+expectedBalanceDue1);

        //Update Receiving amount
        payments.enterAmount("$"+updatedAmt2);
        payments.clickOthersBtn();

        //Process payment through Venmo
        payments.payByZelle();
        //Verify Total Paid Amount
        float updateAmount2 = Float.parseFloat(updatedAmt2.replace(",", ""));
        float expBalanceDue2= expBalanceDue1 - updateAmount2;
        String expectedBalanceDue2 = bill.convertToNumberFormat(expBalanceDue2);
        float amtPaid2 = updateAmount1 + updateAmount2;
        String amountPaid2 = bill.convertToNumberFormat(amtPaid2);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amountPaid2);
        Assertions.assertEquals(payments.getBalanceDue(),"$"+expectedBalanceDue2);

        //Update Receiving amount
        payments.enterAmount("$"+updatedAmt3);
        payments.clickOthersBtn();
        //Process payment through Venmo
        payments.payByVenmo();
        //Verify Total Paid Amount
        float updateAmount3 = Float.parseFloat(updatedAmt3.replace(",", ""));
        float expBalanceDue3= expBalanceDue2 - updateAmount3;
        String expectedBalanceDue3 = bill.convertToNumberFormat(expBalanceDue3);
        float amtPaid3 = updateAmount1 + updateAmount2 + updateAmount3;
        String amountPaid3 = bill.convertToNumberFormat(amtPaid3);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amountPaid3);
        Assertions.assertEquals(payments.getBalanceDue(),"$"+expectedBalanceDue3);

        // Pay Remaining Amount
        payments.clickCreditCardBtn();
        payments.payByCreditCard();
        WebdriverWaits.waitForElementInVisible(payments.paymentTypeHeader,5);
        //Verify Total Paid Amount (Full Payment)
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amt);
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        payments.closeReceivedPopup();
    }
    @Test(description = "PYMT5 : Bill Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager(){
        dashboard.clickOnBill();
        String amt = "1,499.00";
        String payAmt = "1,185.25";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        bill.createBill(bills);
        bill.closeLogoConfigPopup();
        bill.clickUnpaidBill();
        bill.clickProcessPaymentBtn();

        //Update Amount
        payments.enterAmount(payAmt);
        payments.clickCreditCardBtn();
        payments.payByCreditCard();

        //Verify Total Paid Amount
        float amount = Float.parseFloat(amt.replace(",",""));
        float updateAmount = Float.parseFloat(payAmt.replace(",", ""));
        float expBalanceDue= amount - updateAmount;
        String expectedBalanceDue = bill.convertToNumberFormat(expBalanceDue);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+payAmt);
        Assertions.assertEquals(payments.getBalanceDue(),"$"+expectedBalanceDue);
        payments.isPaymentLogoDisplayed();

        payments.closeReceivedPopup();
        payments.refreshPage();
        bill.isPartialLabelDisplayed();

    }

    @Test(description = "PYMT7 : Bill Creation and mark payment as Void by Store manager.")
    public void markSuccessfulPaymentAsVoid() {
        dashboard.clickOnBill();
        String amt = "2,251.75";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        bill.createBill(bills);
        bill.closeLogoConfigPopup();
        bill.clickUnpaidBill();
        bill.clickProcessPaymentBtn();
        // Process payment successfully
        payments.clickOthersBtn();
        payments.payByZelle();
        //Verify payment
        Assertions.assertTrue(payments.isPaidLabelDisplayed());
        Assertions.assertTrue(payments.isPaymentLogoDisplayed());
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+amt);
        Assertions.assertTrue(payments.isVoidBtnDisplayed());
        //Mark payment as void
        payments.clickVoidBtn();
        //Verify voided payment
        float amount = Float.parseFloat(amt.replace(",",""));
        float expVoidAmount= amount - amount;
        String expectedPaidTotal = bill.convertToNumberFormat(expVoidAmount);
        Assertions.assertEquals(payments.getTotalPaidAmount(),"$"+expectedPaidTotal);
        Assertions.assertEquals(payments.getBalanceDue(),"$"+amt);
        Assertions.assertTrue(payments.isVoidedTagDisplayed());
        Assertions.assertTrue(payments.isCreditCardBtnDisplayed());
        Assertions.assertTrue(payments.isOtherBtnDisplayed());
        Assertions.assertEquals(payments.getReceivingAmount(),"$"+amt);

        payments.closeReceivedPopup();
        //Verify NotPaid label
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));

        //Deleting unpaid bill
        bill.deleteUnpaidBill();
    }

    @Test(description = "PYMT8 : Bill Creation and Successful Bill Payment through Credit Card by Customer.")
    public void BillPaymentByCreditCardThroughCustomer() {
        dashboard.clickOnBill();
        String amt = "4999.00";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        bill.createBill(bills);
        bill.closeLogoConfigPopup();
        //Logout as Store manager
        dashboard.signOut();

        //Login as Customer
        login.performSignIn("yonro@yopmail.com", "Test@123");

    }

}