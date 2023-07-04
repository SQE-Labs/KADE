package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
		
	@Test(priority = 2, enabled = true, description = "Verify that user get directed to 'Create New Account' page")
    public void validateSignUpLink() throws InterruptedException {
        
        login.clickSignUpLink();
        String actualTitle=login.getPageTitle();
        String expectedTitle="Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);
        login.goBackToPreviousPage();
    }
	
	@Test(priority = 0, enabled = true, description = "Verify mandatory field gets highlighted on clicking 'SignIn',When mandatory field are left blank")
    public void blankMandatoryField() {
		login.clickSignInButton();
		String actualAttribute=login.getAttribute();
		String expectedAttribute="form-control form-control-lg is-invalid";
		Assert.assertEquals(actualAttribute, expectedAttribute);
	}
	
	@Test(priority = 1, enabled = true, description = "Invalid Email or PhoneNumber")
    public void invalidEmailOrPhone() {
		login.enterUsername("invalid123");
		login.enterPassword("password");
		login.clickSignInButton();
		String actualValidation = login.getValidationMessage();
		String expectedValidation ="Please review the highlighted field(s)";
		Assert.assertEquals(actualValidation, expectedValidation);
	}
	
	@Test(priority = 1, enabled = true, description = "Verify Tool Tip Appear on enterin invalid email")
    public void validateForgotPasswordLink() {
		login.clickForgotPasswordLink();
		String actualTitle = login.getPageTitle();
		String expectedTitle = "Forget Password";
		Assert.assertEquals(actualTitle, expectedTitle);
		login.goBackToPreviousPage();
	}
	
	@Test(priority = 3, enabled = true, description = "Verify Tool Tip Appear on enterin invalid email")
    public void termsOfUsePage() {
		login.clickOnTermsOfUse();
		login.switchToWindow("Terms of Use Page");
		String actualTitle = login.getPageTitle();
		String expectedTitle = "Terms Of Use";
		Assert.assertEquals(actualTitle, expectedTitle);
		login.switchToParentWindow("Sign in");
	}
	
	@Test(priority = 4, enabled = true, description = "Successfull Login" ,groups="Regression")
	public void successfullLogin() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		String actualTitle = dashboard.getPageTitle();
		String expectedTitle = "Dashboard";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
