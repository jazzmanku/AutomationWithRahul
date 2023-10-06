package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    /*
    1. click on the Google Chrome App
    2. type google.com in url window
    3. in search window type "Todays Weather"
    4. search for a specific link "Weather Network"
    5. click the link
    //input[@name="origin-airport-0"]
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.ca");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Source Length: " + driver.getPageSource().contains("name=\"csi\""));

        driver.findElement(By.id("APjFqb")).sendKeys("Today's Weather");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }

}
