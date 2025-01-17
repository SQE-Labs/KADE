package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BillPage;
import org.automation.pages.SidePannel;
import org.automation.pages.popups.SearchPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test(description = "Verify that 'Search' popup appears after clicking on 'Search' tab, on Left Panel.")
    public void verifySearchPopupAppearsAfterClickingSearchTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);
        session.getSidePannel().getSearchTab().click();
        Assertions.assertTrue(session.getSearchPage().SearchPopup().isDisplayed());

    }
}
