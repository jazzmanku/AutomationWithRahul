package framework.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static framework.Constants.DELAY_IN_MS;

public class Helper {

    public static void scrollBy(int verticalPixels, WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, " + verticalPixels + ");");
        Thread.sleep(DELAY_IN_MS);
    }
}
