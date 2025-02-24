package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class RewardsProgramTest extends BaseTest {

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

    @Test(description = "Verify that information message appears, when Rewards program is not configured for store.")
    public void verifyInformationMessageAppears() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        Assertions.assertTrue(session.getRewardsProgramPage().getInfoMsgReardsConfig().isDisplayed());
    }

    @Test(description = "Verify that 'Rewards Program Configuration' popup opens up")
    public void verifyRewardsProgramConfigOpens() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getSettingsBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getRewardsProgPopupTitle().isDisplayed());
        session.getRewardsProgramPage().getToggleDisabled().click();
        session.getRewardsProgramPage().getSaveChangesBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getRewardsActivationMsg().isDisplayed());

        session.getRewardsProgramPage().getSettingsBtn().click();
        session.getRewardsProgramPage().getToggleEnabled().click();
        session.getRewardsProgramPage().getSaveChangesBtn().click();

    }

    @Test(description = "Verify Customer profile page opens up after clicking on the customer name")
    public void verifyCustProfileOpens() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getCustomerName().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getCustCardTitle().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getRewardsPointsTitle().isDisplayed());
    }

    @Test(description = "Verify that user gets directed to 'Reward Points Detail' page")
    public void verifyRewardsPointsDetailPageOpens() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getRewardsPntsLink().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getRewardsPtsPgTitle().isDisplayed());
        session.getRewardsProgramPage().getAddNewRowBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getMemoInputField().isDisplayed());
        //Leave fields blank
        session.getRewardsProgramPage().getAddBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getAlertMsg().isDisplayed());
        Assertions.assertEquals(session.getRewardsProgramPage().getMemoInputField().getToolTipMessage(), Constants.requiredFieldValidation);
        Assertions.assertEquals(session.getRewardsProgramPage().getPointsInputField().getToolTipMessage(), Constants.requiredFieldValidation);

        session.getRewardsProgramPage().getMemoInputField().setText("Memo");
        session.getRewardsProgramPage().getPointsInputField().setText("100");
        session.getRewardsProgramPage().getAddBtn().click();

    }

    @Test(description = "Verify Filter functionality")
    public void verifyFilterFunctionality() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getPartialUsername().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getUserPhnEmail().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getLastVisit().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getCustSince().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getMinRewardsPts().isDisplayed());
        Assertions.assertTrue(session.getRewardsProgramPage().getMaxRewardPts().isDisplayed());

    }

    @Test(description = "Verify relevent record appears on searching using Username")
    public void verifyUsernameFieldFunc() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getPartialUsername().setText("yonro");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getPartialUsername().setText("Jonro");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());
    }

    @Test(description = "Verify relevant record appears on searching using Customer Phone/Email filter field")
    public void verifyUserPhnEmailFieldFunc() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getUserPhnEmail().setText("+2222 223 3333");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 30);

        session.getRewardsProgramPage().getFilterBtn().clickByMouse();
        WebdriverWaits.waitForElementVisible(session.getRewardsProgramPage().userPhnEmail,20);
        session.getRewardsProgramPage().getUserPhnEmail().setText("yonro@yopmail.com");
        session.getRewardsProgramPage().getApplyBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());


    }

    @Test(description = "Verify relevant record appears on searching using Customer Phone/Email filter field")
    public void verifyUserPhnEmailFieldF() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getUserPhnEmail().setText("jonro@yopmail.com");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getUserPhnEmail().setText("+2222 223 3888");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().clickByMouse();
        session.getRewardsProgramPage().getUserPhnEmail().setText("+2222 228");
        session.getRewardsProgramPage().getApplyBtn().click();
        Assertions.assertEquals(session.getRewardsProgramPage().getUserPhnEmail().getToolTipMessage(), Constants.userPhnEmailTooltip);
    }


    @Test(description = "Verify relevant record appears after selecting last visit date range")
    public void verifyValidLastVisitDateRng() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getLastVisit().setText("12/01/2024 - 01/05/2025");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 30);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());
    }

    @Test(description = "Verify relevant record appears after selecting last visit date range")
    public void verifyInvalidLastVisitDateRng() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getLastVisit().setText("12/02/2024 - 12/03/2024");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getLastVisit().setText("wwww");
        session.getRewardsProgramPage().getApplyBtn().click();
    }

    @Test(description = "Verify relevant record appears after selecting Customer since date range")
    public void verifyCustomerSinceValidDateRange() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getCustSince().setText("12/01/2024 - 01/05/2025");
        session.getRewardsProgramPage().getApplyBtn().click();
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());
    }

    @Test(description = "Verify relevant record appears after selecting Customer since date range")
    public void verifyCustomerSinceInvalidDateRange() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getCustSince().setText("12/02/2024 - 12/03/2024");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getCustSince().setText("wwww");
        session.getRewardsProgramPage().getApplyBtn().click();
    }

    @Test(description = "Verify that relevant record appears after selecting minimum reward points")
    public void verifyMinRewardPointsFilter() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMinRewardsPts().setText("200");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().clickByMouse();
        session.getRewardsProgramPage().getMinRewardsPts().setText("9000000");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());
    }

    @Test(description = "Verify that relevant record appears after selecting maximum reward points")
    public void verifyMaxRewardPointsFilter() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMaxRewardPts().setText("2000");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMaxRewardPts().setText("10");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());
    }

    @Test(description = "Verify that relevant record appear listed after entering any existing value in 'Min number of payments' field under 'Filter' link")
    public void verifyMinPaymentsField() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMinPayments().setText("0");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMinPayments().setText("1");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getNoResultIcon().isDisplayed());

    }

    @Test(description = "Verify that relevant record appear listed after entering any existing value in 'Max number of payments' field under 'Filter' link")
    public void verifyMaxPaymentsField() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getRewardsProgramPage().click();
        session.getRewardsProgramPage().getStoreDropdown().click();
        session.getRewardsProgramPage().getcustomerStoreOption().click();
        session.getRewardsProgramPage().getContinueButton().click();

        session.getRewardsProgramPage().getFilterBtn().click();
        session.getRewardsProgramPage().getMaxPayments().setText("0");
        session.getRewardsProgramPage().getApplyBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getRewardsProgramPage().applyBtn, 20);
        Assertions.assertTrue(session.getRewardsProgramPage().getYonroCustomer().isDisplayed());

    }



}
