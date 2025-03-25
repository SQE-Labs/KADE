package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

import java.io.File;

public class ReportsPage extends BasePage {
    String month ="January 2025";
    String month2 = "December - 2024";
    String day = "Sunday";
    By storesComboBox = By.cssSelector(".select2-selection.select2-selection--single");
    By storeSelection = By.xpath("//ul[@class=\"select2-results__options\"]//li[contains(text(), \"Automation Transaction 3\")]");
    By continueBtn = By.xpath("//button[@class='btn btn-primary'][text()='Continue']");
    By dailyPayConfirmation = By.xpath("//a[text()='Daily Payments Confirmations']");
    By monthlyPayConfirmation = By.xpath("//a[text()='Monthly Payments Confirmations']");
    By payReceived = By.xpath("//a[text()='Payments Received']");
    By reportsPgHeading = By.cssSelector(".header-title.mb-0");
    By storeCustomer = By.xpath("//ul[@class='select2-results__options']//li[contains(text(), 'Automation Customer Store')] ");
    By NoResultIcon = By.cssSelector(".no-result-icon");
    By monthCardHeader = By.cssSelector(".card-header");
    By cardBody = By.xpath("//div[@class='card-body max-30c collapse show']");
    By janDataDownload = By.xpath("(//a[contains(text(),'"+month+"')]//parent::div/div[1]//strong[text()='"+day+"'])[1]");
    By selectJanuaryMonth = By.xpath("//a[@class='card-header collapsed' and text()='"+month+"']");
    By dec24Report = By.xpath("//strong[@class='align-self-center' and text()='"+month2+"']");
    By totalReceivedamt = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Received Amount']");
    By totalTax = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Tax']");
    By totalTip = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Tip']");
    By filterBtn = By.cssSelector(".fas.fa-filter.me-1");
    By todayFilter = By.xpath("//label[@class='btn btn-outline-primary ' and text()='Today']");
    By yesterdayFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Yesterday']");
    By lastMonthFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Last month']");
    By customDateFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Custom date']");
    By dateRangePayReceived = By.xpath("//input[@name='dateRange']");
    public By applyDateRangePayRec = By.cssSelector(".btn-sm.mx-2.-btnapply-.btn.btn-outline-primary");
    public By printTotalReceivedPay = By.id("lblTotalReceivedAmount");
    By printTotalTaxPay = By.id("lblTotalTax");
    By printTotalTip = By.id("lblTotalTip");

    public Clickable getTotalTipAmount() {return Clickable.getElementBy(printTotalTip,"TotalTip amount");}

    public Clickable getTotalTaxAmount() {return Clickable.getElementBy(printTotalTaxPay,"Total tex amount");}

    public Clickable getTotalReceivedPayAmount() {return Clickable.getElementBy(printTotalReceivedPay,"Total received pay amount");}

    public Clickable getApplyButton() {return Clickable.getElementBy(applyDateRangePayRec,"Apply button");}

    public Editable getCustomDateRangeInputField() {return Editable.getElementBy(dateRangePayReceived,"Date range input field for custom date stats");}

    public Clickable getCustomDateStats() {return Clickable.getElementBy(customDateFilter,"Custom date filter");}

    public Clickable getLastMonthStats() {return Clickable.getElementBy(lastMonthFilter,"Last month filter");}

    public Clickable getYesterdayStats() {return Clickable.getElementBy(yesterdayFilter,"Yesterday filter");}

    public Clickable getTodayStats() {return Clickable.getElementBy(todayFilter,"Today filter");}

    public Clickable getFilterButton() {return Clickable.getElementBy(filterBtn,"Filter button");}

    public Clickable getTotalTip() {return Clickable.getElementBy(totalTip,"Total tip displayed on Payments received tab");}

    public Clickable getTotalTax() {return Clickable.getElementBy(totalTax,"Total tax displayed on Payments received tab");}

    public Clickable getTotalReceivedAmt() {return Clickable.getElementBy(totalReceivedamt,"Total received amount on Payments received tab");}

    public Clickable getDecMonthReport() {return Clickable.getElementBy(dec24Report,"December report");}

    public Clickable getJanMonth() {return Clickable.getElementBy(selectJanuaryMonth,"Select january month");}

    public Clickable getJanData() {
        return Clickable.getElementBy(janDataDownload,"Jan data download file");
    }

    public Clickable getCardBody() {return Clickable.getElementBy(cardBody,"Card Body");}

    public Clickable getMonthCardHeader() {return Clickable.getElementBy(monthCardHeader,"Card header");}

    public Clickable getNoResultIcon() {return Clickable.getElementBy(NoResultIcon,"No result Icon");}

    public Clickable getCustomerStore() {return Clickable.getElementBy(storeCustomer,"Customer store");}

    public Clickable getReportsPgHeading() {return Clickable.getElementBy(reportsPgHeading,"Reports page heading");}

    public Clickable getPayReceived() {return Clickable.getElementBy(payReceived,"Payment received");}

    public Clickable getMonthlyPayConf() {return Clickable.getElementBy(monthlyPayConfirmation,"Monthly payment confirmation");}

    public Clickable getDailyPayConf() {return Clickable.getElementBy(dailyPayConfirmation,"Daily payment connfirmation");}

    public Clickable getStoresComboBox() {return Clickable.getElementBy(storesComboBox,"Stores combobox");}

    public Clickable getStoreSelection() {return Clickable.getElementBy(storeSelection,"Select store");}

    public Clickable getContinueBtn()

    {
        return Clickable.getElementBy(continueBtn,"Continue button");
    }

    public static String deleteFile(String fileName) {
        String home = System.getProperty("user.home");
        String file_with_location;

        if (System.getProperty("os.name").contains("Windows")) {
            file_with_location = home + "Downloads" + fileName;
        } else {
            file_with_location = home + "/Downloads/" + fileName;
        }
        File file = new File(file_with_location);

        if (file.exists()) {
            if (file.delete()) {
                return "File deleted successfully.";
            } else {
                return "Failed to delete the file.";
            }
        } else {
            return "File does not exist.";
        }
    }

}
