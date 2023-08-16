package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.CreateNewAccountPage;
import org.automation.pageObjects.SetYourPasswordPage;
import org.automation.pageObjects.VerifyYourAccountPage;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.RandomGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    // Page Objects
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();
    VerifyYourAccountPage verifyYourAccountPage = new VerifyYourAccountPage();
    SetYourPasswordPage setYourPasswordPage = new SetYourPasswordPage();

    @BeforeMethod
    public void beforeTestMethod() {
        // Navigate to 'Create a new account' page
        getDriver().navigate().to(PropertiesUtil.getPropertyValue("createNewAccountPageUrl"));
    }

    @Test(enabled = true, description = "1. Verify that user get directed to 'Create New Account' page, after clicking on 'Sign up' link, on 'Login' page.")
    public void tc01_validateSignUpLink() {

        // Verify app Logo name heading - 'Kade'
        Assert.assertTrue(createNewAccountPage.checkPresenceOfappLogoNameHeading());

        // Verify 'Create New Account' heading
        Assert.assertTrue(createNewAccountPage.checkPresenceOfCreateNewAccountHeading());

        // Verify 'Email or Phone' label
        Assert.assertTrue(createNewAccountPage.checkPresenceOfEmailOrPhoneLabel());

        // Verify 'Already have an account? Sign-in' label
        Assert.assertTrue(createNewAccountPage.checkPresenceOfAlreadyHaveAnAccountLabel());

        // Verify 'Sign-in' link
        Assert.assertTrue(createNewAccountPage.checkPresenceOfSignInLink());

        // Verify 'Sign up' button
        Assert.assertTrue(createNewAccountPage.checkPresenceOfSignUpButton());

    }

    @Test( enabled = true, description = "2. Verify that 'Email or Phone' field appears highlighted, when user clicks on 'Sign Up' button, after leaving  'Email or Phone' field blank, on 'Create New Account' page.")
    public void tc02_validateEmailOrPhoneFieldGetHighlighted() {

        // Verify 'Email or Phone' label
        Assert.assertTrue(createNewAccountPage.checkPresenceOfEmailOrPhoneLabel());

        // Verify 'Email or Phone' field
        Assert.assertTrue(createNewAccountPage.checkPresenceOfEmailOrPhoneField());

        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

    }

    @Test(enabled = true, description = "3. Verify that appropriate validation message appears on entering invalid Email or Phone in 'Email or Phone' field, on 'Create New Account' page.")
    public void tc03_validateValidationMessageOnEnteringInvalidEmailOrPhone() {

        // Enter invalid Email or Phone
        createNewAccountPage.enterEmailOrPhone("User22");

        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

}

    @Test(enabled = true, description = "5. Verify that 'Security Code' field appears after entering valid email  in 'Email or Phone' field, on 'Verify your account' page.")
    public void tc04_validateSecurityCodeFieldOnEnteringValidEmail() {

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone("user" + new RandomGenerator().requiredString(6) + "@yopmail.com");

        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();
    }

    @Test(enabled = true, description = "6. Verify that 'Security Code' field appears after entering valid phone number in 'Email or Phone' field, on 'Verify your account' page.")
    public void tc05_validateSecurityCodeFieldOnEnteringValidPhone() {

        // Enter valid phone in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone("919158501408");

        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

    }

    @Test(enabled = true, description = "7. Verify that Security Code is resent after clicking on the 'Resend security code' link, on 'Verify your account' page.")
    public void tc06_validateSecurityCodeIsResent (){

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone("user" + new RandomGenerator().requiredString(6) + "@yopmail.com");
        createNewAccountPage.checkRecieveTextEmailNotificationCheckBox();

        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();
       
        // Verify 'Email or Phone' field on 'Verify your account' page
        Assert.assertTrue(verifyYourAccountPage.checkPresenceOfEmailOrPhoneFieldOnVerifyAccountPage());

        // Verify 'Verify your account' page title - 'Verify Account'
        String actualVerifyYourAccountPageTitle = verifyYourAccountPage.getPageTitle();
        Assert.assertEquals(actualVerifyYourAccountPageTitle,"Verify Account");

        // Verify 'Security Code' field
        Assert.assertTrue(verifyYourAccountPage.checkPresenceOfSecurityCodeField());

        // Verify 'Continue' button
        Assert.assertTrue(verifyYourAccountPage.checkPresenceOfContinueButton());

        // Click 'Resend security code' link
        verifyYourAccountPage.clickResendSecurityCode();

    }

    @Test(enabled = true, description = "8. Verify that 'Set your Password' page opens up after entering valid Security Code in 'Security Code' field on 'Verify your account' page.")
    public void tc07_validateSetYourPasswordPageOpensUpAfterEnteringSecurityCode(){

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone( "user" + new RandomGenerator().requiredString(6) + "@yopmail.com");
        createNewAccountPage.checkRecieveTextEmailNotificationCheckBox();
        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

        // Verify 'Security Code' field
        Assert.assertTrue(verifyYourAccountPage.checkPresenceOfSecurityCodeField());

        // Enter valid security code in 'Security Code' field
       verifyYourAccountPage.EnterSecurityCode("123456");

        //  Click on 'Continue' button
        verifyYourAccountPage.clickContinueButton();

        // Verify 'Password' field on Set your password page
        Assert.assertTrue(setYourPasswordPage.checkPresenceOfPasswordField());

        // Verify 'Set Your Password' page title - 'Configure Password'
        String actualSetYourPasswordPageTitle = setYourPasswordPage.getPageTitle();
        Assert.assertEquals(actualSetYourPasswordPageTitle,"Configure Password");

        // Verify 'Confirm Password' on Set your password page
        Assert.assertTrue(setYourPasswordPage.checkPresenceOfConfirmPasswordField());

        // Verify 'Submit' button on set your password page
       Assert.assertTrue(setYourPasswordPage.checkPresenceSubmitButton());

    }

    @Test(enabled = true, description = "9. Verify that 'Password' field appears highlighted, when user clicks on 'Submit' button, after entering less than 8 characters in  'Password and Confirm Password' field, on 'Set your password' page.")
    public void tc08_validatePasswordFieldGetHighlightedOnEnteringLessThanEightCharacters() {

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone( "user"+ new RandomGenerator().requiredString(5)+"@yopmail.com");
        createNewAccountPage.checkRecieveTextEmailNotificationCheckBox();
        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

        // Enter valid security code in 'Security Code' field
        verifyYourAccountPage.EnterSecurityCode("123456");

        //  Click on 'Continue' button
        verifyYourAccountPage.clickContinueButton();

        // Set password in 'Password' field on set your password page
        setYourPasswordPage.setPasswordField("Hello12");

        // Enter same password in 'Confirm Password' field
        setYourPasswordPage.setConfirmPasswordField("Hello12");

        // Click on 'Submit' button on verify your account page
        setYourPasswordPage.clickSubmitButton();


    }

    @Test(enabled = true, description = "10. Verify that 'Password' field appears highlighted, when user clicks on 'Submit' button, after leaving  'Password and Confirm Password' field blank, on 'Set your password' page.")
    public void tc09_validatePasswordFieldGetHighlightedOnLeavingPasswordAndConfirmPasswordFieldBlank() {

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone( "user"+new RandomGenerator().requiredString(4)+"@yopmail.com");
        createNewAccountPage.checkRecieveTextEmailNotificationCheckBox();
        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

        // Enter valid security code in 'Security Code' field
        verifyYourAccountPage.EnterSecurityCode("123456");

        //  Click on 'Continue' button
        verifyYourAccountPage.clickContinueButton();

        // Click on 'Submit' button on verify your account page
        setYourPasswordPage.clickSubmitButton();

    }

    @Test(enabled = true, description = "11. Verify that appropriate validation message appears on entering invalid Password 'Password  or Confirm Password' field, on 'Set your password' page.")
    public void tc10_VerifyValidationMessageOnEnteringInvalidPassword() {

        // Enter valid email in 'Email or Phone' field
        createNewAccountPage.enterEmailOrPhone( "user"+new RandomGenerator().requiredString(7)+"@yopmail.com");
        createNewAccountPage.checkRecieveTextEmailNotificationCheckBox();
        // Click 'Sign up' button
        createNewAccountPage.clickSignUpButton();

        // Enter valid security code in 'Security Code' field
        verifyYourAccountPage.EnterSecurityCode("123456");

        //  Click on 'Continue' button
        verifyYourAccountPage.clickContinueButton();

        // Set password in 'Password' field on set your password page
        setYourPasswordPage.setPasswordField("hello123");

        // Enter same password in 'Confirm Password' field
        setYourPasswordPage.setConfirmPasswordField("hello123");


        // Click on 'Submit' button on verify your account page
        setYourPasswordPage.clickSubmitButton();

    }

}