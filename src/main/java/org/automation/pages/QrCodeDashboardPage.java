package org.automation.pages;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QrCodeDashboardPage extends BasePage {

    By qrDashBoardText = By.cssSelector(".header-title.mb-0");
    By storeDropDown = By.cssSelector("input[type=\"search\"].select2-search__field");
    By continueBtn = By.cssSelector("button[type=\"submit\"].btn.btn-primary");
    By storeName= By.cssSelector("h3.text-truncate");
    By directPay= By.cssSelector(".w-100.position-relative.p-2.rounded.shadow-sm.m-2.d-flex.flex-column.justify-content-between.align-content-center\n");
    By generateNewQrButton = By.xpath("//button[text()='Generate a new QR code']");
    By flexibleAmountType = By.xpath("//button/span[text()='Flexible amount']");
    By fixedAmountType = By.xpath("//button/span[text()='Fixed amount']");
    By ticketsEvents = By.xpath("//button/span[text()='Tickets/Events']");
    By donationsType = By.xpath("//button/span[text()='Donations']");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By directPayQrButton= By.xpath("//div[text()=' Direct Pay']");
    By qrCodeImage =By.xpath("//img[@class='img-fluid p-2 max-15c']");
    By loader = By.xpath("//img[@class='img-fluid p-2  max-15c']");
    By copyQrButton= By.xpath("//i[@class='fal fa-copy']");
    By downloadQrButton = By.xpath("//i[@class=\"far fa-cloud-download-alt\"]");
    By  viewQrButton = By.xpath("//a[@class=\"btn btn-link fs-p25\"]");

    // Actions

    public Clickable getQrDashboardText() {WebdriverWaits.waitForElementUntilVisible(qrDashBoardText, 100);return Clickable.getElementBy(qrDashBoardText);}
    public Clickable getStoresDropdown() {WebdriverWaits.waitForElementUntilVisible(storesCombobox, 100);return Clickable.getElementBy(storesCombobox);}
    public Editable selectStore(){WebdriverWaits.waitForElementUntilVisible(storeDropDown, 100); return Editable.getElementBy(storeDropDown);}
    public Clickable getContinueButton() {WebdriverWaits.waitForElementUntilVisible(continueBtn, 100);return Clickable.getElementBy(continueBtn, "Continue Button");}
    public Clickable getStoreName() {WebdriverWaits.waitForElementUntilVisible(storeName, 100); return Clickable.getElementBy(storeName);}
    public  Clickable clickDirectPay(){WebdriverWaits.waitForElementUntilVisible(directPay, 100); return Clickable.getElementBy(directPay);}

    public Clickable getDirectPayQR() {
        return Clickable.getElementBy(directPayQrButton,"Direct Pay Button");
    }

    public Clickable getQRCodeImage() {
        WebdriverWaits.waitForElementInVisible(loader,10);
        return Clickable.getElementBy(qrCodeImage);
    }

    public String getQrURL(String QrCodeURL){
        try {
            URL url = new URL(QrCodeURL);
            BufferedImage bi = ImageIO.read(url);
            LuminanceSource ls = new BufferedImageLuminanceSource(bi);
            BinaryBitmap bbm = new BinaryBitmap(new HybridBinarizer((ls)));
            Result result = new MultiFormatReader().decode(bbm);
            String decodedURL = result.getText();
            return decodedURL;
        }
        catch (Exception e){
            System.out.println("Qr code not found");
            return null;
        }
    }

    public void navigateToQrUrl(String qrCodeImageUrl){
       String url = getQrURL(qrCodeImageUrl);
        navigateToUrl(url);
    }

    public Clickable getCopyQrButton() {
        return Clickable.getElementBy(copyQrButton,"Copy Button");
    }

    public Clickable getDownloadQrButton() {
        return Clickable.getElementBy(downloadQrButton,"Download qr Button");
    }

    public Clickable getViewQrButton() {
        return Clickable.getElementBy(viewQrButton,"View qr Button");

    }
}
