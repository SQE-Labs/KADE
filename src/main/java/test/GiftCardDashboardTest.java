package test;

import java.util.ArrayList;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pageObjects.CreateAGiftCardPopup;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.GiftCardConfigurationPopup;
import org.automation.pageObjects.GiftCardDashboardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardDashboardTest extends BaseTest {
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	GiftCardDashboardPage giftCardDashboard=new GiftCardDashboardPage();
	GiftCardConfigurationPopup giftCardConfiguration = new GiftCardConfigurationPopup();
	CreateAGiftCardPopup createGiftCard=new CreateAGiftCardPopup();	
	
	@Test(enabled = true, description="Verify that Gift Cards Dashboard page opens after clicking on Gift Cards Dashboard Tab")
	public void tc01_verifyGiftCardsDashboardPage() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnGiftCardsDashboard();
		Assert.assertEquals(dashboard.getPageTitle(), "Gift Cards Dashboard");
	}
	
	@Test(enabled = true, description="Verify Info message when Issue Gift Card Toggle is disabled")
	public void tc02_verifyConfiguration() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		Assert.assertEquals(giftCardConfiguration.getPopupTitle(), "Gift Cards Configuration");
		giftCardConfiguration.switchOffIssueGiftCardToggle();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardDashboard.getInfoMessage(), "Gift cards is currently disabled.Configuration");
		
	}
	
	@Test(enabled = true, description="Verfy all the element appear after enabling Issue Gift Card Toggle")	
	public void tc03_verifyIssuingGiftCardsToggle() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.isAllElementPresent();
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify Reference No toggle label changes after swiching on/off toggle button")
	public void tc04_verifyRefNoToggleLabel() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnRefNoToggle();
		Assert.assertEquals(giftCardConfiguration.getRefNoLabel(), "Mandatory Reference No.");
		giftCardConfiguration.switchOffRefNoToggle();
		Assert.assertEquals(giftCardConfiguration.getRefNoLabel(), "Optional Reference No.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify funding source toggle button behavior")
	public void tc05_verifyFundingSourceToggleLabel() {
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
	
	@Test(enabled = true, description="Verify validation message of Max Gift Card Ammount")
	public void tc06_validationMaxGiftCardAmount() {
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
	
	@Test(enabled = true, description="Verify validation message for empty funding source textbox")
	public void tc07_validationFundingSourceTextBox() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assert.assertEquals(giftCardConfiguration.getFundingSourceToolTipMessage(), "This field is required.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify successfull configuration of gift card.")
	public void tc08_verifySuccessfullConfiguration() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.enterMaxGiftCardAmount(4999);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		//Assert.assertEquals(giftCardConfiguration.getToastMessage(), "Gift card configuration for store has been updated.");   // Get Toast Message Xpath and update.
		Assert.assertTrue(giftCardDashboard.isIssueAGiftCardLinkPresent());
		Assert.assertTrue(giftCardDashboard.isGiftCardForSaleLinkPresent());
	}
	

	@Test(enabled = true, description="Verify Issue A Gift Card Link")
	public void tc09_createAGiftCardPopup() {
		giftCardDashboard.clickOnIssueAGiftCard();
		Assert.assertEquals(createGiftCard.getPopupTitle(),"Create gift card");
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(enabled = true, description="Validation of Customer Phone Number Text Box")
	public void tc10_validationOfCustomerPhoneNumber() {
		
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "This field is required.");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc11_validationForNonExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+911236547890");
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getWariningMessage(), "Customer not found");
		Assert.assertTrue(createGiftCard.isContinueBtnPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Validation when Invalid Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc12_validationOfInvalidCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("98745611");
		createGiftCard.clickOnFind();
		Assert.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "Invalid phone number");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc13_verifyforExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+918877070727");
		createGiftCard.clickOnFind();
		Assert.assertTrue(createGiftCard.isInitialAmountPresent());
		Assert.assertTrue(createGiftCard.isMessageBoxPresent());
		Assert.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify Continue without search button")
	public void tc14_verifyContinueWithoutSearch() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		Assert.assertTrue(createGiftCard.isInitialAmountPresent());
		Assert.assertTrue(createGiftCard.isMessageBoxPresent());
	    Assert.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when Initial amount textbox is left blank.")
	public void tc15_validationMessageInitialAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "This field is required."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when 0 is entered in Initial amount textbox")
	public void tc16_validationMessageZeroInitialAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.enterInitialAmt("0");
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "Please enter a value greater than or equal to 0.01."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when amount entered in Initial amount textbox is more than configured amount")
	public void tc17_validationMessageInitialAmtMoreThanConfigAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		String configAmt="4999";
		createGiftCard.enterInitialAmt("5000");
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "Please enter a value less than or equal to "+configAmt+"."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify behavior of Advanced Link on Create gift card popup")
	public void tc18_verifyAdvancedLink() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Assert.assertTrue(createGiftCard.isCardNoFieldPresent());
		Assert.assertTrue(createGiftCard.isFundingSourceFieldPresent());
		Assert.assertTrue(createGiftCard.isMemoFieldPresent());
		Assert.assertTrue(createGiftCard.isStartDateFieldPresent());
		Assert.assertTrue(createGiftCard.isExpDateFieldPresent());
		createGiftCard.clickOnCloseBtn();
	}

	@Test(enabled = true, description="Verify that max lengt of Card No textbox is 18")
	public void tc19_verifyCardNoTbxMaxLengthInput() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterCardNo("1234567891234567890000");
		System.out.println("hello"+ createGiftCard.getCardNo());
		Assert.assertTrue(createGiftCard.getCardNo().length()==18);
		Assert.assertEquals(createGiftCard.getCardNo(), "123456789123456789");
		createGiftCard.clickOnCloseBtn();
		} 
	
	@Test(enabled = true, description="Verify only numeric value is accepted")
	public void tc20_verifyCardNoTbxInput() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterCardNo("abcd");
		Assert.assertEquals(createGiftCard.getCardNo(), "");
		createGiftCard.enterCardNo("56972115");
		Assert.assertEquals(createGiftCard.getCardNo(), "56972115");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(enabled = true, description="Verify that 'Funding Source' field appear as text field when Funding source is set to optional")
	 public void tc21_verifyOptionalFundinSourceBehavior() {
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOffFundingSourceToggle();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		giftCardDashboard.refreshPage();
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Assert.assertTrue(createGiftCard.getTagOfFundingSource().equalsIgnoreCase("input"));
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(enabled = true, description="Verify that all the added Funding source during  Gift Cards Configuration appears in 'Funding source' dropdown list")
	 public void tc21_verifyRestrictedFundinSourceBehavior() {
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		List<String> fundingSourceOption=new ArrayList<String>();
		fundingSourceOption.add("Option1");
		fundingSourceOption.add("Option2");
		fundingSourceOption.add("Option3");
		fundingSourceOption.add("");
		for(String s:fundingSourceOption) {
			giftCardConfiguration.enterFundingSource(s+Keys.ENTER );	
		}
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		giftCardDashboard.refreshPage();
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Assert.assertTrue(createGiftCard.getTagOfFundingSource().equalsIgnoreCase("select"));
		Assert.assertTrue(createGiftCard.getSelectList().equals(fundingSourceOption));
		createGiftCard.clickOnCloseBtn();
	}
	
	}
	

