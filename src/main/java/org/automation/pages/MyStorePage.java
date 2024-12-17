package org.automation.pages;

import java.awt.*;
import java.nio.file.Paths;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class MyStorePage extends BasePage {
    public String storeName;
    By registerNewBusinessBtn = By.partialLinkText("Register new business");
    By skipPopUpTitle = By.xpath("//h5[text()='Skip']");
    By skipStripeAccountBtn = By.cssSelector(".btn-lg.fw-bold.w-100.btn.btn-outline-primary");
    public By skipStripeAccountPopUpBtn = By.xpath("//div[@class='modal-content']//button[text()='Skip']");
    public By deleteStoreBtn = By.xpath("//button[text()='Delete the store']");
    By deleteStoreIcon = By.cssSelector(".fa.fa-check");
    By alertMessage = By.cssSelector("form.link-check.checked div.alert-message");
    By configureBtnBusinessPlanStore = By.xpath("(//h6[text()='Automation Flow Business']/../..//a)[1]");

    By blankFieldWarningMsg = By.xpath("//p[@class='alert-content']");
    By storeLogo = By.xpath("//div[@class='display-none -update-div-']//a");
    By StoreNameTbx = By.xpath("//input[@name='name']");
    By locationDescTbx = By.xpath("//input[@name='description']");
    By storeAddressField = By.cssSelector(".form-control.pac-target-input");
    By storeAddressOption = By.xpath("(//div[@class='pac-item'])[1]");
    By phoneTbx = By.xpath("//input[@name='phone']");
    By timeZoneField = By.xpath("//select[@name='timeZone']");
    By timeZoneOption = By.xpath("//option[text()='(GMT-05:00) Eastern Time (US & Canada)']");
    By taxRateTbx = By.xpath("//input[@name='taxRate']");
    By saveBtn = By.xpath("//button[text()='Save']");
    By saveVenmoPaymentBtn = By.xpath("//div[contains(@data-load,'/_venmoGatewayApplication')] //button[text()='Save']");
    By stripeBtn = By.cssSelector(".img-fluid.h-100");
    By connectStripePopUpTitle = By.xpath("//h5[text()='Connect to stripe']");
    By testStripeBtn = By.partialLinkText("Create a test Stripe account");
    By bankTransferToggleBtn = By.xpath("//span[text()='Accept bank transfer']");
    By skipForNowBtn = By.xpath("//button[text()='Skip for now']");
    By continueBtn = By.xpath("//button[text()='Continue']");
    By configureLink = By.xpath("(//h6[text()='Automation Flow 3']/../..//a)[1]");
    By configureLink2 = By.xpath("/html/body/div[4]/div/div/main/div/div[3]/div/div/div[4]/div[1]/a");
    By modifyBtn = By.xpath("//button[text()='Modify']");
    By plansSubTab = By.partialLinkText("Plans");
    By currentPlanMSg = By.xpath("//span[@class='text-success me-1']");
    public By planSignUpBtn = By.partialLinkText("Sign up");
    By yearlyBtn = By.xpath("//label[text()='Yearly']");
    By termsCbx = By.xpath("//span[text()='     I agree to the']");
    By changePlanBtn = By.xpath("//button[text()='Change plan']");
    By addedStoreName = By.cssSelector(".form-group.mb-3>h4");
    By addedLocationDescription = By.cssSelector("div[class='display-none -readonly-div-'] span");
    By addedStoreAddress = By.xpath("//label[text()='Store Address']/following-sibling::p");
    By addedStorePhone = By.xpath("//label[text()='Store Phone']/following-sibling::p");
    By addedCurrencyOfStore = By.xpath("//label[text()='Currency of the Store']/following-sibling::p");
    By addedTaxRate = By.xpath("//label[text()='Tax rate']/following-sibling::p");
    By addedVisaMethod = By.cssSelector("div[class='-title- d-flex flex-column'] span[class='text-nowrap']");
    By newCreditCardBtn = By.xpath("//span[text()='New Credit Card']");
    By newBankAccountBtn = By.xpath("//span[text()='New Bank Account']");
    By changePayMethodBtn = By.xpath("//button[text()='change']");
    By nextBillDate = By.xpath("(//div[@class='d-flex'])[2]");
    By configureBtnWithoutStripe = By.xpath("(//h6[text()='Automation Flow 3']/../..//a)[1]");
    By settingsSubTab = By.xpath("//a[text()='Settings']");
    By maxBillAmountTbx = By.xpath("//input[@name='maxBillAmountThreshold']");
    By tipGratuityToggleBtn = By.xpath("//span[@class='ms-2 custom-check-on'][text()='No']");
    By tipGratuityToggleOffBtn = By.xpath("//span[@class='ms-2 custom-check-off' and text()='Yes']");
    By tipConfigureBtn = By.xpath("//div[@class='checked-d-none']//button[@type='button'][text()='Configure']");
    By tipConfigPopUpTitle = By.xpath("//h5[text()='Tip configuration']");
    By tipPercentField1 = By.xpath("//input[@name='tipSelections[0].percentage']");
    By tipPercentField2 = By.xpath("//input[@name='tipSelections[1].percentage']");
    By tipPercentField3 = By.xpath("//input[@name='tipSelections[2].percentage']");
    By tipFlatValueField1 = By.xpath("//input[@name='tipSelections[0].amount']");
    By tipFlatValueField2 = By.xpath("//input[@name='tipSelections[1].amount']");
    By tipFlatValueField3 = By.xpath("//input[@name='tipSelections[2].amount']");
    By saveChangesBtn = By.xpath("//button[text()='Save changes']");
    By rewardConfigureBtn = By.xpath("(//button[@type='button'][text()='Configure'])[2]");
    By rewardConfigPopUpTitle = By.xpath("//h5[text()='Rewards Program Configuration']");
    By rewardPointToggleBtn = By.xpath("//span[@class='ms-2 fs-6 custom-check-off']");
    By rewardPointToggleOffBtn = By.xpath("//span[@class='ms-2 fs-6 custom-check-on']");
    By rewardPointsField = By.xpath("//input[@name='pointsForGiftcard']");
    By rewardPtsValue = By.xpath("//input[@name='ponitsValue']");
    By checkBtn = By.cssSelector(".btn.btn-dark.-crop-");
    By checkDeleteUser = By.xpath("//button[@class='btn btn-outline-success']");
    By storeLinksBtn = By.xpath("//button[text()='Store links']");
    By websiteURLField = By.xpath("//input[@name='StoreURLTypes[0].url']");
    By earnRewardsToggleBtn = By.xpath("//label[text()=' Website']/../..//i[@class='far fa-toggle-off custom-check-off ']");
    By earnRewardsToggleOffBtn = By.xpath("//label[text()=' Website']/../..//i[@class='far fa-toggle-on custom-check-on ']");
    By enterInPercentToggleBtn = By.xpath("//label[text()=' Enter in percentage']");
    public By paymentProcessingSubTab = By.xpath("//a[text()='Payment Processing']");
    By acceptVenmoToggleBtn = By.xpath("(//span[text()='Accept Venmo'])[1]");
    By acceptZelleToggleBtn = By.xpath("//span[text()='Accept Zelle']");
    By venmoIDField = By.xpath("//label[text()='Venmo ID']/following-sibling::input");
    By venmoNameField = By.xpath("//label[text()='Venmo Name']/following-sibling::input");
    By zellePhoneField = By.xpath("//input[@name='phoneemail']");
    By zelleNameField = By.xpath("//label[text()='Name of the account in Zelle']/following-sibling::input");
    public By creditCardTerminalBtn = By.xpath("//a[text()='Credit Card Terminals']");
    By addNewTerminalBtn = By.xpath("//button[text()='Add new terminal']");
    By newTerminalPopUpTitle = By.xpath("//h5[text()='New Terminal']");
    By creditCardTerminalOption = By.xpath("//label[text()='Select your terminal']/../div[1]/label/i[2]");
    By manageUserSubTab = By.xpath("//a[text()='Manage Users']");
    By addUserButton = By.xpath("//button[text()='Add User']");
    By manageUserNameField = By.xpath("//div[@class='mb-2']//div[@class='input-group']//input");
    By userProfileDropDown = By.xpath("//select[@name='profileId']");
    By managerProfileOption = By.xpath("//option[@value='3000']");
    By manageUserPassword = By.xpath("//input[@name='passWord']");
    By createManagerUserButton = By.xpath("//button[@class='btn btn-primary']");
    By addUserPopUpTitle = By.cssSelector(".modal-title");
    By inviteExistingUserButton = By.xpath("//button[@class='position-relative btn btn-outline-primary']");
    By inviteExistingUserPopupTitle = By.cssSelector(".modal-title");
    By inviteMangeUserEmailOrPhoneField = By.xpath("//input[@name='email_phones']");
    By sendInviteButton = By.xpath("//button[text()='Send Invite']");
    By activeSubTab = By.xpath("//span[text()='Active']");
    By deactivateBtn = By.xpath("//button[text()='Deactivate']");
    By activateButton = By.xpath("//button[text()='Activate']");
    By notActiveStoreLabel = By.xpath("//h4[@class='me-2 text-danger']");
    By activeStoreLabel = By.xpath("//h4[@class='me-2 text-success']");
    By acceptVenmoHeader = By.xpath("//form[@action='/api/Stores/SaveVenmoGatewayApplication' and @style='display: none;']");
    By acceptZelleHeader = By.xpath("//form[@action='/api/Stores/SaveVenmoGatewayApplication']/../..  //div[@style='display: none;']");
    public By deleteUserIcon = By.xpath("(//h5[text()='Users with access to this store']/../..//button)[2]");
    By saveZellePaymentSettings = By.xpath("//form[@action='/api/Stores/SaveZelleGatewayApplication'] //button[text()='Save']");
    By editStoreBtn = By.xpath("//i[@class='far fa-edit ms-2']");
    By premiumTitle = By.xpath("//h4[text()='Premium']");
    By premiumMonthlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_0']");
    By premiumYearlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_1']");
    By premiumSignUpBtn = By.cssSelector("div#div_p3_0>a");


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

    public Editable getSkipPopUpTitle() {
        return Editable.getElementBy(skipPopUpTitle, "Skip PopUp Title");
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
        return Editable.getElementBy(blankFieldWarningMsg, "Blank Field Message");
    }

    public Clickable getStoreLogo() {
        return Clickable.getElementBy(storeLogo, "Store Logo");
    }

    public Editable getStoreNameField() {
        return Editable.getElementBy(StoreNameTbx, "Store Name Field");
    }

    public Editable getLocationDescriptionField() {
        return Editable.getElementBy(locationDescTbx, "Location Description Field");
    }

    public Editable getPhoneField() {
        return Editable.getElementBy(phoneTbx, "Phone Field");
    }

    public Editable getTaxRateField() {
        return Editable.getElementBy(taxRateTbx, "Tax Rate Field");
    }

    public Clickable getSaveButton() {
        return Clickable.getElementBy(saveBtn, "Save Button");
    }

    public Clickable getStipeAccountButton() {
        return Clickable.getElementBy(stripeBtn, "Stripe Account Button");
    }

    public Editable getConnectStripePopUpTitle() {
        return Editable.getElementBy(connectStripePopUpTitle, "Connect Stripe PopUp Title");
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

    public Clickable getConfigureLink2() {
        return Clickable.getElementBy(configureLink2,"Configure Link 2");
    }

    public Clickable getModifyButton() {
        return Clickable.getElementBy(modifyBtn, "Modify Button");
    }

    public Editable getAddedStoreName() {
        return Editable.getElementBy(addedStoreName, "Added Store Name");
    }

    public Editable getAddedLocationDescription() {
        return Editable.getElementBy(addedLocationDescription, "Added Location Description");
    }

    public Editable getAddedStoreAddress() {
        return Editable.getElementBy(addedStoreAddress, "Added Store Address");
    }

    public Editable getAddedStorePhone() {
        return Editable.getElementBy(addedStorePhone, "Added Store Phone");
    }

    public Editable getAddedCurrencyOfStore() {
        return Editable.getElementBy(addedCurrencyOfStore, "Added Currency of Store");
    }

    public Editable getAddedTaxRate() {
        return Editable.getElementBy(addedTaxRate, "Added Tax Rate");
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

    public Editable getCurrentPlanSuccessMessage() {
        return Editable.getElementBy(currentPlanMSg, "current Plan Message");
    }

    public Editable getDefaultPaymentMethod() {
        return Editable.getElementBy(addedVisaMethod, "Added Visa Method");
    }

    public Clickable getChangePayMethodLink() {
        return Clickable.getElementBy(changePayMethodBtn, "Change Plan Method Link");
    }

    public Clickable getNewCreditCardButton() {
        return Clickable.getElementBy(newCreditCardBtn, "New Credit Card Button");
    }

    public Clickable getNewBankAccountButton() {
        return Clickable.getElementBy(newBankAccountBtn, "New Bank Account Button");
    }

    public Clickable getNextBillDate() {
        return Clickable.getElementBy(nextBillDate, "Next Bill Date");
    }

    public Clickable getConfigureButton() {
        return Clickable.getElementBy(configureBtnWithoutStripe, "Configure Button");
    }

    public Clickable getSettingsSubTab() {
        return Clickable.getElementBy(settingsSubTab, "Settings Sub Tab");
    }

    public Editable getMaximumBillAmountField() {
        return Editable.getElementBy(maxBillAmountTbx, "Maximum Bill Amount Field");
    }

    public Clickable getTipGratuityToggleOnButton() {
        return Clickable.getElementBy(tipGratuityToggleBtn, "Tip Gratuity Toggle Button");
    }

    public Clickable getTipGratuityToggleOffButton() {
        return Clickable.getElementBy(tipGratuityToggleOffBtn, "Tip Gratuity Toggle Button");
    }

    public Clickable getTipConfigureButton() {
        return Clickable.getElementBy(tipConfigureBtn, "Tip Configure Button");
    }

    public Editable getTipConfigPopUpTitle() {
        return Editable.getElementBy(tipConfigPopUpTitle, "Tip Configuration Pop Up");
    }

    public Editable getTipAmountPerCentField1() {
        return Editable.getElementBy(tipPercentField1, "Tip Amount Percentage Field 1");
    }

    public Editable getTipAmountPerCentField2() {
        return Editable.getElementBy(tipPercentField2, "Tip Amount Percentage Field 2");
    }

    public Editable getTipAmountPerCentField3() {
        return Editable.getElementBy(tipPercentField3, "Tip Amount Percentage Field 3");
    }

    public Editable getTipAmountFlatValueField1() {
        return Editable.getElementBy(tipFlatValueField1, "Tip Amount Flat Value Field 1");
    }

    public Editable getTipAmountFlatValueField2() {
        return Editable.getElementBy(tipFlatValueField2, "Tip Amount Flat Value Field 2");
    }

    public Editable getTipAmountFlatValueField3() {
        return Editable.getElementBy(tipFlatValueField3, "Tip Amount Flat Value Field 1");
    }

    public Clickable getSaveChangesButton() {
        return Clickable.getElementBy(saveChangesBtn, "Save Changes Button");
    }

    public Clickable getRewardConfigureButton() {
        return Clickable.getElementBy(rewardConfigureBtn, "Reward Configure Button");
    }

    public Editable getRewardConfigPopUpTitle() {
        return Editable.getElementBy(rewardConfigPopUpTitle, "Reward Configuration PopUp");
    }

    public Clickable getRewardPointToggleOnButton() {
        return Clickable.getElementBy(rewardPointToggleBtn, "Reward Point Toggle Button");
    }

    public Clickable getRewardPointToggleOffButton() {
        return Clickable.getElementBy(rewardPointToggleOffBtn, "Reward Point Toggle Button");
    }

    public Clickable getEnterInPerCentToggleButton() {
        return Clickable.getElementBy(enterInPercentToggleBtn, "Enter in Percentage Toggle Button");
    }

    public Editable getRewardPointsField() {
        return Editable.getElementBy(rewardPointsField, "Reward Points Field");
    }

    public Clickable getEarnRewardsPointsToggleButton() {
        return Clickable.getElementBy(earnRewardsToggleBtn, "Earn Rewards Toggle Button");
    }

    public Clickable getEarnRewardsPointsToggleOffButton() {
        return Clickable.getElementBy(earnRewardsToggleOffBtn, "Earn Rewards Toggle Button");
    }

    public Clickable getCheckButton() {
        return Clickable.getElementBy(checkBtn, "Check Button");
    }

    public Clickable getStoreLinksButton() {
        return Clickable.getElementBy(storeLinksBtn, "Store Links Button");
    }

    public Editable getRewardPointsValueField() {
        return Editable.getElementBy(rewardPtsValue, "Reward Points Value");
    }

    public Editable getWebsiteURLField() {
        return Editable.getElementBy(websiteURLField, "Website URL Field");
    }

    public Clickable getPaymentProcessingSubTab() {
        return Clickable.getElementBy(paymentProcessingSubTab, "Payment Processing Sub Tab");
    }

    public Clickable getAcceptVenmoToggleButton() {
        return Clickable.getElementBy(acceptVenmoToggleBtn, "Accept Venmo Toggle Button");
    }

    public Clickable getAcceptZelleToggleButton() {
        return Clickable.getElementBy(acceptZelleToggleBtn, "Accept Zelle Toggle Button");
    }

    public Editable getVenmoIdField() {
        return Editable.getElementBy(venmoIDField, "Venmo ID Field");
    }

    public Clickable getAcceptVenmoHeader() {
        return Clickable.getElementBy(acceptVenmoHeader, "Accept Venmo Header");
    }

    public Editable getVenmoNameField() {
        return Editable.getElementBy(venmoNameField, "Venmo Name Field");
    }

    public Editable getZellePhoneField() {
        return Editable.getElementBy(zellePhoneField, "Zelle Phone Field");
    }

    public Editable getZelleNameField() {
        return Editable.getElementBy(zelleNameField, "Zelle Name Field");
    }

    public Clickable getCreditCardTerminalButton() {
        return Clickable.getElementBy(creditCardTerminalBtn, "Credit Card Terminal Button");
    }

    public Clickable getAddNewTerminalButton() {
        return Clickable.getElementBy(addNewTerminalBtn, "Add New Terminal Button");
    }

    public Editable getNewTerminalPopUpTitle() {
        return Editable.getElementBy(newTerminalPopUpTitle, "New Terminal Pop Up Title");
    }

    public Clickable getCreditTerminalOption() {
        return Clickable.getElementBy(creditCardTerminalOption, "Credit Card Terminal Option");
    }

    public Clickable getManageUserSubTab() {
        return Clickable.getElementBy(manageUserSubTab, "Manage User Sub Tab");
    }

    public Clickable getAddUserButton() {
        return Clickable.getElementBy(addUserButton, "Add User Button");
    }

    public Editable getManageUserNameField() {
        return Editable.getElementBy(manageUserNameField, "Manage User Name Field");
    }

    public Clickable getUserProfileDropDown() {
        return Clickable.getElementBy(userProfileDropDown, "User Profile Drop Down");
    }

    public Clickable getManagerProfileOption() {
        return Clickable.getElementBy(managerProfileOption, "Manager Profile Option");
    }

    public Editable getManageUserPassword() {
        return Editable.getElementBy(manageUserPassword, "Manage User Password");
    }

    public Clickable getCreateUserButton() {
        return Clickable.getElementBy(createManagerUserButton, "Create User Button");
    }

    public Clickable getAddUserPopUpTitle() {
        return Clickable.getElementBy(addUserPopUpTitle, "Add User Pop Up Title");
    }

    public Clickable getInviteExistingUserButton() {
        return Clickable.getElementBy(inviteExistingUserButton, "Invite Existing User Button");
    }

    public Clickable getInviteExistingUserPopupTitle() {
        return Clickable.getElementBy(inviteExistingUserPopupTitle, "Invite Existing User Pop Up Title");
    }

    public Editable getInviteUserEmailOrPhoneField() {
        return Editable.getElementBy(inviteMangeUserEmailOrPhoneField, "Invite User Email or Phone Field");
    }

    public Clickable getSendInviteButton() {
        return Clickable.getElementBy(sendInviteButton, "Send Invite Button");
    }

    public Clickable getActiveSubTab() {
        return Clickable.getElementBy(activeSubTab, "Active Sub Tab");
    }

    public Clickable getDeactivateButton() {
        return Clickable.getElementBy(deactivateBtn, "Deactivate Button");
    }

    public Clickable getActivateButton() {
        return Clickable.getElementBy(activateButton, "Activate Button");
    }

    public Editable getNotActiveStoreLabel() {
        return Editable.getElementBy(notActiveStoreLabel, "Not Active Store Label");
    }

    public Editable getActiveStoreLabel() {
        return Editable.getElementBy(activeStoreLabel, "Active Store Label");
    }

    public Clickable getAlertTipConfigurationMessage() {
        return Clickable.getElementBy(alertMessage, "Alert Tool Tip");
    }

    public Clickable getConfigureButtonForBusinessPlanStore() {
        return Clickable.getElementBy(configureBtnBusinessPlanStore, "Config button of store with business plan ");
    }

    public Clickable getDeleteUserButton() {
        return Clickable.getElementBy(deleteUserIcon, "Delete User Icon");
    }

    public Clickable getCheckDeleteUserButton() {
        return Clickable.getElementBy(checkDeleteUser, "Check Button");
    }

    public Clickable getVenmoSaveButton() {
        return Clickable.getElementBy(saveVenmoPaymentBtn, "Save Venmo payment settings");
    }

    public Clickable getAcceptZelleHeader() {
        return Clickable.getElementBy(acceptZelleHeader);
    }

    public Clickable getZelleSaveButton() {
        return Clickable.getElementBy(saveZellePaymentSettings, "Zelle Payment method");
    }

    public Clickable getEditStoreButton() {
        return Clickable.getElementBy(editStoreBtn, "Edit store config button");
    }
    public Clickable getPremiumTitle() { return Clickable.getElementBy(premiumTitle, "Premium title");}
    public Clickable getPremiumMonthlyBtn(){ return Clickable.getElementBy(premiumMonthlyBtn, " Premium Monthly button");}
    public Clickable getPremiumYearlyBtn(){ return Clickable.getElementBy(premiumYearlyBtn, " Premium yearly button ");}
    public Clickable getPremiumnSignUpBtn(){ return Clickable.getElementBy(premiumSignUpBtn, " Preemium Sign up button ");}




}

