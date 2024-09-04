package scenarios;

import org.automation.base.BaseTest;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest  {

    KadeSession session = new KadeSession();
    RandomGenerator randomGenerator = new RandomGenerator();
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

    @Test (description = "CA_TC 1(c): Verify that creating new account with 'Personal Account' option.")
    public void verifyCreatingAccountWithPersonalAccountOption() {
        session.getLoginPage().getSignUpLink().click();

        // Clicking on Personal Account Option
        session.getCreateAccountPage().getPersonalAccountButton().click();
        String st = randomGenerator.requiredString(6);
        session.getCreateAccountPage().getEmailOrPhoneField().setText(st+"@yopmail.com");
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getSignUpButton().click();

        // Verify the Verify Account Title
        Assertions.assertTrue(session.getCreateAccountPage().getVerifyAccountTitle().isDisplayed());

        // Verify the Security field is displayed
        Assertions.assertTrue(session.getCreateAccountPage().getSecurityCodeLabel().isDisplayed());
        session.getCreateAccountPage().getSecurityCodeField().setText("123456");
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the Set your password Title
        Assertions.assertTrue(session.getCreateAccountPage().getSetPasswordTitle().isDisplayed());

        // clicking on 'Submit' button
        session.getCreateAccountPage().getSubmitButton().click();

        // Verify the tooltip message
       String tooltipMessage= (session.getCreateAccountPage().getPasswordField().getToolTipMessage());
       Assertions.assertEquals(tooltipMessage,"This field is required.");

       // Enter invalid data in Password Field
        session.getCreateAccountPage().getPasswordField().setText("abcdefgh");
        session.getCreateAccountPage().getSubmitButton().click();

        // Verify tooltip message in password field
        String ActualTooltip= session.getCreateAccountPage().getPasswordField().getToolTipMessage();
        Assertions.assertEquals(ActualTooltip,"Invalid password, a password must contain at least one upper case letter, one lower case letter and one number.");

        // Verify tooltip message for Confirm password field
        //String ConfirmPasswordTooltip = session.getCreateAccountPage().getConfirmPasswordField().getToolTipMessage();
        //Assertions.assertEquals(ConfirmPasswordTooltip,"Please enter the same value again.");

        // Enter Password and Confirm Password
        session.getCreateAccountPage().getPasswordField().setText("Text@123");
        session.getCreateAccountPage().getConfirmPasswordField().setText("Text@123");
        session.getCreateAccountPage().getSubmitButton().click();

        // Verify the success message
        Assertions.assertTrue(session.getCreateAccountPage().getSuccessMessage().isDisplayed());
    }

    @Test(description = "CA_TC 2: Verify that creating new account with Business Account option with email address")
        public void verifyCreatingNewAccountWithBusinessAccount(){
            session.getLoginPage().getSignUpLink().click();

            //Clicking on Business Account Option
        session.getCreateAccountPage().getBusinessAccountButton().click();
        Assertions.assertTrue(session.getCreateAccountPage().getMobilePhoneFieldLabel().isDisplayed());
        Assertions.assertTrue(session.getCreateAccountPage().getUseEmailLink().isDisplayed());
        Assertions.assertTrue(session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().isDisplayed());
        Assertions.assertTrue(session.getCreateAccountPage().getContinueButton().isDisplayed());

        //Clicking on Continue' button
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the Tooltip
        session.getCreateAccountPage().getMobilePhoneField().getToolTipMessage();

        // session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().getToolTipMessage();

        session.getCreateAccountPage().getUseEmailLink().click();
        // Enter invalid email
        session.getCreateAccountPage().getEmailBusinessAccountField().setText("123456@");
        session.getCreateAccountPage().getContinueButton().click();
        // Verify the email tooltip
        String Actual= session.getCreateAccountPage().getEmailBusinessAccountField().getToolTipMessage();
        Assertions.assertEquals(Actual,"Please enter a valid email address.");

        // Enter randon valid email in the Email field
         String st = randomGenerator.requiredString(3);
        session.getCreateAccountPage().getEmailBusinessAccountField().setText(st+"@yopmail.com");

        // Checking the By providing my information, I consent to receive text/email notifications. checkbox
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getContinueButton().click();

        // Enter data in security code field
        session.getCreateAccountPage().getSecurityCodeField().setText("123456");

        //Entering name in the Full name field
        session.getCreateAccountPage().getFullName().setText("New User "+  st);

        // Verify the start Over Link
        Assertions.assertTrue(session.getCreateAccountPage().getStartOverLink().isDisplayed());

        // Verify the Resend Code Link
        Assertions.assertTrue(session.getCreateAccountPage().getResendCode().isDisplayed());

        // Click on start over link
        session.getCreateAccountPage().getStartOverLink().click();

        // Click on Continue button
        session.getCreateAccountPage().getContinueButton().click();

    }


}













