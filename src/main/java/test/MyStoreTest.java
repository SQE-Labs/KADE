package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.MyStorePage;
import org.automation.pageObjects.newBusinessPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest{
	
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	MyStorePage myStore=new MyStorePage();
	newBusinessPage newBusiness=new newBusinessPage();
	
	@Test(enabled = true, description="verifyMyStoreButton")
    public void tc01_verifyBillButton(){
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnMyStores();
	 	Assert.assertEquals(myStore.getPageTitle(), "MyStores");
	}
		
	@Test(enabled = true, description="Verify Register new business button")
	public void tc02_verifyRegisterNewBusinessBtn(){
		myStore.clickOnRegisterNewBuissnessBtn();
		String pageHeader=myStore.getPageHeader();
		newBusiness.enterBusinessLegalName("Future Tech Solutions");
		
	}
}
