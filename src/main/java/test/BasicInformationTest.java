package test;

import java.awt.AWTException;

import org.automation.base.BaseTest;
import org.automation.pageObjects.BasicInformationPage;
import org.automation.pageObjects.DashBoardPage;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicInformationTest extends BaseTest{
	
	DashBoardPage dashBoard=new DashBoardPage();
	LoginPage login=new LoginPage();
	BasicInformationPage infoPage=new BasicInformationPage();
	
	@Test(priority = 0, enabled = true, description="verifyNameToolTip")
	public void verifyNameToolTip() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashBoard.clickProfile();
		infoPage.clearDataFromNameField();
		infoPage.clickOnSaveChangesButton();
		infoPage.moveToNameField();
		String validationMessage=infoPage.getNameToolTipMessage();
		String expectedValidation="This field is required.";
		Assert.assertEquals(validationMessage, expectedValidation);
	}
	
	@Test(priority = 1, enabled = true, description="Input alphaNumrical value in name field and verify SuccessMessage")
	public void verifyNameInput() {
		infoPage.enterUserName("Tester123");
		infoPage.clickOnSaveChangesButton();
		String actualMessage = infoPage.getSuccessMessage();
		String expectedMessage ="Saved";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(priority = 2, enabled = true, description="ToolTip validation message when invalid Address")
	public void invalidAddress() {
		infoPage.enterAddress("1234TestLocation");
		infoPage.clickOnSaveChangesButton();
		infoPage.moveToAddressField();
		String actualValidation = infoPage.getAddressToolTipMessage();
		String expectedValidation = "Address cannot be verified";
		Assert.assertEquals(actualValidation, expectedValidation);
		}

	@Test(priority = 3, enabled = true, description="valid Name and Address")
	public void validNameAndAddress() {
		infoPage.enterUserName("Tester");
		infoPage.selectFirstAddress("160062");
		infoPage.clickOnSaveChangesButton();
		String actualMessage=infoPage.getSuccessMessage();
		String expectedMessage="Saved";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(priority = 4, enabled = true, description="Upload Profile Image")
	public void uploadProfileImage() throws AWTException {
		infoPage.uploadImage("C:\\Users\\HP\\Downloads\\dummy-image.jpg");
		String actualMessage=infoPage.getSuccessMessage();
		String expectedMessage="Image updated.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
//	@Test(priority =5, enabled = true, description="upload Invalid Profile Image Formate")
//	public void uploadInvalidFileFormate() throws AWTException, InterruptedException {
//		infoPage.uploadImage("‪C:\\Users\\HP\\Downloads\\demo.txt");
//		String actualAleart = infoPage.getAleartMessage();
//		String expectedAleart = "Invalid image file";
//		Assert.assertEquals(actualAleart, expectedAleart);
//	}
}
