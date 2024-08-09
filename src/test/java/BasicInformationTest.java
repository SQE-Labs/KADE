import java.awt.AWTException;

import org.automation.base.BaseTest;
import org.automation.pages.BasicInformationPage;
import org.automation.pages.DashBoardPage;
import org.automation.pages.LoginPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.Test;

public class BasicInformationTest extends BaseTest{
	
	DashBoardPage dashBoard=new DashBoardPage();
	LoginPage login=new LoginPage();
	BasicInformationPage infoPage=new BasicInformationPage();
	
	@Test(enabled = true, description="verifyNameToolTip")
	public void tc01_verifyNameToolTip() {
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashBoard.clickProfile();
		infoPage.clearDataFromNameField();
		infoPage.clickOnSaveChangesButton();
		infoPage.moveToNameField();
		String validationMessage=infoPage.getNameToolTipMessage();
		String expectedValidation="This field is required.";
		Assertions.assertEquals(validationMessage, expectedValidation);
	}
	
	@Test(enabled = true, description="Input alphaNumrical value in name field and verify SuccessMessage")
	public void tc02_verifyNameInput() {
		infoPage.enterUserName("Tester123");
		infoPage.clickOnSaveChangesButton();
		String actualMessage = infoPage.getSuccessMessage();
		String expectedMessage ="Saved";
		Assertions.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(enabled = true, description="ToolTip validation message when invalid Address")
	public void tc03_invalidAddress() {
		infoPage.enterAddress("1234TestLocation");
		infoPage.clickOnSaveChangesButton();
		infoPage.moveToAddressField();
		String actualValidation = infoPage.getAddressToolTipMessage();
		String expectedValidation = "Address cannot be verified";
		Assertions.assertEquals(actualValidation, expectedValidation);
		}

	@Test(enabled = true, description="valid Name and Address")
	public void tc04_validNameAndAddress() {
		infoPage.enterUserName("Tester");
		infoPage.selectFirstAddress("160062");
		infoPage.clickOnSaveChangesButton();
		String actualMessage=infoPage.getSuccessMessage();
		String expectedMessage="Saved";
		Assertions.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(enabled = true, description="Upload Profile Image")
	public void tc05_uploadProfileImage() throws AWTException {
		infoPage.uploadImage(System.getProperty("user.dir")+"\\src\\main\\resources\\image\\dummy-image.jpg");
		String actualMessage=infoPage.getSuccessMessage();
		String expectedMessage="Image updated.";
		Assertions.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(enabled = true, description="upload Invalid Profile Image Formate")
	public void tc06_uploadInvalidFileFormate() throws AWTException, InterruptedException {
		infoPage.refreshPage();
		infoPage.uploadImage(System.getProperty("user.dir")+"\\src\\main\\resources\\demo.txt");
		String expectedAleart = "Invalid image file";
		String actualAleart = infoPage.getAleartMessage();
		Assertions.assertEquals(actualAleart, expectedAleart);
	}
}
