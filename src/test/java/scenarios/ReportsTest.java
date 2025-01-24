package scenarios;

import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.pages.ReportsPage;
import org.automation.session.KadeSession;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;
import org.automation.base.BaseTest;

import java.io.File;

import static org.automation.utilities.ActionEngine.isFileDownloaded;

public class ReportsTest extends BaseTest{

    @Test(description = "Verify that Reports page opens up")
    public void verifyReportsPgOpens(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        Assertions.assertTrue(session.getReportsPage().getDailyPayConf().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getReportsPgHeading().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getMonthlyPayConf().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getPayReceived().isDisplayed());

    }

    @Test(description = "Verify that reports page opens for customer store")
    public void verifyReportsPgForCustStore() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getCustomerStore().click();
        session.getReportsPage().getContinueBtn().click();

        Assertions.assertTrue(session.getReportsPage().getNoResultIcon().isDisplayed());
    }

    @Test(description = "Verify that daily report appears on report page")
    public void verifyDailyReport() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        Assertions.assertTrue(session.getReportsPage().getMonthCardHeader().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getCardBody().isDisplayed());
    }

    @Test(description = "Verify that reports get downloaded on csv format")
    public void verifyDownloadedReports() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        session.getReportsPage().getJanMonth().click();
        ReportsPage.deleteFile(Constants.fileNameDaily);
        session.getReportsPage().getJanData().clickByMouse();
        WebdriverWaits.sleep(4000);
        String fileStatus = isFileDownloaded(Constants.fileNameDaily);
        System.out.println("fileStatus :" + fileStatus);
        Assertions.assertEquals(fileStatus,Constants.filePresent);
    }

    @Test(description = "Verify that monthly reports get generated under 'Monthly Payments Confirmations' tab on 'Reports' page, after every month end.")
    public void verifyMonthlyPayConfirmationReport(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        session.getReportsPage().getMonthlyPayConf().click();
        Assertions.assertTrue(session.getReportsPage().getDecMonthReport().isDisplayed());
        ReportsPage.deleteFile(Constants.filenameMonthly);
        session.getReportsPage().getDecMonthReport().clickByMouse();
        WebdriverWaits.sleep(4000);
        String fileStatus = ActionEngine.isFileDownloaded(Constants.filenameMonthly);
        System.out.println("fileStatus :" + fileStatus);
        Assertions.assertEquals(fileStatus,Constants.filePresent);
    }

    @Test(description = "Verify that stats of total received amount appears on 'Payment Received' tab, after clicking on 'Payment Received' tab, on Reports page.")
    public void verifyPaymentReceived() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        session.getReportsPage().getPayReceived().click();
        Assertions.assertTrue(session.getReportsPage().getTotalReceivedAmt().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getTotalTax().isDisplayed());
        Assertions.assertTrue(session.getReportsPage().getTotalTip().isDisplayed());

    }

    @Test(description = "Verify that 'Today' statistics appear after clicking on 'Today' from 'Filter'")
    public void verifyTodayStats() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        session.getReportsPage().getPayReceived().click();
        session.getReportsPage().getTodayStats().click();
        WebdriverWaits.sleep(1000);
        System.out.println(session.getReportsPage().getTotalReceivedPayAmount().getText());
        System.out.println(session.getReportsPage().getTotalTaxAmount().getText());
        System.out.println(session.getReportsPage().getTotalTipAmount().getText());

        session.getReportsPage().getYesterdayStats().click();
        WebdriverWaits.sleep(1000);
        System.out.println(session.getReportsPage().getTotalReceivedPayAmount().getText());
        System.out.println(session.getReportsPage().getTotalTaxAmount().getText());
        System.out.println(session.getReportsPage().getTotalTipAmount().getText());

        session.getReportsPage().getLastMonthStats().click();
        WebdriverWaits.sleep(1000);
        System.out.println(session.getReportsPage().getTotalReceivedPayAmount().getText());
        System.out.println(session.getReportsPage().getTotalTaxAmount().getText());
        System.out.println(session.getReportsPage().getTotalTipAmount().getText());

    }

    @Test(description = "Verify that statistics for selected date range appear on 'Payments received' tab after selecting a date range")
    public void verifyCustomDateRange() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getReportsTab().click();
        session.getReportsPage().getStoresComboBox().click();
        session.getReportsPage().getStoreSelection().click();
        session.getReportsPage().getContinueBtn().click();

        session.getReportsPage().getPayReceived().click();
        session.getReportsPage().getCustomDateStats().click();
        WebdriverWaits.waitForElementVisible(session.getReportsPage().applyDateRangePayRec,20);
        session.getReportsPage().getCustomDateRangeInputField().setText(Constants.dateRange);
        session.getReportsPage().getApplyButton().click();
        System.out.println(session.getReportsPage().getTotalReceivedPayAmount().getText());
        System.out.println(session.getReportsPage().getTotalTaxAmount().getText());
        System.out.println(session.getReportsPage().getTotalTipAmount().getText());
    }


}
