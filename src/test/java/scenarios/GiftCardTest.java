package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class GiftCardTest extends BaseTest {

    @Test(description = " GC01, GC02: Verify that user get directed to 'Gift Cards' page, after clicking on 'Gift Cards' tab, on  Left Panel.")
    public void VerifyUserDirectedToGiftCardPageAfterClickingGiftCardTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Click on My Stuff and then on Gift Card
        session.getSidePannel().getMyStuff().click();
        WebdriverWaits.sleep(3000);
        session.getSidePannel().getGiftCardTab().clickByMouse();

        //To get label
        String ActualLabel = session.getGiftCardPage().getGiftCardLabel().getText();
        Assertions.assertEquals(ActualLabel, Constants.ExpectedGiftCard);

        //To check the information displayed when there is no gift card
        String ActualNoGiftCardMsg = session.getGiftCardPage().getNoGiftCardMsg().getText();
        Assertions.assertEquals(ActualNoGiftCardMsg, Constants.ExpectedNoGiftCardMsg);

    }

    public void  VerifyGiftCardListedInGridViewWhenClickOnGiftCardTab()
    {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

    }
}
