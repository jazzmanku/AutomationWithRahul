package framework.testcases;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static framework.Constants.*;
import static framework.helper.Helper.scrollBy;
public class TestCaseWelcomePage extends BaseTest {

    @Test
    public void TC01_TestRadioButton() throws InterruptedException {
        scrollBy(1000, driver);
        scrollBy(-500, driver);
        WebElement radioMaybe = driver.findElement(By.id("Are_you_excited_For_Automation_Testing__Maybe"));
        if (!radioMaybe.isSelected())
            radioMaybe.click();
        Thread.sleep(2000);
    }

    @Test
    public void TC02_TestCheckBoxes() throws InterruptedException {

        scrollBy(1000, driver);
        scrollBy(-500, driver);

        WebElement checkbox1 = driver.findElement(By.id("What_is_your_dream_job__100K_Job"));
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.id("What_is_your_dream_job__Vacation"));
        checkbox2.click();
        Thread.sleep(1000);

        driver.findElement(By.id("What_is_your_dream_job__Flexible_Job")).click();
        //checkbox3.click();
        Thread.sleep(1000);

        WebElement checkbox4 = driver.findElement(By.id("What_is_your_dream_job__Benefits"));
        checkbox4.click();
        Thread.sleep(1000);

        WebElement checkbox5 = driver.findElement(By.id("What_is_your_dream_job__More"));
        checkbox5.click();
        Thread.sleep(1000);

        scrollBy(500, driver);

    }

    @Test
    public void TC03_TestDropDown() throws InterruptedException {

        scrollBy(1000, driver);
        scrollBy(-500, driver);

        WebElement dropdown1 = driver.findElement(By.xpath("//option[contains(text(),'No')]"));
        dropdown1.click();

        Thread.sleep(1000);

    }

    @Test
    public void TC04_TestFillInFields() throws InterruptedException {

        By byId = By.id("Email");
        WebElement email = driver.findElement(byId);
        email.sendKeys("Rahul.Mitra@gmail.com");

        WebElement numberSelector = driver.findElement(By.id("Enter_any_number_between__1_to_100"));
        numberSelector.sendKeys("14");

        WebElement favorite = driver.findElement(By.id("Favorite_Website_"));
        favorite.sendKeys("Google.ca");
        Thread.sleep(675);

        scrollBy(500, driver);

        WebElement readElement = driver.findElement(By.xpath("//p[contains(text(),'Use selenium to read my content. Can you read me a')]"));
        String p = readElement.getText();
        System.out.println(p);

        Thread.sleep(675);

        //WebElement uploader = driver.findElement(By.id("#File_Uploader_"));
        //uploader.click();


        WebElement address1 = driver.findElement(By.id("Fill_in_the_Address_address_line_1"));
        address1.sendKeys("134 Danforth Ave");

        WebElement address2 = driver.findElement(By.id("Fill_in_the_Address_address_line_2"));
        address2.sendKeys("24 Sussex Drive");

        scrollBy(500, driver);
        WebElement city = driver.findElement(By.id("Fill_in_the_Address_city"));
        city.sendKeys("Toronto");

        WebElement state = driver.findElement(By.id("Fill_in_the_Address_state"));
        state.sendKeys("Ontario");

        WebElement postalCode = driver.findElement(By.id("Fill_in_the_Address_postal_code"));
        postalCode.sendKeys("L5N 3D9");

        WebElement country = driver.findElement(By.id("Fill_in_the_Address_country"));
        country.sendKeys("Canada");

        WebElement question = driver.findElement(By.id("What_do_you_think_of_this_form_"));
        question.sendKeys("This is absolutely Amazing");

        Thread.sleep(3500);
    }
@Test
    public void TC05_TestTimeRelated() throws InterruptedException {
    WebElement date = driver.findElement(By.id("Today_s_Date_"));
        date.click();
        date.sendKeys("2023");
        Thread.sleep(500);
        date.sendKeys(Keys.TAB);
        date.sendKeys("09");
        Thread.sleep(500);
    //date.sendKeys(Keys.TAB);
        date.sendKeys("16");
        Thread.sleep(500);

    WebElement timeStamp = driver.findElement(By.id("Current_Timestamp_"));
        timeStamp.click();
        timeStamp.sendKeys("11");
        Thread.sleep(500);
    //timeStamp.sendKeys(Keys.TAB);
        timeStamp.sendKeys("09");
        Thread.sleep(500);
    //date.sendKeys(Keys.TAB);
        timeStamp.sendKeys("AM");
        Thread.sleep(500);

    }
}

