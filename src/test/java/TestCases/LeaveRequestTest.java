package TestCases;

import Heplers.JsonReader;
import Pages.LeaveRequestPage;
import Pages.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveRequestTest extends BaseTest {

    private LoginPage loginPage;
    private JsonObject leavereuestinfo;
    private LeaveRequestPage requestDemoPage;


    @BeforeClass
    public void init() {

        leavereuestinfo = new JsonObject();
        JsonReader jsonReader = new JsonReader();
        leavereuestinfo = jsonReader.getJsonObject(System.getProperty("path.LeaveRequestInfo"));
        requestDemoPage = new LeaveRequestPage(webDriver);
    }


    @BeforeClass
    public void login() {
        //open application URL
        webDriver.get(System.getProperty("target.homepage"));
        // initialize an object from login page
        loginPage = new LoginPage(webDriver);
        // login with username and password provided from test.properties file
        loginPage.Login(System.getProperty("account.username.employee"), System.getProperty("account.password"));
    }

    @Test
    private void assertRequestDemo() {
        String result = requestDemoPage.createRequest(leavereuestinfo.get("year").getAsString(), leavereuestinfo.get("day").getAsString(), leavereuestinfo.get("month").getAsString());
        String expectedTxt = "Successfully Created";
        Assert.assertEquals(result, expectedTxt);
        System.out.println("Assertion Pass");
    }


}
