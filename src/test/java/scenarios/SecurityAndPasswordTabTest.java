package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import java.util.UUID;

public class SecurityAndPasswordTabTest extends BaseTest {

    @Test(description = "Verify Update Email popup opens")
    public void getUpdateEmailPopup() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditEmailBtn().click();

        Assertions.assertTrue(session.getSecurityAndPassword().getEditEmailPopupTitle().isDisplayed());

        session.getSecurityAndPassword().getCloseUpdateEmailPopupBtn().click();
    }

    @Test(description = "Verify for Invalid Email inputs in Update email address popup")
    public void InvalidInputForEmailUpdate() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditEmailBtn().click();

        session.getSecurityAndPassword().getUpdateEmailField().setText(" ");

        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();

        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());

        Assertions.assertEquals(session.getSecurityAndPassword().getUpdateEmailField().getToolTipMessage(),"This field is required.");
        session.getSecurityAndPassword().getCloseUpdateEmailPopupBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getSecurityAndPassword().updateEmailPopupTitle,10);

        session.getSecurityAndPassword().getEditEmailBtn().click();
        session.getSecurityAndPassword().getUpdateEmailField().setText("yonro");
        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getUpdateEmailField().getToolTipMessage(),"Please enter a valid email address.");
        session.getSecurityAndPassword().getCloseUpdateEmailPopupBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getSecurityAndPassword().updateEmailPopupTitle,10);

        session.getSecurityAndPassword().getEditEmailBtn().click();
        session.getSecurityAndPassword().getUpdateEmailField().setText("test1114@yopmail.com");
        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getUpdateEmailField().getToolTipMessage(),"New email cannot be the same as the current email!");

    }

    @Test(description = "Verify for Valid Email inputs in Update email address popup")
    public void ValidInputForEmailUpdate() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditEmailBtn().click();

        String randomEmail = generateRandomEmail();
        session.getSecurityAndPassword().getUpdateEmailField().setText(randomEmail);

        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();
        session.getSecurityAndPassword().getCurrentEmailSecurityCode().setText(" ");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText(" ");
        session.getSecurityAndPassword().getSaveButton().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getCurrentEmailSecurityCode().getToolTipMessage(),"This field is required.");
        Assertions.assertEquals(session.getSecurityAndPassword().getNewEmailSecurityCode().getToolTipMessage(),"This field is required.");

        session.getSecurityAndPassword().getCurrentEmailSecurityCode().setText("123654");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText("123456");
        session.getSecurityAndPassword().getSaveButton().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSecurityCodeValidationMessage().isDisplayed());

        session.getSecurityAndPassword().getCurrentEmailSecurityCode().setText("123456");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText("123654");
        session.getSecurityAndPassword().getSaveButton().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSecurityVerificationErrorMsg().isDisplayed());

        session.getSecurityAndPassword().getCurrentEmailSecurityCode().setText("12345");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText("1236");
        session.getSecurityAndPassword().getSaveButton().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getCurrentEmailSecurityCode().getToolTipMessage(),"Please enter at least 6 characters.");
        Assertions.assertEquals(session.getSecurityAndPassword().getNewEmailSecurityCode().getToolTipMessage(),"Please enter at least 6 characters.");

        session.getSecurityAndPassword().getDifferentEmailBtn().click();
        session.getSecurityAndPassword().getSendBtnOfNewEmailPopup().clickByMouse();
        WebdriverWaits.waitForElementInVisible(session.getSecurityAndPassword().sendBtnOfNewEMailPopup,10);

        session.getSecurityAndPassword().getCurrentEmailSecurityCode().setText("123456");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText("123456");
        session.getSecurityAndPassword().getSaveButton().click();

    }

    private String generateRandomEmail() {
        String uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return uniqueId + "@yopmail.com";
    }








}
