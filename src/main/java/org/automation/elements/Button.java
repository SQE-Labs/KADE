package org.automation.elements;

import org.automation.base.BasePage;
import org.automation.logger.Log;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public final class Button extends Element {

    /**
     * This Constructor is used to create an object to access a <b>Button</b>.
     *
     * @param description description of the Button
     * @param locator     locator of the Button
     */
    public Button(String description, By path) {
        super(description, path);
    }

    /**
     * Click on the button.
     */
    public void click() {
        Log.info("Click [" + description + "] button");
        wait.until(elementToBeClickable(locator)).click();
    }

    /**
     * Click on the button.
     *
     * @param <T>       the type of the page class
     * @param pageClass expected class of the page after the click
     * @return the pageClass object
     */
    public <T extends BasePage> T click(Class<T> pageClass) {
        Log.info("Click [" + description + "] button");
        try {
            wait.until(elementToBeClickable(locator)).click();
            return pageClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            Log.error("Unable to create instance of the page class", e);
            throw new RuntimeException("Unable to create instance of the page class", e);
        }
    }

}
