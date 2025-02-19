package org.automation.pages;

import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.*;

import static org.automation.ReturnObjects.Clickable.getElementBy;

public class BillPage extends BasePage {

    public By newBillBtn = By.cssSelector(".fs-p15>i+div");
    public By recurringBtn = By.xpath("//div[text()='Recurring']");
    public By alertMessage = By.xpath("//div[@class='alert-message']");
    public By transactionsLink = By.xpath("//div[text()='Transactions']");
    public By amtTbx = By.xpath("//input[@name='amount']");
    public By selectedCustomer = By.xpath("(//div[@data-field='name']/../../../..  //div[@class='d-none empty-d-block'])[2]");
    public By suggestionList = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    By customerField = By.xpath("//div[@class='modal-content']//label[text()='Customer']");
    By moreOptionsField = By.xpath("//div[@class='modal-body'] //label[text()='More options']");
    By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
    By closeIcon = By.cssSelector("button.btn-close");
    By closeBillBtn = By.xpath("//span[text()='Bill']/../../../../.. //button");
    By userNumber = By.xpath("//input[@name='userPhone']");
    By filterBtn = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    By fromDatePicker = By.cssSelector("[name='dateRange']");
    By customerName = By.cssSelector("[name='custName']");
    By UserPhoneField = By.xpath("//input[@name='userPhone']");
    By UserEmailField = By.cssSelector("[name='email']");
    By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
    By customerNumberResult = By.xpath("//td[@class='text-nowrap']/p");
    By fromMonth = By.xpath("//th[@class='month'])[1]");
    By previousMonthArrow = By.xpath("//th[@class='prev available']");
    By toMonth = By.xpath("(//th[@class='month'])[2]");
    By nextMonthArrow = By.xpath("//th[@class='next available']");
    By refNo = By.xpath("//tr[@class='none-workingEffect']/td[2]/p[1]");
    By toastCloseBtn = By.xpath("//button[@class='toast-close-button']");
    public By toastMessage = By.xpath("//div[@class='toast-message']");
    By refundBtn = By.xpath("//button[@title='Refund']");
    By reasonField = By.xpath("(//input[@name='reason'])[3]");
    By processFullRefund = By.xpath("//button[@name='refundAll']");
    By refundHeader = By.xpath("//h4[@class='text-center color-inherit py-2']");
    By billGrid = By.xpath("//tr[@class='none-workingEffect']");
    By infoMessage = By.xpath("//div[@class='no-result-icon']/following-sibling::p");
    By billViewPopupTitleHeader = By.xpath("//h4[@class='modal-title']");
    By paidBill1 = By.xpath("//tr//td//div//div[not(contains(text(),'NOT PAID')) and not(@class='text-danger') and not(contains(text(),'PARTIAL')) and not(@class='text-warning')]/../../..");
    By memoNote = By.xpath("(//tr[@class='none-workingEffect']/td[2]/a)[1]");
    By name = By.xpath("//td[@class='text-nowrap']/p[1]");
    By customerNames = By.xpath("//td[@class='text-nowrap']/p[1]");
    By bill = By.xpath("(//tr[@class='none-workingEffect'])[1]");
    By customerHeader = By.xpath("//span[text()='Customer']");
    By popUpHeader = By.cssSelector(".modal-title span");
    By subTotalBox = By.xpath("//input[@name='subTotal']");
    By customerNumber = By.xpath("//input[@name='phone']");
    By createBtn = By.xpath("//button[@class='btn btn-primary fs-p50']");
    By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
    public By addBillDescription = By.xpath("//textarea[@name='amount_description']");
    By addBillPrice = By.xpath("//th[text()='Price']");
    By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
    By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
    By refNoTextBox = By.xpath("//input[@name='refNo']");
    By autoGenToggleBtn = By.xpath("(//input[@name='autoGenerate'])[1]");
    By autoGenClass = By.xpath("(//input[@name='autoGenerate'])[1]/../../../..");
    //	By closeIcon = By.xpath("(//button[@class='btn-close'])[2]");
    By customerEmail = By.xpath("(//input[@name='email'])[2]");
    By moreToggleBtn = By.xpath("(//input[@name='captureCustomerInfo'])[1]");
    By custName = By.xpath("(//input[@name='custName'])[2]");
    By memoTextField = By.xpath("//textarea[@name='memo']");
    By price1 = By.xpath("//input[@name='items[0].price']");
    By price2 = By.xpath("//input[@name='items[1].price']");
    By description1 = By.xpath("//input[@name='items[0].description']");
    By description2 = By.xpath("//input[@name='items[1].description']");
    public By amtInput = By.xpath("//input[@name='amount']");
    By closeCustomerBtn = By.xpath("//span[text()='Customer']/../..//button");
    By customerBtn = By.xpath("//span[text()='Bill']/../../../../../../div[2]/div/div/form/div[5]/div");
    public By phoneNoTbx = By.xpath("//input[@placeholder='Phone number']");
    public By emailTbx = By.xpath("//input[@placeholder='Email']");
    public By searchTbx = By.xpath("//input[@placeholder='Search']");
    By goBtnPhnNo = By.xpath("//input[@placeholder='Phone number']/..//button");
    By goBtnEmail = By.xpath("//input[@placeholder='Email']/..//button");
    By searcherName = By.xpath("(//div[@data-field='alias'])[2]");
    By discardBtn = By.xpath("(//*[contains(text(),'discard')])[5]/.. //button[text()='Discard']");
    public By confirmBtn = By.xpath("//button[@name='method']");
    public By continueWithoutBtn = By.xpath("//*[@role='dialog'] //button[text()='Continue without']");
    public By selectACustomerBtn = By.xpath("//*[@role=\"dialog\"] //button[text()='Select a customer']");
    By whichStorePopup = By.xpath("//p[text()='Which store?']");
    By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    By messagePopupHeader = By.xpath("//*[@role='dialog'] //h5[text()='Message']");
    public By closeLogoPopupBtn = By.xpath("//div[@class='modal fade show' and not(@data-bs-keyboard='false')]" +
            "//child::button");
    By totalAmt = By.xpath("//span[@data-field='total']");
    By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");
    By cameraIcon = By.xpath("(//button[contains(@onclick,'image')])[2]");
    By documentIcon = By.xpath("(//button[contains(@onclick,'pdf')])[2]");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By attachedImage = By.xpath("//img[@class='img-thumbnail  bg-black']");
    By notPaidBill = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    By unPaidBill=By.xpath("(//div[contains(@class,'row bg-white ')])[1]/div[2]");
    public By deleteButton = By.cssSelector(".btn-outline-danger");
    By deleteIcon = By.cssSelector(".fal.fa-thumbs-up.text-white");
    By moreOptions = By.cssSelector(".mb-3.border.p-2.py-3.rounded-3.advanced-d-none.position-relative");
    By referenceNo = By.xpath("(//div[@class='border p-2 py-3 mb-2 rounded-3  d-none advanced-d-block'])[1]");
    public By refNoField = By.xpath("(//input[@lbl-title='Reference No.'])[2]");
    By description = By.xpath("//label[text()='Description:']/..");
    public By descriptionField = By.xpath("//textarea[@name='amount_description']");
    By descriptionBox = By.xpath("(//textarea[@lbl-title='Description'])[2]");
    By doneLink = By.xpath("(//button[@class='btn btn-link w-100 my-3'])[5]");
    By itemsDesc1 = By.xpath("(//textarea[@name='detail_description'])[2]");
    By itemsDesc2 = By.xpath("(//textarea[@name='detail_description'])[3]");
    By itemsDesc3 = By.xpath("(//textarea[@name='detail_description'])[4]");
    By addALineBtn = By.xpath("//button[normalize-space()='Add a line']");
    By itemPrice1 = By.xpath("(//input[@name='detail_amount'])[2]");
    By itemPrice2 = By.xpath("(//input[@name='detail_amount'])[3]");
    By itemPrice3 = By.xpath("(//input[@name='detail_amount'])[4]");
    By refPopUp = By.xpath("//h5[text()='Reference No.']");
    By defaultRefNoText = By.xpath("//label[text()='Ref No.:']/../div/div/div[1]/div[2]");
    By refNoText = By.xpath("//label[text()='Ref No.:']/../div/div/div[1]/div[1]");
    By defaultDescText = By.xpath("//label[text()='Description:']/../div/div/div[1]/div[2]");
    By descText = By.xpath("//label[text()='Description:']/../div/div/div[1]/div[1]");
    By descPopUp = By.xpath("//h5[text()='Description']");
    By addedDescription = By.xpath("(//div[@class='border rounded p-1 overflow-hidden'])[1]");
    By repeatBtn = By.xpath("(//div[contains(@class,'bg-locked')])[1]");
    By expiryBtn = By.xpath("(//div[contains(@class,'bg-locked')])[2]");
    By notNowBtn = By.xpath("(//button[@class='btn btn-outline-primary'])[1]");
    By upgradeBtn = By.xpath("//a[text()='Upgrade']");
    By filterIcon = By.xpath("//i[@class='far fa-2x fa-sliders-h-square']");
    By freezeIcon1 = By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[1]");
    By freezeIcon2 = By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[2]");
    By upgradePopUpTitle = By.xpath("//h3[text()='Upgrade your plan']");
    By memoBtn = By.xpath("(//div[@class='text-nowrap d-flex align-items-center w-100'])[4]");
    By memoField = By.xpath("(//textarea[@lbl-title='Memo'])[2]");
    By doneBtn = By.xpath("(//button[text()='Done'])[5]");
    By doneBtn2 = By.xpath("//h5[text()='Repeat']/../..//button[text()='Done']");
    By memoFieldText = By.xpath("(//div[@class='d-none empty-d-block fst-italic w-100'])[4]");
    By memoFieldMessage = By.xpath("//div[@class='text-muted fs-pn15 pt-3']");
    By memoPopUpTitle = By.xpath("//h5[text()='Memo']");
    By addedMemoText = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
    //    By paidRepeatField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative']");
    By paidRepeatField = By.xpath("(//div[contains(@class,'text-nowrap d-flex align-items-center w-100')])[3]");
    //By paidExpiryField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative -expdate-div-']");
    public By paidExpiryField = By.xpath("//label[text()='Expiration Date:']");
    public By repeatPopUpTitle = By.xpath("//h5[text()='Repeat']");
    By expiryDatePopUpTitle = By.xpath("//h5[text()='Expiration Date']");
    By unpaidAmount = By.cssSelector(".text-danger.fs-4");

    By expCloseIcon = By.xpath("(//button[@class='btn-close'])[7]");
    By repeatCloseIcon = By.xpath("(//button[@class='btn-close'])[8]");
    By expiresInField= By.cssSelector(".form-control.flex-grow-1.me-1");
    By expDropDown = By.cssSelector(".form-control.form-select.max-10c");
    By expDropDownOption = By.xpath("//option[@value='minutes']");
    By addedExpTimer = By.cssSelector(".badge.bg-warning");
    By expPopUpBtnNone = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[1]");
    By expPopUpBtn24Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[2]");
    By expPopUpBtn4Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[3]");
    By expPopUpBtn1Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[4]");
    By expPopUpBtn30Min = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[2]");
    By repeatOption = By.xpath("//input[@value='1']");
    By customerCancelOption = By.xpath("//span[text()='Customer can cancel at any time']");
    By everyDayField = By.xpath("//input[@class='max-5c form-control']");
    By recurringBillText = By.xpath("//a[@class='btn btn-link']");
    public By billTag = By.xpath("//div[contains(@class,'col-5  text-end') ]//div[1]/span");

    /*
    Locators of Bill popup
     */
    public By billPopupHeader = By.xpath("//span[text()='Bill']");
    public By qrCodeBtn = By.xpath("//span[text()='QR Code']");
    By shareBtn = By.xpath("//span[text()='Share']");
    public By processPaymentBtn = By.xpath("//button[text()='Process Payment']");
    By deleteBillBtn = By.xpath("//button[text()='Delete']");
    By editBillBtn = By.xpath("//i[@class='far fa-edit']");
    By uniqueRefNo = By.cssSelector(".badge.position-relative:first-child");
    By notPaidLabel = By.cssSelector(".badge.bg-danger");
    By billTimeOnPopup = By.cssSelector("div[role='document'] div.d-flex.justify-content-between div+div>div");
    By taxValue = By.xpath("//input[@name='applyTax']/../span");
    By taxToggleBtnDisable = By.xpath("//input[@name='applyTax']/../i[1]");
    By customName = By.xpath("//*[@id=\"_B7O\"]/span");
    By activeBillAmmount = By.xpath("//span[@class='display-5 display-sm-2 fw-bold']");
    By doneButton = By.xpath(" //div[@id='_3FH']/button[@type='button'][normalize-space()='Done']");


    public BillPage() {
        super();
    }

    public Clickable getStoresDropdown() {
        return Clickable.getElementBy(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public Clickable getSelectACustomerButton() {
        return Clickable.getElementBy(selectACustomerBtn, "Select Customer Button");
    }

    public Clickable getEnableTaxToggleButton() {
           return Clickable.getElementBy(taxToggleBtn,"Tax Toggle Button");
    }

    public Clickable getDisableTaxToggleButton() {
            return Clickable.getElementBy(taxToggleBtnDisable,"Disable Toggle button");
    }

    public Clickable getTotalAmt() {
        return Clickable.getElementBy(totalAmt,"Total amount");
    }

    public Clickable getTaxValue() {
        return Clickable.getElementBy(taxValue,"Tax value");
    }

    public String convertToNumberFormat(float num) {
        // Create a NumberFormat instance for the default locale
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        // Set maximum fraction digits to 2 for two decimal places
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        // Format the number and return
        return formatter.format(num);
    }

    public Clickable getAttachedFiles() {
        return Clickable.getElementBy(attachedImage,"Attached Image");
    }

    public  Clickable getUnPaidBillWithDescription(){
        return Clickable.getElementBy(unPaidBill,"Unpaid Bill");
    }

    public Clickable getUnpaidBillWithoutDescription() {
        return Clickable.getElementBy(notPaidBill, "Not Paid Bill");
    }

    public Clickable getProcessPaymentButton() {
        return getElementBy(processPaymentBtn, "Process Payment Button");
    }

    public Clickable getTransactionLink() {
        return Clickable.getElementBy(transactionsLink, "Transaction link ");
    }

    public Clickable getContinueButton() {
        return Clickable.getElementBy(continueBtn, "Continue Button");
    }

    public Clickable getNewBillButton() {
        return Clickable.getElementBy(newBillBtn, "New Bill Button");
    }

    public Editable getAmountTextbox() {
        return Editable.getElementBy(amtTbx, "Amount Textbox");
    }

    public Clickable getDescriptionTextbox() {
        return Clickable.getElementBy(descriptionField, "Description Field");
    }

    public Clickable getCustomerField() {
        return Clickable.getElementBy(customerField, "Customer Field");
    }

    public Clickable getMoreOption() {
        return Clickable.getElementBy(moreOptions, "More Options");
    }

    public Clickable getConfirmButton() {
        return Clickable.getElementBy(confirmBtn, "Confirm Button");
    }

    public Clickable getSelectCustomerButton() {
        return Clickable.getElementBy(selectedCustomer, "Select Customer Button");
    }

    public Clickable getContinueWithoutButton() {
        return Clickable.getElementBy(continueWithoutBtn, "Continue Without Button");
    }

    public Editable getCustomerPhoneNoField() {
        return Editable.getElementBy(customerNumber, "Customer Number Field");
    }

    public Editable getEmailField() {
        return Editable.getElementBy(emailTbx, "Customer Email field");
    }

    public Editable getSearchField() {
        return Editable.getElementBy(searchTbx, "Search Textbox");
    }

    public Clickable getGoPhoneNumberButton() {
        return Clickable.getElementBy(goBtnPhnNo, "Go button for Phn No.");
    }

    public Clickable getSuggestedCustomer() {
        return Clickable.getElementBy(suggestionList, "Suggested Customer");
    }

    public Editable getAmountField() {
        return Editable.getElementBy(amtInput, "Amount Field");
    }

    public Clickable getCloseLogoPopupBtn() {
        return getElementBy(closeLogoPopupBtn, "Close Logo Pop Up Button");
    }

    public Editable getPopupTitle() {
        return Editable.getElementBy(popUpHeader, "Bill Pop Up");
    }

    public Editable getCustomerNameField() {
        return Editable.getElementBy(custName, "Customer Name Field");
    }

    public void createBill(BillsPage billObj) {
        createBill(billObj, true);
    }

    public void createBill(BillsPage billObj, boolean navigateToBillSection) {
        if (navigateToBillSection) {
            getStoresDropdown().click();
            selectStore(billObj.getStore());
            getContinueButton().click();
        }

        getNewBillButton().click();
        if (billObj.getAmount() != null) {
            getAmountField().setText(billObj.getAmount());
        }
        getDisableTaxToggleButton().clickIfExist();
        getDescriptionTextbox().click();
        if (billObj.getCustomerPhnNo() != null) {
            getCustomerButton().click();
            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
            getGoPhoneNumberButton().click();
            getConfirmButton().clickByMouse();
        }
        if(billObj.getCustomerEmail() != null){
            getCustomerButton().click();
            getUserEmailField().setText(billObj.getCustomerEmail());
            getEmailGoButton().click();
        }
        getConfirmButton().clickbyJS();
        WebdriverWaits.sleep(2000);
        getContinueWithoutButton().clickIfExist();
    }
    public void createBillForRT(BillsPage billObj, boolean navigateToBillSection) {
        if (navigateToBillSection) {
            getStoresDropdown().click();
            selectStore(billObj.getStore());
            getContinueButton().click();
        }

        getNewBillButton().click();
        if (billObj.getAmount() != null) {
            getAmountField().setText(billObj.getAmount());
        }
        getDisableTaxToggleButton().clickIfExist();
        getDescriptionTextbox().click();
        if (billObj.getCustomerPhnNo() != null) {
            getCustomerButton().click();
            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
            getGoPhoneNumberButton().click();
            getConfirmButton().clickByMouse();
        }
        if(billObj.getCustomerEmail() != null) {
            getCustomerButton().click();
            getUserEmailField().setText(billObj.getCustomerEmail());
            getEmailGoButton().click();
            WebdriverWaits.sleep(2000);
            getMoreOption().click();
            WebdriverWaits.sleep(3000);
            getRepeatField().click();
            getRepeatOption().click();
            getCustomerCancelOption().click();
            getDoneBtn().click();
        }
        getConfirmButton().clickbyJS();
        WebdriverWaits.sleep(2000);
        getContinueWithoutButton().clickIfExist();
    }


    public Clickable getEmailGoButton(){
        return Clickable.getElementBy(goBtnEmail,"Email go button");
    }

    public Clickable getFilterButton() {
        return Clickable.getElementBy(filterBtn, "Filter Button");
    }

    public Editable getUserEmailField() {
        return Editable.getElementBy(UserEmailField, "User Email Field");
    }

    public Clickable getApplyButton() {
        return Clickable.getElementBy(applyBtn, "Apply Button");
    }

    public Editable getMoreOptionField() {
        return Editable.getElementBy(moreOptionsField, "More Options Field");
    }

    public Clickable getCustomerButton() {
        return Clickable.getElementBy(customerBtn, "Customer Button");
    }

    public Editable getCustomerHeader() {
        return Editable.getElementBy(customerHeader, "Customer Pop Up");
    }

    public Clickable GetGoButtonPhoneNo() {
        return Clickable.getElementBy(goBtnPhnNo, "Go Button Phone Number");
    }

    public Editable getMessagePopupHeader() {
        return Editable.getElementBy(messagePopupHeader, "Message popup");
    }

    public Clickable getToastMessage() {
        return Clickable.getElementBy(toastMessage, "Toast Message");
    }

    public Clickable getCustomerPhoneField() {
        return Clickable.getElementBy(customerNumber, "Customer Phone No Field");
    }

    public Clickable getSuggestionList() {
        return Clickable.getElementBy(suggestionList, "Suggestion List");
    }

    public Clickable getTapToAddFilesIcon() {
        return Clickable.getElementBy(tapToAddFiles, "Tap to Add Files Icon");
    }

    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void uploadImageInStoreLogo() throws AWTException {
        uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
    }

    public void uploadPdf() throws AWTException {
        uploadImageAsAttachment("src/main/resources/Documents/Bills.pdf");
    }

    public Clickable getCheckButton() {
        return Clickable.getElementBy(checkBtn, "Check Button");
    }

    public Clickable getCameraIcon() {
        return Clickable.getElementBy(cameraIcon, "Camera Icon");
    }

    public Clickable getAttachedFile() {
        return Clickable.getElementBy(attachedImage, "Attached File");
    }

    public Clickable getAttachedImage() {
        return Clickable.getElementBy(attachedImage, "Attached Image");
    }

    public Clickable getDocumentIcon() {
        return Clickable.getElementBy(documentIcon, "Document Icon");
    }

    public Clickable getCloseBillButton() {
        return Clickable.getElementBy(closeBillBtn, "Close Bill Button");
    }

    public Clickable getDeleteButton() {
        return Clickable.getElementBy(deleteButton, "Delete Button");
    }

    public Clickable getDeleteIcon() {
        return Clickable.getElementBy(deleteIcon, "Delete Icon");
    }

    public Clickable getMoreOptionsButton() {
        return Clickable.getElementBy(moreOptions, "More Options");
    }

    public Clickable getReferenceNumber() {
        return Clickable.getElementBy(referenceNo, "Reference Number");
    }

    public Editable getReferenceNumberField() {
        return Editable.getElementBy(refNoField, "Reference Number Field");
    }

    public Clickable getDescription() {
        return Clickable.getElementBy(description, "Description");
    }

    public Editable getDescriptionField() {
        return Editable.getElementBy(descriptionBox, "Description Field");
    }

    public Clickable getDoneLink() {
        return Clickable.getElementBy(doneLink, "Done Link");
    }

    public Editable getDescriptionBox(){
        return Editable.getElementBy(descriptionBox,"description textbox");
    }

    public Editable getItemDescriptionField1() {
        return Editable.getElementBy(itemsDesc1, "Item Description Field 1");
    }

    public Editable getItemDescriptionField2() {
        return Editable.getElementBy(itemsDesc2, "Item Description Field 2");
    }

    public Editable getItemPriceField2() {
        return Editable.getElementBy(itemPrice2, "Item Price Field 2");
    }

    public Editable getItemPriceField3() {
        return Editable.getElementBy(itemPrice3, "Item Price Field 3");
    }

    public Editable getItemDescriptionField3() {
        return Editable.getElementBy(itemsDesc3, "Item Description Field 3");
    }

    public Editable getItemPriceField1() {
        return Editable.getElementBy(itemPrice1, "Item Price Field 1");
    }

    public Clickable getAddALineButton() {
        return Clickable.getElementBy(addALineBtn, "Add A Line Button");
    }

    public Editable getReferencePopUpTitle() {
        return Editable.getElementBy(refPopUp, "Reference Pop Up");
    }

    public Editable getDefaultReferenceNumberText() {
        return Editable.getElementBy(defaultRefNoText, "Default Reference Text");
    }

    public Editable getAddedReferenceNumberText() {
        return Editable.getElementBy(refNoText, "Added Reference Text");
    }

    public Editable getDescriptionFieldDefaultText() {
        return Editable.getElementBy(defaultDescText, "Default Description Text");
    }

    public Editable getDescriptionFieldAddedText() {
        return Editable.getElementBy(descText, "Description Field Text");
    }

    public Editable getAddedDescription() {
        return Editable.getElementBy(addedDescription, "Added Description Text");
    }

    public Editable getDescriptionPopUpTitle() {
        return Editable.getElementBy(descPopUp, "Description Pop Up Title");
    }

    public Clickable getRepeatButton() {
        return Clickable.getElementBy(repeatBtn, "Repeat Button");
    }

    public Clickable getExpiryButton() {
        return Clickable.getElementBy(expiryBtn, "Expiry Button");
    }

    public Clickable getNotNowButton() {
        return Clickable.getElementBy(notNowBtn, "Not Now Button");
    }

    public Clickable getUpgradeButton() {
        return Clickable.getElementBy(upgradeBtn, "Upgrade Button");
    }

    public Clickable getFilterIcon() {
        return Clickable.getElementBy(filterIcon, "Filter Icon");
    }

    public Clickable getFreezeIcon1() {
        return Clickable.getElementBy(freezeIcon1, "Freeze Icon 1");
    }

    public Clickable getFreezeIcon2() {
        return Clickable.getElementBy(freezeIcon2, "Freeze Icon 2");
    }

    public Editable getUpgradePopUpTitle() {
        return Editable.getElementBy(upgradePopUpTitle, "Upgrade PopUp Title");
    }

    public Clickable getMemoButton() {
        return Clickable.getElementBy(memoBtn, "Memo Button");
    }

    public Editable getMemoField() {
        return Editable.getElementBy(memoField, "Memo Field");
    }

    public Clickable getDoneButton() {
        return Clickable.getElementBy(doneBtn, "Done Button");
    }

    public Editable getDefaultMemoFieldText() {
        return Editable.getElementBy(memoFieldText, "Memo Field Text");
    }

    public Editable getMemoFieldMessage() {
        return Editable.getElementBy(memoFieldMessage, "Memo Field Message");
    }

    public Editable getMemoPopUpTitle() {
        return Editable.getElementBy(memoPopUpTitle, "Memo PopUp Title");
    }

    public Editable getAddedMemoText() {
        return Editable.getElementBy(addedMemoText, "Added Memo Text");
    }

    public Clickable getRepeatField() {
        return Clickable.getElementBy(paidRepeatField, "Paid Repeat Field");
    }

    public Clickable getExpiryField() {
        return Clickable.getElementBy(paidExpiryField, "Paid Expiry Field");
    }

    public Clickable getRecurringButtton() {
        return Clickable.getElementBy(recurringBtn, "Recurring Button");
    }

    public Editable getRepeatPopUpTitle() {
        return Editable.getElementBy(repeatPopUpTitle, "Repeat PopUp");
    }

    public Editable getExpiryDatePopUpTitle() {

        return Editable.getElementBy(expiryDatePopUpTitle, "Expiry Date Pop Up");
    }

    public Editable getUnpaidAmount() {
        return Editable.getElementBy(unpaidAmount, "Unpaid Amount");
    }

    public Clickable getCloseIcon() {
        return Clickable.getElementBy(expCloseIcon, "Expiry Close Icon");
    }

    public Editable getExpiresInField() {
        return Editable.getElementBy(expiresInField, "Expires in Field");
    }

    public Clickable getExpiryDropDown() {
        return Clickable.getElementBy(expDropDown, "Expiry Dropdown");
    }

    public Clickable getExpiryDropDownOption() {
        return Clickable.getElementBy(expDropDownOption, "Expiry Drop Down Option");
    }

    public Editable getAddedExpiryTimer() {
        return Editable.getElementBy(addedExpTimer, "Added Expiry Timer");
    }

    public Clickable getExpiryPopUpButton() {
        return Clickable.getElementBy(expPopUpBtnNone, "Expiry Pop Up Button");
    }

    public Clickable getExpiry24HrOption() {
        return Clickable.getElementBy(expPopUpBtn24Hr, "Expiry 24 Hr Option");
    }

    public Clickable getExpiry4HrOption() {
        return Clickable.getElementBy(expPopUpBtn4Hr, "Expiry 4 Hr Option");
    }

    public Clickable getExpiry1HrOption() {
        return Clickable.getElementBy(expPopUpBtn1Hr, "Expiry 1 Hr Option");
    }

    public Clickable getExpiry30MinOption() {
        return Clickable.getElementBy(expPopUpBtn24Hr, "Expiry 30 Min Option");
    }

    public Clickable getExpiryNoneOption() {
        return Clickable.getElementBy(expPopUpBtnNone, "Expiry None Option");
    }

    public Clickable getRepeatOption() {
        return Clickable.getElementBy(repeatOption, "Repeat Option");
    }

    public Clickable getCustomerCancelOption() {
        return Clickable.getElementBy(customerCancelOption, "Customer Cancel Option");
    }

    public Clickable getDoneBtn() {
        return Clickable.getElementBy(doneBtn2, "Done Button");
    }

    public Editable getEveryDayFieldValue() {
        return Editable.getElementBy(everyDayField, "Every Day Field");
    }

    public Editable getRecurringBillText() {
        return Editable.getElementBy(recurringBillText, "Recurring Bill Text");
    }

    public Clickable getProcessingPaymentButton() {
        return Clickable.getElementBy(processPaymentBtn, "Processing Payment Button");
    }

    public Editable getBillPopupHeader() {
        return Editable.getElementBy(billPopupHeader, "Bill PopUp Header");
    }

    public Clickable getShareButton() {
        return Clickable.getElementBy(shareBtn, "Share Button");
    }

    public Clickable getQRCodeButton() {
        return Clickable.getElementBy(qrCodeBtn, "QR Code Button");
    }

    public Clickable getEditBillButton() {
        return Clickable.getElementBy(editBillBtn, "Edit Bill Button");
    }

    public Clickable getUniqueReferenceNumber() {
        return Clickable.getElementBy(uniqueRefNo, "Unique Reference Number");
    }

    public Editable getBillTime() {
        return Editable.getElementBy(billTimeOnPopup, "Bill Time");
    }

    public Editable getNotPaidLabel() {
        return Editable.getElementBy(notPaidLabel, "Not Paid Label");
    }


    public Clickable getPaymentStatusOfLatestBill() {
        return Clickable.getElementBy(billTag,"Bill Status");
    }

    public Clickable getCustomName() {
        return Clickable.getElementBy(customName,"Customer Name");
    }


    public Clickable getActiveBillAmmount() {
        return Clickable.getElementBy(activeBillAmmount,"Bill Ammount");
    }

    public Clickable getDoneLinkOnBillPage() {
        return Clickable.getElementBy(doneButton, "Done Link");
    }

}
