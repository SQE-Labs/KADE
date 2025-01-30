package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class RewardPointsTest extends BaseTest {

    @Test(description = "RP01, RP02, RP03 : Verify that user get directed to 'Reward Points' page, after clicking on 'Reward Points' tab & correct message appears.")
    public void VerifyUserDirectedToRewardPointsPageAndCorrectMessageDisplaysAfterClickingRewardPointsTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.SearchUser);

        //Click on My Stuff and then on Reward Points
        session.getSidePannel().getMyStuff().clickbyJS();
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getRewardPointsTab().clickbyJS();

        //To get label
        String ActualRewardPointsLabel = session.getRewardPointsPage().getRewardPointsLabel().getText();
        Assertions.assertEquals(ActualRewardPointsLabel, Constants.ExpectedRewardPointsLabel);

        //To get Message
        String ActualRewardPointsMessage = session.getRewardPointsPage().getRewardPointsMessage().getText();
        Assertions.assertEquals(ActualRewardPointsMessage, Constants.ExpectedRewardPointsMessage);

        //To get No Reward Points Message
        String ActualNoRewardPointsMessage = session.getRewardPointsPage().getNoRewardPointsMessage().getText();
        Assertions.assertEquals(ActualNoRewardPointsMessage,Constants.ExpectedNoRewarPointsMessage);

    }

    @Test(description = "Verify that Reward Points get added on 'Reward points' page, after 24 hours of payment made through mobile applicaton.")
    public void VerifyRewardPointsAddedAfter24Hours() {
        KadeSession session = KadeSession.login(KadeUserAccount.Customer);

        // Navigate to the payment history
        session.getRewardPointsPage().getClickPayHistoryTransaction().clickByMouse();
        WebdriverWaits.sleep(3000);
        session.getRewardPointsPage().hourdifference();
        session.getRewardPointsPage().getClickRewardPoints().click();
        session.getRewardPointsPage().getClickOnPoints().click();



    }

}
