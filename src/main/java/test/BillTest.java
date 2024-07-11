package test;

import java.awt.*;
import java.text.ParseException;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BillEditPopup;
import org.automation.pageObjects.BillPage;
import org.automation.pageObjects.BillViewPopup;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.RefundPage;
import org.automation.pageObjects.TransactionsPage;
import org.automation.pageObjects.UpdateBillPopUp;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillTest extends BaseTest {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    BillPage bill = new BillPage();

    @BeforeMethod
    public void navigateToDashboard() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(enabled = true, description = "Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void tc_01createBillWithoutSelectingCustomer() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        // Verify New Bill popup Web Elements
        Assertions.assertEquals(bill.getPopUpTitle(), "Bill");
        Assertions.assertTrue(bill.isAmountTbxDisplayed());
        Assertions.assertTrue(bill.isDescriptionDisplayed());
        Assertions.assertTrue(bill.isCustomerFieldDisplayed());
        Assertions.assertTrue(bill.isMoreOptionDisplayed());

        // Verify Default value of Amount tab
        String defaultAmt = bill.getAttribute(bill.amtInput, "value");
        Assertions.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.isConfirmBtnEnabled());

        //Enter amount
        String amt = "2,999.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.isConfirmBtnEnabled());

        //Click Confirm
        bill.clickOnConfirm();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader(), "Message");
        Assertions.assertTrue(bill.isSelectACustomerBtnVisible());
        Assertions.assertTrue(bill.isContinueWithoutBtnVisible());

        //Click On Continue Button
        bill.clickOnContinueWithout();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Close popup
        bill.closeLogoConfigPopup();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void tc_02createBillBySelectingCustomer() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        // Verify New Bill popup
        Assertions.assertEquals(bill.getPopUpTitle(), "Bill");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.isConfirmBtnEnabled());

        //Enter amount
        String amt = "1,000.00";
        bill.enterAmount(amt);

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.isConfirmBtnEnabled());

        //Click Confirm
        bill.clickOnConfirm();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader(), "Message");
        Assertions.assertTrue(bill.isSelectACustomerBtnVisible());
        Assertions.assertTrue(bill.isContinueWithoutBtnVisible());

        //Click On Continue Button
        bill.clickOnSelectACustomer();

        //Verify Customer popup
        Assertions.assertTrue(bill.isCustomerPhnNoFieldPresent());
        Assertions.assertTrue(bill.isEmailFieldPresent());
        Assertions.assertTrue(bill.isSearchFieldPresent());


        //Select Customer
        bill.enterCustomerPhnNo("918877070727");
        bill.clickOnGoBtnPhoneNo();

        //Click Confirm
        bill.disableTaxToggle();
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Close popup
        bill.closeLogoConfigPopup();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();
    }

    @Test(enabled = true, description = "Bill creation by selecting customers from the suggestion list")
    public void tc_03createBillForSuggestedCustomer() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();
        // Click on New Bill Button
        bill.clickOnNewBill();
        //Enter amount
        String amt = "105.00";
        bill.enterAmount(amt);
        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();
        bill.disableTaxToggle();
        bill.clickOnConfirm();
        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Close popup
        bill.closeLogoConfigPopup();

        //Verify not paid label for generated amount
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_04createBillForConfiguredTax() throws ParseException {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "2500.00";
        bill.enterAmount(amt);

        //Enable Tax toggle Button
        bill.enableTaxToggle();

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        bill.closeLogoConfigPopup();
        String total = bill.convertToNumberFormat(totalAmt);
        System.out.println(total);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(total));
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.isBillTimeDisplayed(total));

        bill.deleteUnpaidBill();
    }

    @Test(enabled = true, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_06createBillByAttachingImage() throws ParseException, AWTException {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "1760.00";
        bill.enterAmount(amt);

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
        bill.clickCustomer();
        bill.clickSuggestedCustomer();
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Close popup
        bill.closeLogoConfigPopup();

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

    @Test(enabled = true, description = "Bill Creation with already configured 'Tax' from store configuration page.")
    public void tc_07createBillByAttachingPdf() throws AWTException {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "879.99";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Add Attachment (PDF)
        bill.clickTapToAddFiles();
        bill.clickDocumentIcon();
        bill.uploadImageAsAttachment("src/main/resources/Documents/Bills.pdf");

        //Verify Added Image
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        // Verify Attached File
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        bill.closeCreatedBill();

        bill.deleteUnpaidBill();
    }

    @Test(enabled = true, description = "Verify that unpaid bill gets deleted")
    public void tc_08verifyBillDeletion() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        //Delete the 1st unpaid bill
        bill.clickUnpaidBill();
        bill.clickDeleteButton();
        bill.clickDeleteIcon();
    }

    @Test(enabled = true, description = "Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void tc_09verifyBillCreationUsingOptionalFields() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();
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
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        //Verifying the total amount i.e 80+120+150
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("350.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("350.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("350.00"));
        Assertions.assertTrue(bill.isAddedDescriptionDisplayed());

    }

    @Test(enabled = true, description = "Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void tc_10verifyingBillCreationWithEssentialFreePlan() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "90.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

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
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "50,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();
        Assertions.assertEquals(bill.getMaxAmountInput(), "50000.00");

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt2 = "60,000.00";
        bill.enterAmount(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();
        Assertions.assertNotEquals(bill.getUnpaidAmount(), amt2);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("6,000.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("6,000.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("6,000.00"));

        bill.deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill with default configured bill amount, on 'Bill' popup of 'Bills' page.")
    public void tc_12verifyingBillCreationWithOutConfiguredBillAmount() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business");
        bill.clickContinueBtn();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.isNewBillBtnDisplayed());
        Assertions.assertTrue(bill.isTransactionDisplayed());
        Assertions.assertTrue(bill.isFilterIconDisplayed());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "3,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt2 = "4,000.00";
        bill.enterAmount(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertNotEquals(bill.getUnpaidAmount(), amt2);
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed("400.00"));
        Assertions.assertTrue(bill.isRefNoDisplayed("400.00"));
        Assertions.assertTrue(bill.isBillTimeDisplayed("400.00"));

        bill.deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void tc_13verifyingBillCreationWithAddingMemoField() {
        dashboard.clickOnBill();
        //New Business 2
        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "2,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

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
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));
        Assertions.assertEquals(bill.getAddedMemoText(), "Memo Text");

    }

    @Test(enabled = true, description = "Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void tc_14verifyingBillCreationAfterPurchasingBusinessPlan() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business 2");
        bill.clickContinueBtn();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "2,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        bill.clickMoreOptions();
        bill.clickRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle(), "Repeat");
        bill.clickDoneBtn();
        bill.clickExpiryField();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle(), "Expiration Date");
        bill.clickDoneBtn();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

    }

    @Test(enabled = true, description = "Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void tc_15verifyingBillCreationByAddingExpirationDate() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business 2");
        bill.clickContinueBtn();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "1,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

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
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isAddedExpTimerDisplayed());
        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

    }
    @Test(enabled = true, description = "Verify that creating a store by adding recurring transactions, on Bills page")
    public void tc_16verifyingBillCreationByAddingRecurringTransactions() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("New Business 2");
        bill.clickContinueBtn();

        Assertions.assertTrue(bill.isRecurringBtnVisible());

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "1,000.00";
        bill.enterAmount(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.clickCustomer();
        bill.clickSuggestedCustomer();

        bill.clickMoreOptions();
        bill.clickRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle(), "Repeat");
        bill.clickDoneBtn();

        bill.clickRepeatField();
        bill.clickRepeatOption();
        bill.checkCustomerCancelOption();
        bill.clickDoneBtn();

        //Confirming the Bill
        bill.clickOnConfirm();

        //Verify toast message
        Assertions.assertTrue(bill.isToastMessageDisplayed());
        Assertions.assertEquals(bill.getToastMessage(), "Bill was created successfully.Click here to open");

        //Verify Created Bill
        bill.closeLogoConfigPopup();

        Assertions.assertTrue(bill.isNotPaidLabelDisplayed(amt));
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.isBillTimeDisplayed(amt));

        bill.deleteUnpaidBill();

    }


}

