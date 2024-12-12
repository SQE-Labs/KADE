package scenarios;

import org.automation.base.BaseTest;
import org.automation.pages.SetYourPasswordPage;
import org.automation.pages.VerifyYourAccountPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    KadeSession session = new KadeSession();
    RandomGenerator randomGenerator = new RandomGenerator();
    //VerifyYourAccountPage = new void VerifyYourAccountPage();
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

    @Test(description = "CA_TC 1(b): Verify the validation messages while creating new account with 'Personal Account' option on 'Login' page.")
    public void verifyValidationMessagesWithPersonalAccountOption() {
        session.getLoginPage().getSignUpLink().click();

        // Clicking on Personal Account Option
        session.getCreateAccountPage().getPersonalAccountButton().click();
        session.getCreateAccountPage().getSignUpButton().click();

        // Verify the Please review the highlighted field validation message and This field is required Tooltip
        Assertions.assertTrue(session.getLoginPage().getValidationMessage().isDisplayed());
        String actualMessage = session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(actualMessage, "This field is required.");

        // Enter invalid data in 'Email or Phone' field
        session.getCreateAccountPage().getEmailOrPhoneField().setText("invalid123");
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getSignUpButton().click();

        // tooltip message
        String actualToolTip = session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(actualToolTip, "Invalid phone or email. Phone numbers must start with country code starting with +");

        // Enter invalid email
        session.getCreateAccountPage().getEmailOrPhoneField().setText("test123@d");
        session.getCreateAccountPage().getSignUpButton().clickByMouse();

        String invalidEmailTooltip = session.getCreateAccountPage().getEmailOrPhoneField().getToolTipMessage();
        Assertions.assertEquals(invalidEmailTooltip, "Please enter a valid email address.");
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

    @Test(description = "CA_TC 1(c): Verify that creating new account with 'Personal Account' option.")
    public void verifyCreatingAccountWithPersonalAccountOption() {
        session.getLoginPage().getSignUpLink().click();

        // Clicking on Personal Account Option
        session.getCreateAccountPage().getPersonalAccountButton().click();
        String st = randomGenerator.requiredString(6);
        session.getCreateAccountPage().getEmailOrPhoneField().setText(st + "@yopmail.com");
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
        String tooltipMessage = (session.getCreateAccountPage().getPasswordField().getToolTipMessage());
        Assertions.assertEquals(tooltipMessage, "This field is required.");

        // Enter invalid data in Password Field
        session.getCreateAccountPage().getPasswordField().setText("abcdefgh");
        session.getCreateAccountPage().getSubmitButton().click();

        // Verify tooltip message in password field
        String ActualTooltip = session.getCreateAccountPage().getPasswordField().getToolTipMessage();
        Assertions.assertEquals(ActualTooltip, "Invalid password, a password must contain at least one upper case letter, one lower case letter and one number.");

        // Enter Password and Confirm Password
        session.getCreateAccountPage().getPasswordField().setText("Text@123");
        session.getCreateAccountPage().getConfirmPasswordField().setText("Text@123");
        session.getCreateAccountPage().getSubmitButton().click();

        // Verify the success message
        Assertions.assertTrue(session.getCreateAccountPage().getSuccessMessage().isDisplayed());
    }

    @Test(description = "CA_TC 2(a): Verify that creating a new account by email address with  Business Account option.")
    public void verifyCreatingNewAccountByEmailWithBusinessAccount() {
        session.getLoginPage().getSignUpLink().click();

        //Clicking on Business Account Option
        session.getCreateAccountPage().getBusinessAccountButton().click();

        // Verify Mobile field label
        Assertions.assertTrue(session.getNewAccountPopup().getMobilePhoneFieldLabel().isDisplayed());

        // Verify the  Use Email Link
        Assertions.assertTrue(session.getNewAccountPopup().getUseEmailLink().isDisplayed());
        // Verify the Receive Text Email Notification CheckBox
        Assertions.assertTrue(session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().isDisplayed());
        // Verify the Continue Button
        Assertions.assertTrue(session.getCreateAccountPage().getContinueButton().isDisplayed());

        //Clicking on Continue button
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the Tooltip
        session.getNewAccountPopup().getMobilePhoneField().getToolTipMessage();

        // Click on Use Email Link
        session.getNewAccountPopup().getUseEmailLink().click();

        // Enter invalid email
        session.getNewAccountPopup().getEmailBusinessAccountField().setText("123456@");
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the email tooltip
        String Actual = session.getNewAccountPopup().getEmailBusinessAccountField().getToolTipMessage();
        Assertions.assertEquals(Actual, "Please enter a valid email address.");

        // Entering valid email in the Email field
        String st = randomGenerator.requiredString(3);
        session.getNewAccountPopup().getEmailBusinessAccountField().setText(st + "@yopmail.com");

        // Checking the By providing my information, I consent to receive text/email notifications. checkbox
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the start Over Link
        Assertions.assertTrue(session.getNewAccountPopup().getStartOverLink().isDisplayed());

        // Verify the Resend Code Link
        Assertions.assertTrue(session.getNewAccountPopup().getResendCode().isDisplayed());

        // Click on start over link
        session.getNewAccountPopup().getStartOverLink().click();

        // Click on Continue button
        session.getCreateAccountPage().getContinueButton().click();
        WebdriverWaits.sleep(5000);

        // Enter data in security code field
        session.getCreateAccountPage().getSecurityCodeField().setText("123456");

        //Entering name in the Full name field
        session.getNewAccountPopup().getFullName().setText("New User " + st);

        // Clicking on 'Continue' button
        session.getNewAccountPopup().getContinueButtonOfBusinessAccount().click();
    }

    @Test(description = "CA_TC 2(b) : Verify that creating new account by phone number with Business Account option.")
    public void verifyCreateNewAccountByPhoneNumberWithBusinessAccount() {
        String Phone = "6465551105";
        session.getLoginPage().getSignUpLink().click();

        //Clicking on Business Account Option
        session.getCreateAccountPage().getBusinessAccountButton().click();

        // Verify Mobile field label
        Assertions.assertTrue(session.getNewAccountPopup().getMobilePhoneFieldLabel().isDisplayed());

        // Enter Phone Number in Phone field
        session.getNewAccountPopup().getMobilePhoneField().setText(Phone);

        // Checking the checkbox
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();

        // Clicking on Continue Button
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the start Over Link
        Assertions.assertTrue(session.getNewAccountPopup().getStartOverLink().isDisplayed());

        // Verify the Resend Code Link
        Assertions.assertTrue(session.getNewAccountPopup().getResendCode().isDisplayed());

        // Click on start over link
        session.getNewAccountPopup().getStartOverLink().click();

        // Click on Continue button
        session.getCreateAccountPage().getContinueButton().click();

        // Enter less than 6 digit in security field
        session.getCreateAccountPage().getSecurityCodeField().setText("12345");

        //Verify the security code sent to Information message
        Assertions.assertTrue(session.getNewAccountPopup().getCodeSendToInformationMessage().isDisplayed());

        // Clicking on Continue Button
        session.getNewAccountPopup().getContinueButtonOfBusinessAccount().click();

        // Verify the Tooltip message for security field
        String TooltipForLessDigit = session.getCreateAccountPage().getSecurityCodeField().getToolTipMessage();
        Assertions.assertEquals(TooltipForLessDigit, "Please enter at least 6 characters.");

        // Entering Invalid security Code
        session.getCreateAccountPage().getSecurityCodeField().setText("123458");
        session.getNewAccountPopup().getFullName().setText("New User");
        session.getNewAccountPopup().getContinueButtonOfBusinessAccount().click();

        // Verify the Validation message for Incorrect Security Code
        Assertions.assertEquals(session.getNewAccountPopup().getSecurityCodeAlertMessage().getText(), "Invalid security code");

        // Entering Valid security Code
        session.getCreateAccountPage().getSecurityCodeField().setText("346543");

        // Clicking Continue Button
        session.getNewAccountPopup().getContinueButtonOfBusinessAccount().click();

        // Verify the page title
        Assertions.assertTrue(session.getNewAccountPopup().getStripePageTitle().isDisplayed());

        // Clicking on Profile Link
        session.getSidePannel().clickProfile();

        // Click on Security and Password Tab
        session.getBasicInformationPage().clickOnSecurityAndPassword();

        // Click on Close and Delete Account button
        session.getSecurityAndPasswordPage().getDeleteAccountButton().clickByMouse();
        session.getSecurityAndPasswordPage().getTickIcon().click();
    }

    @Test(description = "CA_TC 3: Verify that signing in to the application by phone number using Business Account option.")
    public void verifyThatSiginToApplicationByPhoneNumberUsingBusinessAccountOption() {
        session.getLoginPage().getSignUpLink().click();
        session.getCreateAccountPage().getBusinessAccountButton().click();
        session.getCreateAccountPage().getCrossICon().click();

        // Clicking on 'Sign In Button
        session.getCreateAccountPage().getSignInButton().click();

        // Verify the elements on 'Sign In' page
        Assertions.assertTrue(session.getSignInPopup().getSignInPopupTitle().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getContinueButton().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSwitchToEmailLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getPhoneField().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getPhoneLabel().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInWithGoogleImage().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInWithAppleImage().isDisplayed());

        // Validation for Phone Field
        session.getSignInPopup().getContinueButton().click();
        String Actual = session.getSignInPopup().getPhoneNumberField().getToolTipMessage();
        Assertions.assertEquals(Actual, "This field is required.");

        session.getSignInPopup().getContinueButton().click();
        session.getSignInPopup().getPhoneNumberField().setText("123456");
        session.getSignInPopup().getContinueButton().clickByMouse();
        Assertions.assertTrue(session.getSignInPopup().getPleaseReviewValidation().isDisplayed());
        String actualTooltip = session.getSignInPopup().getPhoneNumberField().getToolTipMessage();
        Assertions.assertEquals(actualTooltip, "Invalid phone number");

        // Clearing Phone Field
        session.getSignInPopup().getPhoneNumberField().cleanByJS();
        //session.getSignInPopup().getPhoneField().click();


        // Entering valid phone number
        session.getSignInPopup().getPhoneNumberField().setText("6465551114");
        session.getSignInPopup().getContinueButton().click();

        // Verify the link is displayed
        Assertions.assertTrue(session.getSignInPopup().getChangeLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getIdontKnowPasswordLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInButton().isDisplayed());

        // Validation for Password field
        session.getSignInPopup().getSignInButton().click();
        session.getSignInPopup().getPasswordField().getToolTipMessage();
        session.getSignInPopup().getPasswordField().setText("33432533");
        session.getSignInPopup().getSignInButton().click();
        WebdriverWaits.sleep(2000);

        String ActualAlertMessage = session.getSignInPopup().getPasswordField().getToolTipMessage();
        Assertions.assertEquals(ActualAlertMessage,
                "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.");

        // Entering valid password and signing in to the app.
        session.getSignInPopup().getShowPassword().click();
        session.getSignInPopup().getPasswordField().setText("Test@123");
        session.getSignInPopup().getSignInButton().click();
    }
        @Test(description = "CA_TC 3 (b): Verify that signing in to the application by phone number using Business Account option, with forget password option.")
        public void verifyThatSigningInToApplicationByPhoneUsingNewPassword(){
            session.getLoginPage().getSignUpLink().click();
            session.getCreateAccountPage().getBusinessAccountButton().click();
            session.getCreateAccountPage().getCrossICon().click();

            // Clicking on 'Sign In Button
            session.getCreateAccountPage().getSignInButton().click();

            // Entering Phone Numnber
            session.getSignInPopup().getPhoneNumberField().setText("6465551114");
            session.getSignInPopup().getContinueButton().click();

            // clicking on I don't know my password link.
            session.getSignInPopup().getIdontKnowPasswordLink().click();

            // Verify the elements
            Assertions.assertTrue(session.getSignInPopup().getSecurityCodeLabel().isDisplayed());
            Assertions.assertTrue(session.getSignInPopup().getInformationMessage().isDisplayed());
            Assertions.assertTrue(session.getSignInPopup().getNewPasswordLabel().isDisplayed());
            Assertions.assertTrue(session.getSignInPopup().getShowPassword().isDisplayed());
            Assertions.assertTrue(session.getSignInPopup().getSignInButton().isDisplayed());

            // Checking validations

            session.getSignInPopup().getSignInButton().click();
            session.getSignInPopup().getSecurityCodeField().setText("777777");
            session.getSignInPopup().getSignInButton().click();
            WebdriverWaits.sleep(2000);
            String actual= session.getSignInPopup().getNewPasswordField().getToolTipMessage();
            Assertions.assertEquals(actual,"This field is required.");
            WebdriverWaits.sleep(2000);
            session.getSignInPopup().getNewPasswordField().setText("435345643");
            session.getSignInPopup().getSignInButton().click();

            String ActualAlertMessage = session.getSignInPopup().getNewPasswordField().getToolTipMessage();
            Assertions.assertEquals(ActualAlertMessage,
                    "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.");

            // Entering valid password and signing in to the app.
            session.getSignInPopup().getShowPassword().click();
            session.getSignInPopup().getNewPasswordField().setText("Test@123");
            session.getSignInPopup().getSignInButton().click();

    }
    @Test(description = " CA_TC 4(a): Verify that signing in to the application by email address using Business Account option.")
    public void verifyThatSigningInByEmailUsingBusinessAccountOption(){
        session.getLoginPage().getSignUpLink().click();
        session.getCreateAccountPage().getBusinessAccountButton().click();
        session.getCreateAccountPage().getCrossICon().click();

        // Clicking on 'Sign In Button
        session.getCreateAccountPage().getSignInButton().click();

        // Clicking on Switch to Email Link
        session.getSignInPopup().getSwitchToEmailLink().click();
        session.getSignInPopup().getContinueButton().click();
        String actual= session.getSignInPopup().getEmailField().getToolTipMessage();
        Assertions.assertEquals(actual,"This field is required.");
        session.getSignInPopup().getEmailField().setText("325325325");
        session.getSignInPopup().getContinueButton().click();
        String tooltip= session.getSignInPopup().getEmailField().getToolTipMessage();
        Assertions.assertEquals(tooltip,"Please enter a valid email address.");

        // Entering valid email address
        session.getSignInPopup().getEmailField().setText("test1114@yopmail.com");
        session.getSignInPopup().getContinueButton().click();
        WebdriverWaits.sleep(2000);

        // Validation for Password field
        session.getSignInPopup().getSignInButton().click();
        session.getSignInPopup().getPasswordField().getToolTipMessage();
        session.getSignInPopup().getPasswordField().setText("33432533");
        session.getSignInPopup().getSignInButton().click();
        WebdriverWaits.sleep(2000);

        String ActualAlertMessage = session.getSignInPopup().getPasswordField().getToolTipMessage();
        Assertions.assertEquals(ActualAlertMessage,
                "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.");

        // Entering valid password and signing in to the app.
        session.getSignInPopup().getShowPassword().click();
        session.getSignInPopup().getPasswordField().setText("Test@123");
        session.getSignInPopup().getSignInButton().click();
    }
    @Test(description = " CA_TC 4(b): Verify that signing in to the application by email address using Business Account option, with forget password option.")
    public void verifyThatSigningInByEmailUsingBusinessAccountOptionWithForgetPasswordoption(){
        session.getLoginPage().getSignUpLink().click();
        session.getCreateAccountPage().getBusinessAccountButton().click();
        session.getCreateAccountPage().getCrossICon().click();

        // Clicking on 'Sign In Button
        session.getCreateAccountPage().getSignInButton().click();

        // Clicking on Switch to Email Link
        session.getSignInPopup().getSwitchToEmailLink().click();
        session.getSignInPopup().getEmailField().setText("test1114@yopmail.com");
        session.getSignInPopup().getContinueButton().click();

        // Clicking on I don't know password link
        session.getSignInPopup().getIdontKnowPasswordLink().click();

        // Verify the elements
        Assertions.assertTrue(session.getSignInPopup().getSecurityCodeLabel().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getInformationMessage().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getNewPasswordLabel().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getShowPassword().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInButton().isDisplayed());


        session.getSignInPopup().getSecurityCodeField().setText("123456");
        session.getSignInPopup().getNewPasswordField().setText("Test@123");
        session.getSignInPopup().getShowPassword().click();
        session.getSignInPopup().getSignInButton().click();
}



}











