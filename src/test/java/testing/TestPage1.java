package testing;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static framework.Constants.*;
import static framework.helper.Helper.scrollBy;

public class TestPage1 extends BaseTest {
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
    public void TC01_TestTextBoxes() throws InterruptedException {
        scrollBy(1000, driver);
        scrollBy(-500, driver);
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
    }



    @Test
    public void TC02_TestCheckboxes() throws InterruptedException {
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
    }

    @Test
    public void TC03_Testlist() throws InterruptedException {
        WebElement checkList = driver.findElement(By.id("country5"));
        checkList.click();
        Thread.sleep(1000);

        WebElement checkItem = driver.findElement(By.xpath("//button[contains(text(),'Show Me Prompt')]"));
        checkItem.click();
        Thread.sleep(1000);
    }
}
