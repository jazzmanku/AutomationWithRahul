package framework.testcases;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static framework.Constants.*;
import static framework.helper.Helper.scrollBy;

public class TestPage2 extends BaseTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browserType")
    public void setupTest(String browserType){
        if(browserType!=null)
            driver = setup(browserType, APP_URL);
        else
            driver = setup(CHROME_BROWSER, APP_URL);
        driver.get(APP_URL);
    }

    @AfterMethod
    public void stopTesting() throws InterruptedException {
        tearDown(driver);
    }

    @Test
    public void TC01_TestRadioButtons() throws InterruptedException {
        scrollBy(700, driver);
        WebElement radio1 = driver.findElement(By.id("radio1"));
        if(!radio1.isSelected())
            radio1.click();
        Thread.sleep(1000);

        WebElement radio2 = driver.findElement(By.id("radio2"));
        if(!radio2.isSelected())
            radio2.click();

        List<WebElement> radioButtons = driver.findElements(By.name("yesno"));
        for (WebElement e : radioButtons) {
            System.out.println("Value is : " + e.getAttribute("value"));
            if(!e.isSelected()){
                e.click();
                Thread.sleep(500);
                System.out.println(e.getAttribute("id") + " was checked");
            }
        }
    }
}
