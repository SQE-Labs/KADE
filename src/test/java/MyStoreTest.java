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

    @BeforeMethod
    public void navigateToDashboard() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(description = "SC_01 Verifying creation of Store without Stripe Payment Account Configuration")
    public void sc01_StoreCreationWithoutStripeAccount() throws AWTException {
        //Clicking MyStore sub-tab
        dashboard.clickOnMyStores();

        //Creating New Store
        myStore.clickRegisterNewBusinessBtn();
        myStore.clickSkipStripeAccountBtn();
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(myStore.getSkipPopUpTitle(), "Skip");
        myStore.clickSkipStripeAccountPopUpBtn();
        WebdriverWaits.sleep(3000);

        //Entering Store Details
        myStore.clickSaveBtn();
        Assertions.assertEquals(myStore.getBlankFieldWarningMsg(), "Please review the highlighted field(s)");
        myStore.clickStoreLogo();//Fix this
        myStore.uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
        String businessName = "My Store MSC Final";
        Assertions.assertEquals(myStore.getBusinessFieldMaxLen(), "100");
        myStore.enterBusinessName(businessName);
        String locDescription="Without Stripe Account";
        myStore.enterLocationDescription(locDescription);
        String storeAddressName = "123";
        myStore.selectStoreAddress(storeAddressName);
        String phone = "9180652348";
        Assertions.assertEquals(myStore.getPhoneFieldMaxLen(), "22");
        myStore.enterPhone(phone);
        myStore.selectTimeZone();
        String taxRate = "10.000";

        //Verifying the min, max and default values of taxRate field
        Assertions.assertEquals(myStore.getTaxFieldMinValue(), "0");
        Assertions.assertEquals(myStore.getTaxFieldDefaultValue(), "0.000");
        Assertions.assertEquals(myStore.getTaxFieldMaxValue(), "100");
        myStore.enterTax(taxRate);
        myStore.clickSaveBtn();
        myStore.clickContinueBtn();
    }

    @Test(description = "SC_02 Verifying deletion of Store when Stripe Account is not Configured")
    public void sc02_DeletionOfStore() {
        //Clicking MyStore sub-tab
        dashboard.clickOnMyStores();
        myStore.clickRegisterNewBusinessBtn();

        //Skipping Stripe Account option
        myStore.clickSkipStripeAccountBtn();
        WebdriverWaits.sleep(3000);
        Assertions.assertEquals(myStore.getSkipPopUpTitle(), "Skip");
        myStore.clickSkipStripeAccountPopUpBtn();
        WebdriverWaits.sleep(5000);

        //Deleting the Store
        myStore.clickDeleteStoreBtn();
        WebdriverWaits.sleep(3000);
        myStore.clickDeleteStoreIcon();
    }

    @Test(description = "SC_03 Verify creation of Store with Stripe Payment Account")
    public void sc03_CreationOfStoreWithStripeAccount() {
        //Click MyStore sub-tab
        dashboard.clickOnMyStores();

        //Click Register New Business Button
        myStore.clickRegisterNewBusinessBtn();
        myStore.clickStripeBtn();

        //Creating test Stripe Account
        Assertions.assertEquals(myStore.getConnectStripePopUpTitle(), "Connect to stripe");
        myStore.clickTestStripeBtn();
        myStore.enableBankTransfer();
        myStore.clickContinueBtn();
        myStore.clickSkipForNowBtn();
        myStore.clickContinueBtn();
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
        //Click on MyStore sub-tab
        dashboard.clickOnMyStores();

        //Click on Configure Link
        myStore.clickConfigureLink();

        //Click on Modify Button
        myStore.clickModifyBtn();
        String businessName = "My Store MSC Final";
        Assertions.assertEquals(myStore.getBusinessFieldMaxLen(), "100");
        myStore.enterBusinessName(businessName);
        String locDescription="With Stripe Account";
        myStore.enterLocationDescription(locDescription);
        String storeAddressName = "123";
        myStore.selectStoreAddress(storeAddressName);
        String phone = "9180652341";
        Assertions.assertEquals(myStore.getPhoneFieldMaxLen(), "22");
        myStore.enterPhone(phone);
        myStore.selectTimeZone();
        String taxRate = "18.000";
        Assertions.assertEquals(myStore.getTaxFieldDefaultValue(), "0.000");
        Assertions.assertEquals(myStore.getTaxFieldMaxValue(), "100");
        myStore.enterTax(taxRate);
        myStore.clickSaveBtn();
        WebdriverWaits.sleep(3000);

        //Verifying Modified Details
        Assertions.assertEquals(myStore.getAddedStoreName(), businessName);
        Assertions.assertEquals(myStore.getAddedStorePhone(), "+1 (918) 065 2341");
        Assertions.assertEquals(myStore.getAddedCurrencyOfStore(), "USD");
        Assertions.assertEquals(myStore.getAddedTaxRate(), "18.000%");
    }

    @Test(description = "SC_05 Verifying buying Monthly Business Plan for already created Store")
    public void sc05_VerifyingBuyingMonthlyBusinessPlanForAlreadyCreatedStore() {
        //Clicking MyStore sub-tab
        dashboard.clickOnMyStores();

        //Click on Configure link of already created Store
        myStore.clickConfigureLink();
        myStore.clickPlansSubTab();

        //Click on Sign up button
        Assertions.assertEquals(myStore.getCurrentPlanSuccessMSg(), "Current plan");
        myStore.clickPlanSignUpBtn();
        Assertions.assertEquals(myStore.defaultPaymentMethod(), "Visa 1111");
        myStore.clickChangePayMethodBtn();

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


