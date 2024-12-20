package org.automation.utilities;

import org.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

//import static org.automation.base.BaseTest.driver;
import static org.automation.base.BaseTest.getDriver;

public class WebdriverWaits extends BaseTest {
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
//     * @param driver WebDriver instance
//     * @param e      element to wait for
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
     *
//     * @param driver  WebDriver instance
     * @param locator By of the element to wait for
     */
    public static void waitForElementSelected(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        Boolean bool = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }


    /**
     * Waits for a given element to be clickable
     *
//     * @param driver  WebDriver instance
     * @param locator By to locate element to wait for
     */
    public static void waitForElementClickable(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementUntilVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("Value of locator= "+locator);
        return e;
    }

    /**
     * Waits for the page to have a given title
     * <p>
     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
//     * @param driver WebDriver instance
     * @param title  title the page should have
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
        Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(waitTimeForTimeout))
                .pollingEvery(Duration.ofMillis(waitTimeForPolling))
                .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

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

    public static void retryClick(By locator, int retryCount) {
        int waitTime = 5;
        if (retryCount <= 0) {
            throw new IllegalArgumentException("Retry count must be greater than 0");
        }

        int attempts = 0;
        boolean isClicked = false;

        while (attempts < retryCount && !isClicked) {
            try {
                /* Wait until the element is clickable */

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

                // Attempt to click the element
                element.click();
                isClicked = true;
                System.out.println("Click successful on attempt " + (attempts + 1));
            } catch (Exception e) {
                attempts++;
                if (attempts < retryCount) {
                    System.out.println("Click attempt " + attempts + " failed. Retrying...");
                } else {
                    System.out.println("Click failed after " + attempts + " attempts. Locator: " + locator.toString());
                    throw e; // Rethrow exception after all retries fail
                }

                // Add a delay before retrying
                try {
                    Thread.sleep(1000 * attempts); // Incremental delay (e.g., 1s, 2s, 3s...)
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();

                }
            }
        }
    }

}
