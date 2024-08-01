package org.automation.pages;

import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.objectBuilder.pages.BillsPage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.*;

import static org.automation.ReturnObjects.Clickable.getElementBy;

public class BillPage extends BasePage {

    public By newBillBtn = By.xpath("//button[@class='btn btn-outline-dark']");
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
    By filterBtn = By.xpath("//a[@class='collapsed']");
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
    By unpaidBill = By.xpath("//div[contains(@class,'row bg-white ')]");
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
    By confirmBtn = By.xpath("//button[@name='method']");
    By continueWithoutBtn = By.xpath("//*[@role='dialog'] //button[text()='Continue without']");
    By selectACustomerBtn = By.xpath("//*[@role=\"dialog\"] //button[text()='Select a customer']");
    By whichStorePopup = By.xpath("//p[text()='Which store?']");
    By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    By messagePopupHeader = By.xpath("//*[@role='dialog'] //h5[text()='Message']");
    By closeLogoPopupBtn = By.xpath("//div[@class='modal fade show' and not(@data-bs-keyboard='false')]" +
            "//child::button");
    By totalAmt = By.xpath("//span[@data-field='total']");
    By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");
    By cameraIcon = By.xpath("(//button[contains(@onclick,'image')])[2]");
    By documentIcon = By.xpath("(//button[contains(@onclick,'pdf')])[2]");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By attachedImage = By.xpath("//img[@class='img-thumbnail  bg-black']");
    By deleteBill = By.xpath("//div[contains(@class,'row bg-white ')]");
    By deleteButton = By.cssSelector(".btn-outline-danger");
    By deleteIcon = By.cssSelector(".fa.fa-check");
    By moreOptions = By.cssSelector(".mb-3.border.p-2.py-3.rounded-3.advanced-d-none.position-relative");
    By referenceNo = By.xpath("(//div[@class='border p-2 py-3 mb-2 rounded-3  d-none advanced-d-block'])[1]");
    public By refNoField = By.xpath("(//input[@lbl-title='Reference No.'])[2]");
    By description = By.xpath("//textarea[@name='amount_description']");
    public By descriptionField = By.xpath("//textarea[@name='amount_description']");
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
    By doneBtn2 = By.xpath("(//button[@class='btn btn-link w-100 my-3'])[3]");
    By memoFieldText = By.xpath("(//div[@class='d-none empty-d-block fst-italic w-100'])[4]");
    By memoFieldMessage = By.xpath("//div[@class='text-muted fs-pn15 pt-3']");
    By memoPopUpTitle = By.xpath("//h5[text()='Memo']");
    By addedMemoText = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
    //    By paidRepeatField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative']");
    By paidRepeatField = By.xpath("(//div[contains(@class,'text-nowrap d-flex align-items-center w-100')])[3]");
    By paidExpiryField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative -expdate-div-']");
    By repeatPopUpTitle = By.xpath("//h5[text()='Repeat']");
    By expiryDatePopUpTitle = By.xpath("//h5[text()='Expiration Date']");
    By unpaidAmount = By.cssSelector(".text-danger.fs-4");

    By expCloseIcon = By.xpath("(//button[@class='btn-close'])[7]");
    By repeatCloseIcon = By.xpath("(//button[@class='btn-close'])[8]");
    By expiresInField = By.cssSelector(".form-control.flex-grow-1.me-1");
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


    /*
    Locators of Bill popup
     */
    By billPopupHeader = By.xpath("//span[text()='Bill']");
    By qrCodeBtn = By.xpath("//span[text()='QR Code']");
    By shareBtn = By.xpath("//span[text()='Share']");
    By processPaymentBtn = By.xpath("//button[text()='Process Payment']");
    By deleteBillBtn = By.xpath("//button[text()='Delete']");
    By editBillBtn = By.xpath("//i[@class='far fa-edit']");
    By uniqueRefNo = By.xpath("//div[@class='modal-content']//i[@class='fad fa-hashtag me-2']/..");
    By notPaidLabel = By.xpath("//span[@class='badge bg-danger fs-6']");
    By billTimeOnPopup = By.xpath("//div[@class='fs-pn15 mb-1']");

    public BillPage() {
        super();
    }

    public boolean isTransactionDisplayed() {
        return isElementPresent(transactionsLink, "Transactions Link");
    }

    public boolean isNewBillBtnDisplayed() {
        return isWebElementVisible(newBillBtn);
    }

    public boolean isAmountTbxDisplayed() {
        return isWebElementVisible(amtTbx);
    }

    public boolean isCustomerFieldDisplayed() {
        return isWebElementVisible(customerField);
    }

    public boolean isMoreOptionDisplayed() {
        return isWebElementVisible(moreOptionsField);
    }

    public void enterAmount(String amt) {
        WebdriverWaits.waitForElementUntilVisible(amtInput, 5);
        clear_custom(amtInput);
        pressKeys(amtInput, amt);
        click(amtInput);
    }

    public void clickCustomer() {
        click(customerBtn);
    }

//    public Clickable CustomerButton() {
//        return getElementBy(customerBtn, "Customer Button");
//    }

//    public String getCustomerHeader() {
//        return getText_custom(customerHeader);
//    }

    public void clickOnGoBtnPhoneNo() {
        click(goBtnPhnNo);
    }

    public boolean isConfirmBtnEnabled() {
        return isElementEnabled(confirmBtn);
    }

    public void clickOnConfirm() {
        scrollToElement(confirmBtn);
        click(confirmBtn);
    }

    public void clickOnContinueWithout() {
        WebdriverWaits.waitForElementVisible(continueWithoutBtn, 5);
        WebdriverWaits.waitForElementClickable(continueWithoutBtn, 5);
        click(continueWithoutBtn);
    }

    public Clickable getStoresDropdown() {
        return Clickable.getElementBy(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }


    public boolean isNotPaidLabelDisplayed(String amt) {
        By notPaidLabel = By.xpath("//span[text()='$" + amt + "']/../../div[1]/span");
        WebdriverWaits.waitForElementClickable(notPaidLabel, 5);
        return isWebElementVisible(notPaidLabel);
    }

    public boolean isRefNoDisplayed(String amt) {
        By refNo = By.xpath("//span[text()='$" + amt + "']/../../div[1]/span");
        return isWebElementVisible(refNo);
    }


    public boolean isBillTimeDisplayed(String amt) {
        By time = By.xpath("(//span[text()='$" + amt + "']/../../../div/div)[1]");
        return isWebElementVisible(time);
    }

    public void closeLogoConfigPopup() {
        try {
            WebdriverWaits.waitForElementClickable(closeLogoPopupBtn, 5);
            for (int i = 0; i < 5; i++) {
                if (isWebElementVisible(closeLogoPopupBtn))
                    clickElementByJS(closeLogoPopupBtn);
            }
        } catch (TimeoutException e) {
        }
    }

    public void clickOnSelectACustomer() {
        WebdriverWaits.waitForElementClickable(selectACustomerBtn, 5);
        moveToWebElement(selectACustomerBtn);
        click(selectACustomerBtn);
    }

    public Clickable getSelectACustomerButton() {
        return Clickable.getElementBy(selectACustomerBtn, "Select Customer Button");
    }

    public boolean isSearchFieldPresent() {
        return isWebElementVisible(searchTbx);
    }

    public boolean isCustomerPhnNoFieldPresent() {
        WebdriverWaits.waitForElementVisible(customerNumber, 5);
        return isWebElementVisible(customerNumber);
    }

    public void clickSuggestedCustomer() {
        click(suggestionList);
    }

    public void enableTaxToggle() {
        if (isWebElementVisible(By.cssSelector(".fa-toggle-on.custom-check-off"))) {
            click(taxToggleBtn);
        }
    }

    public void disableTaxToggle() {
        By taxToggleBtnDisable = By.xpath("//input[@name='applyTax']/../i[1]");
        if (isWebElementVisible(By.cssSelector(".fa-toggle-on.custom-check-on"))) {
            click(taxToggleBtnDisable);
        }
    }

    public float getTotalAmt() throws ParseException {
        String total = getText_custom(totalAmt);
        return NumberFormat.getInstance(Locale.US).parse(total).floatValue();
    }

    public float getTaxValue() {
        By taxValue = By.xpath("//input[@name='applyTax']/../span");
        String tax = getText_custom(taxValue).split(" ")[2].replace("%", "");
        return Float.parseFloat(tax);
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

    public void clickTapToAddFiles() {
        WebdriverWaits.waitForElementClickable(tapToAddFiles, 5);
        clickElementByJS(tapToAddFiles);
        click(tapToAddFiles);
    }

//    public void uploadImageAsAttachment(String relativePath) throws AWTException {
//        String projectPath = System.getProperty("user.dir");
//        String absolutePath = Paths.get(projectPath, relativePath).toString();
//        uploadImageFile(absolutePath);
//    }

    public void ClickCheckBtn() {
        click(checkBtn);
    }

    public void clickCameraIcon() {
        click(cameraIcon);
    }

    public int getAttachedFilesCount() {
        int count = getListOfWebElements(attachedImage).size();
        return count;
    }

    public boolean isAttachedFileDisplayed() {
        return isWebElementVisible(attachedImage);
    }

    public void openBillByAmt(String amt) {
        By bill = By.xpath("(//span[text()='$" + amt + "']/../../..)[1]");
        click(bill);
    }

    public void clickUnpaidBill() {
        WebdriverWaits.waitForElementClickable(unpaidBill, 5);
        click(unpaidBill);
    }

    public void clickDeleteButton() {
        WebdriverWaits.waitForElementUntilVisible(deleteButton, 5);
        click(deleteButton);

    }

    public void clickDeleteIcon() {
        WebdriverWaits.waitForElementUntilVisible(deleteIcon, 5);
        click(deleteIcon);
    }

    public void clickMoreOptions() {
        click(moreOptions);
    }

    public void clickRefNo() {
        click(referenceNo);
    }

    public void enterRefNo(String refNum) {
        WebdriverWaits.waitForElementUntilVisible(refNoField, 2);
        pressKeys(refNoField, refNum);
        click(refNoField);
    }

    public void clickDescription() {
        click(description);
    }

    public void enterDescription(String descriptionValue) {
        WebdriverWaits.waitForElementUntilVisible(descriptionField, 2);
        pressKeys(descriptionField, descriptionValue);
        click(descriptionField);
    }

    public void clickDone() {
        click(doneLink);
    }


    public void enterItemDesc1(String desc1) {
        WebdriverWaits.waitForElementUntilVisible(itemsDesc1, 2);
        pressKeys(itemsDesc1, desc1);
        click(itemsDesc1);
    }

    public void enterItemDesc2(String desc2) {
        WebdriverWaits.waitForElementUntilVisible(itemsDesc2, 2);
        pressKeys(itemsDesc2, desc2);
        click(itemsDesc2);
    }

    public void enterItemDesc3(String desc3) {
        WebdriverWaits.waitForElementUntilVisible(itemsDesc3, 2);
        pressKeys(itemsDesc3, desc3);
        click(itemsDesc3);
    }

    public void enterItemPrice1(String price1) {
        WebdriverWaits.waitForElementUntilVisible(itemPrice1, 2);
        pressKeys(itemPrice1, price1);
        click(itemPrice1);
    }

    public void enterItemPrice2(String price2) {
        WebdriverWaits.waitForElementUntilVisible(itemPrice2, 2);
        pressKeys(itemPrice2, price2);
        click(itemPrice2);
    }

    public void enterItemPrice3(String price3) {
        WebdriverWaits.waitForElementUntilVisible(itemPrice3, 2);
        pressKeys(itemPrice3, price3);
        click(itemPrice3);
    }

    public void clickAddALineBtn() {
        click(addALineBtn);
    }


    public String getRefPopUpTitle() {
        WebdriverWaits.waitForElementVisible(refPopUp, 2);
        return getText_custom(refPopUp);
    }


    public String getMaxRefLen() {
        return getAttribute(refNoField, "maxlength");

    }

    public String getDefaultRefNoText() {
        WebdriverWaits.waitForElementVisible(defaultRefNoText, 2);
        return getText_custom(defaultRefNoText);

    }

    public String getRefNoText() {

        return getText_custom(refNoText);

    }

    public String getAddALineBtnText() {

        return getText_custom(addALineBtn);

    }

    public boolean isAddALineBtnDisplayed() {

        return isWebElementVisible(addALineBtn);
    }

    public boolean isItemDesc1Displayed() {

        return isWebElementVisible(itemsDesc1);
    }

    public boolean isItemDesc2Displayed() {

        return isWebElementVisible(itemsDesc2);
    }

    public boolean isItemDesc3Displayed() {

        return isWebElementVisible(itemsDesc3);
    }

    public boolean isItemPrice1Displayed() {

        return isWebElementVisible(itemPrice1);
    }

    public boolean isItemPrice2Displayed() {

        return isWebElementVisible(itemPrice2);
    }

    public boolean isItemPrice3Displayed() {

        return isWebElementVisible(itemPrice3);
    }

    public String getMaxItemDescLen() {
        return getAttribute(itemsDesc1, "maxlength");
    }

    public String getMaxItemPriceLen() {
        return getAttribute(itemPrice1, "max");
    }

    public String getDefaultDescText() {

        return getText_custom(defaultDescText);
    }

    public String getDescText() {
        return getText_custom(descText);
    }

    public boolean isAddedDescriptionDisplayed() {
        return isWebElementVisible(addedDescription);
    }


    public String getDescPopUpTitle() {
        WebdriverWaits.waitForElementVisible(descPopUp, 2);
        return getText_custom(descPopUp);

    }

    public String getMaxDescLen() {
        return getAttribute(descriptionField, "maxlength");
    }

    public String getDefaultPriceValue() {
        return getAttribute(itemPrice1, "value");
    }

    //Essential Free plan Methods of Bill Creation
    public void clickRepeatBtn() {

        click(repeatBtn);
    }

    public void clickExpiryBtn() {
        WebdriverWaits.waitForElementVisible(expiryBtn, 2);
        click(expiryBtn);
    }

    public void clickNotNowBtn() {
        WebdriverWaits.waitForElementVisible(notNowBtn, 2);
        click(notNowBtn);


    }

    public void clickUpgradeBtn() {
        WebdriverWaits.waitForElementVisible(upgradeBtn, 2);
        click(upgradeBtn);
    }

    //Assertions Methods

    public boolean isFilterIconDisplayed() {
        return isWebElementVisible(filterIcon);
    }

    public boolean isFreezeIcon1Present() {
        return isWebElementVisible(freezeIcon1);
    }

    public boolean isFreezeIcon2Present() {
        return isWebElementVisible(freezeIcon2);
    }

//    public String getUpgradePopUpTitle() {
//        WebdriverWaits.waitForElementVisible(upgradePopUpTitle, 5);
//        return getText_custom(upgradePopUpTitle);
//    }

    public boolean isNotNowBtnPresent() {
        WebdriverWaits.waitForElementVisible(notNowBtn, 2);
        return isWebElementVisible(notNowBtn);
    }

    public boolean isUpgradeBtnPresent() {
        WebdriverWaits.waitForElementVisible(upgradeBtn, 2);
        return isWebElementVisible(upgradeBtn);
    }

    public String getMaxAmountInput() {
        return getAttribute(amtInput, "max");

    }

    //
//    public String getEnteredAmount(){
//        WebdriverWaits.waitForElementVisible(amtInput, 2);
//        return getText_custom(amtInput);
//    }
    public void clickMemoBtn() {
        WebdriverWaits.waitForElementUntilVisible(memoBtn, 5);
        click(memoBtn);
    }

    public void enterMemoField(String memoText) {
        WebdriverWaits.waitForElementUntilVisible(memoField, 5);
        pressKeys(memoField, memoText);
        click(memoField);
    }

    public void clickDoneBtn() {


        // WebdriverWaits.waitForElementUntilVisible(doneBtn, 15);
        scrollToElement(doneBtn);
        moveToWebElement(doneBtn);
        WebdriverWaits.waitForElementUntilVisible(doneBtn, 8);
        click(doneBtn);
    }

    public String getDefaultMemoFieldValue() {
        return getText_custom(memoFieldText);
    }

    public String getMemoFieldText() {
        return getText_custom(memoFieldMessage);
    }

//    public String getMemoPopUpTitle() {
//        WebdriverWaits.waitForElementUntilVisible(memoPopUpTitle, 5);
//        return getText_custom(memoPopUpTitle);
//    }

    public String getMaxMemoPopUpField() {
        WebdriverWaits.waitForElementVisible(memoField, 5);
        return getAttribute(memoField, "maxlength");
    }

    public void deleteUnpaidBill() {
        WebdriverWaits.waitForElementVisible(deleteBill, 5);
        click(deleteBill);
        WebdriverWaits.waitForElementVisible(deleteButton, 5);
        click(deleteButton);
        WebdriverWaits.waitForElementVisible(deleteIcon, 5);
        click(deleteIcon);
    }

    public String getAddedMemoText() {
        return getText_custom(addedMemoText);
    }

    public void clickRepeatField() {
        WebdriverWaits.waitForElementUntilVisible(paidRepeatField, 5);
        click(paidRepeatField);
    }

    public void clickExpiryField() {
        WebdriverWaits.waitForElementUntilVisible(paidExpiryField, 5);
        click(paidExpiryField);
    }

    public boolean isRecurringBtnVisible() {
        return isWebElementVisible(recurringBtn);
    }

    public String getRepeatPopUpTitle() {
        WebdriverWaits.waitForElementVisible(repeatPopUpTitle, 5);
        return getText_custom(repeatPopUpTitle);
    }

    public String getExpiryDatePopUpTitle() {
        WebdriverWaits.waitForElementVisible(expiryDatePopUpTitle, 5);
        return getText_custom(expiryDatePopUpTitle);
    }

    public String getUnpaidAmount() {
        return getText_custom(unpaidAmount);
    }

    public void clickCloseIcon() {
        click(expCloseIcon);
    }

    public void enterExpiresInField(String expiresIn) {
        WebdriverWaits.waitForElementUntilVisible(expiresInField, 2);
        pressKeys(expiresInField, expiresIn);
        click(expiresInField);
    }

    public void clickExpiryDropDown() {
        click(expDropDown);
    }

    public void clickExpDropDownOption() {
        click(expDropDownOption);
    }

    public boolean isAddedExpTimerDisplayed() {
        return isWebElementVisible(addedExpTimer);
    }


    public boolean isExpPopUpBtnNoneDisplayed() {
        return isWebElementVisible(expPopUpBtnNone);
    }

    public boolean isExpPopUpBtn24HrDisplayed() {
        return isWebElementVisible(expPopUpBtn24Hr);
    }


    public boolean isExpPopUpBtn4HrDisplayed() {
        return isWebElementVisible(expPopUpBtn4Hr);
    }

    public boolean isExpPopUpBtn1HrDisplayed() {
        return isWebElementVisible(expPopUpBtn1Hr);
    }

    public boolean isExpPopUpBtn30MinDisplayed() {
        return isWebElementVisible(expPopUpBtn30Min);
    }

    public void clickRepeatOption() {

        click(repeatOption);
    }

    public void checkCustomerCancelOption() {
        click(customerCancelOption);
    }

    public void clickDoneBtn2() {
        click(doneBtn2);
    }

    public String getEveryDayFieldValue() {
        return getAttribute(everyDayField, "value");
    }

    public String getRecurringBillText() {
        return getText_custom(recurringBillText);
    }


    public void clickProcessPaymentBtn() {
        WebdriverWaits.waitForElementVisible(processPaymentBtn, 5);
        clickElementByJS(processPaymentBtn);
    }

    public String getBillPopupHeader() {
        WebdriverWaits.waitForElementVisible(billPopupHeader, 5);
        return getText_custom(billPopupHeader);
    }

    public boolean isShareBtnDisplayed() {
        return isWebElementVisible(shareBtn);
    }

    public boolean isQrCodeBtnDisplayed() {
        return isWebElementVisible(qrCodeBtn);
    }

    public boolean isEditBtnDisplayed() {
        return isWebElementVisible(editBillBtn);
    }

    public boolean isProcessPaymentBtnDisplayed() {
        return isWebElementVisible(processPaymentBtn);
    }

    public boolean isDeleteBillBtnDisplayed() {
        return isWebElementVisible(deleteBillBtn);
    }

    public boolean isUniqueRefNoDisplayed() {
        return isWebElementVisible(uniqueRefNo);
    }

    public boolean isBillPopupTimeDisplayed() {
        return isWebElementVisible(billTimeOnPopup);
    }

    public boolean isNotPaidLabelDisplayed() {
        return isWebElementVisible(notPaidLabel);
    }


    //New Methods
    public Clickable getUnpaidBillButton() {
        return getElementBy(unpaidBill, "Unpaid bill Button");
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
        return Editable.getElementBy(amtInput);
    }

    public Clickable getCloseLogoPopupBtn() {
        return getElementBy(closeLogoPopupBtn, "Close Logo Pop Up Button");
    }

    public Editable getPopupTitle() {
        return Editable.getElementBy(popUpHeader);
    }

    public void enterCustomerPhnNo(String phnNo) {
        click(phoneNoTbx);
        pressKeys(phoneNoTbx, phnNo);
    }

    public Editable getCustomerNameField() {
        return Editable.getElementBy(custName);
    }

    public void createBill(BillsPage billObj) {
        createBill(billObj, true);
    }

    public void createBill(BillsPage billObj, boolean navigateToBillSection) {
        if (navigateToBillSection) {
            getStoresDropdown();
            selectStore(billObj.getStore());
            getContinueButton();
        }

        getNewBillButton();
        if (billObj.getAmount() != null) {
            getAmountField().setText(billObj.getAmount());
//            enterAmount(billObj.getAmount());
        }
        disableTaxToggle();
        getCustomerButton();
        if (billObj.getCustomerPhnNo() != null) {
            enterCustomerPhnNo(billObj.getCustomerPhnNo());
        }
        getGoPhoneNumberButton();
        getConfirmButton();
    }

    public Clickable getFilterButton() {
        return Clickable.getElementBy(filterBtn);
    }

    public Editable getUserEmailField() {
        return Editable.getElementBy(UserEmailField);
    }

    public Clickable getApplyButton() {
        return Clickable.getElementBy(applyBtn);
    }

    public Editable getMoreOptionField() {
        return Editable.getElementBy(moreOptionsField);
    }

    public Clickable getCustomerButton() {
        return Clickable.getElementBy(customerBtn, "Customer Button");
    }

    public Editable getCustomerHeader() {
        return Editable.getElementBy(customerHeader);
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
        return Clickable.getElementBy(tapToAddFiles);
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

    public Clickable getUnpaidBill() {
        return Clickable.getElementBy(unpaidBill, "Unpaid Bill");
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
      return Editable.getElementBy(refNoField);
    }

    public Clickable getDescription(){
        return Clickable.getElementBy(description,"Description");
    }

    public Editable getDescriptionField(){
        return Editable.getElementBy(descriptionField);
    }

    public Clickable getDoneLink(){
        return Clickable.getElementBy(doneLink,"Done Link");
    }

    public Editable getItemDescriptionField1(){
        return Editable.getElementBy(itemsDesc1);
    }

    public Editable getItemDescriptionField2(){
        return Editable.getElementBy(itemsDesc2);
    }

    public Editable getItemDescriptionField3(){
        return Editable.getElementBy(itemsDesc3);
    }

    public Editable getItemPriceField1(){
        return Editable.getElementBy(itemPrice1);
    }
    public Editable getItemPriceField2(){
        return Editable.getElementBy(itemPrice2);
    }
    public Editable getItemPriceField3(){
        return Editable.getElementBy(itemPrice3);
    }

    public Clickable getAddALineButton(){
        return Clickable.getElementBy(addALineBtn,"Add A Line Button");
    }

    public Editable getReferencePopUpTitle(){
        return Editable.getElementBy(refPopUp);
    }

    public Editable getDefaultReferenceNumberText(){
        return Editable.getElementBy(defaultRefNoText);
    }

    public Editable getAddedReferenceNumberText(){
        return Editable.getElementBy(refNoText);
    }

    public Editable getDescriptionFieldDefaultText(){
        return Editable.getElementBy(defaultDescText);
    }

    public Editable getDescriptionFieldAddedText(){
        return Editable.getElementBy(descText);
    }

    public Editable getAddedDescription() {
        return Editable.getElementBy(addedDescription);
    }

    public Editable getDescriptionPopUpTitle() {
        return Editable.getElementBy(descPopUp);
    }

    public Clickable getRepeatButton() {
        return Clickable.getElementBy(repeatBtn,"Repeat Button");
    }

    public Clickable getExpiryButton() {
        return Clickable.getElementBy(expiryBtn);
    }

    public Clickable getNotNowButton() {
       return Clickable.getElementBy(notNowBtn);
    }

    public Clickable getUpgradeButton() {
        return Clickable.getElementBy(upgradeBtn);
    }

    public Clickable getFilterIcon() {
        return Clickable.getElementBy(filterIcon,"Filter Icon");
    }

    public Clickable getFreezeIcon1() {
        return Clickable.getElementBy(freezeIcon1,"Freeze Icon 1");
    }

    public Clickable getFreezeIcon2() {
        return Clickable.getElementBy(freezeIcon2,"Freeze Icon 2");
    }

    public Editable getUpgradePopUpTitle() {
        return Editable.getElementBy(upgradePopUpTitle);
    }

    public Clickable getMemoButton() {
        return Clickable.getElementBy(memoBtn,"Memo Button");
    }

    public Editable getMemoField(){
        return Editable.getElementBy(memoField);
    }

    public Clickable getDoneButton() {
        return Clickable.getElementBy(doneBtn,"Done Button");
    }

    public Editable getDefaultMemoFieldText() {
        return Editable.getElementBy(memoFieldText);
    }

    public Editable getMemoFieldMessage() {
        return Editable.getElementBy(memoFieldMessage);
    }

    public Editable getMemoPopUpTitle() {
        return Editable.getElementBy(memoPopUpTitle);
    }

//    public void deleteUnpaidBill() {
//        WebdriverWaits.waitForElementVisible(deleteBill, 5);
//        click(deleteBill);
//        WebdriverWaits.waitForElementVisible(deleteButton, 5);
//        click(deleteButton);
//        WebdriverWaits.waitForElementVisible(deleteIcon, 5);
//        click(deleteIcon);
//    }

    public Editable getAddedMemoText() {
        return Editable.getElementBy(addedMemoText);
    }

    public Clickable getRepeatField() {
        return Clickable.getElementBy(paidRepeatField,"Paid Repeat Field");
    }

    public Clickable getExpiryField() {
        return Clickable.getElementBy(paidExpiryField,"Paid Expiry Field");
    }

    public Clickable getRecurringButtton() {
        return Clickable.getElementBy(recurringBtn,"Recurring Button");
    }

    public Editable getRepeatPopUpTitle() {
        return Editable.getElementBy(repeatPopUpTitle);
    }

    public Editable getExpiryDatePopUpTitle() {

        return getText_custom(expiryDatePopUpTitle);
    }

    public String getUnpaidAmount() {
        return getText_custom(unpaidAmount);
    }

    public void clickCloseIcon() {
        click(expCloseIcon);
    }

    public void enterExpiresInField(String expiresIn) {
        WebdriverWaits.waitForElementUntilVisible(expiresInField, 2);
        pressKeys(expiresInField, expiresIn);
        click(expiresInField);
    }

    public void clickExpiryDropDown() {
        click(expDropDown);
    }

    public void clickExpDropDownOption() {
        click(expDropDownOption);
    }

    public boolean isAddedExpTimerDisplayed() {
        return isWebElementVisible(addedExpTimer);
    }


    public boolean isExpPopUpBtnNoneDisplayed() {
        return isWebElementVisible(expPopUpBtnNone);
    }

    public boolean isExpPopUpBtn24HrDisplayed() {
        return isWebElementVisible(expPopUpBtn24Hr);
    }


    public boolean isExpPopUpBtn4HrDisplayed() {
        return isWebElementVisible(expPopUpBtn4Hr);
    }

    public boolean isExpPopUpBtn1HrDisplayed() {
        return isWebElementVisible(expPopUpBtn1Hr);
    }

    public boolean isExpPopUpBtn30MinDisplayed() {
        return isWebElementVisible(expPopUpBtn30Min);
    }

    public void clickRepeatOption() {

        click(repeatOption);
    }

    public void checkCustomerCancelOption() {
        click(customerCancelOption);
    }

    public void clickDoneBtn2() {
        click(doneBtn2);
    }

    public String getEveryDayFieldValue() {
        return getAttribute(everyDayField, "value");
    }

    public String getRecurringBillText() {
        return getText_custom(recurringBillText);
    }


    public void clickProcessPaymentBtn() {
        WebdriverWaits.waitForElementVisible(processPaymentBtn, 5);
        clickElementByJS(processPaymentBtn);
    }

    public String getBillPopupHeader() {
        WebdriverWaits.waitForElementVisible(billPopupHeader, 5);
        return getText_custom(billPopupHeader);
    }

    public boolean isShareBtnDisplayed() {
        return isWebElementVisible(shareBtn);
    }

    public boolean isQrCodeBtnDisplayed() {
        return isWebElementVisible(qrCodeBtn);
    }

    public boolean isEditBtnDisplayed() {
        return isWebElementVisible(editBillBtn);
    }

    public boolean isProcessPaymentBtnDisplayed() {
        return isWebElementVisible(processPaymentBtn);
    }

    public boolean isDeleteBillBtnDisplayed() {
        return isWebElementVisible(deleteBillBtn);
    }

    public boolean isUniqueRefNoDisplayed() {
        return isWebElementVisible(uniqueRefNo);
    }

    public boolean isBillPopupTimeDisplayed() {
        return isWebElementVisible(billTimeOnPopup);
    }

    public boolean isNotPaidLabelDisplayed() {
        return isWebElementVisible(notPaidLabel);
    }


}
