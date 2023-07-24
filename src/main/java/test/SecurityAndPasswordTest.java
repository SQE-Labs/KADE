package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BasicInformationPage;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.SecurityAndPasswordPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecurityAndPasswordTest extends BaseTest{
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	BasicInformationPage info=new BasicInformationPage();
	SecurityAndPasswordPage security=new SecurityAndPasswordPage();
	
	
	
	@Test
	public void verifyUpdateEmailPopup() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		String actualPopup = security.getHeaderText();
		String expectedPopup ="Update Email Address";
		Assert.assertEquals(actualPopup, expectedPopup);
		security.closePopup();
	}
	
	
	
}
