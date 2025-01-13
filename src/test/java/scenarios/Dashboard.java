package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.objectBuilder.ObjectBuilder;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.pages.DashboardPage;
import org.automation.pages.TransactionsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Dashboard extends BaseTest {

    @Test(description=" DC01 & 2 Verify all sections are displayed on the 'Dashboard'")
    public void verifyALLSectionsOnDashboardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        // verifying the sections on the Dashboard Page
        //Your Business Section
        Assertions.assertTrue(Dashboard.getYourBusinessTitle().isDisplayed());
        String YourBusinessTitle= Dashboard.getYourBusinessTitle().getText();
        Assertions.assertEquals(YourBusinessTitle,"Your Businesses");

        //  Processed Payments
        Assertions.assertTrue(Dashboard.getProcessPaymentTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getProcessPaymentTitle().getText(),"Processed Payments");

        // Recent Transaction and Full Link
        Assertions.assertTrue(Dashboard.getRecentTransactionsTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getRecentTransactionsTitle().getText(),"Recent transactions");
        Assertions.assertTrue(Dashboard.getFullListLink().isDisplayed());

        //Customer
        Assertions.assertTrue(Dashboard.getCustomerTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getCustomerTitle().getText(),"Customers");

        //Today’s Payments
        Assertions.assertTrue(Dashboard.getTodayPaymentTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getTodayPaymentTitle().getText(),"Today’s Payments");

        //Messages and Contact Support link
        Assertions.assertTrue(Dashboard.getMessageTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getMessageTitle().getText(),"Messages");
        Assertions.assertTrue(Dashboard.getContactSupportLink().isDisplayed());

        // Customer Trends
        Assertions.assertTrue(Dashboard.getCustomerTrends().isDisplayed());
        Assertions.assertEquals(Dashboard.getCustomerTrends().getText(),"Customer Trends");

        //Payment Methods Popularity
        Assertions.assertTrue(Dashboard.getPaymentMethodPopularityTitle().isDisplayed());
        Assertions.assertEquals(Dashboard.getPaymentMethodPopularityTitle().getText(),"Payment Methods Popularitypast 30 days");
    }
    
    @Test(description = "DC03 & DC04 Verify that 'No. of stores' count appears under 'Your Businesses' section, on the 'Dashboard' page.")
    public void verifyNoOfCountAppearsUnderBusinessSection(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();

        // Verifying the store count from my store page.
        List <WebElement>storeCount= session.getDashboardPage().getmyStorescount().getListOfWebElements();
        int actualCount = storeCount.size();
        System.out.println(storeCount.size());

        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        // Verify the count of the store under 'Your business' tab.
        String value=session.getDashboardPage().getStoreCountUnderYourBusiness().getText();
        System.out.println(value);

        //  Verifying the store count
        Assertions.assertEquals(String.valueOf(storeCount.size()),value);

        // Verify popup opens up after clicking on the store count
        session.getDashboardPage().getStoreCountUnderYourBusiness().click();

        List<WebElement> storeNames = session.getDashboardPage().getListOfStoreNameonPopup().getListOfWebElements();
        System.out.println("list count : " +storeNames.size());

    }
    @Test(description = "DC05,06,07 : Verify that Processed Payments, No.of Customer Count and Today's Payment of All Stores")
    public void getVerifyThatProcessPaymentsNoofCustomerAndTodayPayment(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        // Verify the Process Payment of Last 30 days
        Assertions.assertTrue(Dashboard.getTotalAmountOfProcessPayment().isDisplayed());
        String valueA = Dashboard.getTotalAmountOfProcessPayment().getText();
        System.out.println("Process Payment of Last 30 days is: "+valueA);


        // Verify the  customer count of all stores displayed under Customer Section
        Assertions.assertTrue(Dashboard.getCountOfAllStoreCustomer().isDisplayed());
        String valueB = Dashboard.getCountOfAllStoreCustomer().getText();
        System.out.println("Total Count of last 30 days of all stores: "+valueB);

        // Verify that Today's Payment appears of  all stores under 'Today's Payment' section.
        Assertions.assertTrue(session.getDashboardPage().getTodayPayment().isDisplayed());
        String valueC = session.getDashboardPage().getTodayPayment().getText();
        System.out.println("Sum of Today's payment of all stores: "+valueC);
    }
    @Test(description=" DC08: Verify that user get directed to 'Messages' page after clicking on 'Contact Support' link under 'Messages' section, on 'Dashboard' page.")
    public void userGetDirectToMessagePage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        session.getDashboardPage().getContactSupportLink().click();
        Assertions.assertTrue(session.getDashboardPage().getMessagePage().isDisplayed());
    }

    @Test (description = "DC09,DC10, DC11 and DC 12: Verify that Recent transactions of all stores appear under 'Recent transactions' section, on 'Dashboard' page.")
    public void verifyThatRecentTransactionForAllStoreAppearsUnderRecentTransactionSection(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        TransactionsPage transactions = session.getTransactionsPage();
        String amt = "200.22";
        String customerEmail = "yonro@yopmail.com";
        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);

        //Creating Bill
        session.getBillPage().createBill(bills);
        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 3);

        //Logout as Store manager
        session.getSidePannel().getSignOutButton().clickByMouse();

        //Login as Customer
        session.getLoginPage().performSignIn(customerEmail, "Test@123");
        session.getNotificationPage().getNotificationIcon().click();
        session.getNotificationPage().getFirstNotification().click();
        WebdriverWaits.waitForElementClickable(session.getPaymentsPage().payNowButton,5);
        session.getPaymentsPage().getPayNowButton().click();
        String expectedTotalPayment = session.getBillPage().getActiveBillAmmount().getText();
        WebdriverWaits.waitForElementUntilVisible(session.getPaymentsPage().changeButton,3000);
        session.getPaymentsPage().getChangePaymentMethodButton().clickByMouse();
        try{
            WebdriverWaits.waitForElementVisible(session.getPaymentsPage().savedCreditcard,5);
        }
        catch (Exception e ) {
            session.getPaymentsPage().getChangePaymentMethodButton().clickByMouse();
        };
        session.getPaymentsPage().getSavedCreditCard().click();
        session.getPaymentsPage().swipeToPay();
        WebdriverWaits.waitForElementVisible(session.getPaymentsPage().closeBlueBtn,1000);
        session.getPaymentsPage().getBlueCloseButton().clickbyJS();

        // logout customer .
        session.getSidePannel().getSignOutButton().clickByMouse();
        WebdriverWaits.fluentWait_ElementIntactable(2000, 500, session.getLoginPage().userNameField);

        // login as store manager
        session.getLoginPage().performSignIn("6465551114", "Test@123");


        // got to transaction Page .
        session.getSidePannel().getTransactionButton().click();
        transactions.selectStore(bills.getStore());

        // Payment Amount
        String Payment = transactions.getTransactionAmmount().getText();
        System.out.println(Payment);

        // Customer Name
        transactions.getLastTransactionRow().click();
        String CustomerName = transactions.getCustomeName().getText();
        System.out.println(CustomerName);
        String Time= transactions.getTimeOnTransactionPage().getText();
        System.out.println(Time);
        transactions.getCloseTransactionPopupButton().click();

        //Clicking on the Dashboard Tab
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        // Verifying the recent Transaction.
        Assertions.assertEquals(Dashboard.getCustomerNameUnderRTSection().getText(),CustomerName);
        Assertions.assertEquals(Dashboard.getRecentRTAmount().getText(),Payment);
        Assertions.assertEquals(Dashboard.getRecentRTTime().getText(),Time);

        // Verify that user is able to refresh the transaction list
        Dashboard.getRefreshIcon().click();

        // Verify that Compelete transaction popup appears after clicking on any  Transaction.
        Dashboard.getCustomerNameUnderRTSection().clickByMouse();
        WebdriverWaits.waitForElementInVisible(Dashboard.transactionPopup,3);
        Assertions.assertTrue(Dashboard.getTransactionPopupUnderRT().isDisplayed());
        Dashboard.getRTpopupCrossIcon().click();

        // Verify that user gets directed to the 'Transactions' page after clicking on 'Full List' link.
        Dashboard.getFullListLink().click();
    }

    @Test(description = "DC 18, 19 & 20,21,22 &23: Verify that user get directed to 'Dashboard' page of store after selecting store, on 'No. of stores' popup, under 'Your Businesses' section.")
        public void verifyThatDirectedToDashboardPageOfSelectedStore(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        DashboardPage Dashboard = new DashboardPage();
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getDashboardTab().click();

        // Clicking on the first store from the Store Popups
       Dashboard.getStoreCountUnderYourBusiness().click();
       Dashboard.getFirstStoreUnderYourBusiness().click();

       // Clicking on the your business link to get redirected to the All stores dashboard page.
        Dashboard.getYourBusinessLink().click();
        Dashboard.getStoreCountUnderYourBusiness().click();
        Dashboard.getFirstStoreUnderYourBusiness().click();

        // Verify the Process Payment of Last 30 days
        Assertions.assertTrue(Dashboard.getTotalAmountOfProcessPayment().isDisplayed());
        String valueA = Dashboard.getTotalAmountOfProcessPayment().getText();
        System.out.println("Process Payment of Last 30 days is: "+valueA);


        // Verify the  customer count of all stores displayed under Customer Section
        Assertions.assertTrue(Dashboard.getCountOfAllStoreCustomer().isDisplayed());
        String valueB = Dashboard.getCountOfAllStoreCustomer().getText();
        System.out.println("Total Count of last 30 days of a stores: "+valueB);

        // Verify that Today's Payment appears of  all stores under 'Today's Payment' section.
        Assertions.assertTrue(session.getDashboardPage().getTodayPayment().isDisplayed());
        String valueC = session.getDashboardPage().getTodayPayment().getText();
        System.out.println("Sum of Today's payment of a stores is : "+valueC);


        Dashboard.getSettingIcon().click();
        // Verify that store Configuration page title
        Assertions.assertTrue(Dashboard.getStoreConfigurationTitle().isDisplayed());
        Dashboard.getDriver().navigate().back();

        // Verify that user gets directed to message page of the same store.
        Dashboard.getContactSupportLink().click();


    }

}
