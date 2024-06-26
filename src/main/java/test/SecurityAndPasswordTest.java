package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BasicInformationPage;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.SecurityAndPasswordPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecurityAndPasswordTest extends BaseTest{
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	BasicInformationPage info=new BasicInformationPage();
	SecurityAndPasswordPage security=new SecurityAndPasswordPage();
	
	
	
	@Test(enabled = true, description = "Verify that 'Update Email Address' pop-up appears after clicking the 'Edit' icon next to 'Email' field on 'Security' page")
	public void tc01_verifyUpdateEmailPopup() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		Assertions.assertEquals(security.getHeaderText(), "Update Email Address");
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc02_verifyValidationForNewEmail() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewEmailToolTipMessage(),"This field is required." );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc03_verifyValidationForNewEmail() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.enterNewEmail("ronny@123");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewEmailToolTipMessage(),"Please enter a valid email address." );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc04_verifyValidationForNewEmail() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.enterNewEmail("testkade@yopmail.com");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewEmailToolTipMessage(),"New email cannot be the same as the current email!" );
		security.closePopup();
	}
	
	
	@Test(enabled = true, description = "")
	public void tc05_verifyBehaviourSendCodeBtn() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.enterNewEmail("testkade1@yopmail.com");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertTrue(security.isElementPresent());
		security.closePopup();
	}
	
	@Test(enabled = true, description = "")
	public void tc06_verifyValidatioMessageForOtpFields() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.enterNewEmail("testkade1@yopmail.com");
		security.clickOnSendSecurityCodeBtn();
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getCurrentEmaiOtplToolTipMessage(),"This field is required." );
		Assertions.assertEquals(security.getNewEmailOtpToolTipMessage(),"This field is required." );
		security.enterCurrentEmailOtp(123451);
		security.enterNewEmailOtp(123451);
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getValidationlToolTipMessage(),"Security code cannot be verified for the current email." );
		security.enterCurrentEmailOtp(12345);
		security.enterNewEmailOtp(12345);
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getCurrentEmaiOtplToolTipMessage(),"Please enter at least 6 characters." );
		Assertions.assertEquals(security.getNewEmailOtpToolTipMessage(),"Please enter at least 6 characters." );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "")
	public void tc07_VerifyDifferentEmailLink() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditEmailIcon();
		security.enterNewEmail("testkade1@yopmail.com");
		security.clickOnSendSecurityCodeBtn();
		security.clickDifferentEmailLink();
		Assertions.assertTrue(security.isNewEmailPresent());
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify that 'Update Email Address' pop-up appears after clicking the 'Edit' icon next to 'Email' field on 'Security' page")
	public void tc08_verifyUpdateEmailPopup() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		Assertions.assertEquals(security.getHeaderText(), "Update Cell-phone");
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc09_verifyValidationForCellPhone() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewCellPhoneToolTipMessage(),"This field is required." );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc10_verifyValidationForInvalidCellPhone() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.enterNewCellPhoneNumber("123456789");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewCellPhoneToolTipMessage(),"Invalid phone number" );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Email field")
	public void tc11_verifyForValidCellPhone() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.enterNewCellPhoneNumber("+919874635124");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertTrue(security.isElementPresent());
		security.closePopup();
	}
	
	@Test(enabled = true, description = "")
	public void tc12_verifyValidatioMessageForCellPhoneOtpFields() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.enterNewCellPhoneNumber("+919874635124");
		security.clickOnSendSecurityCodeBtn();
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getCurrentEmaiOtplToolTipMessage(),"This field is required." );
		Assertions.assertEquals(security.getNewEmailOtpToolTipMessage(),"This field is required." );
		security.enterCurrentCellPhoneOtp(123451);
		security.enterNewCellPhoneOtp(123451);
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getValidationlToolTipMessage(),"Security code cannot be verified for the current phone." );
		security.enterCurrentCellPhoneOtp(12345);
		security.enterNewCellPhoneOtp(12345);
		security.clickOnSaveBtn();
		Assertions.assertEquals(security.getCurrentEmaiOtplToolTipMessage(),"Please enter at least 6 characters." );
		Assertions.assertEquals(security.getNewEmailOtpToolTipMessage(),"Please enter at least 6 characters." );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify that New Cell Phone tbx appears after clicking on Different Cell Phone Link")
	public void tc13_VerifyDifferentCellPhoneLink() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.enterNewCellPhoneNumber("+919875632145");
		security.clickOnSendSecurityCodeBtn();
		security.clickDifferentCellPhoneLink();
		Assertions.assertTrue(security.isNewCellPhoneTbxPresent());
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify validation message for New Cell Phone field after entering same registered cell phone number")
	public void tc14_verifyValidationForExsistingNewCellPhone() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();
		security.clickOnEditCellPhoneIcon();
		security.enterNewCellPhoneNumber("+918618071668");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getNewCellPhoneToolTipMessage(),"New phone number cannot be the same as the current phone number!" );
		security.closePopup();
	}
	
	@Test(enabled = true, description = "Verify behavior of Reset your password link.")
	public void tc15_verifyChangePasswordPopup() {
		dashboard.clickProfile();
		info.clickOnSecurityAndPassword();	
		security.clickResetYourPassword();
		Assertions.assertEquals(security.getHeaderText(), "Change Password");
		security.clickOnSendSecurityCodeBtn();
		Assertions.assertEquals(security.getTitleOfPage("Verify Account"), "Verify Account");
		security.goBackToPreviousPage();
	}
}
