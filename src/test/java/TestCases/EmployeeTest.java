package TestCases;

import Heplers.JsonReader;
import Pages.EmployeePage;
import Pages.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    private EmployeePage employeePage;
    private LoginPage loginPage;
    private JsonObject employeeInfo;


    @BeforeClass
    public void init() {
        JsonReader jsonReader = new JsonReader();
        employeeInfo = jsonReader.getJsonObject(System.getProperty("path.employeeInfo"));
        employeePage = new EmployeePage(webDriver);
    }

    @BeforeClass
    public void login() {
        //open application URL
        webDriver.get(System.getProperty("target.homepage"));
        // initialize an object from login page
        loginPage = new LoginPage(webDriver);
        // login with username and password provided from test.properties file
        loginPage.Login(System.getProperty("account.username"), System.getProperty("account.password"));
    }

    @Test(priority = 1)
    public void assertSearchByNameTest() {
        String searchName = employeeInfo.get("SearchName").getAsString();
        String result = employeePage.SearchByName(searchName);
        System.out.println("result : " + result);
        Assert.assertEquals(result, searchName);
        System.out.println("assertSearchTest is done successfully");
    }

}
