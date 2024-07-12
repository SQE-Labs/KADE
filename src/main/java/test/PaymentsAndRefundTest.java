package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ParameterMetaData;

public class PaymentsAndRefundTest extends BaseTest {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();
    NotificationsPage notification = new NotificationsPage();
    PaymentsPage payments = new PaymentsPage();

    @BeforeMethod
    public void loginApplication() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test
    public void cashPaymentByCustomerThroughStoreManager(){
        dashboard.clickOnBill();
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        String amt = "1,999.00";
        bill.createBill(amt,"918877070727");
        bill.closeLogoConfigPopup();

        bill.clickUnpaidBill();
        bill.clickProcessPaymentBtn();

        // Verify popup title
        String actualTitle = payments.getReceivedPaymentTitle();
        Assertions.assertEquals(actualTitle,"Receive Payment");

        payments.clickOthersBtn();
        payments.clickCashBtn();

        Assertions.assertTrue(payments.isPaidLabelDisplayed());

        payments.closeReceivedPopup();


//
//        //Sign out as Store Manager
//        dashboard.signOut();
//
//        //Login as Customer
//        login.performSignIn("+918877070727", "Test@123");
//        notification.clickNotificationIcon();
//        notification.clickNotificationByIndex("1");




    }
}
