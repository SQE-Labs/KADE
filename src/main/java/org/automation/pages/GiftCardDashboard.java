package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GiftCardDashboard extends BasePage {



    By manageBusinessDropdown=By.xpath("//a[contains(text(),'Manage Business')]");
    By GiftcardLink=By.linkText("Gift Cards Dashboard");
    By GiftCardDashboardPageTitle=By.xpath("//h1[contains(text(),'Gift Cards Dashboard')]");
    By WhichStoreText=By.xpath("//p[contains(text(),'Which store?')]");
    By SelectStoreToContinueText=By.xpath("//h4[contains(text(),'Please select a store to continue')]");
    By StoresDropdownText=By.xpath("//lable[contains(text(),'Stores :')]");
    By StoresDropDown=By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
    By SelectStoresDropdownOption=By.xpath("//body[1]/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/select[1]");
    By ActualTextDisplayedAfterStoreSelected=By.xpath("//body[1]/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
    By ContinueButton=By.xpath("//button[contains(text(),'Continue')]");
    By RememberToggleButton=By.xpath("//input[@id='customcheckbox']");
    By DropDownOption=By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[6]");
    By BusinessFlowPagetitle=By.xpath("//body[1]/div[4]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/h3[1]");
    By GiftCardDisabledMessage=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]");
    By ConfigurationButtonWhenDisabled=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/button[1]");
    By ConfigurationButtonWhenEnabled=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/button[1]");
    By GiftCardConfigurationPageTitle=By.xpath("//h5[contains(text(),'Gift Cards Configuration')]");
    By EnableToggleSwitchForGiftCard=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/label[1]");
    By SaveConfigurationButton=By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");
    By ReferenceNumberToggleButton=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]");
    By FundingSourceToggleButton=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]");
    By TextAreaInFundingArea=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/textarea[1]");
    By MaxGiftAmountTextbox=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/input[1]");
    By ErrorMessageForMaxGiftAmountFieldBlank=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/p[1]");
    By closeButtonOnConfigurationPopup=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[1]/button[1]");
    By IssueANewGiftCardLink=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/button[2]");
    By GiftCardForSaleLink=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    By FiltersButtonOnConfigurationPage=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[3]/div[1]/button[1]/i[1]");
    By IssueAGiftCardFormTitle=By.xpath("//h5[contains(text(),'Issue a new gift card')]");
    By YouAreIssuingGiftCardMessageOnForm=By.xpath("//p[contains(text(),'You are issuing a new gift card for your customer.')]");
    By customerBlockOnIssueGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    By customerBlockOnIssueGiftCard=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]");
    By initialAmountTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Initial amount')]");
    By currencyIconOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/span[1]");
    By initialAmountTextboxOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]");
    By messageToTheReceiverMessageTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Message to the receiver')]");
    By messageToTheReceiverMessageTextboxOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/textarea[1]");
    By referenceNumberTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Reference No.')]");
    By referenceNumberTextboxOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/input[1]");
    By moreOptionsButtonOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/a[1]");
    By createButtonOnIssueNewGiftCardForm=By.xpath("//button[contains(text(),'Create')]");

    By customerForm=By.xpath("//span[contains(text(),'Customer')]");
    By phoneNumberOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[2]/input[1]");
    By GoButtonForEmailOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[2]/div[2]/button[1]");
    By emailOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[2]/div[2]/input[1]");
    By GoButtonForPhoneNumberOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[2]/button[1]");
    By searchOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/input[1]");
    By searchIconOnCustomerPage=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/button[1]/i[1]");
    By searchTextboxOnCustomerPage=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/input[1]");
    By errorMessageForPhoneNumberOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]");
    By errorMessageForEmailOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[2]/div[1]");
    By ThereAreNoResultsMessageOnCustomerForm=By.xpath("//body[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/p[1]");
    By closeIconOnCustomerForm=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
    By errorMessageOfNoSearchResultOnCustomerPage=By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]");
    By firstSearchEntryOnCustomerPage=By.xpath("//body[1]/div[14]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]");

    By cardNumberTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Card No')]");
    By cardNumberTextboxOnIssueNewGiftCardForm=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[1]/input[1]");
    By fundingSourceTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Funding source')]");
    By fundingSourceTextboxOnIssueNewGiftCardForm=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[2]/select[1]");
    By memoTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Memo')]");
    By memoTextboxOnIssueNewGiftCardForm=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[3]/textarea[1]");
    By startDateTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Start Date:')]");
    By startDateTextboxOnIssueNewGiftCardForm=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[4]/div[1]/input[1]");
    By expDateTitleOnIssueNewGiftCardForm=By.xpath("//label[contains(text(),'Exp. Date:')]");
    By expDateTextboxOnIssueNewGiftCardForm=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[5]/div[1]/input[1]");



    By errorMessageOnIssueANewGiftCardPage=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[8]/div[1]/div[1]/p[1]");
    By closeIconOnIssueANewGiftCardPage=By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[1]");

//    By =By.xpath("");
//    By =By.xpath("");
//    By =By.xpath("");
//    By =By.xpath("");
//    By =By.xpath("");

//
//


    public Clickable manageBusinessDropdown() {
        WebdriverWaits.waitForElementVisible(manageBusinessDropdown,5);
        return  Clickable.getElementBy(manageBusinessDropdown);
    }


    public Clickable getManageBusinessDropdown() {
        return Clickable.getElementBy(manageBusinessDropdown, "Manage Business Dropdown");
    }

    public Editable getGiftCardDashboardPageLink() {
        return Editable.getElementBy(GiftcardLink, "Issue Gift Card Link");
    }

    public Clickable GiftcardLink() {
        return Clickable.getElementBy(GiftcardLink, "Gift card Dashboard Link");
    }

    public boolean isSelectStoreToContinueTextPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(SelectStoreToContinueText, 5);
            return isElementPresent(SelectStoreToContinueText, "Select Store To Continue Default Text Message is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isWhichStoreTextTextPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(WhichStoreText, 5);
            return isElementPresent(WhichStoreText, "Which Store Text Message is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isStoresDropdownTextPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(StoresDropdownText, 5);
            return isElementPresent(StoresDropdownText, "Stores Dropdown Text is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isStoresDropDownPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(StoresDropDown, 5);
            return isElementPresent(StoresDropDown, "Stores Dropdown is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isContinueButtonPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(ContinueButton, 5);
            return isElementPresent(ContinueButton, "Continue Button is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isRememberToggleButtonPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(RememberToggleButton, 5);
            return isElementPresent(RememberToggleButton, "Remember Toggle Button is present");
        } catch (RuntimeException e) {
            return false;
        }

    }



    public void selectStore(String store){
        selectDropDownByVisibleText_custom(SelectStoresDropdownOption,store);
        AssertionForSelectedStoreNameToBeDisplayedCorrectly(store);
    }

    public void AssertionForSelectedStoreNameToBeDisplayedCorrectly(String expectedSelectedStore){
        String actualSelectedStore = getDriver().findElement(ActualTextDisplayedAfterStoreSelected).getText();
        Assertions.assertEquals(actualSelectedStore, expectedSelectedStore);
    }



















    public Clickable ContinueButton() {
        WebdriverWaits.waitForElementVisible(ContinueButton,5);
        return  Clickable.getElementBy(ContinueButton);
    }

    public Clickable RememberToggleButton() {
        WebdriverWaits.waitForElementVisible(RememberToggleButton,5);
        return  Clickable.getElementBy(RememberToggleButton);
    }

    public Clickable StoresDropDown() {
        WebdriverWaits.waitForElementVisible(StoresDropDown,5);
        return  Clickable.getElementBy(StoresDropDown);
    }

    public Clickable DropDownOption() {
        WebdriverWaits.waitForElementVisible(DropDownOption,5);
        return  Clickable.getElementBy(DropDownOption);
    }

    public Clickable BusinessFlowPagetitle() {
        WebdriverWaits.waitForElementVisible(BusinessFlowPagetitle,5);
        return  Clickable.getElementBy(BusinessFlowPagetitle);
    }

    public Clickable EnableToggleSwitchForGiftCard() {
        WebdriverWaits.waitForElementVisible(EnableToggleSwitchForGiftCard,5);
        return  Clickable.getElementBy(EnableToggleSwitchForGiftCard);
    }

    public Clickable ConfigurationButtonWhenDisabled() {
        WebdriverWaits.waitForElementVisible(ConfigurationButtonWhenDisabled,5);
        return  Clickable.getElementBy(ConfigurationButtonWhenDisabled);
    }

    public Clickable ConfigurationButtonWhenEnabled() {
        WebdriverWaits.waitForElementVisible(ConfigurationButtonWhenEnabled,5);
        return  Clickable.getElementBy(ConfigurationButtonWhenEnabled);
    }



    public Clickable SaveConfigurationButton() {
        WebdriverWaits.waitForElementVisible(SaveConfigurationButton,5);
        return  Clickable.getElementBy(SaveConfigurationButton);
    }

    public Clickable ReferenceNumberToggleButton() {
        WebdriverWaits.waitForElementVisible(ReferenceNumberToggleButton,5);
        return  Clickable.getElementBy(ReferenceNumberToggleButton);
    }

    public Clickable FundingSourceToggleButton() {
        WebdriverWaits.waitForElementVisible(FundingSourceToggleButton,5);
        return  Clickable.getElementBy(FundingSourceToggleButton);
    }


    public Clickable closeButtonOnConfigurationPopup() {
        WebdriverWaits.waitForElementVisible(closeButtonOnConfigurationPopup,5);
        return  Clickable.getElementBy(closeButtonOnConfigurationPopup);
    }



    public Clickable TextAreaInFundingArea() {
        WebdriverWaits.waitForElementVisible(TextAreaInFundingArea,5);
        return  Clickable.getElementBy(TextAreaInFundingArea);
    }

    public Editable MaxGiftAmountTextbox() {
        WebdriverWaits.waitForElementVisible(MaxGiftAmountTextbox,5);
        return Editable.getElementBy(MaxGiftAmountTextbox,"Text In Max Amount Textbox");
    }

    public String MaxGiftAmountTextboxValue() {
        WebdriverWaits.waitForElementVisible(MaxGiftAmountTextbox,5);
        System.out.println(MaxGiftAmountTextbox().getAttribute("value"));
        MaxGiftAmountTextbox().getAttribute("value").equals("9999.99");
        String str=MaxGiftAmountTextbox().getAttribute("value");
        System.out.println(MaxGiftAmountTextbox().getAttribute("value"));
        return str;
    }



    public boolean IssueANewGiftCardLink() {
        try {
            WebdriverWaits.waitForElementUntilVisible(IssueANewGiftCardLink, 5);
            return isElementPresent(IssueANewGiftCardLink, "Issue A New Gift Card Link is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Clickable moreOptionsButtonOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(moreOptionsButtonOnIssueNewGiftCardForm,5);
        return  Clickable.getElementBy(moreOptionsButtonOnIssueNewGiftCardForm);
    }

    public Clickable customerBlockOnIssueGiftCardFormForm() {
        WebdriverWaits.waitForElementVisible(customerBlockOnIssueGiftCardForm,5);
        return  Clickable.getElementBy(customerBlockOnIssueGiftCardForm);
    }

    public Clickable customerBlockOnIssueGiftCardFormFormm() {
        WebdriverWaits.waitForElementVisible(customerBlockOnIssueGiftCard,5);
        return  Clickable.getElementBy(customerBlockOnIssueGiftCard);
    }

    public boolean isIssueANewGiftCardLinkPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(IssueANewGiftCardLink, 5);
            return isElementPresent(IssueANewGiftCardLink, "Issue A New Gift Card Link is present");
        } catch (RuntimeException e) {
           return false;
        }

    }

    public Clickable IssueANewGiftCardLinkClick() {
        WebdriverWaits.waitForElementVisible(IssueANewGiftCardLink,5);
        return  Clickable.getElementBy(IssueANewGiftCardLink);
    }

    public boolean isFiltersButtonOnConfigurationPagePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(FiltersButtonOnConfigurationPage, 5);
            return isElementPresent(FiltersButtonOnConfigurationPage, "Filters Button On Configuration Page is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Clickable FiltersButtonOnConfigurationPage() {
        WebdriverWaits.waitForElementVisible(FiltersButtonOnConfigurationPage,5);
        return  Clickable.getElementBy(FiltersButtonOnConfigurationPage);
    }

    public boolean GiftCardForSaleLinkPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(GiftCardForSaleLink, 5);
            return isElementPresent(GiftCardForSaleLink, "Gift Card For Sale Link is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean GiftCardDashboardPageTitlePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(GiftCardDashboardPageTitle, 5);
            return isElementPresent(GiftCardDashboardPageTitle, "Gift Card Dashboard page title is present");
        } catch (RuntimeException e) {
            return false;
        }

    }




























    public boolean isIssueANewGiftCardLinkLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(IssueANewGiftCardLink, 5);
        System.out.println("Gift card Present!!!!!");
        return isElementPresent(IssueANewGiftCardLink,"Issue A New Gift Card Link");

    }

    public boolean isGiftCardForSaleLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftCardForSaleLink, 5);
        return isElementPresent(GiftCardForSaleLink,"Gift Card For Sale Link");
    }
//
//    public boolean isFiltersButtonOnPresent() {
//        WebdriverWaits.waitForElementUntilVisible(FiltersButtonOn, 5);
//        return isElementPresent(FiltersButtonOn,"Filters Button On Dashboard");
//    }
//
//    public void clickOnFiltersButtonOnGiftCardDashboard() {
//        click(FiltersButtonOn);
//
//    }



    public void writeOnTextAreaForGiftCard() {
        click(TextAreaInFundingArea);
        getDriver().findElement(TextAreaInFundingArea).sendKeys("Sample Text");
    }


    public Editable getTextAreaInFundingAreaField() {
        WebdriverWaits.waitForElementVisible(TextAreaInFundingArea,5);
        return Editable.getElementBy(TextAreaInFundingArea,"Text Area In Funding Area");
    }

    public void clickOnReferenceNumberToggleButtonForGiftCard() {
        click(ReferenceNumberToggleButton);

    }
    public void clickOnFundingSourceToggleButtonButtonForGiftCard() {
        click(FundingSourceToggleButton);

    }






    public boolean isGiftCardConfigurationPageTitlePresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftCardConfigurationPageTitle, 5);
        return isElementPresent(GiftCardConfigurationPageTitle,"Gift Card Configuration Page Title");
    }

    public void clickOnEnableToggleSwitchForGiftCard() {
        click(EnableToggleSwitchForGiftCard);

    }

    public void clickOnSaveConfigurationButton() {
        click(SaveConfigurationButton);
    }



    public boolean isGiftCardDisableMessagePresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftCardDisabledMessage, 5);
        return isElementPresent(GiftCardDisabledMessage,"Gift Card Disabled");
    }



    public void getGiftcardLink() {
        click(GiftcardLink);
    }



    public void firstSearchEntryOnCustomerPageClick() {
        //Instantiate Action Class
        Actions actions = new Actions(getDriver());
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = getDriver().findElement(firstSearchEntryOnCustomerPage);
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        click(firstSearchEntryOnCustomerPage);
    }

    public void clickOnContinueButton() {
        click(ContinueButton);
    }




    public boolean isGiftCardDashboardPageLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftcardLink, 5);
        return isElementPresent(GiftcardLink,"Issue Gift Card Link");
    }

    public boolean isErrorMessageForMaxGiftAmountFieldBlankPresent() {
        WebdriverWaits.waitForElementUntilVisible(ErrorMessageForMaxGiftAmountFieldBlank, 5);
        return isElementPresent(ErrorMessageForMaxGiftAmountFieldBlank,"Error Message For Max Gift Amount Field Blank");
    }



    public void VerifyTitleOnAutomatedBusinessFlowPageOngiftcard(){
        Assertions.assertTrue(getDriver().findElement(BusinessFlowPagetitle).isDisplayed());
    }

    public void isTitlePagePresentForGiftCardDashboardPage(){
        String actualTitleForGiftCardDashboardPage = getDriver().getTitle();
        String expectedTitleForGiftCardDashboardPage = "Transactions";
        Assertions.assertEquals(actualTitleForGiftCardDashboardPage, expectedTitleForGiftCardDashboardPage);
    }

    public void ClickOnConfigurationLinkOfGiftCardDashboard(){
        if(IssueANewGiftCardLink()) {
            ConfigurationButtonWhenEnabled().click();
        }else {
            ConfigurationButtonWhenDisabled().click();
        }
        WebdriverWaits.sleep(3000);
    }

    public void updateConfigurationOnGiftCardPage(String textAreaInFundingAreaField,String maxGiftAmount){
        EnableToggleSwitchForGiftCard().click();
        ReferenceNumberToggleButton().click();
        FundingSourceToggleButton().click();
       // getTextAreaInFundingAreaField(textAreaInFundingAreaField);
        MaxGiftAmountTextbox().setText(maxGiftAmount);
    }

    public void EnableORDisableToggleSwitchForGiftCard() {
        WebdriverWaits.waitForElementVisible(EnableToggleSwitchForGiftCard,5);
        if (EnableToggleSwitchForGiftCard().getAttribute("class").equals("custom-checkbox mb-3")) EnableToggleSwitchForGiftCard().click();
        else EnableToggleSwitchForGiftCard().click();

    }

    //Issue A Gift Card Page
    public boolean isIssueAGiftCardFormTitlePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(IssueAGiftCardFormTitle, 5);
            return isElementPresent(IssueAGiftCardFormTitle, "Issue A New Gift Card Title is present");
        } catch (RuntimeException e) {
            return false;
        }

    }


    public boolean isYouAreIssuingGiftCardMessageOnFormTextPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(YouAreIssuingGiftCardMessageOnForm, 5);
            return isElementPresent(YouAreIssuingGiftCardMessageOnForm, "You Are Issuing a GiftCard Message On Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isCustomerBlockOnIssueGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(customerBlockOnIssueGiftCardForm, 5);
            return isElementPresent(customerBlockOnIssueGiftCardForm, "Customer block on the page is present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isInitialAmountTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(initialAmountTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(initialAmountTitleOnIssueNewGiftCardForm, "Initial Amount Title On Issue New Gift Card Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable initialAmountTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(initialAmountTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(initialAmountTextboxOnIssueNewGiftCardForm,"Text In Initial Amount Textbox");
    }

    public boolean isCurrencyIconOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(currencyIconOnIssueNewGiftCardForm, 5);
            return isElementPresent(currencyIconOnIssueNewGiftCardForm, "Currency Icon On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isInitialAmountTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(initialAmountTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(initialAmountTextboxOnIssueNewGiftCardForm, "Initial Amount Textbox On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isMessageToTheReceiverMessageTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(messageToTheReceiverMessageTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(messageToTheReceiverMessageTitleOnIssueNewGiftCardForm, "Message To The Receiver Message Title On Issue New Gift Card Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }


    public boolean isMessageToTheReceiverMessageTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(messageToTheReceiverMessageTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(messageToTheReceiverMessageTextboxOnIssueNewGiftCardForm, "Is Message To The Receiver Message Textbox On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isReferenceNumberTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(referenceNumberTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(referenceNumberTitleOnIssueNewGiftCardForm, "Is Reference Number Title On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isReferenceNumberTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(referenceNumberTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(referenceNumberTextboxOnIssueNewGiftCardForm, "Is Reference Number Textbox On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable referenceNumberTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(referenceNumberTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(referenceNumberTextboxOnIssueNewGiftCardForm,"Text In Funding Source Textbox");
    }

    public boolean isMoreOptionsButtonOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(moreOptionsButtonOnIssueNewGiftCardForm, 5);
            return isElementPresent(moreOptionsButtonOnIssueNewGiftCardForm, "Is More Options Button On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }



    public boolean isCreateButtonOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(createButtonOnIssueNewGiftCardForm, 5);
            return isElementPresent(createButtonOnIssueNewGiftCardForm, "Is Create Button On Issue New GiftCard Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Clickable closeIconOnIssueANewGiftCardPage() {
        WebdriverWaits.waitForElementVisible(closeIconOnIssueANewGiftCardPage,5);
        return  Clickable.getElementBy(closeIconOnIssueANewGiftCardPage);
    }

    public Clickable createButtonOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(createButtonOnIssueNewGiftCardForm,5);
        return  Clickable.getElementBy(createButtonOnIssueNewGiftCardForm);
    }

    public boolean isErrorMessageOnIssueANewGiftCardPagePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(errorMessageOnIssueANewGiftCardPage, 5);
            return isElementPresent(errorMessageOnIssueANewGiftCardPage, "Is Error Message On Issue A New GiftCard Page present");
        } catch (RuntimeException e) {
            return false;
        }

    }


    //Customer Form Page
    public Clickable GiftCardForSaleLink() {
        WebdriverWaits.waitForElementVisible(GiftCardForSaleLink,5);
        return  Clickable.getElementBy(GiftCardForSaleLink);
    }

    public boolean isCustomerFormTitlePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(customerForm, 5);
            return isElementPresent(customerForm, "Is Customer Form Title present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isPhoneNumberOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(phoneNumberOnCustomerForm, 5);
            return isElementPresent(phoneNumberOnCustomerForm, "Is Phone Number On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable phoneNumberOnCustomerForm() {
        WebdriverWaits.waitForElementVisible(phoneNumberOnCustomerForm,5);
        return Editable.getElementBy(phoneNumberOnCustomerForm,"Phone Number Textbox on Customer Page");
    }

    public boolean isGoButtonForPhoneNumberOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(GoButtonForPhoneNumberOnCustomerForm, 5);
            return isElementPresent(GoButtonForPhoneNumberOnCustomerForm, "Is Go Button For Phone Number On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Clickable GoButtonForPhoneNumberOnCustomerFormClick() {
        WebdriverWaits.waitForElementVisible(GoButtonForPhoneNumberOnCustomerForm,5);
        return  Clickable.getElementBy(GoButtonForPhoneNumberOnCustomerForm);
    }

    public boolean isEmailOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(emailOnCustomerForm, 5);
            return isElementPresent(emailOnCustomerForm, "Is Email On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable emailOnCustomerForm() {
        WebdriverWaits.waitForElementVisible(emailOnCustomerForm,5);
        return Editable.getElementBy(emailOnCustomerForm,"Email Textbox on Customer Page");
    }


    public boolean isSearchOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(searchOnCustomerForm, 5);
            return isElementPresent(searchOnCustomerForm, "Is Search On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isErrorMessageForPhoneNumberOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(errorMessageForPhoneNumberOnCustomerForm, 5);
            return isElementPresent(errorMessageForPhoneNumberOnCustomerForm, "Is Error Message For Phone Number On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isErrorMessageForEmailOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(errorMessageForEmailOnCustomerForm, 5);
            return isElementPresent(errorMessageForEmailOnCustomerForm, "Is Error Message For Email On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }



    public boolean isErrorMessageOfNoSearchResultOnCustomerPagePresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(errorMessageOfNoSearchResultOnCustomerPage, 5);
            return isElementPresent(errorMessageOfNoSearchResultOnCustomerPage, "Is Error Message Of No Search Result On Customer Page present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isThereAreNoResultsMessageOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(ThereAreNoResultsMessageOnCustomerForm, 5);
            return isElementPresent(ThereAreNoResultsMessageOnCustomerForm, "Is There Are No Results Message On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isGoButtonForEmailOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(GoButtonForEmailOnCustomerForm, 5);
            return isElementPresent(GoButtonForEmailOnCustomerForm, "Is Go Button For Email On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isCloseIconOnCustomerFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(closeIconOnCustomerForm, 5);
            return isElementPresent(closeIconOnCustomerForm, "Is Close Icon On Customer Form present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Clickable GoButtonForPhoneNumberOnCustomerForm() {
         WebdriverWaits.waitForElementVisible(GoButtonForPhoneNumberOnCustomerForm,5);
        return  Clickable.getElementBy(GoButtonForPhoneNumberOnCustomerForm);
    }

    public Clickable GoButtonForEmailOnCustomerForm() {
        WebdriverWaits.waitForElementVisible(GoButtonForEmailOnCustomerForm,5);
        return  Clickable.getElementBy(GoButtonForEmailOnCustomerForm);
    }

    public Clickable searchIconOnCustomerPage() {
        WebdriverWaits.waitForElementVisible(searchIconOnCustomerPage,5);
        return  Clickable.getElementBy(searchIconOnCustomerPage);
    }

    public Clickable firstSearchEntryOnCustomerPage() {
        WebdriverWaits.waitForElementVisible(firstSearchEntryOnCustomerPage,5);
        return  Clickable.getElementBy(firstSearchEntryOnCustomerPage);
    }


    public Editable searchTextboxOnCustomerPage() {
        WebdriverWaits.waitForElementVisible(searchTextboxOnCustomerPage,5);
        return Editable.getElementBy(searchTextboxOnCustomerPage,"Search Textbox on Customer Page");
    }

    public boolean isCardNumberTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(cardNumberTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(cardNumberTitleOnIssueNewGiftCardForm, "Is CardNumberTitleOnIssueNewGiftCardForm present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isCardNumberTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(cardNumberTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(cardNumberTextboxOnIssueNewGiftCardForm, "Is CardNumberTextboxOnIssueNewGiftCardForm present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable cardNumberTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(cardNumberTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(cardNumberTextboxOnIssueNewGiftCardForm,"Text In Card Number Textbox");
    }

    public boolean isFundingSourceTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(fundingSourceTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(fundingSourceTitleOnIssueNewGiftCardForm, "Is FundingSourceTitleOnIssueNewGiftCardForm present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isFundingSourceTextboxOnIssueNewGiftCardFormresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(fundingSourceTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(fundingSourceTextboxOnIssueNewGiftCardForm, "Is FundingSourceTextboxOnIssueNewGiftCardForm present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable fundingSourceTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(fundingSourceTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(fundingSourceTextboxOnIssueNewGiftCardForm,"Text In Funding Source Textbox");
    }

    public Clickable fundingSourceTextboxOnIssueNewGiftCardFormClick() {
        WebdriverWaits.waitForElementVisible(fundingSourceTextboxOnIssueNewGiftCardForm,5);
        return  Clickable.getElementBy(fundingSourceTextboxOnIssueNewGiftCardForm);
    }

    public void SelectOptionForFundingTextbox(String textToSelect){
        Select objSelect =new Select(getDriver().findElement(fundingSourceTextboxOnIssueNewGiftCardForm));
        objSelect.selectByVisibleText(textToSelect);
    }

    public boolean isMemoTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(memoTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(memoTitleOnIssueNewGiftCardForm, "Is MemoTitleOnIssueNewGiftCardFormpresent");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isMemoTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(memoTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(memoTextboxOnIssueNewGiftCardForm, "Is MemoTextboxOnIssueNewGiftCardFormpresent");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable memoTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(memoTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(memoTextboxOnIssueNewGiftCardForm,"Text In Memo Textbox");
    }

    public boolean isStartDateTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(startDateTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(startDateTitleOnIssueNewGiftCardForm, "Is StartDateTitleOnIssueNewGiftCardFormpresent");
        } catch (RuntimeException e) {
            return false;
        }

    }


    public boolean isStartDateTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(startDateTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(startDateTextboxOnIssueNewGiftCardForm, "Is StartDateTextboxOnIssueNewGiftCardFormpresent");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable startDateTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(startDateTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(startDateTextboxOnIssueNewGiftCardForm,"Text Start Date Textbox");
    }

    public boolean isExpDateTitleOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(expDateTitleOnIssueNewGiftCardForm, 5);
            return isElementPresent(expDateTitleOnIssueNewGiftCardForm, "Is ExpDateTitleOnIssueNewGiftCardFormpresent");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public boolean isExpDateTextboxOnIssueNewGiftCardFormPresent() {
        try {
            WebdriverWaits.waitForElementUntilVisible(expDateTextboxOnIssueNewGiftCardForm, 5);
            return isElementPresent(expDateTextboxOnIssueNewGiftCardForm, "Is ExpDateTextboxOnIssueNewGiftCardForm present");
        } catch (RuntimeException e) {
            return false;
        }

    }

    public Editable expDateTextboxOnIssueNewGiftCardForm() {
        WebdriverWaits.waitForElementVisible(expDateTextboxOnIssueNewGiftCardForm,5);
        return Editable.getElementBy(expDateTextboxOnIssueNewGiftCardForm,"Text End Date Textbox");
    }















}
