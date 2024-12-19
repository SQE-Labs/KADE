package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {

    @Test(description = "Verify that Store's customers page opens up displaying all the options")
    public void storeCustomersPage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        Assertions.assertTrue(session.getCustomersPage().nameAddress().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().findAddCustomer().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().filter().isDisplayed());
    }

    @Test(description = "Adding a new customer with Phone number")
    public void addCustomerWithPhoneNumber() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();



    }
}
