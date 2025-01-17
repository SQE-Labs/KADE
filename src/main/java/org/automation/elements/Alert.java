package org.automation.elements;

import org.automation.logger.Log;
import org.automation.utilities.ExplicitWait;
import org.openqa.selenium.TimeoutException;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


public final class Alert {

    private final String description;
    private final ExplicitWait wait;

    /**
     * This Constructor is used to create an object to access an <b>Alert</b>.
     *
     * @param description description of the Alert
     */
    public Alert(String description) {
        wait = new ExplicitWait();
        this.description = description;
    }

    /**
     * Get the text present in an alert.
     *
     * @return the text
     */
    public String getText() {
        Log.info("Get the text from the [" + description + "] alert");
        return wait.until(alertIsPresent()).getText();
    }


}
