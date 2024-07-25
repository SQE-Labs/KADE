import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.MyStorePage;
import org.automation.pageObjects.newBusinessPage;
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
//    newBusinessPage newBusiness = new newBusinessPage();

	@BeforeMethod
	public void navigateToDashboard() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
	}

	@AfterMethod
	public void logout() {
		dashboard.signOut();
	}
	@Test(description="TC_01 Verifying creation of Store without Stripe Payment Account Configuration")
	public void tc01_StoreCreationWithoutStripeAccount() throws AWTException {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		//Creating New Store
		myStore.clickRegisterNewBusinessBtn();
		myStore.clickSkipStripeAccountBtn();
		WebdriverWaits.sleep(3000);
		myStore.clickSkipStripeAccountPopUpBtn();
		WebdriverWaits.sleep(3000);

		//Entering Store Details
		myStore.clickStoreLogo();//Fix this
		myStore.uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
		String businessName = "Test Store-1";
		myStore.enterBusinessName(businessName);
		String storeAddressName="123";
		myStore.selectStoreAddress(storeAddressName);
		String phone="9180652348";
		myStore.enterPhone(phone);
		myStore.selectTimeZone();
		String taxRate="10.000";
		myStore.enterTax(taxRate);
		myStore.clickSaveBtn();//Fix this
	}

	@Test(description = "TC_02 Verifying deletion of Store when Stripe Account is not Configured")
	public void tc02_DeletionOfStore() {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		myStore.clickRegisterNewBusinessBtn();

		//Skipping Stripe Account option
		myStore.clickSkipStripeAccountBtn();
		WebdriverWaits.sleep(3000);
		myStore.clickSkipStripeAccountPopUpBtn();
		WebdriverWaits.sleep(5000);

		//Deleting the Store
		myStore.clickDeleteStoreBtn();
		WebdriverWaits.sleep(3000);
		myStore.clickDeleteStoreIcon();
	}
	@Test(description = "TC_03 Verify creation of Store with Stripe Payment Account including terminal configuration")
	public void tc03_CreationOfStoreWithStripeAccount() {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		myStore.clickRegisterNewBusinessBtn();
		myStore.clickStripeBtn();

		//Creating test Stripe Account
		myStore.clickTestStripeBtn();
		myStore.enableBankTransfer();
		myStore.clickContinueBtn();
		myStore.clickConfigureCreditCardTerminals();
		myStore.selectCreditCardTerminal();
		myStore.clickCreditSaveBtn();
		myStore.clickSkipForNowBtn();
		myStore.clickContinueBtn();
	}

	@Test(description = "TC_04 Verifying modification of existing created Store")
	public void tc04_VerifyingModificationOfExistingCreatedStore() {
		//Clicking MyStore sub-tab
		dashboard.clickOnMyStores();

		myStore.clickConfigureLink();
		myStore.clickModifyBtn();
		String businessName = "Test Store-2";
		myStore.enterBusinessName(businessName);
		String storeAddressName="123";
		myStore.selectStoreAddress(storeAddressName);
		String phone="9180652341";
		myStore.enterPhone(phone);
		myStore.selectTimeZone();
		String taxRate="18.000";
		myStore.enterTax(taxRate);
		myStore.clickSaveBtn();//Fix this

	}

}


