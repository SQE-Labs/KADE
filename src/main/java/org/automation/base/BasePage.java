package org.automation.base;


import org.automation.elements.Element;
import org.automation.logger.Log;
import org.automation.session.KadeSession;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;

public class BasePage extends ActionEngine {
    KadeSession session;
    public BasePage(KadeSession session){
        this.session = session;
    }

    public BasePage(){
    }

    public KadeSession getSession(){
        return this.session;
    }

    private String parentWindow;






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
    public void navigateBack() {
        Log.info("navigate to the previous page of the browser");
        getDriver().navigate().back();
    }

    public void switchToWindow(String description) {
        Log.info("Switch to window [" + description + "]");
        parentWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles())
            if (!windowHandle.equals(parentWindow))
                getDriver().switchTo().window(windowHandle);
    }


    public void switchToFrame(By element) {
//        Log.info("Switch to frame [" + element.getDescription() + "]");
        getDriver().switchTo().frame(getDriver().findElement(element));
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

    public boolean isWebElementVisible(By element){
        return getDriver().findElement(element).isDisplayed();
    }
}
