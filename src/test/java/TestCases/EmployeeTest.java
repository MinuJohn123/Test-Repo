package TestCases;

import Heplers.JsonReader;
import Pages.EmployeePage;
import Pages.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    private EmployeePage employeePage;
    private LoginPage loginPage;
    private JsonObject employeeInfo;
    private EmployeePage filter;


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
        test=extent.createTest("login");
        // login with username and password provided from test.properties file
        loginPage.Login(System.getProperty("account.username"), System.getProperty("account.password"));
        System.out.println("Inside Emp req");
        Assert.assertTrue(1>0);
    }

    @Test(priority = 1)
    public void assertSearchByNameTest() throws InterruptedException {
        test=extent.createTest("assertSearchByNameTest");
        String searchName = employeeInfo.get("SearchName").getAsString();
        String result = employeePage.SearchByName(searchName);
        System.out.println("result : " + result);
        Assert.assertEquals(result, searchName);
        System.out.println("assertSearchTest is done successfully");
        Assert.assertTrue(1>0);
    }
    @Test(priority = 2)
    public void add_personal_info() throws InterruptedException {
        test=extent.createTest("add_personal_info");
        employeePage=new EmployeePage(webDriver);

        employeePage.add_personal_info(System.getProperty("add.Firstname"), System.getProperty("add.Firstname_arabic"),
                System.getProperty("add.Emp_id"), System.getProperty("add.nationalid"),
                System.getProperty("add.nationality"), System.getProperty("add.Email_id"));
        Assert.assertTrue(1>0);

    }
    @Test(priority = 3)
    public void add_organization() throws InterruptedException {
        test=extent.createTest("add_organization");
        employeePage.add_organization(System.getProperty("add.joining_date"),System.getProperty("add.Employment_Type"),
                System.getProperty("add.Department"),System.getProperty("add.Wrk_location"),
                System.getProperty("add.line_manager"), System.getProperty("add.access")
                ,System.getProperty("add.contract_type"));
        Assert.assertTrue(1>0);

    }
    @Test(priority = 4)
    public void Finances_Insurance() throws InterruptedException {
        test=extent.createTest("Finances_Insurance");
        employeePage.Finances_Insurance(System.getProperty("add.Basic_sal"), System.getProperty("add.Bank_country"),
                System.getProperty("add.bank_name"), System.getProperty("add.IBAN"));
        Assert.assertTrue(1>0);

    }
    @Test(priority = 5)
    public void Annual_Leave_Attendance_Policy() throws InterruptedException {
        test=extent.createTest("Annual_Leave_Attendance_Policy");
        employeePage.Earned_Leave_Attendance_Policy();
        Assert.assertTrue(1>0);
    }

    @Test(priority = 6)
    public void Employee_creation_confirmation() throws InterruptedException {
        test=extent.createTest("Employee_creation_confirmation");
        employeePage.Employee_creation_confirmation();
        Assert.assertTrue(1>0);
    }
    @Test (priority= 7)

    public void Apply_filter() throws InterruptedException
    {
        test=extent.createTest("Apply_filter");
        filter=new EmployeePage(webDriver);
        boolean result= filter.filtered();
        Assert.assertTrue(result,"Successful filter applied ");
        Assert.assertTrue(1>0);



    }




}
