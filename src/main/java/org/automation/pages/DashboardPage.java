package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BaseTest;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

public class DashboardPage extends BaseTest {
    By yourBusinessTitle = By.cssSelector("div.card-body h5:nth-child(1)");
    By customerTitle = By.cssSelector("div.card-body h5:nth-child(2)");
    By messageTitle = By.cssSelector("div[class='row mb-1'] h5[class='card-title']");
    By processPaymentTitle =By.xpath("//h5[text()='Processed Payments']");
    By todayPaymentTitle = By.xpath("//h5[text()='Today’s Payments']");
    By recentTransactionsTitle =By.cssSelector("a +h5.card-title.mb-0");
    By customerTrends =By.xpath("//h5[text()='Customer Trends']");
    By pymtmethodPopularityTitle =By.xpath("//h5[text()='Payment Methods Popularity']");
    By refreshIcon = By.cssSelector(".card-title.mb-0 .btn >i");
    By fullListLink = By.cssSelector("a.float-end");
    By contactSupportLink =By.cssSelector(".card-title +h6 a");









    public Clickable getYourBusinessTitle() {
        return Clickable.getElementBy(yourBusinessTitle,"Your Bussiness Title");
    }
    public Clickable getCustomerTitle() {
        return Clickable.getElementBy(customerTitle,"Customer Title");
    }
    public Clickable getMessageTitle() {return Clickable.getElementBy(messageTitle, "Message Label");}
    public Clickable getProcessPaymentTitle() {return Clickable.getElementBy(processPaymentTitle, "Process Payment");}
    public Clickable getTodayPaymentTitle() {return Clickable.getElementBy(todayPaymentTitle,"Today's payment");}
    public Clickable getRecentTransactionsTitle() {return Clickable.getElementBy(recentTransactionsTitle,"Recent Transactions");}
    public Clickable getCustomerTrends() {return Clickable.getElementBy(customerTrends,"Customer Trends");}
    public Clickable getPaymentMethodPopularityTitle() {return Clickable.getElementBy(pymtmethodPopularityTitle);}
    public Clickable getRefreshIcon() {return Clickable.getElementBy(refreshIcon,"Refresh Icon next to RT");}
    public Clickable getFullListLink() {return Clickable.getElementBy(fullListLink,"Full List Link");}
    public Clickable getContactSupportLink() {return Clickable.getElementBy(contactSupportLink, "Contact Support");}



}
