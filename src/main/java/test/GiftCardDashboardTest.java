package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pageObjects.CreateAGiftCardPopup;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.GiftCardConfigurationPopup;
import org.automation.pageObjects.GiftCardDashboardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.UserPage;
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
	CardNoPopup cardNo=new CardNoPopup();
	UserPage user=new UserPage();
	
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
		giftCardDashboard.refreshPage();
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
	 public void tc22_verifyRestrictedFundinSourceBehavior() {
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		List<String> fundingSourceOption=new ArrayList<String>();
		fundingSourceOption.add("Outsource");
		fundingSourceOption.add("Individual");
		fundingSourceOption.add("Private");
		fundingSourceOption.add("");
		for(String s:fundingSourceOption) {
			giftCardConfiguration.enterFundingSource(s+Keys.ENTER );	
		}
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		giftCardDashboard.refreshPage();
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Collections.sort(fundingSourceOption);
		Assert.assertTrue(createGiftCard.getTagOfFundingSource().equalsIgnoreCase("select"));
		Assert.assertTrue(createGiftCard.getSelectList().equals(fundingSourceOption));
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field")
	public void tc23_verifyValidationForStartAndExpDate() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterStartDate("Start date");
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getStartDateToolTipMessage(), "Invalid date");
		createGiftCard.enterExpDate("Exp date");
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getExpDateToolTipMessage(), "Invalid date");
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify successfull creation of Gift Card after finding a phone number")
	public void tc24_verifySuccessfullCreationOfGiftCardForExsistingNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+918877070727");
		createGiftCard.clickOnFind();
		createGiftCard.enterInitialAmt("499");
		createGiftCard.enterRefNo("RefNo-969");
		createGiftCard.clickOnCreate();
		createGiftCard.closeToastMessage();
		Assert.assertEquals(createGiftCard.getToastMesssage(), "Gift card created!");
	}
	
	@Test(enabled = true, description="Verify successfull creation of Gift Card without finding phone number")
	public void tc25_verifySuccessfullCreationOfGiftCard() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.enterInitialAmt("999");
		createGiftCard.enterRefNo("RefNo-1265");
		createGiftCard.clickOnCreate();
		Assert.assertEquals(createGiftCard.getAleartMesssage(), "Attention! Anyone who has access to this link can claim this gift card.");
		Assert.assertEquals(createGiftCard.getToastMesssage(), "Gift card created!");
		createGiftCard.clickOnCloseBtn();
		createGiftCard.closeToastMessage();
	}
	
	@Test(enabled = true, description="Verify that 'Gift Card Details' popup opens up after clicking on any card number listed under 'Card No' ")
	public void tc26_verifyGiftCardDetailsPopup() {
		String giftCardNo=giftCardDashboard.getGiftCard();
		giftCardDashboard.clickOnGiftCard();
		Assert.assertEquals("Card No: "+giftCardNo, cardNo.getCardNo());
		cardNo.clickOnInfoIcon();
		Assert.assertTrue(cardNo.isStartDatePresent());
		Assert.assertTrue(cardNo.isIssueOnDatePresent());
		Assert.assertTrue(cardNo.isIssueByDatePresent());
		Assert.assertTrue(cardNo.isFundingSourcePresent());
		Assert.assertTrue(cardNo.isRefNoPresent());
		Assert.assertTrue(cardNo.isIssueAmtPresent());
		cardNo.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify'User-Profile' page opens afetr clicking on any customer name under 'Card holder' column.")
	public void tc27_verifyUserProfilePage() {
		giftCardDashboard.clickOnGiftCard();
		String userName=cardNo.getUserName();
		cardNo.clickOnUserName();
		cardNo.switchToWindow("User Profile Window");
		Assert.assertEquals(userName, user.getPageTitle());
		
	}
	
	@Test(enabled = true, description="Verify'Message' page opens afetr clicking on message icon ")
	public void tc28_verifyMessagePage() {
		user.clickOnMessage();
		Assert.assertEquals(user.getHeader() ,"Messages");
		user.goBackToPreviousPage();
	}
	
	@Test(enabled = true, description="Verify 'Reward Point' page opens afetr clicking on Reward point count ")
	public void tc29_verifRewardPointPage() {
		user.clickOnRewardPoint();
		Assert.assertEquals(user.getHeader() ,"Reward Points Detail");
		cardNo.switchToWindow("Card Details Page");
		cardNo.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify that all fields appears afetr clicking on filter link")
	public void tc30_verifyFilterButtonBehaviour() {
		giftCardDashboard.clickOnFilter();
		Assert.assertTrue(giftCardDashboard.isUserNameFieldPresent());
		Assert.assertTrue(giftCardDashboard.isUserPhoneEmailFieldPresent());
		Assert.assertTrue(giftCardDashboard.isDateFieldPresent());
		Assert.assertTrue(giftCardDashboard.isGiftCardStatusPresent());
		Assert.assertTrue(giftCardDashboard.isMinAmountFieldPresent());
		Assert.assertTrue(giftCardDashboard.isMaxAmountFieldPresent());
		Assert.assertTrue(giftCardDashboard.isCardNoFieldPresent());
	}
	
	@Test(enabled = true, description="Verify that all the issued gift cards with 'Active' status appear listed on Gift Card Dashboard page")
	public void tc31_verifyAllActiveGiftCard() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.ScrollDownThePageMax();
		Assert.assertTrue(giftCardDashboard.isAllGiftCardStatus("Active"));
	}
	
	@Test(enabled = true, description="Verify relevant gift cards appear listed after entering existing card holder name in User Name")
	public void tc32_verifyUserNameFilter() {
		giftCardDashboard.clickOnFilter();
		String userName="Lucas";
		giftCardDashboard.enterUserName(userName);
		giftCardDashboard.clickOnApply();
		Assert.assertTrue(giftCardDashboard.isAllCardHolderName(userName));
	}
	
	@Test(enabled = true, description="Verify information message appear after entering non existing number in User Number/Email")
	public void tc33_verifyUserNameFilterNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("+918547659428");
		giftCardDashboard.clickOnApply();
		Assert.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
	}
	
	@Test(enabled = true, description="Verify information message appear after entering non existing email in User Number/Email")
	public void tc34_verifyUserEmialFilterNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("demo@yopmail.com");
		giftCardDashboard.clickOnApply();
		Assert.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
	}
	
	@Test(enabled = true, description="Verify relevant gift cards appear listed after entering date in date field")
	public void tc35_verifyDateRangeField() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String startDate="07/01/2023";
		String endDate="07/31/2023";
		giftCardDashboard.enterDate(startDate+" - "+endDate);
		giftCardDashboard.clickOnApply();
		Assert.assertTrue(giftCardDashboard.areAllGiftCardOfRange(giftCardDashboard.getGiftIssuedate(),startDate,endDate));
		}
	
	@Test(enabled = true, description="Verify infromation message appear after non exsisting entering date in date field")
	public void tc36_verifyDateRangeFieldNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String startDate="05/01/2022";
		String endDate="12/31/2022";
		giftCardDashboard.enterDate(startDate+" - "+endDate);
		giftCardDashboard.clickOnApply();
		Assert.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
		}
	
	@Test(enabled = true, description="Verify validation message appears after entering characters in 'Date' field")
	public void tc37_verifyValidationDateRange() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterDate("date");
		giftCardDashboard.clickOnApply();
		giftCardDashboard.clickOnCloseValidation();
		Assert.assertEquals(giftCardDashboard.getDateRangeToolTipMessage(),"Invalid date range");
		}
	
	@Test(enabled = true, description="Verify 'Gift card status' dropdown appears 'Active' by default")
	public void tc38_verifyGiftCardStatusDefaultSelection() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		Assert.assertEquals(giftCardDashboard.getSelectedGiftCardStatus(),"Active");
		}
	
	@Test(enabled = true, description="Verify all options appear in 'Gift card status' dropdown, after clicking 'Gift card status' dropdown")
	public void tc39_verifyGiftCardStatusAllOptions() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		List<String> options=new ArrayList();
		options.add("");
		options.add("Active");
		options.add("Blocked");
		options.add("Expired");
		options.add("No Balance");
		options.add("Pending transfer");
		Assert.assertTrue(options.equals(giftCardDashboard.getAllGiftCardStatusOptions()));
		}
	
	
	
	
	}
	

