package testing.tests;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void runBeforeSuite(){
        System.out.println("Create the DB");
    }

    @AfterSuite
    public void runAfterSuite(){
        System.out.println("Drop the DB");
    }

    @BeforeTest
    public void runBeforeTest(){
        System.out.println("    Install the Required Browsers");
    }

    @AfterTest
    public void runAfterTest(){
        System.out.println("    Delete the Required Browsers");
    }
    @BeforeClass
    public void runBeforeClass(){
        System.out.println("        Open Browser and Navigate to App URL");
    }

    @AfterClass
    public void runAfterClass(){
        System.out.println("        Close the Browser");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("            Login");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("            Logout");
    }
}
