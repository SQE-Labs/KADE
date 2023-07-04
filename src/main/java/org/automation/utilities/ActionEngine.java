package org.automation.utilities;

import org.automation.base.BaseTest;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.automation.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ActionEngine extends BaseTest {

	public void selectFirst(By element) {
		getDriver().findElements(element).get(0).click();
		
	}
	
    public void click(By path, String... label) {
        String var = "";
        try {

            var = label.length > 0 ? label[0] : path.toString();

            Element btn = new Element(var, path);
            btn.click();
            Log.info("Clicked on " + var);
            //log success message in exgent report
            extentTest.log(PASS, "==> Clicked element Successfully! " + var);
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click on => " + var + " due to exception " + e);

        }

    }

    public void click(WebElement element, String... label) {
        try {
            element.click();
            extentTest.log(PASS, "==> Clicked element Successfully! " + label);
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click  " + label + " due to exception " + e);
        }
    }

    public void sendKeys(By path, String valueToBeSent, String... label) {
        String var = "";
        try {
            var = label.length > 0 ? label[0] : path.toString();
            Element element = new Element(var, path);
            element.getWebElement().sendKeys(valueToBeSent);
            //log success message in extent report
            extentTest.log(PASS, "Entered value  in field " + var + "as: " + valueToBeSent);
        } catch (Exception e) {
            //log failure in extent
            extentTest.log(FAIL, "Sendkeys in field: " + var + " is failed due to exception:        " + e);
            throw new RuntimeException(e);
        }
    }
    
    
    public void sendKeys_withClear(By path, String valueToBeSent, String... label) {

        String var = "";
        try {
            var = label.length > 0 ? label[0] : path.toString();
            Element element = new Element(var, path);
            element.clear();
            element.getWebElement().sendKeys(valueToBeSent);
            //log success message in extent report
            extentTest.log(PASS, "Entered value  in field " + var + "as: " + valueToBeSent);
        } catch (Exception e) {
            //  log failure in extent
            extentTest.log(FAIL, "Sendkeys in field: " + var + " is failed due to exception:     " + e);
            throw new RuntimeException(e);

        }
    }


    //custom click method to log evey click action in to extent report
    public void clickBtn(By path, String... label) {
        String var = "";
        try {
            var = label.length > 0 ? label[0] : path.toString();

            Button btn = new Button(var, path);
            btn.click();
            //log success message in exgent report
            extentTest.log(PASS, "Clicked Successfully! " + var);
        } catch (Exception e) {
            //log failure in extent
            extentTest.log(FAIL, "Unable to click on field: " + var + " due to exception: \n " + e);
            throw new RuntimeException(e);

        }

    }


    //clear data from field
    public void clear_custom(By element) {
        try {
        	Element e=new Element(null, element);
           e.clear();
            Thread.sleep(250);
            extentTest.log(PASS, "Data Cleared Successfully!");
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to clear Data on field:  due to exception: " + e);
            throw new RuntimeException(e);

        }
    }

    //custom mouseHover
    public void moveToElement_custom(By element, String fieldName) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(element)).build().perform();
            extentTest.log(PASS, fieldName + "==> Mouse hovered Successfully! ");
            Thread.sleep(1000);
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to hover mouse on field: " + fieldName + " due to exception: " + e);
            throw new RuntimeException(e);
        }
    }
    
    public void moveToWebElement(By element) {
    	Actions a=new Actions(getDriver());
    	a.moveToElement(getDriver().findElement(element)).perform();;
    }

    public String getElementText(By element) {
    	return getDriver().findElement(element).getText();
    }

    //check if element is Present
    public boolean isElementPresent_custom(By element, String fieldName) {
        boolean flag = false;
        try {
            flag = getDriver().findElement(element).isDisplayed();
            extentTest.log(PASS, "==> Is  " + fieldName + " element present => " + flag);
            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "Checking for presence of field: " + fieldName + " not tested due to exception: " + e);
            return flag;

        }
    }
    //check if element is Present
   

    //Select dropdown value value by visibleText
    public void selectDropDownByVisibleText_custom(By path, String ddVisibleText, String... fieldName) {

        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByVisibleText(ddVisibleText);
            extentTest.log(PASS, var + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
        } catch (Exception e) {
            extentTest.log(FAIL, "Dropdown value not selected for field: " + var + "  due to exception: " + e);
            throw new RuntimeException(e);

        }
    }

    //Select dropdown value value by value
    public void selectDropDownByValue_custom(By path, String ddValue, String... fieldName) {
        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByValue(ddValue);
            extentTest.log(PASS, var + "==> Dropdown Value Selected by visible text: " + ddValue);
        } catch (Exception e) {
            extentTest.log(FAIL, "Dropdown value not selected for field: " + var + "  due to exception: " + e);
            throw new RuntimeException(e);
        }
    }

    //Select dropdown list by index
    public void selectDropDownByIndex_custom(By path, int index, String... fieldName) {
        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByIndex(index);
            extentTest.log(PASS, var + "==> Dropdown Value Selected by index : " + index);
        } catch (Exception e) {
            extentTest.log(FAIL, "Dropdown value not selected for field: " + var + "  due to exception: " + e);
            throw new RuntimeException(e);

        }
    }

    //Get text from webelement
    public String getText_custom(By path) {
        String text = "";
        try {

            Element element = new Element("", path);
            text = element.getText();
            Log.info("Text for " + path + " is " + text);
            extentTest.log(PASS, "Text retrieved is: " + text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to get text due to exception : \n" + e);

        }
        return text;
    }


    public void selectCheckBox(By path, String... fieldName) {
        try {
            String var = fieldName.length > 0 ? fieldName[0] : path.toString();
            CheckBox checkBox = new CheckBox(var, path);

            checkBox.check();
            extentTest.log(PASS, "Check box selected");

        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to get text due to exception : \n" + e);

        }
    }

    public void uncheckCheckBox(By path, String... fieldName) {
        String var = fieldName.length > 0 ? fieldName[0] : path.toString();
        CheckBox checkBox = new CheckBox(var, path);
        checkBox.uncheck();
    }

    public boolean getCheckBoxValue(By path, String... fieldName) {
        String var = fieldName.length > 0 ? fieldName[0] : path.toString();
        CheckBox checkBox = new CheckBox(var, path);
        return checkBox.isChecked();
    }
    public String getAttributevalue(By path ,String attribute) {
        String value ;
        try {
            Element element = new Element("fieldName", path);
            value = element.getAttributeValue(attribute);
            return value;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean isElementPresent(By path,String fieldName) {
        boolean flag = false;
        try {
            Element element = new Element(fieldName, path);
            flag = element.isVisible();
               return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "****Checking for presence of element : " + fieldName + " not tested due to exception: " + e);
            return flag;
        }
    }
    public boolean isExceptionOrErrorPresent() {
        boolean flag = false;
        By exception= By.xpath("(//*[contains( text(),'Exception')])[2]");
          By error= By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

        try {
            Element exceptionEle = new Element("fieldName", exception);
              Element errorEle = new Element("fieldName", error);
            flag= exceptionEle.isVisible() ;
             Log.debug( " Exception or Error  is present -->" + flag);

            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "Error or Exception Presence" + " : " + flag);
            return flag;
        }
    }
    
    public String getAttribute(By element,String attribute) {
    	return getDriver().findElement(element).getAttribute(attribute);
    }
    
    public boolean isExceptionOrErrorPresent(int exceptionTextCount) {
        boolean flag = false;
        By exception= By.xpath("(//*[contains( text(),'Exception')])["+exceptionTextCount+"]");
        By error= By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

        try {
            Element exceptionEle = new Element("fieldName", exception);
            Element errorEle = new Element("fieldName", error);
            flag= exceptionEle.isVisible() || errorEle.isVisible();
             Log.debug( " Exception or Error  is present -->" + flag);

            return flag;
        } catch (Exception e) {

            return flag;
        }
    }
    
    public void uploadImageFile	(String location) throws AWTException {
    	
    	Robot rb = new Robot();
    	rb.setAutoDelay(1000);
    	 // copying File path to Clipboard
        StringSelection str = new StringSelection(location);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
     
         // press Contol+V for pasting
         rb.keyPress(KeyEvent.VK_CONTROL);
         rb.keyPress(KeyEvent.VK_V);
     
        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
     
        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
}
