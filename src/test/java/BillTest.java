import java.awt.*;
import java.text.ParseException;
import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BillPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class BillTest extends BaseTest {

    @Test(description = "BC_01 Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void bc_01createBillWithoutSelectingCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        // Verify New Bill popup Web Elements
        String billPopupTitle = bill.getPopupTitle().getText();
        Assertions.assertEquals(billPopupTitle, "Bill");
        Assertions.assertTrue(bill.getAmountTextbox().isDisplayed());
        Assertions.assertTrue(bill.getDescriptionTextbox().isDisplayed());
        Assertions.assertTrue(bill.getCustomerField().isDisplayed());
        Assertions.assertTrue(bill.getMoreOption().isDisplayed());

        // Verify Default value of Amount tab
        String defaultAmt = bill.getAttribute(bill.amtInput, "value");
        Assertions.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.getConfirmButton().isEnabled());

        //Enter amount
        String amt = "2,999.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.getConfirmButton().isEnabled());

        //Click Confirm
        bill.getConfirmButton().click();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(bill.getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(bill.getContinueWithoutButton().isDisplayed());

        //Click On Continue Button
        bill.getContinueWithoutButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify not paid label for generated amount
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_02 Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void bc_02createBillBySelectingCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        // Verify New Bill popup
        String popupTitle = bill.getPopupTitle().getText();
        Assertions.assertEquals(popupTitle, "Bill");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.getConfirmButton().isEnabled());

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);

        //Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.getConfirmButton().isEnabled());

        //Click Confirm
        bill.getConfirmButton().click();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(bill.getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(bill.getContinueWithoutButton().isDisplayed());
        bill.getSelectACustomerButton().click();

        //Verify Customer popup
        Assertions.assertTrue(bill.getCustomerPhoneNoField().isDisplayed());
        Assertions.assertTrue(bill.getEmailField().isDisplayed());
        Assertions.assertTrue(bill.getSearchField().isDisplayed());

        //Select Customer
        bill.getCustomerPhoneNoField().setText("918877070727");
        bill.getGoPhoneNumberButton().click();

        //Click Confirm
        bill.disableTaxToggle();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify not paid label for generated amount
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_03 Bill creation by selecting customers from the suggestion list")
    public void bc_03createBillForSuggestedCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "105.00";
        bill.getAmountTextbox().setText(amt);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.disableTaxToggle();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify not paid label for generated amount
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_04 Bill Creation with already configured 'Tax' from store configuration page.")
    public void bc_04createBillForConfiguredTax() throws ParseException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "2500.00";
        bill.getAmountTextbox().setText(amt);

        //Enable Tax toggle Button
        bill.enableTaxToggle();

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist();
        String total = bill.convertToNumberFormat(totalAmt);
        System.out.println(total);

        //Verify not paid label for generated amount
        bill.openBillByAmt(total);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_05 Bill Creation with already configured 'Tax' from store configuration page.")
    public void bc_05createBillByAttachingImage() throws ParseException, AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "1760.00";
        bill.getAmountTextbox().setText(amt);

        //Enable Tax toggle Button
        bill.enableTaxToggle();

        //Add Attachment(Image)
        bill.getTapToAddFilesIcon().click();
        bill.getCameraIcon().click();
        bill.uploadImageInStoreLogo();
        bill.getCheckButton().click();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Verify Total Amt after tax
        float taxValue = bill.getTaxValue();
        float totalAmt = bill.getTotalAmt();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);
        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        String total = bill.convertToNumberFormat(totalAmt);
        bill.openBillByAmt(total);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Verify Attached File
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);
        bill.getCloseBillButton().click();
    }

    @Test(description = "BC_06 Bill Creation with already configured 'Tax' from store configuration page.")
    public void bc_06createBillByAttachingPdf() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "879.99";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Add Attachment (PDF)
        bill.getTapToAddFilesIcon().click();
        bill.getDocumentIcon().click();
        bill.uploadPdf();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedFile().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist();
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        // Verify Attached File
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getAttachedFile().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);
        bill.getCloseBillButton().click();

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_07 Verify that unpaid bill gets deleted")
    public void bc_07verifyBillDeletion() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Delete the 1st unpaid bill
        bill.getUnpaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_08 Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void bc_08verifyBillCreationUsingOptionalFields() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.disableTaxToggle();

        //Verify that optional fields are added to the bill
        bill.getMoreOptionsButton().click();
        String defaultPriceValue = bill.getItemPriceField1().getAttribute("value");
        Assertions.assertEquals(defaultPriceValue, "$0.00");

        //Verifying that 'None' text should appear by default in 'Reference' field
        Assertions.assertEquals(bill.getDefaultReferenceNumberText().getText(), "None");
        bill.getReferenceNumber().click();
        Assertions.assertEquals(bill.getReferencePopUpTitle().getText(), "Reference No.");
        String actualMaxRefLen = bill.getReferenceNumberField().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.getReferenceNumberField().setText(refNum);
        bill.getDoneLink().click();

        //Verifying that added reference number should appear under the 'Ref No' field.
        Assertions.assertEquals(bill.getAddedReferenceNumberText().getText(), refNum);

        //Verifying that default text should be none in Description Field
        Assertions.assertEquals(bill.getDescriptionFieldDefaultText().getText(), "None");
        bill.getDescription().clickIfExist();
        Assertions.assertEquals(bill.getDescriptionPopUpTitle().getText(), "Description");
        String actualMaxDescLen = bill.getDescriptionField().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.getDescriptionField().setText(descriptionValue);

        //Verifying that added reference number should appear under the 'Description' field.
        bill.getDoneLink().click();
        Assertions.assertEquals(bill.getDescriptionFieldAddedText().getText(), descriptionValue);

        //Verifying that Description and Price fields appear
        Assertions.assertTrue(bill.getItemDescriptionField1().isDisplayed());
        Assertions.assertTrue(bill.getItemDescriptionField2().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField1().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField2().isDisplayed());
        String actualItemDescLen = bill.getItemDescriptionField1().getAttribute("maxlength");
        Assertions.assertEquals(actualItemDescLen, "200");

        String actualItemPriceLen = bill.getItemPriceField1().getAttribute("max");
        Assertions.assertEquals(actualItemPriceLen, "50000.00");

        //Enter Items and Item Price
        String desc1 = "Tea";
        bill.getItemDescriptionField1().setText(desc1);
        String price1 = "80.00";
        bill.getItemPriceField1().setText(price1);
        String desc2 = "Coffee";
        bill.getItemDescriptionField2().setText(desc2);
        String price2 = "120.00";
        bill.getItemPriceField2().setText(price2);

        //Verifying that 'Add A line' button appear in the bill pop-up
        Assertions.assertTrue(bill.getAddALineButton().isDisplayed());
        Assertions.assertEquals(bill.getAddALineButton().getText(), "Add a line");
        bill.getAddALineButton().click();
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        String desc3 = "Shake";
        bill.getItemDescriptionField3().setText(desc3);
        String price3 = "150.00";
        bill.getItemDescriptionField3().setText(price3);
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verifying the total amount 80+120+150
        String total="350";
        bill.openBillByAmt(total);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(total));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertTrue(bill.getAddedDescription().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_09 Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void bc_09verifyingBillCreationWithEssentialFreePlan() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "90.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Verify that optional fields are added to the bill
        bill.getMoreOption().click();

        Assertions.assertTrue(bill.getFreezeIcon1().isDisplayed());
        bill.getRepeatButton().click();
        Assertions.assertTrue(bill.getNotNowButton().isDisplayed());
        Assertions.assertTrue(bill.getUpgradeButton().isDisplayed());
        Assertions.assertEquals(bill.getUpgradePopUpTitle().getText(), "Upgrade your plan");
        bill.getNotNowButton().click();

        //Verifying that Repeat and Expiry Fields are locked
        Assertions.assertTrue(bill.getFreezeIcon2().isDisplayed());
        bill.getExpiryButton().click();
        bill.getUpgradeButton().click();
    }

    @Test(description = "BC_10 Verify that creating a bill with default configured bill amount, on 'Bill' popup")
    public void bc_10verifyingBillCreationWithConfiguredBillAmount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "50,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();
        Assertions.assertEquals(bill.getAmountTextbox().getAttribute("max"), "50000.00");

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt2 = "60,000.00";
        bill.getAmountTextbox().setText(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist();
        Assertions.assertNotEquals(bill.getUnpaidAmount().getText(), amt2);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed("6,000.00"));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Delete Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_11 Verify that creating a bill with default configured bill amount, on 'Bill' popup")
    public void bc_11verifyingBillCreationWithOutConfiguredBillAmount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("New Business");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "3,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt2 = "4,000.00";
        bill.getAmountTextbox().setText(amt2);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        Assertions.assertNotEquals(bill.getUnpaidAmount().getText(), amt2);
        bill.openBillByAmt("400");
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed("400.00"));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_12 Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void bc_12verifyingBillCreationWithAddingMemoField() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation Flow 1");
        bill.getContinueButton().click();

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "2,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Click on More Options
        bill.getMoreOption().click();
        Assertions.assertEquals(bill.getDefaultMemoFieldText().getText(), "None");
        Assertions.assertEquals(bill.getMemoFieldMessage().getText(), "Customer will not see this memo");
        bill.getMemoButton().click();

        //Verifying details of 'Memo' Pop-up
        Assertions.assertEquals(bill.getMemoPopUpTitle().getText(), "Memo");
        Assertions.assertEquals(bill.getMemoField().getAttribute("maxlength"), "200");
        String memoText = "Memo Text";
        bill.getMemoField().setText(memoText);
        bill.getDoneButton().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertEquals(bill.getAddedMemoText().getText(), "Memo Text");
    }

    @Test(description = "BC_13 Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void bc_13verifyingBillCreationAfterPurchasingBusinessPlan() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("New Business 2");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "2,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getMoreOption().click();
        bill.getRepeatField().click();
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton().click();
        bill.getExpiryField().click();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle().getText(), "Expiration Date");
        bill.getDoneButton().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist();
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_14 Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void bc_14verifyingBillCreationByAddingExpirationDate() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("New Business 2");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Click on More Option
        bill.getMoreOption().click();
        bill.getExpiryField().click();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle().getText(), "Expiration Date");
        Assertions.assertTrue(bill.getExpiryNoneOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry24HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry4HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry1HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry30MinOption().isDisplayed());
        bill.getCloseIcon().click();

        //Click on Expiry Field
        bill.getExpiryField().click();
        String expiresIn = "20";
        bill.getExpiresInField().setText(expiresIn);
        bill.getExpiryDropDown().click();
        bill.getExpiryDropDownOption().click();
        bill.getDoneButton().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getAddedExpiryTimer().isDisplayed());
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_15 Verify that creating a store by adding recurring transactions, on Bills page")
    public void bc_15verifyingBillCreationByAddingRecurringTransactions() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("New Business");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.disableTaxToggle();

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Click on More Option
        bill.getMoreOption().click();
        bill.getRepeatField().click();
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton().click();

        //Click on Repeat Field
        bill.getRepeatField().click();
        bill.getRepeatOption().click();
        bill.getCustomerCancelOption().click();
        Assertions.assertEquals(bill.getEveryDayFieldValue().getAttribute("value"), "1");
        bill.getDoneBtn().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist();

        //Verify Created Bill
        bill.openBillByAmt(amt);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed(amt));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        bill.openBillByAmt(amt);
        Assertions.assertEquals(bill.getRecurringBillText().getText(), "This is a recurring bill");

        //Deleting Created Bill
        bill.getNotPaidBill().click();
        bill.getDeleteButton().click();
        bill.getDeleteIcon().click();
    }

    @Test(description = "BC_16 Verifying bill creation using all Features, on Bills page")
    public void bc_16verifyingBillCreationByAddingAllFeatures() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getDashBoardPage().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("New Business");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();
        bill.enableTaxToggle();

        //Add Attachment(Image)
        bill.getTapToAddFilesIcon().click();
        bill.getCameraIcon().click();
        bill.uploadImageInStoreLogo();
        bill.getCheckButton().click();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFilesCount() == 1);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Verify that optional fields are added to the bill
        bill.getMoreOptionsButton().click();
        String defaultPriceValue = bill.getItemPriceField1().getAttribute("value");
        Assertions.assertEquals(defaultPriceValue, "$0.00");

        //Verifying that 'None' text should appear by default in 'Reference' field
        Assertions.assertEquals(bill.getDefaultReferenceNumberText().getText(), "None");
        bill.getReferenceNumber().click();
        Assertions.assertEquals(bill.getReferencePopUpTitle().getText(), "Reference No.");
        String actualMaxRefLen = bill.getReferenceNumberField().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.getReferenceNumberField().setText(refNum);
        bill.getDoneLink().click();

        //Verifying that added reference number should appear under the 'Ref No' field.
        Assertions.assertEquals(bill.getAddedReferenceNumberText().getText(), refNum);

        //Verifying that default text should be none in Description Field
        Assertions.assertEquals(bill.getDescriptionFieldDefaultText().getText(), "None");
        bill.getDescription().clickIfExist();
        Assertions.assertEquals(bill.getDescriptionPopUpTitle().getText(), "Description");
        String actualMaxDescLen = bill.getDescriptionField().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.getDescriptionField().setText(descriptionValue);

        //Verifying that added reference number should appear under the 'Description' field.
        bill.getDoneLink().click();
        Assertions.assertEquals(bill.getDescriptionFieldAddedText().getText(), descriptionValue);

        //Verifying that Description and Price fields appear
        Assertions.assertTrue(bill.getItemDescriptionField1().isDisplayed());
        Assertions.assertTrue(bill.getItemDescriptionField2().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField1().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField2().isDisplayed());
        String actualItemDescLen = bill.getItemDescriptionField1().getAttribute("maxlength");
        Assertions.assertEquals(actualItemDescLen, "200");

        String actualItemPriceLen = bill.getItemPriceField1().getAttribute("max");
        Assertions.assertEquals(actualItemPriceLen, "50000.00");

        //Enter Items and Item Price
        String desc1 = "Tea";
        bill.getItemDescriptionField1().setText(desc1);
        String price1 = "80.00";
        bill.getItemPriceField1().setText(price1);
        String desc2 = "Coffee";
        bill.getItemDescriptionField2().setText(desc2);
        String price2 = "120.00";
        bill.getItemPriceField2().setText(price2);

        //Verifying that 'Add A line' button appear in the bill pop-up
        Assertions.assertTrue(bill.getAddALineButton().isDisplayed());
        Assertions.assertEquals(bill.getAddALineButton().getText(), "Add a line");
        bill.getAddALineButton().click();
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        String desc3 = "Shake";
        bill.getItemDescriptionField3().setText(desc3);
        String price3 = "150.00";
        bill.getItemDescriptionField3().setText(price3);
        bill.getConfirmButton().click();

        //Click on Repeat Field
        bill.getRepeatField().click();
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton().click();
        bill.getRepeatField().click();
        bill.getRepeatOption().click();
        bill.getCustomerCancelOption().click();
        Assertions.assertEquals(bill.getEveryDayFieldValue().getText(), "1");
        bill.getDoneBtn().click();

        //Click on More Option
        bill.getMoreOption().click();
        Assertions.assertEquals(bill.getDefaultMemoFieldText().getText(), "None");
        Assertions.assertEquals(bill.getMemoFieldMessage().getText(), "Customer will not see this memo");

        //Click on Memo Button
        bill.getMemoButton().click();
        Assertions.assertEquals(bill.getMemoPopUpTitle().getText(), "Memo");
        Assertions.assertEquals(bill.getMemoField().getAttribute("maxlength"), "200");
        String memoText = "Memo Text";
        bill.getMemoField().setText(memoText);
        bill.getDoneButton().click();

        //Confirming the Bill
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill was created successfully.Click here to open";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist();
        bill.openBillByAmt("357.00");
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.isRefNoDisplayed("357.00"));
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        bill.openBillByAmt("357.00");
        Assertions.assertEquals(bill.getRecurringBillText().getText(), "This is a recurring bill");
    }


}

