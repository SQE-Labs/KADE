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
import org.openqa.selenium.support.ui.Select;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;

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
			// log success message in exgent report
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
			// log success message in extent report
			extentTest.log(PASS, "Entered value  in field " + var + "as: " + valueToBeSent);
		} catch (Exception e) {
			// log failure in extent
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
			// log success message in extent report
			extentTest.log(PASS, "Entered value  in field " + var + "as: " + valueToBeSent);
		} catch (Exception e) {
			// log failure in extent
			extentTest.log(FAIL, "Sendkeys in field: " + var + " is failed due to exception:     " + e);
			throw new RuntimeException(e);

		}
	}

	public void sendkeysClear(By element, String string) {
		getDriver().findElement(element).clear();
		getDriver().findElement(element).sendKeys(string);
	}

	// custom click method to log evey click action in to extent report
	public void clickBtn(By path, String... label) {
		String var = "";
		try {
			var = label.length > 0 ? label[0] : path.toString();

			Button btn = new Button(var, path);
			btn.click();
			// log success message in exgent report
			extentTest.log(PASS, "Clicked Successfully! " + var);
		} catch (Exception e) {
			// log failure in extent
			extentTest.log(FAIL, "Unable to click on field: " + var + " due to exception: \n " + e);
			throw new RuntimeException(e);

		}

	}

	// clear data from field
	public void clear_custom(By element) {
		try {
			Element e = new Element(null, element);
			e.clear();
			Thread.sleep(250);
			extentTest.log(PASS, "Data Cleared Successfully!");
		} catch (Exception e) {
			extentTest.log(FAIL, "Unable to clear Data on field:  due to exception: " + e);
			throw new RuntimeException(e);

		}
	}

	// custom mouseHover
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
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(element)).build().perform();
	}

	public String getElementText(By element) {
		return getDriver().findElement(element).getText();
	}

	// check if element is Present
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
	// check if element is Present

	// Select dropdown value value by visibleText
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

	// Select dropdown value value by value
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

	// Select dropdown list by index
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

	// Get text from webelement
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

	// Get text from webelement
	public <List> String getText_List(By path) {
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

	public long getAllMatchingCount(By element, String string) {
		List<WebElement> allElements = getDriver().findElements(element);
		return allElements.stream().map(a -> a.getText().equalsIgnoreCase(string)).count();
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

	public String getAttributevalue(By path, String attribute) {
		String value;
		try {
			Element element = new Element("fieldName", path);
			value = element.getAttributeValue(attribute);
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isElementPresent(By path, String fieldName) {
		boolean flag = false;
		try {
			Element element = new Element(fieldName, path);
			flag = element.isVisible();
			return flag;
		} catch (Exception e) {
			extentTest.log(FAIL,
					"****Checking for presence of element : " + fieldName + " not tested due to exception: " + e);
			return flag;
		}

	}

	public boolean isExceptionOrErrorPresent() {
		boolean flag = false;
		By exception = By.xpath("(//*[contains( text(),'Exception')])[2]");
		By error = By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

		try {
			Element exceptionEle = new Element("fieldName", exception);
			Element errorEle = new Element("fieldName", error);
			flag = exceptionEle.isVisible();
			Log.debug(" Exception or Error  is present -->" + flag);

			return flag;
		} catch (Exception e) {
			extentTest.log(FAIL, "Error or Exception Presence" + " : " + flag);
			return flag;
		}
	}

	// get attribute value
	public String getAttribute(By element, String attribute) {
		return getDriver().findElement(element).getAttribute(attribute);
	}

	// get The tag of element
	public String getTag(By element) {
		return getDriver().findElement(element).getTagName();
	}

	public boolean isExceptionOrErrorPresent(int exceptionTextCount) {
		boolean flag = false;
		By exception = By.xpath("(//*[contains( text(),'Exception')])[" + exceptionTextCount + "]");
		By error = By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

		try {
			Element exceptionEle = new Element("fieldName", exception);
			Element errorEle = new Element("fieldName", error);
			flag = exceptionEle.isVisible() || errorEle.isVisible();
			Log.debug(" Exception or Error  is present -->" + flag);

			return flag;
		} catch (Exception e) {

			return flag;
		}
	}

	// Method to upload a file from local driver
	public void uploadImageFile(String location) throws AWTException {
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

	// code to execute javaScript code
	public void sendKeysUsingJavaScript(By element, String jsScript) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(jsScript, getDriver().findElement(element));
	}

	// code to check element is enabled
	public boolean isElementEnabled(By element) {
		return getDriver().findElement(element).isEnabled();
	}

	// click on element with text
	public void clickOnElementByText(By element, String text) {
		List<WebElement> allElements = getDriver().findElements(element);
		for (WebElement we : allElements) {
			if (we.getText().equalsIgnoreCase(text))
				WebdriverWaits.waitForElementClickable(element, 5);
			click(we);
			break;
		}
	}

	// method to click on first element from list of Web Elements
	public void clickOnFirstElement(By element) {
		getDriver().findElements(element).get(0).click();
	}

	// This method will getText from element and compare to string passed in parameter.
	public boolean areAllELementTextMatches(By element, String text) {
		return getDriver().findElements(element).stream().allMatch(status -> status.getText().equalsIgnoreCase(text));
	}

	// Method to get the default selected option of a dropdown
	public String getSelectedOptionOfDropdown(By element) {
		Select s = new Select(getDriver().findElement(element));
		return s.getFirstSelectedOption().getText();
	}

	// Method to get all the options of a dropdown menu
	public List<String> getAllOptionsOfDropDown(By element) {
		Select s = new Select(getDriver().findElement(element));
		return s.getOptions().stream().map(option -> option.getText()).collect(Collectors.toList());
	}

	// Method to select a option of dropdown by option text
	public void selectByText(By element, String string) {
		Select s = new Select(getDriver().findElement(element));
		s.selectByVisibleText(string);
	}

	// This method returns the list of text of webELements
	public List<String> getListOfString(By element) {
		return getDriver().findElements(element).stream().map(m -> m.getText()).collect(Collectors.toList());
	}

	// This method hovers mouse to web Element and gets the tooltip message appears on the tooltip
	public String getToolTipMessage(By element) {
		moveToWebElement(element);
		String toolTipId = getAttribute(element, "aria-describedby");
		By toolTipMessage = By.id(toolTipId);
		return getElementText(toolTipMessage);
	}

	// Method to get list of web elements
	public List<WebElement> getListOfWebElements(By element) {
		return getDriver().findElements(element);
	}

}
