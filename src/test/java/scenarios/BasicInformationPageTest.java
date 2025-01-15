package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.Constants;
import org.automation.data.KadeUserAccount;
import org.automation.pages.BasicInfoPage;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class BasicInformationPageTest extends BaseTest {

    @Test(description = "Verify 'Basic Information' page is visible after clicking on 'Configure' button of any store")
    public void verifyBasicInformationPageOpens() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        Assertions.assertTrue(session.getBasicInfoPage().getStoreConfigTitle().isDisplayed());
        Assertions.assertTrue(session.getBasicInfoPage().getBasicInfoPage().isDisplayed());
        Assertions.assertTrue(session.getBasicInfoPage().getStoreAddress().isDisplayed());
        Assertions.assertTrue(session.getBasicInfoPage().getStorePhone().isDisplayed());
        Assertions.assertTrue(session.getBasicInfoPage().getStoreCurrency().isDisplayed());
        Assertions.assertTrue(session.getBasicInfoPage().getStoreTaxRate().isDisplayed());
    }

    @Test(description = "Verify that the user is able to modify information after clicking on 'Modify' button")
    public void verifyModifyAndSaveChangesFunctionality() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        session.getBasicInfoPage().getModifyButton().click();
        WebdriverWaits.waitForElementInVisible(session.getBasicInfoPage().modifyBtn,10);
        session.getBasicInfoPage().getStoreNameField().setText("Automation Customer Store");

        session.getBasicInfoPage().getStoreAddressField().setText("New York Avenue Northwest, Washington, DC, USA");

        session.getBasicInfoPage().getStorePhoneField().setText("12312312312");

        session.getBasicInfoPage().getStoreTaxRateField().setText("10000");

        session.getBasicInfoPage().getSaveButton().click();

    }

    @Test(description = "Enter Invalid or Unverified address in the Store Address field of the Store Basic Information page")
    public void verifyInvalidAddressValidation() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        session.getBasicInfoPage().getModifyButton().click();
        WebdriverWaits.waitForElementInVisible(session.getBasicInfoPage().modifyBtn,10);
        session.getBasicInfoPage().getStoreAddressField().setText("New");
        session.getBasicInfoPage().getSaveButton().clickByMouse();
        Assertions.assertTrue(session.getBasicInfoPage().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getBasicInfoPage().getStoreAddressField().getToolTipMessage(),Constants.addressVerificationError);

    }

    @Test(description = "Enter Invalid Phone number in the Phone number field of the Store Basic Information page")
    public void verifyInvalidPhoneValidation() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        session.getBasicInfoPage().getModifyButton().click();
        WebdriverWaits.waitForElementInVisible(session.getBasicInfoPage().modifyBtn,10);
        session.getBasicInfoPage().getStorePhoneField().setText("1231");
        session.getBasicInfoPage().getSaveButton().clickByMouse();
        Assertions.assertTrue(session.getBasicInfoPage().getAlertMessage().isDisplayed());
        Assertions.assertEquals(session.getBasicInfoPage().getStorePhoneField().getToolTipMessage(),Constants.invalidPhnValidation);
    }


    @Test(description = "Change Store logo")
    public void verifyStoreLogoChange() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "image" + File.separator + "dummy-image.jpg";
        fileInput.sendKeys(filePath);
        WebdriverWaits.sleep(2000);
        session.getBasicInfoPage().getCheckBtn().click();
        WebdriverWaits.waitForElementInVisible(session.getBasicInfoPage().checkBtn,10);

    }

    @Test(description = "Try uploading invalid file format as store logo")
    public void verifyStoreLogoChangeWithInvalidFile() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "image" + File.separator + "dummy.pdf";
        fileInput.sendKeys(filePath);
        Assertions.assertTrue(session.getBasicInfoPage().getValidationMsg().isDisplayed());
        Assertions.assertEquals(session.getBasicInfoPage().getValidationMsg().getText(),"Not a valid image file");

    }

}
