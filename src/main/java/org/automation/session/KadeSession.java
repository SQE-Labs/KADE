package org.automation.session;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.*;

public class KadeSession extends BaseTest {

    private static KadeUserAccount logggedInUser;

    public static KadeSession login(KadeUserAccount user) {
        logggedInUser = user;
        new LoginPage().performSignIn(user.getUserName(), user.getPassword());
        return new KadeSession();
    }

    public DashBoardPage getDashBoardPage(){
        return new DashBoardPage();
    }

    public BillPage getBillPage(){
        return new BillPage();
    }

    public PaymentsPage getPaymentsPage(){
        return new PaymentsPage();
    }

    public MyStorePage getMyStorePage(){
        return new MyStorePage();
    }

    public TransactionsPage getTransactionsPage(){return  new TransactionsPage();}


    public LoginPage getLoginPage() {
        return new LoginPage();
    }
}

