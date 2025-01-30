package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage extends BasePage {
    //Locators
    By transactionRow = By.xpath("//div[contains(@class,'bg-white border')]");
    By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
    By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    By uniqueTransactionId = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate']");
    public By transactionID = By.cssSelector(".badge.position-relative.bg-light.text-dark.p-1");
    By store = By.xpath("//span[@class='fs-pn15 text-truncate']");
    By payment = By.cssSelector(".fs-pn25.ms-2");
    By customerName = By.cssSelector(".flex-column.overflow-hidden>a");
    By transactionAmmount = By.xpath("//div[@class='d-flex align-items-center']");
    By customNameONRecipt = By.xpath("//a[@class='text-truncate']");
    By time = By.xpath("//span[@class='fs-pn25 mb-2 ms-auto']");
    By informationMessage = By.xpath("//p[text()='There are no payments available yet!']");
    By newBillTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[1]");
    By newChargeTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[2]");
    public By filterIcon = By.xpath("//div[@class='d-flex flex-wrap'] //button[3]");
    By terminalAlertMessage = By.xpath("//p[text()='Terminal charges are not accepted']");
    By currentPaidBill = By.xpath("(//div[contains(@class, 'bg-white') and contains(@class, 'position-relative')])[1]");
    public By refundButton = By.cssSelector("[title='Refund']");
    public By refundRefenceNo = By.cssSelector("[name='refNo']");
    By refundReason = By.cssSelector("[name='reason']");
    By processFullRefund = By.cssSelector("[name='refundAll']");
    By refundAmountOnReceipt = By.cssSelector("[class=\"d-flex align-items-end\"]");
    public By refundLabel = By.xpath("//h4[text()='** Refund **']");
    By verifyButton = By.cssSelector("button.btn.btn-outline-success");
    By partialRefundLink = By.xpath("//button[text()='Partial refund']");
    By selectPaymentInfo = By.cssSelector("div[id='_B1Q'] p");
    By paymentCheckBox = By.xpath(" //label[@class='custom-checkbox']");
    By validationMessage = By.xpath("//p[text()='Select at least one payment to refund']");
    public By processRefundButton = By.xpath("//button[text()='Process Refund']");
    By refundAmountField = By.cssSelector("[name='refunds[0].amount']");
    By verifyButtonOnPopup = By.xpath("//button[@class='btn btn-success']");
    By informationMessageOnVerifyPopup = By.xpath("//div[@class='alert-message']");
    By verifyByStoreMssg = By.xpath("//span[@class='badge rounded-pill bg-info px-2']");
    public By applyButton = By.xpath("//button[@type='submit']");
    By filterTiltle = By.xpath("(//h5[@class='offcanvas-title'])[1]");
    public By downloadButton = By.xpath("//button[normalize-space()='Download']");
    By listCallender = By.xpath("//ul[@class='float-none w-100']/li");
    public By dateRangeField = By.xpath("//input[@name='dateRange']");
    By calender1 = By.xpath("//div[@class='drp-calendar left float-none w-100']");
    By calender2 = By.xpath("//div[@class='drp-calendar right float-none w-100']");
    By yesterday = By.xpath("(//ul[@class='float-none w-100']/li)[2]");
    By yesterdayOnTransactionList = By.xpath("//span[@class='fs-pn25 mb-2']");
    public By paaymentStatusDropdown = By.xpath("//select[@name='paymentStatus']");
    By clearPaymentField = By.xpath("(//select[@name='paymentStatus']/option)[1]");
    By pendingPayments = By.xpath("//option[@value='pending']");
    public By failedPayments = By.xpath("//option[@value='failed']");
    public By unverifiedPayments = By.xpath("//option[@value='unverified']");
    By pendingPaymentIcon = By.xpath("//i[contains(@class,'fas fa-hourglass-half text-warning fs-5 me-2')]");
    public By excalamatrySign = By.xpath("//i[contains(@class,'fas fa-exclamation-circle text-danger fs-5 me-2')]");
    public By quotionmarkSign = By.xpath("//i[@class='fas fa-question-square text-info fs-5 me-2']");
    public By qrCodeSign = By.xpath("//i[contains(@class,'fa fa-qrcode me-2')]");
    public By paymentLinkField = By.xpath("//select[@name='billTemplate']");
    By qrCodeSeletct = By.xpath("(//select[@name='billTemplate']/option)[2]");
    By amountRangeFrom = By.xpath("//input[@placeholder='From']");
    By amountRangeTo = By.xpath("//input[@placeholder='To']");
    By clearQrPayment = By.xpath("(//select[@name='billTemplate']/option)[1]");
    By ammountList = By.xpath("((//div[contains(@class,'d-flex align-items-center')])//span)");
    By paidLabelOnPopup = By.cssSelector("span.bg-success");
    By returnSymbol = By.xpath("//div[span[text()='Refunded']]/following::div[4]/i");
    public By questionMarkIcon = By.cssSelector(".align-items-end>i");
    public By capturedButton = By.cssSelector("[value='captured']");
    By failedButton = By.cssSelector(".mx-3");
    By recurringIcon = By.cssSelector(".fa.fa-repeat.me-1");
    By ConfigureStore = By.xpath("//a[@href=\"/Stores/manageStore/3980\"]");
    By PaymentProcessing = By.xpath("//a[contains(text(),'Payment Processing')]");
    By ProcessingFeeBtn = By.xpath("(//button[@class='btn-sm p-0 btn btn-link collapsed'])[1]");
    By FeeDetails1 = By.xpath("(//div[@class='mb-2 fs-pn15']/ul/li)[1]");
    By FeeDetails2 = By.xpath("(//div[@class='mb-2 fs-pn15']/ul/li)[2]");
    public By TerminalServiceFee = By.xpath("//span[@class='text-danger fw-bold ']");
    By CloseBtn = By.xpath("(//div[@class='modal-header']/button)[2]");
    By ManualCloseBtn = By.xpath("(//div[@class='modal-header'])[4]/button");
    By NewCharge = By.xpath("(//div[@class='col-4 col-sm-3']/button)[2]");
    By CancelBtn = By.xpath("(//button[contains(text(),'Cancel')])[2]");
    By ManualBtn = By.xpath("//div[contains(text(),'Manual')]");
    By ManualServiceFee = By.xpath("//div[@class='text-warning']/span[@class='ms-2']");



    public Clickable getFailedButton() {
        return Clickable.getElementBy(failedButton, "failed Button ");
    }
    public Clickable getRecurringIcon() {return Clickable.getElementBy(recurringIcon, "Recurring Icon");}
    public Clickable getCapturedButton() {
        return Clickable.getElementBy(capturedButton, "Captured Button");
    }
    public Clickable getQuestionMarkIcon() {
        return Clickable.getElementBy(questionMarkIcon, "Question Mark Icon");
    }
    public Clickable getPaidLabelOnPopup() {
        return Clickable.getElementBy(paidLabelOnPopup, "Paid Label");
    }
    public Clickable getContinueButton() {
        return Clickable.getElementBy(continueBtn, "Continue Button");
    }
    public Clickable getReturnSymbol() {
        return Clickable.getElementBy(returnSymbol, "Refund Symbol");
    }
    public Clickable getLastTransactionRow() {
        return Clickable.getElementBy(transactionRow, "Last Transaction");
    }
    public Clickable getConfigureStore() { return Clickable.getElementBy(ConfigureStore, "Configure Store");}
    public Clickable getPaymentProcessing() { return Clickable.getElementBy(PaymentProcessing, "Payment Processing");}
    public Editable getFeeDetails1() {return Editable.getElementBy(FeeDetails1, "Fee Details");}
    public Editable getFeeDetails2() {return Editable.getElementBy(FeeDetails2, "Fee Details");}
    public Editable getTerminalServiceFee() { return Editable.getElementBy(TerminalServiceFee, "Terminal Service Fee Details");}
    public Clickable getManualBtn() { return Clickable.getElementBy(ManualBtn, "Manual Button"); }
    public Clickable getCloseBtn() { return Clickable.getElementBy(CloseBtn,"Close Button"); }
    public Clickable getNewCharge() { return Clickable.getElementBy(NewCharge, "New Charge");}
    public Clickable getCancelBtn() { return Clickable.getElementBy(CancelBtn,"Cancel Button"); }
    public Clickable getManualCloseBtn() { return Clickable.getElementBy(ManualCloseBtn,"Manual Close Button"); }
    public Editable getManualServiceFee() { return Editable.getElementBy(ManualServiceFee, "Manual Service Fee Details");}



    public Clickable getBillAmount() {
        return Clickable.getElementBy(billAmount, "Bill Amount");
    }

    public Clickable getUniqueTransactionId() {
        return Clickable.getElementBy(uniqueTransactionId, "Transaction ID");
    }
    public Clickable getProcessingFeeBtn() { return Clickable.getElementBy(ProcessingFeeBtn, "Processing Fee Btn");}

    public Clickable getCloseTransactionPopupButton() {
        return Clickable.getElementBy(closeTransactionPopupBtn, "Close button");
    }

    public Clickable getTransactionID() {
        return Clickable.getElementBy(transactionID, "transaction ID");
    }

    public Clickable getTransactionAmmount() {
        return Clickable.getElementBy(transactionAmmount, "transaction Amount");
    }

    public Clickable getPaymentTypeOnTransaction() {
        return Clickable.getElementBy(payment, "Payment Type");
    }

    public Clickable getStore() {
        return Clickable.getElementBy(store, "Store Type");
    }

    public Clickable getCustomeName() {
        return Clickable.getElementBy(customNameONRecipt, "Customer Name");
    }

    public Clickable getCustomerNameOnTransactionPage() {
        return Clickable.getElementBy(customerName, "Customer Name");
    }

    public void clickStoresDropdown() {
        click(storesCombobox);
    }


    public void selectStore(String store) {
        clickStoresDropdown();
        click(By.xpath("//li[contains(text(),'" + store + "')]"));
        getContinueButton().click();
    }

    public Clickable getTimeOnTransactionPage() {
        return Clickable.getElementBy(time, "transaction time ");
    }

    public boolean matchPattern(String transID) {
        if (transID.startsWith("TR-")) {
            transID = transID.substring(3);
        }
        boolean checkflag = true;
        // Check if the transaction ID contains only digits on Transaction Page
        if (!transID.matches("\\d+")) {
            checkflag = false;
        }
        return checkflag;
    }

    public boolean matchTimePattern(String time) {
        boolean isValid = time.matches("^(0?[1-9]|1[0-2]):([0-5][0-9]) (AM|PM)$");
        boolean check = true;
        // Print the result
        if (!isValid) {
            check = false;
        }
        return check;
    }

    public Clickable getInformationMessage() {
        return Clickable.getElementBy(informationMessage, "Information message label");
    }

    public Clickable getNewBillTab() {
        return Clickable.getElementBy(newBillTab, "New Bill Tab");
    }

    public Clickable getNewChargeTab() {
        return Clickable.getElementBy(newChargeTab, "New Charge Tab");
    }

    public Clickable getFilterIcon() {
        return Clickable.getElementBy(filterIcon, "Filter Icon");
    }

    public Clickable getTerminalAlertMessage() {
        return Clickable.getElementBy(terminalAlertMessage, " Alert Message");
    }

    public Clickable getCurrentPaidBill() {
        return Clickable.getElementBy(currentPaidBill, " CurrentPaidBill");
    }

    public Clickable getRefundButton() {
        return Clickable.getElementBy(refundButton, "Refund Button");
    }

    public Editable getRefundReferenceNo() {
        return Editable.getElementBy(refundRefenceNo, "Refund Reference No Field");
    }

    public Editable getRefundReason() {
        return Editable.getElementBy(refundReason, "Refund Reason Field");
    }

    public Clickable getFullRefundButton() {
        return Clickable.getElementBy(processFullRefund, "Process Full Refund");
    }

    public Clickable getRefundAmountOnReceipt() {
        return Clickable.getElementBy(refundAmountOnReceipt, "Refund Amount On Receipt");
    }

    public Clickable getRefundLabel() {
        return Clickable.getElementBy(refundLabel, "Refund Label");
    }

    public Clickable getVerifyButton() {
        return Clickable.getElementBy(verifyButton, "Verify Button");
    }

    public Clickable getPartialRefundLink() {
        return Clickable.getElementBy(partialRefundLink, "Partial Refund Link");
    }

    public Clickable getSelectPaymentInformationMessage() {
        return Clickable.getElementBy(selectPaymentInfo, "Select payments which are refunded from the list below");
    }

    public Clickable getVisaPaymentCheckbox() {
        return Clickable.getElementBy(paymentCheckBox, "Payment Checkbox");
    }

    public Clickable getRefundValidationMessage() {
        return Clickable.getElementBy(validationMessage, "Select atleast one payment method");
    }

    public Clickable getProcessRefundButton() {
        return Clickable.getElementBy(processRefundButton, "Process Refund Button");
    }

    public Editable getRefundAmountField() {
        return Editable.getElementBy(refundAmountField, "Refund Amount");
    }

    public Clickable getVerifyButtonOnPopup() {
        return Clickable.getElementBy(verifyButtonOnPopup, "Verify Button on Popup");
    }

    public Clickable getInformationMessageOnVerifyPopup() {
        return Clickable.getElementBy(informationMessageOnVerifyPopup, "Verify information message on Popup");
    }


    public Clickable getVerifiedByStoreMssg() {
        return Clickable.getElementBy(verifyByStoreMssg, "Verify store message on Transaction Receipt");
    }

    public Clickable getApplyButtonOnPopup() {
        return Clickable.getElementBy(applyButton, "Verify Apply button is display ");
    }

    public Clickable getFilterTitle() {
        return Clickable.getElementBy(filterTiltle, "Verify Filter title is displayed");
    }

    public Clickable getDownloadButton() {
        return Clickable.getElementBy(downloadButton, "Verify download Button is displayed");
    }

    public Clickable getListCallenderTime() {
        return Clickable.getElementBy(listCallender, "Verify list of callender is displayed");
    }

    public Clickable getDateRangeField() {
        return Clickable.getElementBy(dateRangeField, "Verify dateRange field is displayed");
    }

    public Clickable getCalender1() {
        return Clickable.getElementBy(calender1, "Verify calender1 is displayed");
    }

    public Clickable getCalender2() {
        return Clickable.getElementBy(calender2, "Verify calender2 is displayed");
    }

    public Clickable getYesterDayDate() {
        return Clickable.getElementBy(yesterday, "Verify yesterday is displayed");
    }

    public Clickable getYesterDayListOnTransactionPage() {
        return Clickable.getElementBy(yesterdayOnTransactionList, "Verify yesterdayOnTransactionList date is displayed");
    }

    public Clickable getPaymentStatusDropdown() {
        return Clickable.getElementBy(paaymentStatusDropdown, " paaymentStatusDropdown is displayed");
    }

    public Clickable getClearPaymentField() {
        return Clickable.getElementBy(clearPaymentField, "clearPaymentField is displayed");
    }

    public Clickable getPendingPayments() {
        return Clickable.getElementBy(pendingPayments, "pendingPayments is displayed");
    }

    public Clickable getFailedPayments() {
        return Clickable.getElementBy(failedPayments, "failedPayments is displayed");
    }

    public Clickable getUnverifiedPayments() {
        return Clickable.getElementBy(unverifiedPayments, "unverifiedPayments is displayed");
    }

    public Clickable getPendingPaymentIcon() {
        return Clickable.getElementBy(pendingPaymentIcon, "pendingPaymentIcon is displayed");
    }

    public Clickable getExcalamatrySign() {
        return Clickable.getElementBy(excalamatrySign, "excalamatrySign is displayed");
    }

    public Clickable getQuotionmarkSign() {
        return Clickable.getElementBy(quotionmarkSign, "quotionmarkSign is displayed");
    }

    public Clickable getQrCodeSign() {
        return Clickable.getElementBy(qrCodeSign, "qrCodeSign is displayed");
    }

    public Clickable getPaymentLinkField() {
        return Clickable.getElementBy(paymentLinkField, "payment link is displayed");
    }

    public Clickable getQrCodeSeletct() {
        return Clickable.getElementBy(qrCodeSeletct, "Qr code selected  is displayed");
    }

    public Clickable getQrClearField() {
        return Clickable.getElementBy(clearQrPayment, "quotionmarkSign is displayed");
    }


    public Editable getAmmountFieldFrom() {
        return Editable.getElementBy(amountRangeFrom, "amountRangeFrom");
    }
    public Editable getAmmountFieldTo() {
        return Editable.getElementBy(amountRangeTo, "amountRangeTo");
    }
    public Clickable getAmmountList() {
        return Clickable.getElementBy(ammountList, "ammountList");
    }

}
