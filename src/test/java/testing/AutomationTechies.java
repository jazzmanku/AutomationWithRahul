package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutomationTechies {

    @Test
    public void TC01_TestTextBoxes() throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get(url);

        scrollBy(1000, driver);

        scrollBy(-500, driver);
        WebElement firstName = driver.findElement(By.name("fname")); // //*[@id='text1']
        if(firstName.isEnabled() == true)
            firstName.sendKeys("John");

        WebElement text4 = driver.findElement(By.id("text4"));
        //jse.executeScript("arguments[0].scrollIntoView(true);", text4, firstName);
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    public void TC02_TestCheckboxes() throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get(url);
        scrollBy(500, driver);
//        WebElement checkBox1 = driver.findElement(By.id("check1"));
//        if(!checkBox1.isSelected())
//            checkBox1.click();
//
//        WebElement checkBox2 = driver.findElement(By.id("check2"));
//        if(checkBox2.isSelected()==true)
//            checkBox2.click();

        List<WebElement> vehicles = driver.findElements(By.name("vehicle"));
        for (WebElement e : vehicles) {
            System.out.println("Value is : " + e.getAttribute("value"));
            if(!e.isSelected()){
                e.click();
                System.out.println(e.getAttribute("id") + " was checked");
            }
        }

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<WebElement> links1 = driver.findElements(By.xpath("//a"));
        System.out.println(links1.size());


        WebElement linkText = driver.findElement(By.xpath("//*[@class='breadcrumb_last']"));
        System.out.println(linkText.getText());
        linkText.click();

        WebElement linkText2 = driver.findElement(By.className("breadcrumb_last"));
        System.out.println(linkText2.getText());

        driver.findElement(By.linkText("Home")).click();

        driver.findElement(By.partialLinkText("Contact")).click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void TC02_TestRadioButtons() throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get(url);
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

        Thread.sleep(5000);
        driver.quit();
    }
    public void scrollBy(int verticalPixels, WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, " + verticalPixels + ");");
        Thread.sleep(500);
    }
}
