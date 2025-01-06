package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SecurityAndPassword extends BasePage {

    By userProfile = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
    By securityAndPasswordTab = By.xpath("//a[@class='list-group-item list-group-item-action'][text()='Security and Password']");
    By editEmailBtn = By.xpath("//button[@class='btn btn-outline-secondary'][@data-action='/users/_userProfile_replaceEmail']");
    public By updateEmailPopupTitle = By.xpath("//h5[text()='Update Email Address']");
    By closePopupBtn = By.cssSelector(".btn-close");
    By updateEmailInputField = By.xpath("//input[@placeholder='email@gmail.com']");
    By sendBtnForUpdatedEmail = By.cssSelector(".-email-.btn.btn-primary");
    By alertMessage = By.xpath("//p[text()='Please review the highlighted field(s)']");
    By currentSecurityCode = By.xpath("//input[@name='current_OTP']");
    public By newEmailSecurityCode = By.xpath("//input[@name='otp']");
    By saveBtn = By.xpath("//button[@class='display-none -otp- btn btn-primary']");
    By emailField = By.xpath("//input[@name='email'][@type='text']");
    By invalidSecurityCodeValidationMsg = By.xpath("//p[text()='Security code cannot be verified for the current email.']");
    By differentEmailBtn = By.xpath("//button[text()='Different Email']");
    public By sendBtnOfNewEMailPopup = By.xpath("//button[@class='-email- btn btn-primary']");
    By securityVerificationError = By.xpath("//p[text()='Security code cannot be verified for the new email.']");


    public Clickable getSecurityVerificationErrorMsg() {return Clickable.getElementBy(securityVerificationError,"Security verification error validation message");}

    public Clickable getSendBtnOfNewEmailPopup() {return Clickable.getElementBy(sendBtnOfNewEMailPopup,"Send Security code button of new email pop up");}

    public Clickable getDifferentEmailBtn() {return Clickable.getElementBy(differentEmailBtn,"Enter Different Email to receive security code");}

    public Clickable getSecurityCodeValidationMessage() {return Clickable.getElementBy(invalidSecurityCodeValidationMsg,"Invalid Security Code Validation Message");}

    public Clickable getEmailField() {return Clickable.getElementBy(emailField,"Email field");}

    public Clickable getSaveButton() {return Clickable.getElementBy(saveBtn,"Save button");}

    public Editable getNewEmailSecurityCode() {return Editable.getElementBy(newEmailSecurityCode,"Security code from the new email");}

    public Editable getCurrentEmailSecurityCode() {return Editable.getElementBy(currentSecurityCode,"Security code from the current email");}

    public Clickable getUserProfileBtn() {return Clickable.getElementBy(userProfile,"User profile link");}

    public Clickable getSecurityAndPasswordTab() {return Clickable.getElementBy(securityAndPasswordTab,"Open Security and Password Tab");}

    public Clickable getEditEmailBtn() {return Clickable.getElementBy(editEmailBtn,"Change Email button");}

    public Clickable getEditEmailPopupTitle() {return Clickable.getElementBy(updateEmailPopupTitle,"Update email popup title");}

    public Clickable getCloseUpdateEmailPopupBtn() {return Clickable.getElementBy(closePopupBtn,"Close popup");}

    public Editable getUpdateEmailField() {return Editable.getElementBy(updateEmailInputField,"Input new email");}

    public Clickable getSendBtnForUpdatedEmail() {return Clickable.getElementBy(sendBtnForUpdatedEmail,"Send Code button after updating Email");}

    public Clickable getAlertMessage() {return Clickable.getElementBy(alertMessage,"Alert message after entering invalid input");}



}
