package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class BasicInformationPageTest extends BaseTest {

    @Test(description = "Verify 'Basic Information' page is visible after clicking on 'Configure' button of any store")
    public void basicInformationPage() {
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
    public void modifyAndSaveChanges() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().expandManageBusinessAccordionBttn().click();
        session.getSidePannel().getMyStoresTab().click();
        session.getBasicInfoPage().getStoreConfigBtn().click();

        session.getBasicInfoPage().getModifyButton().click();
        session.getBasicInfoPage().getStoreNameField().setText("Automation Customer Store");

        session.getBasicInfoPage().getStoreAddressField().setText("New York Avenue Northwest, Washington, DC, USA");

        session.getBasicInfoPage().getStorePhoneField().setText("12312312312");


        session.getBasicInfoPage().getSaveButton().click();

    }




}
