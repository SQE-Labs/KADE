package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class RewardPointsTest extends BaseTest {

    @Test(description = "Verify that rewards points page opens up")
    public void verifyRewardsPointsPageOpens() {

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        Assertions.assertTrue(session.getRewardPointsPage().getRewardCard().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getAlertMsgHours().isDisplayed());
    }

    @Test(description = "Verify that '<Store-Name>' Reward Point cards contain appropriate details")
    public void verifyRewardCardDetails() {

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        Assertions.assertTrue(session.getRewardPointsPage().getStoreNameOnCard().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getRewardPointsOnCard().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getRedeemLinkOnCard().isDisplayed());
    }

    @Test(description = "Verify that appropriate details appears under store Information page")
    public void verifyStoreInfoPageDetails() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        session.getRewardPointsPage().getStoreNameOnCard().click();
        Assertions.assertTrue(session.getRewardPointsPage().getStoreInfoTitle().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getContactInfoCard().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getRecentTransaction().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getCustomerSince().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getEarnedRewardPoints().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getContactNumber().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getStoreAddress().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getStoreURL().isDisplayed());
    }

    @Test(description = "Verify that user gets directed to 'Reward Points Detail' page, after clicking on '<Total Reward Point Earned>' link,")
    public void verifyRewardPointsDetails() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        session.getRewardPointsPage().getRewardPointsOnCard().click();
        Assertions.assertTrue(session.getRewardPointsPage().getPointsTable().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getRewardPointsDetailTitle().isDisplayed());
    }

    @Test(description = "Verify that user get directed to 'Redeem Reward Points To Gift Card' page, after clicking on 'Redeem Points' link")
    public void verifyRedeemNowPg() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        session.getRewardPointsPage().getRedeemLinkOnCard().click();
        Assertions.assertTrue(session.getRewardPointsPage().getTotalRewardPoints().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getInfoMsgOnRedeemLink().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getCustomGiftCardToggleBtn().isDisplayed());
        Assertions.assertTrue(session.getRewardPointsPage().getClaimGiftCard().isDisplayed());
    }

    @Test(description = "verify Custom gift card slider appears after toggling 'Custom Gift Card' button")
    public void verifyCustomGiftCardSlider() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getMyStuff().click();
        session.getSidePannel().getRewardsPointsPage().click();

        session.getRewardPointsPage().getRedeemLinkOnCard().click();
        session.getRewardPointsPage().getCustomGiftCardToggleBtn().click();
        Assertions.assertTrue(session.getRewardPointsPage().getPointsToRedeem().isDisplayed());

        session.getRewardPointsPage().pointsToRedeemSlider();
        System.out.println(session.getRewardPointsPage().getEligibleGiftCardAmt().getText());
    }

}
