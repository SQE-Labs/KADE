package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class RewardsProgramPage extends BasePage {


    By storeCombobox = By.cssSelector(".select2-selection.select2-selection--single");
    By cutomerStoreOption = By.xpath("//li[@class='select2-results__option'][text()='Automation Customer Store']");
    By continueBtn = By.xpath("//button[@class='btn btn-primary'][text()='Continue']");
    By pageHeading = By.cssSelector(".header-title.mb-0");
    By infoMsgRewardsConfig = By.cssSelector(".fa.fa-do-not-enter.text-danger.me-2");
    By settingsBtn = By.cssSelector(".btn.btn-link.float-end.p-0");
    By rewardsProgPopupTitle = By.cssSelector(".modal-title");
    By toggleDisabled = By.cssSelector(".far.fa-toggle-off.custom-check-off ");
    By toggleEnabled = By.cssSelector(".far.fa-toggle-on.custom-check-on ");
    By saveChangesBtn = By.xpath("//button[@class='btn btn-primary'][text()='Save changes']");
    By rewardsProgActivationMsg = By.cssSelector(".fa.fa-check.text-success.me-2");
    By customerNameYonro = By.xpath("//span[text()='Yonro']");
    By customerCardTitle = By.xpath("//h5[@class='card-title'][text()='Customer']");
    By rewardsPtsCardTitle = By.xpath("//h4[@class='card-title'][text()='Reward points']");
    By rewardsPntsLink = By.xpath("//a[@class='btn btn-link'][1]");
    By rewardsPtsPgTitle = By.xpath("//h1[@class='header-title mb-0']");
    By addNewRowBtn = By.cssSelector(".btn.btn-outline-primary.floar-start.collapsed.btn-sm");
    By memoInputField = By.xpath("//input[@name='memo']");
    By pointsInputField = By.xpath("//input[@name='points']");
    By addBtn = By.cssSelector(".btn.btn-outline-primary.ms-auto");
    By alertMsg = By.xpath("//p[text()='Please review the highlighted field(s)']");
    By filterBtn = By.cssSelector(".fas.fa-filter.me-1");
    By partialUsername = By.xpath("//input[@name='userName']");
    public By userPhnEmail = By.xpath("//input[@name='emailPhone']");
    By lastVisit = By.xpath("//input[@name='dateRangeLastVisit']");
    By customerSince = By.xpath("//input[@name='dateRangeCustomerSince']");
    By minRewardPts = By.xpath("//input[@name='minRewardPoints']");
    By maxRewardPts = By.xpath("//input[@name='maxRewardPoints']");
    public By applyBtn = By.cssSelector(".btn-sm.btn.btn-outline-primary");
    By yonroCustomer = By.xpath("//span[text()='yonro']");
    By noResultIcon = By.cssSelector(".no-result-icon");
    By minPayments = By.cssSelector("[name='minpayments']");
    By maxPayments = By.cssSelector("[name='maxpayments']");


    public Editable getMaxPayments() {return Editable.getElementBy(maxPayments,"Maximum number of payments made by the customer");}

    public Editable getMinPayments() {return Editable.getElementBy(minPayments,"Minimum number of payments made by the customer");}

    public Clickable getNoResultIcon() {return Clickable.getElementBy(noResultIcon,"There are no results");}

    public Clickable getYonroCustomer() {return Clickable.getElementBy(yonroCustomer,"Yonro Customer record");}

    public Clickable getApplyBtn() {return Clickable.getElementBy(applyBtn,"Apply button");}

    public Editable getMaxRewardPts() {return Editable.getElementBy(maxRewardPts,"Maximum reward pts");}

    public Editable getMinRewardsPts() {return Editable.getElementBy(minRewardPts,"Minimum rewards points");}

    public Editable getCustSince() {return Editable.getElementBy(customerSince,"Customer Since");}

    public Editable getLastVisit() {return Editable.getElementBy(lastVisit,"Last visit");}

    public Editable getUserPhnEmail() {return Editable.getElementBy(userPhnEmail,"User PHone/EMail");}

    public Editable getPartialUsername() {return Editable.getElementBy(partialUsername,"Username 'Partial' field ");}

    public Clickable getFilterBtn() {return  Clickable.getElementBy(filterBtn,"Filter button");}

    public Clickable getAlertMsg() {return Clickable.getElementBy(alertMsg,"Alert message");}

    public Clickable getAddBtn() {return Clickable.getElementBy(addBtn,"Add button");}

    public Editable getPointsInputField() {return Editable.getElementBy(pointsInputField,"Points input field");}

    public Editable getMemoInputField() {return Editable.getElementBy(memoInputField,"Memo input field");}

    public Clickable getAddNewRowBtn() {return Clickable.getElementBy(addNewRowBtn,"Add new row button");}

    public Clickable getRewardsPtsPgTitle() {return Clickable.getElementBy(rewardsPtsPgTitle,"Rewards Points Detail Page Title");}

    public Clickable getRewardsPntsLink() {return Clickable.getElementBy(rewardsPntsLink,"rewards points link");}

    public Clickable getRewardsPointsTitle() {return Clickable.getElementBy(rewardsPtsCardTitle,"RewardsPoints card title");}

    public Clickable getCustCardTitle() {return Clickable.getElementBy(customerCardTitle,"Customer Card Title");}

    public Clickable getCustomerName() {return Clickable.getElementBy(customerNameYonro,"Customer Name");}

    public Clickable getRewardsActivationMsg() {return Clickable.getElementBy(rewardsProgActivationMsg,"Rewards program is activated and configured");}

    public Clickable getSaveChangesBtn() {return Clickable.getElementBy(saveChangesBtn,"Save changes button");}

    public Clickable getToggleEnabled() {return Clickable.getElementBy(toggleEnabled,"Enabled Status");}

    public Clickable getToggleDisabled() {return Clickable.getElementBy(toggleDisabled,"Disabled status");}

    public Clickable getRewardsProgPopupTitle() {return Clickable.getElementBy(rewardsProgPopupTitle,"Popup title");}

    public Clickable getSettingsBtn() {return Clickable.getElementBy(settingsBtn,"Settings button ");}

    public Clickable getInfoMsgReardsConfig() { return Clickable.getElementBy(infoMsgRewardsConfig,"Rewards program is not configured");}

    public Clickable getRewardsProgramHeading() {return Clickable.getElementBy(pageHeading,"Rewards Program page heading");}

    public Clickable getContinueButton() {return Clickable.getElementBy(continueBtn,"Continue Button");}

    public Clickable getcustomerStoreOption() {return Clickable.getElementBy(cutomerStoreOption,"Store selection");}

    public Clickable getStoreDropdown() {return Clickable.getElementBy(storeCombobox,"Store dropdown");}
}
