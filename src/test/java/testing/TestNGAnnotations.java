package testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    /*
    1. Open Chrome Browser
    2. Navigate to the URL
        3. TC01 Verify the Login Page is open
            3.1 Enter Credentials
            3.2. Press Submit
                4. TC02 Verify Home Page
                5. TC03 Verify Account Details
                    5.1
                    5.2
                6. TC04 Verify Personal Details
                    6.1
                    6.2
    7. Logout
     */

    public static void OpenBrowser_NavigateToURL(){
        System.out.println("Open Browser");
        System.out.println("Navigate To Url");
    }

    public static void CloseBrowser(){
        System.out.println("Close Browser");
    }

    public static void Logout(){
        System.out.println("Logout");
    }

    @BeforeMethod
    public void setup(){
        OpenBrowser_NavigateToURL();
        Login();
    }
    @AfterMethod
    public void tearDown(){
        Logout();
        CloseBrowser();
    }

    public static void Login(){
        System.out.println("Verify Login Page");
        System.out.println("Enter credentials");
        System.out.println("Press Submit");
    }

    @Test
    public static void TC02_VerifyHomePage(){
        System.out.println("Verify Home Page");
    }

    @Test
    public static void TC03_VerifyHomePage(){
        System.out.println("Verify Account Details Page");
    }

    @Test
    public static void TC04_VerifyPersonalDetailsPage(){
        System.out.println("Verify Personal Details Page");
    }

}
