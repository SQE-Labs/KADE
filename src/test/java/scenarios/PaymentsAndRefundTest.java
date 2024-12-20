package scenarios;

import org.automation.data.KadeUserAccount;
import org.automation.data.StoreAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.automation.session.KadeSession;


public class PaymentsAndRefundTest extends KadeSession {

    @Test(description = "PYMT1 Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String amt = "1,199.01";
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getSidePannel().getBillButton().click();
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);

        //Click on the bill created
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = session.getBillPage().getBillPopupHeader().getText();
        Assertions.assertEquals(expectedPopupHeader,"Bill");
        WebdriverWaits.waitForElementVisible(By.xpath("//span[text()='QR Code']"),2000);
        Assertions.assertTrue(session.getBillPage().getQRCodeButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getShareButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getEditBillButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getProcessPaymentButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getDeleteButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getUniqueReferenceNumber().isDisplayed());
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
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
        session.getSidePannel().getTransactionButton().click();
        session.getTransactionsPage().selectStore(bills.getStore());
        session.getTransactionsPage().getLastTransactionRow().clickByMouse();
        Assertions.assertEquals(session.getTransactionsPage().getBillAmount().getText(),"$"+bills.getAmount());
        session.getTransactionsPage().getCloseTransactionPopupButton().click();
    }

    @Test(description = "PYMT2 : Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
    public void cardPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Create Bill
        String amt = "2,499.00";
        String customerEmail = "yonro@yopmail.com";
        BillsPage billsDetails= ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getSidePannel().getBillButton().click();
        session.getBillPage().createBill(billsDetails);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);
        //Open Bill Details popup
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();
        WebdriverWaits.waitForElementVisible(By.xpath("//span[text()='Bill']"),2000);

        //Verify all the WebElements on Bill popup
        String expectedPopupHeader = session.getBillPage().getBillPopupHeader().getText();
        Assertions.assertEquals(expectedPopupHeader,"Bill");
        WebdriverWaits.waitForElementVisible(By.xpath("//span[text()='QR Code']"),2000);
        Assertions.assertTrue(session.getBillPage().getQRCodeButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getShareButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getEditBillButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getProcessPaymentButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getDeleteButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getUniqueReferenceNumber().isDisplayed());
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
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getSidePannel().getBillButton().click();
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();
        WebdriverWaits.sleep(3000);
        session.getBillPage().getProcessPaymentButton().click();
        WebdriverWaits.fluentWait_ElementIntactable(3000, 500,By.xpath("//h5[text()='Receive Payment']"));

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
        WebdriverWaits.sleep(2000);
        //Verify Payment done
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed()); 
        session.getPaymentsPage().getCloseReceivedPopupButton().click();
    }

    @Test(description = "PYMT4 : Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        //Create Bill
        String amt = "900.00";
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);

        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();
        WebdriverWaits.sleep(3000);
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
    public void verifyPaymentByMultipleModeThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();

        String amt = "2,999.01";
        String updatedAmt1 = "500.00";
        String updatedAmt2 = "350.99";
        String updatedAmt3 = "1,000.00";
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);
        WebdriverWaits.sleep(3000);
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();

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

        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().totalPaidAmt,5);
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
//        WebdriverWaits.waitForElementUntilVisible(session.getPaymentsPage().totalPaidAmt,5);
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
//        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().totalPaidAmt,5);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amountPaid3);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+expectedBalanceDue3);

        // Pay Remaining Amount
        session.getPaymentsPage().getCreditCardButton().click();
        session.getPaymentsPage().payByCreditCard();
        WebdriverWaits.sleep(3000);

        //Verify Total Paid Amount (Full Payment)
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed()); 
        session.getPaymentsPage().getCloseReceivedPopupButton().click();

        // Open Transaction
        session.getSidePannel().getTransactionButton().click();
        session.getTransactionsPage().selectStore(StoreAccount.AutomationBillFlow);
        session.getTransactionsPage().getLastTransactionRow().click();
        Assertions.assertEquals(session.getTransactionsPage().getBillAmount().getText(),"$"+bills.getAmount());
        Assertions.assertTrue(session.getTransactionsPage().getUniqueTransactionId().isDisplayed());

        session.getTransactionsPage().getCloseTransactionPopupButton().click();
    }
    @Test(description = "PYMT5 : Bill Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        String amt = "1,499.00";
        String payAmt = "1,155.25";
        String customerEmail= "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();
        WebdriverWaits.waitForElementVisible(session.getBillPage().processPaymentBtn,3);

        session.getBillPage().getProcessPaymentButton().clickByMouse();
        WebdriverWaits.waitForElementClickable(getPaymentsPage().receiveAmountTbx,5);

        //Update Amount
        session.getPaymentsPage().getAmountTextbox().setText(payAmt);
        WebdriverWaits.waitForElementClickable(session.getPaymentsPage().creditCardBtn,5);
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
        WebdriverWaits.sleep(1000);
        session.getPaymentsPage().refreshPage();
        WebdriverWaits.sleep(2000);
        Assertions.assertEquals(session.getBillPage().getPaymentStatusOfLatestBill().getText(),"PARTIAL");
    }

    @Test(description = "PYMT7 : Bill Creation and mark payment as Void by Store manager.")
    public void markSuccessfulPaymentAsVoid() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        String amt = "2,251.75";
        String customerEmail="yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);
        session.getBillPage().getUnpaidBillWithoutDescription().clickByMouse();
        WebdriverWaits.waitForElementClickable(getBillPage().processPaymentBtn,3);
        session.getBillPage().getProcessPaymentButton().clickbyJS();
        // Process payment successfully
        session.getPaymentsPage().getOthersButton().click();
        session.getPaymentsPage().getZelleButton().click();
        //Verify payment
        Assertions.assertTrue(session.getPaymentsPage().getPaidLabel().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getPaymentLogo().isDisplayed());
        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().totalPaidAmt,5);
        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getVoidButton().isDisplayed());
        //Mark payment as void
        session.getPaymentsPage().getVoidButton().click();

        //Verify voided payment
        float amount = Float.parseFloat(amt.replace(",",""));
        float expVoidAmount= amount - amount;
        String expectedPaidTotal = session.getBillPage().convertToNumberFormat(expVoidAmount);
        WebdriverWaits.sleep(3000);

        Assertions.assertEquals(session.getPaymentsPage().getTotalPaidAmount().getText().split(":")[1],"$"+expectedPaidTotal);
        Assertions.assertEquals(session.getPaymentsPage().getBalanceDue().getText(),"$"+amt);
        Assertions.assertTrue(session.getPaymentsPage().getVoidedTag().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getCreditCardBtn().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getOthersButton().isDisplayed());
        Assertions.assertEquals(session.getPaymentsPage().getReceivingAmount().getAttribute("value"),"$"+amt);

        session.getPaymentsPage().getCloseReceivedPopupButton().click();
        //Verify NotPaid label
        Assertions.assertEquals(session.getBillPage().getPaymentStatusOfLatestBill().getText(),"NOT PAID");
    }

    @Test(description = "PYMT8 : Bill Creation and Successful Bill Payment through Credit Card by Customer.")
    public void BillPaymentByCreditCardThroughCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        String amt = "4999.00";

        String customerEmail ="yonro@yopmail.com" ;
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,3);

        //Logout as Store manager
        session.getSidePannel().getSignOutButton().clickByMouse();
        WebdriverWaits.fluentWait_ElementIntactable(2000, 500, session.getLoginPage().userNameField);

        //Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");
        session.getNotificationPage().getNotificationIcon().clickByMouse();
        session.getNotificationPage().getFirstNotification().click();
        session.getPaymentsPage().getPayNowButton().click();
        session.getPaymentsPage().getChangePaymentButton().clickbyJS();
        WebdriverWaits.waitForElementClickable(session.getPaymentsPage().savedCreditcard,7);
        session.getPaymentsPage().getSavedCreditCard().clickByMouse();
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.waitForElementClickable(session.getPaymentsPage().closeBlueBtn,3);
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();
    }

    @Test(description = "PYMT9 : Bill Creation and Successful Bill Payment through Bank account by Customer.")
    public void BillPaymentByCustomerThroughBankAccount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'Bill' sub-Tab
        session.getSidePannel().getBillButton().click();

        //Step 2: Enter Amount
        String amt = "4999.00";

        //Step 3: Enter Customer Email
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Step 4: Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Step 5: Logout as Store manager
        session.getSidePannel().getSignOutButton().clickByMouse();
        WebdriverWaits.fluentWait_ElementIntactable(2000, 500, By.cssSelector("[name='userName']"));

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
        WebdriverWaits.retryClick(session.getPaymentsPage().changeButton, 2);


        //Step 11: Select 'Bank Account' Method
        session.getPaymentsPage().getSavedBankAccount().clickbyJS();

//        WebdriverWaits.retryClick(session.getPaymentsPage().savedBankAccount,2);

//     WebdriverWaits.waitForElementClickable(session.getPaymentsPage().savedBankAccount,5);
        //Verify that Selected Bank Method is Displayed
//        Assertions.assertTrue(session.getPaymentsPage().getSelectedBankDisplay().isDisplayed());

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
    }

    @Test(description = "PYMT11 :Reject a Bill by customer")
    public void RejectingABillByCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        //Step 1: Click on 'Bill' sub-Tab
        session.getSidePannel().getBillButton().click();

        //Step 2: Enter Amount
        String amt = "4999.00";

        //Step 3: Enter Customer Email
        String customerEmail ="yonro@yopmail.com" ;
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Step 4: Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Step 5: Logout as Store manager
        session.getSidePannel().getSignOutButton().clickByMouse();
        WebdriverWaits.fluentWait_ElementIntactable(2000, 500, By.cssSelector("[name='userName']"));

        //Step 6: Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");

        //Step 7: Click on 'Notifications' Icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 8: Click on first notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 9: Click on 'Reject' button
        session.getPaymentsPage().getRejectButton().click();

        //Verifying Confirmation Pop-Up Title
        Assertions.assertEquals(session.getPaymentsPage().getConfirmationPopUpTitle().getText(),"Confirmation");

        //Step 10: Select any Reason
        session.getPaymentsPage().getRejectReason().click();

        //Step 11: Click on 'Submit' Button
        session.getPaymentsPage().getSubmitButton().click();

        //Verifying the success Message
        Assertions.assertEquals(session.getPaymentsPage().getRejectToastMessage().getText(),"Bill has been rejected successfully");
    }
   /* @Test(description="PYMT12:Bill Payment by Customer through Credit Card, Pay more amount after paying full bill")
    public void BillPaymentByCustomerThroughCreditCardPayMoreAmountAfterFullBillPayment() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'Bill' sub-Tab
        session.getDashBoardPage().getBillButton().click();

        //Step 2: Enter Amount
        String amt = "500.00";

        //Step 3: Enter Customer Email
        String customerEmail ="yonro@yopmail.com" ;
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Step 4: Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Step 5: Logout as Store manager
        session.getDashBoardPage().getSignOutButton().click();

        //Step 6: Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");

        //Step 7: Click on 'Notification' icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 8: Click on first Notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 9: Click on 'Pay Now' Button
        session.getPaymentsPage().getPayNowButton().click();

        //Step 10: Click on 'Change' Button
        session.getPaymentsPage().getChangePaymentMethodButton().click();

        //Step 11: Select Credit Card
        session.getPaymentsPage().getSavedCreditCard().click();

        //Step 12: Swipe To Pay Full Amount
        session.getPaymentsPage().swipeToPay();
        session.getPaymentsPage().scrollToBottomPage();

        //Step 13: Close the Pop-up
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();

        //Step 14: Click on 'Notification' icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 15: Click on First Notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 16: Click on 'Pay Now' Button
        session.getPaymentsPage().getPayNowButton().click();
        session.getPaymentsPage().scrollToBottomPage();
        WebdriverWaits.sleep(5000);

        //Step 17: Click on 'Tap to Pay More' link
        session.getPaymentsPage().getTapToPayMoreLink().clickbyJS();

        //Step 18: Click on 'Swipe to Pay' field
        session.getPaymentsPage().getSwipeToPayButton().clickbyJS();

        //Step 19: Enter Amount
        session.getPaymentsPage().getMoreAmountField().setText("100.00");

        //Step 20: Click on 'Update' Button
        session.getPaymentsPage().getAmountUpdateButton().click();

        //Step 21: Swipe to Pay more Amount
        session.getPaymentsPage().swipeToPay();

        //Step 22: Click on 'Close' button
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();
    }

    */


}

