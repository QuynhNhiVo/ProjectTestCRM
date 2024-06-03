package common;


import contants.ConfigData;
import drivers.DriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import utils.LogUtils;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser){
        WebDriver driver = setupBrowser(browser);
        DriverManager.setDriver(driver);
    }

    private WebDriver setupBrowser(String browser){
        WebDriver driver;
        switch (browser.trim().toLowerCase()){
            case "chrome":
                driver = initChromeDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            default:
                driver = initChromeDriver();
                LogUtils.info("Launching Chrome as browser of choice...");
        }
        return driver;
    }

    private WebDriver initChromeDriver(){
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        if(ConfigData.HEADLESS.equals("true")){
            LogUtils.info("Launching Chrome browser (Headless)...");
            chromeOptions.addArguments("--headless");
        }else {
            LogUtils.info("Launching Chrome browser...");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver(){
        WebDriver driver;
        EdgeOptions edgeOptions = new EdgeOptions();
        if(ConfigData.HEADLESS.equals("true")){
            LogUtils.info("Launching Chrome browser (Headless)...");
            edgeOptions.addArguments("--headless");
        }else {
            LogUtils.info("Launching Chrome browser...");
        }
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver(){
        WebDriver driver;
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(ConfigData.HEADLESS.equals("true")){
            LogUtils.info("Launching Chrome browser (Headless)...");
            firefoxOptions.addArguments("--headless");
        }else {
            LogUtils.info("Launching Chrome browser...");
        }
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser(){
        DriverManager.quit();
    }
}
