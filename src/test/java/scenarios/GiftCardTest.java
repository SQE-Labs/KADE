package scenarios;

import org.automation.base.BaseTest;
import org.automation.data.KadeUserAccount;
import org.automation.pages.GiftCardDashboard;
import org.automation.session.KadeSession;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.lang.Boolean.TRUE;


public class GiftCardTest extends BaseTest {

    KadeSession session = new KadeSession();
    GiftCardDashboard gift = new GiftCardDashboard();

    @Test(description = "Log01 : Gift Dashboard Card Page Navigation and Verify title")
    public void tc01_GiftCardDashboard_PageNavigation() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            //Verify Gift Card Dashboard Page Title
            gift.isTitlePagePresentForGiftCardDashboardPage();
        }
    }
    @Test(description = "Log02 : Gift Dashboard Card Page Navigation and Verify title")
    public void tc02_VerifyPageComponentsOnGiftCardDashboard() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            //Verify Gift Card Dashboard Page Title
            Assertions.assertTrue(gift.isWhichStoreTextPresent());
            Assertions.assertTrue(gift.isSelectStoreToContinueTextPresent());
            Assertions.assertTrue(gift.isStoresDropdownTextPresent());
            Assertions.assertTrue(gift.isContinueButtonPresent());
            Assertions.assertTrue(gift.isRememberToggleButtonPresent());
            Assertions.assertTrue(gift.isStoresDropDownPresent());
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
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            gift.clickOnDropDown();
            WebdriverWaits.sleep(3000);
            gift.DropdownOption();
            WebdriverWaits.sleep(3000);
            gift.clickOnContinueButton();
            WebdriverWaits.sleep(3000);
            gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();




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
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            gift.clickOnDropDown();
            WebdriverWaits.sleep(3000);
            gift.DropdownOption();
            WebdriverWaits.sleep(3000);
            gift.clickOnContinueButton();
            WebdriverWaits.sleep(3000);
            gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();
            if (gift.isGiftCardDisableMessagePresent()) {
                gift.clickOnConfigurationButton();
                gift.isTitlePagePresentForGiftCardDashboardPage();

            }
        }
    }


    @Test(description = "Log05 : Enable the Gift card if it is disabled and Save Configuration")
    public void tc05_EnableGiftCardAndSaveConfiguration() {
            KadeSession session = KadeSession.login(KadeUserAccount.Default);
            String actualTitle = session.getDashBoardPage().getPageHeader();
            //Verify Title of the Dashboard Page
            String expectedTitle = "Transactions";
            Assertions.assertEquals(actualTitle, expectedTitle);
            //Click on the Manage Businesses
            gift.clickOnManageBusinessDropdown();
            //Verify if Gift Card Dashboard Page Link is Present or not
            if (gift.isGiftCardDashboardPageLinkPresent()) {
                //Click on the Gift Card Dashboard Page
                gift.clickOnGiftcardLink();
                gift.clickOnDropDown();
                WebdriverWaits.sleep(3000);
                gift.DropdownOption();
                WebdriverWaits.sleep(3000);
                gift.clickOnContinueButton();
                WebdriverWaits.sleep(3000);
                gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();
                if(gift.isGiftCardDisableMessagePresent()){
                    gift.clickOnConfigurationButton();
                    gift.isTitlePagePresentForGiftCardDashboardPage();
                    gift.clickOnEnableToggleSwitchForGiftCard();
                    gift.clickOnSaveConfigurationButton();
                }
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
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            gift.clickOnDropDown();

            gift.DropdownOption();

            gift.clickOnContinueButton();

            gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();
            if(gift.isGiftCardDisableMessagePresent()){
                gift.clickOnConfigurationButton();
                gift.isTitlePagePresentForGiftCardDashboardPage();
                gift.clickOnEnableToggleSwitchForGiftCard();
                gift.clickOnFundingSourceToggleButtonButtonForGiftCard();
                gift.clickOnReferenceNumberToggleButtonForGiftCard();
                gift.clickOnSaveConfigurationButton();
            }
        }
    }




    @Test(description = "Log07 : Verify If the Gift Card is Enable and Verify Links Present")
    public void tc07_VerifyIfTheGiftCardIsEnable() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            gift.clickOnDropDown();
            gift.DropdownOption();
            gift.clickOnContinueButton();
            gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();
            if (gift.isIssueANewGiftCardLinkLinkPresent()) {
                System.out.println("NOT DISABLE");
            }
        }


    }

    @Test(description = "Log08 : Verify If the New Gift Card Addition Link is Present")
    public void tc08_VerifyIfNewGiftCardAdditionLinkPresent() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        String actualTitle = session.getDashBoardPage().getPageHeader();
        //Verify Title of the Dashboard Page
        String expectedTitle = "Transactions";
        Assertions.assertEquals(actualTitle, expectedTitle);
        //Click on the Manage Businesses
        gift.clickOnManageBusinessDropdown();
        //Verify if Gift Card Dashboard Page Link is Present or not
        if (gift.isGiftCardDashboardPageLinkPresent()) {
            //Click on the Gift Card Dashboard Page
            gift.clickOnGiftcardLink();
            gift.clickOnDropDown();
            WebdriverWaits.sleep(3000);
            gift.DropdownOption();
            WebdriverWaits.sleep(3000);
            gift.clickOnContinueButton();
            WebdriverWaits.sleep(3000);
            gift.VerifyTitleOnAutomatedBusinessFlowPageOngiftcard();
            if(gift.isGiftCardDisableMessagePresent()){

                gift.EnableGiftCardIfDisabled();
            }
            gift.isIssueANewGiftCardLinkLinkPresent();

        }

    }
}
