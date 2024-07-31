import java.awt.*;
import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.MyStorePage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest {

	@Test(description = "SC_01 Verifying creation of Store without Stripe Payment Account Configuration")
	public void sc01_StoreCreationWithoutStripeAccount() throws AWTException {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		//Creating New Store
		myStore.getRegisterNewBusinessButton().click();
		myStore.getSkipStripeAccountButton().click();
		Assertions.assertEquals(myStore.getSkipPopUpTitle().getText(),"Skip");
		myStore.getSkipStripeAccountPopUpButton().click();

		//Entering Store Details
		myStore.getSaveButton().click();
		String blankFieldWarningMessage="Please review the highlighted field(s)";
		Assertions.assertEquals(myStore.getBlankFieldWarningMsg().getText(), blankFieldWarningMessage);
		myStore.getStoreLogo().click();
		myStore.uploadImageInStoreLogo();
		myStore.getCheckButton().click();
		String businessFieldMaximumLength="100";
		Assertions.assertEquals(myStore.getBusinessFieldMaxLen().getAttribute("maxlength"), businessFieldMaximumLength);
		myStore.getBusinessNameField().setText("My Store Final");
		myStore.getLocationDescriptionField().setText("Without Stripe Account");
		String storeAddressName = "123";
		myStore.selectStoreAddress(storeAddressName);
		String phoneFieldMaximumLength="22";
		Assertions.assertEquals(myStore.getPhoneFieldMaxLen().getAttribute("maxlength"), phoneFieldMaximumLength);
		myStore.getPhoneField().setText("9180652348");
		myStore.selectTimeZone();

		//Verifying the min, max and default values of taxRate field
		Assertions.assertEquals(myStore.getTaxFieldMinValue().getAttribute("min"), "0");
		Assertions.assertEquals(myStore.getTaxFieldDefaultValue().getAttribute("value"), "0.000");
		Assertions.assertEquals(myStore.getTaxFieldMaxValue().getAttribute("max"), "100");
		myStore.getTaxRateField().setText("10.000");
		myStore.getSaveButton().click();
		myStore.getContinueButton().click();
	}

	@Test(description = "SC_02 Verifying deletion of Store when Stripe Account is not Configured")
	public void sc02_DeletionOfStore() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		myStore.getRegisterNewBusinessButton().click();

		//Skipping Stripe Account option
		myStore.getSkipStripeAccountButton().click();
		Assertions.assertEquals(myStore.getSkipPopUpTitle().getText(),"Skip");
		myStore.getSkipStripeAccountPopUpButton().click();

		//Deleting the Store
		myStore.getDeleteStoreButton().click();
		WebdriverWaits.sleep(3000);
		myStore.getDeleteStoreIcon().click();
	}

	@Test(description = "SC_03 Verify creation of Store with Stripe Payment Account")
	public void sc03_CreationOfStoreWithStripeAccount() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		myStore.getRegisterNewBusinessButton().click();
		myStore.getStipeAccountButton().click();

		//Creating test Stripe Account
		Assertions.assertEquals(myStore.getConnectStripePopUpTitle().getText(), "Connect to stripe");
		myStore.getTestStripeAccountButton().click();
		myStore.getBankTransferToggleButton().click();
		myStore.getContinueButton().click();
		myStore.getSkipForNowButton().click();
		myStore.getContinueButton().click();
		WebdriverWaits.sleep(3000);

		//verifying the default Store Values
		String defaultStoreName="Avenue";
		String defaultLocationDescription="Dix Hills";
		String defaultStoreAddress="8 Glover Dr, Dix Hills, NY 11746, USA";
		String defaultStorePhone="+1 (646) 713 6494";
		String defaultCurrency="USD";
		String defaultTaxRate="0.000%";
		Assertions.assertEquals(myStore.getAddedStoreName().getText(), defaultStoreName);
		Assertions.assertEquals(myStore.getAddedLocationDescription().getText(), defaultLocationDescription);
		Assertions.assertEquals(myStore.getAddedStoreAddress().getText(), defaultStoreAddress);
		Assertions.assertEquals(myStore.getAddedStorePhone().getText(), defaultStorePhone);
		Assertions.assertEquals(myStore.getAddedCurrencyOfStore().getText(), defaultCurrency);
		Assertions.assertEquals(myStore.getAddedTaxRate().getText(), defaultTaxRate);
	}

	@Test(description = "SC_04 Verifying modification of existing created Store")
	public void sc04_VerifyingModificationOfExistingCreatedStore() throws AWTException {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		//Click on Configure Link
		myStore.getConfigureLink().click();

		//Click on Modify Button
		myStore.getModifyButton().click();
		myStore.getStoreLogo().click();
		myStore.uploadImageInStoreLogo();
		myStore.getCheckButton().click();
		Assertions.assertEquals(myStore.getBusinessFieldMaxLen().getAttribute("max"), "100");
		myStore.getBusinessNameField().setText("My Store MSC Final");
		myStore.getLocationDescriptionField().setText("With Stripe Account");
		String storeAddressName = "123";
		myStore.selectStoreAddress(storeAddressName);
		Assertions.assertEquals(myStore.getPhoneFieldMaxLen().getAttribute("maxlength"), "22");
		myStore.getPhoneField().setText("9180652341");
		myStore.selectTimeZone();
		Assertions.assertEquals(myStore.getTaxFieldDefaultValue().getAttribute("value"), "0.000");
		Assertions.assertEquals(myStore.getTaxFieldMaxValue().getAttribute("max"), "100");
		myStore.getTaxRateField().setText("18.000");
		myStore.getSaveButton().click();
		WebdriverWaits.sleep(3000);

		//Verifying Modified Details
		String defaultStoreName="My Store MSC Final";
		String defaultStorePhone="+1 (918) 065 2341";
		String defaultCurrency="USD";
		String defaultTaxRate="18.000%";
		Assertions.assertEquals(myStore.getAddedStoreName().getText(), defaultStoreName);
		Assertions.assertEquals(myStore.getAddedStorePhone().getText(), defaultStorePhone);
		Assertions.assertEquals(myStore.getAddedCurrencyOfStore().getText(), defaultCurrency);
		Assertions.assertEquals(myStore.getAddedTaxRate().getText(), defaultTaxRate);
	}

	@Test(description = "SC_05 Verifying buying Monthly Business Plan for already created Store")
	public void sc05_VerifyingBuyingMonthlyBusinessPlanForAlreadyCreatedStore() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		myStore.getConfigureLink().click();
		myStore.getPlansSubTab().click();

		//Click on Sign up button
		Assertions.assertEquals(myStore.getCurrentPlanSuccessMessage().getText(),"Current plan");
		myStore.getPlansSignUpButton().click();
		Assertions.assertEquals(myStore.getDefaultPaymentMethod().getText(), "Visa 1111");
		myStore.getChangePayMethodLink().click();

		//Verifying that other payment methods are available
		Assertions.assertTrue(myStore.getNewCreditCardButton().isDisplayed());
		Assertions.assertTrue(myStore.getNewBankAccountButton().isDisplayed());
		myStore.getTermsCheckbox().click();
		myStore.getChangePlanButton().click();
		Assertions.assertTrue(myStore.getNextBillDate().isDisplayed());
	}

	@Test(description = "SC_06 Verifying buying Yearly Business Plan for already created Store")
	public void sc06_VerifyingBuyingYearlyBusinessPlanForAlreadyCreatedStore() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		myStore.getConfigureLink().click();
		myStore.getPlansSubTab().click();
		Assertions.assertEquals(myStore.getCurrentPlanSuccessMessage().getText(),"Current plan");
		myStore.getYearlyPlanButton().click();

		//Click on Sign up button
		myStore.getPlansSignUpButton().click();
		Assertions.assertEquals(myStore.getDefaultPaymentMethod().getText(), "Visa 1111");
		myStore.getChangePayMethodLink().click();

		//Verifying that other payment methods are available
		Assertions.assertTrue(myStore.getNewCreditCardButton().isDisplayed());
		Assertions.assertTrue(myStore.getNewBankAccountButton().isDisplayed());
		myStore.getTermsCheckbox().click();
		myStore.getChangePlanButton().click();
	}

	@Test(description = "SC_07 Verifying the Configuration of already created Store using Settings Sub-Tabs")
	public void sc07_VerifyingConfigurationsOfStoreUsingSettings() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		//Click on Configure Button
		myStore.getConfigureButton().click();

		//Click on Settings Sub-Tab
		myStore.getSettingsSubTab().click();

		//Enter Maximum Bill Amount
		String defaultBillAmount="3000.00";
		String maximumBillAmount="50000.00";
		String minimumBillAmount="50.00";
		Assertions.assertEquals(myStore.getMinimumBillAmtValue().getAttribute("min"),defaultBillAmount);
		Assertions.assertEquals(myStore.getMaximumBillAmtValue().getAttribute("max"),maximumBillAmount);
		Assertions.assertEquals(myStore.getDefaultBillAmtValue().getAttribute("value"),minimumBillAmount);
		myStore.getMaximumBillAmountField().setText("5000.00");

		//Configure Tip & Gratuity
		myStore.getTipGrauityToggleButton().click();
		myStore.getTipConfigureButton().click();
		Assertions.assertEquals(myStore.getTipConfigPopUpTitle().getText(),"Tip configuration");
		Assertions.assertEquals(myStore.getDefaultTipAmtValue().getAttribute("value"),"0");
		Assertions.assertEquals(myStore.getMaxTipAmtValue().getAttribute("max"),"99");
		myStore.getTipAmountPerCentField1().setText("10");
		myStore.getTipAmountPerCentField2().setText("20");
		myStore.getTipAmountPerCentField3().setText("30");
		myStore.getSaveChangesButton().click();

		//Configure Reward Points
		myStore.getRewardConfigureButton().click();
		Assertions.assertEquals(myStore.getRewardConfigPopUpTitle().getText(),"Rewards Program Configuration");
		myStore.getRewardPointToggleButton().click();
		Assertions.assertEquals(myStore.getMinRewardPointsValue().getAttribute("min"), "100");
		Assertions.assertEquals(myStore.getMaxRewardPointsValue().getAttribute("max"),"99999");
		myStore.getRewardPointsField().setText("1000");
		myStore.getSaveChangesButton().click();

		//Configure Store Links
		myStore.getStoreLinksButton().click();
		Assertions.assertEquals(myStore.getMinRewardPointsFieldValue().getAttribute("min"), "1");
		Assertions.assertEquals(myStore.getMaxRewardPointsFieldValue().getAttribute("max"),"9999");
		myStore.getRewardPointsValueField().setText("1000");
		myStore.getWebsiteURLField().setText("www.KadePay.com");
		myStore.getEarnRewardsPointsToggleButton().click();
		myStore.getSaveChangesButton().click();
	}
	@Test(description = "SC_07(b) Verifying the Configuration of the Store using flat value in 'tip or gratuity' field")
	public void sc07b_VerifyingConfigurationsOfStoreUsingFlatValueInTipField() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();
		//Click on Configure Button
		myStore.getConfigureButton().click();

		//Click on Settings Sub-Tab
		myStore.getSettingsSubTab().click();

		//Configure Tip & Gratuity
		myStore.getTipGrauityToggleButton().click();
		myStore.getTipConfigureButton().click();
		Assertions.assertEquals(myStore.getTipConfigPopUpTitle().getText(),"Tip configuration");
		myStore.getEnterInPerCentToggleButton().click();
		Assertions.assertEquals(myStore.getDefaultTipAmtValue().getAttribute("value"),"0");
		Assertions.assertEquals(myStore.getMaxTipAmtValue().getAttribute("max"),"99");
		myStore.getTipAmountFlatValueField1().setText("10.00");
		myStore.getTipAmountFlatValueField2().setText("20.00");
		myStore.getTipAmountFlatValueField3().setText("30.00");
		myStore.getSaveChangesButton().click();
		}

	@Test(description = "SC_08 Verifying the Configuration of the Store using Payment Processing Sub-Tab")
	public void sc08_VerifyingConfigurationOfStoreUsingPaymentProcessingSubTab() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();
		//Click on Configure Button
		myStore.getConfigureButton().click();

		//Click on Payment-Processing Sub-Tab
		myStore.getPaymentProcessingSubTab().click();
	}
}
