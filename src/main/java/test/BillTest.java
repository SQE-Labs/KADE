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
        bill.ClickSuggestedCustomer();
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
        bill.EnableTaxToggle();

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.clickCustomer();
        bill.ClickSuggestedCustomer();
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
        bill.EnableTaxToggle();

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
        bill.ClickSuggestedCustomer();
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

        //Add Attachment (PDF)
        bill.clickTapToAddFiles();
        bill.clickDocumentIcon();
        bill.uploadImageAsAttachment("src/main/resources/Documents/Bills.pdf");

        //Verify Added Image
        Assertions.assertTrue(bill.isAttachedFileDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        bill.clickCustomer();
        bill.ClickSuggestedCustomer();
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
    }

    @Test(enabled = true, description = "Verify that unpaid bill gets deleted")
    public void tc08_verifyBillDeletion() {
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
    public void tc09_verifyBillCreationUsingOptionalFields() {
        dashboard.clickOnBill();

        //Select Store
        bill.clickStoresDropdown();
        bill.selectStore("Automation Flow 1");
        bill.clickContinueBtn();

        // Click on New Bill Button
        bill.clickOnNewBill();

        //Enter amount
        String amt = "0.00";
        bill.enterAmount(amt);

        //Select Suggested Customer
        bill.clickCustomer();
        bill.ClickSuggestedCustomer();


        //Verify that optional fields are added to the bill
        bill.clickMoreOptions();
        Assertions.assertEquals(bill.getDefaultRefNoText(), "None");
        bill.clickRefNo();
        Assertions.assertEquals(bill.getRefPopUpTitle(), "Reference No.");
        String actualMaxRefLen = bill.getMaxRefLen();
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.enterRefNo(refNum);
        bill.clickDone();
        Assertions.assertEquals(bill.getRefNoText(), refNum);
        Assertions.assertEquals(bill.getDefaultDescText(), "None");
        bill.clickDescription();
        Assertions.assertEquals(bill.getDescPopUpTitle(), "Description");
        String actualMaxDescLen = bill.getMaxDescLen();
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.enterDescription(descriptionValue);
        Assertions.assertEquals(bill.getDescText(), descriptionValue);
        bill.clickDone();

        //Verifying that Description and Price fields appear
        Assertions.assertTrue(bill.isItemDesc1Displayed());
        Assertions.assertTrue(bill.isItemDesc2Displayed());
        Assertions.assertTrue(bill.isItemPrice1Displayed());
        Assertions.assertTrue(bill.isItemPrice2Displayed());
        String actualItemDescLen = bill.getMaxItemDescLen();
        Assertions.assertEquals(actualItemDescLen, "200");
        String actualItemPriceLen = bill.getMaxItemPriceLen();
        Assertions.assertEquals(actualItemPriceLen, "50000.00");
        String defaultPriceValue = bill.getDefaultPriceValue();
        Assertions.assertEquals(defaultPriceValue, "$0.00");

        String desc1 = "Tea";
        bill.enterItemDesc1(desc1);
        String price1 = "80.00";
        bill.enterItemPrice1(price1);
        String desc2 = "Coffee";
        bill.enterItemDesc2(desc2);
        String price2 = "120.00";
        bill.enterItemPrice2(price2);
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

    }

}

