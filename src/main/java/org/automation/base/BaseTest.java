package org.automation.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.automation.listeners.TestRunListener;
import org.automation.session.KadeSession;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.Screenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.*;
import static java.io.File.separator;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;
import static org.automation.logger.Log.error;



@Listeners({ TestRunListener.class })
public class BaseTest {
	public static ExtentReports extent;
	ExtentSparkReporter extentSparkReporter;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	public static void closeDriver() {
		getDriver().close();
		getDriver().quit();
		driver.remove();
	}

	@BeforeSuite
	@Parameters({"xmlFileName"})
	public void setExtent(@Optional("testng.xml") String xmlFileName) throws InterruptedException, IOException {
		extent = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-report/Report.html");
		extentSparkReporter.config().thumbnailForBase64(true);
		extent.attachReporter(extentSparkReporter);

		// Add system info
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Executed By", System.getProperty("user.name")); // Add executor's name
		extent.setSystemInfo("TestNG XML File", xmlFileName); // Add XML file name

	}

	public void setExtent() throws InterruptedException, IOException {
		extent = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-report/Report.html");
		extentSparkReporter.config().thumbnailForBase64(true);
		extent.attachReporter(extentSparkReporter);
		extent.setSystemInfo("Environment", "QA");
	}

    @Parameters({"headless"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("false") String headlessParameter) throws MalformedURLException {
		String browser = PropertiesUtil.getPropertyValue("browser");
		String url = PropertiesUtil.getPropertyValue("url");

		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--window-size=1920,1080");
			if (Boolean.parseBoolean(headlessParameter)) {
				chromeOptions.addArguments("--headless=old");

			}
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "fireFox":
			driver.set(new FirefoxDriver());
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + browser);
		}
		// driver.set(Objects.requireNonNull(driver));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().manage().window().maximize();
		getDriver().navigate().to(url);
	}

	/**
	 * Method to execute at the end of each test method execution.
	 */

	@BeforeMethod
	public void beforeMethod(Method method) {
		Test test = method.getAnnotation(Test.class);
		extentTest.set(extent.createTest(method.getAnnotation(Test.class).description()));
		getExtentTest().assignCategory(method.getDeclaringClass().getSimpleName());
	}

	@AfterMethod
	public void tearDown(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.getScreenshot(getDriver(), result.getTestName());
			getExtentTest().addScreenCaptureFromPath(screenshotPath);
			getExtentTest().log(Status.FAIL, result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			String screenshotPath = Screenshot.getScreenshot(getDriver(), result.getName());
//			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
		}
		new KadeSession().getSidePannel().getSignOutButton().clickIfExist();
		closeDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extent.flush();
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

	public void switchToDefaultWindow(){
		getDriver().switchTo().defaultContent();
	}

}
