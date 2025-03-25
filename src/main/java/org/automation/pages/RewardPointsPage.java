package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RewardPointsPage extends BasePage {


    By rewardCard = By.cssSelector(".card.m-0.p-2.p-md-3");
    By alertMsgHours = By.xpath("//div[@class='alert-message' and text()='Reward points may take up to 24 hours to show up']");
    By storeName = By.cssSelector(".text-truncate");
    By storeNameOnCard = By.cssSelector(".ms-2.text-truncate");
    By rewardPointsOnCard = By.cssSelector(".d-flex.justify-content-center.gap-3.fs-1");
    By redeemNowLinkOnCard = By.cssSelector(".fs-pn25.mt-2.float-end");
    By storeInformationTitle = By.cssSelector(".header-title.mb-0");
    By contactInfoCard = By.cssSelector(".card-title");
    By recentTransaction = By.xpath("//h5[@class='card-header']");
    By customerSince = By.cssSelector(".fal.fa-calendar-edit.fa-fw.me-1");
    By earnedRewardPoints = By.cssSelector(".border.p-4.my-2.rounded");
    By contactNumber = By.cssSelector(".fa-2x.far.fa-phone");
    By address = By.cssSelector(".fa-2x.fal.fa-map-marker-alt");
    By url = By.cssSelector(".avatar-title.rounded-circle.bg-dark");
    By pointsTable = By.xpath("//tbody");
    By rewardPointsDetailPageTitle = By.cssSelector(".header-title.mb-0");
    By totalPointsEarned = By.cssSelector("div.card-body h1.display-5.mt-2.mb-4");
    By infoMsgOnRedeemNowLink = By.xpath("//div[text()='You will receive $1 per each ']");
    By CustomGiftCardToggleBtn = By.cssSelector(".form-check-input.mt-0.me-3");
    By claimGiftCard = By.cssSelector(".card-img-overlay");
    By pointsToRedeem = By.cssSelector(".custom-slider.w-100");
    By eligibleGiftCardAmt = By.xpath("//span[@data-field='eligibleGiftCardAmount']");

    public Clickable getEligibleGiftCardAmt() {return Clickable.getElementBy(eligibleGiftCardAmt,"eligible gift card amount");}

    public Clickable getPointsToRedeem() {return Clickable.getElementBy(pointsToRedeem,"Points to redeem slider");}

    public Clickable getClaimGiftCard() {return Clickable.getElementBy(claimGiftCard,"Claim gift card");}

    public Clickable getCustomGiftCardToggleBtn() {return Clickable.getElementBy(CustomGiftCardToggleBtn,"Toggle button on gift card button");}

    public Clickable getInfoMsgOnRedeemLink() {return Clickable.getElementBy(infoMsgOnRedeemNowLink,"Information message on redeem now page");}

    public Clickable getTotalRewardPoints() {return Clickable.getElementBy(totalPointsEarned,"Total reward points on Redeem Reward Points To Gift Card page");}

    public Clickable getRewardPointsDetailTitle() {return Clickable.getElementBy(rewardPointsDetailPageTitle,"Reward points detail page title");}

    public Clickable getPointsTable() {return Clickable.getElementBy(pointsTable,"Reward Points table details");}

    public Clickable getStoreURL() {return Clickable.getElementBy(url,"Store URL");}

    public Clickable getStoreAddress() {return Clickable.getElementBy(address,"Store Address");}

    public Clickable getContactNumber() {return Clickable.getElementBy(contactNumber,"Store Contact number");}

    public Clickable getEarnedRewardPoints() {return Clickable.getElementBy(earnedRewardPoints,"Earned Reward Points");}

    public Clickable getCustomerSince() {return Clickable.getElementBy(customerSince,"customer since information");}

    public Clickable getRecentTransaction() {return Clickable.getElementBy(recentTransaction,"Recent transaction section");}

    public Clickable getContactInfoCard() {return Clickable.getElementBy(contactInfoCard,"Contact information card title");}

    public Clickable getStoreInfoTitle() {return Clickable.getElementBy(storeInformationTitle,"Store information page title");}

    public Clickable getRedeemLinkOnCard() {return Clickable.getElementBy(redeemNowLinkOnCard,"redeem Now Link on card");}

    public Clickable getRewardPointsOnCard() {return Clickable.getElementBy(rewardPointsOnCard,"RewardPoints on Card");}

    public Clickable getStoreNameOnCard() {return Clickable.getElementBy(storeNameOnCard,"store name on card");}

    public Clickable getStoreName() {return Clickable.getElementBy(storeName,"Store name");}

    public Clickable getAlertMsgHours() {return Clickable.getElementBy(alertMsgHours,"Reward points may take up to 24 hours to show up");}

    public Clickable getRewardCard() {return Clickable.getElementBy(rewardCard,"Reward cards");}

    public void pointsToRedeemSlider() {
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(pointsToRedeem);
        actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
    }
}
