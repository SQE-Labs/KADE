package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class CustomersPage extends BasePage {

    By customersPageText = By.cssSelector(".header-title.mb-0");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By selectStore = By.xpath("//ul[@class=\"select2-results__options\"]//li[contains(text(), \"Automation Cust Test\")]");
    By cnt = By.cssSelector(".btn.btn-primary");
    By nameAddress = By.xpath("//div[@class='d-flex flex-column  overflow-hidden']");
    By findAddCustomer = By.xpath("//button[@class='-addnew- btn btn-outline-dark']");
    By filter = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    By phoneNumber = By.xpath("//input[@placeholder='Phone number']");
    By goBtn = By.xpath("//button[text()=\"Go\"]");
    By emailGoBtn = By.xpath("(//button[text()=\"Go\"])[2]");
    By customerName = By.xpath("(//input[@lbl-title=\"Customer's name?\"])[2]");
    By done = By.xpath("//button[text()=\"Done\"]");
    By emailField = By.xpath("//input[@placeholder='Email']");
    By filterPhoneNumber = By.xpath("(//input[@class='form-control'])[1]");
    By filterEmail = By.xpath("(//input[@class='form-control'])[2]");
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
    By typeArea = By.cssSelector(".form-control");
    By sendBtn = By.cssSelector(".btn.btn-primary.align-self-start.mt-1");
    By unsendBtn = By.xpath("//button[@class='btn btn-outline-danger align-self-start mt-1 -deleteMessage-']");
    By deletecnfrm = By.cssSelector(".btn.btn-outline-success");
    By addRewardpts = By.cssSelector(".btn.btn-outline-primary.floar-start.collapsed.btn-sm");
    By memoinput = By.xpath("//input[@placeholder='Memo']");
    By rewardPoints = By.xpath("//input[@placeholder='Points']");
    By submitRewardPts = By.cssSelector(".btn.btn-outline-primary.ms-auto");


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

    public Clickable filter() {
        return Clickable.getElementBy(filter,"Filter icon");
    }

    public void setPhoneNumber(String phoneNumberInput) {
        Editable phoneField = Editable.getElementBy(phoneNumber, "Phone Number field");
        phoneField.setText(phoneNumberInput); // Assuming setText() exists in the Editable class
    }

    public void setEmailId(String emailId) {
        Editable email = Editable.getElementBy(emailField,"Email field");
        email.setText(emailId);
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

    public void filterByPhoneNumber(String customerPhnNumber) {
        Editable customersNumber = Editable.getElementBy(filterPhoneNumber,"Filter by Phone number");
        customersNumber.setText(customerPhnNumber);
    }

    public void filterByEmail(String customerEmail) {
        Editable customerEmailId = Editable.getElementBy(filterEmail,"Filter by Email");
        customerEmailId.setText(customerEmail);
    }

    public void filterByName(String customersName) {
        Editable customerName = Editable.getElementBy(filterName,"Filter by Name");
        customerName.setText(customersName);
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



}
