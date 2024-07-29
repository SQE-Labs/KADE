package session;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BillPage;
import org.automation.pages.DashBoardPage;
import org.automation.pages.LoginPage;
import org.automation.pages.PaymentsPage;

public class KadeSession extends BaseTest {

    public void KadeSession(){

    }

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
}

