package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.CreateAGiftCardPopup;
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
	CreateAGiftCardPopup createGiftCard=new CreateAGiftCardPopup();
	
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
	public void validationMaxGiftCardAmount() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.clearMaxGiftCardTbx();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "This field is required.");
		giftCardConfiguration.enterMaxGiftCardAmount(0);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "Please enter a value greater than or equal to 1.");
		giftCardConfiguration.enterMaxGiftCardAmount(100000);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "Please enter a value less than or equal to 99999.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(priority =6, enabled = true, description="Verify validation message of Max Gift Card Amount")
	public void validationFundingSourceTextBox() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getFundingSourceToolTipMessage(), "This field is required.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(priority =7, enabled = true, description="Verify successfull configuration of gift card.")
	public void verifySuccessfullConfiguration() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.enterMaxGiftCardAmount(4999);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		//Assert.assertEquals(giftCardConfiguration.getToastMessage(), "Gift card configuration for store has been updated.");   // Get Toast Message Xpath and update.
		Assert.assertTrue(giftCardDashboard.isIssueAGiftCardLinkPresent());
		Assert.assertTrue(giftCardDashboard.isGiftCardForSaleLinkPresent());
	}
	

	@Test(priority =8, enabled = true, description="Verify Issue A Gift Card Link")
	public void createAGiftCardPopup() {
		giftCardDashboard.clickOnIssueAGiftCard();
		Assert.assertEquals(createGiftCard.getPopupTitle(),"Create gift card");
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(priority =9, enabled = true, description="Validation of Customer Phone Number Text Box")
	public void validationOfCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "This field is required.");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(priority =10, enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void validationForNonExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+911236547890");
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getWariningMessage(), "Customer not found");
		Assert.assertTrue(createGiftCard.isContinueBtnPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(priority =11, enabled = true, description="Validation when Invalid Customer Phone Number entered in Customer Phone Number Text Box")
	public void validationOfInvalidCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("987456112");
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "Invalid value");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(priority =12, enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void verifyforExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+918877070727");
		createGiftCard.clickOnFind();
		Assert.assertTrue(createGiftCard.isInitialAmountPresent());
		Assert.assertTrue(createGiftCard.isMessageBoxPresent());
		Assert.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(priority =13, enabled = true, description="Verify Continue without search button")
	public void verifyContinueWithoutSearch() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		Assert.assertTrue(createGiftCard.isInitialAmountPresent());
		Assert.assertTrue(createGiftCard.isMessageBoxPresent());
	    Assert.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	
	
}
