package org.automation.base;


import org.automation.elements.Element;
import org.automation.logger.Log;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;

public class BasePage extends ActionEngine {

    private String parentWindow;


    /**
     * Open the specified URL.
     *
     * @param url URL to open
     */
    public void openUrl(String url) {
        Log.info("Open the URL [" + url + "]");
        getDriver().get(url);
    }

    /**
     * Get the URL of the current page.
     *
     * @return page URL
     */
    public String getPageUrl() {
        Log.info("Get the Current URL");
        return getDriver().getCurrentUrl();
    }

    /**
     * Get the Title of the current page.
     *
     * @return page title
     */
    public String getPageTitle() {
        Log.info("Get the Current Page Title");
        
        return getDriver().getTitle();
    }

    /**
     * Refresh the current page.
     */
    public void refreshPage() {
        Log.info("Refresh the browser");
        getDriver().navigate().refresh();
    }

    /**
     * Get the Hash String of the specified file.
     *
     * @param file     file whose hash is needed
     * @param hashType The hash type of the file
     * @return The hash of the specified file
     */

    /**
     * Switch to the newly opened window.
     *
     * @param description description of the new window
     */
    public void switchToWindow(String description) {
        Log.info("Switch to window [" + description + "]");
        parentWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles())
            if (!windowHandle.equals(parentWindow))
                getDriver().switchTo().window(windowHandle);
    }

    /**
     * Switch to the window containing the specified URL text.
     *
     * @param description description of the new window
     * @param urlText     URL text that the window contains
     */
//    public void switchToWindowContainingUrlText(String description, String urlText) {
//        Log.info("Switch to window [" + description + "] which contains URL text [" + urlText + "]");
//        parentWindow = getDriver().getWindowHandle();
//        getDriver().getWindowHandles().stream().map(getDriver().switchTo()::window)
//                .filter(driver -> getDriver().getCurrentUrl().contains(urlText)).findFirst()
//                .orElseThrow(() -> new NoSuchWindowException(
//                        "Unable to find window [" + description + "] which contains URL text [" + urlText + "]"));
//    }

    /**
     * Switch to the window containing the specified title.
     *
     * @param description description of the new window
     * @param title       title that the window contains
     */
    public void switchToWindowContainingTitle(String description, String title) {
        Log.info("Switch to window [" + description + "] which contains title [" + title + "]");
        parentWindow = getDriver().getWindowHandle();
        getDriver().getWindowHandles().stream().map(getDriver().switchTo()::window)
                .filter(driver -> getDriver().getTitle().contains(title)).findFirst()
                .orElseThrow(() -> new NoSuchWindowException(
                        "Unable to find window [" + description + "] which contains title [" + title + "]"));
    }

    /**
     * Switch to the Main window.
     *
     * @param description description of the main window
     */
    public void switchToParentWindow(String description) {
        Log.info("Switch to parent window [" + description + "]");
        getDriver().switchTo().window(parentWindow);
    }

    /**
     * Switch to the frame containing the specified element.
     *
     * @param description description of the frame
     * @param element     element of the frame
     */
    public void switchToFrame(Element element) {
        Log.info("Switch to frame [" + element.getDescription() + "]");
        getDriver().switchTo().frame(element.getWebElement());
    }

    /**
     * Switch to the frame containing the specified name or ID.
     *
     * @param description description of the frame
     * @param nameOrId    name or ID of the frame
     */
    public void switchToFrame(String description, String nameOrId) {
        Log.info("Switch to frame [" + description + "]");
        getDriver().switchTo().frame(nameOrId);
    }

    /**
     * Switch to the frame containing the specified index number.
     *
     * @param description description of the frame
     * @param index       index number of the frame
     */
    public void switchToFrame(String description, int index) {
        Log.info("Switch to frame [" + description + "]");
        getDriver().switchTo().frame(index);
    }

    /**
     * Switch to the default window.
     *
     * @param description description of the window
     */
    public void switchToDefaultContent(String description) {
        Log.info("Switch to main window [" + description + "]");
        getDriver().switchTo().defaultContent();
    }

    public void ScrollThePage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy("+x+", "+y+")", "");
    }

    public void ScrollDownThePageMax() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);", "");
    }
//
//    public void scrollIntoView(By element) {
//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//        WebElement ele = getDriver().findElement(element);
//        jse.executeScript("arguments[0].scrollIntoView(true);", ele);
//
//    }
    
    public static void scrollToElement( By element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(element));
    }
    
    public static void scrollByPixel( int x,int y) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollTo("+x+","+y+")");
    }
    
    
    public void scrollToPageTop(By element) {
    		WebdriverWaits.waitForElementVisible(element, 5);
    	  JavascriptExecutor js = (JavascriptExecutor) getDriver();
          js.executeScript("window.scrollTo(0,0);");
    }
    
    public void goBackToPreviousPage() {
    	getDriver().navigate().back();
    }
    
    public int countWebElements(By element) {
    	return getDriver().findElements(element).size();
    }
    
}
