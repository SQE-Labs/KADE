import java.util.ArrayList;
import java.util.List;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.*;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
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
		Assertions.assertEquals(myStore.getPageHeader(), "New business");
	}
	
	@Test(enabled = true, description="Verify that validation message appears, after clicking on 'Save' button, when mandatory fields are left blank, on 'New Business' page.")
    public void tc02_verifyValidationMessageForBlankFields() {
		//dashboard.clickOnMyStores();
		//myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnSaveBtn();
		Assertions.assertTrue(myStore.isValidationMessageDisplayed());
	}
	
	@Test(enabled = true, description="Verify Behavior of Buisness Legal Name Textbox")
    public void tc03_verifyBuisnessLegalNameTbx() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterBisnessLegalName("Frutos@32");
		Assertions.assertEquals(myStore.getBuisnessLegalNameText(), "Frutos@32");
		myStore.enterBisnessLegalName("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum.");
		Assertions.assertTrue(myStore.getBuisnessLegalNameText().length()==100);
		
	}

	@Test(enabled = true, description="Verify Behavior of Name Of the Store textbox ")
    public void tc04_verifyNameOfStore(){
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterBisnessLegalName("SQE Labs");
		myStore.clickOnNameOfStore();
		Assertions.assertEquals(myStore.getNameOfStoreAutoPopulation(), "SQE Labs");
		myStore.enterBisnessLegalName("SQE");
		myStore.clickOnNameOfStore();
		Assertions.assertFalse(myStore.getNameOfStoreAutoPopulation().equalsIgnoreCase("SQE"));
		myStore.enterNameOfStore("Labs");
		Assertions.assertFalse(myStore.getBuisnessLegalNameText().equalsIgnoreCase("Labs"));
		myStore.enterNameOfStore("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum.");
		Assertions.assertTrue(myStore.getNameOfStoreAutoPopulation().length()==100);
    }
	
	@Test(enabled = true, description="Verify that 'Individual' option appears selected by default in 'Types of business field, on 'New business page")
    public void tc05_VerifyTypeOfBuisnessSelectedOption() {
		myStore.clickOnRegisterNewBuissnessBtn();
		Assertions.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "Individual");
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
		Assertions.assertTrue(options.equals(allOptions));
	}
	

	@Test(enabled = true, description="Verify that user is able to select or search different types of business options from the 'combo box' ,on the New Business page.")
    public void tc07_verifyTypeOfBuisnessSelection() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnTypeOfBuisness();
		myStore.selectTypeOfBuisnessOption("LLC");
		Assertions.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "LLC");
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.clickOnTypeOfBuisness();
		myStore.enterTypeOfBuisness("Corporation");
		myStore.selectFirstSearchResult();
		Assertions.assertEquals(myStore.getTypeOfBuisnessSelectedOption(), "Corporation");
		myStore.clickOnTypeOfBuisness();
		myStore.enterTypeOfBuisness("Group");
		Assertions.assertEquals(myStore.getTypeOfBusinessInfoMessage(), "No results found");
	}
	
	@Test(enabled = true, description="Verify behavior 'Location Description' field, on 'New Business' page.")
    public void tc08_verifyLocationDescription() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterLocationDescription("Lorem&#ipsum9olor sit amet, consectetuer adipiscing eli");
		Assertions.assertTrue(myStore.getLocationDescriptionText().length()==50);
	}
	
	@Test(enabled = true, description="Verify behavior 'Store Address' field, on 'New Business' page.")
    public void tc09_verifyStoreAddressTbx() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterStoreAddress("12345");
		Assertions.assertTrue(myStore.getStoreAddressSuggestionList().size()>0);
		myStore.enterStoreAddress("mksmxj15");
		myStore.clickOnSaveBtn();
		Assertions.assertEquals(myStore.getStoreAddressToolTipMessage(), "Address cannot be verified"); 
	}
	
	@Test(enabled = true, description="Verify behavior of 'Phone' field, on 'New Business' page.")
    public void tc10_verifyPhoneField() {
		myStore.clickOnRegisterNewBuissnessBtn();
		myStore.enterPhone("PhoneNumber");
		Assertions.assertTrue(myStore.getPhoneText().length()==0);
		myStore.enterPhone("8877070727");
		Assertions.assertTrue(myStore.getPhoneText().length()==17);
		myStore.enterPhone("887707");
		myStore.clickOnSaveBtn();
		Assertions.assertEquals(myStore.getPhoneToolTipMessage(),"Invalid phone number");
	}
	
	@Test(enabled = true, description="Verify behavior of 'Local Time Zone' field, on 'New Business' page.")
    public void tc11_verifyLocalSystemTimeZone() {
		myStore.clickOnRegisterNewBuissnessBtn();
		Assertions.assertTrue(!myStore.SelectedLocalSystemTimeZone().isEmpty());
		myStore.selectLocalSystemTimeZoneByIndex(15);
		Assertions.assertTrue(!myStore.SelectedLocalSystemTimeZone().isEmpty());
	}
	
	@Test(enabled = true, description="Verify behavior of 'Currency' field, on 'New Business' page.")
    public void tc12_verifyCurrencyField() {
		myStore.clickOnRegisterNewBuissnessBtn();
		Assertions.assertTrue(myStore.getSelectedCurrency().equalsIgnoreCase("USD"));
		myStore.selectCurrencyByText("EUR");
		Assertions.assertTrue(myStore.getSelectedCurrency().equalsIgnoreCase("EUR"));
	}
	
	@Test(enabled = true, description="Verify behavior of 'Tax rate' field, on 'New Business' page.")
    public void tc13_verifyTaxField() {
		myStore.clickOnRegisterNewBuissnessBtn();
		Assertions.assertTrue(myStore.getTaxRateText().equalsIgnoreCase("0.000"));
		myStore.enterTaxRate("tax");
		Assertions.assertTrue(myStore.getTaxRateText().length()==0);
		myStore.enterTaxRate("123");
		Assertions.assertTrue(myStore.getTaxRateText().length()==2);
		myStore.enterTaxRate("55.555");
		System.out.println(myStore.getTaxRateText());
		Assertions.assertTrue(myStore.getTaxRateText().substring(2, 5).length()==3);
	}
	
	@Test(enabled = true, description="Verify behavior of 'Tax rate' field, on 'New Business' page.")
    public void tc14_verifyBehaviorOfSaveBtn() {
		myStore.clickOnRegisterNewBuissnessBtn();
		String buisnessName="Unicorn";
		myStore.enterBisnessLegalName(buisnessName);
		myStore.enterStoreAddress("12345");
		myStore.clickOnFirstSuggestion();
		myStore.enterPhone("9860157365");
		myStore.clickOnSaveBtn();
		Assertions.assertEquals(myStore.getLabel(), buisnessName);
		Assertions.assertEquals(myStore.getTypeOfBuisnessRunningSelectedOptn(),"Gourment food");
	}
	
	}
