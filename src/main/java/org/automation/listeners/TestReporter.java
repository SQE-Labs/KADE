package org.automation.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.automation.logger.Log;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

import static com.aventstack.extentreports.Status.*;
import static com.aventstack.extentreports.reporter.configuration.Theme.STANDARD;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.util.stream.Collectors.joining;


public final class TestReporter implements IReporter {

    private final Optional<String> browser = Optional.ofNullable(System.getProperty("browser"));
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch").toUpperCase();
    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        this.init(xmlSuites);
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();
            for (ISuiteResult result : results.values()) {
                ITestContext context = result.getTestContext();
                buildTestNodes(context.getFailedTests(), FAIL);
                buildTestNodes(context.getSkippedTests(), SKIP);
                buildTestNodes(context.getPassedTests(), PASS);
            }
        }
        Reporter.getOutput().forEach(extent::setTestRunnerOutput);
        extent.flush();
    }

    /**
     * To initialize all the report's elements.
     *
     * @param xmlSuites all the executed suites
     */
    private void init(List<XmlSuite> xmlSuites) {
        String suiteName = xmlSuites.get(0).getName();
        Path report = Paths.get(System.getProperty("user.dir"), "extent-reports",
                "Extent Report_" + System.currentTimeMillis() + "_" + suiteName + ".html");
        if (Files.notExists(report.getParent(), NOFOLLOW_LINKS)) {
            try {
                Files.createDirectory(report.getParent());
            } catch (IOException e) {
                System.err.println("Unable to create path: " + report.getParent());
                e.printStackTrace();
            }
        }
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(report.toString());
        htmlReporter.config().setDocumentTitle("ExtentReports: " + suiteName);
        htmlReporter.config().setReportName(suiteName);
        htmlReporter.config().setTheme(STANDARD);
        htmlReporter.config().setEncoding("UTF-8");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setSystemInfo("Operating System", operatingSystem);
        extent.setSystemInfo("System Architecture", systemArchitecture);
        extent.setSystemInfo("Browser Selection", browser.orElse("chrome").toUpperCase());
    }

    /**
     * Build the report for all the tests executed.
     *
     * @param tests  all the tests executed
     * @param status status of the test executed
     */
    private void buildTestNodes(IResultMap tests, Status status) {
        SortedSet<ITestResult> results = new TreeSet<ITestResult>();
        tests.getAllResults().forEach(results::add);
        if (tests.size() > 0) {
            for (ITestResult result : results) {
                ExtentTest test = extent
                        .createTest(result.getTestContext().getCurrentXmlTest().getName() + " - " + result.getName());
                test.assignCategory(result.getMethod().getRealClass().getSimpleName());
                Throwable throwable = result.getThrowable();
                Object[] parameters = result.getParameters();
                if (parameters.length > 0) {
                    String params = Arrays.stream(parameters).map(Object::toString).collect(joining(", "));
                    test.info(params);
                }
                Reporter.getOutput(result).forEach(test::info);
                test.log(status, "Test [" + result.getName() + "] " + status.toString() + "ed");
                if (throwable != null) {
                    try {
                        String base64String = result.getAttribute("failureScreenshot").toString();
                        MediaEntityModelProvider provider = MediaEntityBuilder
                                .createScreenCaptureFromBase64String(base64String).build();
                        test.log(status, throwable, provider);
                    } catch (IOException e) {
                        Log.error("Unable to add screenshot to extent report", e);
                    }
                }
                test.getModel().setStartTime(this.getTime(result.getStartMillis()));
                test.getModel().setEndTime(this.getTime(result.getEndMillis()));
            }
        }
    }

    /**
     * Get the date and time from the epoch milliseconds provided.
     *
     * @param millis epoch milliseconds
     * @return the data and time
     */
    private Date getTime(long millis) {
        return Date.from(Instant.ofEpochMilli(millis));
    }

}
