package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class RewardsProgramPage extends BasePage {


    By storeCombobox = By.cssSelector(".select2-selection.select2-selection--single");
    By cutomerStoreOption = By.xpath("//li[@class='select2-results__option'][text()='Automation Customer Store']");
    By continueBtn = By.xpath("//button[@class='btn btn-primary'][text()='Continue']");
    By pageHeading = By.cssSelector(".header-title.mb-0");


    public Clickable getRewardsProgramHeading() {return Clickable.getElementBy(pageHeading,"Rewards Program page heading");}

    public Clickable getContinueButton() {return Clickable.getElementBy(continueBtn,"Continue Button");}

    public Clickable getcustomerStoreOption() {return Clickable.getElementBy(cutomerStoreOption,"Store selection");}

    public Clickable getStoreDropdown() {return Clickable.getElementBy(storeCombobox,"Store dropdown");}
}
