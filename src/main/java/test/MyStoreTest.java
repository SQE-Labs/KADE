package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.*;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest {

	LoginPage login = new LoginPage();
	DashBoardPage dashboard = new DashBoardPage();
	MyStorePage myStore = new MyStorePage();
	NewBusinessPage newBusiness = new NewBusinessPage();
	NewStorePage newStore = new NewStorePage();

//	@BeforeMethod
//			public void beforeMethod() {
//		login.performSignIn("testkade@yopmail.com", "Test@123");
//	}
	@Test(priority = 0, enabled = true, description = "1. Verify that 'My Store' page opens up, after clicking on 'My Store' tab, on the left panel")
	public void validateMyStorePageOpensUpOnClickingMyStoreTab() {

		// Login with valid credentials
		login.performSignIn("testkade@yopmail.com", "Test@123");

		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		Assert.assertEquals(dashboard.getPageTitle(), "My Stores");
	}

	@Test(priority = 1, enabled = true, description = "2. Verify that 'New business' page opens up, after clicking on 'Register new business' button, on 'My Store' page.")
	public void validateNewBusinessPageOpensUp() {
		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		Assert.assertEquals(dashboard.getPageTitle(), "My Stores");

		// click on 'Register a New Business' button
		myStore.clickOnRegisterNewBusinessBtn();
		Assert.assertEquals(myStore.getPageTitle(), "New business");
	}

	@Test(priority = 2, enabled = true, description = "3. Verify that validation message appears, after clicking on 'Save' button, when mandatory fields are left blank, on 'New Business' page.")
	public void validateValidationMessageOnLeavingMandatoryFieldsBlank() throws InterruptedException {

        // Click on 'My Stores' tab
        dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();

		newBusiness.clearBusinessLegalNameField();
        // Click on 'Save' button
		newBusiness.clickOnSave();

		// Validate validation message "Please review the highlighted field(s)"
		String expectedValidationMessage = "Please review the highlighted field(s)";
		String actualValidationMessage = newBusiness.getText_custom(By.xpath("//p[@class='alert-content']"));
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
	}

	@Test(priority = 5, enabled = true, description = "4. Verify that 'Business legal name' field accepts any special characters and alphanumeric charcaters, on 'New Business' page.")
	public void validateBusinessLegalNameFieldAcceptsAlphanumericsAndSpecialCharacters() throws InterruptedException {

        // Click on 'My Stores' tab
        dashboard.clickOnMyStoreTab();
        myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Enter alphanumric and special characters in 'Business legal name' field
		newBusiness.enterBusinessLegalName("NewBusiness@22");

		// Enter Store address in 'Store Address' field
		newBusiness.enterStoreAddress("chandigarh");

		// Enter phone number in 'Phone' field
		newBusiness.enterPhone("123457877984789");

		// Click on 'Save' button
		newBusiness.clickOnSave();
	}

	@Test(priority = 8, enabled = true, description = "5. Verify that 'Business legal name' field accepts maximum of 100 characaters, on 'New Business' page")
	public void validateBusinessLegalNameFieldAcceptsMaximunHundredCharacters() {

		dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		newBusiness.clearBusinessLegalNameField();

		// Enter alphanumric and special characters in 'Business legal name' field
		newBusiness.enterBusinessLegalName("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");

		Assert.assertTrue(newBusiness.getBusinessLegalName().length()==100);

	}

	@Test(priority =3, enabled = true, description = "6. Verify that 'Name of the store/DBA' field gets auto-populated with the same data entered in 'Business legal name' field, on the 'New Business' page.")
	public void validateNameOfStoreGetAutoPopulated() {

		dashboard.clickOnMyStoreTab();

		Assert.assertEquals(dashboard.getPageTitle(), "My Stores");

		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Enter alphanumric and special characters in 'Business legal name' field
		newBusiness.enterBusinessLegalName("Business@11");

		// Click on name of store field
		newBusiness.clickOnNameOfStoreField();
	}

	@Test(priority =4, enabled = true, description = "7. Verify that changes are not reflected in the 'Name of the store/DBA' field, when any changes are made in 'Bussiness legal name' field text, on 'New business page.")
	public void validateChangesNotReflectedInNameOfStoreField() {

		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Clear 'Business legal name' field
		newBusiness.clearBusinessLegalNameField();

		// Enter alphanumeric and special characters in 'Business legal name' field
		newBusiness.enterBusinessLegalName("NewBusiness@22");

	}

	@Test(priority =6, enabled = true, description = "8. Verify that 'Name of the store/DBA' field accepts different data without changing the data in 'Bussiness legal name' field on New business page.")
	public void validateNameOfStoreFieldAcceptsDifferentDataWithoutChangingBusinessLegalNameField() {

		dashboard.clickOnMyStoreTab();

		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		newBusiness.clearNameOfStoreField();

		newBusiness.enterNameOfStore("NewStoreName");
	}

	@Test(priority =9, enabled = true, description = "9. Verify that 'Name of the store/DBA' field accepts maximum of 100 characters, on 'New Business' page.")
	public void valiadteNameOfStoreFieldAcceptsMaximumHundredCharacters(){

		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Clear 'Name of store' field
		newBusiness.clearNameOfStoreField();

		// Enter more than hundred characters in 'Name of Store' field
		newBusiness.enterNameOfStore("hdorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");
		Assert.assertTrue(newBusiness.getNameOfStore().length()==100);
	}

	@Test(priority =7, enabled = true, description = "10. Verify that 'Individual' option appears selected by default in 'Types of business field, on 'New business page")
	public void valiadteIndividualOptionSelectedByDafault(){

		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Check presence of 'Individual' option by default in 'Type Of Business' field
		Assert.assertTrue(newBusiness.checkPresenceOfIndividualOption());

	}
	@Test(priority =10, enabled = true, description = "11. Verify that all the different types of business options appear in Combo box, after clicking on 'Type of Business' field, on New Business' page.")
	public void validateAllOptionsAppearsInComboBox(){

		// Click on 'My Stores' tab
		dashboard.clickOnMyStoreTab();
		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		// Click on 'Type of store' field
		newBusiness.clickOnTypeOfBusiness();
	}
	@Test(priority =11, enabled = true, description = "14. Verify that 'Location Description' field appears 'Optional', on 'New Business' page.")
	public void validateLocationDescriptionFieldIsOptional(){

		dashboard.clickOnMyStoreTab();

		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		newBusiness.enterBusinessLegalName("Business@11");

		newBusiness.enterStoreAddress("chandigarh");

		newBusiness.enterPhone("123457877984789");

		newBusiness.clickOnSave();

		Assert.assertTrue(newBusiness.checkPresenceOfTellUsMoreAboutHeading());
	}

	@Test(priority =11, enabled = true, description = "15. Verify that 'Location Description' field accepts maximum of 50 characters, on 'New Business' page.")
	public void validateLocationDescriptionFieldAcceptsfiftyCharacters(){
		dashboard.clickOnMyStoreTab();

		myStore.clickOnRegisterNewBusinessBtn();

		newBusiness.clickBackArrowBtn();

		newBusiness.clickDeleteTheStoreButton();

		newBusiness.clickConfirmationButton();

//		newBusiness.enterLocationDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing eli");
//
//		Assert.assertTrue(newBusiness.getLocationDescription().length()==50);
	}

	@Test(priority =11, enabled = true, description = "16. Verify that 'Location Description' field accepts any alphanumeric and special characters, on 'New Business' page.")
	public void validateLocationDescriptonFieldAcceptsAlphanumericsAndSpecialCharacters(){
		dashboard.clickOnMyStoreTab();

		myStore.clickOnRegisterNewBusinessBtn();
		newBusiness.clickBackArrowBtn();


		newBusiness.enterBusinessLegalName("Business@11");

		newBusiness.enterStoreAddress("chandigarh");

		newBusiness.enterLocationDescription("NewDelhi4578");

		newBusiness.enterPhone("123457877984789");

		newBusiness.clickOnSave();




	}







	}
