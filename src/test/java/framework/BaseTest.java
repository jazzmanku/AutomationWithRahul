package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static framework.Constants.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browserType")
    public void setupTest(@Optional("CH") String browserType) {
        if (browserType != "")
            driver = setup(browserType, APP_URL_2);
        else
            driver = setup(CHROME_BROWSER, APP_URL_2);
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
        driver.get(url);
        return driver;
    }
    public void tearDown(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
