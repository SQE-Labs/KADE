package legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pages.*;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.GiftCardsForSalePage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.automation.data.KadeUserAccount.Customer;
import static org.automation.data.KadeUserAccount.Default;

public class GiftCardDashboardTest extends BaseTest {
	LoginPage login=new LoginPage();
	SidePannel dashboard=new SidePannel();
	GiftCardDashboardPage giftCardDashboard=new GiftCardDashboardPage();
	GiftCardConfigurationPopup giftCardConfiguration = new GiftCardConfigurationPopup();
	CreateAGiftCardPopup createGiftCard=new CreateAGiftCardPopup();
	GiftCardDetailsPage giftCardDetails=new GiftCardDetailsPage();
	UserPage user=new UserPage();
	GiftCardsForSalePage giftCardForSale=new GiftCardsForSalePage();
	AddGiftCardPage addGiftCard=new AddGiftCardPage();
	KadeSession session = new KadeSession();


	@Test(description = "TC_01 Verify that user gets directed to 'Gift Cards Dashboard' page, after clicking on 'Gift Cards' tab on Left Panel.")
	public void TC_01_verifyGiftCardDashboard()  {
		KadeSession.login(Default);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		Assertions.assertEquals(session.getGiftCardDashboardPage().getGiftCardText().getText(),"Gift Cards Dashboard");

	}

	
	@Test(enabled = true, description="TC_02_01 Verify that 'Gift Cards Configuration' pop up opens after clicking on 'Configuration' link on the 'Gift Cards Dashboard' Page")
	public void TC_02_01_verifyGiftCardConfigurationPopup() {
		KadeSession.login(Customer);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();
		Assertions.assertEquals(session.getGiftCardConfigurationPopup().getPopupTitle().getText(), "Gift Cards Configuration");
		
	}
	
	@Test(enabled = true, description="TC_02_02 Verify that information message appear on 'Gift Cards Dashboard' page, when 'Accepting and issuing Gift Cards' toggle is disabled on 'Gift Cards Configuration' popup.")
	public void TC_02_02_verifyDisabledInfoMsg() {
		KadeSession.login(Customer);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();
		session.getGiftCardConfigurationPopup().clickOnSaveConfigurationBtn().click();
		Assertions.assertEquals(session.getGiftCardDashboardPage().getInfoMessage().getText(),"Gift cards is currently disabled.Configuration");
	}



	@Test(enabled = true, description="TC_03 Verify that 'Reference No.' and 'funding source' toggle button, and 'Maximum gift card amount allowed' textbox field appear, after 'Accepting and issuing Gift Cards' toggle button is enabled, on 'Gift Cards Configuration' popup.")
	public void TC_03_verifyRefNoToggleLabel() {
		KadeSession.login(Customer);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();
		session.getGiftCardConfigurationPopup().switchOnIssueGiftCardToggle().click();
		Assertions.assertEquals(session.getGiftCardConfigurationPopup().getEnabledText().getText(),"Enabled");
		Assertions.assertEquals(session.getGiftCardConfigurationPopup().getReferenceDisabledNoText().getText(),"Reference No. is optional");
		Assertions.assertEquals(session.getGiftCardConfigurationPopup().getAmtText().getText(),"Maximum allowed gift card amount:");



	}
	
	@Test(enabled = true, description="TC_04 Verify that label of 'Optional Reference No.' toggle button changes to 'Mandatory Reference No.' , when 'Optional Reference No.' toggle button is switched on, on 'Gift Cards Configuration' popup.")
	public void TC_04_verifyOptionalRefNoToggleLabel() throws InterruptedException {
		KadeSession.login(Customer);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();
		if (session.getGiftCardConfigurationPopup().getReferenceEnabledElement().isDisplayed()) {
			session.getGiftCardConfigurationPopup().switchOnRefeNoToggele().click();
			Assertions.assertEquals(session.getGiftCardConfigurationPopup().getReferenceDisabledNoText().getText(), "Reference No. is optional");
			session.getGiftCardConfigurationPopup().switchOffRefeNoToggle().click();
			Assertions.assertEquals(session.getGiftCardConfigurationPopup().getEnabledReferenceNotext().getText(), "Reference No. is mandatory");
		} else {

			Assertions.assertEquals(session.getGiftCardConfigurationPopup().getReferenceDisabledNoText().getText(), "Reference No. is optional");
			session.getGiftCardConfigurationPopup().switchOffRefeNoToggle().click();
			Assertions.assertEquals(session.getGiftCardConfigurationPopup().getEnabledReferenceNotext().getText(), "Reference No. is mandatory");
		}
	}



		@Test(enabled = true, description="TC_05 Verify that label of 'Optional funding source' toggle button changes to 'Restricted funding source' and a textbox appears , when 'Optional funding source' toggle button is switched on, on 'Gift Cards Configuration' popup.")
		public void TC_05_verifyFundingResourceToggle() throws InterruptedException {
			KadeSession.login(Customer);
			session.getSidePannel().expandManageBusinessAccordionBttn().click();
			session.getSidePannel().getGiftCardsDashboardTab().click();
			session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();
			if(session.getGiftCardConfigurationPopup().getFundingResourceElement().isDisplayed()) {
				session.getGiftCardConfigurationPopup().switchOnFundingSourceToggele().click();
				Assertions.assertEquals(session.getGiftCardConfigurationPopup().getFundingSourceDiabledText().getText(),"Funding source is optional");
				session.getGiftCardConfigurationPopup().switchoffFundingSourceToggele().click();
				Assertions.assertEquals(session.getGiftCardConfigurationPopup().getFundingSourceEnabledText().getText(), "Funding source is restricted");
			}
			else{

				Assertions.assertEquals(session.getGiftCardConfigurationPopup().getFundingSourceDiabledText().getText(),"Funding source is optional");
				session.getGiftCardConfigurationPopup().switchoffFundingSourceToggele().click();
				Assertions.assertEquals(session.getGiftCardConfigurationPopup().getFundingSourceEnabledText().getText(), "Funding source is restricted");
			}



	}



	@Test(enabled = true, description="Verify validation message of Max Gift Card Ammount")
	public void TC_06_validationMaxGiftCardAmount() {
		KadeSession.login(Customer);
		session.getSidePannel().expandManageBusinessAccordionBttn().click();
		session.getSidePannel().getGiftCardsDashboardTab().click();
		session.getGiftCardConfigurationPopup().clickConfigurationBtn().click();

		Assertions.assertEquals(giftCardConfiguration.getMaxGiftCardToolTipMessage(), "This field is required.");

	}
	
	@Test(enabled = true, description="Verify validation message for empty funding source textbox")
	public void tc07_validationFundingSourceTextBox() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		Assertions.assertEquals(giftCardConfiguration.getFundingSourceToolTipMessage(), "This field is required.");
		giftCardConfiguration.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify successfull configuration of gift card.")
	public void tc08_verifySuccessfullConfiguration() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnIssueGiftCardToggle();
		giftCardConfiguration.enterMaxGiftCardAmount(4999);
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		//Assertions.assertEquals(giftCardConfiguration.getToastMessage(), "Gift card configuration for store has been updated.");   // Get Toast Message Xpath and update.
		Assertions.assertTrue(giftCardDashboard.isIssueAGiftCardLinkPresent());
		Assertions.assertTrue(giftCardDashboard.isGiftCardForSaleLinkPresent());
	}
	

	@Test(enabled = true, description="Verify Issue A Gift Card Link")
	public void tc09_createAGiftCardPopup() {
		giftCardDashboard.clickOnIssueAGiftCard();
		Assertions.assertEquals(createGiftCard.getPopupTitle(),"Create gift card");
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(enabled = true, description="Validation of Customer Phone Number Text Box")
	public void tc10_validationOfCustomerPhoneNumber() {
		giftCardDashboard.refreshPage();
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnFind();
		Assertions.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "This field is required.");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc11_validationForNonExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+911236547890");
		createGiftCard.clickOnFind();
		Assertions.assertEquals(createGiftCard.getWariningMessage(), "Customer not found");
		Assertions.assertTrue(createGiftCard.isContinueBtnPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Validation when Invalid Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc12_validationOfInvalidCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("98745611");
		createGiftCard.clickOnFind();
		Assertions.assertEquals(createGiftCard.getCustomerPhoneNumberToolTipMessage(), "Invalid phone number");
		createGiftCard.clickOnCloseBtn();
		}
	
	@Test(enabled = true, description="Validation when non existing Customer Phone Number entered in Customer Phone Number Text Box")
	public void tc13_verifyforExsistingCustomerPhoneNumber() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.enterCustomerPhoneNumber("+918877070727");
		createGiftCard.clickOnFind();
		Assertions.assertTrue(createGiftCard.isInitialAmountPresent());
		Assertions.assertTrue(createGiftCard.isMessageBoxPresent());
		Assertions.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify Continue without search button")
	public void tc14_verifyContinueWithoutSearch() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		Assertions.assertTrue(createGiftCard.isInitialAmountPresent());
		Assertions.assertTrue(createGiftCard.isMessageBoxPresent());
	    Assertions.assertTrue(createGiftCard.isRefNoTextBoxPresent());
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when Initial amount textbox is left blank.")
	public void tc15_validationMessageInitialAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "This field is required."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when 0 is entered in Initial amount textbox")
	public void tc16_validationMessageZeroInitialAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.enterInitialAmt("0");
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "Please enter a value greater than or equal to 0.01."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="validation when amount entered in Initial amount textbox is more than configured amount")
	public void tc17_validationMessageInitialAmtMoreThanConfigAmt() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		String configAmt="4999";
		createGiftCard.enterInitialAmt("5000");
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getInitialAmountToolTipMessage(), "Please enter a value less than or equal to "+configAmt+"."); 
		createGiftCard.clickOnCloseBtn();
	}
	
	@Test(enabled = true, description="Verify behavior of Advanced Link on Create gift card popup")
	public void tc18_verifyAdvancedLink() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Assertions.assertTrue(createGiftCard.isCardNoFieldPresent());
		Assertions.assertTrue(createGiftCard.isFundingSourceFieldPresent());
		Assertions.assertTrue(createGiftCard.isMemoFieldPresent());
		Assertions.assertTrue(createGiftCard.isStartDateFieldPresent());
		Assertions.assertTrue(createGiftCard.isExpDateFieldPresent());
		createGiftCard.clickOnCloseBtn();
	}

	@Test(enabled = true, description="Verify that max lengt of Card No textbox is 18")
	public void tc19_verifyCardNoTbxMaxLengthInput() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterCardNo("1234567891234567890000");
		Assertions.assertTrue(createGiftCard.getCardNo().length()==18);
		Assertions.assertEquals(createGiftCard.getCardNo(), "123456789123456789");
		createGiftCard.clickOnCloseBtn();
		} 
	
	@Test(enabled = true, description="Verify only numeric value is accepted")
	public void tc20_verifyCardNoTbxInput() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterCardNo("abcd");
		Assertions.assertEquals(createGiftCard.getCardNo(), "");
		createGiftCard.enterCardNo("56972115");
		Assertions.assertEquals(createGiftCard.getCardNo(), "56972115");
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
		Assertions.assertTrue(createGiftCard.getTagOfFundingSource().equalsIgnoreCase("input"));
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(enabled = true, description="Verify that all the added Funding source during  Gift Cards Configuration appears in 'Funding source' dropdown list")
	 public void tc22_verifyRestrictedFundinSourceBehavior() {
		giftCardDashboard.clickOnConfigurationLink();
		giftCardConfiguration.switchOnFundingSourceToggle();
		giftCardConfiguration.clearFundingSource();
		List<String> fundingSourceOption=new ArrayList<String>();
		fundingSourceOption.add("Individual");
		fundingSourceOption.add("Outsource");
		fundingSourceOption.add("Private");
		for(String s:fundingSourceOption) {
				giftCardConfiguration.enterFundingSource(s+Keys.ENTER );	
		}
		giftCardConfiguration.clickOnSaveConfigurationBtn();
		giftCardDashboard.refreshPage();
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		Collections.sort(fundingSourceOption);
		Assertions.assertTrue(createGiftCard.getTagOfFundingSource().equalsIgnoreCase("select"));
		createGiftCard.clickOnCloseBtn();
		
	}
	
	@Test(enabled = true, description="Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field")
	public void tc23_verifyValidationForStartAndExpDate() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.clickOnAdvancedLink();
		createGiftCard.enterStartDate("Start date");
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getStartDateToolTipMessage(), "Invalid date");
		createGiftCard.enterExpDate("Exp date");
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getExpDateToolTipMessage(), "Invalid date");
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
		Assertions.assertEquals(createGiftCard.getToastMesssage(), "Gift card created!");
	}
	
	@Test(enabled = true, description="Verify successfull creation of Gift Card without finding phone number")
	public void tc25_verifySuccessfullCreationOfGiftCard() {
		giftCardDashboard.clickOnIssueAGiftCard();
		createGiftCard.clickOnContinueWithoutSearch();
		createGiftCard.enterInitialAmt("999");
		createGiftCard.enterRefNo("RefNo-1265");
		createGiftCard.clickOnCreate();
		Assertions.assertEquals(createGiftCard.getAleartMesssage(), "Attention! Anyone who has access to this link can claim this gift card.");
		Assertions.assertEquals(createGiftCard.getToastMesssage(), "Gift card created!");
		createGiftCard.clickOnCloseBtn();
		createGiftCard.closeToastMessage();
	}
	
	@Test(enabled = true, description="Verify that 'Gift Card Details' popup opens up after clicking on any card number listed under 'Card No' ")
	public void tc26_verifyGiftCardDetailsPopup() {
		String giftCardNo=giftCardDashboard.getGiftCard();
		giftCardDashboard.clickOnGiftCard();
		Assertions.assertEquals("Card No: "+giftCardNo, giftCardDetails.getCardNo());
		giftCardDetails.clickOnInfoIcon();
		Assertions.assertTrue(giftCardDetails.isStartDatePresent());
		Assertions.assertTrue(giftCardDetails.isIssueOnDatePresent());
		Assertions.assertTrue(giftCardDetails.isIssueByDatePresent());
		Assertions.assertTrue(giftCardDetails.isFundingSourcePresent());
		Assertions.assertTrue(giftCardDetails.isRefNoPresent());
		Assertions.assertTrue(giftCardDetails.isIssueAmtPresent());
		giftCardDetails.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify'User-Profile' page opens afetr clicking on any customer name under 'Card holder' column.")
	public void tc27_verifyUserProfilePage() {
		giftCardDashboard.clickOnGiftCard();
		String userName=giftCardDetails.getUserName();
		giftCardDetails.clickOnUserName();
		giftCardDetails.switchToWindow("User Profile Window");
		Assertions.assertEquals(userName, user.getPageTitle());
		
	}
	
	@Test(enabled = true, description="Verify'Message' page opens afetr clicking on message icon ")
	public void tc28_verifyMessagePage() {
		user.clickOnMessage();
		Assertions.assertEquals(user.getHeader() ,"Messages");
		user.goBackToPreviousPage();
	}
	
	@Test(enabled = true, description="Verify 'Reward Point' page opens afetr clicking on Reward point count ")
	public void tc29_verifRewardPointPage() {
		user.clickOnRewardPoint();
		Assertions.assertEquals(user.getHeader() ,"Reward Points Detail");
		giftCardDetails.switchToWindow("Card Details Page");
		giftCardDetails.clickOnClose();
	}
	
	@Test(enabled = true, description="Verify that all fields appears afetr clicking on filter link")
	public void tc30_verifyFilterButtonBehaviour() {
		giftCardDashboard.clickOnFilter();
		Assertions.assertTrue(giftCardDashboard.isUserNameFieldPresent());
		Assertions.assertTrue(giftCardDashboard.isUserPhoneEmailFieldPresent());
		Assertions.assertTrue(giftCardDashboard.isDateFieldPresent());
		Assertions.assertTrue(giftCardDashboard.isGiftCardStatusPresent());
		Assertions.assertTrue(giftCardDashboard.isMinAmountFieldPresent());
		Assertions.assertTrue(giftCardDashboard.isMaxAmountFieldPresent());
		Assertions.assertTrue(giftCardDashboard.isCardNoFieldPresent());
	}
	
	@Test(enabled = true, description="Verify that all the issued gift cards with 'Active' status appear listed on Gift Card Dashboard page")
	public void tc31_verifyAllActiveGiftCard() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.ScrollDownThePageMax();
		Assertions.assertTrue(giftCardDashboard.isAllGiftCardStatus("Active"));
	}
	
	@Test(enabled = true, description="Verify relevant gift cards appear listed after entering existing card holder name in User Name")
	public void tc32_verifyUserNameFilter() {
		giftCardDashboard.clickOnFilter();
		String userName="Lucas";
		giftCardDashboard.enterUserName(userName);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.isAllCardHolderName(userName));
	}
	
	@Test(enabled = true, description="Verify information message appear after entering non existing number in User Number/Email")
	public void tc33_verifyUserNameFilterNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("+918547659428");
		giftCardDashboard.clickOnApply();
		Assertions.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
	}
	
	@Test(enabled = true, description="Verify information message appear after entering non existing email in User Number/Email")
	public void tc34_verifyUserEmialFilterNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("demo@yopmail.com");
		giftCardDashboard.clickOnApply();
		Assertions.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
	}
	
	@Test(enabled = true, description="Verify relevant gift cards appear listed after entering date in date field")
	public void tc35_verifyDateRangeField() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String startDate="07/01/2023";
		String endDate="07/31/2023";
		giftCardDashboard.enterDate(startDate+" - "+endDate);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.areAllGiftCardOfRange(giftCardDashboard.getGiftIssuedate(),startDate,endDate));
		}
	
	@Test(enabled = true, description="Verify infromation message appear after non exsisting entering date in date field")
	public void tc36_verifyDateRangeFieldNonExsisting() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String startDate="05/01/2022";
		String endDate="12/31/2022";
		giftCardDashboard.enterDate(startDate+" - "+endDate);
		giftCardDashboard.clickOnApply();
		Assertions.assertEquals(giftCardDashboard.getResultNotFoundMessage(),"There are no results");
		}
	
	@Test(enabled = true, description="Verify validation message appears after entering characters in 'Date' field")
	public void tc37_verifyValidationDateRange() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterDate("date");
		giftCardDashboard.clickOnApply();
		giftCardDashboard.clickOnCloseValidation();
		Assertions.assertEquals(giftCardDashboard.getDateRangeToolTipMessage(),"Invalid date range");
		}
	
	@Test(enabled = true, description="Verify 'Gift card status' dropdown appears 'Active' by default")
	public void tc38_verifyGiftCardStatusDefaultSelection() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		Assertions.assertEquals(giftCardDashboard.getSelectedGiftCardStatus(),"Active");
		}
	
	@Test(enabled = true, description="Verify all options appear in 'Gift card status' dropdown, after clicking 'Gift card status' dropdown")
	public void tc39_verifyGiftCardStatusAllOptions() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		List<String> options=new ArrayList<String>();
		options.add("");
		options.add("Active");
		options.add("Blocked");
		options.add("Expired");
		options.add("No Balance");
		options.add("Pending transfer");
		Assertions.assertTrue(options.equals(giftCardDashboard.getAllGiftCardStatusOptions()));
		}
	
	@Test(enabled = true, description="Verify all existing active gift cards appear listed, after selecting 'Active' option from 'Gift card status' dropdown")
	public void tc40_verifyGiftCardStatusFilterActive() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		giftCardDashboard.selectGiftCardStatues("Active");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkStatus("Active"));
		}
	
	@Test(enabled = true, description="Verify all existing blocked gift cards appear listed, after selecting 'Blocked' option from 'Gift card status' dropdown")
	public void tc41_verifyGiftCardStatusFilterBlocked() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		giftCardDashboard.selectGiftCardStatues("Blocked");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkStatus("Blocked"));
		}
	
	@Test(enabled = true, description="Verify all existing expired gift cards appear listed, after selecting 'Expired' option from 'Gift card status' dropdown")
	public void tc42_verifyGiftCardStatusFilterExpired() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		giftCardDashboard.selectGiftCardStatues("Expired");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkStatus("Expired"));
		}
	
	@Test(enabled = true, description="Verify all existing pending transfer gift cards appear listed, after selecting 'Pending Activation' option from 'Gift card status' dropdown")
	public void tc43_verifyGiftCardStatusFilterPendingActivation() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		giftCardDashboard.selectGiftCardStatues("Pending transfer");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkStatus("Pending transfer"));
		}
	
	@Test(enabled = true, description="Verify all existing No Balance gift cards appear listed, after selecting 'Pending Activation' option from 'Gift card status' dropdown")
	public void tc44_verifyGiftCardStatusFilterNoBalance() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.clickOnGiftCardStatusField();
		giftCardDashboard.selectGiftCardStatues("No Balance");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkStatus("No Balance"));
		}
	
	
	@Test(enabled = true, description="Verify that relevant gift cards appear listed after entering value in 'Min Amount' under 'Filter' link, on 'Gift Cards Dashboard' page.")
	public void tc45_verifyMinAmountFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String minAmt="500";
		giftCardDashboard.enterMinAmount(minAmt);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkAmtGreaterThanMinAmt(minAmt));
		}
	
	@Test(enabled = true, description="Verify that relevant gift cards appear listed after entering value in 'Min Amount' under 'Filter' link, on 'Gift Cards Dashboard' page.")
	public void tc46_verifyMaxAmountFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String maxAmt="2000";
		giftCardDashboard.enterMaxAmount(maxAmt);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkAmtLessThanMaxAmt(maxAmt));
		}
	
	@Test(enabled = true, description="Verify that relevant gift cards appear listed after entering value in 'Min Amount' and 'Max Amount' 'under 'Filter' link, on 'Gift Cards Dashboard' page.")
	public void tc47_verifyMinAndMaxAmountFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String minAmt="800";
		String maxAmt="4000";
		giftCardDashboard.enterMinAmount(minAmt);
		giftCardDashboard.enterMaxAmount(maxAmt);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkAmtBetweenMinAndMaxAmt(minAmt,maxAmt));
		}
	
	
	@Test(enabled = true, description="Verify that information message appears after entering non existing card number in 'Card Number Partial field")
	public void tc48_verifyNonExsistingCardNoFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String giftCardDetails="9874569844584";
		giftCardDashboard.enterCardNo(giftCardDetails);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.getResultNotFoundMessage().equalsIgnoreCase("There are no results"));
	}
	
	@Test(enabled = true, description="Verify validation message appears after entering less than 4 digit card number in 'Card Number Partial field")
	public void tc49_verifyValidationCardNoFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String giftCardDetails="123";
		giftCardDashboard.enterCardNo(giftCardDetails);
		giftCardDashboard.clickOnApply();
		Assertions.assertEquals(giftCardDashboard.getCardNoToolTipMessage(),"Please enter at least 4 characters.");
	}
	
	@Test(enabled = true, description="Verify that information message appears after entering non existing card number in 'Card Number Partial field")
	public void tc50_verifyValidationForAllFilterField() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserName("Sam");
		giftCardDashboard.enterUserPhoneEmail("sam@yopmail.com");
		giftCardDashboard.enterDate("08/02/2021 - 08/31/2021");
		giftCardDashboard.enterMinAmount("10000");
		giftCardDashboard.enterMaxAmount("20000");
		giftCardDashboard.enterCardNo("597749");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.getResultNotFoundMessage().equalsIgnoreCase("There are no results"));
	}
	
	@Test(enabled = true, description="Verify relevant gift cards appear listed after entering any existing gift card number in 'Card Number Partial field ")
	public void tc51_verifyExsistingCardNoFilter() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		String giftCardDetails="123654789663252145";
		giftCardDashboard.enterCardNo(giftCardDetails);
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.checkCardNo(giftCardDetails));
		
	}
	
	@Test(enabled = true, description="Verify that total count and total amount of gift cards appears, on 'Gift Cards Dashboard' page")
	public void tc52_verifyTotalCountAndTotalAmtAppearance() {
		Assertions.assertTrue(giftCardDashboard.isotalCountAndTotalAmtDisplayed());
	}
	
	@Test(enabled = true, description="Verify that 'Gift Card Detail' page opens up on new tab, after clicking on 'External-Link' icon, on ''Gift Card Details' popup")
	public void tc53_verifyExternalLink() {
		dashboard.clickOnGiftCardsDashboard(); 
		giftCardDashboard.clickOnGiftCard();
		giftCardDetails.clickOnExternalLink();
		giftCardDetails.switchToWindow("Gift Card Detail Page");
		Assertions.assertEquals(giftCardDetails.getPageTitle(), "Gift Card Detail");
		giftCardDetails.switchToWindow("Parent Window");
	}
	
	@Test(enabled = true, description="Verify that 'Gift Cards For Sale' page opens up after clicking on 'Gift card for sale' link on 'Gift Cards Dashboard' page.")
	public void tc54_verifyGiftCardsForSalePage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		Assertions.assertEquals(giftCardForSale.getPageTitle(), "Gift Cards For Sale");
	}
	
	@Test(enabled = true, description="Verify that 'Status' dropdown appears after clicking on 'Filter' link, on 'Gift Cards For Sale' page.")
	public void tc55_vertifyFilterLink() {
		giftCardForSale.clickOnFilterLink();
		Assertions.assertTrue(giftCardForSale.isStatusDropdownDisplayed());
	}
	
	@Test(enabled = true, description="Verify default status option, 'Available' and 'All' option appears after clicking on 'Status' dropdown")
	public void tc56_verifyStatusOptions() {
		dashboard.clickOnGiftCardsDashboard(); 
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnFilterLink();
		giftCardForSale.clickOnStatus();
		String defaultOptn="Available";
		Assertions.assertTrue(giftCardForSale.defaultSelectedOption(defaultOptn));
		List<String> options=new ArrayList<String>();
		options.add("Available");
		options.add("All");
		Assertions.assertTrue(giftCardForSale.areStatusOptionMatching(options));
	}
	
	@Test(enabled = true, description="Verify that all exsisting gift cards appear after clicking on 'Apply' button, when 'All' option is selected from 'Status' dropdown")
	public void tc57_verifyAllGiftAppearWhenAllStatusIsSelected() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnFilterLink();
		giftCardForSale.clickOnStatus();
		giftCardForSale.selectStatusByText("All");
		giftCardForSale.clickOnApply();
		Assertions.assertTrue(giftCardForSale.areQuantityMoreThanEqualToZero());
	}
	
	@Test(enabled = true, description="Verify that all exsisting gift cards appear after clicking on 'Apply' button, when 'All' option is selected from 'Status' dropdown")
	public void tc58_verifyAllGiftAppearWhenAllStatusIsSelected() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnFilterLink();
		giftCardForSale.clickOnStatus();
		giftCardForSale.selectStatusByText("Available");
		giftCardForSale.clickOnApply();
		Assertions.assertTrue(giftCardForSale.areQuantityMoreThanZero());
	}
	
	@Test(enabled = true, description="Verify that 'Copied' tooltip message appear after clicking on 'Copy the URL' link, on 'Gift Cards For Sale' page.")
	public void tc59_verifyCopyUrlLink() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnCopyUrl();
		Assertions.assertEquals(giftCardForSale.getCopyUrlToolTipMessage(), "Copied");
	}
	@Test(enabled = true, description="Verify that 'Add Gift Card' page opens afeter clicking on 'Add' link , on 'Gift Cards For Sale' page.")
	public void tc60_verifyAddLink() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		Assertions.assertEquals(giftCardForSale.getPageTitle(), "Gift Cards For Sale");
		}
	
	@Test(enabled = true, description="Verift validation message appear after clicking on 'Save Changes' button, when 'Gift card amount' text field is left blank")
	public void tc61_verifyGiftCardAmtValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardAmtToolTipMessage(),"This field is required.");
		}
	
	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when 'Gift card sale price' text field is left blank")
	public void tc62_verifyGiftCardForSalePageValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardSalePriceTipMessage(),"This field is required.");
		}
	

	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when 'Available quantity for sale' text field is left blank")
	public void tc63_verifyAvailableQtyValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getAvailableQtyForSaleTipMessage(),"This field is required.");
		}
	
	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when when '0' is entered in 'Gift card amount' text field")
	public void tc64_verifyGiftCardAmtValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterGiftCardAmt("0");
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardAmtToolTipMessage(),"Please enter a value greater than or equal to 1.");
		}
	
	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when 'Gift card sale price' text field is left blank")
	public void tc65_verifyGiftCardForSalePageValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterGiftCardSaleprice("0");
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardSalePriceTipMessage(),"Please enter a value greater than or equal to 1.");
		}
	

	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when 'Available quantity for sale' text field is left blank")
	public void tc66_verifyAvailableQtyValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterAvailableQty("0");
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getAvailableQtyForSaleTipMessage(),"Please enter a value greater than or equal to 1.");
		}
	
	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when value entered in 'Gift card amount' text field is more than configured amount")
	public void tc67_verifyGiftCardAmtValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterGiftCardAmt("10000");
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardAmtToolTipMessage(),"Please enter a value less than or equal to 4999.");
		}
	
	
	@Test(enabled = true, description="Verift that validation message appear after clicking on 'Save Changes' button, when value entered in 'Gift card sale price'  is more than configured amount")
	public void tc68_verifyGiftCardForSalePageValidationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterGiftCardSaleprice("10000");
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(addGiftCard.getGiftCardSalePriceTipMessage(),"Please enter a value less than or equal to 7498.5.");
		}
	
	@Test(enabled = true, description="Verify that 'Available quantity for sale' field accepts value up to 4 digits, on 'Add Gift Card' page.")
	public void tc69_verifyAvailableQtyMaxLengthMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterAvailableQty("15987");
		addGiftCard.clickOnSaveChange();
		Assertions.assertTrue(addGiftCard.getTextAvailableQty().length()==4);
		}
	
	@Test(enabled = true, description="Verify that gift card successfully gets created after entering the valid data in mandatory fields, on 'Gift Card For Sale' page.")
	public void tc70_selectDateRange() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.clickOnDateRange();
		addGiftCard.selectCurrentDate();
		addGiftCard.selectNextMonthDate();
		Assertions.assertTrue(addGiftCard.getSaleDateRange()!=null);
		}
	
	@Test(enabled = true, description="Verify that gift card successfully gets created after entering the valid data in mandatory fields, on 'Gift Card For Sale' page.")
	public void tc71_verifySuccesfulCreationOfGiftCard() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.enterGiftCardAmt("100");
		addGiftCard.enterGiftCardSaleprice("80");
		addGiftCard.enterAvailableQty("5");
		addGiftCard.ScrollDownThePageMax();
		addGiftCard.clickOnDateRange();
		addGiftCard.selectCurrentDate();
		addGiftCard.selectNextMonthDate();
		addGiftCard.clickOnSaveChange();
		Assertions.assertEquals(giftCardForSale.getToastMessage(), "Data saved successfully!");
		}
	
	@Test(enabled = true, description="verify that 'There are 3.00 % fee on all sold gift cards.' information message appear on the 'Add Gift Card' page.")
	public void tc72_verifyInformationMessage() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCardForSaleLink();
		giftCardForSale.clickOnAddLink();
		addGiftCard.isAleartMessagePresent();
		Assertions.assertEquals(addGiftCard.getAlertMessage(), "There are 3.00 % fee on all sold gift cards.");
		}
	
	
	@Test(enabled = true, description="Verify that 'Edit Gift Card' page opens after clicking on a record from grid, on 'Gift Cards Dashboard' page. ")
	public void tc73_verifyEditIcon() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCard();
		giftCardDetails.clickOnInfoIcon();
		giftCardDetails.clickOnEditIcon();
		Assertions.assertTrue(giftCardDetails.isFundingSourceTbxPresent());
		Assertions.assertTrue(giftCardDetails.isRefNoTbxPresent());
		Assertions.assertTrue(giftCardDetails.isMemoTbxPresent());
		Assertions.assertTrue(giftCardDetails.isStartDateTbxPresent());
		Assertions.assertTrue(giftCardDetails.isExpDateTbxPresent());
		giftCardDetails.clickOnClose();
		}
	
	@Test(enabled = true, description="Verify that 'Blocked' button appear after clicking on 'Active' button, on 'Card Details' popup.")
	public void tc74_verifyBlockButton() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnGiftCard();
		giftCardDetails.clickOnActiveBtn();
		Assertions.assertTrue(giftCardDetails.isBlockBtnPresent());
		giftCardDetails.clickOnClose();
}

	@Test(enabled = true, description="Verify that relevant gift cards appear listed after entering any existing customer emailm in 'User email' field under 'Filter' link.")
	public void tc75_verifyUserEmailFilterField() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("testkade@yopmail.com");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.getFilterResultCount()>0);
	}
	
	@Test(enabled = true, description="Verify that relevant gift cards appear listed after entering any existing customer phone number in 'User Phone' field under 'Filter' link.")
	public void tc76_verifyUserPhoneFilterField() {
		dashboard.clickOnGiftCardsDashboard();
		giftCardDashboard.clickOnFilter();
		giftCardDashboard.enterUserPhoneEmail("+918877070727");
		giftCardDashboard.clickOnApply();
		Assertions.assertTrue(giftCardDashboard.getFilterResultCount()>0);
	}
}