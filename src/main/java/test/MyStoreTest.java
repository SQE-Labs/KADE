package test;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test(enabled = true, description="")
    public void tc01_RegisterNewBusinessPage(){
		login.performSignIn(PropertiesUtil.getPropertyValue("userName2"), PropertiesUtil.getPropertyValue("password2"));
		//dashboard.clickOnMyStores();
		myStore.clickOnRegisterNewBuissnessBtn();
		Assert.assertEquals(myStore.getPageHeader(), "New business");
	}
	
	@Test(enabled = true, description="Verify that validation message appears, after clicking on 'Save' button, when mandatory fields are left blank, on 'New Business' page.")
    public void tc02_verifyValidationMessageForBlankFields() {
		//dashboard.clickOnMyStores();
		//myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnSaveBtn();
		Assert.assertTrue(myStore.isValidationMessageDisplayed());
	}
	
	@Test(enabled = true, description="Verify Behavior of Buisness Legal Name Textbox")
    public void tc03_verifyBuisnessLegalNameTbx() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterBisnessLegalName("Frutos@32");
		Assert.assertEquals(myStore.getBuisnessLegalNameText(), "Frutos@32");
		myStore.enterBisnessLegalName("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum.");
		Assert.assertTrue(myStore.getBuisnessLegalNameText().length()==100);
		
	}

	@Test(enabled = true, description="Verify Behavior of Name Of the Store textbox ")
    public void tc04_verifyNameOfStore(){
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterBisnessLegalName("SQE Labs");
		myStore.clickOnNameOfStore();
		Assert.assertEquals(myStore.getNameOfStoreAutoPopulation(), "SQE Labs");
		myStore.enterBisnessLegalName("SQE");
		myStore.clickOnNameOfStore();
		Assert.assertFalse(myStore.getNameOfStoreAutoPopulation().equalsIgnoreCase("SQE"));
		myStore.enterNameOfStore("Labs");
		Assert.assertFalse(myStore.getBuisnessLegalNameText().equalsIgnoreCase("Labs"));
		myStore.enterNameOfStore("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum.");
		Assert.assertTrue(myStore.getNameOfStoreAutoPopulation().length()==100);
    }
	
	@Test(enabled = true, description="Verify that 'Individual' option appears selected by default in 'Types of business field, on 'New business page")
    public void tc05_VerifyTypeOfBuisnessSelectedOption() {
		myStore.clickOnRegisterNewBuissnessBtn();
		Assert.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "Individual");
	}
	
	@Test(enabled = true, description="Verify that all the different types of business options appear in Combo box, after clicking on 'Type of Business' field, on New Business' page.")
    public void tc06_VerifyTypeOfBuisnessAllOption() {
		myStore.clickOnRegisterNewBuissnessBtn();
		List<String> options=new ArrayList<String>();
		options.add("Individual");
		options.add("Sole Proprietorship");
		options.add("Corporation");
		options.add("LLC");
		options.add("Partnership");
		List<String> allOptions=myStore.getAllOptionsOfTypesOfBuisness();
		Assert.assertTrue(options.equals(allOptions));
	}
	

	@Test(enabled = true, description="Verify that user is able to select or search different types of business options from the 'combo box' ,on the New Business page.")
    public void tc07_verifyTypeOfBuisnessSelection() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnTypeOfBuisness();
		myStore.selectTypeOfBuisnessOption("LLC");
		Assert.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "LLC");
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnTypeOfBuisness();
		myStore.enterTypeOfBuisness("Corporation");
		myStore.selectFirstSearchResult();
		Assert.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "Corporation");
		myStore.clickOnTypeOfBuisness();
		myStore.enterTypeOfBuisness("Group");
		Assert.assertEquals(myStore.getTypeOfBusinessInfoMessage(), "No results found");
	}
	
	@Test(enabled = true, description="Verify behavior 'Location Description' field, on 'New Business' page.")
    public void tc08_verifyLocationDescription() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterLocationDescription("Lorem&#ipsum9olor sit amet, consectetuer adipiscing eli");
		Assert.assertTrue(myStore.getLocationDescriptionText().length()==50);
	}
	
	
	}
