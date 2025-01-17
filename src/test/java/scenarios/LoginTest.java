package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	KadeSession session=new KadeSession();

	@Test(description = "Log04 : Verify that user get directed to 'Create New Account' page")
    public void tc04_validateSignUpLink() {
        session.getLoginPage().getSignUpLink().click(); 
        String actualTitle=session.getLoginPage().getNewAccountPopupTitle().getText();
        String expectedTitle="New Account";
        Assertions.assertEquals(actualTitle, expectedTitle);
    }
	
	@Test(description = "Log01 : Verify mandatory field gets highlighted on clicking 'SignIn',When mandatory field are left blank")
    public void tc01_blankMandatoryField() {
		session.getLoginPage().getSignInButton().click();
		String actualAttribute=session.getLoginPage().getUserNameTextbox().getAttribute("class");
		String expectedAttribute="form-control form-control-lg is-invalid";
		Assertions.assertEquals(actualAttribute, expectedAttribute);
	}
	
	@Test(description = " Log02 : Invalid Email or PhoneNumber")
    public void tc02_invalidEmailOrPhone() {
		session.getLoginPage().getUserNameTextbox().setText("invalid123");
		session.getLoginPage().getPasswordTextbox().setText("password");
		session.getLoginPage().getSignInButton().click();
		String actualValidation = session.getLoginPage().getValidationMessage().getText();
		String expectedValidation ="Please review the highlighted field(s)";
		Assertions.assertEquals(actualValidation, expectedValidation);
	}
	
	@Test(description = "Log03 : Verify Tool Tip Appear on enter in invalid email")
    public void tc03_validateForgotPasswordLink() {
		session.getLoginPage().getForgotPasswordLink().click();
		String actualTitle = session.getLoginPage().getPageTitle();
		String expectedTitle = "Forget password";
		Assertions.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(description = "Log05 : Verify Tool Tip Appear on enter in invalid email")
    public void tc05_termsOfUsePage() {
		session.getLoginPage().getTermOfUseButton().click();
		session.getLoginPage().switchToWindow("Terms of Use Page");
		String actualTitle = session.getLoginPage().getPageTitle();
		String expectedTitle = "Terms Of Use";
		Assertions.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(description = "Log06 : Successful Login" ,groups="Regression")
	public void tc06_successfulLogin(){
		KadeSession session=KadeSession.login(KadeUserAccount.Default);
		String actualTitle = session.getSidePannel().getPageHeader();
		String expectedTitle = "Transactions";
		Assertions.assertEquals(actualTitle, expectedTitle);
		session.getSidePannel().getSignOutButton().click();
	}
}
