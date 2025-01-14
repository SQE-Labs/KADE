package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class RewardsProgramPage extends BaseTest {

    @Test(description = "Verify that Rewards Program Page Opens")
    public void verifyRewardsProgramPageOpens() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();

        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getRewardsProgramHeading().isDisplayed());

    }
}
