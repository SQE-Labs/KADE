package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SearchPage extends BasePage {
    //Locators
    public By SearchTab = By.xpath("(//a[@class='sidebar-link '])[1]");
    By SearchPopup = By.cssSelector(".modal-content");
    By SearchLabel = By.xpath("//div[@class = 'modal-body']/div");
    By SearchClose = By.xpath("//div[@class = 'modal-header']/button");
    By SearchBillReferenceId = By.xpath("(//div[@class='col-7    ']/span)[1]");
    public By CopyReferenceId = By.xpath("//div[@class='mb-1']/span");
    By CloseBillButton = By.xpath("//div[@class='modal-header']/button");
    public By ClickSearchBox = By.xpath("//input[@name='phrase']");
    By ClickSearchIcon =By.xpath("//div[@class='input-group']/button");
    By Billid = By.xpath("//div[@class='mb-1']/span");
    public By SearchTransReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    By BillPageReferenceId = By.xpath("(//div[@class='modal-body']/div/div)[3]");
    public By TransactionId = By.xpath("(//div[@class='col-7']/div/span)[1]");
    By UserProfile = By.xpath("(//a[@class='text-truncate'])[1]");
    By Useremail = By.xpath("//div[@class='d-flex mb-2']/div/div");
    By VerifyUserEmail = By.xpath("//div[@class='d-flex flex-column overflow-hidden']/div");
    By ReferenceValidation = By.cssSelector(".display-none");


    public SearchPage()
    {
        super();
    }
    //To get Search Popup Box
    public Clickable SearchPopup() {
        return Clickable.getElementBy(SearchPopup,"Search Popup");
    }

    //To get Label on Search Popup
    public Editable getSearchLabel() {
        return Editable.getElementBy(SearchLabel, "Search Label");
    }

    //To click on Bill Reference ID
    public Clickable getSearchBillReferenceId() { return Clickable.getElementBy(SearchBillReferenceId, "Search Reference Id"); }

    //To copy Bill Reference ID
    public Clickable getCopyReferenceId() {
        return Clickable.getElementBy(CopyReferenceId, "Copy Reference Id");
    }

    //To close Bill Popup box
    public Clickable getCloseBillButton() {
        return Clickable.getElementBy(CloseBillButton, "Close Bill Button");
    }

    //To click on Search Box
    public Clickable getClickSearchBox() { return Clickable.getElementBy(ClickSearchBox, "Click Search Box"); }

    //Created one more method for Search box with Editable return type to use setText function
    public Editable getEditableClickSearchBox() { return Editable.getElementBy(ClickSearchBox, "Click Search Box"); }

    //To get the Reference ID we copied by clicking on it
    public String getClipboardText() throws IOException, UnsupportedFlavorException
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String clipboardtext = (String) clipboard.getData(DataFlavor.stringFlavor);
        return clipboardtext;
    }

    //To click on search icon
    public Clickable getClickSearchIcon() {
        return Clickable.getElementBy(ClickSearchIcon,"Click Search Icon");
    }

    //To get the Bill ID from bill popup displayed after searching with Bill Reference ID
    public Clickable getBillid() {
        return Clickable.getElementBy(Billid,"Bill Label");
    }

    //To get the Reference ID from Transaction Tab
    public Clickable getSearchTransReferenceId() { return Clickable.getElementBy(SearchTransReferenceId,"Search Transaction Reference Id"); }

    //To get the Transaction ID from Transaction popup displayed after searching with Transaction Reference ID
    public Clickable getTransactionId() {
        return Clickable.getElementBy(TransactionId,"Transaction Id");
    }

    //To open the profile of the user to copy email id
    public Clickable getUserProfile() {
        return Clickable.getElementBy(UserProfile,"User Profile");
    }

    //To get the email id for searching the user
    public Editable getUseremail() { return Editable.getElementBy(Useremail,"User Email");}

    //To get the email ID from customer's page displayed after searching with email id
    public Editable getVerifyUserEmail() { return Editable.getElementBy(VerifyUserEmail,"Verify User Email"); }

    //To get validation message displayed after searching
    public Editable getReferenceValidation() { return Editable.getElementBy(ReferenceValidation,"Reference Validation"); }


}
