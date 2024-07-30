import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.DashBoardPage;
import org.automation.pages.LoginPage;
import org.automation.pages.MyStorePage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest {
	LoginPage login = new LoginPage();
	DashBoardPage dashboard = new DashBoardPage();
	MyStorePage myStore = new MyStorePage();

	//@BeforeMethod
//	public void navigateToDashboard() {
//		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
//	}
//
//	//@AfterMethod
//	public void logout() {
//		dashboard.signOut();
//	}

	@Test(description = "SC_01 Verifying creation of Store without Stripe Payment Account Configuration")
	public void sc01_StoreCreationWithoutStripeAccount() throws AWTException {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		//Creating New Store
		myStore.getRegisterNewBusinessButton().click();
		myStore.getSkipStripeAccountButton().clickIfExist();
//		WebdriverWaits.sleep(3000);
//		Assertions.assertEquals(myStore.getSkipPopUpTitle(), "Skip");
		myStore.getSkipStripeAccountPopUpButton().clickIfExist();
//		WebdriverWaits.sleep(3000);

		//Entering Store Details
		myStore.getSaveButton().click();
		Assertions.assertEquals(myStore.getBlankFieldWarningMsg(), "Please review the highlighted field(s)");
		myStore.getStoreLogo().click();//Fix this
		myStore.uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
		Assertions.assertEquals(myStore.getBusinessFieldMaxLen(), "100");
		myStore.getBusinessNameField().setText("My Store Final");
		myStore.getLocationDescriptionField().setText("Without Stripe Account");
		String storeAddressName = "123";
		myStore.selectStoreAddress(storeAddressName);
		Assertions.assertEquals(myStore.getPhoneFieldMaxLen(), "22");
		myStore.getPhoneField().setText("9180652348");
		myStore.selectTimeZone();

		//Verifying the min, max and default values of taxRate field
		Assertions.assertEquals(myStore.getTaxFieldMinValue(), "0");
		Assertions.assertEquals(myStore.getTaxFieldDefaultValue(), "0.000");
		Assertions.assertEquals(myStore.getTaxFieldMaxValue(), "100");
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
		WebdriverWaits.sleep(3000);
		Assertions.assertEquals(myStore.getSkipPopUpTitle(), "Skip");
		myStore.getSkipStripeAccountPopUpButton().click();
		WebdriverWaits.sleep(5000);

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
		Assertions.assertEquals(myStore.getConnectStripePopUpTitle(), "Connect to stripe");
		myStore.getTestStripeAccountButton().click();
		myStore.getBankTransferToggleButton().click();
		myStore.getContinueButton().click();
		myStore.getSkipForNowButton().click();
		myStore.getContinueButton().click();
		WebdriverWaits.sleep(3000);

		//verifying the default Store Values
		Assertions.assertEquals(myStore.getAddedStoreName(), "Avenue");
		Assertions.assertEquals(myStore.getAddedBusinessName(), "Dix Hills");
		Assertions.assertEquals(myStore.getAddedStoreAddress(), "8 Glover Dr, Dix Hills, NY 11746, USA");
		Assertions.assertEquals(myStore.getAddedStorePhone(), "+1 (646) 713 6494");
		Assertions.assertEquals(myStore.getAddedCurrencyOfStore(), "USD");
		Assertions.assertEquals(myStore.getAddedTaxRate(), "0.000%");
	}

	@Test(description = "SC_04 Verifying modification of existing created Store")
	public void sc04_VerifyingModificationOfExistingCreatedStore() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();


		//Click on Configure Link
		myStore.getConfigureLink().click();

		//Click on Modify Button
		myStore.getModifyButton().click();
		Assertions.assertEquals(myStore.getBusinessFieldMaxLen(), "100");
		myStore.getBusinessNameField().setText("My Store MSC Final");
		myStore.getLocationDescriptionField().setText("With Stripe Account");
		String storeAddressName = "123";
		myStore.selectStoreAddress(storeAddressName);
		Assertions.assertEquals(myStore.getPhoneFieldMaxLen(), "22");
		myStore.getPhoneField().setText("9180652341");
		myStore.selectTimeZone();
		Assertions.assertEquals(myStore.getTaxFieldDefaultValue(), "0.000");
		Assertions.assertEquals(myStore.getTaxFieldMaxValue(), "100");
		myStore.getTaxRateField().setText("18.000");
		myStore.getSaveButton().click();
		WebdriverWaits.sleep(3000);

		//Verifying Modified Details
		Assertions.assertEquals(myStore.getAddedStoreName(), "My Store MSC Final");
		Assertions.assertEquals(myStore.getAddedStorePhone(), "+1 (918) 065 2341");
		Assertions.assertEquals(myStore.getAddedCurrencyOfStore(), "USD");
		Assertions.assertEquals(myStore.getAddedTaxRate(), "18.000%");
	}

	@Test(description = "SC_05 Verifying buying Monthly Business Plan for already created Store")
	public void sc05_VerifyingBuyingMonthlyBusinessPlanForAlreadyCreatedStore() {
		KadeSession session = KadeSession.login(KadeUserAccount.Default);
		session.getDashBoardPage().getMyStoresTab().click();
		MyStorePage myStore= session.getMyStorePage();

		myStore.getConfigureLink().click();
		myStore.getPlansSubTab().click();

		//Click on Sign up button
		Assertions.assertEquals(myStore.getCurrentPlanSuccessMSg(), "Current plan");
		myStore.getPlansSignUpButton().click();
		Assertions.assertEquals(myStore.defaultPaymentMethod(), "Visa 1111");
//		myStore.getChangePlanButton().clickChangePayMethodBtn();

		//Verifying that other payment methods are available
		Assertions.assertTrue(myStore.isNewCreditCardBtnDisplayed());
		Assertions.assertTrue(myStore.isNewBankAccountBtnDisplayed());
		myStore.selectVisaMethod();
		myStore.selectTermsCbx();
		myStore.clickChangePlanBtn();
		Assertions.assertTrue(myStore.isNextBillDateDisplayed());//Fix This
	}

	@Test(description = "SC_06 Verifying buying Yearly Business Plan for already created Store")
	public void sc06_VerifyingBuyingYearlyBusinessPlanForAlreadyCreatedStore() {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		//Click on Configure link of already created Store
		myStore.clickConfigureLink();
		myStore.clickPlansSubTab();
		Assertions.assertEquals(myStore.getCurrentPlanSuccessMSg(), "Current plan");
		myStore.clickYearlyBtn();

		//Click on Sign up button
		myStore.clickPlanSignUpBtn();
		Assertions.assertEquals(myStore.defaultPaymentMethod(), "Visa 1111");
		myStore.clickChangePayMethodBtn();

		//Verifying that other payment methods are available
		Assertions.assertTrue(myStore.isNewCreditCardBtnDisplayed());
		Assertions.assertTrue(myStore.isNewBankAccountBtnDisplayed());
		myStore.selectVisaMethod();//Fix This
		myStore.selectTermsCbx();
		myStore.clickChangePlanBtn();
	}

	@Test(description = "SC_07 Verifying the Configuration of already created Store using Settings Sub-Tabs")
	public void sc07_VerifyingConfigurationsOfStoreUsingSettings() {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		//Click on Configure link of already created Store
		myStore.clickConfigureBtn();

		//Click on Settings Sub-Tab
		myStore.clickSettingsSubTab();

		//Enter Max Bill Amount
		String maxBillAmt="5000.00";
		Assertions.assertEquals(myStore.getMinimumBillAmtValue(),"50.00");
		Assertions.assertEquals(myStore.getMaximumBillAmtValue(),"50000.00");
		Assertions.assertEquals(myStore.getDefaultBillAmtValue(),"3000.00");
		myStore.enterMaximumBillAmount(maxBillAmt);
		myStore.enableTipGratuityToggleBtn();

		//Configure Tip & Gratuity
		myStore.clickTipConfigureBtn();
		Assertions.assertEquals(myStore.getTipConfigPopUpTitle(),"Tip configuration");
		String tipAmt1="10";
		String tipAmt2="20";
		String tipAmt3="30";
		Assertions.assertEquals(myStore.getDefaultTipAmtValue(),"0");
		Assertions.assertEquals(myStore.getMaxTipAmtValue(),"99");
		myStore.enterTipAmt1(tipAmt1);
		myStore.enterTipAmt2(tipAmt2);
		myStore.enterTipAmt3(tipAmt3);
		myStore.clickSaveChangesBtn();

		//Configure Reward Points
		myStore.clickRewardConfigBtn();
		Assertions.assertEquals(myStore.getRewardConfigPopUpTitle(),"Rewards Program Configuration");
		myStore.enableRewardPointToggleBtn();
		String rewardPoints="1000";
		Assertions.assertEquals(myStore.getMinRewardPointsValue(), "100");
		Assertions.assertEquals(myStore.getMaxRewardPointsValue(),"99999");
		myStore.enterRewardPoints(rewardPoints);
		myStore.clickSaveChangesBtn();
	}

}
