package org.automation.pages;

import org.automation.ReturnObjects.Clickable;
import org.automation.ReturnObjects.Editable;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class RewardPointsPage extends BasePage {

    //Locators
    By RewardPointsLabel = By.cssSelector(".mb-0");
    By RewardPointsMessage = By.xpath("(//div[@class='container-fluid ']/div/div)[2]");
    By NoRewardPointsMessage = By.xpath("//div[@class='card']/div/p");
    By ClickPaymentHistory = By.xpath("//div[contains(@class, 'text-nowrap') and contains(text(), 'Payment History')]");
    By ClickRewardPoints = By.xpath("//div[contains(@class, 'text-nowrap') and contains(text(), 'Reward Points')]");

    By ClickPayHistoryTransaction = By.xpath("(//span[contains(@class, 'ms-2 text-truncate') and contains(text(), 'Automation Payment History')])[1]");
    By DateAndTime = By.xpath("//span[@class='fs-pn25']");
    By ClickOnPoints = By.xpath("(//div[@class='d-flex justify-content-center gap-3 fs-1']/a/span)[1]");

    public Editable getRewardPointsLabel() { return Editable.getElementBy(RewardPointsLabel, "Reaward Points Label"); }
    public Editable getRewardPointsMessage() { return  Editable.getElementBy(RewardPointsMessage, "Reward Points Message"); }
    public Editable getNoRewardPointsMessage() { return  Editable.getElementBy(NoRewardPointsMessage, "No Reward Points Message"); }
    public Clickable getClickPaymentHistory() { return Clickable.getElementBy(ClickPaymentHistory, "Click Payment History"); }
    public Clickable getClickPayHistoryTransaction() { return Clickable.getElementBy(ClickPayHistoryTransaction, "Click Payment History"); }
    public Editable getDateAndTime() { return Editable.getElementBy(DateAndTime, "Date and Time"); }
    public Clickable getClickRewardPoints() { return Clickable.getElementBy(ClickRewardPoints, "Click Reward Points"); }
    public Clickable getClickOnPoints() { return Clickable.getElementBy(ClickOnPoints, "Click On Points"); }
    public void hourdifference()
    {
        try {
            // Extract the date string from the UI
            String extractedDate = getDateAndTime().getText().trim();
            //System.out.println("Extracted Date from UI: [" + extractedDate + "]");

            // Define the formatter for parsing the extracted date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.ENGLISH);

            // Parse the extracted date into LocalDateTime
            LocalDateTime givenDate = LocalDateTime.parse(extractedDate, formatter);
            //System.out.println("Parsed Given Date: " + givenDate);

            // Get the current date and time
            LocalDateTime currentDate = LocalDateTime.now();
            //System.out.println("Current Date: " + currentDate);

            // Compare the difference in full days using ChronoUnit
            long daysDifference = ChronoUnit.DAYS.between(givenDate.toLocalDate(), currentDate.toLocalDate());
            //System.out.println("Days Difference: " + daysDifference);

            // Validate if 24 or more hours have passed
            if (daysDifference > 0 ||
                    (daysDifference == 0 && Duration.between(givenDate, currentDate).toHours() >= 24)) {
                System.out.println("Test Passed: 24 or more hours have passed.");
            } else {
                System.out.println("Test Failed: Less than 24 hours have passed.");
            }
        } catch (Exception e) {
            // Handle errors gracefully
            System.out.println("Error during test execution: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
