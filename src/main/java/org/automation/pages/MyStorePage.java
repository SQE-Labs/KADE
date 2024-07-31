package org.automation.pages;

import java.awt.*;
import java.nio.file.Paths;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {
    By registerNewBusinessBtn = By.partialLinkText("Register new business");
    By skipPopUpTitle = By.xpath("//h5[text()='Skip']");
    By skipStripeAccountBtn = By.cssSelector(".btn-lg.fw-bold.w-100.btn.btn-outline-primary");
    By skipStripeAccountPopUpBtn = By.xpath("//div[@class='modal-content']//button[text()='Skip']");
    By deleteStoreBtn = By.xpath("//button[text()='Delete the store']");
    By deleteStoreIcon = By.cssSelector(".fa.fa-check");
    By blankFieldWarningMsg = By.xpath("//p[@class='alert-content']");
    By storeLogo = By.xpath("(//img[contains(@alt,'')])[3]");
    By businessNameTbx = By.xpath("//input[@name='name']");
    By locationDescTbx = By.xpath("//input[@name='description']");
    By storeAddressField = By.cssSelector(".form-control.pac-target-input");
    By storeAddressOption = By.xpath("(//div[@class='pac-item'])[1]");
    By phoneTbx = By.xpath("//input[@name='phone']");
    By timeZoneField = By.xpath("//select[@name='timeZone']");
    By timeZoneOption = By.xpath("//option[text()='(GMT-05:00) Eastern Time (US & Canada)']");
    By taxRateTbx = By.xpath("//input[@name='taxRate']");
    By saveBtn = By.xpath("//button[text()='Save']");
    By stripeBtn = By.cssSelector(".img-fluid.h-100");
    By connectStripePopUpTitle = By.xpath("//h5[text()='Connect to stripe']");
    By testStripeBtn = By.partialLinkText("Create a test Stripe account");
    By stripeAccSuccessMsg = By.xpath("(//div[@class='alert-message'])");
    By bankTransferToggleBtn = By.xpath("//span[text()='Accept bank transfer']");
    By configureCreditCardTerminal = By.xpath("//button[@class='btn btn-link']");
    By creditCardTerminalOption = By.xpath("//span[text()=' Tap-To-Pay on phone']");
    By creditSaveBtn = By.xpath("//button[text()='Save']");
    By skipForNowBtn = By.xpath("//button[text()='Skip for now']");
    By continueBtn = By.xpath("//button[text()='Continue']");
    By configureLink = By.xpath("(//a[contains(@class,'float-end btn btn-link')][text()='Configure'])[3]");
    By modifyBtn = By.xpath("//button[text()='Modify']");
    By plansSubTab = By.partialLinkText("Plans");
    By currentPlanMSg = By.xpath("//span[@class='text-success me-1']");
    By planSignUpBtn = By.partialLinkText("Sign up");
    By yearlyBtn = By.xpath("//label[text()='Yearly']");
    By termsCbx = By.xpath("//span[text()='     I agree to the']");
    By changePlanBtn = By.xpath("//button[text()='Change plan']");
    By addedStoreName = By.cssSelector("div[class='form-group mb-3'] h4");
    By addedBusinessName = By.cssSelector("div[class='display-none -readonly-div-'] span");
    By addedStoreAddress = By.xpath("//label[text()='Store Address']/following-sibling::p");
    By addedStorePhone = By.xpath("//label[text()='Store Phone']/following-sibling::p");
    By addedCurrencyOfStore = By.xpath("//label[text()='Currency of the Store']/following-sibling::p");
    By addedTaxRate = By.xpath("//label[text()='Tax rate']/following-sibling::p");
    By addedVisaMethod = By.cssSelector("div[class='-title- d-flex flex-column'] span[class='text-nowrap']");
    By newCreditCardBtn = By.xpath("//span[text()='New Credit Card']");
    By newBankAccountBtn = By.xpath("//span[text()='New Bank Account']");
    By changePayMethodBtn = By.xpath("//button[text()='change']");
    By nextBillDate = By.xpath("(//div[@class='d-flex'])[2]");
    By defaultVisaMethod = By.xpath("//div[contains(@class,'d-flex justify-content-center align-items-center')]");
    By configureBtnWithoutStripe = By.xpath("(//a[contains(@class,'float-end btn btn-link')][text()='Configure'])[6]");
    By settingsSubTab = By.xpath("//a[text()='Settings']");
    By maxBillAmountTbx = By.xpath("//input[@name='maxBillAmountThreshold']");
    By tipGratuityToggleBtn = By.xpath("//span[@class='ms-2 custom-check-on'][text()='No']");
    By tipConfigureBtn = By.xpath("//div[@class='checked-d-none']//button[@type='button'][text()='Configure']");
    By tipConfgPopUpTitle = By.xpath("//h5[text()='Tip configuration']");
    By tipPercentField1 = By.xpath("//input[@name='tipSelections[0].percentage']");
    By tipPercentField2 = By.xpath("//input[@name='tipSelections[1].percentage']");
    By tipPercentField3 = By.xpath("//input[@name='tipSelections[2].percentage']");
    By saveChangesBtn = By.xpath("//button[text()='Save changes']");
    By rewardConfigureBtn = By.xpath("(//button[@type='button'][text()='Configure'])[2]");
    By rewardConfigPopUpTitle = By.xpath("//h5[text()='Rewards Program Configuration']");
    By rewardPointToggleBtn = By.xpath("//span[@class='ms-2 fs-6 custom-check-off']");
    By rewardPointsField = By.xpath("//input[@name='pointsForGiftcard']");
    By rewardPtsValue = By.xpath("//input[@name='ponitsValue']");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By storeLinksBtn=By.xpath("//button[text()='Store links']");
    By websiteURLField=By.xpath("//input[@name='StoreURLTypes[0].url']");
    By earnRewardsToggleBtn=By.xpath("(//i[@class='far fa-toggle-off custom-check-off '])[2]");

    public MyStorePage() {
    }
    public void clickRegisterNewBusinessBtn() {
        click(registerNewBusinessBtn);
    }
    public void clickSkipStripeAccountBtn() {
        WebdriverWaits.waitForElementClickable(skipStripeAccountBtn, 5);
        click(skipStripeAccountBtn);
    }
//    public String getSkipPopUpTitle() {
//        return getText_custom(skipPopUpTitle);
//    }
    public void clickSkipStripeAccountPopUpBtn() {
        WebdriverWaits.waitForElementClickable(skipStripeAccountPopUpBtn, 5);
        clickElementByJS(skipStripeAccountPopUpBtn);
    }

    public void clickDeleteStoreBtn() {
        WebdriverWaits.waitForElementUntilVisible(deleteStoreBtn, 5);
        clickElementByJS(deleteStoreBtn);
    }

//    public String getBlankFieldWarningMsg() {
//        return getText_custom(blankFieldWarningMsg);
//    }

    public void clickDeleteStoreIcon() {
        WebdriverWaits.waitForElementUntilVisible(deleteStoreIcon, 5);
        clickElementByJS(deleteStoreIcon);
    }

    public void clickStoreLogo() {
        moveToWebElement(storeLogo);
        clickElementByJS(storeLogo);
    }

    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void enterBusinessName(String businessName) {
        WebdriverWaits.waitForElementUntilVisible(businessNameTbx, 2);
        clear_custom(businessNameTbx);
        pressKeys(businessNameTbx, businessName);
        click(businessNameTbx);
    }

    public void enterLocationDescription(String locDescription) {
        WebdriverWaits.waitForElementUntilVisible(locationDescTbx, 2);
        clear_custom(locationDescTbx);
        pressKeys(locationDescTbx, locDescription);
        click(locationDescTbx);
    }

//    public String getBusinessFieldMaxLen() {
//        return getAttribute(businessNameTbx, "maxlength");
//    }

    public void selectStoreAddress(String storeAddressName) {
        WebdriverWaits.waitForElementUntilVisible(storeAddressField, 2);
        clear_custom(storeAddressField);
        pressKeys(storeAddressField, storeAddressName);
        click(storeAddressField);
        click(storeAddressOption);
    }

    public void enterPhone(String phone) {
        WebdriverWaits.waitForElementUntilVisible(phoneTbx, 2);
        clear_custom(phoneTbx);
        pressKeys(phoneTbx, phone);
        click(phoneTbx);
    }

    public String getPhoneFieldMaxLen() {
        return getAttribute(phoneTbx, "maxlength");
    }

    public void selectTimeZone() {
        click(timeZoneField);
        click(timeZoneOption);
    }

    public void enterTax(String taxRate) {
        WebdriverWaits.waitForElementUntilVisible(taxRateTbx, 2);
        clear_custom(taxRateTbx);
        pressKeys(taxRateTbx, taxRate);
        click(taxRateTbx);
    }

    public String getTaxFieldMinValue() {
        return getAttribute(taxRateTbx, "min");
    }

    public String getTaxFieldDefaultValue() {
        return getAttribute(taxRateTbx, "value");
    }

    public String getTaxFieldMaxValue() {
        return getAttribute(taxRateTbx, "max");
    }

    public void clickSaveBtn() {
        WebdriverWaits.waitForElementUntilVisible(saveBtn, 5);
        moveToWebElement(saveBtn);
        clickElementByJS(saveBtn);
    }

    public void clickStripeBtn() {
        click(stripeBtn);
    }

//    public String getConnectStripePopUpTitle() {
//        return getText_custom(connectStripePopUpTitle);
//    }

    public void clickTestStripeBtn() {
        click(testStripeBtn);
    }

    public String getStripeAccountSuccessMsg() {
        return getText_custom(stripeAccSuccessMsg);
    }

    public void enableBankTransfer() {
        click(bankTransferToggleBtn);
    }

    public void clickConfigureCreditCardTerminals() {
        click(configureCreditCardTerminal);
    }

    public void selectCreditCardTerminal() {
        click(creditCardTerminalOption);
    }

    public void clickCreditSaveBtn() {
        click(creditSaveBtn);
    }

    public void clickSkipForNowBtn() {
        click(skipForNowBtn);
    }

    public void clickContinueBtn() {
        moveToWebElement(continueBtn);
        click(continueBtn);
    }

    public void clickConfigureLink() {
        click(configureLink);
    }

    public void clickModifyBtn() {
        moveToWebElement(modifyBtn);
        click(modifyBtn);
    }
//
//    public String getAddedStoreName() {
//        return getText_custom(addedStoreName);
//    }
//
//    public String getAddedBusinessName() {
//        return getText_custom(addedBusinessName);
//    }
//
//    public String getAddedStoreAddress() {
//        return getText_custom(addedStoreAddress);
//    }
//
//    public String getAddedStorePhone() {
//        return getText_custom(addedStorePhone);
//    }
//
//    public String getAddedCurrencyOfStore() {
//        return getText_custom(addedCurrencyOfStore);
//    }
//
//    public String getAddedTaxRate() {
//        return getText_custom(addedTaxRate);
//    }

    public void clickPlansSubTab() {
        click(plansSubTab);
    }

    public void clickPlanSignUpBtn() {
        moveToWebElement(planSignUpBtn);
        click(planSignUpBtn);
    }

    public void selectTermsCbx() {
        click(termsCbx);
    }

    public void clickChangePlanBtn() {
        click(changePlanBtn);
    }

    public void clickYearlyBtn() {
        click(yearlyBtn);
    }

//    public String getCurrentPlanSuccessMSg() {
//        return getText_custom(currentPlanMSg);
//    }
//
//    public String defaultPaymentMethod() {
//        return getText_custom(addedVisaMethod);
//    }

    public void selectVisaMethod() {
        click(defaultVisaMethod);
    }

    public boolean isNewCreditCardBtnDisplayed() {
        return isWebElementVisible(newCreditCardBtn);
    }

    public boolean isNewBankAccountBtnDisplayed() {
        return isWebElementVisible(newBankAccountBtn);
    }

    public void clickChangePayMethodBtn() {
        click(changePayMethodBtn);
    }

    public boolean isNextBillDateDisplayed() {
        return isWebElementVisible(nextBillDate);
    }

    public void clickConfigureBtn() {
        click(configureBtnWithoutStripe);
    }

    public void clickSettingsSubTab() {
        click(settingsSubTab);
    }

    public void enterMaximumBillAmount(String maxBillAmt) {
        WebdriverWaits.waitForElementUntilVisible(maxBillAmountTbx, 2);
        clear_custom(maxBillAmountTbx);
        pressKeys(maxBillAmountTbx, maxBillAmt);
        click(maxBillAmountTbx);
    }

    public String getMinimumBillAmtValue() {
        return getAttribute(maxBillAmountTbx, "min");
    }

    public String getMaximumBillAmtValue() {
        return getAttribute(maxBillAmountTbx, "max");
    }

    public String getDefaultBillAmtValue() {
        return getAttribute(maxBillAmountTbx, "value");
    }

    public void enableTipGratuityToggleBtn() {
        click(tipGratuityToggleBtn);
    }

    public void clickTipConfigureBtn() {
        moveToWebElement(tipConfigureBtn);
        click(tipConfigureBtn);
    }

//    public String getTipConfigPopUpTitle() {
//        return getText_custom(tipConfgPopUpTitle);
//    }

    public String getDefaultTipAmtValue() {
        return getAttribute(tipPercentField1, "value");
    }

    public String getMaxTipAmtValue() {
        return getAttribute(tipPercentField1, "max");
    }

    public void enterTipAmt1(String tipAmt1) {
        WebdriverWaits.waitForElementUntilVisible(tipPercentField1, 2);
        clear_custom(tipPercentField1);
        pressKeys(tipPercentField1, tipAmt1);
        click(tipPercentField1);
    }

    public void enterTipAmt2(String tipAmt2) {
        WebdriverWaits.waitForElementUntilVisible(tipPercentField2, 2);
        clear_custom(tipPercentField2);
        pressKeys(tipPercentField2, tipAmt2);
        click(tipPercentField2);
    }

    public void enterTipAmt3(String tipAmt3) {
        WebdriverWaits.waitForElementUntilVisible(tipPercentField3, 2);
        clear_custom(tipPercentField3);
        pressKeys(tipPercentField3, tipAmt3);
        click(tipPercentField3);
    }

    public void clickSaveChangesBtn() {
        click(saveChangesBtn);
    }

    public void clickRewardConfigBtn() {
        click(rewardConfigureBtn);
    }

//    public String getRewardConfigPopUpTitle() {
//        return getText_custom(rewardConfigPopUpTitle);
//    }

    public void enableRewardPointToggleBtn() {
        click(rewardPointToggleBtn);
    }

    public void enterRewardPoints(String rewardPoints) {
        WebdriverWaits.waitForElementUntilVisible(rewardPointsField, 2);
        clear_custom(rewardPointsField);
        pressKeys(rewardPointsField, rewardPoints);
        click(rewardPointsField);
    }

    public String getMinRewardPointsValue() {
        return getAttribute(rewardPointsField, "min");
    }

    public String getMaxRewardPointsValue() {
        return getAttribute(rewardPointsField, "max");
    }

    //New Methods for click and Enter
    public Clickable getRegisterNewBusinessButton() {
        return Clickable.getElementBy(registerNewBusinessBtn, "Register New Business Button");
    }
    public Clickable getSkipStripeAccountButton() {
        return Clickable.getElementBy(skipStripeAccountBtn, "Skip Stripe Account Button");
    }
    public Editable getSkipPopUpTitle(){
        return Editable.getElementBy(skipPopUpTitle);
    }
    public Clickable getSkipStripeAccountPopUpButton() {
        return Clickable.getElementBy(skipStripeAccountPopUpBtn, "Skip Stripe Account Pop Up Button");
    }
    public Clickable getDeleteStoreButton() {
        return Clickable.getElementBy(deleteStoreBtn, "Delete Store Button");
    }
    public Clickable getDeleteStoreIcon() {
        return Clickable.getElementBy(deleteStoreIcon, "Delete Store Icon");
    }
    public Editable getBlankFieldWarningMsg() {
        return Editable.getElementBy(blankFieldWarningMsg);
    }
    public Clickable getStoreLogo() {
        return Clickable.getElementBy(storeLogo, "Store Logo");
    }
    public Editable getBusinessNameField() {
        return Editable.getElementBy(businessNameTbx);
    }
    public Editable getBusinessFieldMaxLen() {
        return Editable.getElementBy(businessNameTbx);
    }
    public Editable getLocationDescriptionField() {
        return Editable.getElementBy(locationDescTbx);
    }
    public Editable getPhoneField() {
        return Editable.getElementBy(phoneTbx);
    }
    public Editable getTaxRateField() {
        return Editable.getElementBy(taxRateTbx);
    }
    public Clickable getSaveButton() {
        return Clickable.getElementBy(saveBtn, "Save Button");
    }
    public Clickable getStipeAccountButton() {
        return Clickable.getElementBy(stripeBtn, "Stripe Account Button");
    }
    public Editable getConnectStripePopUpTitle(){
        return Editable.getElementBy(connectStripePopUpTitle);
    }
    public Clickable getTestStripeAccountButton() {
        return Clickable.getElementBy(testStripeBtn, "Test Stripe Account Button");
    }
    public Clickable getBankTransferToggleButton() {
        return Clickable.getElementBy(bankTransferToggleBtn, "Bank Transfer Toggle Button");
    }
    public Clickable getSkipForNowButton() {
        return Clickable.getElementBy(skipForNowBtn, "Skip For Now Button");
    }
    public Clickable getContinueButton() {
        return Clickable.getElementBy(continueBtn, "Continue Button");
    }
    public Clickable getConfigureLink() {
        return Clickable.getElementBy(configureLink, "Configure Link");
    }
    public Clickable getModifyButton() {
        return Clickable.getElementBy(modifyBtn, "Modify Button");
    }
    public Editable getAddedStoreName() {
        return Editable.getElementBy(addedStoreName);
    }
    public Editable getAddedBusinessName(){
        return Editable.getElementBy(addedBusinessName);
    }
    public Editable getAddedStoreAddress(){
        return Editable.getElementBy(addedStoreAddress);
    }
    public Editable getAddedStorePhone(){
        return Editable.getElementBy(addedStorePhone);
    }
    public Editable getAddedCurrencyOfStore(){
        return Editable.getElementBy(addedCurrencyOfStore);
    }
    public Editable getAddedTaxRate(){
        return Editable.getElementBy(addedTaxRate);
    }
    public Clickable getPlansSubTab() {
        return Clickable.getElementBy(plansSubTab, "Plans Sub Tab");
    }
    public Clickable getPlansSignUpButton() {
        return Clickable.getElementBy(planSignUpBtn, "Plan Sign Up Button");
    }
    public Clickable getTermsCheckbox() {
        return Clickable.getElementBy(termsCbx, "Terms Checkbox");
    }
    public Clickable getChangePlanButton() {
        return Clickable.getElementBy(changePlanBtn, "Change Plan Button");
    }
    public Clickable getYearlyPlanButton() {
        return Clickable.getElementBy(yearlyBtn, "Yearly Plan Button");
    }
    public Editable getCurrentPlanSuccessMessage(){
        return Editable.getElementBy(currentPlanMSg);
    }
    public Editable getDefaultPaymentMethod(){
        return Editable.getElementBy(addedVisaMethod);
    }
    public Clickable getChangePayMethodLink() {
        return Clickable.getElementBy(changePayMethodBtn, "Change Plan Method Link");
    }
    public Clickable getConfigureButton() {
        return Clickable.getElementBy(configureBtnWithoutStripe, "Configure Button");
    }
    public Clickable getSettingsSubTab() {
        return Clickable.getElementBy(settingsSubTab, "Settings Sub Tab");
    }
    public Editable getMaximumBillAmountField() {
        return Editable.getElementBy(maxBillAmountTbx);
    }
    public Clickable getTipGrauityToggleButton() {
        return Clickable.getElementBy(tipGratuityToggleBtn, "Tip Gratuity Toggle Button");
    }
    public Clickable getTipConfigureButton() {
        return Clickable.getElementBy(tipConfigureBtn, "Tip Configure Button");
    }
    public Editable getTipConfigPopUpTitle(){
        return Editable.getElementBy(tipConfgPopUpTitle);
    }
    public Editable getTipAmountField1() {
        return Editable.getElementBy(tipPercentField1);
    }
    public Editable getTipAmountField2() {
        return Editable.getElementBy(tipPercentField2);
    }
    public Editable getTipAmountField3() {
        return Editable.getElementBy(tipPercentField3);
    }
    public Clickable getSaveChangesButton() {
        return Clickable.getElementBy(saveChangesBtn, "Save Changes Button");
    }
    public Clickable getRewardConfigureButton() {
        return Clickable.getElementBy(rewardConfigureBtn, "Reward Configure Button");
    }
    public Editable getRewardConfigPopUpTitle(){
        return Editable.getElementBy(rewardConfigPopUpTitle);
    }
    public Clickable getRewardPointToggleButton() {
        return Clickable.getElementBy(rewardPointToggleBtn, "Reward Point Toggle Button");
    }
    public Editable getRewardPointsField() {
        return Editable.getElementBy(rewardPointsField);
    }
    public Clickable getCheckButton() {
        return Clickable.getElementBy(checkBtn,"Check Button");
    }
    public Clickable getStoreLinksButton() {
        return Clickable.getElementBy(storeLinksBtn,"Store Links Button");
    }
    public Editable getRewardPointsValueField() {
        return Editable.getElementBy(rewardPtsValue);
    }
    public String getMaxRewardPointsFieldValue() {
        return getAttributevalue(rewardPtsValue,"max");
    }
    public String getMinRewardPointsFieldValue() {
        return getAttributevalue(rewardPtsValue,"min");
    }
    public Editable getWebsiteURLField(){
        return Editable.getElementBy(websiteURLField);
    }
    public Clickable getEarnRewardsPointsToggleButton() {
        return Clickable.getElementBy(earnRewardsToggleBtn,"Earn Rewards Toggle Button");
    }
}