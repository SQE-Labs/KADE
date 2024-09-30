package singleThreaded;

import org.automation.base.BasePage;
import org.automation.data.KadeUserAccount;
import org.automation.pages.MyStorePage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import java.awt.*;

public class MyStoreTest extends BasePage {
    @Test(enabled=true, description = "SC_01(A) Verifying creation of Store without Stripe Payment Account Configuration")
    public void sc01a_StoreCreationWithoutStripeAccount() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        String storeName = "My store " + RandomGenerator.requiredString(6);
        String phoneNumber = RandomGenerator.requiredNumber(10);
        String description = "Without Stripe Account" + RandomGenerator.requiredString(15);
        String storeAddressName = "123";

        //Step 1: Click on 'My Stores' Tab
        session.getDashBoardPage().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Register New Business' Button
        myStore.getRegisterNewBusinessButton().click();

        if(!myStore.getStoreLogo().isDisplayed()) {

            //Step 3: Click on 'Skip' button
            myStore.getSkipStripeAccountButton().click();

            //Verifying the 'Skip' PopUp Title
            Assertions.assertEquals(myStore.getSkipPopUpTitle().getText(), "Skip");

            //Step 4: Click on 'Skip' Button
            WebdriverWaits.sleep(2000);
            myStore.getSkipStripeAccountPopUpButton().clickByMouse();
        }

        //Step 5: Click on 'Save' Button
        myStore.getSaveButton().clickByMouse();

        //Verify the validation message
        String blankFieldWarningMessage = "Please review the highlighted field(s)";
        Assertions.assertEquals(myStore.getBlankFieldWarningMsg().getText(), blankFieldWarningMessage);

        //Step 6: Upload Image for Store Logo
        WebdriverWaits.sleep(3000);
        myStore.getStoreLogo().click();
        myStore.uploadImageInStoreLogo();
        myStore.getCheckButton().click();

        //Verifying maximum length of 'Store Name' field
        Assertions.assertEquals(myStore.getStoreNameField().getAttribute("maxlength"), "100");

        //Step 7: Enter Store Name
        myStore.getStoreNameField().setText(storeName);

        //Step 8: Enter Location Description
        myStore.getLocationDescriptionField().setText(description);

        //Step 9: Select Store Address
        myStore.selectStoreAddress(storeAddressName);

        //Verifying the maximum length of 'Phone' field
        Assertions.assertEquals(myStore.getPhoneField().getAttribute("maxlength"), "22");

        //Step 10: Enter Phone Number
        myStore.getPhoneField().setText(phoneNumber);

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

        //Verify Created Store
        Assertions.assertEquals(myStore.getAddedStoreName().
                getText(), storeName);
        Assertions.assertEquals(myStore.getAddedStorePhone().getText().replaceAll("[+()\\s-]", "").substring(1,11), phoneNumber);
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
        myStore.getStoreLogo().clickByMouse();
        myStore.uploadImageInStoreLogo();
        WebdriverWaits.sleep(2000);
        myStore.getCheckButton().click();

        //Verifying the Maximum length of 'Store Name' field
        Assertions.assertEquals(myStore.getStoreNameField().getAttribute("maxlength"), "100");

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
//        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("value"), "10.000");
        Assertions.assertEquals(myStore.getTaxRateField().getAttribute("max"), "100");

        //Step 10 Enter Tax Rate
        myStore.getTaxRateField().setText("18.000");
        myStore.getSaveButton().clickByMouse();
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

        //Reset Store to default
        myStore.getModifyButton().click();
        myStore.getStoreNameField().setText("Automation Flow 3");
        myStore.getLocationDescriptionField().setText("Without Stripe Account");
        myStore.getPhoneField().setText("9112212120");
        myStore.getTaxRateField().setText("0.000");
        myStore.getSaveButton().clickByMouse();

    }

}
