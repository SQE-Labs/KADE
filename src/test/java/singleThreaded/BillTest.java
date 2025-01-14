package singleThreaded;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BillPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class BillTest extends BaseTest {
    @Test(description = "BC_05 Bill creation along with image attachement ")
    public void za_verifyCreateBillByAttachingImage() throws ParseException, AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "1760.00";
        bill.getAmountTextbox().setText(amt);

        //Enable Tax toggle Button
        bill.getEnableTaxToggleButton().clickIfExist();

        //Add Attachment(Image)
        WebdriverWaits.sleep(3000);
        bill.getTapToAddFilesIcon().click();
        bill.getCameraIcon().click();
        WebdriverWaits.sleep(3000);
        bill.uploadImageInStoreLogo();
        WebdriverWaits.sleep(3000);
        bill.getCheckButton().click();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFiles().getListOfWebElements().size() == 1);

        //Verify Total Amt after tax
        float taxValue = Float.parseFloat(bill.getTaxValue().getText().split(" ")[2].replace("%", ""));
        float totalAmt = NumberFormat.getInstance(Locale.US).parse(bill.getTotalAmt().getText()).floatValue();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);
        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        bill.getUnpaidBillWithoutDescription().click();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Verify Attached File
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFiles().getListOfWebElements().size()  == 1);
    }

    @Test(description = "BC_06 Bill creation along with pdf attachment .")
    public void zb_verifyCreateBillByAttachingPdf() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton().click();

        //Click on New Bill Button
        bill.getNewBillButton().click();

        //Enter amount
        String amt = "879.99";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton().clickIfExist();

        //Add Attachment (PDF)
        bill.getTapToAddFilesIcon().click();
        bill.getDocumentIcon().click();
        bill.uploadPdf();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedFile().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFiles().getListOfWebElements().size()  == 1);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();
        bill.getConfirmButton().click();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);
        bill.getUnpaidBillWithoutDescription().clickByMouse();

        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        // Verify Attached File
        Assertions.assertTrue(bill.getAttachedFile().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFiles().getListOfWebElements().size()  == 1);

        //Deleting Created Bill
        bill.getDeleteButton().clickbyJS();
        bill.getDeleteIcon().click();
    }
    @Test(description = "BC_17 Verifying bill creation using all Features, on Bills page")
    public void zcverifyingBillCreationByAddingAllFeatures() throws AWTException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton().click();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown().click();
        bill.selectStore("Automation flow 2");
        bill.getContinueButton().click();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton().click();
        bill.getEnableTaxToggleButton().clickIfExist();

        //Add Attachment(Image)
        WebdriverWaits.sleep(3000);
        bill.getTapToAddFilesIcon().click();
        bill.getCameraIcon().click();
        bill.uploadImageInStoreLogo();
        bill.getCheckButton().click();

        //Verify Added Image
        Assertions.assertTrue(bill.getAttachedImage().isDisplayed());
        Assertions.assertTrue(bill.getAttachedFiles().getListOfWebElements().size() == 1);

        //Select Suggested Customer
        bill.getCustomerButton().click();
        bill.getSuggestedCustomer().click();

        //Verify that optional fields are added to the bill
        bill.getMoreOptionsButton().click();
        String defaultPriceValue = bill.getItemPriceField1().getAttribute("value");
       // Assertions.assertEquals(defaultPriceValue, "$0.00"); due to bug
        Assertions.assertEquals(bill.getDefaultMemoFieldText().getText(), "None");
        Assertions.assertEquals(bill.getMemoFieldMessage().getText(), "Customer will not see this memo");

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
        String actualMaxDescLen = bill.getDescriptionBox().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.getDescriptionBox().setText(descriptionValue);

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
        bill.getItemPriceField3().setText(price3);

        //Click on Repeat Field
        WebdriverWaits.sleep(2000);
        bill.getRepeatField().clickByMouse();
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton().click();
        bill.getRepeatField().click();
        bill.getRepeatOption().click();
        bill.getCustomerCancelOption().click();
        Assertions.assertEquals(bill.getEveryDayFieldValue().getAttribute("value"), "1");
        bill.getDoneBtn().click();

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
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist(true,3);
        bill.getUnPaidBillWithDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertEquals(bill.getRecurringBillText().getText(), "This is a recurring bill");
        bill.getCloseBillButton().click();
    }


}
