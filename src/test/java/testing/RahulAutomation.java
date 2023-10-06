package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class RahulAutomation {

    private final int PAGE_LOAD_TIMEOUT_IN_SEC = 25000;
    private final int SCRIPT_TIMEOUT_IN_SEC = 50000;
    private final int IMP_WAIT_TIMEOUT_IN_SEC = 15000;
    private String CHROME_BROWSER = "CH";
    private String FIREFOX_BROWSER = "FF";
    private String APP_URL = "https://theautomationtechies.com/web-elements-for-ui-testing";
    private long DELAY_IN_MS=500;


    public void scrollBy(int verticalPixels, WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, " + verticalPixels + ");");
        Thread.sleep(DELAY_IN_MS);
    }

    public WebDriver setup(String browserType) throws InterruptedException {
       // String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver;
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

    @Test
    public void TC01_TestTextBoxes() throws InterruptedException {
        WebDriver driver = setup(CHROME_BROWSER);
        driver.get(APP_URL);
        //driver.findElement(By.linkText("Portfolio")).click();
        scrollBy(1000, driver);
        scrollBy(-500, driver);
       // WebElement loginBtn = driver.findElement(By.class("login"));

        WebElement firstName = driver.findElement(By.name("fname")); // //*[@id='text1']
        if(firstName.isEnabled())
           firstName.sendKeys("John");

        WebElement text2 = driver.findElement(By.id("text2"));
        if(text2.isDisplayed()== true)
            text2.sendKeys("Mitra");

        WebElement text3 = driver.findElement(By.id("text3"));
        if(text3.isDisplayed()== true)
            text3.sendKeys("This is Hidden");

        WebElement text4 = driver.findElement(By.id("text4"));
        if(text4.isDisplayed()== true)
            text4.sendKeys("I can see you");

        WebElement checkBox1 = driver.findElement(By.id("check1"));
        if(!checkBox1.isSelected())
            checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.id("check2"));
        if(checkBox2.isSelected()==false)
            checkBox2.click();

        WebElement checkBox3 = driver.findElement(By.id("check3"));
        if(checkBox3.isSelected()==false)
            checkBox3.click();

        WebElement checkBox4 = driver.findElement(By.id("check4"));
        if(checkBox4.isSelected()==false)
            checkBox4.click();

        WebElement checkBox5 = driver.findElement(By.id("check5"));
        if(checkBox5.isSelected()==false)
            checkBox5.click();

        WebElement checkBox22 = driver.findElement(By.id("check22"));
        if(checkBox22.isSelected()==false)
            checkBox22.click();

        WebElement checkBox33 = driver.findElement(By.id("check33"));
        if(checkBox33.isSelected()==false)
            checkBox33.click();

        WebElement checkBox101 = driver.findElement(By.id("check101"));
        if(checkBox101.isSelected()==false)
            checkBox101.click();



        //jse.executeScript("arguments[0].scrollIntoView(true);", text4, firstName);
        Thread.sleep(5000);
        driver.quit();
    }
}
