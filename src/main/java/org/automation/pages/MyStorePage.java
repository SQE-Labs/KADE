package org.automation.pages;

import java.awt.*;
import java.nio.file.Paths;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
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
    By tipFlatValueField1=By.xpath("//input[@name='tipSelections[0].amount']");
    By tipFlatValueField2=By.xpath("//input[@name='tipSelections[1].amount']");
    By tipFlatValueField3=By.xpath("//input[@name='tipSelections[2].amount']");
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
    By enterInPercentToggleBtn=By.xpath("//label[text()=' Enter in percentage']");
    By paymentProcessingSubTab=By.xpath("//a[text()='Payment Processing']");
    By acceptVenmoToggleBtn=By.xpath("//span[text()='Accept Venmo']");
    By acceptZelleToggleBtn=By.xpath("//span[text()='Accept Zelle']");

    public MyStorePage() {
    }
    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }
    public void uploadImageInStoreLogo() throws AWTException {
        uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
    }
    public void selectStoreAddress(String storeAddressName) {
        WebdriverWaits.waitForElementUntilVisible(storeAddressField, 2);
        clear_custom(storeAddressField);
        pressKeys(storeAddressField, storeAddressName);
        click(storeAddressField);
        click(storeAddressOption);
    }
    public void selectTimeZone() {
        click(timeZoneField);
        click(timeZoneOption);
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
    public Editable getPhoneFieldMaxLen() {
        return Editable.getElementBy(phoneTbx);
    }
    public Editable getTaxRateField() {
        return Editable.getElementBy(taxRateTbx);
    }
    public Editable getTaxFieldMinValue() {
        return Editable.getElementBy(taxRateTbx);
    }
    public Editable getTaxFieldDefaultValue() {
        return Editable.getElementBy(taxRateTbx);
    }
    public Editable getTaxFieldMaxValue() {
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
    public Editable getAddedLocationDescription(){
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
    public Clickable getNewCreditCardButton() {
        return Clickable.getElementBy(newCreditCardBtn);
    }
    public Clickable getNewBankAccountButton() {
        return Clickable.getElementBy(newBankAccountBtn);
    }
    public Clickable getNextBillDate() {
        return Clickable.getElementBy(nextBillDate);
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
    public Editable getMinimumBillAmtValue() {
        return Editable.getElementBy(maxBillAmountTbx);
    }
    public Editable getMaximumBillAmtValue() {
        return Editable.getElementBy(maxBillAmountTbx);
    }
    public Editable getDefaultBillAmtValue() {
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
    public Editable getDefaultTipAmtValue() {
        return Editable.getElementBy(tipPercentField1);
    }
    public Editable getMaxTipAmtValue() {
        return Editable.getElementBy(tipPercentField1);
    }
    public Editable getTipAmountPerCentField1() {
        return Editable.getElementBy(tipPercentField1);
    }
    public Editable getTipAmountPerCentField2() {
        return Editable.getElementBy(tipPercentField2);
    }
    public Editable getTipAmountPerCentField3() {
        return Editable.getElementBy(tipPercentField3);
    }
    public Editable getTipAmountFlatValueField1() {
        return Editable.getElementBy(tipFlatValueField1);
    }
    public Editable getTipAmountFlatValueField2() {
        return Editable.getElementBy(tipFlatValueField2);
    }
    public Editable getTipAmountFlatValueField3() {
        return Editable.getElementBy(tipFlatValueField3);
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
    public Clickable getEnterInPerCentToggleButton(){
        return Clickable.getElementBy(enterInPercentToggleBtn);
    }
    public Editable getRewardPointsField() {
        return Editable.getElementBy(rewardPointsField);
    }
    public Clickable getEarnRewardsPointsToggleButton(){
        return Clickable.getElementBy(earnRewardsToggleBtn);
    }
    public Editable getMinRewardPointsValue() {
        return Editable.getElementBy(rewardPointsField);
    }
    public Editable getMaxRewardPointsValue() {
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
    public Editable getMaxRewardPointsFieldValue() {
        return Editable.getElementBy(rewardPtsValue);
    }
    public Editable getMinRewardPointsFieldValue() {
        return Editable.getElementBy(rewardPtsValue);
    }
    public Editable getWebsiteURLField(){
        return Editable.getElementBy(websiteURLField);
    }
    public Clickable getPaymentProcessingSubTab() {
        return Clickable.getElementBy(paymentProcessingSubTab,"Payment Processing Sub Tab");
    }
    public Clickable getAcceptVenmoToggleButton() {
        return Clickable.getElementBy(acceptVenmoToggleBtn,"Earn Rewards Toggle Button");
    }
    public Clickable getAcceptZelleToggleButton() {
        return Clickable.getElementBy(earnRewardsToggleBtn, "Earn Rewards Toggle Button");
    }

}