package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class SecurityAndPassword extends BasePage {

    By userProfile = By.cssSelector("a.btn.btn-link.p-0.fs-pn15[href='/Users/userprofile']");
    public By securityAndPasswordTab = By.xpath("//a[@class='list-group-item list-group-item-action'][@data-section='security']");
    By editEmailBtn = By.cssSelector("button.btn.btn-outline-secondary[data-action='/users/_userProfile_replaceEmail']");
    public By updateEmailPopupTitle = By.cssSelector("h5.modal-title");
    By closePopupBtn = By.cssSelector(".btn-close");
    By updateEmailInputField = By.xpath("//input[@placeholder='email@gmail.com']");
    By sendBtnForUpdatedEmail = By.cssSelector(".-email-.btn.btn-primary");
    By alertMessage = By.xpath("//p[text()='Please review the highlighted field(s)']");
    public By currentSecurityCode = By.xpath("//input[@name='current_OTP']");
    public By newEmailSecurityCode = By.xpath("//input[@name='otp']");
    By saveBtn = By.xpath("//button[@class='display-none -otp- btn btn-primary']");
    By emailField = By.xpath("//input[@name='email'][@type='text']");
    By invalidSecurityCodeValidationMsg = By.xpath("//p[text()='Security code cannot be verified for the current email.']");
    By differentEmailBtn = By.xpath("//button[text()='Different Email']");
    public By sendBtnOfNewEMailPopup = By.xpath("//button[@class='-email- btn btn-primary']");
    By securityVerificationError = By.xpath("//p[text()='Security code cannot be verified for the new email.']");
    By editPhoneBtn = By.xpath("//button[@class='btn btn-outline-secondary'][@data-action='/users/_userProfile_replacePhone']");
    By newPhoneInputField = By.xpath("//input[@name='phone'][@placeholder='+12125551234']");
    By sendSecurityCodeForNewPhone = By.xpath("//button[@class='-phone- btn btn-primary']");
    By closeNewPhonePopup = By.cssSelector(".btn-close");
    By currentPhoneOTPField = By.xpath("//input[@name='current_otp']");
    By newPhoneOTPField = By.xpath("//input[@name='otp']");
    By differentCellPhone = By.xpath("//button[text()='Different Cell-phone']");
    By updatePhoneNumberPopupTitle = By.xpath("//h5[text()='Update Cell-phone']");
    By systemAlertMessage = By.cssSelector(".alert-heading");
    public By saveNewPhoneBtn = By.cssSelector(".display-none.-otp-.btn.btn-primary");
    By resetYourPassword = By.xpath("//a[@href='#'][text()='Reset your password']");
    By resetPwdEmailFIeld = By.cssSelector(".form-control.custom-select");
    By resetPwdSecurityCodeBtn = By.cssSelector(".-email-.btn.btn-primary");
    By resetPwdCodeInputField = By.cssSelector(".form-control-lg.fs-3.text-center.form-control");
    By resetPwdContinueBtn = By.cssSelector(".btn-lg.btn.btn-primary");
    public By passwordField = By.xpath("//input[@name='password']");
    By confirmPasswordField = By.xpath("//input[@name='confirmPassword']");
    By showPasswordIcon = By.cssSelector(".fal.fa-eye-slash.custom-check-off");
    By submitNewPasswordBtn = By.xpath("//button[@class='btn-lg btn btn-primary'][text()='Submit']");
    By deleteEmailBtn = By.xpath("//button[@data-action='/users/_userProfile_deleteEmail']");
    By deletePhoneBtn = By.xpath("//button[@data-action='/users/_userProfile_deletePhone']");
    By deletePhoneValidationMsg = By.xpath("//p[text()='You cannot remove the phone number from a Business account.']");
    By deleteEmailValidationMsg = By.xpath("//p[text()='You cannot remove the email address from a Business account.']");
    By closeAndDeletebtn = By.cssSelector(".btn.btn-danger");

    public Clickable getDelPhoneValidationMsg() {return Clickable.getElementBy(deletePhoneValidationMsg,"validation message showing You cannot remove the phone number from a Business account.");}

    public Clickable getDelEmailValidationMsg() {return Clickable.getElementBy(deleteEmailValidationMsg,"Validation message showing You cannot remove the email address from a Business account.");}

    public Clickable getDeleteEmailBtn() {return Clickable.getElementBy(deleteEmailBtn,"Delete Email button");}

    public Clickable getDeletePhoneBtn() {return Clickable.getElementBy(deletePhoneBtn,"Delete Phone number button");}

    public Clickable getSubmitNewPasswordBtn() {return Clickable.getElementBy(submitNewPasswordBtn,"Submit and save the new password");}

    public Clickable getShowPwdIcon() {return Clickable.getElementBy(showPasswordIcon,"Show password button");}

    public Editable getConfirmPasswordField() {return Editable.getElementBy(confirmPasswordField,"Reenter the new password");}

    public Editable getPasswordField() {return Editable.getElementBy(passwordField,"Enter the new password field");}

    public Clickable getResetPwdContinueBtn() {return Clickable.getElementBy(resetPwdContinueBtn,"Continue button to proceed to change password");}

    public Editable getRestPwdInputField() {return Editable.getElementBy(resetPwdCodeInputField,"Enter Security code in this field");}

    public Clickable getResetPwdSecCodeBtn() {return Clickable.getElementBy(resetPwdSecurityCodeBtn,"Get security code button after entering an email to receive te security code");}

    public Editable getResetPwdEMailField() {return Editable.getElementBy(resetPwdEmailFIeld,"Enter or check if te mail mentioned in the field is correct if not correct it");}

    public Clickable getResetPasswordBtn() {return Clickable.getElementBy(resetYourPassword,"Reset your password button");}

    public Clickable getSaveNewPhoneBtn() {return Clickable.getElementBy(saveNewPhoneBtn,"Save new phone number after entering OTP");}

    public Clickable getSystemAlertMessage() {return Clickable.getElementBy(systemAlertMessage,"System alert message");}

    public Clickable getUpdatePhonePopupTitle() {return Clickable.getElementBy(updatePhoneNumberPopupTitle,"Update Phone number popup title");}

    public Clickable getDiffCellPhone() {return Clickable.getElementBy(differentCellPhone,"To enter a different contact number");}

    public Editable getNewPhoneOTPField() {return Editable.getElementBy(newPhoneOTPField,"Enter otp received on New phone number");}

    public Editable getCurrentPhoneOTPField() {return Editable.getElementBy(currentPhoneOTPField,"Enter otp received on current phone number");}

    public Clickable getPopupCloseBtn() {return Clickable.getElementBy(closeNewPhonePopup,"Close new phone popup");}

    public Clickable getSecurityCodeBtn() {return Clickable.getElementBy(sendSecurityCodeForNewPhone,"Get security code");}

    public Editable getNewPhoneFIeld() {return Editable.getElementBy(newPhoneInputField,"Enter new phone number");}

    public Clickable getEditPhoneBtn() {return Clickable.getElementBy(editPhoneBtn,"Edit phone number");}

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
