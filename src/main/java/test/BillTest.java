package test;

import java.util.List;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BillEditPopup;
import org.automation.pageObjects.BillPage;
import org.automation.pageObjects.BillViewPopup;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.NewBillPopUp;
import org.automation.pageObjects.RefundPage;
import org.automation.pageObjects.TransactionsPage;
import org.automation.pageObjects.UpdateBillPopUp;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillTest extends BaseTest{
	
	LoginPage login= new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	BillPage bill = new BillPage();
	BillEditPopup editPopup=new BillEditPopup();
	BillViewPopup billView=new BillViewPopup();
	RefundPage refund=new RefundPage();
	UpdateBillPopUp update = new UpdateBillPopUp();
	TransactionsPage transactions=new TransactionsPage();

	@BeforeMethod
	public void navigateToBill(){
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnBill();
	}

	@AfterMethod
	public void logout(){
		dashboard.signOut();
	}
	
	@Test(enabled = true, description="Verify that user gets directed to Bills page.")
    public void tc01_verifyBillButton(){
		WebdriverWaits.waitForPageTitle("Bills",5);
		String pageTitle = bill.getPageTitle();
	 	Assert.assertEquals(pageTitle,"Bills");
		Assert.assertTrue(bill.isNewBillBtnDisplayed());
		Assert.assertTrue(bill.isTransactionLinkDisplayed());
	}
	
	@Test(enabled = true, description="Verify the Elements on the New Bill Popup and default values")
	public void tc02_createNewBillPopup() {
		bill.clickOnNewBill();
		Assert.assertEquals(bill.getPopUpTitle(), "Bill");
		Assert.assertTrue(bill.isAmountTbxDisplayed());
		Assert.assertTrue(bill.isDescriptionDisplayed());
		Assert.assertTrue(bill.isCustomerFieldDisplayed());
		Assert.assertTrue(bill.isMoreOptionDisplayed());
		bill.CloseBillPopup();
	}

	@Test(enabled = true, description = "Verfiy the amount field on Bill popup")
	public void tc03_verifyAmountField() throws  Exception{
		bill.clickOnNewBill();
		String defaultAmt = bill.getAttribute(bill.amtInput,"value");
		Assert.assertEquals(defaultAmt,"$0.00");

		//Try entering bill amount 999.99
		bill.enterAmount("999.99");  // Assertion for the entered amount

		// Verify optional field
		String expectedDescription = "Description (optional)";
		String actualDescription = bill.getAttribute(bill.addBillDescription,"placeholder");
		Assert.assertEquals(actualDescription,expectedDescription);

		// Verify default customer selected
		String defaultCustomrt = bill.getSelectedCustomer();
		Assert.assertEquals(defaultCustomrt,"None");
		bill.CloseBillPopup();
	}

	@Test(enabled = true, description="Verify validations and fields present in Customer popup")
	public void tc04_verifyCustomerPopup() throws InterruptedException {
		bill.clickOnNewBill();

		// Verify Customer popup
		bill.clickCustomer();
		String customerPopupHeader = bill.getCustomerHeader();
		Assert.assertEquals(customerPopupHeader,"Customer");

		//Verify fields on customer popup
		Assert.assertTrue(bill.isWebElementVisible(bill.phoneNoTbx));
		Assert.assertTrue(bill.isWebElementVisible(bill.emailTbx));
		Assert.assertTrue(bill.isWebElementVisible(bill.searchTbx));

		// Verify the validation message phone no
		bill.clickOnGoBtnPhoneNo();
		String phnNoValidation = bill.getToolTipMessagePhoneNumber();
		Assert.assertEquals(phnNoValidation,"This field is required.");

		// Verify the validation message email
		bill.clickOnGoBtnEmail();
		String emailValidation = bill.getToolTipMessageEmail();
		Assert.assertEquals(emailValidation,"This field is required.");

		// Verify Validation message for invalid email
		bill.enterCustomerEmail("invalidemail");
		bill.clickOnGoBtnEmail();
		emailValidation = bill.getToolTipMessageEmail();
		Assert.assertEquals(emailValidation,"Please enter a valid email address.");

		//Suggestion List on Customer popup
		boolean isSuggestionDisplayed = bill.isWebElementVisible(bill.suggestionList);
		Assert.assertTrue(isSuggestionDisplayed);
		bill.closeCustomerPopup();
		bill.CloseBillPopup();
	}

	@Test(enabled = true, description="Verify search textbox")
	public void tc05_verifyInfoMsgOnBill(){
		bill.clickOnNewBill();
		bill.clickCustomer();
		bill.searchCustomer("Alexander"+ Keys.ENTER);
		String nonExistingInfoMsg = bill.getInfoMessage();
		Assert.assertEquals(nonExistingInfoMsg,"There are no results");

		// Verify search for existing customer
		bill.searchCustomer("Steven"+Keys.ENTER);
		String serachResult = bill.getSearchedCustomer();
		Assert.assertEquals(serachResult,"Steven");
	}




//	@Test(enabled = true, description="Verify validation message of SubTotal field, When subTotal field is left blank")
//	public void tc03_verifySubTotalValidation() {
//		bill.clickOnCreate();
//		bill.moveToSubTotal();
//		Assert.assertEquals(bill.getToolTipMessage(), "Please enter a value greater than or equal to 0.01.");
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verify CustName and Memo field appears after More toggle button is turned On")
//	public void tc04_moreDetailsToggleBtn() {
//		bill.clickOnNewBill();
//		bill.switchOnMoreToggleBtn();
//		Assert.assertTrue(bill.isCustNamePresent());
//		Assert.assertTrue(bill.isMemoPresent());
//	}
//
//	@Test(enabled = true, description="Verify RefNo. textbox appears after AutoGenarate toggle button is turned Off")
//	public void tc05_autoGenerateToggleBtn(){
//		bill.switchOffAutoGenToggle();
//		Assert.assertTrue(bill.isRefNoTextFieldPresent());
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verify validation message appears after entering amount more than configured amount")
//		public void tc06_verifyValidationForAmountMoreThanConfigure() throws InterruptedException {
//		bill.clickOnNewBill();
//		Thread.sleep(1000);
//		bill.enterSubTotalAmount(5000);
//		bill.clickOnCreate();
//		bill.moveToSubTotal();
//		Assert.assertEquals(bill.getToolTipMessage(), "Please enter a value less than or equal to 3000.");
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verify Description and Price textbox appeares after clicking AddBillDetail page")
//	public void tc07_verifyAddBillDetailLink() {
//		bill.clickOnNewBill();
//		bill.clickOnAddBillDetail();
////		Assert.assertTrue(bill.isDescriptionPresent());
//		Assert.assertTrue(bill.isPricePresent());
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verifying that validation appears after invalid phone number is entered in Customer Phone Number")
//	public void tc08_validationInvalidCustPhoneNumber() {
//		bill.clickOnNewBill();
//		bill.createBill(520, "77510247", "kade@yopmail.com", "Jhon", "");
//		Assert.assertEquals(bill.getToolTipMessagePhoneNumber(),"Invalid phone number");
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verifying that validation appears after invalid Email is entered in Customer Email")
//	public void tc09_validationInvalidCustEmail() {
//		bill.clickOnNewBill();
//		bill.createBill(229, "+917077510247", "invalidMail", "Harry", "Recipt");
//		Assert.assertEquals(bill.getToolTipMessageEmail(),"Please enter a valid email address.");
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verify that tooltip message appears on hovering over memo icon")
//	public void tc10_memoToolTipMessage() throws InterruptedException {
//		String memoMsg = "Lorem ipsum dolor sit amet";
//		bill.clickOnNewBill();
//		bill.createBill(450, "", "", "Name", memoMsg);
//		bill.closeToastBtn();
//		billView.clickOnCloseBtn();
//		bill.refreshPage();
//		Assert.assertEquals(bill.getToolTipMemo(), memoMsg);
//	}
//
//	@Test(enabled = false, description="")  // Price field is filled by using javaScript Code so Sub Total Value is not updated
//	public void tc11_addBillPriceField() {					// It has to be discussed and fixed
//		bill.clickOnNewBill();
//		bill.clickOnAddBillDetail();
//		int value1=50;
//		int value2=100;
//		bill.enterBillDetailValue1("product1", value1);
//		bill.enterBillDetailValue2("product2", value2);
//		Assert.assertEquals(bill.getSubTotalValue(), value1+value2);
//		bill.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description="Verify Alert box disappears after clicking on close icon")
//	public void tc12_alertMessageBox(){
//		bill.closeBtn();
//		Assert.assertFalse(bill.isTransactionDisplayed());
//	}
//
//	@Test(enabled = true, description="Verify successful creation of bill")
//	public void tc13_createANewBill()  {
//		int actualCount = bill.getCountOfAllBill();
//		bill.refreshPage();
//		bill.clickOnNewBill();
//		bill.switchOnAutoGenToggle();
//		bill.enterSubTotalAmount(799);
//		bill.enterPhoneNumber("+918877070727");
//		bill.enterCustomerEmail("test2023@yopmail.com");
//		bill.switchOnMoreToggleBtn();
//		bill.enterCustomerName("Sara");
//		bill.enterMemo("Recipt");
//		bill.clickOnCreate();
//		Assert.assertEquals(bill.getToastMessage(), "New bill created successfully");
//		bill.closeToastBtn();
//		billView.clickOnCloseBtn();
//		Assert.assertEquals(bill.getCountOfAllBill(), actualCount+1);
//	}
//
//	@Test(enabled = true, description = "Verify fields of Filter Section")
//	public void tc14_verifyBillFilterFunctionality() {
//		bill.clickOnFilter();
//		Assert.assertTrue(bill.isDateFieldPresent());
//		Assert.assertTrue(bill.isCustomerNamePresent());
//		Assert.assertTrue(bill.isUserPhoneFieldPresent());
//		Assert.assertTrue(bill.isEmailFieldPresent());
//		bill.clickOnApply();
//		Assert.assertTrue(bill.getCountOfAllBill()>0);
//		}
//
//	@Test(enabled = true, description = "Verify customer name filter Functionality")
//	public void tc15_verifyCustomerNameFilter() {
//		dashboard.clickOnBill();
//		bill.clickOnFilter();
//		bill.enterCustomerName("Ana");
//		bill.clickOnApply();
//		Assert.assertTrue(bill.checkFieldContains("Ana"));
//	}
//
//	@Test(enabled = true, description = "Verify partial customer name filter Functionality")
//	public void tc16_verifyPartialCustomerNameFilter() {
//		bill.clickOnFilter();
//		bill.enterCustomerName("An");
//		bill.clickOnApply();
//		Assert.assertTrue(bill.checkFieldContains("An"));
//	}
//
//	@Test(enabled = true, description = "Verify User Phone filter Functionality")
//	public void tc17_verifyUserPhoneFilter() {
//		dashboard.clickOnBill();
//		long expectedCount=bill.countOfUserPhonePresent("+918877070727");
//		bill.clickOnFilter();
//		bill.enterUserNumber("+918877070727");
//		bill.clickOnApply();
//		long actualCount = bill.countOfUserPhonePresent("+918877070727");
//		Assert.assertEquals(actualCount, expectedCount);
//	}
//
//	@Test(enabled = true, description = "Verify invalid User Phone validation message")
//	public void tc18_invalidUserPhoneFilterValidation() {
//		dashboard.clickOnBill();
//		bill.clickOnFilter();
//		bill.enterUserNumber("77070727");
//		bill.clickOnApply();
//		Assert.assertEquals(bill.getToolTipUserPhone(), "Invalid phone number");
//	}
//
//	@Test(enabled = true, description = "Verify User Email filter Functionality")
//	public void tc19_verifyUserEmailFilter() {
//		dashboard.clickOnBill();
//		long expectedCount=bill.countOfUserEmailPresent("michal@yopmail.com");
//		bill.clickOnFilter();
//		bill.enterUserEmail("michal@yopmail.com");
//		bill.clickOnApply();
//		long actualCount = bill.countOfUserEmailPresent("michal@yopmail.com");
//		Assert.assertEquals(actualCount, expectedCount);
//	}
//
//	@Test(enabled = true, description = "Verify From filter Functionality")
//	public void tc20_verifyFromFilter() {
//		dashboard.clickOnBill();
//		bill.clickOnFilter();
//		bill.enterFrom("06/01/2023","07/05/2023");
//		List<String> billDate=bill.getDateOfBill();
//		bill.verifyRecordsDateRange(billDate,"06/01/2023","07/05/2023");
//	}
//
//
//	@Test(enabled = true, description = "Verify filter Functionality when no exsixting records are matching")
//	public void tc21_verifyFilterWhenNoRecordMatch() {
//		dashboard.clickOnBill();
//		long expectedCount=bill.countOfUserEmailPresent("abc@yopmail.com");
//		bill.clickOnFilter();
//		bill.enterUserEmail("abc@yopmail.com");
//		bill.clickOnApply();
//		long actualCount = bill.countOfUserEmailPresent("abc@yopmail.com");
//		Assert.assertEquals(actualCount, expectedCount);
//		Assert.assertEquals(bill.getInfoMessage(), "There are no results");
//	}
//
//	@Test(enabled = true, description = "Verify validation message when invalid email is entered in User Email field")
//	public void tc22_validationOnInvalidEmailInFilter() throws InterruptedException {
//		dashboard.clickOnBill();
//		bill.clickOnFilter();
//		bill.enterUserEmail("bobby");
//		bill.clickOnApply();
//		Assert.assertEquals(bill.getEmailToolTiptMessage(), "Please enter a valid email address.");
//	}
//
//	@Test(enabled = true, description = "Verify bill view popup appears on clicking on a bill")
//	public void tc23_billViewPopup() {
//		dashboard.clickOnBill();
//		bill.clickOnBill();
//		Assert.assertTrue(bill.isBillViewPopUpHeaderPresent());
//		billView.clickOnCloseBtn();
//		Assert.assertTrue(bill.isTransactionDisplayed());
//	}
//
//	@Test(enabled = true, description = "Verify successfull Bill deletion")
//	public void tc24_deleteBill() {
//		String refNo = bill.getFirstRefNoBillDisplayed();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnDeleteBtn();
//		billView.clickOnConfirmIcon();
//		Assert.assertTrue(bill.isRefNoPresent(refNo));
//
//	}
//
//	@Test(enabled = true, description = "Verify QR code appears on clicking QR code button")
//	public void tc25_qrCodeShare() {
//		bill.clickOnNewBill();
//		bill.createBill(500, "+917077510247", "david@yopmail.com", "David", "Gross Bill");
//		billView.clickOnQrCode();
//		Assert.assertTrue(billView.isQrPresent());
//		bill.closeToastBtn();
//		billView.closeQrCodePopup();
//		billView.clickOnDeleteBtn();
//		billView.clickOnConfirmIcon();
//	}
//
//	@Test(enabled = true, description = "Verify invite code appears on clicking invite button")
//	public void tc26_inviteCode() {
//		bill.clickOnNewBill();
//		bill.createBill(299, "+919122324663", "paul@yopmail.com", "Paul", "Bill");
//		billView.clickOnInvite();
//		Assert.assertTrue(billView.isInviteCodePresent());
//		bill.closeToastBtn();
//		billView.clickOnDeleteBtn();
//		billView.clickOnConfirmIcon();
//	}
//
//	@Test(enabled = true, description = "Verify Transaction page opens on clicking Transactions link")
//	public void tc27_transactionPage() {
//		bill.clickOnTransactions();
//		Assert.assertEquals(transactions.getPageTitle(), "Transactions");
//		dashboard.clickOnBill();
//	}
//
//	@Test(enabled = true, description = "Veriy paid bill appears on the bill grid")
//	public void tc28_verifyPaidBills() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		Assert.assertTrue(billView.isLinkPresent());
//		Assert.assertEquals(billView.getLableText(), "Paid");
//		billView.clickOnCloseBtn();
//	}
//
//	@Test(enabled = true, description = "Verify refund page")
//	public void tc29_refundPage() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		billView.clickOnAmountLink();
//		Assert.assertTrue(refund.isRefundBtnPresent());
//		refund.clickOnRefund();
//		Assert.assertTrue(refund.isRefNoTextBoxPresent());
//		Assert.assertTrue(refund.isReasonTextBoxPresent());
//	}
//
//	@Test(enabled = true, description = "Verify message when reason field is left blank")
//	public void tc30_validationWhenReasonFieldLeftBlank() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		billView.clickOnAmountLink();
//		refund.clickOnRefund();
//		refund.clickOnProcessFullRefund();
//		Assert.assertEquals(refund.getReasonToolTip(), "This field is required.");
//		refund.closeValidationMessage();
//	}
//
//	@Test(enabled = true, description = "Verify partial refund button behavior")
//	public void tc31_verifyPartialRefundLink() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		billView.clickOnAmountLink();
//		refund.clickOnRefund();
//		refund.clickOnPartialRefundLink();
//		Assert.assertTrue(refund.isCheckBoxPresent());
//		refund.checkCheckBox();
//		Assert.assertTrue(refund.isRefundAmountTextBoxPresent());
//	}
//
//	@Test(enabled = true, description = "Varify Refund Amount text box validation when value more than configurerd amount")
//	public void tc32_RefundAmountTextBox() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		billView.clickOnAmountLink();
//		refund.clickOnRefund();
//		refund.clickOnPartialRefundLink();
//		refund.checkCheckBox();
//		refund.enterRefundAmount(2999);
//		refund.clickOnProcessRefund();
//		refund.closeValidationMessage();
//		Assert.assertEquals(refund.getRefundToolTipMessage(),"Please enter a value less than or equal to 499.");
//
//	}
//
//	@Test(enabled = true, description = "Verify validation message when ")
//	public void tc33_validationWhenZeroRefundAmount() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstPaidBills();
//		billView.clickOnAmountLink();
//		refund.clickOnRefund();
//		refund.clickOnPartialRefundLink();
//		refund.checkCheckBox();
//		refund.enterRefundAmount(0);
//		refund.clickOnProcessRefund();
//		refund.closeValidationMessage();
//		Assert.assertEquals(refund.getRefundToolTipMessage(), "Please enter a value greater than or equal to 0.01.");
//	}
//
//	@Test(enabled = true, description = "Verify Update Popup")
//	public void tc34_verifyUpdatePopup() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnEditBtn();
//		update.isAllFieldPresent();
//		update.clickOnClose();
//	}
//
//	@Test(enabled = true, description = "Verify Bill amount textbox")
//	public void tc35_updateBillAmount() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnEditBtn();
//		update.enterSubTotalAmount(500);
//		update.clickOnUpdateBtn();
//		Assert.assertEquals(bill.getToastMessage(), "Bill updated successfully");
//		bill.closeToastBtn();
//	}
//
//	@Test(enabled = true, description = "Verify Edit bill button")
//	public void tc36_validationSubTotalAmountUpdate() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnEditBtn();
//		update.enterSubTotalAmount(0);
//		update.clickOnUpdateBtn();
//		Assert.assertEquals(update.getSubTotalToolTipMsg(), "Please enter a value greater than or equal to 0.01.");
//		update.clickOnClose();
//	}
//
//	@Test(enabled = true, description = "Verify add bill detail link")
//	public void tc37_addBillDetailLinkUpdatePopup() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnEditBtn();
//		update.clickOnAddBillDetailLink();
//		Assert.assertTrue(update.isDescriptionFieldDisplayed());
//		Assert.assertTrue(update.isPriceFieldDisplayed());
//		update.clickOnClose();
//	}
//
//	@Test(enabled = true, description = "Verify more details toggle button")
//	public void tc38_moreDetailToggleUpdatePopup() {
//		dashboard.clickOnBill();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnEditBtn();
//		update.switchOnMoreDetailsToggle();
//		Assert.assertTrue(update.isCustomerNameDisplayed());
//		Assert.assertTrue(update.isMemoTbxDisplayed());
//		update.clickOnClose();
//	}
//
//	@Test(enabled = true, description = "Verify successfull Bill deletion")
//	public void tc39_deleteBill() {
//		dashboard.clickOnBill();
//		String refNo = bill.getFirstRefNoBillDisplayed();
//		bill.clickOnFirstUnPaidBills();
//		billView.clickOnDeleteBtn();
//		billView.clickOnConfirmIcon();
//		Assert.assertTrue(bill.isRefNoPresent(refNo));
//
//	}
	
}

