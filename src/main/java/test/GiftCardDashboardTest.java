package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.GiftCardConfigurationPopup;
import org.automation.pageObjects.GiftCardDashboardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardDashboardTest extends BaseTest {
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	GiftCardDashboardPage giftCardDashboard=new GiftCardDashboardPage();
	GiftCardConfigurationPopup giftCardConfiguration = new GiftCardConfigurationPopup();
	
	@Test(priority =0, enabled = true, description="Verify that Gift Cards Dashboard page opens after clicking on Gift Cards Dashboard Tab")
	public void verifyGiftCardsDashboardPage() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnGiftCardsDashboard();
		Assert.assertEquals(dashboard.getPageTitle(), "Gift Cards Dashboard");
	}
	
	@Test(priority =1, enabled = true, description="Verify Info message when Issue Gift Card Toggle is disabled")
	public void verifyConfiguration() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		Assert.assertEquals(giftCardConfiguration.getPopupTitle(), "Gift Cards Configuration");
		giftCardConfiguration.switchOffIssueGiftCardToggle();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardDashboard.getInfoMessage(), "Gift cards is currently disabled.Configuration");
		
	}
	
	@Test(priority =2, enabled = true, description="Verfy all the element appear after enabling Issue Gift Card Toggle")	
	public void verifyIssuingGiftCardsToggle() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.isAllElementPresent();
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(priority =3, enabled = true, description="Verify Reference No toggle label changes after swiching on/off toggle button")
	public void verifyRefNoToggleLabel() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnRefNoToggle();
		Assert.assertEquals(giftCardConfiguration.getRefNoLabel(), "Mandatory Reference No.");
		giftCardConfiguration.switchOffRefNoToggle();
		Assert.assertEquals(giftCardConfiguration.getRefNoLabel(), "Optional Reference No.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(priority =4, enabled = true, description="Verify funding source toggle button behavior")
	public void verifyFundingSourceToggleLabel() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnFundingSourceToggle();
		Assert.assertEquals(giftCardConfiguration.getFundingSourceLabel(), "Restricted funding source");
		Assert.assertTrue(giftCardConfiguration.isFundingSourcePresent());
		giftCardConfiguration.switchOffFundingSourceToggle();
		Assert.assertEquals(giftCardConfiguration.getFundingSourceLabel(), "Optional funding source");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(priority =5, enabled = true, description="Verify validation message of Max Gift Card Ammount")
	public void validationMaxGiftCardAmountBlank() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.clearMaxGiftCardTbx();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "This field is required.");
		giftCardConfiguration.enterMaxGiftCardAmount(0);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "Please enter a value greater than or equal to 1.");
		giftCardConfiguration.clickOnClose();
	}
	
	
	
}
