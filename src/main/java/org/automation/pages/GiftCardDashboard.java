package org.automation.pages;

import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GiftCardDashboard extends BasePage {



    By manageBusinessDropdown=By.xpath("//a[contains(text(),'Manage Business')]");
    By GiftcardLink=By.linkText("Gift Cards Dashboard");
    By GiftCardDashboardPageTitle=By.xpath("//h1[contains(text(),'Gift Cards Dashboard')]");
    By WhichStoreText=By.xpath("//p[contains(text(),'Which store?')]");
    By SelectStoreToContinueText=By.xpath("//h4[contains(text(),'Please select a store to continue')]");
    By StoresDropdownText=By.xpath("//lable[contains(text(),'Stores :')]");
    By StoresDropDown=By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
    By ContinueButton=By.xpath("//button[contains(text(),'Continue')]");
    By RememberToggleButton=By.xpath("//input[@id='customcheckbox']");
    By DropDownOption=By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[6]");
    By BusinessFlowPagetitle=By.xpath("//h3[contains(text(),'Automation Flow Business')]");
    By GiftCardDisabledMessage=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]");
    By ConfigurationButton=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/button[1]");
    By GiftCardConfigurationPageTitle=By.xpath("//h5[contains(text(),'Gift Cards Configuration')]");
    By EnableToggleSwitchForGiftCard=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/label[1]/i[2]");
    By SaveConfigurationButton=By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]");
    By ReferenceNumberToggleButton=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]/i[1]");
    By FundingSourceToggleButton=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]/i[1]");
    By TextAreaInFundingArea=By.xpath("//textarea[@id='_5PI']");
    By MaxGiftAmountTextbox=By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/input[1]");
    By IssueANewGiftCardLink=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/button[2]");
    By GiftCardForSaleLink=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    By FiltersButtonOn=By.xpath("//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[3]/div[1]/button[1]/i[1]");
//    By =By.xpath("");
//    By =By.xpath("");

    public void EnableGiftCardIfDisabled(){
        clickOnConfigurationButton();
        WebdriverWaits.sleep(3000);
        clickOnEnableToggleSwitchForGiftCard();
        WebdriverWaits.sleep(3000);
        clickOnSaveConfigurationButton();
        WebdriverWaits.sleep(3000);
        System.out.println("CONFIGURATION SAVED!!!");
    }

    public boolean isIssueANewGiftCardLinkLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(IssueANewGiftCardLink, 5);
        return isElementPresent(IssueANewGiftCardLink,"Issue A New Gift Card Link");
    }

    public boolean isGiftCardForSaleLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftCardForSaleLink, 5);
        return isElementPresent(GiftCardForSaleLink,"Gift Card For Sale Link");
    }

    public boolean isFiltersButtonOnPresent() {
        WebdriverWaits.waitForElementUntilVisible(FiltersButtonOn, 5);
        return isElementPresent(FiltersButtonOn,"Filters Button On Dashboard");
    }

    public void clickOnFiltersButtonOnGiftCardDashboard() {
        click(FiltersButtonOn);

    }



    public void writeOnTextAreaForGiftCard() {
        click(TextAreaInFundingArea);
        getDriver().findElement(TextAreaInFundingArea).sendKeys("Sample Text");
    }


    public Editable getTextAreaInFundingAreaField() {
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

    public void clickOnConfigurationButton() {
        click(ConfigurationButton);
    }


    public boolean isGiftCardDisableMessagePresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftCardDisabledMessage, 5);
        return isElementPresent(GiftCardDisabledMessage,"Gift Card Disabled");
    }

    public void clickOnManageBusinessDropdown() {
        click(manageBusinessDropdown);
    }

    public void clickOnGiftcardLink() {
        click(GiftcardLink);
    }

    public void clickOnDropDown() {
        click(StoresDropDown);
    }

    public void DropdownOption() {
        click(DropDownOption);
    }

    public void clickOnContinueButton() {
        click(ContinueButton);
    }


    public boolean isGiftCardDashboardPageLinkPresent() {
        WebdriverWaits.waitForElementUntilVisible(GiftcardLink, 5);
        return isElementPresent(GiftcardLink,"Issue Gift Card Link");
    }

    public void VerifyTitleOnAutomatedBusinessFlowPageOngiftcard(){
        Assertions.assertTrue(getDriver().findElement(BusinessFlowPagetitle).isDisplayed());
    }

    public void isTitlePagePresentForGiftCardDashboardPage(){
        String actualTitleForGiftCardDashboardPage = getDriver().getTitle();
        String expectedTitleForGiftCardDashboardPage = "Gift Cards Dashboard";
        Assertions.assertEquals(actualTitleForGiftCardDashboardPage, expectedTitleForGiftCardDashboardPage);
    }

    public boolean isWhichStoreTextPresent() {
        return isElementPresent(WhichStoreText, "Which Store Text");
    }
    public boolean isSelectStoreToContinueTextPresent() {
        return isElementPresent(SelectStoreToContinueText, "Select Store to Continue Text");
    }
    public boolean isStoresDropdownTextPresent() {
        return isElementPresent(StoresDropdownText, "Stores Dropdown Text");
    }
    public boolean isStoresDropDownPresent() {
        return isElementPresent(StoresDropDown, "Stores Dropdown");
    }
    public boolean isContinueButtonPresent() {
        return isElementPresent(ContinueButton, "Continue Button");
    }

    public boolean isRememberToggleButtonPresent() {
        return isElementPresent(RememberToggleButton, "Remember Toggle Button");
    }

    public void SelectAutomationBillFlow(String value){
//
//        WebElement testDropDown = driver.findElement(By.id("testingDropdown"));
//        Select dropdown = new Select(testDropDown);
//
//        dropdown.selectByValue(value);
    }





}
