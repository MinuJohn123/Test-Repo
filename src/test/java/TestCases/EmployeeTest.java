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

    //@Test(priority = 1)
    public void assertSearchByNameTest() {
        String searchName = employeeInfo.get("SearchName").getAsString();
        String result = employeePage.SearchByName(searchName);
        System.out.println("result : " + result);
        Assert.assertEquals(result, searchName);
        System.out.println("assertSearchTest is done successfully");
    }
    @Test(priority = 2)
    public void add_personal_info() throws InterruptedException {

        employeePage=new EmployeePage(webDriver);

        employeePage.add_personal_info(System.getProperty("add.Firstname"), System.getProperty("add.Firstname_arabic"),
                System.getProperty("add.Emp_id"), System.getProperty("add.National_id"),
                System.getProperty("add.nationality"), System.getProperty("add.Email_id"));


    }
    @Test(priority = 3)
    public void add_organization() throws InterruptedException {

        employeePage.add_organization(System.getProperty("add.joining_date"),System.getProperty("add.Employment_Type"),
                System.getProperty("add.Department"),System.getProperty("add.Wrk_location"),
                System.getProperty("add.line_manager"), System.getProperty("add.access")
                ,System.getProperty("add.contract_type"));


    }
    @Test(priority = 4)
    public void Finances_Insurance() throws InterruptedException {

        employeePage.Finances_Insurance(System.getProperty("add.Basic_sal"), System.getProperty("add.Bank_country"),
                System.getProperty("add.bank_name"), System.getProperty("add.IBAN"));


    }
    @Test(priority = 5)
    public void Annual_Leave_Attendance_Policy() throws InterruptedException {

        employeePage.Annual_Leave_Attendance_Policy();


    }
    @Test(priority = 5)
    public void Employee_creation_confirmation() throws InterruptedException {

        employeePage.Employee_creation_confirmation();


    }



}
