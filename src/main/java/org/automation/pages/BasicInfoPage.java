package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class BasicInfoPage extends BasePage {

    By manageBusinessAcc = By.xpath("//a[@class='sidebar-link collapsed' and text()='Manage Business']");
    By myStores = By.cssSelector(".align-middle.me-2.fa-fw.fas.fa-store");
    By custStoreConfig = By.cssSelector("a.float-end.btn.btn-link[href^='/Stores/manageStore/3790']");
    By storeConfigTitle = By.cssSelector(".header-title.mb-0");
    By basicInfoTab = By.xpath("//a[contains(@href, '#_71Z')]");
    By basicInfoPg = By.cssSelector(".col-md-9.col-xl-10");
    By storeAddress = By.xpath("//label[@class='text-muted fs-pn15'][text()='Store Address']");
    By storePhone = By.xpath("//label[@class='text-muted fs-pn15'][text()='Store Phone']");
    By storeCurrency = By.xpath("//label[@class='text-muted fs-pn15'][text()='Currency of the Store']");
    By storeTaxRate = By.xpath("//label[@class='text-muted fs-pn15'][text()='Tax rate']");
    public By modifyBtn = By.xpath("//button[@class='-btn-modify- btn btn-outline-primary']");
    By storeNameField = By.xpath("//input[@name='name']");
    By saveButton = By.xpath("//button[@class='-btn-save- btn btn-primary']");
    By storeFullAddress = By.xpath("//input[@name='fulladdress']");
    By storePhoneField = By.xpath("//input[@name='phone']");
    By storeTexRateField = By.xpath("//input[@name='taxRate']");
    public By storeLogo = By.xpath("//a[@class=' -profile- d-inline-block position-relative start-50 translate-middle-x']");
    public By checkBtn = By.cssSelector(".fa.fa-check");
    By validationMsg = By.cssSelector(".toast-message");
    By alertMsg = By.cssSelector(".alert-content");

    public Clickable getAlertMessage() {return Clickable.getElementBy(alertMsg,"Alert message that is displayed after entering invalid data");}

    public Clickable getValidationMsg() {return Clickable.getElementBy(validationMsg,"Validation message for uploading invalid file as store logo");}

    public Clickable getCheckBtn() {return Clickable.getElementBy(checkBtn,"Check button");}

    public Clickable getStoreLogo() {return Clickable.getElementBy(storeLogo,"Store logo");}

    public Editable getStoreTaxRateField() {return Editable.getElementBy(storeTexRateField,"Store tax rate field");}

    public Editable getStorePhoneField() {return Editable.getElementBy(storePhoneField,"Store contact number");}

    public Editable getStoreAddressField() {return Editable.getElementBy(storeFullAddress,"Store Address field");}

    public Clickable getSaveButton() {return Clickable.getElementBy(saveButton,"Save button");}

    public Editable getStoreNameField() {return Editable.getElementBy(storeNameField,"Name of the business field");}

    public Clickable getModifyButton() {return Clickable.getElementBy(modifyBtn,"Modify button");}

    public Clickable getStoreAddress() {return Clickable.getElementBy(storeAddress,"Store address");}

    public Clickable getStorePhone() {return Clickable.getElementBy(storePhone,"Store Phone number");}

    public Clickable getStoreCurrency(){return Clickable.getElementBy(storeCurrency,"Store currency");}

    public Clickable getStoreTaxRate() {return Clickable.getElementBy(storeTaxRate,"Store Tax rate");}

    public Clickable getStoreConfigBtn() {
        return Clickable.getElementBy(custStoreConfig,"Automation Cust Store Config button");
    }

    public Clickable getStoreConfigTitle() {
        return Clickable.getElementBy(storeConfigTitle,"Store configuration title");
    }

    public Clickable getBasicInfoPage() {
        return Clickable.getElementBy(basicInfoPg,"Basic configuration page");
    }

    public Clickable getBasicInfoTab() {
        return Clickable.getElementBy(basicInfoTab,"Basic Information tab button");
    }

    public static class TestConstants {
        public static final String addressVerificationError = "Address cannot be verified";
        public static final String invalidPhnValidation = "Invalid phone number";

    }

}
