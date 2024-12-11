package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.DashboardPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.Test;

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

}
