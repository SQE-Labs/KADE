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
    By directPayTitle= By.cssSelector("h5.modal-title");
    By directPayCloseBtn = By.cssSelector("button.btn-close[type=\"button\"][data-bs-dismiss=\"modal\"]\n");
    By qrImage = By.cssSelector(".img-fluid.p-2.max-15c");
    By generateNewQrBtn= By.cssSelector("button[type=\"button\"].btn-primary");
    By generateNewQrText = By.xpath("(//div[@class=\"modal-header\"]/h5[@class=\"modal-title\"])[2]");
    By editPaymentLinkHeader=By.cssSelector("nav.navbar h1.header-title");
    By title = By.cssSelector("input[name=\"description\"][placeholder=\"Title\"]\n");
    By loadingIcon = By.cssSelector("div.d-flex img[src*=\"loading.gif\"]\n");
    By payNowBtn = By.cssSelector("button[type=\"button\"].btn-info");
    By enterPaymentAmount = By.cssSelector("input[type=\"text\"][data-f-type=\"money\"]\n");
    By updateBtn = By.cssSelector("button[type=\"submit\"]");
    By storePayName = By.cssSelector("div.d-flex >h4");
    By directPayCopyBtn = By.cssSelector("button.btn-link.fs-p25 i.fal.fa-copy");
    By flexibleAmountTypeBtn = By.xpath("//button[@data-ajaxsubmit=\"1\" and contains(@data-inaction, \"hide-modal\")]//span[text()=\"Flexible amount\"]");
    By fixedAmountType = By.xpath("//button/span[text()='Fixed amount']");
    By ticketsEvents = By.xpath("//button/span[text()='Tickets/Events']");
    By donationsType = By.xpath("//button/span[text()='Donations']");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By directPayQrButton= By.xpath("//div[text()=' Direct Pay']");
    By qrCodeImage =By.xpath("//img[@class='img-fluid p-2 max-15c']");
    By loader = By.xpath("//img[@class='img-fluid p-2  max-15c']");
    By copyQrButton= By.cssSelector("button.btn.btn-link.fs-p25 > i.fal.fa-copy\n");
    By downloadQrButton = By.xpath("//i[@class=\"far fa-cloud-download-alt\"]");
    By  viewQrButton = By.xpath("//a[@class=\"btn btn-link fs-p25\"]");

    // Actions

    public Clickable getQrDashboardText() {WebdriverWaits.waitForElementUntilVisible(qrDashBoardText, 100);return Clickable.getElementBy(qrDashBoardText);}
    public Clickable getStoresDropdown() {WebdriverWaits.waitForElementUntilVisible(storesCombobox, 100);return Clickable.getElementBy(storesCombobox);}
    public Editable selectStore(){WebdriverWaits.waitForElementUntilVisible(storeDropDown, 100); return Editable.getElementBy(storeDropDown);}
    public Clickable getContinueButton() {WebdriverWaits.waitForElementUntilVisible(continueBtn, 100);return Clickable.getElementBy(continueBtn, "Continue Button");}
    public Clickable getStoreName() {WebdriverWaits.waitForElementUntilVisible(storeName, 100); return Clickable.getElementBy(storeName);}
    public Clickable getStorePayName() {WebdriverWaits.waitForElementUntilVisible(storePayName, 100); return Clickable.getElementBy(storePayName);}
    public  Clickable clickDirectPay(){WebdriverWaits.waitForElementUntilVisible(directPay, 100); return Clickable.getElementBy(directPay);}
    public  Clickable getDirectPayTitle(){WebdriverWaits.waitForElementUntilVisible(directPayTitle, 100); return Clickable.getElementBy(directPayTitle);}
    public  Clickable clickDirectPayCloseBtn(){WebdriverWaits.waitForElementUntilVisible(directPayCloseBtn, 100); return Clickable.getElementBy(directPayCloseBtn);}
    public  Clickable clickDirectPayCopyBtn(){WebdriverWaits.waitForElementUntilVisible(copyQrButton, 100); return Clickable.getElementBy(copyQrButton);}
    public  Clickable clickPayNowBtn(){WebdriverWaits.waitForElementUntilVisible(payNowBtn, 100); return Clickable.getElementBy(payNowBtn);}
    public  Clickable getQrImage(){WebdriverWaits.waitForElementUntilVisible(qrImage, 10000); return Clickable.getElementBy(qrImage);}
    public  Clickable clickNewQrBtn(){WebdriverWaits.waitForElementUntilVisible(generateNewQrBtn, 10000); return Clickable.getElementBy(generateNewQrBtn);}
    public  Clickable getNewQrText(){WebdriverWaits.waitForElementUntilVisible(generateNewQrText, 10000); return Clickable.getElementBy(generateNewQrText);}
    public  Clickable clickFlexibleAmountbtn(){WebdriverWaits.waitForElementUntilVisible(flexibleAmountTypeBtn, 10000); return Clickable.getElementBy(flexibleAmountTypeBtn);}
    public  Clickable clickUpdateBtn(){WebdriverWaits.waitForElementUntilVisible(updateBtn, 10000); return Clickable.getElementBy(updateBtn);}
    public Clickable getEditPaymentLinkHeader(){WebdriverWaits.waitForElementUntilVisible(editPaymentLinkHeader, 10000); return Clickable.getElementBy(editPaymentLinkHeader);}
    public Editable editTitle(){WebdriverWaits.waitForElementUntilVisible(title, 10000); return Editable.getElementBy(title);}
    public Editable enterPaymentAmount(){WebdriverWaits.waitForElementUntilVisible(enterPaymentAmount, 10000); return Editable.getElementBy(enterPaymentAmount);}
    public Clickable getLoadingIcon(){WebdriverWaits.waitForElementInVisible(loadingIcon,100);return Clickable.getElementBy(loadingIcon);}
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
