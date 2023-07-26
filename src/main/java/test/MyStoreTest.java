package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.MyStorePage;
import org.automation.pageObjects.NewStorePage;
import org.automation.pageObjects.newBusinessPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest{

		LoginPage login=new LoginPage();
		DashBoardPage dashboard=new DashBoardPage();
		MyStorePage myStore=new MyStorePage();
		newBusinessPage newBusiness =new newBusinessPage();
		NewStorePage newStore = new NewStorePage();
	
		
		@Test
		public void createNewBusiness() throws InterruptedException {
			login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
			dashboard.clickOnMyStore();
			myStore.clickOnRegisterNewBuissnessBtn();
			newBusiness.enterBusinessLegalName("NewStore");
			newBusiness.selectTypeOfBusiness("Corporation");
			newBusiness.enterLocationDescription("In City Center");
			newBusiness.enterStoreAddress("1234");
			newBusiness.enterPhone("9874563210");
			newBusiness.selectCurrencyOfStore("EUR");
			newBusiness.enterTaxRate("5.25");
			newBusiness.clickOnSave();
			newStore.selectByVisibleText("Services - other");
			newStore.enterWebsite("www.mystore.com");
			newStore.clickOnSave();
		}
}
