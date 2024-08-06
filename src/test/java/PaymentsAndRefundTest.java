import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.automation.session.KadeSession;

public class PaymentsAndRefundTest extends KadeSession {

    @Test(description = "PYMT1 Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String amt = "1,999.00";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Click on the bill created
        session.getBillPage().getUnpaidBillButton().click();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = session.getBillPage().getBillPopupHeader().getTex();
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
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed()); 
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());

        //Close Receive Payment popup
        session.getPaymentsPage().getCloseReceivedPopupButton().click();;
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore(bills.getStore());
        session.getTransactionsPage().getLastTransactionRow().click();
        Assertions.assertEquals(session.getTransactionsPage().getBillAmount().getText(),"$"+bills.getAmount());
        session.getTransactionsPage().getCloseTransactionPopupButton().click();
    }

    @Test(description = "PYMT2 : Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
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

        //Process Payment by Credit Card
        session.getPaymentsPage().getCreditCardBtn().click();
        session.getPaymentsPage().payByCreditCard();
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "PYMT3 : Bill Creation and Successful Bill Payment by Venmo through Store manager.")
    public void payByVenmoThroughStoreManager(){
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        //Create Bill
        String amt = "1,199.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getDashBoardPage().getBillButton().click();
        session.getBillPage().createBill(defaultBill);
        WebdriverWaits.sleep(5000);

        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
        session.getBillPage().getUnpaidBillButton().click();
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

        session.getPaymentsPage().getOthersButton().click();
        //Pay by Venmo
        session.getPaymentsPage().getVenmoButton().click();
        //Verify Payment done
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed()); 
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "PYMT4 : Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        //Create Bill
        String amt = "900.00";
        BillsPage defaultBill = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        session.getBillPage().createBill(defaultBill);
        WebdriverWaits.sleep(5000);

        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();

        // Verify popup title and elements of Receive Payment popup
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

        session.getPaymentsPage().getOthersButton().click();
        //Pay by Venmo
        session.getPaymentsPage().getZelleButton().click();
        //Verify Payment done
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "PYMT6 : Bill Creation and pay the bill by multiple payment mode through Store manager.")
    public void paymentByMultipleModeThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        String amt = "2,999.00";
        String updatedAmt1 = "500.00";
        String updatedAmt2 = "350.99";
        String updatedAmt3 = "1,000.00";
        BillsPage billsDetail = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);
        //Creating Bill
        session.getBillPage().createBill(billsDetail);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
        session.getBillPage().getUnpaidBillButton().click();

        session.getBillPage().getProcessPaymentButton().click();
        
        // Verify popup title and elements of Receive Payment popup
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
        //Update Receiving amount
        session.getPaymentsPage().getReceivingAmountTextbox().setText(updatedAmt1);
        session.getPaymentsPage().getOthersButton().click();

        //Verify Updated Amount on Payment Type Panel
        Assertions.assertEquals(session.getPaymentsPage().getReceivingAmountFromPaymentTypePanel().getText(),"$"+updatedAmt1);
        session.getPaymentsPage().getCashButton().click();

        //Verify Paid Amount
        float amount = Float.parseFloat(amt.replace(",", ""));
        float updateAmount1 = Float.parseFloat(updatedAmt1.replace(",", ""));
        float expBalanceDue1= amount - updateAmount1;
        String expectedBalanceDue1 = session.getBillPage().convertToNumberFormat(expBalanceDue1);
        WebdriverWaits.waitForElementInVisible(session.getPaymentsPage().paymentTypeHeader,5);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+updatedAmt1);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+expectedBalanceDue1);

        //Update Receiving amount
        session.getPaymentsPage().getAmountTextbox().setText(updatedAmt2);
        session.getPaymentsPage().getOthersButton().click();

        //Process payment through Venmo
        session.getPaymentsPage().getZelleButton().click();
        //Verify Total Paid Amount
        float updateAmount2 = Float.parseFloat(updatedAmt2.replace(",", ""));
        float expBalanceDue2= expBalanceDue1 - updateAmount2;
        String expectedBalanceDue2 = session.getBillPage().convertToNumberFormat(expBalanceDue2);
        float amtPaid2 = updateAmount1 + updateAmount2;
        String amountPaid2 = session.getBillPage().convertToNumberFormat(amtPaid2);
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amountPaid2);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+expectedBalanceDue2);

        //Update Receiving amount
        session.getPaymentsPage().getAmountTextbox().setText("$"+updatedAmt3);
        session.getPaymentsPage().getOthersButton().click();
        //Process payment through Venmo
        session.getPaymentsPage().getVenmoButton().click();
        //Verify Total Paid Amount
        float updateAmount3 = Float.parseFloat(updatedAmt3.replace(",", ""));
        float expBalanceDue3= expBalanceDue2 - updateAmount3;
        String expectedBalanceDue3 = session.getBillPage().convertToNumberFormat(expBalanceDue3);
        float amtPaid3 = updateAmount1 + updateAmount2 + updateAmount3;
        String amountPaid3 = session.getBillPage().convertToNumberFormat(amtPaid3);
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amountPaid3);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+expectedBalanceDue3);

        // Pay Remaining Amount
        session.getPaymentsPage().getCreditCardButton().click();
        session.getPaymentsPage().payByCreditCard();
        WebdriverWaits.sleep(8000);
        //Verify Total Paid Amount (Full Payment)
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed()); 
        session.getPaymentsPage().getCloseReceivedPopupButton().click();

        // Open Transaction
        session.getDashBoardPage().getTransactionButton().click();
        session.getTransactionsPage().selectStore("Automation Flow 1");
        session.getTransactionsPage().getLastTransactionRow().click();
        Assertions.assertEquals(session.getTransactionsPage().getBillAmount().getText(),"$"+billsDetail.getAmount());
        Assertions.assertTrue(session.getTransactionsPage().getUniqueTransactionId().isDisplayed());
        session.getTransactionsPage().getCloseTransactionPopupButton().click();
    }
    @Test(description = "PYMT5 : Bill Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        String amt = "1,499.00";
        String payAmt = "1,185.25";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();

        //Update Amount
        session.getPaymentsPage().getAmountTextbox().setText(payAmt);
        session.getPaymentsPage().getCreditCardButton().click();
        session.getPaymentsPage().payByCreditCard();

        //Verify Total Paid Amount
        float amount = Float.parseFloat(amt.replace(",",""));
        float updateAmount = Float.parseFloat(payAmt.replace(",", ""));
        float expBalanceDue= amount - updateAmount;
        String expectedBalanceDue = session.getBillPage().convertToNumberFormat(expBalanceDue);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+payAmt);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+expectedBalanceDue);
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
        session.getPaymentsPage().refreshPage();
//        Assertions.assertTrue(session.getBillPage().getPartialPaidLabel().isDisplayed());

    }

    @Test(description = "PYMT7 : Bill Creation and mark payment as Void by Store manager.")
    public void markSuccessfulPaymentAsVoid() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        String amt = "2,251.75";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
        session.getBillPage().getUnpaidBillButton().click();
        session.getBillPage().getProcessPaymentButton().click();
        // Process payment successfully
        session.getPaymentsPage().getOthersButton().click();
        session.getPaymentsPage().getZelleButton().click();
        //Verify payment
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());
        WebdriverWaits.sleep(2000);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        //Mark payment as void
        session.getPaymentsPage().getVoidButton().click();
        //Verify voided payment
        float amount = Float.parseFloat(amt.replace(",",""));
        float expVoidAmount= amount - amount;
        String expectedPaidTotal = session.getBillPage().convertToNumberFormat(expVoidAmount);
        WebdriverWaits.sleep(2000);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+expectedPaidTotal);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getVoidedTag().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getCreditCardBtn().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getOthersButton().isDisplayed());
        Assertions.assertEquals(session.getPaymentsPage().getReceivingAmount().getAttribute("value"),"$"+amt);

        session.getPaymentsPage().getCloseReceivedPopupButton().click();
        //Verify NotPaid label
        Assertions.assertEquals(session.getBillPage().getPaymentStatusOfLatestBill().getText(),"NOT PAID");

        //Deleting unpaid bill
        session.getBillPage().getNotPaidBill().click();
        session.getBillPage().getDeleteButton().click();
        session.getBillPage().getDeleteIcon().click();
    }

    @Test(description = "PYMT8 : Bill Creation and Successful Bill Payment through Credit Card by Customer.")
    public void BillPaymentByCreditCardThroughCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        String amt = "4999.00";

        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Login as Customer
        session.getLoginPage().performSignIn("yonro@yopmail.com", "Test@123");
        session.getNotificationPage().getNotificationIcon().click();
        session.getNotificationPage().getFirstNotification().click();
        session.getPaymentsPage().getPayNowButton().click();
        session.getPaymentsPage().getChangePaymentButton().click();
        session.getPaymentsPage().getSavedCreditCard().click();
        session.getPaymentsPage().swipeToPay();
    }
}