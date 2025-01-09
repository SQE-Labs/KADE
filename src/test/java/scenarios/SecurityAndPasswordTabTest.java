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
    public void sp_1getUpdateEmailPopup() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditEmailBtn().click();

        Assertions.assertTrue(session.getSecurityAndPassword().getEditEmailPopupTitle().isDisplayed());

        session.getSecurityAndPassword().getCloseUpdateEmailPopupBtn().click();
    }

    @Test(description = "Verify for Invalid Email inputs in Update email address popup")
    public void sp_2InvalidInputForEmailUpdate() {
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
        String currentEmail = session.getSecurityAndPassword().getEmailField().getAttribute("value");
        session.getSecurityAndPassword().getUpdateEmailField().setText(currentEmail);
        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getUpdateEmailField().getToolTipMessage(),"New email cannot be the same as the current email!");

    }

    @Test(description = "Verify for Valid Email inputs in Update email address popup")
    public void sp_3ValidInputForEmailUpdate() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditEmailBtn().click();

        String randomEmail = generateRandomEmail();
        session.getSecurityAndPassword().getUpdateEmailField().setText(randomEmail);

        session.getSecurityAndPassword().getSendBtnForUpdatedEmail().click();
        WebdriverWaits.waitForElementVisible(session.getSecurityAndPassword().currentSecurityCode,10);
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

    @Test(description = "Verify user is able to edit phone number")
    public void sp_4editPhoneNumber() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditPhoneBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getUpdatePhonePopupTitle().isDisplayed());

        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSystemAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getNewPhoneFIeld().getToolTipMessage(),"This field is required.");

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("12312312");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        Assertions.assertEquals(session.getSecurityAndPassword().getNewPhoneFIeld().getToolTipMessage(),"Invalid phone number");
        session.getSecurityAndPassword().getPopupCloseBtn().click();

    }

    @Test(description = "verify different scenarios of security code fields after entering valid phone number")
    public void sp_5securityCodeScenarios() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditPhoneBtn().click();

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("1231231231");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        WebdriverWaits.waitForElementVisible(session.getSecurityAndPassword().saveNewPhoneBtn,10);
        session.getSecurityAndPassword().getSaveNewPhoneBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSystemAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getNewPhoneOTPField().getToolTipMessage(),"This field is required.");
        Assertions.assertEquals(session.getSecurityAndPassword().getCurrentPhoneOTPField().getToolTipMessage(),"This field is required.");

        session.getSecurityAndPassword().getCurrentPhoneOTPField().setText("123456");
        session.getSecurityAndPassword().getNewPhoneOTPField().setText("12345");
        session.getSecurityAndPassword().getSaveNewPhoneBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSystemAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getNewPhoneOTPField().getToolTipMessage(),"Please enter at least 6 characters.");

        session.getSecurityAndPassword().getCurrentPhoneOTPField().setText("123456");
        session.getSecurityAndPassword().getNewPhoneOTPField().setText("122222");
        session.getSecurityAndPassword().getSaveNewPhoneBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSystemAlertMessage().isDisplayed());

        session.getSecurityAndPassword().getDiffCellPhone().click();
        session.getSecurityAndPassword().getNewPhoneFIeld().setText("12334545676");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        session.getSecurityAndPassword().getCurrentPhoneOTPField().setText("123456");
        session.getSecurityAndPassword().getNewEmailSecurityCode().setText("123456");
        session.getSecurityAndPassword().getSaveNewPhoneBtn().click();

    }

    @Test(description = "Verify user can update/change phone number using Different phone number option")
    public void sp_6differentCellPhone() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getEditPhoneBtn().click();

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("1231231231");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        session.getSecurityAndPassword().getDiffCellPhone().click();

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("1233454");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getSystemAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getSecurityAndPassword().getNewPhoneFIeld().getToolTipMessage(),"Invalid phone number");

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("12334");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        session.getSecurityAndPassword().getCurrentPhoneOTPField().setText("123456");
        session.getSecurityAndPassword().getNewPhoneOTPField().setText("123456");
        session.getSecurityAndPassword().getSaveNewPhoneBtn().click();
        session.getSecurityAndPassword().getPopupCloseBtn().click();

        session.getSecurityAndPassword().getEditPhoneBtn().click();

        session.getSecurityAndPassword().getNewPhoneFIeld().setText("1231231231");
        session.getSecurityAndPassword().getSecurityCodeBtn().click();
        session.getSecurityAndPassword().getDiffCellPhone().click();
        session.getSecurityAndPassword().getNewPhoneFIeld().setText("1231231231");

    }

    @Test(enabled = false, description = "verify that 'Chnage password' popup opens up, when user clicks on 'Reset your password' button")
    public void sp_7resetYourPassword() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();
        session.getSecurityAndPassword().getResetPasswordBtn().click();

        session.getSecurityAndPassword().getResetPwdSecCodeBtn().click();
        session.getSecurityAndPassword().getRestPwdInputField().setText("123456");
        session.getSecurityAndPassword().getResetPwdContinueBtn().click();
        WebdriverWaits.waitForElementVisible(session.getSecurityAndPassword().passwordField,10);
        Assertions.assertTrue(session.getSecurityAndPassword().getPasswordField().isDisplayed());
        Assertions.assertTrue(session.getSecurityAndPassword().getConfirmPasswordField().isDisplayed());
//        session.getSecurityAndPassword().getPasswordField().setText("Test@123");
//        session.getSecurityAndPassword().getConfirmPasswordField().setText("Test@123");
//        session.getSecurityAndPassword().getShowPwdIcon().click();
//        session.getSecurityAndPassword().getSubmitNewPasswordBtn().click();

    }

    @Test(description = "Verify validation message appears when clicked on delete button")
    public void sp_8DeleteButton() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSecurityAndPassword().getUserProfileBtn().click();
        session.getSecurityAndPassword().getSecurityAndPasswordTab().click();

        session.getSecurityAndPassword().getDeleteEmailBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getDelEmailValidationMsg().isDisplayed());
        session.getSecurityAndPassword().getDeletePhoneBtn().click();
        Assertions.assertTrue(session.getSecurityAndPassword().getDelPhoneValidationMsg().isDisplayed());
    }


}
