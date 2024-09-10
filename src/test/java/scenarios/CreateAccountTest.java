package scenarios;

import org.automation.base.BaseTest;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

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
        Assertions.assertTrue(session.getCreateAccountPage().getMobilePhoneFieldLabel().isDisplayed());

        // Verify the  Use Email Link
        Assertions.assertTrue(session.getCreateAccountPage().getUseEmailLink().isDisplayed());
        // Verify the Receive Text Email Notification CheckBox
        Assertions.assertTrue(session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().isDisplayed());
        // Verify the Continue Button
        Assertions.assertTrue(session.getCreateAccountPage().getContinueButton().isDisplayed());

        //Clicking on Continue button
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the Tooltip
        session.getCreateAccountPage().getMobilePhoneField().getToolTipMessage();

        // Click on Use Email Link
        session.getCreateAccountPage().getUseEmailLink().click();

        // Enter invalid email
        session.getCreateAccountPage().getEmailBusinessAccountField().setText("123456@");
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the email tooltip
        String Actual = session.getCreateAccountPage().getEmailBusinessAccountField().getToolTipMessage();
        Assertions.assertEquals(Actual, "Please enter a valid email address.");

        // Entering valid email in the Email field
        String st = randomGenerator.requiredString(3);
        session.getCreateAccountPage().getEmailBusinessAccountField().setText(st + "@yopmail.com");

        // Checking the By providing my information, I consent to receive text/email notifications. checkbox
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the start Over Link
        Assertions.assertTrue(session.getCreateAccountPage().getStartOverLink().isDisplayed());

        // Verify the Resend Code Link
        Assertions.assertTrue(session.getCreateAccountPage().getResendCode().isDisplayed());

        // Click on start over link
        session.getCreateAccountPage().getStartOverLink().click();

        // Click on Continue button
        session.getCreateAccountPage().getContinueButton().click();
        WebdriverWaits.sleep(5000);

        // Enter data in security code field
        session.getCreateAccountPage().getSecurityCodeField().setText("123456");

        //Entering name in the Full name field
        session.getCreateAccountPage().getFullName().setText("New User " + st);

        // Clicking on 'Continue' button
        session.getCreateAccountPage().getContinueButtonOfBusinessAccount().click();
    }

    @Test(description = "CA_TC 2(b) : Verify that creating new account by phone number with Business Account option.")
    public void verifyCreateNewAccountByPhoneNumberWithBusinessAccount() {
        String Phone = "6465551119";
        session.getLoginPage().getSignUpLink().click();

        //Clicking on Business Account Option
        session.getCreateAccountPage().getBusinessAccountButton().click();

        // Verify Mobile field label
        Assertions.assertTrue(session.getCreateAccountPage().getMobilePhoneFieldLabel().isDisplayed());

        // Enter Phone Number in Phone field
        session.getCreateAccountPage().getMobilePhoneField().setText(Phone);

        // Checking the checkbox
        session.getCreateAccountPage().getReceiveTextEmailNotificationCheckBox().click();

        // Clicking on Continue Button
        session.getCreateAccountPage().getContinueButton().click();

        // Verify the start Over Link
        Assertions.assertTrue(session.getCreateAccountPage().getStartOverLink().isDisplayed());

        // Verify the Resend Code Link
        Assertions.assertTrue(session.getCreateAccountPage().getResendCode().isDisplayed());

        // Click on start over link
        session.getCreateAccountPage().getStartOverLink().click();

        // Click on Continue button
        session.getCreateAccountPage().getContinueButton().click();

        // Enter less than 6 digit in security field
        session.getCreateAccountPage().getSecurityCodeField().setText("12345");

        //Verify the security code sent to Information message
        Assertions.assertTrue(session.getCreateAccountPage().getCodeSendToInformationMessage().isDisplayed());

        // Clicking on Continue Button
        session.getCreateAccountPage().getContinueButtonOfBusinessAccount().click();

        // Verify the Tooltip message for security field
        String TooltipForLessDigit = session.getCreateAccountPage().getSecurityCodeField().getToolTipMessage();
        Assertions.assertEquals(TooltipForLessDigit, "Please enter at least 6 characters.");

        // Entering Invalid security Code
        session.getCreateAccountPage().getSecurityCodeField().setText("123458");
        session.getCreateAccountPage().getFullName().setText("New User");
        session.getCreateAccountPage().getContinueButtonOfBusinessAccount().click();

        // Verify the Validation message for Incorrect Security Code
        Assertions.assertEquals(session.getCreateAccountPage().getSecurityCodeAlertMessage().getText(), "Invalid security code");

        // Entering Valid security Code
        session.getCreateAccountPage().getSecurityCodeField().setText("777777");

        // Clicking Continue Button
        session.getCreateAccountPage().getContinueButtonOfBusinessAccount().click();

        // Verify the page title
        Assertions.assertTrue(session.getCreateAccountPage().getStripePageTitle().isDisplayed());

        // Clicking on Profile Link
        session.getDashBoardPage().clickProfile();

        // Click on Security and Password Tab
        session.getBasicInformationPage().clickOnSecurityAndPassword();

        // Click on Close and Delete Account button
        session.getSecurityAndPasswordPage().getDeleteAccountButton().click();
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
        Assertions.assertTrue(session.getSignInPopup().getSignInContinue().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSwitchToEmailLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getPhoneFieldOfSignIn().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getPhoneLabelofSignIn().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInWithGoogleImage().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInWithAppleImage().isDisplayed());

        // Validation for Phone Field
        session.getSignInPopup().getSignInContinue().click();
        String Actual = session.getSignInPopup().getPhoneFieldOfSignIn().getToolTipMessage();
        Assertions.assertEquals(Actual, "This field is required.");
        session.getSignInPopup().getSignInContinue().click();
        session.getSignInPopup().getPhoneFieldOfSignIn().setText("12345");
        session.getSignInPopup().getSignInContinue().clickByMouse();
        Assertions.assertTrue(session.getSignInPopup().getPleaseReviewValidation().isDisplayed());
        String ActualTooltip = session.getSignInPopup().getPhoneFieldOfSignIn().getToolTipMessage();
        Assertions.assertEquals(ActualTooltip, "Invalid phone number");

        // Clearing Phone Field
        session.getSignInPopup().getPhoneFieldOfSignIn().clearMaskedInputField(By.xpath("//input[@name='userName' and @data-f-type='phone']"));
        session.getSignInPopup().getPhoneField().click();

        // Entering valid phone number
        session.getSignInPopup().getPhoneFieldOfSignIn().setText("6465551114");
        session.getSignInPopup().getSignInContinue().click();

        // Verify the link is displayed
        Assertions.assertTrue(session.getSignInPopup().getChangeLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getIdontKnowPasswordLink().isDisplayed());
        Assertions.assertTrue(session.getSignInPopup().getSignInButton().isDisplayed());

        // Validation for Password field
        session.getSignInPopup().getSignInButton().click();
        session.getSignInPopup().getSignInPasswordField().getToolTipMessage();
        session.getSignInPopup().getSignInPasswordField().setText("33432533");
        session.getSignInPopup().getSignInButton().click();
        WebdriverWaits.sleep(2000);

        String ActualAlertMessage = session.getSignInPopup().getSignInPasswordField().getToolTipMessage();
        Assertions.assertEquals(ActualAlertMessage,
                "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.");

        // Entering valid password and signing in to the app.
        session.getSignInPopup().getShowPassword().click();
        session.getSignInPopup().getSignInPasswordField().setText("Test@123");
        session.getSignInPopup().getSignInButton().click();
    }

}











