package TestCases;

import Heplers.JsonReader;
import Pages.EmployeePage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    private EmployeePage employeePage;

    private LoginPage loginPage;


    @BeforeClass
    public void init() {

        JsonReader jsonReader = new JsonReader();
        employeePage = new EmployeePage(webDriver);
    }

    @BeforeClass
    public void login() {
        //open application URL
        webDriver.get(System.getProperty("target.homepage"));
        // initialize an object from login page
        LoginPage loginPage = new LoginPage(webDriver);
        // login with username and password provided from test.properties file
        loginPage.Login(System.getProperty("account.username"), System.getProperty("account.password"));


    }

    @Test(priority = 1)
    public void assertSearchTest() {
         employeePage.Search();
    }



}
