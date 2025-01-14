package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomersTest extends BaseTest {

    @Test(description = "Verify that Store's customers page opens up displaying all the options")
    public void c_01storeCustomersPage() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Assert if all the necessary elements are visible
        Assertions.assertTrue(session.getCustomersPage().nameAddress().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().findAddCustomer().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().filter().isDisplayed());
    }

    @DataProvider(name = "phoneNumberData")
    public Object[][] phoneNumberData() {
        return new Object[][]{
                {"9011017524", null}, // Valid phone number
                {"901101752", "Invalid phone number"}, // Invalid phone number
                {"", "This field is required."}, // Blank phone number
                {"12345678901234567890123", "Please enter no more than 22 characters."} // More than 22 characters
        };
    }

    @Test(description = "Adding a new customer with Phone number", dataProvider = "phoneNumberData")
    public void c_02addCustomerWithPhoneNumber(String phoneNumber, String expectedValidationMessage) {
        // Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();


        // Open Customer popup by clicking 'Find or add a new Customer'
        session.getCustomersPage().findAddCustomer().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='me-1']")));

        // Enter phone number and check for validation
        session.getCustomersPage().getPhoneField().setText(phoneNumber);
        session.getCustomersPage().goPhoneNumber().click();

        if (expectedValidationMessage != null) {
            Assertions.assertTrue(session.getCustomersPage().getPhoneValidation().isDisplayed());
            String actualValidationMessage = session.getCustomersPage().getPhoneField().getToolTipMessage();
            Assertions.assertEquals(actualValidationMessage, expectedValidationMessage);
        } else {
            // No validation expected for valid phone number
            //Assertions.assertFalse(session.getCustomersPage().getPhoneValidation().isDisplayed());
            Assertions.assertTrue(session.getCustomersPage().findAddCustomer().isDisplayed());
        }

        session.getCustomersPage().getCustPopupCloseBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().customerPopupClose, 10);
    }



    @Test(description = "Adding a new customer with Email")
    public void c_03AddCustomerWithEmail() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().findAddCustomer().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='me-1']")));

        //Enter valid email address in the 'Email' field.
        session.getCustomersPage().setEmailId("yonro@yopmail.com");
        session.getCustomersPage().goEmail().click();
        //session.getCustomersPage().doneBtn().click(); -- Done button is displayed once when the customer is being added for the first time.
        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().emailGoBtn,10);

        //Enter invalid email address in the 'Email' field
        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getEmailField().setText("yonro");
        session.getCustomersPage().goEmail().click();
        Assertions.assertTrue(session.getCustomersPage().getEmailValidation().isDisplayed());
        String emailTooltip = session.getCustomersPage().getEmailField().getToolTipMessage();
        Assertions.assertEquals(emailTooltip,"Please enter a valid email address.");
        session.getCustomersPage().getCustPopupCloseBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().customerPopupClose,10);

        //Leave 'Email' field blank
        session.getCustomersPage().findAddCustomer().click();
        session.getCustomersPage().getEmailField().setText(" ");
        session.getCustomersPage().goEmail().click();
        Assertions.assertTrue(session.getCustomersPage().getEmailValidation().isDisplayed());
        String emailTooltip2 = session.getCustomersPage().getEmailField().getToolTipMessage();
        Assertions.assertEquals(emailTooltip2,"This field is required.");
        session.getCustomersPage().getCustPopupCloseBtn().click();

    }

    @Test(description = "Creating a bill and searching for the customer on Customers page")
    public void c_04CreateBillAndSearch() {
        //Login
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Create a new bill
        session.getCustomersPage().getNewBill().click();
        session.getCustomersPage().billstoreSelection();
        session.getCustomersPage().continuebtn().click();
        session.getCustomersPage().newBillBtn().click();
        WebdriverWaits.waitForElementVisible(session.getCustomersPage().amountInput,10);
        Assertions.assertTrue(session.getCustomersPage().amountText().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().getAmount().isDisplayed());
        session.getCustomersPage().getAmount().setText("10000");
        session.getCustomersPage().selectCustoemr().clickByMouse();
        session.getCustomersPage().billByPhone().setText("12312312313");
        session.getCustomersPage().billGoBtn().click();
        WebdriverWaits.waitForElementVisible( session.getCustomersPage().billSendBtn,20);
        session.getCustomersPage().billSendBtn().clickByMouse();

        session.getCustomersPage().closePopup().clickIfExist(true,3);

        //Navigate to 'Customers' page
        session.getSidePannel().expandManageBusinessAccordionBttn().clickbyJS();
        session.getSidePannel().getCustomersTab().clickbyJS();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Search for the name of the customer after creating a bill
        session.getCustomersPage().findAddCustomer().click();
        Assertions.assertTrue(session.getCustomersPage().customerDisplayed().isDisplayed());
        session.getCustomersPage().getSearch().setText("Santa");
        session.getCustomersPage().searchBtn().click();
        Assertions.assertTrue(session.getCustomersPage().customerDisplayed().isDisplayed());
    }

    @Test(description = "Filtering out using Phone number")
    public void c_05FilterWithPhoneNumber() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Open 'Filter' pop up
        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        //Filter by valid name
        session.getCustomersPage().filterByPhnNumber().setText("9011017524");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().filterApplyBtn,10);
        session.getCustomersPage().filter().click();
        //Filter by invalid number
        session.getCustomersPage().filterByPhnNumber().setText("1231");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String filterPhnNumberTooltip = session.getCustomersPage().invalidFilterByPhnNumber().getToolTipMessage();
        Assertions.assertEquals(filterPhnNumberTooltip,"Invalid phone number");
        session.getCustomersPage().closeFilterBtn().click();


        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().closefilter,10);
        session.getCustomersPage().filter().click();
        //Check if the field accepts more than 22 characters
        session.getCustomersPage().invalidFilterByPhnNumber().setText("12345678901234567890123");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String filterPhoneNumberTooltip = session.getCustomersPage().invalidFilterByPhnNumber().getToolTipMessage();
        Assertions.assertEquals(filterPhoneNumberTooltip,"Please enter no more than 22 characters.");
        session.getCustomersPage().invalidFilterByPhnNumber().setText(" ");
        session.getCustomersPage().filterApply().click();

        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().filterApplyBtn,10);
        session.getCustomersPage().filter().click();
        //Check for a valid phone number but of a non-existing customer
        session.getCustomersPage().filterByPhnNumber().setText("1232233223");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().getNoResult().isDisplayed());

    }

    @Test(description = "Filtering out using Email")
    public void c_06FilterWithEmail() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        //Filter by valid and existing customer's email address
        session.getCustomersPage().filterByEmailId().setText("yonro@yopmail.com");
        session.getCustomersPage().filterApply().click();
        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().filterApplyBtn,10);

        session.getCustomersPage().filter().click();
        WebdriverWaits.waitForElementVisible(session.getCustomersPage().filterEmail,10);
        //Filter by invalid email address
        session.getCustomersPage().filterByEmailId().setText("yonro");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().alertValidation().isDisplayed());
        String tooltipEmailField = session.getCustomersPage().invalidFilterByEmailId().getToolTipMessage();
        Assertions.assertEquals(tooltipEmailField,"Please enter a valid email address.");

    }

    @Test(description = "Filtering out using Name")
    public void c_07FilterWithName() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        session.getCustomersPage().filter().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='offcanvas-title']")));
        //Filter by the name of an existing customer
        session.getCustomersPage().filterByName("yonro");
        session.getCustomersPage().filterApply().click();
        WebdriverWaits.waitForElementInVisible(session.getCustomersPage().filterApplyBtn,10);

        session.getCustomersPage().filter().click();
        //Filter by an non-existing customer's name
        session.getCustomersPage().filterByName("jon123");
        session.getCustomersPage().filterApply().click();
        Assertions.assertTrue(session.getCustomersPage().getNoResult().isDisplayed());

    }

    @Test(description = "Select customer from customer popup via filters")
    public void c_08selectCustomerviaFilter() {
        //Login and navigate to Customers page.
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
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Change the name of the customer
        session.getCustomersPage().chngeName().click();
        session.getCustomersPage().changeCustomerName("Yonro");
        session.getCustomersPage().saveBtn().click();
    }



    @Test(description = "Open customer's profile page")
    public void c_10OpenCustomersProfilePage() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Open customer's profile page
        session.getCustomersPage().viewProfile().click();
        Assertions.assertTrue(session.getCustomersPage().profileHeading().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().messageIcon().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().rewardIcon().isDisplayed());
        Assertions.assertTrue(session.getCustomersPage().storeName().isDisplayed());
    }

    @Test(description = "Type and Unsend message to the customer")
    public void c_11OpenMessagePg() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Open message page
        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().messageIcon().click();
        Assertions.assertTrue(session.getCustomersPage().getMsgPgHeader().isDisplayed());
    }

    @Test(description = "Add reward points to the customer")
    public void c_12AddRewardPoints() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Create reward points memo
        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().rewardIcon().click();
        session.getCustomersPage().addRewardPoints().click();
        session.getCustomersPage().memoInput("Memo");
        session.getCustomersPage().rewardpoints("100");
        session.getCustomersPage().submitRewardsPoints().click();
    }

    @Test(enabled = false, description = "Add payment method")
    public void c_13AddPaymentMethod() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Adding Payment method for a customer
        session.getCustomersPage().addPaymentMethod().click();
        session.getCustomersPage().permissionCheckbox().click();
        session.getCustomersPage().permissionContinueBtn().click();

        WebdriverWaits.waitForElementVisible(session.getCustomersPage().addCardNumberField,10);
        //Assertions.assertTrue(session.getCustomersPage().addingCard().isDisplayed());
        session.getCustomersPage().seitchToFrame();
        session.getCustomersPage().saveNewByCreditCard();

    }

    @Test(description = "Create Gift Card")
    public void c_14CreateGiftCard() {
        //Login and navigate to Customers page.
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getCustomersTab().click();
        session.getCustomersPage().storeSelection();
        session.getCustomersPage().continuebtn().click();

        //Creating a gift card for a customer
        session.getCustomersPage().viewProfile().click();
        session.getCustomersPage().addGiftCardIcon().click();
        session.getCustomersPage().getGiftCardAmt().setText("1000");
        session.getCustomersPage().createGiftCardBtn().click();
    }









}
