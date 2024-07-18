import Manager.Manager;
import org.automation.base.BaseTest;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	LoginPage login = new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();

	@Test(enabled = true, description = "Verify that user get directed to 'Create New Account' page")
    public void tc04_validateSignUpLink() throws InterruptedException {
        login.clickSignUpLink();
        String actualTitle=login.getPageTitle();
        String expectedTitle="Sign Up";
        Assertions.assertEquals(actualTitle, expectedTitle);
        login.goBackToPreviousPage();
    }
	
	@Test(enabled = true, description = "Verify mandatory field gets highlighted on clicking 'SignIn',When mandatory field are left blank")
    public void tc01_blankMandatoryField() {
		login.clickSignInButton();
		String actualAttribute=login.getAttribute();
		String expectedAttribute="form-control form-control-lg is-invalid";
		Assertions.assertEquals(actualAttribute, expectedAttribute);
	}
	
	@Test(enabled = true, description = "Invalid Email or PhoneNumber")
    public void tc02_invalidEmailOrPhone() {
		login.enterUsername("invalid123");
		login.enterPassword("password");
		login.clickSignInButton();
		String actualValidation = login.getValidationMessage();
		String expectedValidation ="Please review the highlighted field(s)";
		Assertions.assertEquals(actualValidation, expectedValidation);
	}
	
	@Test(enabled = true, description = "Verify Tool Tip Appear on enterin invalid email")
    public void tc03_validateForgotPasswordLink() {
		login.clickForgotPasswordLink();
		String actualTitle = login.getPageTitle();
		String expectedTitle = "Forget Password";
		Assertions.assertEquals(actualTitle, expectedTitle);
		login.goBackToPreviousPage();
	}
	
	@Test(enabled = true, description = "Verify Tool Tip Appear on enterin invalid email")
    public void tc05_termsOfUsePage() {
		login.clickOnTermsOfUse();
		login.switchToWindow("Terms of Use Page");
		String actualTitle = login.getPageTitle();
		String expectedTitle = "Terms Of Use";
		Assertions.assertEquals(actualTitle, expectedTitle);
		login.switchToParentWindow("Sign in");
	}
	
	@Test(enabled = true, description = "Successfull Login" ,groups="Regression")
	public void tc06_successfullLogin() throws InterruptedException {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		String actualTitle = dashboard.getPageHeader();
		String expectedTitle = "Dashboard";
		System.out.println(actualTitle);
		Assertions.assertEquals(actualTitle, expectedTitle);
	}
}
