package scenarios;
import java.awt.*;
import java.awt.event.KeyEvent;
import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.data.StoreAccount;
import org.automation.pages.MyStorePage;
import org.automation.pages.PaymentsPage;
import org.automation.pages.QrCodeDashboardPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.RandomGenerator;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class QRTest extends BaseTest {
  public static String storeName = "QrDashBoard"+ RandomGenerator.requiredString(6);
    public  static String phoneNumber = RandomGenerator.requiredNumber(10);

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    KadeSession session = new KadeSession();
    @Test(priority = 0, enabled=true, description = "SC_02 Verify creation of Store with Stripe Payment Account")
    public void sc02_CreationOfStoreWithStripeAccount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);

        //Step 1: Click on 'My Stores' Tab
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        MyStorePage myStore = session.getMyStorePage();

        //Step 2: Click on 'Register New Business' Button
        myStore.getRegisterNewBusinessButton().click();

        if(myStore.getStoreLogo().isDisplayed()) {
            myStore.getDeleteStoreButton().clickByMouse();
            myStore.getDeleteStoreIcon().clickByMouse();
            session.getSidePannel().getMyStoresTab().click();
            myStore.getRegisterNewBusinessButton().click();
        }
        //Step 3: Click on 'Stripe Account' Button
        myStore.getStipeAccountButton().clickByMouse();

        //Verifying the 'Connect To Stripe' PopUp Title
        Assertions.assertEquals(myStore.getConnectStripePopUpTitle().getText(), "Connect to stripe");

        //Step 4: Click on 'Test Stripe Account' Button
        myStore.getTestStripeAccountButton().click();

        //Edit Store name
        myStore.getEditStoreButton().click();
        myStore.getStoreNameField().setText(storeName);
        myStore.getPhoneField().setText(phoneNumber);
        myStore.getSaveButton().clickByMouse();

        //Step 5: Click on 'Bank Transfer' toggle button
        myStore.getBankTransferToggleButton().click();

        //Step 6: Click on 'Continue' Button
        myStore.getContinueButton().clickByMouse();

        //Step 7: Click on 'Skip For Now' Button
        myStore.getSkipForNowButton().clickByMouse();

        //Step 8: Click on 'Continue' Button
        myStore.getContinueButton().clickByMouse();

        //verifying the default Values of the Store
        String defaultLocationDescription = "Dix Hills";
        String defaultStoreAddress = "8 Glover Dr, Dix Hills, NY 11746, USA";
        String defaultCurrency = "USD";
        String defaultTaxRate = "0.000%";
        Assertions.assertEquals(myStore.getAddedStoreName().getText(), storeName);
        Assertions.assertEquals(myStore.getAddedLocationDescription().getText(), defaultLocationDescription);
        Assertions.assertEquals(myStore.getAddedStoreAddress().getText(), defaultStoreAddress);
        Assertions.assertEquals(myStore.getAddedStorePhone().getText().replaceAll("[+()\\s-]", "").substring(1,11), phoneNumber);
        Assertions.assertEquals(myStore.getAddedCurrencyOfStore().getText(), defaultCurrency);
        Assertions.assertEquals(myStore.getAddedTaxRate().getText(), defaultTaxRate);
    }

    @Test(priority = 1, enabled=true, description = "TC_01 Verify that user get directed to 'QR Code Dashboard' page, after clicking on 'QR Code Dashboard' tab under 'Manage Business' section, on Left Panel.")
    public void TC_01_VerifyQRDasBoardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getQrDashboardText().getText(),"QR Code Dashboard");
    }
    @Test(priority = 2, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_02_verifySelectedStore(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getStoreName().getText(),storeName);
        session.getSidePannel().getSignOutButton().click();




    }
    @Test(priority = 3, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_02_verifyDirectPayPopup(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        session.getQRCodeDashboardPage().clickDirectPay().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getDirectPayTitle().getText(),"QR code view");
        session.getQRCodeDashboardPage().clickDirectPayCloseBtn().click();
        session.getSidePannel().getSignOutButton().click();


    }
    @Test(priority = 4, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_02_verifyDirectPayCopyBtn() throws IOException, UnsupportedFlavorException, InterruptedException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        session.getQRCodeDashboardPage().clickDirectPay().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getDirectPayTitle().getText(),"QR code view");
        Thread.sleep(1000);

        session.getQRCodeDashboardPage().clickDirectPayCopyBtn().click();
        String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println("Clipboard Content: " + clipboardText);
        session.getQRCodeDashboardPage().clickDirectPayCloseBtn().click();
        session.getSidePannel().getSignOutButton().click();
        KadeSession.login(KadeUserAccount.Customer);

        wait.until(ExpectedConditions.urlToBe("https://sibtestenv.azurewebsites.net/Stores/BillsHistory/3334"));
        getDriver().get("https://sibtestenv.azurewebsites.net/Stores/BillsHistory/3334");
        getDriver().get(clipboardText);
        Assertions.assertEquals( session.getQRCodeDashboardPage().getStorePayName().getText(),"QrDashBoardAfBGNi");

    }



    @Test(priority = 5, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_02_verifyGenerateNewQrBtn(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getStoreName().getText(),storeName);
        session.getQRCodeDashboardPage().clickNewQrBtn().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getNewQrText().getText(),"Select QR code type");
        session.getSidePannel().getSignOutButton().click();




    }
    @Test(priority = 5, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_06_verifyFlexibleAmtBtn(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getStoreName().getText(),storeName);
        session.getQRCodeDashboardPage().clickNewQrBtn().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getNewQrText().getText(),"Select QR code type");
        session.getQRCodeDashboardPage().clickFlexibleAmountbtn().click();
        //Assertions.assertEquals(session.getQRCodeDashboardPage().getEditPaymentLinkHeader().getText(),"Edit Payment link");
        session.getSidePannel().getSignOutButton().click();

    }
    @Test(priority = 5, enabled=true, description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void TC_06_verifyEditPaymentForm(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        session.getQRCodeDashboardPage().getStoresDropdown().click();
        session.getQRCodeDashboardPage().selectStore().setText(storeName);

        // Delay to allow time to switch focus if needed
        robot.delay(2000);

        // Simulate pressing the Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        session.getQRCodeDashboardPage().getContinueButton().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getStoreName().getText(),storeName);
        session.getQRCodeDashboardPage().clickNewQrBtn().click();
        Assertions.assertEquals(session.getQRCodeDashboardPage().getNewQrText().getText(),"Select QR code type");
        session.getQRCodeDashboardPage().clickFlexibleAmountbtn().click();

        session.getSidePannel().getSignOutButton().click();

    }





}

