package org.automation.pageObjects;

import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.*;

import static org.apache.xmlbeans.xml.stream.utils.NestedThrowable.Util.printStackTrace;

public class BillPage extends BasePage {

    public By newBillBtn = By.xpath("//button[@class='btn btn-outline-dark']");
    public By recurringBtn = By.xpath("//div[text()='Recurring']");
    public By alertMessage = By.xpath("//div[@class='alert-message']");
    public By transactionsLink = By.xpath("//div[text()='Transactions']");
    public By amtTbx = By.xpath("//input[@name=\"amount\"]");
    public By selectedCustomer = By.xpath("(//div[@data-field=\"name\"]/../../../..  //div[@class='d-none empty-d-block'])[2]");
    public By suggestionList = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    By customerField = By.xpath("//div[@class='modal-content']//label[text()='Customer']");
    By moreOptionsField = By.xpath("//div[@class=\"modal-body\"] //label[text()='More options']");
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
    By unpaidBill = By.xpath("//div[@class='badge bg-danger']/../../..");
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
    By closeLogoPopupBtn = By.xpath("//div[@class='modal-sm modal-dialog']//button");
    By totalAmt = By.xpath("//span[@data-field='total']");
    By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");
    By cameraIcon = By.xpath("(//button[contains(@onclick,'image')])[2]");
    By documnetIcon = By.xpath("(//button[contains(@onclick,'pdf')])[2]");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By attachedImage = By.xpath("//img[@class='img-thumbnail  bg-black']");
    By deleteBill = By.xpath("(//div[@class='container-fluid ']//div[@class='row bg-white rounded-2 g-2 m-0 mt-2 position-relative border overflow-hidden -tr-row-'])[1]");
    By deleteButton = By.cssSelector(".btn.btn-outline-danger");
    By deleteIcon = By.cssSelector(".btn.btn-outline-success");
    By moreOptions = By.cssSelector(".mb-3.border.p-2.py-3.rounded-3.advanced-d-none.position-relative");
    By referenceNo = By.xpath("(//div[@class='border p-2 py-3 mb-2 rounded-3  d-none advanced-d-block'])[1]");
    public By refNoField = By.xpath("(//input[@lbl-title='Reference No.'])[2]");
    By description = By.xpath("(//div[@class='border p-2 py-3 mb-2 rounded-3  d-none advanced-d-block'])[2]");
    public By descriptionField = By.xpath("(//textarea[@lbl-title='Description'])[2]");
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
    //By descText = By.xpath("//label[text()='Description:']/../div/div/div[1]/div[1]");
    By descText = By.xpath("(//div[@class='link-empty w-100 text-truncate'])[2]");
    By descPopUp = By.xpath("//h5[text()='Description']");
    By addedDescription = By.xpath("(//div[@class='border rounded p-1 overflow-hidden'])[1]");
    By repeatBtn = By.xpath("(//div[@class='position-absolute start-0 end-0 top-0 bottom-0 bg-locked'])[1]");
    By expiryBtn = By.xpath("(//div[@class='position-absolute start-0 end-0 top-0 bottom-0 bg-locked'])[2]");
    By notNowBtn = By.xpath("(//button[@class='btn btn-outline-primary'])[1]");
    By upgradeBtn = By.xpath("//a[text()='Upgrade']");
    By filterIcon=By.xpath("//i[@class='far fa-2x fa-sliders-h-square']");
    By freezeIcon1=By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[1]");
    By freezeIcon2=By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[2]");
    By upgradePopUpTitle=By.xpath("//h3[text()='Upgrade your plan']");


    public String getPopUpTitle() {
        WebdriverWaits.waitForElementVisible(popUpHeader, 5);
        return getText_custom(popUpHeader);
    }

    public void enterSubTotalAmount(int i) {
        WebdriverWaits.waitForElementUntilVisible(subTotalBox, 5);
        sendKeysUsingJavaScript(subTotalBox, "document.getElementsByName('subTotal')[0].value=" + i);
    }

    public void enterPhoneNumber(String number) {
        sendKeys(customerNumber, number);
    }

    public void clickOnCreate() {
        click(createBtn);
    }

    public void clickOnAddBillDetail() {
        click(addBillDetails);
    }

    public boolean billDetailsHeader() {
        return isElementPresent(addBillDescription, "Add Bill Details description");
    }

    public void clickOnAddMoreRow() {
        click(addMoreRowLink);
    }

    public void moveToSubTotal() {
        moveToWebElement(subTotalBox);

    }

    public String getToolTipMessage() {
        return getText_custom(toolTipMessage);
    }

    public void switchOffAutoGenToggle() {
        if (getAttribute(autoGenClass, "class").equalsIgnoreCase("mb-2 link-check checked")) {
            WebdriverWaits.waitForElementClickable(autoGenToggleBtn, 5);
            click(autoGenToggleBtn);
        }
    }

    public void switchOnAutoGenToggle() {
        if (!getAttribute(autoGenClass, "class").equalsIgnoreCase("mb-2 link-check checked")) {
            WebdriverWaits.waitForElementClickable(autoGenToggleBtn, 5);
            click(autoGenToggleBtn);
        }
    }

    public boolean isReferenceNoTextboxPresent() {
        return isElementPresent(refNoTextBox, "Reference No Text Box");
    }


    public void CloseBillPopup() {
        click(closeBillBtn);
    }

    public void switchOnMoreToggleBtn() {
        By moreClass = By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..");
        if (getAttribute(moreClass, "class").equalsIgnoreCase("mb-2 link-check checked"))
            click(moreToggleBtn);
    }

    public void switchOffMoreToggleBtn() {
        By moreClass = By.xpath("(//div[@class='d-flex align-items-center'])[2]/../..");
        if (!getAttribute(moreClass, "class").equalsIgnoreCase("mb-2 link-check checked"))
            click(moreToggleBtn);
    }

    public boolean isCustNamePresent() {
        return isElementPresent(custName, "Customer Name");
    }

    public boolean isMemoPresent() {
        return isElementPresent(memoTextField, "Memo");
    }

    public boolean isRefNoTextFieldPresent() {
        return isElementPresent(refNoTextBox, "Ref No textbox");
    }

    public boolean isDescriptionDisplayed() {
        return isWebElementVisible(addBillDescription);
    }

    public boolean isPricePresent() {
        return isElementEnabled(addBillPrice);
    }

    public void enterCustomerEmail(String string) {
        sendKeys(emailTbx, string);
    }

    public void enterCustomerPhnNo(String phnNo) {
        click(phoneNoTbx);
        pressKeys(phoneNoTbx, phnNo);
    }

    public void enterMemo(String string) {
        sendKeys(memoTextField, string);
    }

    public void enterCustomerName(String string) {
        sendKeys(custName, string);
    }

    public void createBill(int billAmount, String phoneNo, String email, String custName, String memo) {
        switchOnAutoGenToggle();
        enterSubTotalAmount(billAmount);
        enterPhoneNumber(phoneNo);
        enterCustomerEmail(email);
        switchOnMoreToggleBtn();
        enterCustomerName(custName);
        enterMemo(memo);
        clickOnCreate();
    }

    public String getToolTipMessagePhoneNumber() {
        return getToolTipMessage(phoneNoTbx);
    }

    public String getToolTipMessageEmail() {
        return getToolTipMessage(emailTbx);
    }

    public void enterBillDetailValue1(String description, int price) {
        sendKeys(description1, description);
        sendKeysUsingJavaScript(price1, "document.getElementsByName('items[0].price')[0].value=" + price);
    }

    public void enterBillDetailValue2(String description, int price) {
        sendKeys(description2, description);
        sendKeysUsingJavaScript(price1, "document.getElementsByName('items[1].price')[0].value=" + price);
    }

    public Object getSubTotalValue() {
        return getText_custom(subTotalBox);
    }

    public boolean isAleartMessageDisplayed() {
        return isElementPresent(alertMessage, "Alert Message Section");
    }

    public boolean isFilterBtnPresent() {
        return isElementPresent(filterBtn, "Filter Button");
    }

    public void clickOnTransactions() {
        click(transactionsLink);
    }

    public String getPageHeader() {
        return getText_custom(pageHeader);
    }

    public void closeBtn() {
        click(closeIcon);
    }

    public String getpPaidBillAmount() {
        scrollToElement(paidBill1);
        WebdriverWaits.waitForElementUntilVisible(paidBill1, 5);
        return getText_custom(paidBill1).replace("$", "");
    }

    public void clickOnNewBill() {
        WebdriverWaits.waitForElementClickable(newBillBtn, 5);
        click(newBillBtn);
    }

    public String getToastMessage() {
        return getText_custom(toastMessage);
    }

    public void clickOnFilter() {
        click(filterBtn);
    }

    public boolean isDateFieldPresent() {
        return isElementPresent(fromDatePicker, "From Date Picker");
    }

    public boolean isCustomerNamePresent() {
        return isElementPresent(customerName, "Customer Name Textbox");
    }

    public boolean isUserPhoneFieldPresent() {
        return isElementPresent(UserPhoneField, "User Phone Field");
    }

    public boolean isEmailFieldPresent() {
        return isElementPresent(UserEmailField, "User Email Field");
    }

    public void clickOnApply() {
        scrollToElement(applyBtn);
        WebdriverWaits.fluentWait_ElementIntactable(10, 100, applyBtn);
        click(applyBtn);
    }

    public String getCustomerPhoneNumber() {
        return getText_custom(customerNumberResult);
    }

    public void enterUserNumber(String string) {
        sendKeys(userNumber, string);
    }

    public void clickOnFirstTransaction() {
        WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
        click(unpaidBill);
    }

    public String getFirstRefNoBillDisplayed() {
        return getText_custom(refNo);
    }

    public void closeToastBtn() {
        WebdriverWaits.waitForElementClickable(toastCloseBtn, 5);
        click(toastCloseBtn);
    }

    public void openUnpaidBill() {
        WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
        click(unpaidBill);
    }


    public void clickOnFirstUnPaidBills() {
        WebdriverWaits.fluentWait_ElementIntactable(10, 100, unpaidBill);
        click(unpaidBill);
    }

    public void clickOnRefund() {
        click(refundBtn);
    }

    public void enterReason(String string) {
        sendKeys(reasonField, string);
    }

    public void clickOnProcessFullRefund() {
        click(processFullRefund);
    }

    public String getRefundHeader() {
        return getText_custom(refundHeader);
    }

    public int getCountOfAllBill() {
        ScrollDownThePageMax();
        WebdriverWaits.sleep(2000);
        int count = countWebElements(billGrid);
        scrollToPageTop(newBillBtn);
        return count;
        //return getListOfWebElements(billGrid).stream().allMatch(a->a.isDisplayed());
    }

//	public void enterCustomerName(String string) {
//		sendKeys_withClear(customerName, string);
//	}

    public boolean isTransactionDisplayed() {
        return isElementPresent(transactionsLink, "Transactions Link");
    }


    public long countOfUserPhonePresent(String string) {
        ScrollDownThePageMax();
        By userPhoneOnBill = By.xpath("//p[text()='" + string + "']");
        long count = getAllMatchingCount(userPhoneOnBill, string);
        scrollToPageTop(newBillBtn);
        return count;
    }

    public void enterUserEmail(String string) {
        sendKeys(UserEmailField, string);
    }

    public long countOfUserEmailPresent(String string) {
        ScrollDownThePageMax();
        By userEmailOnBill = By.xpath("//p[text()='" + string + "']");
        scrollToPageTop(newBillBtn);
        long count = getAllMatchingCount(userEmailOnBill, string);
        return count;
    }

    public void enterFrom(String fromDate, String toDate) {
        String date = fromDate + " - " + toDate;
        sendKeys(fromDatePicker, date);
        getDriver().findElement(fromDatePicker).sendKeys(Keys.ENTER);
    }

    public String getInfoMessage() {
        return getText_custom(infoMessage);
    }

    public String getEmailToolTiptMessage() {
        WebdriverWaits.sleep(500);
        return getToolTipMessage(UserEmailField);
    }

    public void clickOnBill() {
        click(billGrid);
    }

    public boolean isBillViewPopUpHeaderPresent() {
        return isElementPresent(billViewPopupTitleHeader, "Bill View Popup Title Header");
    }

    public boolean isRefNoPresent(String refNo2) {
        By refNo = By.xpath("//p[text()='" + refNo2 + "']");
        return isElementPresent(refNo, "Ref No.");
    }

    public void clickOnFirstPaidBills() {
        clickOnFilter();
        enterCustomerName("Ana");
        clickOnApply();
        click(bill);

    }

    public String getToolTipMemo() {
        WebdriverWaits.waitForElementUntilVisible(memoNote, 5);
        return getToolTipMessage(memoNote);
    }

    public String getToolTipUserPhone() {
        WebdriverWaits.sleep(2000);
        return getToolTipMessage(UserPhoneField);
    }

    public long countOfPartialCustName(String string) {
        return getAllMatchingCount(name, string);
    }

    public boolean verifyRecordsDateRange(List<String> billDate, String fromDate, String toDate) {
        for (String s : billDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            LocalDate actualDate = LocalDate.parse(s, formatter);
            LocalDate fromdate = LocalDate.parse(fromDate, formatter);
            LocalDate todate = LocalDate.parse(toDate, formatter);
            if (!actualDate.isBefore(fromdate) && !actualDate.isAfter(todate)) {
                continue;
            } else
                return false;
        }
        return true;

    }

    public List<String> getDateOfBill() {
        By billDate = By.xpath("//tr[@class='none-workingEffect']/td[2]/p[2]");
        List<WebElement> allDates = getListOfWebElements(billDate);
        List<String> date = allDates.stream().map(str -> str.getText().split(" ")[0]).collect(Collectors.toList());
        return date;
    }

    public boolean checkFieldContains(String string) {
        List<String> custList = getListOfString(customerNames).stream().map(m -> m.toLowerCase()).collect(Collectors.toList());
        String str = string.toLowerCase();
        return custList.stream().allMatch(a -> a.contains(str));
    }

    public boolean isNewBillBtnDisplayed() {
        return isWebElementVisible(newBillBtn);
    }

    public boolean isTransactionLinkDisplayed() {
        return isWebElementVisible(transactionsLink);
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

    public void getAmtValue() {

    }

    public String getSelectedCustomer() {
        return getText_custom(selectedCustomer);
    }

    public void clickCustomer() {
        click(customerBtn);
    }

    public String getCustomerHeader() {
        return getText_custom(customerHeader);
    }

    public void closeCustomerPopup() {
        click(closeCustomerBtn);
    }

    public void clickOnGoBtnPhoneNo() {
        click(goBtnPhnNo);
    }

    public void clickOnGoBtnEmail() {
        click(goBtnEmail);
    }

    public void searchCustomer(String customer) {
        WebdriverWaits.fluentWait_ElementIntactable(5, 500, searchTbx);
        click(searchTbx);
        sendKeys_withClear(searchTbx, customer);
    }

    public String getSearchedCustomer() {
        return getText_custom(searcherName);
    }

    public void clickDiscardBtn() {
        click(discardBtn);
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

    public void clickStoresDropdown() {
        click(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }

    public String getMessagePopupHeader() {
        return getText_custom(messagePopupHeader);
    }

    public boolean isSelectACustomerBtnVisible() {
        return isWebElementVisible(selectACustomerBtn);
    }

    public boolean isContinueWithoutBtnVisible() {
        return isWebElementVisible(continueWithoutBtn);
    }

    public boolean isToastMessageDisplayed() {
        return isWebElementVisible(toastMessage);
    }

    public boolean isNotPaidLabelDisplayed(String amt) {
        By notPaidLabel = By.xpath("//span[text()='$" + amt + "']/../../div[1]/span");
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
            click(closeLogoPopupBtn);
        } catch (TimeoutException e) {
        }
    }

    public void clickOnSelectACustomer() {
        WebdriverWaits.waitForElementClickable(selectACustomerBtn, 5);
        moveToWebElement(selectACustomerBtn);
        click(selectACustomerBtn);
    }

    public boolean isSearchFieldPresent() {
        return isWebElementVisible(searchTbx);
    }

    public boolean isCustomerPhnNoFieldPresent() {
        WebdriverWaits.waitForElementVisible(customerNumber, 5);
        return isWebElementVisible(customerNumber);
    }

    public void ClickSuggestedCustomer() {
        click(suggestionList);
    }

    public void EnableTaxToggle() {
        By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
        click(taxToggleBtn);
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

    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

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

    public void clickDocumentIcon() {
        click(documnetIcon);
    }

    public void openBillByAmt(String amt) {
        By bill = By.xpath("(//span[text()='$" + amt + "']/../../..)[1]");
        click(bill);
    }

    public void closeCreatedBill() {
        click(closeBillBtn);
    }

    public void clickUnpaidBill() {
        click(deleteBill);
    }

    public void clickDeleteButton() {
        WebdriverWaits.waitForElementUntilVisible(deleteButton, 2);
        click(deleteButton);

    }

    public void clickDeleteIcon() {
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

//    public String getDescText() {
//        return getText_custom(descText);
//    }

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

    public String getUpgradePopUpTitle(){
        WebdriverWaits.waitForElementVisible(upgradePopUpTitle, 5);
        return getText_custom(upgradePopUpTitle);
    }

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
}
