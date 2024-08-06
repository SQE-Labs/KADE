import java.awt.*;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.MyStorePage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest {

    @Test(description = "SC_01(A) Verifying creation of Store without Stripe Payment Account Configuration")
    public void sc01a_StoreCreationWithoutStripeAccount() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Register New Business' Button
        myStore.getRegisterNewBusinessButton().click();

        //Step 3: Click on 'Skip' button
        myStore.getSkipStripeAccountButton().click();

        //Verifying the 'Skip' PopUp Title
        Assertions.assertEquals(myStore.getSkipPopUpTitle().getText(), "Skip");

        //Step 4: Click on 'Skip' Button
        myStore.getSkipStripeAccountPopUpButton().click();

        //Step 5: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Verify the validation message
        String blankFieldWarningMessage = "Please review the highlighted field(s)";
        Assertions.assertEquals(myStore.getBlankFieldWarningMsg().getText(), blankFieldWarningMessage);

        //Step 6: Upload Image for Store Logo
        myStore.getStoreLogo().click();
        myStore.uploadImageInStoreLogo();
        myStore.getCheckButton().click();

        //Verifying maximum length of 'Store Name' field
        Assertions.assertEquals(myStore.getStoreNameField().getAttribute("maxlength"), "100");

        //Step 7: Enter Store Name
        myStore.getStoreNameField().setText("My Store Final");

        //Step 8: Enter Location Description
        myStore.getLocationDescriptionField().setText("Without Stripe Account");

        //Step 9: Select Store Address
        String storeAddressName = "123";
        myStore.selectStoreAddress(storeAddressName);

        //Verifying the maximum length of 'Phone' field
        Assertions.assertEquals(myStore.getPhoneField().getAttribute("maxlength"), "22");

        //Step 10: Enter Phone Number
        myStore.getPhoneField().setText("9180652348");

        //Step 11: Select Time Zone
        myStore.selectTimeZone();

        //Verifying the minimum, maximum and default values of taxRate field
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("min"), "0");
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("value"), "0.000");
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("max"), "100");

        //Step 12: Enter Tax rate
        myStore.getTaxRateField().setText("10.000");

        //Step 13: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Step 14: Click on 'Continue' Button
        myStore.getContinueButton().click();
    }

    @Test(description = "SC_01(B) Verifying deletion of Store when Stripe Account is not Registered Yet")
    public void sc01b_DeletionOfStore() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Register New Business' Button
        myStore.getRegisterNewBusinessButton().click();

        //Step 3: Click on 'Skip' Button
        myStore.getSkipStripeAccountButton().click();

        //Verifying the 'Skip' Pop Up Title
        Assertions.assertEquals(myStore.getSkipPopUpTitle().getText(), "Skip");

        //Step 4: Click on 'Skip' button
        myStore.getSkipStripeAccountPopUpButton().click();

        //Step 5: Click on 'Delete' Button
        myStore.getDeleteStoreButton().click();

        //Step 6: Click on 'Confirmation' icon
        myStore.getDeleteStoreIcon().click();
    }

    @Test(description = "SC_02 Verify creation of Store with Stripe Payment Account")
    public void sc02_CreationOfStoreWithStripeAccount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Register New Business' Button
        myStore.getRegisterNewBusinessButton().click();

        //Step 3: Click on 'Stripe Account' Button
        myStore.getStipeAccountButton().click();

        //Verifying the 'Connect To Stripe' PopUp Title
        Assertions.assertEquals(myStore.getConnectStripePopUpTitle().getText(), "Connect to stripe");

        //Step 4: Click on 'Test Stripe Account' Button
        myStore.getTestStripeAccountButton().click();

        //Step 5: Click on 'Bank Transfer' toggle button
        myStore.getBankTransferToggleButton().click();

        //Step 6: Click on 'Continue' Button
        myStore.getContinueButton().click();

        //Step 7: Click on 'Skip For Now' Button
        myStore.getSkipForNowButton().click();

        //Step 8: Click on 'Continue' Button
        myStore.getContinueButton().click();

        //verifying the default Values of the Store
        String defaultStoreName = "Avenue";
        String defaultLocationDescription = "Dix Hills";
        String defaultStoreAddress = "8 Glover Dr, Dix Hills, NY 11746, USA";
        String defaultStorePhone = "+1 (646) 713 6494";
        String defaultCurrency = "USD";
        String defaultTaxRate = "0.000%";
        Assertions.assertEquals(myStore.getAddedStoreName().getText(), defaultStoreName);
        Assertions.assertEquals(myStore.getAddedLocationDescription().getText(), defaultLocationDescription);
        Assertions.assertEquals(myStore.getAddedStoreAddress().getText(), defaultStoreAddress);
        Assertions.assertEquals(myStore.getAddedStorePhone().getText(), defaultStorePhone);
        Assertions.assertEquals(myStore.getAddedCurrencyOfStore().getText(), defaultCurrency);
        Assertions.assertEquals(myStore.getAddedTaxRate().getText(), defaultTaxRate);
    }

    @Test(description = "SC_03 Verifying modification of existing created Store")
    public void sc03_VerifyingModificationOfExistingCreatedStore() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Link
        myStore.getConfigureLink().click();

        //step 3: Click on 'Modify' Button
        myStore.getModifyButton().click();

        //Step 4: Upload Image for Store Logo
        myStore.getStoreLogo().click();
        myStore.uploadImageInStoreLogo();
        myStore.getCheckButton().click();

        //Verifying the Maximum length of 'Store Name' field
        Assertions.assertEquals(myStore.getStoreNameField().getAttribute("max"), "100");

        //Step 5: Enter Store Name
        myStore.getStoreNameField().setText("My Store MSC Final");

        //Step 6: Enter Location Description
        myStore.getLocationDescriptionField().setText("With Stripe Account");

        //Step 7: Select Store Address
        String storeAddressName = "123";
        myStore.selectStoreAddress(storeAddressName);

       //Verifying maximum length of 'Phone' field
        Assertions.assertEquals(myStore.getPhoneField().getAttribute("maxlength"), "22");

        //Step 8: Enter Phone Number
        myStore.getPhoneField().setText("9180652341");

        //Step 9: Select Time Zone
        myStore.selectTimeZone();

        //Verifying the Maximum and Default Values of 'Tax Rate' field
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("value"), "0.000");
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("max"), "100");

        //Step 10 Enter Tax Rate
        myStore.getTaxRateField().setText("18.000");
        myStore.getSaveButton().click();
        WebdriverWaits.sleep(3000);

        //Verifying Modified Details
        String defaultStoreName = "My Store MSC Final";
        String defaultStorePhone = "+1 (918) 065 2341";
        String defaultCurrency = "USD";
        String defaultTaxRate = "18.000%";
        Assertions.assertEquals(myStore.getAddedStoreName().getText(), defaultStoreName);
        Assertions.assertEquals(myStore.getAddedStorePhone().getText(), defaultStorePhone);
        Assertions.assertEquals(myStore.getAddedCurrencyOfStore().getText(), defaultCurrency);
        Assertions.assertEquals(myStore.getAddedTaxRate().getText(), defaultTaxRate);
    }

    @Test(description = "SC_04(A) Verifying buying Monthly Business Plan for already created Store")
    public void sc04a_VerifyingBuyingMonthlyBusinessPlanForAlreadyCreatedStore() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Link
        myStore.getConfigureLink().click();

        //Step 3: Click on 'Plans' sub-tab
        myStore.getPlansSubTab().click();

        //Verifying that 'Current Plan' appears under Essential Free Plan
        Assertions.assertEquals(myStore.getCurrentPlanSuccessMessage().getText(), "Current plan");

        //Step 4: Click on 'Sign up' button
        myStore.getPlansSignUpButton().click();

        //Verifying that by-default Visa Payment method is enabled
        Assertions.assertEquals(myStore.getDefaultPaymentMethod().getText(), "Visa 1111");

        //Step 5: Click on 'Change Pay Method' Link
        myStore.getChangePayMethodLink().click();

        //Verifying that other payment methods are available
        Assertions.assertTrue(myStore.getNewCreditCardButton().isDisplayed());
        Assertions.assertTrue(myStore.getNewBankAccountButton().isDisplayed());

        //Step 6: Click on 'Terms' Checkbox
        myStore.getTermsCheckbox().click();

        //Step 7: Click on 'Change Plan' Button
        myStore.getChangePlanButton().click();

        //Verifying that next bill date is generated
        Assertions.assertTrue(myStore.getNextBillDate().isDisplayed());
    }

    @Test(description = "SC_04(B) Verifying buying Yearly Business Plan for already created Store")
    public void sc04b_VerifyingBuyingYearlyBusinessPlanForAlreadyCreatedStore() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Link
        myStore.getConfigureLink().click();

        //Step 3: Click on 'Plans' Sub-Tab
        myStore.getPlansSubTab().click();

        //Verifying that 'Current Plan' appears under Essential Free Plan
        Assertions.assertEquals(myStore.getCurrentPlanSuccessMessage().getText(), "Current plan");

        //Step 4: Click on 'Yearly Plan' Button
        myStore.getYearlyPlanButton().click();

        //Step 5: Click on 'Sign up' button
        myStore.getPlansSignUpButton().click();

        //Verifying that by-default Visa Payment method is enabled
        Assertions.assertEquals(myStore.getDefaultPaymentMethod().getText(), "Visa 1111");

        //Step 6: Click on 'Change Pay Method' link
        myStore.getChangePayMethodLink().click();

        //Verifying that other payment methods are available
        Assertions.assertTrue(myStore.getNewCreditCardButton().isDisplayed());
        Assertions.assertTrue(myStore.getNewBankAccountButton().isDisplayed());

        //Step 7: Click on 'Terms' Checkbox
        myStore.getTermsCheckbox().click();

        //Step 8: Click on 'Change Plan' Button
        myStore.getChangePlanButton().click();
    }

    @Test(description = "SC_05(A) Verifying the Configuration of already created Store using Settings Sub-Tabs")
    public void sc05a_VerifyingConfigurationsOfStoreUsingSettings() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Settings' Sub-Tab
        myStore.getSettingsSubTab().click();

        //Verifying Minimum, Maximum and Default values of 'Maximum Bill Amount' Field
        String defaultBillAmount = "3000.00";
        String maximumBillAmount = "50000.00";
        String minimumBillAmount = "50.00";
        Assertions.assertEquals(myStore.getMaximumBillAmountField().getAttribute("value"), defaultBillAmount);
        Assertions.assertEquals(myStore.getMaximumBillAmountField().getAttribute("max"), maximumBillAmount);
        Assertions.assertEquals(myStore.getMaximumBillAmountField().getAttribute("min"), minimumBillAmount);

        //Step 4: Enter amount in 'Maximum Bill Amount' field
        myStore.getMaximumBillAmountField().setText("5000.00");

        //Step 5: Click on 'Tip & Gratuity' toggle button
        myStore.getTipGratuityToggleButton().click();

        //Step 6: Click on 'Configure' button
        myStore.getTipConfigureButton().click();

        //Verifying the 'Tip Configuration' Pop-up Title
        Assertions.assertEquals(myStore.getTipConfigPopUpTitle().getText(), "Tip configuration");

        //Verifying the Default and maximum values of 'Tip Amount' field
        Assertions.assertEquals(myStore.getTipAmountPerCentField1().getAttribute("value"), "0");
        Assertions.assertEquals(myStore.getTipAmountPerCentField1().getAttribute("max"), "99");

        //Step 7: Enter Tip Values
        myStore.getTipAmountPerCentField1().setText("10");
        myStore.getTipAmountPerCentField2().setText("20");
        myStore.getTipAmountPerCentField3().setText("30");

        //Step 8: Click on 'Save Changes' button
        myStore.getSaveChangesButton().click();

        //Step 9: Click on 'Configure' button
        myStore.getRewardConfigureButton().click();

        //Verifying the 'Rewards Configuration' Pop-Up Title
        Assertions.assertEquals(myStore.getRewardConfigPopUpTitle().getText(), "Rewards Program Configuration");

        //Step 10: Click on 'Reward Point' Toggle button
        myStore.getRewardPointToggleButton().click();

        //Verifying the Minimum and Maximum Values of 'Reward Points' Field
        Assertions.assertEquals(myStore.getRewardPointsField().getAttribute("min"), "100");
        Assertions.assertEquals(myStore.getRewardPointsField().getAttribute("max"), "99999");

        //Step 11: Enter Reward Points
        myStore.getRewardPointsField().setText("1000");

        //Step 12: Click on 'Save Changes' Button
        myStore.getSaveChangesButton().click();

        //Step 13: Click on 'Store Links' button
        myStore.getStoreLinksButton().click();

        //Verifying the minimum and maximum values of 'Reward Points' field
        Assertions.assertEquals(myStore.getRewardPointsValueField().getAttribute("min"), "1");
        Assertions.assertEquals(myStore.getRewardPointsValueField().getAttribute("max"), "9999");

        //Step 14: Enter Reward Point Values
        myStore.getRewardPointsValueField().setText("1000");

        //Step 15: Enter Website URL
        myStore.getWebsiteURLField().setText("www.KadePay.com");

        //Step 16: Click on 'Earn Rewards Points' Toggle Button
        myStore.getEarnRewardsPointsToggleButton().click();

        //Step 17: Click on 'Save Changes' Button
        myStore.getSaveChangesButton().click();
    }

    @Test(description = "SC_05(B) Verifying the Configuration of the Store using flat value in 'tip or gratuity' field")
    public void sc05b_VerifyingConfigurationsOfStoreUsingFlatValueInTipField() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Store' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Settings' Sub-Tab
        myStore.getSettingsSubTab().click();

        //Step 4: Click on 'Tip & Gratuity' Toggle Button
        myStore.getTipGratuityToggleButton().click();

        //Step 5: Click on 'Configure' button
        myStore.getTipConfigureButton().click();

        //Verifying the 'Tip Configuration' Pop-up Title
        Assertions.assertEquals(myStore.getTipConfigPopUpTitle().getText(), "Tip configuration");

        //Step 6: Click on 'Enter in Percentage' Toggle button
        myStore.getEnterInPerCentToggleButton().click();

        //Verifying the maximum and minimum values of 'Tip Amount' field
        Assertions.assertEquals(myStore.getTipAmountFlatValueField1().getAttribute("value"), "0");
        Assertions.assertEquals(myStore.getTipAmountFlatValueField1().getAttribute("max"), "99");

        //Step 7: Enter Tip Values
        myStore.getTipAmountFlatValueField1().setText("10.00");
        myStore.getTipAmountFlatValueField2().setText("20.00");
        myStore.getTipAmountFlatValueField3().setText("30.00");

        //Step 8: Click on 'Save Changes' Button
        myStore.getSaveChangesButton().click();
    }

    @Test(description = "SC_06 Verifying the Configuration of the Store using Payment Processing Sub-Tab")
    public void sc06_VerifyingConfigurationOfStoreUsingPaymentProcessingSubTab() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Store' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Payment-Processing' Sub-Tab
        myStore.getPaymentProcessingSubTab().click();

        //Step 4: Click on 'Accept Venmo' Toggle Button
        myStore.getAcceptVenmoToggleButton().click();

        //Step 5: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Verifying Maximum length of 'VenmoID' field
        Assertions.assertEquals(myStore.getVenmoIdField().getAttribute("maxlength"), "40");

        //Step 6: Enter ID in 'Venmo ID" field
        myStore.getVenmoIdField().setText("1234");

        //Verifying maximum length of 'Venmo Name' field
        Assertions.assertEquals(myStore.getVenmoNameField().getAttribute("maxlength"), "40");

        //Step 7: Enter name in 'Venmo Name' Field
        myStore.getVenmoNameField().setText("Ven1");

        //Step 8: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Step 9: Click on 'Accept Zelle" toggle button
        myStore.getAcceptZelleToggleButton().click();

        //Step 10: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Verifying maximum length of 'Zelle Phone' field
        Assertions.assertEquals(myStore.getZellePhoneField().getAttribute("maxlength"), "40");

        //Step 11: Enter Phone Number in 'Zelle Phone' Field
        myStore.getZellePhoneField().setText("1234567890");

        //Verifying maximum length of 'Zelle Name' field
        Assertions.assertEquals(myStore.getZelleNameField().getAttribute("maxlength"), "40");

        //Step 12: Enter Zelle Account Name
        myStore.getZelleNameField().setText("Zel1");

        //Step 13: Click on 'Save' Button
        myStore.getSaveButton().click();

        //Step 14: Click on 'Credit Card Terminal' button
        myStore.getCreditCardTerminalButton().click();

        //Step 15: Click on 'Add new Terminal' button
        myStore.getAddNewTerminalButton().click();

        //Verifying the 'New Terminal' Pop-Up Title
        Assertions.assertEquals(myStore.getNewTerminalPopUpTitle().getText(), "New Terminal");

        //Step 16: Select an option
        myStore.getCreditTerminalOption().click();

        //Step 17: Click on 'Save' Button
        myStore.getSaveButton().click();
    }
    @Test(description = "SC_07(A) Verifying the Configuration of the Store using 'Manage Users' Sub-Tab")
    public void sc07a_VerifyingConfigurationOfStoreUsingManageUsersSubTabs(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Store' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Manage User' Sub Tab
        myStore.getManageUserSubTab().click();

        //Step 4: Click on 'Add User' Button
        myStore.getAddUserButton().click();

        //Verifying 'Add User' Pop-Up Title
        Assertions.assertEquals(myStore.getAddUserPopUpTitle().getText(), "Add User");

        //Step 5: Enter UserName in 'Username' field
        myStore.getManageUserNameField().setText("Manage store user");

        //Verifying the Maximum length of 'Username' field.
        Assertions.assertEquals(myStore.getManageUserNameField().getAttribute("maxlength"), "30");

        //Step 6: Click on the 'User Profile' Drop Down
        myStore.getUserProfileDropDown().click();

        //Step 7: Select profile of 'Manager' User
        myStore.getManagerProfileOption().click();

        //Step 8: Enter password in 'Password' field
        myStore.getManageUserPassword().setText("Test@123");

        //Verifying the Maximum length of 'Password' field
        Assertions.assertEquals(myStore.getManageUserPassword().getAttribute("maxlength"), "18");

        //Step 9: Click on 'Create User' Button
        myStore.getCreateUserButton().click();
    }

    @Test(description = "SC_07(B) Verifying the Configuration of the store using Manage User sub tab to invite any existing user to manage store.")
    public void sc_07b_VerifyingConfigurationOfStoreUsingManageUserSubTabToInviteAnyExistingUserToManageStore() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Store' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Manage User' Sub Tab
        myStore.getManageUserSubTab().click();

        //Step 4: Click on 'Invite Existing User' Button
        myStore.getInviteExistingUserButton().click();

        //Verifying the 'Invite Existing User' PopUp Title
        Assertions.assertEquals(myStore.getInviteExistingUserPopupTitle().getText(), "Invite users");

        //Step 5: Enter Email Or Phone Number
        myStore.getInviteUserEmailOrPhoneField().setText("6465551106");

        //Step 6: Click on the 'User Profile' Drop Down
        myStore.getUserProfileDropDown().click();

        //Step 7: Selecting profile of Manager User
        myStore.getManagerProfileOption().click();

        //Step 8: Click on 'Send Invite' Button.
        myStore.getSendInviteButton().click();
    }

    @Test(description = "SC_08 Verify deactivating an activated Store")
    public void sc_08_VerifyDeactivatingAnActivatedStore(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1:Click on 'My Store' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Configure' Button
        myStore.getConfigureButton().click();

        //Step 3: Click on 'Active' Sub-tab
        myStore.getActiveSubTab().click();

        //Step 4: Click on 'Deactivate' Button
        myStore.getDeactivateButton().click();

        //Verifying that store gets Deactivated and success message appears
        Assertions.assertEquals(myStore.getNotActiveStoreLabel().getText(), "Store is NOT active (Deactivated)");

        //Step 5: Click on 'Activate' Button
        myStore.getActivateButton().click();

        //Verifying that store gets Deactivated and success message appears
        Assertions.assertEquals(myStore.getActiveStoreLabel().getText(), "Store is active and ready to receive payments");
    }
}
