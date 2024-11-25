package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.data.StoreAccount;
import org.automation.pages.PaymentsPage;
import org.automation.pages.QrCodeDashboardPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.testng.annotations.Test;

public class QRTest extends BaseTest {

    @Test(description = "Verify that customer is able to directly pay to the store, after scanning the 'Direct Pay' QR Code.")
    public void directPayByQr(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        WebdriverWaits.sleep(5000);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getQrCodeDashboardButton().click();
        QrCodeDashboardPage qr = session.getQRCodeDashboardPage();
        PaymentsPage payment = session.getPaymentsPage();

        qr.getStoresDropdown().click();
        qr.selectStore(StoreAccount.AutomationQRCode);
        qr.getContinueButton().click();
        qr.getDirectPayQR().clickByMouse();
        WebdriverWaits.sleep(5000);
        Assertions.assertTrue(qr.getCopyQrButton().isDisplayed());
        Assertions.assertTrue(qr.getDownloadQrButton().isDisplayed());
        Assertions.assertTrue(qr.getViewQrButton().isDisplayed());
        String QrCodeImageURL=qr.getQRCodeImage().getAttribute("src");
        qr.navigateToQrUrl(QrCodeImageURL);

        //Enter Amount and do payment
        payment.getPayNowButton().click();
        payment.getAmountTextbox().setText("1000");
        payment.getUpdateAmountToPayButton().click();
        payment.getChangePaymentMethodButton().clickbyJS();
        WebdriverWaits.sleep(2000);
        payment.getSavedCreditCard().click();
        payment.swipeToPay();
        payment.getBlueCloseButton().clickbyJS();
    }

}
