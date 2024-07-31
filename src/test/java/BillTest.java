import java.awt.*;
import java.text.ParseException;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BillPage;
import org.automation.pages.DashBoardPage;
import org.automation.pages.LoginPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillTest extends BaseTest {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(enabled = true, description = "Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void tc_01createBillWithoutSelectingCustomer() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        // Verify New Bill popup Web Elements
         String popupTitle = session.getBillPage().getPopupTitle().getText();
        Assertions.assertEquals(popupTitle, "Bill");
        Assertions.assertTrue(session.getBillPage().getAmountTextbox().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getDescriptionTextbox().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getCustomerField().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getMoreOption().isDisplayed());

        // Verify Default value of Amount tab
        String defaultAmt = bill.getAttribute(bill.amtInput, "value");
        Assertions.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(session.getBillPage().getConfirmButton().isEnabled());

        //Enter amount
        String amt = "2,999.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(session.getBillPage().getConfirmButton().isEnabled());

        //Click Confirm
        session.getBillPage().getConfirmButton().click();

        //Verify Message popup and Buttons
        Assertions.assertEquals(session.getBillPage().getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(session.getBillPage().getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getContinueWithoutButton().isDisplayed());

        //Click On Continue Button
        session.getBillPage().getContinueWithoutButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        //Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Close popup
        session.getBillPage().getCloseLogoPopupBtn().click();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void tc_02createBillBySelectingCustomer() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        // Verify New Bill popup
        String popupTitle = session.getBillPage().getPopupTitle().getText();
        Assertions.assertEquals(popupTitle, "Bill");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(session.getBillPage().getConfirmButton().isEnabled());

        //Enter amount
        String amt = "1,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(session.getBillPage().getConfirmButton().isEnabled());

        //Click Confirm
        session.getBillPage().getConfirmButton().click();

        //Verify Message popup and Buttons
        Assertions.assertEquals(session.getBillPage().getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(session.getBillPage().getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getContinueWithoutButton().isDisplayed());

        session.getBillPage().getSelectACustomerButton().click();

        //Verify Customer popup
        Assertions.assertTrue(session.getBillPage().getCustomerPhnNoField().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getEmailField().isDisplayed());
        Assertions.assertTrue(session.getBillPage().getSearchField().isDisplayed());


        //Select Customer
        session.getBillPage().getCustomerPhnNoField().setText("918877070727");
        session.getBillPage().getGoPhoneNumberButton().click();


        //Click Confirm
        bill.disableTaxToggle();
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Close popup
        session.getBillPage().getCloseLogoPopupBtn().click();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();
    }

    @Test(enabled = false, description = "Bill creation by selecting customers from the suggestion list")
    public void tc_03createBillForSuggestedCustomer() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();
        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();
        //Enter amount
        String amt = "105.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();
        bill.disableTaxToggle();
        session.getBillPage().getConfirmButton().click();
        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Close popup
        session.getBillPage().getCloseLogoPopupBtn().click();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = false, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_04createBillForConfiguredTax() throws ParseException {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "2500.00";
        session.getBillPage().getAmountTextbox().setText(amt);

        //Enable Tax toggle Button
        bill.enableTaxToggle();

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        ;
        session.getBillPage().getSuggestedCustomer().click();
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        session.getBillPage().getCloseLogoPopupBtn().click();
        String total = bill.convertToNumberFormat(totalAmt);
        System.out.println(total);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(total));
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.isBillTimeDisplayed(total));

        session.getBillPage().deleteUnpaidBill();
    }

    @Test(enabled = false, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_06createBillByAttachingImage() throws ParseException, AWTException {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "1760.00";
        session.getBillPage().getAmountTextbox().setText(amt);

        //Enable Tax toggle Button
        bill.enableTaxToggle();

        //Add Attachment(Image)
        bill.clickTapToAddFiles();
        bill.clickCameraIcon();
        bill.uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
        bill.ClickCheckBtn();
        //Verify Added Image
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Close popup
        session.getBillPage().getCloseLogoPopupBtn().click();

        //Verify Created Bill
        String total = bill.convertToNumberFormat(totalAmt);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(total));
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.isBillTimeDisplayed(total));

        // Verify Attached File
        bill.openBillByAmt(total);
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);
        bill.closeCreatedBill();

    }

    @Test(enabled = false, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_07createBillByAttachingPdf() throws AWTException {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "879.99";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Add Attachment (PDF)
        bill.clickTapToAddFiles();
        bill.clickDocumentIcon();
        bill.uploadImageAsAttachment("src/main/resources/Documents/Bills.pdf");

        //Verify Added Image
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        // Verify Attached File
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        bill.closeCreatedBill();

        session.getBillPage().deleteUnpaidBill();
    }

    @Test(enabled = true, description = "Verify that unpaid bill gets deleted")
    public void tc_08verifyBillDeletion() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        //Delete the 1st unpaid bill
        bill.clickUnpaidBill();
        bill.clickDeleteButton();
        bill.clickDeleteIcon();
    }

    @Test(enabled = true, description = "Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void tc_09verifyBillCreationUsingOptionalFields() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();
        bill.disableTaxToggle();


        //Verify that optional fields are added to the bill
        bill.clickMoreOptions();
        String defaultPriceValue = bill.getDefaultPriceValue();
        Assertions.assertEquals(defaultPriceValue, "$0.00");

        //Verifying that 'None' text should appear by default in 'Reference' field
        Assertions.assertEquals(bill.getDefaultRefNoText(), "None");
        bill.clickRefNo();
        Assertions.assertEquals(bill.getRefPopUpTitle(), "Reference No.");
        String actualMaxRefLen = bill.getMaxRefLen();
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.enterRefNo(refNum);
        bill.clickDone();

        //Verifying that added reference number should appear under the 'Ref No' field.
        Assertions.assertEquals(bill.getRefNoText(), refNum);

        //Verifying that default text should be none in Description Field
        Assertions.assertEquals(bill.getDefaultDescText(), "None");
        bill.clickDescription();
        Assertions.assertEquals(bill.getDescPopUpTitle(), "Description");
        String actualMaxDescLen = bill.getMaxDescLen();
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.enterDescription(descriptionValue);

        //Verifying that added reference number should appear under the 'Description' field.
        bill.clickDone();
        Assertions.assertEquals(bill.getDescText(), descriptionValue);

        //Verifying that Description and Price fields appear
        Assertions.assertTrue(bill.isItemDesc1Displayed());
        Assertions.assertTrue(bill.isItemDesc2Displayed());
        Assertions.assertTrue(bill.isItemPrice1Displayed());
        Assertions.assertTrue(bill.isItemPrice2Displayed());
        String actualItemDescLen = bill.getMaxItemDescLen();
        Assertions.assertEquals(actualItemDescLen, "200");

        String actualItemPriceLen = bill.getMaxItemPriceLen();
        Assertions.assertEquals(actualItemPriceLen, "50000.00");


        String desc1 = "Tea";
        bill.enterItemDesc1(desc1);
        String price1 = "80.00";
        bill.enterItemPrice1(price1);
        String desc2 = "Coffee";
        bill.enterItemDesc2(desc2);
        String price2 = "120.00";
        bill.enterItemPrice2(price2);

        //Verifying that 'Add A line' button appear in the bill pop-up
        Assertions.assertTrue(bill.isAddALineBtnDisplayed());
        Assertions.assertEquals(bill.getAddALineBtnText(), "Add a line");
        bill.clickAddALineBtn();
        Assertions.assertTrue(bill.isItemDesc3Displayed());
        Assertions.assertTrue(bill.isItemPrice3Displayed());
        String desc3 = "Shake";
        bill.enterItemDesc3(desc3);
        String price3 = "150.00";
        bill.enterItemPrice3(price3);
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        //Verifying the total amount i.e 80+120+150
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("350.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("350.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("350.00"));
        Assertions.assertTrue(bill.isAddedDescriptionDisplayed());

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void tc_10verifyingBillCreationWithEssentialFreePlan() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "90.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        //Verify that optional fields are added to the bill
        bill.clickMoreOptions();

        Assertions.assertTrue(bill.isFreezeIcon1Present());
        bill.clickRepeatBtn();
        Assertions.assertTrue(bill.isNotNowBtnPresent());
        Assertions.assertTrue(bill.isUpgradeBtnPresent());
        Assertions.assertEquals(bill.getUpgradePopUpTitle(), "Upgrade your plan");
        bill.clickNotNowBtn();

        Assertions.assertTrue(bill.isFreezeIcon2Present());
        bill.clickExpiryBtn();
        bill.clickUpgradeBtn();


    }

    @Test(enabled = true, description = "Verify that creating a bill with default configured bill amount, on 'Bill' popup of 'Bills' page.")
    public void tc_11verifyingBillCreationWithConfiguredBillAmount() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "50,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();
        Assertions.assertEquals(bill.getMaxAmountInput(), "50000.00");

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt2 = "60,000.00";
        bill.enterAmount(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();
        Assertions.assertNotEquals(bill.getUnpaidAmount(), amt2);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("6,000.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("6,000.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("6,000.00"));

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill with default configured bill amount, on 'Bill' popup of 'Bills' page.")
    public void tc_12verifyingBillCreationWithOutConfiguredBillAmount() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business");
        session.getBillPage().getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "3,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt2 = "4,000.00";
        bill.enterAmount(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertNotEquals(bill.getUnpaidAmount(), amt2);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("400.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("400.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("400.00"));

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void tc_13verifyingBillCreationWithAddingMemoField() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        //New Business 2
        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        session.getBillPage().getContinueButton().click();

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "2,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        bill.clickMoreOptions();
        Assertions.assertEquals(bill.getDefaultMemoFieldValue(), "None");
        Assertions.assertEquals(bill.getMemoFieldText(), "Customer will not see this memo");
        bill.clickMemoBtn();


        Assertions.assertEquals(bill.getMemoPopUpTitle(), "Memo");
        Assertions.assertEquals(bill.getMaxMemoPopUpField(), "200");
        String memoText = "Memo Text";
        bill.enterMemoField(memoText);
        bill.clickDoneBtn();


        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));
        Assertions.assertEquals(bill.getAddedMemoText(), "Memo Text");

    }

    @Test(enabled = true, description = "Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void tc_14verifyingBillCreationAfterPurchasingBusinessPlan() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business 2");
        session.getBillPage().getContinueButton().click();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "2,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        bill.clickMoreOptions();
        bill.clickRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle(), "Repeat");
        bill.clickDoneBtn();
        bill.clickExpiryField();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle(), "Expiration Date");
        bill.clickDoneBtn();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void tc_15verifyingBillCreationByAddingExpirationDate() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business 2");
        session.getBillPage().getContinueButton().click();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "1,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        bill.clickMoreOptions();
        bill.clickExpiryField();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle(), "Expiration Date");
        Assertions.assertTrue(bill.isExpPopUpBtnNoneDisplayed());
        Assertions.assertTrue(bill.isExpPopUpBtn24HrDisplayed());
        Assertions.assertTrue(bill.isExpPopUpBtn4HrDisplayed());
        Assertions.assertTrue(bill.isExpPopUpBtn1HrDisplayed());
        Assertions.assertTrue(bill.isExpPopUpBtn30MinDisplayed());
        bill.clickCloseIcon();
        bill.clickExpiryField();
        String expiresIn="20";
        bill.enterExpiresInField(expiresIn);
        bill.clickExpiryDropDown();
        bill.clickExpDropDownOption();
        bill.clickDoneBtn();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isAddedExpTimerDisplayed());
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        session.getBillPage().deleteUnpaidBill();

    }
    @Test(enabled = true, description = "Verify that creating a store by adding recurring transactions, on Bills page")
    public void tc_16verifyingBillCreationByAddingRecurringTransactions() {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business");
        session.getBillPage().getContinueButton().click();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        //Enter amount
        String amt = "1,000.00";
        session.getBillPage().getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        bill.clickMoreOptions();
        bill.clickRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle(), "Repeat");
        bill.clickDoneBtn();

        bill.clickRepeatField();
        bill.clickRepeatOption();
        bill.checkCustomerCancelOption();
        Assertions.assertEquals(bill.getEveryDayFieldValue(),"1");
        bill.clickDoneBtn2();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.openBillByAmt(amt);
        Assertions.assertEquals(bill.getRecurringBillText(), "This is a recurring bill");
        session.getBillPage().deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verifying bill creation using all Features, on Bills page")
    public void tc_17verifyingBillCreationByAddingAllFeatures() throws AWTException {
        KadeSession session= KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business");
        session.getBillPage().getContinueButton().click();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        session.getBillPage().getNewBillButton().click();

        bill.enableTaxToggle();

        //Add Attachment(Image)
        bill.clickTapToAddFiles();
        bill.clickCameraIcon();
        bill.uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
        bill.ClickCheckBtn();
        //Verify Added Image
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        session.getBillPage().getCustomerButton().click();
        session.getBillPage().getSuggestedCustomer().click();

        bill.clickMoreOptions();
        //Verifying that 'None' text should appear by default in 'Reference' field
        Assertions.assertEquals(bill.getDefaultRefNoText(), "None");
        bill.clickRefNo();
        Assertions.assertEquals(bill.getRefPopUpTitle(), "Reference No.");
        String actualMaxRefLen = bill.getMaxRefLen();
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.enterRefNo(refNum);
        bill.clickDone();

        //Verifying that added reference number should appear under the 'Ref No' field.
        Assertions.assertEquals(bill.getRefNoText(), refNum);

        //Verifying that default text should be none in Description Field
        Assertions.assertEquals(bill.getDefaultDescText(), "None");
        bill.clickDescription();
        Assertions.assertEquals(bill.getDescPopUpTitle(), "Description");
        String actualMaxDescLen = bill.getMaxDescLen();
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.enterDescription(descriptionValue);

        //Verifying that added reference number should appear under the 'Description' field.
        bill.clickDone();
        Assertions.assertEquals(bill.getDescText(), descriptionValue);

        String desc1 = "Tea";
        bill.enterItemDesc1(desc1);
        String price1 = "80.00";
        bill.enterItemPrice1(price1);
        String desc2 = "Coffee";
        bill.enterItemDesc2(desc2);
        String price2 = "120.00";
        bill.enterItemPrice2(price2);

        //Verifying that 'Add A line' button appear in the bill pop-up
        Assertions.assertTrue(bill.isAddALineBtnDisplayed());
        Assertions.assertEquals(bill.getAddALineBtnText(), "Add a line");
        bill.clickAddALineBtn();
        Assertions.assertTrue(bill.isItemDesc3Displayed());
        Assertions.assertTrue(bill.isItemPrice3Displayed());
        String desc3 = "Shake";
        bill.enterItemDesc3(desc3);
        String price3 = "150.00";
        bill.enterItemPrice3(price3);

        bill.clickRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle(), "Repeat");
        bill.clickDoneBtn();

        bill.clickRepeatField();
        bill.clickRepeatOption();
        bill.checkCustomerCancelOption();
        Assertions.assertEquals(bill.getEveryDayFieldValue(),"1");
        bill.clickDoneBtn2();

        Assertions.assertEquals(bill.getDefaultMemoFieldValue(), "None");
        Assertions.assertEquals(bill.getMemoFieldText(), "Customer will not see this memo");
        bill.clickMemoBtn();


        Assertions.assertEquals(bill.getMemoPopUpTitle(), "Memo");
        Assertions.assertEquals(bill.getMaxMemoPopUpField(), "200");
        String memoText = "Memo Text";
        bill.enterMemoField(memoText);
        bill.clickDoneBtn();

        //Confirming the Bill
        session.getBillPage().getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(session.getBillPage().getToastMessage().isDisplayed());
        Assertions.assertEquals(session.getBillPage().getToastMessage().getText(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        session.getBillPage().getCloseLogoPopupBtn().click();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("357.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("357.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("357.00"));

        bill.openBillByAmt("357.00");
        Assertions.assertEquals(bill.getRecurringBillText(), "This is a recurring bill");
    }


}

