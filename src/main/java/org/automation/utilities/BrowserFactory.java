package org.automation.utilities;


public class BrowserFactory {

    //create webdriver object for given browser
//    public ThreadLocal<WebDriver> createBrowserInstance(String browser) throws MalformedURLException {
//
//        //	WebDriver driver = null;
//         ThreadLocal<WebDriver> driver = null;
//
//         switch (browser) {
//         case "chrome":
//             WebDriverManager.chromedriver().setup();
//            // driver = new ChromeDriver(BrowserOptions.getChromeOptions());
//             ((ThreadLocal<WebDriver>) driver).set(new ChromeDriver());
//             break;
//
//         case "fireFox":
//            // WebDriverManager.firefoxdriver().setup();
//             //driver = new FirefoxDriver(BrowserOptions.getFirefoxOptions());
//             break;
//         default:
//             throw new IllegalStateException("Unexpected value: " + browser);
//     }
//    // driver.set(Objects.requireNonNull(driver));
//     prepareBrowser();
//
//        return driver;
//    }
//private static void prepareBrowser(){
//    getDriver().manage().window().maximize();
//    getDriver().manage().deleteAllCookies();
//    getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//    getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//}
//public static WebDriver getDriver(){
//    return Objects.requireNonNull(driver.get());
//}
//public static void closeBrowser() {
//    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    getDriver().close();
//    getDriver().quit();
//}
}
