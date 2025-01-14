package org.automation.pages.popups;

import org.apache.poi.util.NullLogger;
import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {
    //Locators
    By SearchRow = By.xpath("//a[@class = 'sidebar-link']");
    By SearchPopup = By.cssSelector(".modal-content");
    By SearchLabel = By.xpath("//div[@class = 'modal-body']/div");
    By SearchClose = By.xpath("//div[@class = 'modal-header']/button");
    By SearchBillReferenceId = By.xpath("(//div[@class='col-7    ']/span)[1]");
    public By CopyReferenceId = By.xpath("//div[@class='mb-1']/span");
    By CloseBillButton = By.xpath("//div[@class='modal-header']/button");
    public By ClickSearchBox = By.xpath("//input[@name='phrase']");
    By ClickSearchIcon =By.xpath("//div[@class='input-group']/button");
    By Billid = By.xpath("//div[@class='mb-1']/span");
    //By BillLabel = By.xpath("//span[text() = 'Bill']");
    public By SearchTransReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    By BillPageReferenceId = By.xpath("(//div[@class='modal-body']/div/div)[3]");
    public By TransactionId = By.xpath("(//div[@class='col-7']/div/span)[1]");
    By UserProfile = By.xpath("(//a[@class='text-truncate'])[1]");


    public SearchPage()
    {
        super();
    }

    public Clickable SearchPopup() {
        return Clickable.getElementBy(SearchPopup,"Search Popup");
    }

    public Clickable closeSearchPopup() {
        return Clickable.getElementBy(SearchClose,"Search Popup Close");
    }

    public Editable getSearchLabel() {
        return Editable.getElementBy(SearchLabel, "Search Label");
    }

    public Clickable getSearchBillReferenceId() {
        return Clickable.getElementBy(SearchBillReferenceId, "Search Reference Id");
    }
    public Clickable getCopyReferenceId() {
        return Clickable.getElementBy(CopyReferenceId, "Copy Reference Id");
    }
    public Clickable getCloseBillButton() {
        return Clickable.getElementBy(CloseBillButton, "Close Bill Button");
    }
    public Clickable getClickSearchBox() {

        return Clickable.getElementBy(ClickSearchBox, "Click Search Box");
    }
    public String getClipboardText() throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String clipboardtext = (String) clipboard.getData(DataFlavor.stringFlavor);
        return clipboardtext;
    }
    public Clickable getClickSearchIcon() {
        return Clickable.getElementBy(ClickSearchIcon,"Click Search Icon");
    }
    public Clickable getBillid() {
        return Clickable.getElementBy(Billid,"Bill Label");
    }
    public Clickable getSearchTransReferenceId() {
        return Clickable.getElementBy(SearchTransReferenceId,"Search Transaction Reference Id");
    }
    public Clickable getBillPageReferenceId() {
        return Clickable.getElementBy(BillPageReferenceId,"Bill Page Reference Id");
    }

    public Clickable getTransactionId() {
        return Clickable.getElementBy(TransactionId,"Transaction Id");
    }

    public Clickable getUserProfile() {
        return Clickable.getElementBy(UserProfile,"User Profile");
    }





}
