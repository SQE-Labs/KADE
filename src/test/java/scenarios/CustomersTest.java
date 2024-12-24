package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomersTest extends BaseTest {

    @Test(description = "Verify that Store's customers page opens up displaying all the options")
    public void c_01storeCustomersPage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        Assertions.assertTrue(session.getCustomersPage().nameAddress().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().findAddCustomer().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().filter().isDisplayed());
    }

    @Test(description = "Adding a new customer with Phone number")
    public void c_02addCustomerWithPhoneNumber() {

        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().findAddCustomer().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='me-1']")));
        System.out.println(getDriver().findElement(By.xpath("//span[@class='me-1']")).getText());
        session.getCustomersPage().setPhoneNumber("9011017524");
        session.getCustomersPage().goPhoneNumber().click();
//        WebdriverWaits.sleep(2000);
//        session.getCustomersPage().setCustomerName("Rishabh");
//        session.getCustomersPage().doneBtn().click();

        session.getCustomersPage().findAddCustomer().click();
        WebDriverWait waitt = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        waitt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='me-1']")));
        session.getCustomersPage().getPhoneField().setText("90110");
        session.getCustomersPage().goPhoneNumber().click();
        Assertions.assertTrue(session.getCustomersPage().getPhoneValidation().isDisplayed());
        String tooltipMessage = session.getCustomersPage().getPhoneField().getToolTipMessage();
        Assertions.assertEquals(tooltipMessage,"Invalid phone number");
        session.getCustomersPage().getCustPopupCloseBtn().click();

        WebdriverWaits.waitForElementVisible(session.getCustomersPage().findAddCustomer,10);
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getPhoneField().setText(" ");
        session.getCustomersPage().goPhoneNumber().click();
        Assertions.assertTrue(session.getCustomersPage().getPhoneValidation().isDisplayed());
        String tooltipMsg = session.getCustomersPage().getPhoneField().getToolTipMessage();
        Assertions.assertEquals(tooltipMsg,"This field is required.");
        session.getCustomersPage().getCustPopupCloseBtn().click();

        WebdriverWaits.waitForElementVisible(session.getCustomersPage().findAddCustomer,10);
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getPhoneField().setText("12345678901234567890123");
        session.getCustomersPage().goPhoneNumber().click();
        Assertions.assertTrue(session.getCustomersPage().getPhoneValidation().isDisplayed());
        String phnNumbertTt3 = session.getCustomersPage().getPhoneField().getToolTipMessage();
        Assertions.assertEquals(phnNumbertTt3,"Please enter no more than 22 characters.");
        session.getCustomersPage().getCustPopupCloseBtn().click();

    }

    @Test(description = "Adding a new customer with Email")
    public void c_03AddCustomerWithEmail() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().findAddCustomer().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='me-1']")));
        session.getCustomersPage().setEmailId("yonro@yopmail.com");
        session.getCustomersPage().goEmail().click();
     //   session.getCustomersPage().doneBtn().click();
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getEmailField().setText("yonro");
        session.getCustomersPage().goEmail().click();
        Assertions.assertTrue(session.getCustomersPage().getEmailValidation().isDisplayed());
        String emailTooltip = session.getCustomersPage().getEmailField().getToolTipMessage();
        Assertions.assertEquals(emailTooltip,"Please enter a valid email address.");
        session.getCustomersPage().getCustPopupCloseBtn().click();
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getEmailField().setText(" ");
        session.getCustomersPage().goEmail().click();
        Assertions.assertTrue(session.getCustomersPage().getEmailValidation().isDisplayed());
        String emailTooltip2 = session.getCustomersPage().getEmailField().getToolTipMessage();
        Assertions.assertEquals(emailTooltip2,"This field is required.");
        session.getCustomersPage().getCustPopupCloseBtn().click();

    }

    @Test(enabled = false, description = "Creating a bill and searching for the customer on Customers page")
    public void c_04CreateBillandSearch() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getCustomersPage().getNewBill().click();
        session.getCustomersPage().billstoreSelection();
        session.getCustomersPage().continuebtn().click();
        session.getCustomersPage().newBillBtn().click();
        WebdriverWaits.sleep(4000);
        session.getCustomersPage().getAmount().setText("10000");
        session.getCustomersPage().selectCustoemr().click();
        session.getCustomersPage().billByPhone().setText("9011017524");
        session.getCustomersPage().billGoBtn().click();
        WebdriverWaits.waitForElementVisible( session.getCustomersPage().billSendBtn,20);
        session.getCustomersPage().billSendBtn().click();

        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().findAddCustomer().click();
        Assertions.assertTrue(session.getCustomersPage().customerDisplayed().isDisplayed());
        session.getCustomersPage().getSearch().setText("Rishabh");
        session.getCustomersPage().searchBtn().click();
        Assertions.assertTrue(session.getCustomersPage().customerDisplayed().isDisplayed());
    }

    @Test(description = "Filtering out using Phone number")
    public void c_05FilterWithPhoneNumber() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        session.getCustomersPage().filterByPhnNumber().setText("9011017524");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.sleep(2000);
        session.getCustomersPage().filter().click();
        session.getCustomersPage().filterByPhnNumber().setText("1231");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String flterPhnNumberTooltip = session.getCustomersPage().invalidFilterByPhnNumber().getToolTipMessage();
        Assertions.assertEquals(flterPhnNumberTooltip,"Invalid phone number");
        session.getCustomersPage().closeFilterBtn().click();


        WebdriverWaits.sleep(2000);
        session.getCustomersPage().filter().click();
        session.getCustomersPage().invalidFilterByPhnNumber().setText("12345678901234567890123");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String filterPhoneNumberTooltip = session.getCustomersPage().invalidFilterByPhnNumber().getToolTipMessage();
        Assertions.assertEquals(filterPhoneNumberTooltip,"Please enter no more than 22 characters.");
        session.getCustomersPage().invalidFilterByPhnNumber().setText(" ");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.sleep(2000);
        session.getCustomersPage().filter().click();
        session.getCustomersPage().filterByPhnNumber().setText("1232233223");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().getNoResult().isDisplayed());

    }

    @Test(description = "Filtering out using Email")
    public void c_06FilterWithEmail() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        session.getCustomersPage().filterByEmailId().setText("yonro@yopmail.com");
        session.getCustomersPage().filterApply().click();
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().filter().click();
        WebdriverWaits.waitForElementVisible(session.getCustomersPage().filterEmail,10);
        session.getCustomersPage().filterByEmailId().setText("yonro");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String tooltipEmailField = session.getCustomersPage().invalidFilterByEmailId().getToolTipMessage();
        Assertions.assertEquals(tooltipEmailField,"Please enter a valid email address.");

    }

    @Test(description = "Filtering out using Name")
    public void c_07FilterWithName() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        session.getCustomersPage().filterByName("yonro");
        session.getCustomersPage().filterApply().click();
        WebdriverWaits.sleep(2000);

        session.getCustomersPage().filter().click();
        session.getCustomersPage().filterByName("jon");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().getNoResult().isDisplayed());

    }

    @Test(description = "Select customer from customer popup via filters")
    public void c_08selectCustomerviaFilter() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebdriverWaits.waitForElementVisible(session.getCustomersPage().selectCustomerinFilter,10);
        session.getCustomersPage().selectCustomer().click();
        session.getCustomersPage().customerSelection().click();
        Assertions.assertTrue(session.getCustomersPage().customerDisplayed().isDisplayed());
    }

    @Test(description = "Changing the name of the Customer")
    public void c_09ChangeCustomerName() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().chngeName().click();
        session.getCustomersPage().changeCustomerName("Yonro");
        session.getCustomersPage().saveBtn().click();
    }



    @Test(description = "Open customer's profile page")
    public void c_10OpenCusotmersProfilePage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().viewProfile().click();
        Assertions.assertTrue(session.getCustomersPage().profileHeading().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().messageIcon().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().rewardIcon().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().storeName().isDisplayed());
    }

    @Test(description = "Type and Unsend message to the customer")
    public void c_11TypeAMessage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().messageIcon().click();
        Assertions.assertTrue(session.getCustomersPage().getMsgPgHeader().isDisplayed());
//        session.getCustomersPage().typeMessage("Hi");
//        session.getCustomersPage().sendButton().click();
//        WebdriverWaits.sleep(2000);
//        session.getCustomersPage().unsendBtn().click();
//        session.getCustomersPage().confirmUnsend().click();
    }

    @Test(description = "Add reward points to the customer")
    public void c_12AddRewardPoints() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().rewardIcon().click();
        session.getCustomersPage().addRewardPoints().click();
        session.getCustomersPage().memoInput("Memo");
        session.getCustomersPage().rewardpoints("100");
        session.getCustomersPage().submitRewardsPoints().click();
    }

    @Test(description = "Add payment method")
    public void c_13AddPaymentMethod() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().addPaymentMethod().click();
        session.getCustomersPage().permissionCheckbox().click();
        session.getCustomersPage().permissionContinueBtn().click();

        WebdriverWaits.sleep(5000);
        //Assertions.assertTrue(session.getCustomersPage().addingCard().isDisplayed());
        session.getCustomersPage().seitchToFrame();
        session.getCustomersPage().saveNewByCreditCard();

    }









}
