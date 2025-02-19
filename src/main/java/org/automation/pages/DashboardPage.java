package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BaseTest;
import org.automation.utilities.WebdriverWaits;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends BaseTest {
    By yourBusinessTitle = By.cssSelector("div.card-body h5:nth-child(1)");
    By customerTitle = By.cssSelector("div.card-body h5:nth-child(2)");
    By last30DaysCustomerCount = By.xpath("(//h1[contains(@class, 'display-5 mt-2 mb-4')])[1]");
    By messageTitle = By.cssSelector("div[class='row mb-1'] h5[class='card-title']");
    By processPaymentTitle = By.xpath("//h5[text()='Processed Payments']");
    By last30DaysTotalAmount = By.cssSelector("div:nth-child(1) >div >h1");
    By todayPaymentTitle = By.xpath("//h5[text()='Today’s Payments']");
    By todayPayment = By.xpath("(//h1[contains(@class, 'display-5 mt-2 mb-4')])[3]");
    By recentTransactionsTitle = By.cssSelector("a +h5.card-title.mb-0");
    By customerNameUnderRTSection = By.cssSelector(".row.g-1.p-1 >div> div:nth-child(2)");
    By recentAmountUnderRT = By.cssSelector(" div:nth-child(4) strong");
    By recentRTTime = By.cssSelector(" div:nth-child(4) strong+a");
    By refreshIcon = By.cssSelector(".card-title.mb-0 .btn >i");
    By fullListLink = By.cssSelector("a.float-end");
    public By transactionPopup = By.cssSelector("div div.modal-content:nth-child(1)");
    By RTpopupCrossIcon = By.cssSelector(" h5+ button.btn-close:nth-child(2)");
    By customerTrends = By.xpath("//h5[text()='Customer Trends']");
    By pymtmethodPopularityTitle = By.xpath("//h5[text()='Payment Methods Popularity']");
    By contactSupportLink = By.cssSelector(".card-title +h6 a");
    By myStore = By.cssSelector("[class^='card p-2 border w-20c overflow-hidden']");
    By storeCountDashboard = By.xpath("(//span[@class='badge rounded-pill bg-dark ms-n1'])[2]");
    By listofStoreNameonPopup = By.cssSelector("div.popover-body span:nth-child(1)");
    By getFirstStore = By.cssSelector(".popover-body >div a:nth-child(1)");
    By settingIcon = By.cssSelector("a.p-0.float-end");
    By yourBusinessLink = By.cssSelector("span.fs-pn15 + a");
    By messagePage = By.cssSelector("nav.navbar >h1 ");
    By storeConfigurationTitle = By.cssSelector("h1.header-title");
    By storeName = By.cssSelector(".d-flex.flex-column h3");
    public By bankAccountGraph = By.cssSelector("g[id^=\"Svgjs\"] path.apexcharts-pie-area.apexcharts-polararea-slice-0");
    By graphContainer = By.cssSelector("g.apexcharts-inner .apexcharts-pie");
    public By paths = By.cssSelector("g.apexcharts-pie g.apexcharts-series >path");
    By paymentNames = By.cssSelector(".chart .apexcharts-legend.apexcharts-align-center >div");
    // Customer Trends
    By monthsLabel = By.cssSelector(".apexcharts-xaxis-texts-g >text");
    By newLabel = By.xpath("//div[@class='apexcharts-legend-series' and @seriesname='New']");
    By repeatingLabel = By.xpath("//div[@class='apexcharts-legend-series' and @seriesname='Repeating']");
    By customerCount = By.cssSelector(" div.apexcharts-tooltip.apexcharts-theme-light div.apexcharts-tooltip-y-group >span");
    By custGraphLine = By.xpath("(//*[name()='rect' and @class='apexcharts-grid-row'])[4]");
    By lastDEC= By.xpath("(//*[contains(@id,'SvgjsText')])[6]");



    public Clickable getYourBusinessTitle() {
        return Clickable.getElementBy(yourBusinessTitle, "Your Bussiness Title");
    }
    public Clickable getFirstStoreUnderYourBusiness() {
        return Clickable.getElementBy(getFirstStore, "Get First Store");
    }
    public Clickable getSettingIcon() {
        return  Clickable.getElementBy(settingIcon,"Setting Icon");
    }
    public Clickable getYourBusinessLink() {
        return Clickable.getElementBy(yourBusinessLink,"Your Business Link");
    }
    public Clickable getStoreConfigurationTitle() {
        return Clickable.getElementBy(storeConfigurationTitle,"Store Configuration Title");
    }

    public Clickable getCustomerTitle() {
        return Clickable.getElementBy(customerTitle, "Customer Title");
    }

    public Clickable getMessageTitle() {
        return Clickable.getElementBy(messageTitle, "Message Label");
    }

    public Clickable getProcessPaymentTitle() {
        return Clickable.getElementBy(processPaymentTitle, "Process Payment");
    }

    public Clickable getTodayPaymentTitle() {
        return Clickable.getElementBy(todayPaymentTitle, "Today's payment");
    }

    public Clickable getRecentTransactionsTitle() {
        return Clickable.getElementBy(recentTransactionsTitle, "Recent Transactions");}

    public Clickable getRecentRTAmount(){ return Clickable.getElementBy(recentAmountUnderRT, " Recent Transaction Amount");}

    public Clickable getRecentRTTime() { return Clickable.getElementBy(recentRTTime, "Recent Transaction Time");}

    public Clickable getCustomerNameUnderRTSection(){
        return  Clickable.getElementBy(customerNameUnderRTSection, "Customer Name Under Recent Transactions");}

    public Clickable getRTpopupCrossIcon() {
        return Clickable.getElementBy(RTpopupCrossIcon, "Cross Icon");}

    public Clickable getCustomerTrends() {
        return Clickable.getElementBy(customerTrends, "Customer Trends");
    }

    public Clickable getPaymentMethodPopularityTitle() {
        return Clickable.getElementBy(pymtmethodPopularityTitle);
    }

    public Clickable getRefreshIcon() {
        return Clickable.getElementBy(refreshIcon, "Refresh Icon next to RT");
    }

    public Clickable getFullListLink() {
        return Clickable.getElementBy(fullListLink, "Full List Link");
    }

    public Clickable getContactSupportLink() {
        return Clickable.getElementBy(contactSupportLink, "Contact Support");
    }

    public Clickable getmyStorescount() {
        return Clickable.getElementBy(myStore, "my store count ");
    }

    public Clickable getStoreCountUnderYourBusiness() {
        return Clickable.getElementBy(storeCountDashboard, "Get Count of store under Your Business");
    }

    public Clickable getListOfStoreNameonPopup() {
        return Clickable.getElementBy(listofStoreNameonPopup, "Store Names under Your Business");
    }

    public Clickable getTotalAmountOfProcessPayment() {
        return Clickable.getElementBy(last30DaysTotalAmount, "total payment under Process Payment");}
    public Clickable getCountOfAllStoreCustomer() {return Clickable.getElementBy(last30DaysCustomerCount, "All Stores Customer Count");}
    public Clickable getTodayPayment() { return Clickable.getElementBy(todayPayment, "Today's payment");}
    public Clickable getMessagePage() { return Clickable.getElementBy(messagePage, "Message Page");}
    public Clickable getStoreName() { return Clickable.getElementBy(storeName, "Store Name");}
    public Clickable getTransactionPopupUnderRT() { return Clickable.getElementBy(transactionPopup, "Transaction popup under RT section");}
    public Clickable getBankGraph() { return Clickable.getElementBy(bankAccountGraph, "bank Graph");}
    public Clickable getPathsofGraph() { return Clickable.getElementBy(paths);}
    public Clickable getGraphContainer() {return Clickable.getElementBy(graphContainer);}
    public Clickable getPaymentNames() { return Clickable.getElementBy(paymentNames);}
    public Clickable getMonthsLabel() { return Clickable.getElementBy(monthsLabel);}
    public Clickable getNewLabel() { return Clickable.getElementBy(newLabel);}
    public Clickable getRepeatingLabel() { return Clickable.getElementBy(repeatingLabel);}
    public Clickable getCustomerCount() { return Clickable.getElementBy(customerCount);}
    public Clickable getCustGraphLine() { return Clickable.getElementBy(custGraphLine);}

    public void HoverToGraph() {
        Actions actions = new Actions(getDriver());
        WebElement hover = getDriver().findElement(custGraphLine);
        WebElement last = getDriver().findElement(lastDEC);

//        actions.moveToElement(hover).moveByOffset(0, -10).clickAndHold().moveByOffset(1, -100).release().perform();
        actions.moveToElement(hover).dragAndDrop(hover,last).build().perform();
    }

}
