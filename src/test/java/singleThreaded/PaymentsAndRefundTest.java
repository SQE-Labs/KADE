package singleThreaded;

import org.automation.base.BasePage;
import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;

public class PaymentsAndRefundTest extends BasePage {
    @Test(description = "PYMT13 : Create Bill for a customer and pay using Venmo.")
    public void pyCreateBillForCustomerPayUsingVenmo () throws AWTException {
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
        session.getSidePannel().getSignOutButton().click();

        //Step 6: Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");

        //Step 7: Click on Notification icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 8: click on first notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 9: click 'pay now' button
        session.getPaymentsPage().getPayNowButton().click();

        //Step 10: Click on 'Change Payment' Button
        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();
        WebdriverWaits.sleep(2000);
        //Step 11:  Selecting Venmo Card
        session.getPaymentsPage().getSavedVenmoCard().clickByMouse();
        //Verifying that Venmo PopUp is displayed
        Assertions.assertTrue(session.getPaymentsPage().getVenmoPopup().isDisplayed());

        //Verifying that Copy link is visible
        Assertions.assertTrue(session.getPaymentsPage().getCopyLink().isDisplayed());

        //Verifying that 'Made my Payment' button is visible
        Assertions.assertTrue(session.getPaymentsPage().getIMadeMyPaymentButton().isDisplayed());

        //Step 12: Click on 'Made my Payment' Button
        session.getPaymentsPage().getIMadeMyPaymentButton().clickbyJS();

        //Verifying that Venmo Payment Text is displayed
        Assertions.assertTrue(session.getPaymentsPage().getVenmoPaymentText().isDisplayed());

        //Step 13: Enter Text
        session.getPaymentsPage().getVenmoPaymentText().setText("Paid the bill");

        //Verify that Screenshot button is Displayed
        Assertions.assertTrue(session.getPaymentsPage().getScreenshotButton().isDisplayed());

        //Step 14: Upload Screenshot
        session.getPaymentsPage().getScreenshotButton ().click();
        session.getPaymentsPage().uploadVenmoImageScreenshot();
        session.getPaymentsPage().getCheckButton().click();

        //Verify that attached image is displayed
        Assertions.assertTrue(session.getPaymentsPage().getUploadedImage().isDisplayed());
        WebdriverWaits.sleep(2000);

        //Step 15: Click on 'Confirm Venmo' Checkbox
        session.getPaymentsPage().getConfirmVenmoCheckbox().click();

        //Step 16: Click on 'Submit' Button
        session.getPaymentsPage().getVenmoSubmitButton().click();

        //Step 17: Click on 'Close' Icon
        session.getPaymentsPage().getCloseButton().clickbyJS();
    }

    @Test(description = "PYMT15 : Create Bill for a customer and pay using Zelle.")
    public void CreateBillForCustomerAndPayUsingZelle() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();

        String amt = "4,999.00";
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 2);

        //Logout as Store manager
        session.getSidePannel().getSignOutButton().click(); // Signing out
        WebdriverWaits.sleep(3000);

        //Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");
        session.getNotificationPage().getNotificationIcon().click(); // Click on Notification icon
        session.getNotificationPage().getFirstNotification().click(); // click on first bill notification
        session.getPaymentsPage().getPayNowButton().click(); // click paynow button
        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();
        WebdriverWaits.sleep(3000);
        session.getPaymentsPage().getSavedZelleCard().clickbyJS();
        WebdriverWaits.sleep(3000);
        Assertions.assertTrue(session.getPaymentsPage().getZellePopup().isDisplayed());
        Assertions.assertTrue(session.getPaymentsPage().getZelleCopyLink().isDisplayed());
        session.getPaymentsPage().getIMadeMyPaymentButton().click();
        Assertions.assertTrue(session.getPaymentsPage().getVenmoPaymentText().isDisplayed());

        //Step 13: Enter Text
        session.getPaymentsPage().getVenmoPaymentText().setText("Paid the bill");

        //Verify that Screenshot button is Displayed
        Assertions.assertTrue(session.getPaymentsPage().getScreenshotButton().isDisplayed());

        //Step 14: Upload Screenshot
        session.getPaymentsPage().getScreenshotButton ().click();
        session.getPaymentsPage().uploadVenmoImageScreenshot();
        session.getPaymentsPage().getCheckButton().clickbyJS();

        //Verify that attached image is displayed
        Assertions.assertTrue(session.getPaymentsPage().getUploadedImage().isDisplayed());
        WebdriverWaits.sleep(2000);

        //Step 15: Click on 'Confirm Venmo' Checkbox
        session.getPaymentsPage().getConfirmVenmoCheckbox().click();

        //Step 16: Click on 'Submit' Button
        session.getPaymentsPage().getVenmoSubmitButton().click();
        WebdriverWaits.sleep(3000);

        //Step 17: Click on 'Close' Icon
        session.getPaymentsPage().getCloseButton().clickbyJS();
    }
    @Test(description = "PYMT10 :Create Bill and Pay Bills Partially/Multiple payment type")
    public void BillPaymentByVariousPaymentMethods() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'Bill' sub-Tab
        session.getSidePannel().getBillButton().click();

        //Step 2: Enter Amount
        String amt = "3000.00";

        //Step 3: Enter Customer Email
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Step 4: Create Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);

        //Step 5: Logout as Store manager
        session.getSidePannel().getSignOutButton().click();
        WebdriverWaits.sleep(3000);

        //Step 6: Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");

        //Step 7: Click on Notification Icon
        session.getNotificationPage().getNotificationIcon().click();

        //Step 8: Click on First Notification
        session.getNotificationPage().getFirstNotification().click();

        //Step 9: Click on 'Pay Now' Button
        session.getPaymentsPage().getPayNowButton().click();

        //Step 10: Click on 'Swipe to Pay; field
        session.getPaymentsPage().getSwipeToPayButton().click();
        WebdriverWaits.waitForElementUntilVisible(By.xpath("//input[@lbl-title='Amount']"),5);

        //Step 11: Enter Amount
        session.getPaymentsPage().getMoreAmountField().setText("1000.00");

        //Step 12: Click on 'Update' Button
        session.getPaymentsPage().getAmountUpdateButton().click();

        //Step 13: Swipe to Pay the Partial Amount
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.sleep(5000);

        //Step 14: Click on 'Swipe to Pay' field
        session.getPaymentsPage().getSwipeToPayButton().clickbyJS();
        WebdriverWaits.sleep(2000);

        //Step 15: Enter Amount
        session.getPaymentsPage().getMoreAmountField().setText("1000.00");

        //Step 16: Click on 'Update' Button
        session.getPaymentsPage().getAmountUpdateButton().clickByMouse();
        WebdriverWaits.sleep(2000);

        //Step 17: Click on 'Change' Button
        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();

        //Step 18: Select the 'Bank Account' Method
        session.getPaymentsPage().getSavedBankAccount().clickbyJS();

        //Step 19: Swipe to Pay the Partial amount
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.sleep(5000);

        //Step 20: Click on 'Swipe to pay' field
        session.getPaymentsPage().getSwipeToPayButton().clickbyJS();
        WebdriverWaits.sleep(5000);

        //Step 21: Enter Amount
        session.getPaymentsPage().getMoreAmountField().setText("1000.00");

        //Step 22: Click on 'Update' Button
        session.getPaymentsPage().getAmountUpdateButton().click();
        WebdriverWaits.sleep(2000);

        //Step 23: Click on 'Change' Button
        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();
        //Step 24: Select 'Venmo' Method
        WebdriverWaits.sleep(2000);
        session.getPaymentsPage().getSavedVenmoCard().clickbyJS();
        WebdriverWaits.sleep(2000);

        //Verifying that Venmo PopUp is displayed
        Assertions.assertTrue(session.getPaymentsPage().getVenmoPopup().isDisplayed());

        //Verifying that Copy link is visible
        Assertions.assertTrue(session.getPaymentsPage().getCopyLink().isDisplayed());

        //Verifying that 'Made my Payment' button is visible
        Assertions.assertTrue(session.getPaymentsPage(). getIMadeMyPaymentButton().isDisplayed());

        //Step 25: Click on 'Made my Payment' Button
        session.getPaymentsPage().getIMadeMyPaymentButton().clickbyJS();

        //Verifying that Venmo Payment Text is displayed
        Assertions.assertTrue(session.getPaymentsPage().getVenmoPaymentText().isDisplayed());

        //Step 26: Enter Text
        session.getPaymentsPage().getVenmoPaymentText().setText("Paid the bill");

        //Verify that Screenshot button is Displayed
        Assertions.assertTrue(session.getPaymentsPage().getScreenshotButton().isDisplayed());

        //Step 27: Upload Screenshot
        session.getPaymentsPage().getScreenshotButton ().click();
        session.getPaymentsPage().uploadVenmoImageScreenshot();
        session.getPaymentsPage().getCheckButton().clickbyJS();

        //Verify that attached image is displayed
        Assertions.assertTrue(session.getPaymentsPage().getUploadedImage().isDisplayed());
        WebdriverWaits.sleep(2000);

        //Step 28: Click on 'Confirm Venmo' Checkbox
        session.getPaymentsPage().getConfirmVenmoCheckbox().clickbyJS();

        //Step 29: Click on 'Submit' Button
        session.getPaymentsPage().getVenmoSubmitButton().click();

        //Step 30: Click on 'Close' Icon
        session.getPaymentsPage().getCloseButton().click();
    }

}

