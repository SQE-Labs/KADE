package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.DashboardPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Dashboard extends BaseTest {

    @Test(description=" DC01&2 Verify that following sections are displayed, on the 'Dashboard'")
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
    
    @Test(description ="DC04 Verify that 'No. of stores' count appears under 'Your Businesses' section, on the 'Dashboard' page.")
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
        Assertions.assertTrue(session.getDashboardPage().getTotalAmountOfProcessPayment().isDisplayed());
        String valueA = session.getDashboardPage().getTotalAmountOfProcessPayment().getText();
        System.out.println("Process Payment of Last 30 days is: "+valueA);


        // Verify the  customer count of all stores displayed under Customer Section
        Assertions.assertTrue(session.getDashboardPage().getCountOfAllStoreCustomer().isDisplayed());
        String valueB = session.getDashboardPage().getCountOfAllStoreCustomer().getText();
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

}
