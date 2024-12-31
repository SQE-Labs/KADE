package org.automation.utilities;

import org.automation.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.Set;

public class WebdriverWaits extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(WebdriverWaits.class);
    /**
     * Waits for a given element to be visible
     *
     * @param driver  WebDriver instance
     * @param locator By of the element to wait for
     */
//    public static void waitForElementVisible(By locator, int i) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), i);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }


    /**
     * Waits for a given element to be visible
     *
     //* @param driver WebDriver instance
     * @param locator The locator of the element to wait for.
     * @param waitTime element to wait for
     */
    public static void waitForElementVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
     

    public static void waitForElementInVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }


    /**
     * Waits for a given element to be selected
     * @param waitTime element to wait for
     //* @param driver  WebDriver instance
     * @param locator By of the element to wait for
     */
    public static void waitForElementSelected(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        Boolean bool = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }


    /**
     * Waits for a given element to be clickable
     * @param waitTime element to wait for
     //* @param driver  WebDriver instance
     * @param locator By to locate element to wait for
     */
    public static void waitForElementClickable(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementUntilVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        log.info("Value of locator= {}", locator);
        return e;
    }

    /**
     * Waits for the page to have a given title
     * <p>
     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
     //* @param driver WebDriver instance
     * @param title  title the page should have
     * @param waitTime The maximum time to wait for the title to appear, in seconds.
     * @return true if the page title contains the specified title within the given time; false otherwise.
     */
    public static boolean waitForPageTitle(String title, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.titleContains(title));
    }


    /**
     * Sleep script for the specified length
     * (generally not an ideal solution)
     *
     * @param length
     */
    public static void sleep(long length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            /*
             * Log.error("Sleep Interrupted"); e.printStackTrace();
             */
        }
    }

    public static void fluentWait_ElementLocated(long waitTimeForTimeout, long waitTimeForPolling, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(waitTimeForTimeout))
                .pollingEvery(Duration.ofSeconds(waitTimeForPolling))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void fluentWait_ElementIntactable(long waitTimeForTimeout, long waitTimeForPolling, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(waitTimeForTimeout))
                .pollingEvery(Duration.ofMillis(waitTimeForPolling))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void fluentWaitForDuration(long timeoutInMillis, long pollingInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(timeoutInMillis))  // Total wait time
                .pollingEvery(Duration.ofMillis(pollingInMillis)) // Polling interval
                .ignoring(Exception.class); // Ignore exceptions during polling

        // Wait until timeout is reached (dummy condition)
        wait.until(driver -> true); // A condition that always returns false, making it wait the full duration
    }

    public static void waitForElementValueToUpdate(long timeoutInMillis, long pollingInMillis, By locator, String oldValue) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(timeoutInMillis))
                .pollingEvery(Duration.ofMillis(pollingInMillis))
                .ignoring(Exception.class);


        WebElement element = wait.until(driver -> {
            WebElement ele = driver.findElement(locator);
            String currentValue = ele.getAttribute("value");

            if (!currentValue.equals(oldValue)) {
                return ele;
            } else {
                return null;
            }
        });
    }

    public static void retryClick(WebElement element, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                element.click();
                return; // Exit the loop if the click is successful
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep(1000); // Short wait before retrying
                } catch (InterruptedException ignored) {
                }
            }
        }
        throw new RuntimeException("Unable to click the element after " + maxRetries + " attempts");
    }





 
    
    public static void SwitchToNewTab() throws InterruptedException {
		String originalHandle = getDriver().getWindowHandle();
		Set<String> tabs = getDriver().getWindowHandles();

		for(String handle : tabs) {
			if (!handle.equals(originalHandle)) {
				getDriver().switchTo().window(handle);
			}
		}

		Thread.sleep(3000);
	}
}


