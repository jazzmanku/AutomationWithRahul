package framework;

import framework.helper.OptionsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static framework.Constants.*;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    @Parameters({"browserType", "headless", "incognito"})
    public void setupTest(@Optional("CH") String browserType,
                          @Optional("true") boolean headless,
                          @Optional("true") boolean incognito) {
        if (browserType != "")
            driver = setup(browserType, APP_URL_2, headless, incognito);
        else
            driver = setup(CHROME_BROWSER, APP_URL_2, headless, incognito);
        driver.get(APP_URL_2);
    }

    @AfterMethod
    public void stopTesting() throws InterruptedException {
        tearDown(driver);
    }

    public WebDriver setup(String browserType) {
        // String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        switch (browserType) {
            case "CH":
                driver = new ChromeDriver();
                break;
            case "FF":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMP_WAIT_TIMEOUT_IN_SEC));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_IN_SEC));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT_IN_SEC));
        return driver;
    }
    public WebDriver setup(String browserType, String url) {
        switch (browserType) {
            case "CH":
                driver = new ChromeDriver(OptionsManager.getChromeOptions(false,false));
                break;
            case "FF":
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;
            case "ED":
                driver = new EdgeDriver(OptionsManager.getEdgeOptions());
                break;
            case "SF":
                driver = new SafariDriver(OptionsManager.getSafariOptions());
                break;
            default:
                driver = new ChromeDriver(OptionsManager.getChromeOptions(false,false));
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMP_WAIT_TIMEOUT_IN_SEC));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_IN_SEC));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT_IN_SEC));
        driver.get(url);
        return driver;
    }

    public WebDriver setup(String browserType, String url, boolean headless, boolean incognito) {
        switch (browserType) {
            case "CH":
                driver = new ChromeDriver(OptionsManager.getChromeOptions(headless,incognito));
                break;
            case "FF":
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;
            case "ED":
                driver = new EdgeDriver(OptionsManager.getEdgeOptions());
                break;
            case "SF":
                driver = new SafariDriver(OptionsManager.getSafariOptions());
                break;
            default:
                driver = new ChromeDriver(OptionsManager.getChromeOptions(headless,incognito));
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMP_WAIT_TIMEOUT_IN_SEC));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_IN_SEC));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT_IN_SEC));
        driver.get(url);
        return driver;
    }
    public void tearDown(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
