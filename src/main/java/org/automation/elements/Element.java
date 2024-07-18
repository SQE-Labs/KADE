package org.automation.elements;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.automation.utilities.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static java.util.stream.Collectors.joining;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class Element extends BaseTest {

    protected final String description;
    protected final By locator;
    protected final ExplicitWait wait;

    /**
     * To create a generic element.
     *
     * @param description description of the element
     * @param locator     locator of the element
     */
    public Element(String description, By locator) {
        this.description = description;
        this.locator = locator;
        wait = new ExplicitWait();
    }

    /**
     * To provide the description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * To provide the selenium web element.
     *
     * @return web element
     */
    public WebElement getWebElement() {
        Log.info("Get the [" + description + "] web element");
        return wait.until(visibilityOfElementLocated(locator));
    }

    /**
     * Get the text from the element.
     *
     * @return the text.
     */
    public String getText() {
        Log.info("Get text from [" + description + "] element");
        return wait.until(visibilityOfElementLocated(locator)).getText();
    }

    public void clear() {
        Log.info("Get text from [" + description + "] element");
        wait.until(visibilityOfElementLocated(locator)).clear();
    }

    public void click() {
        Log.debug("Clicking [" + description + "] button");
        wait.until(elementToBeClickable(locator)).click();
    }


    /**
     * Get the value of the specified attribute.
     *
     * @param attribute attribute whose value is needed
     * @return value of the attribute
     */
    public String getAttributeValue(String attribute) {
        Log.info("Get the value of the attribute [" + attribute + "] from [" + description + "] element");
        return wait.until(visibilityOfElementLocated(locator)).getAttribute(attribute);
    }

    /**
     * Get the value of the specified CSS property.
     *
     * @param property CSS property whose value is needed
     * @return value of the CSS property
     */
    public String getCssPropertyValue(String property) {
        Log.info("Get the value of the property [" + property + "] from [" + description + "] element");
        return wait.until(visibilityOfElementLocated(locator)).getCssValue(property);
    }

    /**
     * Checks whether the element is visible.
     *
     * @return true if visible, false otherwise
     */
    public boolean isVisible() {
        Log.info("Is [" + description + "] element visible");
        try {
            return wait.until(visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Checks whether the element is invisible.
     *
     * @return true if invisible, false otherwise
     */
    public boolean isInvisible() {
        Log.info("Is [" + description + "] element invisible");
        try {
            return wait.until(invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Checks whether the element is enabled.
     *
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled() {
        Log.info("Is [" + description + "] element enabled");
        try {
            return wait.until(driver -> driver.findElement(locator).isEnabled());
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Checks whether the element is disabled.
     *
     * @return true if disabled, false otherwise
     */
    public boolean isDisabled() {
        Log.info("Is [" + description + "] element disabled");
        try {
            return wait.until(driver -> !driver.findElement(locator).isEnabled());
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Move the mouse pointer to the element.
     */
    public void moveMousePointer() {
        Log.info("Move mouse to [" + description + "] element");
        WebElement element = wait.until(elementToBeClickable(locator));
        new Actions(getDriver()).moveToElement(element).perform();
    }

    /**
     * Right click on an element.
     */
    public void rightClick() {
        Log.info("Right click [" + description + "] element");
        WebElement element = wait.until(elementToBeClickable(locator));
        new Actions(getDriver()).contextClick(element).perform();
    }

    /**
     * Drag the element to the specified destination element.
     *
     * @param destination element to drop on
     */
    public void dragTo(Element destination) {
        Log.info("Drag [" + description + "] element to [" + destination.description + "] element");
        WebElement source = wait.until(elementToBeClickable(locator));
        WebElement target = wait.until(elementToBeClickable(destination.locator));
        new Actions(getDriver()).dragAndDrop(source, target).perform();
    }

    /**
     * Drag the element to the specified destination element using java script.
     *
     * @param destination element to drop on
     */
    public void dragToUsingJs(Element destination) {
        Log.info("Drag [" + description + "] element to [" + destination.description + "] element");
        WebElement source = wait.until(elementToBeClickable(locator));
        WebElement target = wait.until(elementToBeClickable(destination.locator));
        InputStream in = getClass().getResourceAsStream("/dragdrop.js");
        InputStreamReader isr = new InputStreamReader(in, Charset.defaultCharset());
        String dragDropJs = new BufferedReader(isr).lines().collect(joining("\n"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(dragDropJs, source, target);
    }

}
