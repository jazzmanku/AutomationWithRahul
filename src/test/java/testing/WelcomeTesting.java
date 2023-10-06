package testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class WelcomeTesting {

    public void scrollBy(int verticalPixels, WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, " + verticalPixels + ");");
        Thread.sleep(500);
    }

    @Test
    public void TC01_TestTextBoxes() throws InterruptedException {
        String url = "https://theautomationtechies.com/welcome-to-automation-testing/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25000));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50000));

        driver.get(url);


        WebElement radioMaybe = driver.findElement(By.id("Are_you_excited_For_Automation_Testing__Maybe"));
        if(!radioMaybe.isSelected())
            radioMaybe.click();
        Thread.sleep(1000);

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

        WebElement checkbox5= driver.findElement(By.id("What_is_your_dream_job__More"));
        checkbox5.click();
        Thread.sleep(1000);

        scrollBy(500, driver);

        WebElement dropdown1 = driver.findElement(By.xpath("//option[contains(text(),'No')]"));
        dropdown1.click();

        Thread.sleep(1000);

        By byId = By.id("Email");
        WebElement  email = driver.findElement(byId);
        email.sendKeys("Rahul.Mitra@gmail.com");

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

        WebElement uploader = driver.findElement(By.xpath("//input[@id='File_Uploader_']"));
        uploader.click();
        uploader.sendKeys("C:\rescuepe.txt");
        Thread.sleep(1000);
        uploader.sendKeys(Keys.ENTER);


        WebElement address1 = driver.findElement(By.id("Fill_in_the_Address_address_line_1"));
        address1.sendKeys("134 Danforth Ave");

        WebElement address2 = driver.findElement(By.id("Fill_in_the_Address_address_line_2"));
        address2.sendKeys("24 Sussex Drive");

        scrollBy(500, driver);
        WebElement city = driver.findElement(By.id("Fill_in_the_Address_city"));
        city.sendKeys("Toronto");

        WebElement state = driver.findElement(By.id("Fill_in_the_Address_state"));
        state.sendKeys("Ontario");

        WebElement  postalCode = driver.findElement(By.id("Fill_in_the_Address_postal_code"));
        postalCode.sendKeys("L5N 3D9");

        WebElement country = driver.findElement(By.id("Fill_in_the_Address_country"));
        country.sendKeys("Canada");

        WebElement question = driver.findElement(By.id("What_do_you_think_of_this_form_"));
        question.sendKeys("This is absolutely Amazing");

        Thread.sleep(3500);











        Thread.sleep(1000);


        driver.quit();
    }



}
