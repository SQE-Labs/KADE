package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BillPage;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillTest extends BaseTest{
	
	LoginPage login= new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	BillPage bill = new BillPage();

	@Test(priority = 0, enabled = true, description = "BillPage")
    public void verifyBillPage() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnBill();
		//Verify page title 
		Assert.assertEquals(bill.getPageTitle(), "Bills");
		
		//Verify New Bill Button
		Assert.assertTrue(bill.billButtonPresent());
		
		//Verify Alert Message
		Assert.assertTrue(bill.isAleartMessageDisplayed());
		
		}
	
	@Test(priority = 1, enabled = true, description = "Varify Transactions Link")
	public void verifyTransactionLink() {
		bill.clickOnTransactions();
		String actualPage = bill.getPageHeader();
		String expectedPage = "Transactions";
		Assert.assertEquals(actualPage, expectedPage);
		bill.goBackToPreviousPage();
	}
	
	@Test(priority = 2, enabled = true, description = "Varify close icon functionality")
	public void closeAlertMessagePopup() {
		bill.closeBtn();
		Assert.assertFalse(bill.isAleartMessageDisplayed());
	}
	
	@Test(priority = 5, enabled = true, description = "Creating a new bill")
	public void createNewBill() {
		bill.clickOnNewBill();
		Assert.assertEquals(bill.getPopUpTitle(), "Create A Bill");
		bill.enterPhoneNumber("+918877070727");
		bill.enterSubTotalAmount("1000");
		bill.clickOnCreate();
		Assert.assertEquals(bill.getSuccessMessage(), "New bill created successfully");
	}
	
	@Test(priority = 3, enabled = true, description = "Add bill details link")
	public void addBillDetails() {
		bill.clickOnNewBill();
		bill.clickOnAddBillDetail();
		Assert.assertTrue(bill.billDetailsHeader());
		bill.clickOnAddMoreRow();
		// Insert Assertion to validate that count of rows is 4
		bill.closeBtn();
	}
	
	@Test(priority = 4, enabled = true, description = "validation Message when user bill value is zero")
	public void validationWhenBillValueIsZero() {
		bill.clickOnNewBill();
		bill.clickOnCreate();
		bill.moveToSubTotal();
		Assert.assertEquals(bill.getToolTipMessage(), "Please enter a value greater than or equal to 0.01.");
		bill.closeBtn();
	}
	
}
