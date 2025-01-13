package org.automation.session;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.*;
import org.automation.pages.popups.*;

public class KadeSession extends BaseTest {

    public static KadeSession session;
    private static KadeUserAccount logggedInUser;

    public static KadeSession login(KadeUserAccount user) {
        logggedInUser = user;
        new LoginPage().performSignIn(user.getUserName(), user.getPassword());

        return new KadeSession();
    }

    public SidePannel getSidePannel() {
        return new SidePannel();
    }

    public BillPage getBillPage() {
        return new BillPage();
    }

    public GiftCardDashboardPage getGiftCardDashboardPage() {
        return new GiftCardDashboardPage();
    }

    public PaymentsPage getPaymentsPage() {
        return new PaymentsPage();
    }

    public MyStorePage getMyStorePage() {
        return new MyStorePage();
    }

    public TransactionsPage getTransactionsPage() {
        return new TransactionsPage();
    }

    public SearchPage getSearchPage() { return new SearchPage(); }


    public LoginPage getLoginPage() {
        return new LoginPage();
    }

    public NotificationsPage getNotificationPage() {
        return new NotificationsPage();
    }

    public QrCodeDashboardPage getQRCodeDashboardPage() {
        return new QrCodeDashboardPage();
    }

    public NewChargePopup getNewChargePopup() {
        return new NewChargePopup();
    }

    public SendTheReceiptPopup getSendTheReceiptPopup() {
        return new SendTheReceiptPopup();
    }

    public CustomersPage getCustomersPage() { return new CustomersPage();}

    public CreateNewAccountPage getCreateAccountPage() {
        return new CreateNewAccountPage();
    }

    public BasicInformationPage getBasicInformationPage() {
        return new BasicInformationPage();
    }
    public BasicInfoPage getBasicInfoPage() {return new BasicInfoPage();}

    public SecurityAndPassword getSecurityAndPassword() {return new SecurityAndPassword();}
    public SecurityAndPasswordPage getSecurityAndPasswordPage() {
        return new SecurityAndPasswordPage();
    }

    public SignInPopup getSignInPopup(){
        return  new SignInPopup();
    }

    public NewAccountPopup getNewAccountPopup(){
        return  new NewAccountPopup();
    }
    public GiftCardConfigurationPopup getGiftCardConfigurationPopup(){return new GiftCardConfigurationPopup();}
    public AttentionRTPopup getAttentionRTPopup() {return new AttentionRTPopup();}
    public AdminPage getAdminPage() {return new AdminPage();}

    }






