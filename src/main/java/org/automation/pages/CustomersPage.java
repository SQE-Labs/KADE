package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class CustomersPage extends BasePage {

    By customersPageText = By.cssSelector(".header-title.mb-0");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By selectStore = By.xpath("//span[@title='Automation Bill Flow']");
    By cnt = By.cssSelector(".btn.btn-primary");
    By nameAddress = By.xpath("//div[@class='d-flex flex-column  overflow-hidden']");
    By findAddCustomer = By.xpath("//button[@class='-addnew- btn btn-outline-dark']");
    By filter = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    By phoneNumber = By.cssSelector("#_2PX > div.input-group > input.form-control");


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

    public Clickable phoneNumber() {
        return Clickable.getElementBy(phoneNumber,"Phone Number field");
    }


}
