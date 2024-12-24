package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomersPage extends BasePage {

    By customersPageText = By.cssSelector(".header-title.mb-0");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By selectStore = By.xpath("//ul[@class=\"select2-results__options\"]//li[contains(text(), \"Automation Cust Test\")]");
    By cnt = By.cssSelector(".btn.btn-primary");
    By nameAddress = By.xpath("//div[@class='d-flex flex-column  overflow-hidden']");
    public By findAddCustomer = By.xpath("//button[@class='-addnew- btn btn-outline-dark']");
    By filter = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    By phoneNumber = By.xpath("//input[@placeholder='Phone number']");
    By goBtn = By.xpath("//button[text()=\"Go\"]");
    By emailGoBtn = By.xpath("(//button[text()=\"Go\"])[2]");
    By customerName = By.xpath("(//input[@lbl-title=\"Customer's name?\"])[2]");
    By done = By.xpath("//button[text()=\"Done\"]");
    By emailField = By.xpath("//input[@placeholder='Email']");
    By filterPhoneNumber = By.xpath("(//input[@class='form-control'])[1]");
    By filterPhonenumberInvalid = By.xpath("(//input[@class='form-control is-invalid'])[1]");
    public By filterEmail = By.xpath("(//input[@class='form-control'])[2]");
    By invalidFilterEmail = By.xpath("//input[@class='form-control is-invalid']");
    By filterName  = By.xpath("(//input[@class='form-control'])[3]");
    By filterApplyBtn = By.xpath("//button[@class='btn-sm mt-4 -apply- btn btn-primary']");
    By filterTitle = By.xpath("//h5[@class='offcanvas-title']");
    By pencilIcon = By.xpath("//i[@class='fas fa-pencil fs-pn15']");
    By chngeName = By.xpath("//input[@name='userAliasName']");
    By saveBtn = By.xpath("//button[@class='float-end mt-2 mb-2 btn btn-primary']");
    By eyeIcon = By.cssSelector(".far.fa-eye");
    By profileHeading = By.xpath("//h1[@class='header-title mb-0']");
    By messageIcon = By.cssSelector(".fal.fa-paper-plane.fa-2x");
    By trophieIcon = By.cssSelector(".far.fa-trophy-alt.fa-fw.align-self-center");
    By storeName = By.xpath("//h3[@class='text-truncate']");
    By messagePg = By.xpath("//h1[@class='header-title mb-0']");
    By typeArea = By.cssSelector(".form-control");
    By sendBtn = By.cssSelector(".btn.btn-primary.align-self-start.mt-1");
    By unsendBtn = By.xpath("//button[@class='btn btn-outline-danger align-self-start mt-1 -deleteMessage-']");
    By deletecnfrm = By.cssSelector(".btn.btn-outline-success");
    By addRewardpts = By.cssSelector(".btn.btn-outline-primary.floar-start.collapsed.btn-sm");
    By memoinput = By.xpath("//input[@placeholder='Memo']");
    By rewardPoints = By.xpath("//input[@placeholder='Points']");
    By submitRewardPts = By.cssSelector(".btn.btn-outline-primary.ms-auto");
    By phoneValidation = By.cssSelector(".alert.alert-error.text-danger.display-none");
    By customerPopupClose = By.xpath("(//button[@class=\"btn-close\"])[2]");
    By emailValidation = By.xpath("(//div[@class=\"alert alert-error text-danger  display-none\"])[2]");
    By newBill = By.cssSelector(".fs-4");
    By newBillDropdown = By.xpath("//span[@class=\"select2-selection select2-selection--single\"]");
    By newBillSoreSelection = By.xpath("//ul[@class='select2-results__options']//li[contains(text(), \"Automation Cust Test\")]");
    By newBillBrn = By.cssSelector(".fs-p15.btn.btn-outline-dark");
    public By amountInput = By.xpath("//input[@class=\"text-center p-3 fs-inherit display-4 text-end form-control\"]");
    By selectCustomer = By.xpath("//div[@id=\"_EH\"]");
    By billPhonenumber = By.xpath("//input[@placeholder=\"Phone number\"]");
    public By billPhoneGoBtn = By.xpath("//button[@class=\"btn btn-primary\"]");
    public By billSendBtn = By.xpath("//div[@class=\"-totalDivId- d-flex justify-content-around position-relative\"]");
    By customerDisplayed = By.xpath("//span[text()=\"Rishabh\"]");
    By searchField = By.xpath("//input[@placeholder=\"Search\"]");
    By searchBtn = By.xpath("(//button[@class=\"btn btn-primary\"])[3]");
    By alertValidation = By.xpath("//h4[@class=\"alert-heading\"]");
    By noResult = By.xpath("//div[@class='no-result-icon']");
    public By selectCustomerinFilter = By.xpath("//div[@class='d-flex align-items-center position-relative mb-3 rounded border']");
    By customerSelection = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    By customerdisplayed = By.xpath("//div[@class='bg-white mb-2 row position-relative m-0 g-2 border rounded-2 -cust-row-']");
    By addPaymentMethod = By.xpath("//button[@class='-btn-add-payment- btn-sm btn btn-link']");
    By permissionChkbx = By.xpath("//i[@class='fal fa-square custom-check-off ']");
    By permissionCtnBtn = By.xpath("//button[@class='checked-d-inline-block d-none -launch-add-paymentmethod- btn btn-primary']");
    public By addCardNumberField = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
    By expirationDate = By.xpath("//input[@class='p-Input-input Input Input--empty p-Input-input--textRight']");
    By securityCode = By.xpath("//input[@placeholder='CVC']");
    By countrySelect = By.xpath("//select[@class=\"Input p-Select-select\"]");
    By selectCountry = By.xpath("//option[text()=\"Australia\"]");
    By saveCardBtn = By.xpath("//button[@class=\"btn btn-primary display-none\"]");
    By closefilter = By.xpath("//button[@class='btn-close text-reset']");
    By frame1 = By.xpath("//iframe[@title='Secure payment input frame']");

    public void storeSelection() {
        click(storesCombobox);
        click(selectStore);
    }

    public Clickable continuebtn() {
        return Clickable.getElementBy(cnt,"Continue button");
    };

    public Editable nameAddress() {
        return Editable.getElementBy(nameAddress,"Store name and address");
    }

    public Clickable findAddCustomer() {
        return Clickable.getElementBy(findAddCustomer,"Find or Add Customer");
    }

    public Clickable getCustPopupCloseBtn() {
        return Clickable.getElementBy(customerPopupClose,"Close button for Customer popup");
    }

    public Clickable filter() {
        return Clickable.getElementBy(filter,"Filter icon");
    }

    public void setPhoneNumber(String phoneNumberInput) {
        Editable phoneField = Editable.getElementBy(phoneNumber, "Phone Number field");
        phoneField.setText(phoneNumberInput); // Assuming setText() exists in the Editable class
    }

    public Editable getPhoneField(){
        return Editable.getElementBy(phoneNumber,"Email or Phone field");
    }

    public Clickable getPhoneValidation() {
        return Clickable.getElementBy(phoneValidation,"Please review the highlighted field(s)");
    }

    public void setEmailId(String emailId) {
        Editable email = Editable.getElementBy(emailField,"Email field");
        email.setText(emailId);
    }

    public Editable getEmailField(){
        return Editable.getElementBy(emailField,"Email or Phone field");
    }

    public Clickable getEmailValidation() {
        return Clickable.getElementBy(emailValidation,"Please review the highlighted field(s)");
    }

    public Clickable goPhoneNumber() {
        return Clickable.getElementBy(goBtn, "Phone number GO button");
    }

    public Clickable goEmail() {
        return Clickable.getElementBy(emailGoBtn,"Email GO button");
    }

    public void setCustomerName(String customerNameInput) {
        Editable nameField = Editable.getElementBy(customerName, "Customer's name");
        nameField.setText(customerNameInput); // Assuming setText() exists in the Editable class
    }

    public Clickable doneBtn() {
        return Clickable.getElementBy(done,"Done button for Customer's name");
    }

    public Clickable getNewBill() {
        return Clickable.getElementBy(newBill,"Create new bill");
    }

    public Clickable newBillBtn() {
        return Clickable.getElementBy(newBillBrn,"New Bill Button");
    }

    public void billstoreSelection() {
        click(newBillDropdown);
        click(newBillSoreSelection);
    }

    public Editable getAmount() {
        return Editable.getElementBy(amountInput,"Enter amount");
    }

//    public void setAmount(String billAmountInput) {
//        Editable amountInputField = Editable.getElementBy(amountInput, "Enter Bill Amount");
//        amountInputField.setText(billAmountInput); // Assuming setText() exists in the Editable class
//    }

    public Clickable selectCustoemr() {
        return Clickable.getElementBy(selectCustomer,"Select customer");
    }

    public Editable billByPhone() {
        return Editable.getElementBy(billPhonenumber,"Enter the phone number for Bill creation");
    }

    public Clickable billGoBtn() {
        return Clickable.getElementBy(billPhoneGoBtn,"Phone field GO button");
    }

    public Clickable billSendBtn() {
        return Clickable.getElementBy(billSendBtn,"Send bill button");
    }

    public Clickable customerDisplayed() {
        return Clickable.getElementBy(customerDisplayed,"Customer is displayed");
    }

    public Editable getSearch() {
        return Editable.getElementBy(searchField,"Search for customers");
    }

    public Clickable searchBtn() {
        return Clickable.getElementBy(searchBtn,"Search button");
    }

//    public void filterByPhoneNumber(String customerPhnNumber) {
//        Editable customersNumber = Editable.getElementBy(filterPhoneNumber,"Filter by Phone number");
//        customersNumber.setText(customerPhnNumber);
//    }

    public Clickable getNoResult() {
        return Clickable.getElementBy(noResult,"No result");
    }

    public Clickable closeFilterBtn() {
        return Clickable.getElementBy(closefilter,"close filter popup");
    }

    public Editable filterByPhnNumber() {
        return Editable.getElementBy(filterPhoneNumber,"Filter by Phone Number");
    }

    public Editable invalidFilterByPhnNumber() {
        return Editable.getElementBy(filterPhonenumberInvalid,"Invalid phone number field");
    }

    public Clickable alertValidation() {
        return Clickable.getElementBy(alertValidation,"Alert validation message");
    }

//    public void filterByEmail(String customerEmail) {
//        Editable customerEmailId = Editable.getElementBy(filterEmail,"Filter by Email");
//        customerEmailId.setText(customerEmail);
//    }

    public Editable filterByEmailId() {
        return Editable.getElementBy(filterEmail,"Email field");
    }

    public Editable invalidFilterByEmailId() {
        return Editable.getElementBy(invalidFilterEmail,"Email field");
    }

    public void filterByName(String customersName) {
        Editable customerName = Editable.getElementBy(filterName,"Filter by Name");
        customerName.setText(customersName);
    }

    public Clickable selectCustomer() {
        return Clickable.getElementBy(selectCustomerinFilter,"Select customer");
    }

    public Clickable customerSelection() {
        return Clickable.getElementBy(customerSelection,"Custoemr selection");
    }

    public Clickable customerdisplayed() {
        return Clickable.getElementBy(customerdisplayed,"If customer is displayed");
    }

    public Clickable filterApply() {
        return Clickable.getElementBy(filterApplyBtn,"Filter Apply button");
    }

    public Clickable chngeName() {
        return Clickable.getElementBy(pencilIcon,"Change Customers name");
    }

    public void changeCustomerName(String changeNameInput) {
        Editable chngenameField = Editable.getElementBy(chngeName, "Change Customer's name");
        chngenameField.setText(changeNameInput); // Assuming setText() exists in the Editable class
    }

    public Clickable saveBtn() {
        return Clickable.getElementBy(saveBtn, "Save the new customers name");
    }

    public Clickable viewProfile() {
        return Clickable.getElementBy(eyeIcon,"Open customer's profile page");
    }


    public Clickable profileHeading() {
        return Clickable.getElementBy(profileHeading,"Customer's name displayed at the top of the profile page");
    }

    public Clickable messageIcon() {
        return Clickable.getElementBy(messageIcon,"Message customer icon");
    }

    public Clickable rewardIcon() {
        return Clickable.getElementBy(trophieIcon,"Reward points");
    }

    public  Clickable storeName() {
        return Clickable.getElementBy(storeName,"Store name displayed on the profile page");
    }

    public Clickable getMsgPgHeader() {
        return Clickable.getElementBy(messagePg,"Message page header");
    }

    public void typeMessage(String typeamsg) {
        Editable typeamessage = Editable.getElementBy(typeArea,"Type a message to a customer");
        typeamessage.setText(typeamsg);
    }

    public Clickable sendButton() {
        return Clickable.getElementBy(sendBtn,"Send message button");
    }

    public  Clickable unsendBtn() {
        return Clickable.getElementBy(unsendBtn,"Unsend last set message");
    }

    public Clickable confirmUnsend() {
        return Clickable.getElementBy(deletecnfrm,"confirm and delete");
    }

    public Clickable addRewardPoints() {
        return Clickable.getElementBy(addRewardpts,"Add reward points");
    }

    public void memoInput(String typememo) {
        Editable typeaMemo = Editable.getElementBy(memoinput,"Type memo");
        typeaMemo.setText(typememo);
    }

    public void rewardpoints(String points) {
        Editable enterPoints = Editable.getElementBy(rewardPoints,"Enter reward points");
        enterPoints.setText(points);
    }

    public Clickable submitRewardsPoints() {
        return Clickable.getElementBy(submitRewardPts,"Submit and add reward points");
    }

    public Clickable addPaymentMethod() {
        return Clickable.getElementBy(addPaymentMethod,"Add Payment Method");
    }

    public Clickable permissionCheckbox() {
        return Clickable.getElementBy(permissionChkbx,"Permission checkbox");
    }

    public Clickable permissionContinueBtn() {
        return Clickable.getElementBy(permissionCtnBtn,"Permission continue after checkbox");
    }

    public Editable addingCard() {
        return Editable.getElementBy(addCardNumberField,"Add card number");
    }

    public Editable expirationDate() {
        return Editable.getElementBy(expirationDate,"Expiration of the card");
    }

    public Editable securityCode() {
        return Editable.getElementBy(securityCode,"Security code of the Card");
    }

//    public void countrySelection(String country) {
//        Editable countryName = Editable.getElementBy(countrySelect,"Enter country");
//        countryName.setText(country);
//    }

    public Clickable countrySelection() {
        return Clickable.getElementBy(countrySelect,"Click on country dropdown");
    }

    public Clickable selectCountry() {
        return Clickable.getElementBy(selectCountry,"Selection of country");
    }

    public Clickable saveCard() {
        return Clickable.getElementBy(saveCardBtn,"Save card details");
    }

    public void saveNewByCreditCard() {
        addingCard().setText("4111111111111111");
        expirationDate().setText("0230");
        securityCode().setText("123");
        countrySelection().click();
        selectCountry().click();

        saveCard().click();
    }

    public void seitchToFrame() {
        switchToFrame(frame1);
    }







}
