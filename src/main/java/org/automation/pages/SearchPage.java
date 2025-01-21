package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.automation.ReturnObjects.Clickable.getElementBy;

public class SearchPage extends BasePage {
    //Locators
    public By billBtn = By.xpath("//div[@class='text-nowrap'and contains(text(),'Bills')]");
    public By SearchBtn = By.xpath("//div[@class='text-nowrap'and contains(text(),'Search')]");
    By SearchPopup = By.cssSelector(".modal-content");
    By SearchLabel = By.xpath("//div[@class = 'modal-body']/div");
    public By SearchBillReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    public By CopyReferenceId = By.xpath("//div[@class='mb-1']/span");
    public By CloseBillButton = By.xpath("//div[@class='modal-header']/button");
    public By ClickSearchBox = By.xpath("//input[@name='phrase']");
    public By ClickSearchIcon =By.xpath("//div[@class='input-group']/button");
    public By Billid = By.xpath("//div[@class='mb-1']/span");
    public By SearchTransReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    public By TransactionId = By.xpath("(//div[@class='col-7']/div/span)[1]");
    By UserProfile = By.xpath("(//a[@class='text-truncate'])[1]");
    By UserProfilePhone = By.xpath("//a[@class='text-truncate' and contains(text(),'Marry')]");
    By Useremail = By.xpath("//div[@class='d-flex mb-2']/div/div");
    By UserPhoneNumber = By.cssSelector("div[class='text-truncate']");
    By VerifyUserEmail = By.xpath("//div[@class='d-flex flex-column overflow-hidden']/div");
    By VerifyUserPhoneNumber = By.xpath("//div[@class='d-flex mb-2']/div/div");
    By ReferenceValidation = By.cssSelector(".display-none");
    public By transactionsButton = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");

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
    public Editable getSearchBillReferenceId() { return Editable.getElementBy(SearchBillReferenceId, "Search Reference Id"); }

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
    public Clickable getbillBtn()
    {
        return Clickable.getElementBy(billBtn, "Click Bill Button");
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

    //To click on Search Tab
    public Clickable getSearchTab(){
        return getElementBy(SearchBtn);
    }

    //To open the profile of the user to copy email id
    public Clickable getUserProfile() {
        return Clickable.getElementBy(UserProfile,"User Profile");
    }

    //To get the email id for searching the user
    public Editable getUseremail() { return Editable.getElementBy(Useremail,"User Email");}

    //To get the Phone Number for searching the user
    public Editable getUserPhoneNumber() { return Editable.getElementBy(UserPhoneNumber,"User Email");}

    //To get the email ID from customer's page displayed after searching with email id
    public Editable getVerifyUserEmail() { return Editable.getElementBy(VerifyUserEmail,"Verify User Email"); }

    //To get the Phone Number from customer's page displayed after searching with email id
    public Editable getVerifyUserPhoneNumber() { return Editable.getElementBy(VerifyUserPhoneNumber,"Verify User Email"); }

    //To get validation message displayed after searching
    public Editable getReferenceValidation() { return Editable.getElementBy(ReferenceValidation,"Reference Validation"); }

    //To click on Transaction button
    public Clickable getTransactionsButton() { return Clickable.getElementBy(transactionsButton,"Transaction Button"); }

    //To get User profile for phone number
    public Clickable getUserProfilePhone() { return Clickable.getElementBy(UserProfilePhone,"User Profile Phone"); }

    //To search & verify bill and transaction id
    public void performSearchAndVerify(String actiontype) throws IOException, UnsupportedFlavorException {
        if (actiontype.equals("Bills"))
        {
            getbillBtn().click();
            getSearchBillReferenceId().clickByMouseActions(SearchBillReferenceId);
            WebdriverWaits.waitForElementClickable(CopyReferenceId,3);
            getCopyReferenceId().click();
            getCloseBillButton().click();
            getSearchTab().click();
            getClickSearchBox().click();
            String copiedText = getClipboardText();
            WebElement searchBoxElement = getElement(ClickSearchBox);
            searchBoxElement.sendKeys(copiedText);
            getClickSearchIcon().click();
            getBillid().click();
            String actualResult = getClipboardText();
            Assertions.assertEquals(copiedText, actualResult);
            getCloseBillButton().click();

        }
        else
        {
            getTransactionsButton().click();
            getSearchTransReferenceId().clickByMouseActions(SearchTransReferenceId);
            getSearchTab().click();
            getClickSearchBox().click();
            String copiedText = getClipboardText();
            WebElement searchBoxElement = getElement(ClickSearchBox);
            searchBoxElement.sendKeys(copiedText);
            getClickSearchIcon().click();
            getTransactionId().click();
            String actualResult = getClipboardText();
            Assertions.assertEquals(copiedText, actualResult);
        }
    }




}
