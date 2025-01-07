package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.GiftCardDashboard;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class giftCardTest extends BaseTest {

    KadeSession session = new KadeSession();
    GiftCardDashboard gift = new GiftCardDashboard();

    @Test(description = "Log01 : Gift Dashboard Card Page Navigation and Verify title")
    public void tc01_GiftCardDashboard_PageNavigation() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        WebdriverWaits.sleep(3000);
        gift.manageBusinessDropdown();
        String actualTitle = session.getDashBoardPage().getPageTitle();
        System.out.println("#############"+actualTitle);
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();

        session.giftCardDashboard();

        Assertions.assertTrue(gift.getGiftCardDashboardPageLink().isDisplayed());
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.getManageBusinessDropdown().click();
            //Verify Gift Card Dashboard Page Title
            gift.isTitlePagePresentForGiftCardDashboardPage();
        }
    }

    @Test(description = "Log02 : Gift Dashboard Card Page Navigation and Verify Page Components")
    public void tc02_VerifyPageComponentsOnGiftCardDashboard() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Verify Gift Card Dashboard Page Title
            Assertions.assertTrue(gift.ContinueButton().isDisplayed());
            Assertions.assertTrue(gift.RememberToggleButton().isDisplayed());
            Assertions.assertTrue(gift.StoresDropDown().isDisplayed());
        }
    }



    @Test(description = "Log03 : Select Store from Dropdown from Gift Dashboard Card Page , verify Navigation and Verify title")
    public void tc03_VerifyPageComponentsOnGiftCardDashboard() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            WebdriverWaits.sleep(3000);
            gift.DropDownOption().click();
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.BusinessFlowPagetitle().isDisplayed());
        }
    }

    @Test(description = "Log04 : Verify if Giftcard is enabled or not")
    public void tc04_VerifyGiftCardIsEnabledOrNot() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            WebdriverWaits.sleep(3000);
            gift.DropDownOption().click();
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            WebdriverWaits.sleep(3000);
            gift.ConfigurationButtonWhenDisabled().click();
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("far fa-toggle-on fa-rotate-180 custom-check-off")) {
                System.out.println("Gift Card is Disabled");
            } else System.out.println("Gift Card is Enabled.");

        }
    }

    @Test(description = "Log05 : Verify if Giftcard is enabled or not,Make it enable and Save Configuration")
    public void tc05_EnableGiftCardAndSaveConfiguration() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            WebdriverWaits.sleep(3000);
            gift.DropDownOption().click();
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            WebdriverWaits.sleep(3000);
            gift.ConfigurationButtonWhenDisabled().click();
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.SaveConfigurationButton().click();
                WebdriverWaits.sleep(3000);
                System.out.println("CONFIGURATION SAVED!!!");
            } else System.out.println("Gift Card is Enabled.");
        }


    }



    @Test(description = "Log06 : Configure Gift Card Details and Save Configuration")
    public void tc06_ConfigureGiftCardDetailsAndSaveConfiguration() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            WebdriverWaits.sleep(3000);
            gift.DropDownOption().click();
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            WebdriverWaits.sleep(3000);

            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.ReferenceNumberToggleButton().click();
                gift.FundingSourceToggleButton().click();
                gift.SaveConfigurationButton().click();
                WebdriverWaits.sleep(3000);
                System.out.println("CONFIGURATION SAVED!!!");
            } else System.out.println("Gift Card is Enabled.");
        }
    }

    @Test(description = "Log07 : Verify If the Gift Card is Enable and Verify Links Present")
    public void tc07_VerifyIfTheGiftCardIsEnablee() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            //  WebdriverWaits.sleep(3000);
            gift.DropDownOption().click();
            //  WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            //  WebdriverWaits.sleep(3000);

            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            //  WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                System.out.println("Gift Card is Disabled");
            } else System.out.println("Gift Card is Enabled.");
        }
    }


    @Test(description = "Log08 : Verify If the Gift Card is Enable and Verify Links Present")
    public void tc08_VerifyIfTheGiftCardIsEnable() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            gift.DropDownOption().click();
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }

            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                System.out.println("Gift Card is Disabled");
            } else System.out.println("Gift Card is Enabled.");
        }
    }

    @Test(description = "Log09 : Verify If the New Gift Card Addition Link is Present")
    public void tc09_VerifyIfNewGiftCardAdditionLinkPresent() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            gift.DropDownOption().click();
            gift.ContinueButton().click();

            if (gift.isIssueANewGiftCardLinkPresent()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }

            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");

            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.SaveConfigurationButton().click();
                gift.isIssueANewGiftCardLinkPresent();

            } else {
                System.out.println("Gift Card is Enabled.");
                gift.isIssueANewGiftCardLinkPresent();
            }

        }
    }

    @Test(description = "Log10 : Verify If the Filter Icon Link is Present")
    public void tc10_VerifyIfFilterIconLinkLinkPresent() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            gift.StoresDropDown().click();
            gift.DropDownOption().click();
            gift.ContinueButton().click();

            if (gift.isIssueANewGiftCardLinkPresent()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }

            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");

            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.SaveConfigurationButton().click();
                gift.isIssueANewGiftCardLinkPresent();
                gift.GiftCardForSaleLinkPresent();

            } else {
                System.out.println("Gift Card is Enabled.");
                gift.isIssueANewGiftCardLinkPresent();
                gift.GiftCardForSaleLinkPresent();
            }

        }
    }

    @Test(description = "Log11 : Verify If the Filter Icon Link is Present")
    public void tc11_VerifyIfFilterIconLinkLinkPresent() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.isFiltersButtonOnConfigurationPagePresent();
        }
    }





    @Test(description = "Log11 : Verify If Select Store to Continue default message is present or not on Gift Card Dashboard Page")
    public void tc11_VerifyIfSelectStoreToContinueTextPresent() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();

            //Verify if Select Store To Continue Message is displayed on Gift Card Dashboard Page
            gift.isSelectStoreToContinueTextPresent();

        }


    }


@Test(description = "Log12 : Verify If All Default Page Components are present or not on Gift Card Dashboard Page")
public void tc12_VerifyIfAllDefaultPageComponentsPresent() {
    KadeSession session = KadeSession.login(KadeUserAccount.Default);
    String actualTitle = session.getDashBoardPage().getPageHeader();
    //Verify Title of the Dashboard Page
    String expectedTitle = "Transactions";
    Assertions.assertEquals(actualTitle, expectedTitle);
    //Click on the Manage Businesses
    gift.getManageBusinessDropdown().click();
    //Verify if Gift Card Dashboard Page Link is Present or not
    if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
        //Click on the Gift Card Dashboard Page
        gift.GiftcardLink().click();

        //Verify if Select Store To Continue Message is displayed on Gift Card Dashboard Page
        gift.isSelectStoreToContinueTextPresent();
        gift.isWhichStoreTextTextPresent();
        gift.isStoresDropdownTextPresent();
        gift.isStoresDropDownPresent();
        gift.isContinueButtonPresent();
        gift.isRememberToggleButtonPresent();

    }


}

    @Test(description = "Log13 : Verify If Store Manage is able to select any kind of store from list of Multiple stores on Gift Card Dashboard Page")
    public void tc13_VerifyIfStoreManageAbleToSelectMultipleStores() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();

            //Verify if Select Store To Continue Message is displayed on Gift Card Dashboard Page
            gift.isSelectStoreToContinueTextPresent();
            gift.isWhichStoreTextTextPresent();
            gift.isStoresDropdownTextPresent();
            gift.isStoresDropDownPresent();
            gift.isContinueButtonPresent();
            gift.isRememberToggleButtonPresent();
            gift.selectStore("Automation QR Code");

        }


    }

    @Test(description = "Log14 : Verify If Store seleted name should be properly displayed on the store textbox on Gift Card Dashboard Page")
    public void tc14_VerifyIfStoreSelectedNameShouldBeProperlyDisplayed() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation QR Code");
        }


    }



    @Test(description = "Log15 : Verify If Store seleted name should be properly displayed on the store textbox on Gift Card Dashboard Page")
    public void tc15_VerifyIf() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");

            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();


            if(gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            }else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.ReferenceNumberToggleButton().click();
                WebdriverWaits.sleep(3000);
                gift.FundingSourceToggleButton().click();
                WebdriverWaits.sleep(3000);
                gift.getTextAreaInFundingAreaField().setText("Test Description");
                gift.MaxGiftAmountTextbox().setText("100");
                gift.SaveConfigurationButton().click();
                WebdriverWaits.sleep(3000);
                System.out.println("CONFIGURATION SAVED!!!");

                gift.ConfigurationButtonWhenEnabled().click();

                Assertions.assertEquals("custom-checkbox mb-3 checked", gift.EnableToggleSwitchForGiftCard().getAttribute("class"));
                Assertions.assertEquals("far fa-toggle-on custom-check-on",gift.ReferenceNumberToggleButton().getAttribute("class"));
                Assertions.assertEquals("far fa-toggle-on custom-check-on",gift.ReferenceNumberToggleButton().getAttribute("class"));

            } else System.out.println("Gift Card is Enabled.");
        }

        }



    @Test(description = "Log16 : Verify that all the settings get saved, even after setting the 'Managing, accepting and issuing Gift Cards' toggle button to Disable while configuring the Gift Card.")
    public void tc16_VerifyIf() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();

        //Code for Configuration Button Click
           gift.ClickOnConfigurationLinkOfGiftCardDashboard();


          //If Toggle Button is disabled
            if (gift.EnableToggleSwitchForGiftCard().getAttribute("class").equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.updateConfigurationOnGiftCardPage("Add Test Description when disabled","10000");
                gift.SaveConfigurationButton().click();
                System.out.println("CONFIGURATION SAVED!!!");
            } else {
                System.out.println("Gift Card is Enabled.");
                gift.EnableToggleSwitchForGiftCard().click();
                gift.SaveConfigurationButton().click();
                System.out.println("CONFIGURATION SAVED!!!");
            }
        }

    }



    @Test(description = "Log17 : Verify that all the settings get saved, even after setting the 'Managing, accepting and issuing Gift Cards' toggle button to Disable while configuring the Gift Card.")
    public void tc17_VerifyIf() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();

            //Code for Configuration Button Click
            gift.ClickOnConfigurationLinkOfGiftCardDashboard();


            //If Toggle Button is disabled
            if (gift.EnableToggleSwitchForGiftCard().getAttribute("class").equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                WebdriverWaits.sleep(3000);
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.MaxGiftAmountTextbox().setText("999999999");

                gift.SaveConfigurationButton().click();
                System.out.println("CONFIGURATION SAVED!!!");
            } else {
                System.out.println("Gift Card is Enabled.");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.EnableToggleSwitchForGiftCard().click();
                gift.MaxGiftAmountTextbox().setText("999999999");
                gift.SaveConfigurationButton().click();
                System.out.println("CONFIGURATION SAVED!!!");
            }

            WebdriverWaits.sleep(10000);
            //Code for Configuration Button Click
            gift.ClickOnConfigurationLinkOfGiftCardDashboard();
            WebdriverWaits.sleep(3000);
            Assertions.assertEquals(gift.MaxGiftAmountTextboxValue(), "9999.99");

        }

    }


    @Test(description = "Log18 : Verify Error Message for Maximum Gift Card Amount")
    public void tc18_VerifyErrorMessageForMaxAmountGiftCard() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            //Code for Configuration Button Click
            gift.ClickOnConfigurationLinkOfGiftCardDashboard();
            //If Toggle Button is disabled
            if (gift.EnableToggleSwitchForGiftCard().getAttribute("class").equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                WebdriverWaits.sleep(3000);
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
                gift.EnableToggleSwitchForGiftCard().click();

            }

            gift.MaxGiftAmountTextbox().setText("0000000000");

            gift.SaveConfigurationButton().click();

            Assertions.assertTrue(gift.isErrorMessageForMaxGiftAmountFieldBlankPresent());



        }
        }


    @Test(description = "Log19 : Verify If All Configurations Are Saved and verified")
    public void tc19_VerifyIfAllConfigurationsAreSavedAndVerified() throws InterruptedException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");

            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();


            if(gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            }else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);

            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);

                //If Reference Toggle button is Disabled
                if(gift.ReferenceNumberToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.ReferenceNumberToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }

                //If Funding Source Option is disabled
                if(gift.FundingSourceToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.FundingSourceToggleButton().click();
                    WebdriverWaits.sleep(3000);
                    gift.getTextAreaInFundingAreaField().setText("Test Description");
                }
                gift.MaxGiftAmountTextbox().setText("1000");
                gift.SaveConfigurationButton().click();
                WebdriverWaits.sleep(5000);
                System.out.println("CONFIGURATION SAVED!!!");

            } else {
                System.out.println("Gift Card is Enabled.");

                //If Reference Toggle button is Disabled
                if(gift.ReferenceNumberToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.ReferenceNumberToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }else {
                    gift.ReferenceNumberToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }

                //If Funding Source Option is disabled
                if(gift.FundingSourceToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.FundingSourceToggleButton().click();
                    WebdriverWaits.sleep(3000);
                    gift.getTextAreaInFundingAreaField().setText("Test Description");
                }else {
                    gift.FundingSourceToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }
                gift.MaxGiftAmountTextbox().setText("1000");
                gift.SaveConfigurationButton().click();
                WebdriverWaits.sleep(5000);
                System.out.println("CONFIGURATION SAVED!!!");
            }
        }

    }



    @Test(description = "Log20 : Verify that 'Gift Cards Configuration' popup closes after clicking on 'Cross' icon, without any changes on 'Gift Cards Configuration' popup of 'Gift Cards Dashboard' page")
    public void tc20_VerifyCrossIconOnGiftCardConfigurationPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");

            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();

            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            gift.closeButtonOnConfigurationPopup().click();
            WebdriverWaits.sleep(3000);

            Assertions.assertTrue(gift.GiftCardDashboardPageTitlePresent());


        }


    }

    @Test(description = "Log21 : Verify If All Page Components of Issue A New Gift Card is Present or not")
    public void tc21_VerifyIfAllPageComponentsOfIssueANewGiftCardPresent(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(13000);

            Assertions.assertTrue(gift.isIssueAGiftCardFormTitlePresent());
            Assertions.assertTrue(gift.isYouAreIssuingGiftCardMessageOnFormTextPresent());
            Assertions.assertTrue(gift.isCustomerBlockOnIssueGiftCardFormPresent());
            Assertions.assertTrue(gift.isInitialAmountTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isCurrencyIconOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isInitialAmountTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isMessageToTheReceiverMessageTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isMessageToTheReceiverMessageTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isReferenceNumberTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isReferenceNumberTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isMoreOptionsButtonOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isCreateButtonOnIssueNewGiftCardFormPresent());

        }
    }


    @Test(description = "Log23 : Verify Error Message For Blank Fields on Issue A New Gift Card Page ")
    public void tc23_VerifyIfErrorMessageForBlankFieldsOnIssueANewGiftCardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(13000);
            gift.createButtonOnIssueNewGiftCardForm().click();
            WebdriverWaits.sleep(1000);
            gift.isErrorMessageOnIssueANewGiftCardPagePresent();

        }


    }


    @Test(description = "Log24 : Verify If Additional Page Components Present On Issue A New Gift Card Page")
    public void tc24_VerifyIfAdditionalPageComponentsPresentOnIssueANewGiftCardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(13000);

             gift.moreOptionsButtonOnIssueNewGiftCardForm().click();
            WebdriverWaits.sleep(3000);

            Assertions.assertTrue(gift.isCardNumberTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isCardNumberTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isFundingSourceTitleOnIssueNewGiftCardFormPresent());
           // Assertions.assertTrue(gift.isFundingSourceTextboxOnIssueNewGiftCardFormresent());
            Assertions.assertTrue(gift.isMemoTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isMemoTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isStartDateTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isStartDateTextboxOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isExpDateTitleOnIssueNewGiftCardFormPresent());
            Assertions.assertTrue(gift.isExpDateTextboxOnIssueNewGiftCardFormPresent());



        }


    }

    @Test(description = "Log25 : Verify Functionality of Close Icon On Issue A New Gift Card Page")
    public void tc25_VerifyIfFunctionalityOfCloseIconOnIssueANewGiftCardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(13000);

            gift.moreOptionsButtonOnIssueNewGiftCardForm().click();
            WebdriverWaits.sleep(3000);

            gift.closeIconOnIssueANewGiftCardPage().click();
            WebdriverWaits.sleep(3000);

            gift.isIssueANewGiftCardLinkPresent();
        }


    }

    @Test(description = "Log26 : Verify if all page components are present on Issue a new gift card page")
    public void tc26_VerifyAllComponentsOnIssueANewGiftCardPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");

                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);

                //If Reference Toggle button is Disabled
                if(gift.ReferenceNumberToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.ReferenceNumberToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }

                //If Funding Source Option is disabled
                if(gift.FundingSourceToggleButton().getAttribute("class").equals("far fa-toggle-on fa-rotate-180 custom-check-off ")) {
                    gift.FundingSourceToggleButton().click();
                    WebdriverWaits.sleep(3000);
                    gift.getTextAreaInFundingAreaField().setText("Test Description");
                }

                gift.MaxGiftAmountTextbox().setText("100000");
            } else {
                System.out.println("Gift Card is Enabled.");

                //If Reference Toggle button is Disabled
               if(gift.ReferenceNumberToggleButton().getText().equals("Reference No. is optional")){
                    gift.ReferenceNumberToggleButton().click();
                    WebdriverWaits.sleep(3000);
                }

                //If Funding Source Option is disabled
                if(gift.FundingSourceToggleButton().getText().equals("Funding source is optional")) {
                    gift.FundingSourceToggleButton().click();
                    WebdriverWaits.sleep(3000);
                    gift.getTextAreaInFundingAreaField().setText("Test Description");
                }else gift.getTextAreaInFundingAreaField().setText("Test Description");

                gift.MaxGiftAmountTextbox().setText("100000");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(13000);

            gift.moreOptionsButtonOnIssueNewGiftCardForm().click();
            WebdriverWaits.sleep(3000);

           
            Assertions.assertEquals("",gift.referenceNumberTextboxOnIssueNewGiftCardForm().getText());

            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("abcdef");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Card Number Entered ###"+gift.cardNumberTextboxOnIssueNewGiftCardForm().getText());
            WebdriverWaits.sleep(5000);
            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("");

            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("@#$%^&");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Card Number Entered ###"+gift.cardNumberTextboxOnIssueNewGiftCardForm().getText());
            WebdriverWaits.sleep(5000);
            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("");

            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("12345678901234567890");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Card Number Entered ###"+gift.cardNumberTextboxOnIssueNewGiftCardForm().getText());
            WebdriverWaits.sleep(5000);
            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("");

            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("12345");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Card Number Entered ###"+gift.cardNumberTextboxOnIssueNewGiftCardForm().getText());
            WebdriverWaits.sleep(5000);
            gift.cardNumberTextboxOnIssueNewGiftCardForm().setText("");

            gift.SelectOptionForFundingTextbox("Test Description");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Funding Source Dropdown Entered ###"+gift.fundingSourceTextboxOnIssueNewGiftCardForm().getText());

            gift.memoTextboxOnIssueNewGiftCardForm().setText("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890abcde");
            WebdriverWaits.sleep(5000);
            System.out.println("#### Memo Value Entered ###"+gift.memoTextboxOnIssueNewGiftCardForm().getText());

            gift.startDateTextboxOnIssueNewGiftCardForm().setText("01/01/2025");
            WebdriverWaits.sleep(10000);

            gift.expDateTextboxOnIssueNewGiftCardForm().setText("01/01/2025");
            WebdriverWaits.sleep(10000);
        }


    }

    @Test(description = "Log22 : Verify If Every Component is present on the Customer form")
    public void tc22_VerifyIfAllComponentsPresentOnCustomerPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(13000);

            Assertions.assertTrue(gift.isCustomerFormTitlePresent());
            Assertions.assertTrue(gift.isPhoneNumberOnCustomerFormPresent());
            Assertions.assertTrue(gift.isPhoneNumberOnCustomerFormPresent());
            Assertions.assertTrue(gift.isGoButtonForPhoneNumberOnCustomerFormPresent());
            Assertions.assertTrue(gift.isEmailOnCustomerFormPresent());
            Assertions.assertTrue(gift.isSearchOnCustomerFormPresent());
            Assertions.assertTrue(gift.isGoButtonForEmailOnCustomerFormPresent());
            Assertions.assertTrue(gift.isCloseIconOnCustomerFormPresent());

        }


    }

    @Test(description = "Log27 : Verify Error Messages of Every Component is present on the Customer form")
    public void tc27_VerifyErrorMessageForPageComponentsOnCustomerPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(13000);

            gift.GoButtonForEmailOnCustomerForm().click();
            gift.GoButtonForPhoneNumberOnCustomerForm().click();
            gift.searchIconOnCustomerPage().click();
            WebdriverWaits.sleep(3000);

            Assertions.assertTrue(gift.isErrorMessageForEmailOnCustomerFormPresent());
            Assertions.assertTrue(gift.isErrorMessageForEmailOnCustomerFormPresent());
            Assertions.assertTrue(gift.isErrorMessageOfNoSearchResultOnCustomerPagePresent());
            WebdriverWaits.sleep(3000);
        }


    }

    @Test(description = "Log28 : Verify Customer Search functionality on the Customer form")
    public void tc28_VerifySearchExistingCustomerSearchOnCustomerPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(13000);

            gift.GoButtonForEmailOnCustomerForm().click();
            gift.GoButtonForPhoneNumberOnCustomerForm().click();
            gift.searchIconOnCustomerPage().click();
            WebdriverWaits.sleep(3000);

            gift.searchTextboxOnCustomerPage().setText("Lucas");
            gift.searchIconOnCustomerPage().click();
            WebdriverWaits.sleep(3000);

        }


    }

    @Test(description = "Log29 : Verify Customer Select on successful search functionality on the Customer form")
    public void tc29_VerifyCustomerSelectFunctionalityOnSuccessfulCustomerSearchOnCustomerPage(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(13000);

            gift.searchTextboxOnCustomerPage().setText("Lucas");
            gift.searchIconOnCustomerPage().click();

        //    gift.isPhoneNumberOnCustomerFormPresent();
            WebdriverWaits.sleep(3000);

           // gift.firstSearchEntryOnCustomerPageClick();

        }


    }

    @Test(description = "Log30 : Verify Customer Searched by Phone Number Should be successfully selected as Customer on the Customer form")
    public void tc30_VerifyCustomerSearchedByPhoneNumber(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(3000);

           gift.phoneNumberOnCustomerForm().setText("(646)5551106");
           gift.GoButtonForPhoneNumberOnCustomerFormClick().click();
            WebdriverWaits.sleep(3000);

            Assertions.assertEquals("Marry\n" +
                            "+1 (646) 555 1106",gift.customerBlockOnIssueGiftCardFormFormm().getText());

        }


    }


    @Test(description = "Log31 : Verify Customer Searched by Email Should be successfully selected as Customer on the Customer form")
    public void tc31_VerifyCustomerSearchedByEmail(){
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.getManageBusinessDropdown().click();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.getGiftCardDashboardPageLink().isDisplayed()) {
            //Click on the Gift Card Dashboard Page
            gift.GiftcardLink().click();
            //Select any Store and verify title
            gift.selectStore("Automation flow 2");
            WebdriverWaits.sleep(3000);
            gift.ContinueButton().click();
            if (gift.IssueANewGiftCardLink()) {
                gift.ConfigurationButtonWhenEnabled().click();
            } else {
                gift.ConfigurationButtonWhenDisabled().click();
            }
            WebdriverWaits.sleep(3000);
            String str = gift.EnableToggleSwitchForGiftCard().getAttribute("class");
            System.out.println("##############" + str);
            if (str.equals("custom-checkbox mb-3")) {
                System.out.println("Gift Card is Disabled");
                gift.EnableToggleSwitchForGiftCard().click();
                WebdriverWaits.sleep(3000);
            } else {
                System.out.println("Gift Card is Enabled.");
            }
            gift.SaveConfigurationButton().click();
            WebdriverWaits.sleep(3000);
            Assertions.assertTrue(gift.isIssueANewGiftCardLinkPresent());
            WebdriverWaits.sleep(3000);

            gift.IssueANewGiftCardLinkClick().click();
            WebdriverWaits.sleep(6000);
            gift.customerBlockOnIssueGiftCardFormFormm().click();
            WebdriverWaits.sleep(3000);

            gift.emailOnCustomerForm().setText("yonro@yopmail.com");
            gift.GoButtonForEmailOnCustomerForm().click();
            WebdriverWaits.sleep(3000);

            Assertions.assertEquals("yonro\n" +
                    "yonro@yopmail.com",gift.customerBlockOnIssueGiftCardFormFormm().getText());

        }


    }


}






