import java.util.ArrayList;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.MyStorePage;
import org.automation.pageObjects.newBusinessPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest {

    LoginPage login = new LoginPage();
    DashBoardPage dashboard = new DashBoardPage();
    MyStorePage myStore = new MyStorePage();
//    newBusinessPage newBusiness = new newBusinessPage();

    @BeforeMethod
    public void navigateToDashboard() {
        login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
    }

    @AfterMethod
    public void logout() {
        dashboard.signOut();
    }

    @Test(enabled = true, description = "Verifying deletion of Store when Stripe Account is not Configured")
    public void tc01_DeletionOfStore() {
        dashboard.clickOnMyStores();

        myStore.clickRegisterNewBusinessBtn();
        myStore.clickSkipStripeAccountBtn();
        WebdriverWaits.sleep(3000);
        myStore.clickSkipStripeAccountPopUpBtn();
        WebdriverWaits.sleep(10000);
        myStore.clickDeleteStoreBtn();
        WebdriverWaits.sleep(3000);
        myStore.clickDeleteStoreIcon();

    }
}
