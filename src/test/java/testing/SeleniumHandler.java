package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Level;

public class SeleniumHandler {
    private static final String PROPERTY_DRIVER_CHROME = "webdriver.chrome.driver";
    private static final String PATH_DRIVER_CHROME = "./driver/chromedriver";
    private static final String PROPERTY_DRIVER_FIREFOX = "webdriver.gecko.driver";
    private static final String PATH_DRIVER_FIREFOX = "./driver/geckodriver";

    static WebDriver driver = null;

    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //new in Selenenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    public static WebDriver getDriver(String browser, boolean isHeadless, boolean isIncognito) {
        WebDriver driver = null;
        switch (browser) {
            case "CH":
                System.setProperty(PROPERTY_DRIVER_CHROME, PATH_DRIVER_CHROME);
                System.setProperty("webdriver.chrome.logfile", "./logs/chromedriver.log");
                System.setProperty("webdriver.chrome.verboseLogging", "true");

                ChromeOptions chromeOptions = new ChromeOptions();
                if(isIncognito){
                    chromeOptions.addArguments("--incognito");
                }
                if(isHeadless){
                    chromeOptions.addArguments("--headless");
                }

                driver = new ChromeDriver(chromeOptions);
                break;
            case "FF":
            default:
                FirefoxOptions options = new FirefoxOptions();
                options.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.WARNING));
                options.setHeadless(isHeadless);
//                if(isHeadless){
//                    options.addArguments("-headless");
//                }
                System.setProperty(PROPERTY_DRIVER_FIREFOX, PATH_DRIVER_FIREFOX);
                driver = new FirefoxDriver(options);
                break;
        }
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }

    public static void openUrl(String url){
        driver.get(url);
    }

    public static void pause(long timeInMs){
        try{
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void scrollDownBy(int num){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+num+")");
    }
    public static void fileUpload(String fileLocation){
        WebElement upload = driver.findElement(By.name("img"));
        System.out.println(upload.getAttribute("type"));
        upload.sendKeys(fileLocation);
    }
    public static void typeInFieldByID(String id , String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }
    public static void typeInFieldByName(String name , String value){
        driver.findElement(By.name(name)).sendKeys(value);
    }
    public static void typeInFieldByXpath(String xpath , String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void closeBrowser(){

        driver.close();
    }

    public static void closeAllBrowser(){
        driver.quit();
    }
    public static void selectDropDown(String selector , boolean byId){
        Select carlist;
        if(byId){
            carlist = new Select(driver.findElement(By.id(selector)));
        }
        else{
             carlist = new Select(driver.findElement(By.name(selector)));
        }
        int size = carlist.getOptions().size();
        for(int i = 0 ; i < size ; i++){
            SeleniumHandler.pause(2000);
            carlist.selectByIndex(i);
        }
    }
    public static void acceptAndDismissShowMeAlert(String selector){
        driver.findElement(By.xpath(selector)).click();
        SeleniumHandler.pause(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath(selector)).click();
        SeleniumHandler.pause(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


    }
    public static void acceptAndCancelConfirmationAlertBox(String selector){
        driver.findElement(By.xpath(selector)).click();
        SeleniumHandler.pause(2000);
        System.out.println(driver.switchTo().alert().getText());
        SeleniumHandler.pause(2000);
        driver.switchTo().alert().accept();
        SeleniumHandler.pause(2000);
        WebElement response = driver.findElement(By.id("demo"));
        System.out.println(response.getText());
        Assert.assertEquals(response.getText(),"You pressed OK!");
        System.out.println("Then");
        driver.findElement(By.xpath(selector)).click();
        SeleniumHandler.pause(2000);
        driver.switchTo().alert().dismiss();
        response = driver.findElement(By.id("demo"));
        SeleniumHandler.pause(2000);
        System.out.println(response.getText());
        Assert.assertTrue(response.getText().contains("Cancel"));
    }
    public static void sendTextInPromptbyXpath(String selector, String str){
        driver.findElement(By.xpath(selector)).click();
        SeleniumHandler.pause(2000);
        System.out.println(driver.switchTo().alert().getText());
        SeleniumHandler.pause(10000);
        driver.switchTo().alert().sendKeys(str);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath(selector)).click();
        driver.switchTo().alert().dismiss();
        SeleniumHandler.pause(2000);
    }


}
