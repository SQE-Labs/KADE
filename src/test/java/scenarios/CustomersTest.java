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
        WebdriverWaits.sleep(2000);
        session.getCustomersPage().setCustomerName("Rishabh");
        session.getCustomersPage().doneBtn().click();
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
    }

    @Test(description = "Filtering out using Phone number")
    public void c_04FilterWithPhoneNumber() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        session.getCustomersPage().filterByPhoneNumber("9011017524");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.sleep(2000);
        session.getCustomersPage().filter().click();
        session.getCustomersPage().filterByPhoneNumber(" ");
        session.getCustomersPage().filterByEmail("yonro@yopmail.com");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.sleep(2000);
        session.getCustomersPage().filter().click();
        session.getCustomersPage().filterByPhoneNumber(" ");
        session.getCustomersPage().filterByName("yonro");
        session.getCustomersPage().filterApply().click();
    }

    @Test(description = "Filtering out using Email")
    public void c_05FilterWithEmail() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        session.getCustomersPage().filterByEmail("yonro@yopmail.com");
        session.getCustomersPage().filterApply().click();
    }

    @Test(description = "Filtering out using Name")
    public void c_06FilterWithName() {
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
    }

    @Test(description = "Changing the name of the Customer")
    public void c_07ChangeCustomerName() {
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
    public void c_08OpenCusotmersProfilePage() {
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
    public void c_09TypeAMessage() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().messageIcon().click();
        session.getCustomersPage().typeMessage("Hi");
        session.getCustomersPage().sendButton().click();
        WebdriverWaits.sleep(2000);
        session.getCustomersPage().unsendBtn().click();
        session.getCustomersPage().confirmUnsend().click();
    }

    @Test(description = "Add reward points to the customer")
    public void c_10AddRewardPoints() {
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









}
