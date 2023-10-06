package testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class OpenWestJetBooking {
//https://theautomationtechies.com/web-elements-for-ui-testing/


    @Test
    public void WestjetLoading() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get("https://www.westjet.com/en-ca");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Source Length: " + driver.getPageSource().contains("name=\"csi\""));

        driver.findElement(By.xpath("//input[@name=\"origin-airport-0\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"origin-airport-0\"]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("origin-airport-0")).sendKeys("yyz");
        driver.findElement(By.name("origin-airport-0")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();
    }
    /*
    1. Open URL                 10s
    2. Login                    10s
    3.      Personal Info       10s
    4.          Financial Info  30s
    5. Log out                  10s
     */

    @Test
    public void WestjetLoadingFirefox() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get("https://www.westjet.com/en-ca");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Source Length: " + driver.getPageSource().contains("name=\"csi\""));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"origin-airport-0\"]"))).click();

//        FluentWait fluentWait = new FluentWait(driver)
//                .pollingEvery(Duration.ofMillis(5000))
//                        .withTimeout(Duration.ofSeconds(30))
//                                .ignoring(StaleElementReferenceException.class);
//        fluentWait.until(new Function() {
//            @Override
//            public Object apply(Object o) {
//                System.out.println("Waiting : Fluent Wait");
//                return null;
//            }
//        });
        //driver.findElement(By.xpath("//input[@name=\"origin-airport-0\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"origin-airport-0\"]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("origin-airport-0")).sendKeys("yyz");
        driver.findElement(By.name("origin-airport-0")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        //Financial info


        driver.quit();
    }

}
