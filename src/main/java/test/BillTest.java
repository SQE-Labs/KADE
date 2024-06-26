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
import org.automation.utilities.Assertions;
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
	}

	@AfterMethod
	public void logout(){
		dashboard.signOut();
	}

	@Test (enabled = true, description="Verify that creating a bill by adding amount value only, without Selecting a Customer")
	public void tc_01createBillWithoutSelectingCustomer(){
		dashboard.clickOnBill();

		//Select Store
		bill.clickStoresDropdown();
		bill.selectStore("Automation Flow 1");
		bill.clickContinueBtn();

		// Click on New Bill Button
		bill.clickOnNewBill();

		// Verify New Bill popup Web Elements
		Assert.assertEquals(bill.getPopUpTitle(), "Bill");
		Assert.assertTrue(bill.isAmountTbxDisplayed());
		Assert.assertTrue(bill.isDescriptionDisplayed());
		Assert.assertTrue(bill.isCustomerFieldDisplayed());
		Assert.assertTrue(bill.isMoreOptionDisplayed());

		// Verify Default value of Amount tab
		String defaultAmt = bill.getAttribute(bill.amtInput,"value");
		Assert.assertEquals(defaultAmt,"$0.00");

		//Verify Confirm Button is disabled before entering amount
		Assert.assertFalse(bill.isConfirmBtnEnabled());

		//Enter amount
		String amt ="2,999.00";
		bill.enterAmount(amt);

		// Verify Default Confirm button is enabled after entering amount
		Assert.assertTrue(bill.isConfirmBtnEnabled());

		//Click Confirm
		bill.clickOnConfirm();

		//Verify Message popup and Buttons
		Assert.assertEquals(bill.getMessagePopupHeader(),"Message");
		Assert.assertTrue(bill.isSelectACustomerBtnVisible());
		Assert.assertTrue(bill.isContinueWithoutBtnVisible());

		//Click On Continue Button
		bill.clickOnContinueWithout();

		//Verify toast message
		Assert.assertTrue(bill.isToastMessageDisplayed());
		Assert.assertEquals(bill.getToastMessage(),"Bill was created successfully.Click here to open");

		//Close popup
//		bill.closeLogoConfigPopup();

		//Verify not paid label for generated amount
		Assert.assertTrue(bill.isNotPaidLabelDisplayed(amt));
		Assert.assertTrue(bill.isRefNoDisplayed(amt));
		Assert.assertTrue(bill.isBillTimeDisplayed(amt));

	}

	@Test (enabled = true, description="Verify that creating a bill by adding amount value only, without Selecting a Customer")
	public void tc_02createBillBySelectingCustomer(){
		dashboard.clickOnBill();

		//Select Store
		bill.clickStoresDropdown();
		bill.selectStore("Automation Flow 1");
		bill.clickContinueBtn();

		// Click on New Bill Button
		bill.clickOnNewBill();

		// Verify New Bill popup
		Assert.assertEquals(bill.getPopUpTitle(), "Bill");

		//Verify Confirm Button is disabled before entering amount
		Assert.assertFalse(bill.isConfirmBtnEnabled());

		//Enter amount
		String amt ="1,000.00";
		bill.enterAmount(amt);

		// Verify Default Confirm button is enabled after entering amount
		Assert.assertTrue(bill.isConfirmBtnEnabled());

		//Click Confirm
		bill.clickOnConfirm();

		//Verify Message popup and Buttons
		Assert.assertEquals(bill.getMessagePopupHeader(),"Message");
		Assert.assertTrue(bill.isSelectACustomerBtnVisible());
		Assert.assertTrue(bill.isContinueWithoutBtnVisible());

		//Click On Continue Button
		bill.clickOnSelectACustomer();

		//Verify Customer popup
		Assert.assertTrue(bill.isCustomerPhnNoFieldPresent());
		Assert.assertTrue(bill.isEmailFieldPresent());
		Assert.assertTrue(bill.isSearchFieldPresent());


		//Select Customer
		bill.enterCustomerPhnNo("918877070727");
		bill.clickOnGoBtnPhoneNo();

		//Click Confirm
		bill.clickOnConfirm();

		//Verify toast message
		Assert.assertTrue(bill.isToastMessageDisplayed());
		Assert.assertEquals(bill.getToastMessage(),"Bill was created successfully.Click here to open");

		//Close popup
		bill.closeLogoConfigPopup();

		//Verify not paid label for generated amount
		Assert.assertTrue(bill.isNotPaidLabelDisplayed(amt));
		Assert.assertTrue(bill.isRefNoDisplayed(amt));
		Assert.assertTrue(bill.isBillTimeDisplayed(amt));
	}

	@Test (enabled = true, description="Bill creation by selecting customers from the suggestion list")
	public void tc_03createBillForSuggestedCustomer(){
		dashboard.clickOnBill();

		//Select Store
		bill.clickStoresDropdown();
		bill.selectStore("Automation Flow 1");
		bill.clickContinueBtn();
		// Click on New Bill Button
		bill.clickOnNewBill();
		//Enter amount
		String amt ="105.00";
		bill.enterAmount(amt);
		//Select Suggested Customer
		bill.clickCustomer();
		bill.ClickSuggestedCustomer();
		bill.clickOnConfirm();
		//Verify toast message
		Assert.assertTrue(bill.isToastMessageDisplayed());
		Assert.assertEquals(bill.getToastMessage(),"Bill was created successfully.Click here to open");


		//Verify not paid label for generated amount
		Assert.assertTrue(bill.isNotPaidLabelDisplayed(amt));
		Assert.assertTrue(bill.isRefNoDisplayed(amt));
		Assert.assertTrue(bill.isBillTimeDisplayed(amt));

	}
	
}

