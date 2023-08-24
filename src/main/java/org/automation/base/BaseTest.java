package org.automation.base;

//import com.codoid.products.exception.FilloException;
//import com.codoid.products.fillo.Connection;
//import com.codoid.products.fillo.Fillo;
//import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.listeners.TestReporter;
import org.automation.listeners.TestRunListener;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;
import static org.automation.logger.Log.error;

@Listeners({ TestRunListener.class, TestReporter.class })
public class BaseTest {

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		getDriver().close();
		driver.remove();
	}

	@BeforeSuite
	public void setExtent() throws InterruptedException, IOException {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-report/ExtentReportResult.html", true);
		extent.addSystemInfo("Environment", "QA");
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws MalformedURLException {
		String browser = PropertiesUtil.getPropertyValue("browser");
		String url = PropertiesUtil.getPropertyValue("url");

		switch (browser) {
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
//			//driver = new ChromeDriver(BrowserOptions.getChromeOptions());
			driver.set(new ChromeDriver());
			break;

		case "fireFox":
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(BrowserOptions.getFirefoxOptions());
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + browser);
		}
		// driver.set(Objects.requireNonNull(driver));
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().navigate().to(url);
	}

	/**
	 * Method to execute at the end of each test method execution.
	 */

	@BeforeMethod
	public void beforeMethod(Method method) {
		Test test = method.getAnnotation(Test.class);
		extentTest = extent.startTest(method.getName());
		extentTest.setDescription(test.description());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.getScreenshot(getDriver(), result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String screenshotPath = Screenshot.getScreenshot(getDriver(), result.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));

		}
		extent.endTest(extentTest);
		extent.flush();
	}

	/**
	 * Method to execute at the end of the suite execution
	 */
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
	}

	/**
	 * Data Provider method to get data from Excel file.
	 *
	 * @param method test method executed
	 * @return excel data
	 */
	@DataProvider(name = "ExcelDataProvider")
	public Iterator<Object[]> provideData(Method method) {
		List<Object[]> excelData = new ArrayList<Object[]>();
		String pathName = "src" + separator + "test" + separator + "resources" + separator + "ExcelData.xlsx";
//		Connection con = null;
//		Recordset record = null;
//		try {
//			Fillo fillo = new Fillo();
//			con = fillo.getConnection(pathName);
//			record = con.executeQuery("Select * from TestData where TestCase = '"
//					+ method.getDeclaringClass().getSimpleName() + "." + method.getName() + "'");
//			while (record.next()) {
//				Map<String, String> data = new HashMap<String, String>();
//				for (String field : record.getFieldNames()) {
//					if (!record.getField(field).isEmpty()) {
//						data.put(field, record.getField(field));
//					}
//				}
//				excelData.add(new Object[] { data });
//			}
//		} catch (FilloException e) {
//			error("Unable to get data from Excel", e);
//			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
//		} finally {
//			con.close();
//			record.close();
//		}
		return excelData.iterator();
	}

	/**
	 * Data Provider method to get data from CSV file.
	 *
	 * @param method test method executed
	 * @return CSV data
	 */
	@DataProvider(name = "CsvDataProvider")
	public Iterator<Object[]> getCsvData(Method method) {
		List<Object[]> csvData = new ArrayList<Object[]>();
		String csvRegex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
		String pathName = "src" + separator + "test" + separator + "resources" + separator + "CsvData.csv";
		try {
			String[] keys = lines(get(pathName)).findFirst().orElseThrow(IOException::new).split(csvRegex);
			List<String[]> dataLines = lines(get(pathName)).filter(
					line -> line.startsWith(method.getDeclaringClass().getSimpleName() + "." + method.getName()))
					.map(line -> line.split(csvRegex)).collect(toList());
			for (String[] values : dataLines) {
				Map<String, String> data = new HashMap<String, String>();
				for (int i = 1; i < keys.length; i++) {
					if (!values[i].isEmpty()) {
						data.put(keys[i], values[i]);
					}
				}
				csvData.add(new Object[] { data });
			}
		} catch (IOException e) {
			error("Unable to get data from Csv", e);
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		}
		return csvData.iterator();
	}

}
