package scenarios;

import org.automation.base.BaseTest;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    KadeSession session = new KadeSession();
    //VerifyYourAccountPage = new VerifyYourAccountPage();
    //SetYourPasswordPage setYourPasswordPage = new SetYourPasswordPage();


    @Test(description = "CA_TC 1: Verify the elements of 'Create New Account' page after selecting  'Personal Account' option, on 'Login' page..")
    public void VerifyTheSignUpPage() {
        session.getLoginPage().getSignUpLink().click();

        // Verify the Business Account And Personal Account Button
        Assertions.assertTrue(session.getCreateAccountPage().getBusinessAccountButton().isDisplayed());
        Assertions.assertTrue(session.getCreateAccountPage().getPersonalAccountButton().isDisplayed());

        // Clicking on Personal Account Option
        session.getCreateAccountPage().getPersonalAccountButton().click();

        // Verify app Logo  - 'Kade'
        Assertions.assertTrue(session.getCreateAccountPage().getKadelogo().isDisplayed());

        // Verify 'Create New Account' heading
        Assertions.assertTrue(session.getCreateAccountPage().getCreateNewAccountTitle().isDisplayed());

        // Verify 'Email or Phone' label
        Assertions.assertTrue(session.getCreateAccountPage().getEmailOrPhoneNumberLabel().isDisplayed());

        // Verify 'Already have an account? Sign-in' label
        Assertions.assertTrue(session.getCreateAccountPage().getPresenceOfAlreadyHaveAnAccountTitle().isDisplayed());

        // Verify 'Sign-in' link
        Assertions.assertTrue(session.getCreateAccountPage().getEmailOrPhoneField().isDisplayed());

        // Verify 'Sign up' button
        Assertions.assertTrue(session.getCreateAccountPage().getSignUpButton().isDisplayed());

        // Clicking on Sign in link
        session.getCreateAccountPage().getSignInLink().click();

    }
    @Test (description = "CA_TC 1(b): Verify the validation messages while creating new account with 'Personal Account' option on 'Login' page.")
    public void verifyValidationMessagesWithPersonalAccountOption(){
        session.getLoginPage().getSignUpLink().click();

        // Clicking on Personal Account Option
        session.getCreateAccountPage().getPersonalAccountButton().click();
        session.getCreateAccountPage().getSignUpButton().click();

        // Verify the Please review the highlighted field validation message and This field is required Tooltip
        Assertions.assertTrue(session.getLoginPage().getValidationMessage().isDisplayed());
        String actualMessage = session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(actualMessage,"This field is required.");

        // Enter invalid data in 'Email or Phone' field
        session.getCreateAccountPage().getEmailOrPhoneField().setText("invalid123");
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getSignUpButton().click();

        // tooltip message
        String actualToolTip = session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(actualToolTip,"Invalid phone or email. Phone numbers must start with country code starting with +");

        // Enter invalid email
        session.getCreateAccountPage().getEmailOrPhoneField().setText("test@123");
        session.getCreateAccountPage().getSignUpButton().click();
        String invalidEmailTooltip= session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(invalidEmailTooltip,"Please enter a valid email address.");
        //session.getCreateAccountPage().getCrossICon().click();

         // Entering existing phone number and verify the validation message
        session.getCreateAccountPage().getEmailOrPhoneField().setText("6465551114");
        session.getCreateAccountPage().getSignUpButton().click();

        //Verify the validation message for Phone Number
        String ExpectedMessage = "This phone number is already registered.";
        Assertions.assertEquals(session.getCreateAccountPage().getExistingPhoneValidationMessage().getText(),
                ExpectedMessage);
        session.getCreateAccountPage().getCrossICon().click();

        // Verify the Validation for Existing Email
        session.getCreateAccountPage().getEmailOrPhoneField().setText("test@yopmail.com");
        session.getCreateAccountPage().getSignUpButton().click();
        String ExpectedEmailMessage = "This email is already registered.";
        Assertions.assertEquals(session.getCreateAccountPage().getExistingEmailValidation().getText(),
                ExpectedEmailMessage);
    }

}













