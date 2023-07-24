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
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillTest extends BaseTest{
	
	LoginPage login= new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	BillPage bill = new BillPage();
	BillEditPopup editPopup=new BillEditPopup();
	NewBillPopUp newBill=new NewBillPopUp();
	BillViewPopup billView=new BillViewPopup();
	RefundPage refund=new RefundPage();
	UpdateBillPopUp update = new UpdateBillPopUp();
	
	@Test(priority = -1, enabled = true, description="")
    public void verifyBillButton() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnBill();
	 	Assert.assertEquals(bill.getPageTitle(), "Bills");		//Verify page title
	}
	
	@Test(priority = 1, enabled = true, description="Verify the Elements on the New Bill Popup")
	public void createNewBillPopup() {
		bill.clickOnNewBill();
		Assert.assertEquals(newBill.getPopUpTitle(), "Create A Bill");
		newBill.isElementsPresent();
	}
	
	@Test(priority = 2, enabled = true, description="Verify validation message of SubTotal field, When subTotal field is left blank")
	public void verifySubTotalValidation() {
		newBill.clickOnCreate();
		newBill.moveToSubTotal();
		Assert.assertEquals(newBill.getToolTipMessage(), "Please enter a value greater than or equal to 0.01.");
		newBill.clickOnCloseBtn();
	}

	@Test(priority = 3, enabled = true, description="Verify CustName and Memo field appears after More toggle button is turned On")
	public void moreDetailsToggleBtn() {
		bill.clickOnNewBill();
		newBill.switchOnMoreToggleBtn();
		Assert.assertTrue(newBill.isCustNamePresent());
		Assert.assertTrue(newBill.isMemoPresent());
//		newBill.switchOffMoreToggleBtn();
//		Assert.asserttrue(newBill.isCustNamePresent());
//		Assert.asserttrue(newBill.isMemoPresent());
	}
	
	@Test(priority = 4, enabled = true, description="Verify RefNo. textbox appears after AutoGenarate toggle button is turned Off")
	public void autoGenerateToggleBtn(){
		newBill.switchOffAutoGenToggle();
		Assert.assertTrue(newBill.isRefNoTextFieldPresent());
		newBill.clickOnCloseBtn();
//		newBill.switchOnAutoGenToggle();
//		Assert.asserttrue(newBill.isRefNoTextFieldPresent());
//		newBill.clickOnCloseBtn();
	}
	
	@Test(priority = 5, enabled = true, description="Verify validation message appears after entering amount more than configured amount") 
		public void verifyValidationForAmountMoreThanConfigure() throws InterruptedException {
		bill.clickOnNewBill();
		Thread.sleep(1000);
		newBill.enterSubTotalAmount(5000);
		newBill.clickOnCreate();
		newBill.moveToSubTotal();
		Assert.assertEquals(newBill.getToolTipMessage(), "Please enter a value less than or equal to 3000.");
		newBill.clickOnCloseBtn();
	}

	@Test(priority = 6, enabled = true, description="Verify Description and Price textbox appeares after clicking AddBillDetail page") 
	public void verifyAddBillDetailLink() {
		bill.clickOnNewBill();
		newBill.clickOnAddBillDetail();
		Assert.assertTrue(newBill.isDescriptionPresent());
		Assert.assertTrue(newBill.isPricePresent());
		newBill.clickOnCloseBtn();
	}
	
	@Test(priority = 7, enabled = true, description="Verifying that validation appears after invalid phone number is entered in Customer Phone Number")
	public void validationInvalidCustPhoneNumber() {
		bill.clickOnNewBill();
		newBill.createBill(520, "77510247", "kade@yopmail.com", "Jhon", "");
		Assert.assertEquals(newBill.getToolTipMessagePhoneNumber(),"Invalid value");
		newBill.clickOnCloseBtn();
	}
	
	@Test(priority = 8, enabled = true, description="Verifying that validation appears after invalid Email is entered in Customer Email")
	public void validationInvalidCustEmail() {
		bill.clickOnNewBill();
		newBill.createBill(229, "+917077510247", "invalidMail", "Harry", "Recipt");
		Assert.assertEquals(newBill.getToolTipMessageEmail(),"Please enter a valid email address.");
		newBill.clickOnCloseBtn();
	}
	
	@Test(priority = 9, enabled = true, description="")
	public void memoToolTipMessage() throws InterruptedException {
		String memoMsg = "Lorem ipsum dolor sit amet";
		bill.clickOnNewBill();
		newBill.createBill(450, "", "", "Name", memoMsg);
		bill.closeToastBtn();
		billView.clickOnCloseBtn();
		bill.refreshPage();
		Assert.assertEquals(bill.getToolTipMemo(), memoMsg);
	}
	
	@Test(priority = 10, enabled = false, description="")  // Price field is filled by using javaScript Code so Sub Total Value is not updated 
	public void addBillPriceField() {					// It has to be discussed and fixed
		bill.clickOnNewBill();
		newBill.clickOnAddBillDetail();
		int value1=50;
		int value2=100;
		newBill.enterBillDetailValue1("product1", value1);
		newBill.enterBillDetailValue2("product2", value2);
		Assert.assertEquals(newBill.getSubTotalValue(), value1+value2);
		newBill.clickOnCloseBtn();
	}
	
	@Test(priority = 11, enabled = true, description="Verify Alert box disappears after clicking on close icon")
	public void alertMessageBox(){
		bill.closeBtn();
		Assert.assertFalse(bill.isTransactionDisplayed());
	}
	
	@Test(priority = 12, enabled = true, description="Verify successful creation of bill")
	public void createANewBill()  {
		int actualCount = bill.getCountOfAllBill();
		bill.refreshPage();
		bill.clickOnNewBill();
		newBill.switchOnAutoGenToggle();
		newBill.enterSubTotalAmount(799);
		newBill.enterPhoneNumber("+918877070727");
		newBill.enterCustomerEmail("test2023@yopmail.com");
		newBill.switchOnMoreToggleBtn();
		newBill.enterCustomerName("Sara");	
		newBill.enterMemo("Recipt");
		newBill.clickOnCreate();
		Assert.assertEquals(bill.getToastMessage(), "New bill created successfully");
		bill.closeToastBtn();
		billView.clickOnCloseBtn();
		Assert.assertEquals(bill.getCountOfAllBill(), actualCount+1);
	}
		
	@Test(priority = 13, enabled = true, description = "Verify fields of Filter Section")
	public void verifyBillFilterFunctionality() {
		bill.clickOnFilter();
		int expectedCount=bill.getCountOfAllBill();
		Assert.assertTrue(bill.isDateFieldPresent());	
		Assert.assertTrue(bill.isCustomerNamePresent());
		Assert.assertTrue(bill.isUserPhoneFieldPresent());
		Assert.assertTrue(bill.isEmailFieldPresent());
		bill.clickOnApply();
		Assert.assertEquals(bill.getCountOfAllBill(), expectedCount);
		}
		
	@Test(priority = 14, enabled = true, description = "Verify customer name filter Functionality")
	public void verifyCustomerNameFilter() {
		long expectedCount = bill.countOfCustNamePresent("Ana");
		bill.clickOnFilter();
		bill.enterCustomerName("Ana");
		bill.clickOnApply();
		long actualCount=bill.countOfCustNamePresent("Ana");
		Assert.assertEquals(actualCount, expectedCount);
	}
	
	@Test(priority = 15, enabled = true, description = "Verify customer name filter Functionality")
	public void verifyPartialCustomerNameFilter() {
		long expectedCount = bill.countOfCustNamePresent("An");
		bill.clickOnFilter();
		bill.enterCustomerName("An");
		bill.clickOnApply();
		Assert.assertEquals(bill.countOfPartialCustName("An"), expectedCount);
	}
	
	@Test(priority = 16, enabled = true, description = "Verify User Phone filter Functionality")
	public void verifyUserPhoneFilter() {
		dashboard.clickOnBill();
		long expectedCount=bill.countOfUserPhonePresent("+918877070727");
		bill.clickOnFilter();
		bill.enterUserNumber("+918877070727");
		bill.clickOnApply();
		long actualCount = bill.countOfUserPhonePresent("+918877070727");
		Assert.assertEquals(actualCount, expectedCount);
	}
	
	@Test(priority = 17, enabled = true, description = "Verify User Phone filter Functionality")
	public void invalidUserPhoneFilterValidation() throws InterruptedException {
		dashboard.clickOnBill();
		bill.clickOnFilter();
		bill.enterUserNumber("77070727");
		bill.clickOnApply();
		Assert.assertEquals(bill.getToolTipUserPhone(), "Invalid value");
	}
		
	@Test(priority = 18, enabled = true, description = "Verify User Email filter Functionality")
	public void verifyUserEmailFilter() {
		dashboard.clickOnBill();
		long expectedCount=bill.countOfUserEmailPresent("michal@yopmail.com");
		bill.clickOnFilter();
		bill.enterUserEmail("michal@yopmail.com");
		bill.clickOnApply();
		long actualCount = bill.countOfUserEmailPresent("michal@yopmail.com");
		Assert.assertEquals(actualCount, expectedCount);
	}
	
	@Test(priority = 19, enabled = true, description = "Verify From filter Functionality")
	public void verifyFromFilter() {
		dashboard.clickOnBill();
		bill.clickOnFilter();
		bill.enterFrom("06/01/2023","07/05/2023");
		List<String> billDate=bill.getDateOfBill();
		bill.verifyRecordsDateRange(billDate,"06/01/2023","07/05/2023");
	}

	
	@Test(priority = 20, enabled = true, description = "Verify filter Functionality when no exsixting records are matching")
	public void verifyFilterWhenNoRecordMatch() {
		dashboard.clickOnBill();
		long expectedCount=bill.countOfUserEmailPresent("abc@yopmail.com");
		bill.clickOnFilter();
		bill.enterUserEmail("abc@yopmail.com");
		bill.clickOnApply();
		long actualCount = bill.countOfUserEmailPresent("abc@yopmail.com");
		Assert.assertEquals(actualCount, expectedCount);
		Assert.assertEquals(bill.getInfoMessage(), "There are no results");
	}
	
	@Test(priority = 21, enabled = true, description = "Verify validation message when invalid email is entered in User Email field")
	public void validationOnInvalidEmailInFilter() throws InterruptedException {
		dashboard.clickOnBill();
		bill.clickOnFilter();
		bill.enterUserEmail("bobby");
		bill.clickOnApply();
		Assert.assertEquals(bill.getEmailToolTiptMessage(), "Please enter a valid email address.");
	}
	
	@Test(priority = 22, enabled = true, description = "Verify bill view popup appears on clicking on a bill")
	public void billViewPopup() {
		dashboard.clickOnBill();
		bill.clickOnBill();
		Assert.assertTrue(bill.isBillViewPopUpHeaderPresent());
		billView.clickOnCloseBtn();
		Assert.assertTrue(bill.isTransactionDisplayed());
	}
	
	@Test(priority = 23, enabled = true, description = "Verify Bill gets deleted")
	public void deleteBill() {
		String refNo = bill.getFirstRefNoBillDisplayed();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnDeleteBtn();
		billView.clickOnConfirmIcon();
		Assert.assertTrue(bill.isRefNoPresent(refNo));
		
	}
	
	@Test(priority = 24, enabled = true, description = "Verify QR code appears on clicking QR code button")
	public void qrCodeShare() {
		bill.clickOnNewBill();
		newBill.createBill(500, "+917077510247", "david@yopmail.com", "David", "Gross Bill");
		billView.clickOnQrCode();
		Assert.assertTrue(billView.isQrPresent());
		bill.closeToastBtn();
		billView.closeQrCodePopup();
		billView.clickOnDeleteBtn();
		billView.clickOnConfirmIcon();
	}
	
	@Test(priority = 25, enabled = true, description = "Verify invite code appears on clicking invite button")
	public void inviteCode() {
		bill.clickOnNewBill();
		newBill.createBill(299, "+919122324663", "paul@yopmail.com", "Paul", "Bill");
		billView.clickOnInvite();
		Assert.assertTrue(billView.isInviteCodePresent());
		bill.closeToastBtn();
		billView.clickOnDeleteBtn();
		billView.clickOnConfirmIcon();
	}
	
	@Test(priority = 26, enabled = true, description = "Verify Transaction page opens on clicking Transactions link")
	public void transactionPage() {
		bill.clickOnTransactions();
		TransactionsPage transactions=new TransactionsPage();
		Assert.assertEquals(transactions.getPageTitle(), "Transactions");
		dashboard.clickOnBill();
	}
		
	@Test(priority = 27, enabled = true, description = "Verify filter Functionality")
	public void verifyPaidBills() {
		dashboard.refreshPage();
		bill.clickOnFirstPaidBills();
		Assert.assertTrue(billView.isLinkPresent());
		Assert.assertEquals(billView.getLableText(), "Paid");
		billView.clickOnCloseBtn();
	}
	
	@Test(priority = 28, enabled = true, description = "Verify filter Functionality")
	public void refundPage() {
		bill.clickOnFirstPaidBills();
		billView.clickOnAmountLink();
		Assert.assertTrue(refund.isRefundBtnPresent());
		refund.clickOnRefund();
		Assert.assertTrue(refund.isRefNoTextBoxPresent());
		Assert.assertTrue(refund.isReasonTextBoxPresent());
	}
	
	@Test(priority = 29, enabled = true, description = "Verify filter Functionality")
	public void validationWhenReasonFieldLeftBlank() {
		refund.refreshPage();
		refund.clickOnRefund();
		refund.clickOnProcessFullRefund();
		Assert.assertEquals(refund.getReasonToolTip(), "This field is required.");
		refund.closeValidationMessage();
	}
	
	@Test(priority = 30, enabled = true, description = "Verify filter Functionality")
	public void verifyPartialRefundLink() {
		refund.refreshPage();
		refund.clickOnRefund();
		refund.clickOnPartialRefundLink();
		Assert.assertTrue(refund.isCheckBoxPresent());
		refund.checkCheckBox();
		Assert.assertTrue(refund.isRefundAmountTextBoxPresent());
	}
	
	@Test(priority = 31, enabled = true, description = "Verify filter Functionality")
	public void RefundAmountTextBox() {
		refund.refreshPage();
		refund.clickOnRefund();
		refund.clickOnPartialRefundLink();
		refund.checkCheckBox();
		refund.enterRefundAmount(2999);
		refund.clickOnProcessRefund();
		refund.closeValidationMessage();
		Assert.assertTrue(refund.getRefundToolTipMessage().contains("Please enter a value less than or equal to"));
		refund.removeMouseFromTextBox();
	}
	
	@Test(priority = 32, enabled = true, description = "Verify filter Functionality")
	public void validationWhenZeroRefundAmount() {
		refund.refreshPage();
		refund.clickOnRefund();
		refund.clickOnPartialRefundLink();
		refund.checkCheckBox();
		refund.enterRefundAmount(0);
		refund.clickOnProcessRefund();
		refund.closeValidationMessage();
		Assert.assertEquals(refund.getRefundToolTipMessage(), "Please enter a value greater than or equal to 0.01.");
	}
	
	@Test(priority = 33, enabled = true, description = "Verify filter Functionality")
	public void verifyUpdatePopup() {
		dashboard.clickOnBill();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnEditBtn();
		update.isAllFieldPresent();
		update.clickOnClose();
	}
	
	@Test(priority = 34, enabled = true, description = "Verify filter Functionality")
	public void updateBillAmount() {
		dashboard.clickOnBill();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnEditBtn();
		update.enterSubTotalAmount(500);
		update.clickOnUpdateBtn();
		Assert.assertEquals(bill.getToastMessage(), "Bill updated successfully");
		bill.closeToastBtn(); 
	}
	
	@Test(priority = 35, enabled = true, description = "Verify filter Functionality")
	public void validationSubTotalAmountUpdate() {
		dashboard.clickOnBill();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnEditBtn();
		update.enterSubTotalAmount(0);
		update.clickOnUpdateBtn();
		Assert.assertEquals(update.getSubTotalToolTipMsg(), "Please enter a value greater than or equal to 0.01.");
		update.clickOnClose();
	}
	
	@Test(priority = 36, enabled = true, description = "Verify filter Functionality")
	public void addBillDetailLinkUpdatePopup() {
		dashboard.clickOnBill();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnEditBtn();
		update.clickOnAddBillDetailLink();
		Assert.assertTrue(update.isDescriptionFieldDisplayed());
		Assert.assertTrue(update.isPriceFieldDisplayed());
		update.clickOnClose();
	}
	
	@Test(priority = 37, enabled = true, description = "Verify filter Functionality")
	public void moreDetailToggleUpdatePopup() {
		dashboard.clickOnBill();
		bill.clickOnFirstUnPaidBills();
		billView.clickOnEditBtn();
		update.switchOnMoreDetailsToggle();
		Assert.assertTrue(update.isCustomerNameDisplayed());
		Assert.assertTrue(update.isMemoTbxDisplayed());
		update.clickOnClose();
		
	}
	
	
}

