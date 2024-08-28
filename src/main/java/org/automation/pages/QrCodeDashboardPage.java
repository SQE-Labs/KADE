package org.automation.pages;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QrCodeDashboardPage extends BasePage {
    // Locators
    By generateNewQrButton = By.xpath("//button[text()='Generate a new QR code']");
    By flexibleAmountType = By.xpath("//button/span[text()='Flexible amount']");
    By fixedAmountType = By.xpath("//button/span[text()='Fixed amount']");
    By ticketsEvents = By.xpath("//button/span[text()='Tickets/Events']");
    By donationsType = By.xpath("//button/span[text()='Donations']");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    By directPayQrButton= By.xpath("//div[text()=' Direct Pay']");
    By qrCodeImage =By.xpath("//img[@class='img-fluid p-2 max-15c']");
    By loader = By.xpath("//img[@class='img-fluid p-2  max-15c']");
    By copyQrButton= By.xpath("//i[@class='fal fa-copy']");
    By downloadQrButton = By.xpath("//i[@class=\"far fa-cloud-download-alt\"]");
    By  viewQrButton = By.xpath("//a[@class=\"btn btn-link fs-p25\"]");

    // Actions
    public Clickable getStoresDropdown() {
        return Clickable.getElementBy(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public Clickable getContinueButton() {
        return Clickable.getElementBy(continueBtn, "Continue Button");
    }

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
