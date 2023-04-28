package Pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class EmployeePage {

    public WebDriverWait wait;
    JavascriptExecutor js;
    private Actions actions;

    public Alert alert;

    @FindBy(xpath = "//a[@class=\"sideMenuToggle\"] //i[@class='mdi mdi-menu']")
    private WebElement homeMnu;

    @FindBy(xpath = "//*[@href=\"/hr/emp\"]")
    private WebElement empMnu;

    @FindBy(xpath = "//*[@class=\"input-style ng-untouched ng-pristine ng-valid\"]")
    private WebElement searchTxt;

    @FindBy(xpath = "//*[@data-kendo-grid-column-index=\"1\"]")
    private List<WebElement> grdName;

    //------------add_personal_info-------------------------//
    @FindBy(xpath = "//i[@class='mdi mdi-account-plus-outline']")
    private WebElement select_add;
    @FindBy(xpath = "//input[@placeholder='First Name (EN)']")
    private WebElement enter_first_name;
    @FindBy(xpath = "//input[@placeholder='First Name (AR)']")
    private WebElement enter_first_name_arabic;
    @FindBy(xpath = "//input[@placeholder='Employee ID']")
    private WebElement enter_emp_id;
    @FindBy(xpath = "//input[@placeholder='National ID Number']")
    private WebElement enter_national_id;
    @FindBy(xpath = "(//span[@class='k-input'])[1]")
    private WebElement select_nationality;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_nationality;
    @FindBy(xpath = "//input[@placeholder='Email ID']")
    private WebElement enter_email_id;
    //-------------add_Organization_Contract_info----------------------------------//
    @FindBy(xpath = "//a[normalize-space()='Organization & Contract']")
    private WebElement select_Organization_Contract;
    @FindBy(xpath = "//input[@placeholder='Joining Date']")
    private WebElement select_joining_date;
    @FindBy(xpath = "(//span[@class='k-input'])[1]")
    private WebElement select_emp_type;

    @FindBy(xpath = "(//span[@class='k-input'])[3]")
    private WebElement select_department;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_department;
    @FindBy(xpath = "(//span[@class='k-input'])[4]")
    private WebElement select_work_location;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_work_location;
    @FindBy(xpath = "(//span[@class='k-input'])[6]")
    private WebElement select_line_manager;

    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_line_manager;

    @FindBy(xpath = "(//span[@class='k-input'])[7]")
    private WebElement select_access;

    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_access;

    @FindBy(xpath = "(//span[@class='k-input'])[9]")
    private WebElement select_contract_type;
    //-------------Add_Finances_Insurance------------------------------//

    @FindBy(xpath = "//a[normalize-space()='Finances & Insurance']")
    private WebElement select_Finances_Insurance;
    @FindBy(xpath = "(//input[@class='k-input k-formatted-value'])[1]")
    private WebElement enter_basic_sal;
    @FindBy(xpath = "//input[@id='paymentMethod1']")
    private WebElement select_payment_method;
    @FindBy(xpath = "(//span[@class='k-input'])[1]")
    private WebElement select_bank_country;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_bank_country;
    @FindBy(xpath = "(//span[@class='k-input'])[2]")
    private WebElement select_bank_name;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_bank_name;
    @FindBy(xpath = "//input[@placeholder='IBAN']")
    private WebElement enter_iban;
    //--------------Add_Earned_leave_Attendance_Policy--------------------------//
    @FindBy(xpath = "(//li[@class='list-inline-item'])[4]")
    private WebElement select_Earned_leave_Attendance_Policy;
    @FindBy(xpath = "//input[@id='leaveType0']")
    private WebElement select_leave_type;
    @FindBy(xpath = "//input[@id='shift1']")
    private WebElement select_shift;
    @FindBy(xpath = "//button[normalize-space()='Add Employee']")
    private WebElement add_emp;

    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    WebElement alerTxt;

    @FindBy(xpath = "//button[normalize-space()='No']")
    private WebElement Request_workflow;

    /*   Apply Filter*/

    @FindBy(xpath = "//i[@class='mdi mdi-filter-outline']")
    private WebElement Filter;


    @FindBy(xpath = "//input[@id='S1']")
    private WebElement Activeemp;


    @FindBy(xpath = "//label[text()='Under Probation']")
    private WebElement Underprobation;

    @FindBy(xpath = "//div[@class='dropdown']")
    private WebElement dropdown1;

    @FindBy(xpath = "//*[text()=' Leader In Group India Pvt Ltd ']")
    private WebElement Allemp;

    @FindBy(xpath = "//div[@class='dropdown']")
    private WebElement locationdropdown;

    @FindBy(xpath = "//*[text()=' India ']")
    private WebElement India;

    @FindBy(xpath = "//label[text()='Associate Test Engineer']")
    private WebElement AutTestEng;

    @FindBy(xpath = "//label[text()='India']")
    private WebElement Indian;

    @FindBy(xpath = "//label[text()='Contract']")
    private WebElement contract;

    @FindBy(xpath = "//button[text()='Apply Filters']")
    private WebElement Apply;


    @FindBy(xpath = "//*[text()='Associate Test Engineer']")
    private List<WebElement> elements;



    //----------------------------------------------------------------------/

    public EmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }
    public String SearchByName(String strSearh) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(homeMnu));
        js.executeScript("arguments[0].click()", homeMnu);
        js.executeScript("arguments[0].click()", empMnu);
        js.executeScript("arguments[0].click()", searchTxt);
        searchTxt.sendKeys(strSearh);
        Thread.sleep(4000);
        String searchName = "";
        //System.out.println("size is "+grdName.size());
        if (grdName.size() > 0) {
            //System.out.println("element 0 is "+Grd.get(0).getText());
            searchName = grdName.get(0).getText();
        }
        return searchName;
    }

    public void add_personal_info(String first_name,String first_name_arabic,String emp_id,
                                  String national_id,String nationality,String email_id) throws  InterruptedException {
        js.executeScript("arguments[0].click()", homeMnu);
        js.executeScript("arguments[0].click()", empMnu);
        js.executeScript("arguments[0].click();", select_add);
        enter_first_name.sendKeys(first_name);
        enter_first_name_arabic.sendKeys(first_name_arabic);
        Thread.sleep(4000);
        enter_emp_id.sendKeys(emp_id);
        Thread.sleep(4000);
        js.executeScript("arguments[0].click();",enter_national_id);
        enter_national_id.sendKeys(national_id);
        js.executeScript("arguments[0].click();",select_nationality);
        enter_nationality.sendKeys(nationality);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        enter_email_id.sendKeys(email_id);
        System.out.println("Entered employee details:"+emp_id+" "+first_name);

    }

    public void add_organization(String joining_date,String emp_type,String department,String work_location,
                                 String line_manager,String access,String contract_type) throws  InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(select_Organization_Contract));
        select_Organization_Contract.click();
        Thread.sleep(4000);
        select_joining_date.click();

        actions.sendKeys(Keys.LEFT).perform();

        Thread.sleep(4000);
        select_joining_date.sendKeys(joining_date);
        select_emp_type.click();
        actions.sendKeys(Keys.chord(Keys.SHIFT+emp_type)).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        select_department.click();
        enter_department.sendKeys(department);
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_work_location);
        enter_work_location.sendKeys(work_location);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_line_manager);
        enter_line_manager.sendKeys(line_manager);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_access);
        enter_access.sendKeys(access);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_contract_type);
        actions.sendKeys(Keys.chord(Keys.SHIFT+contract_type)).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();


    }


    public void Finances_Insurance(String basic_sal,String bank_country,String bank_name,String iban) throws  InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(select_Finances_Insurance));
        js.executeScript("arguments[0].click();", select_Finances_Insurance);
        enter_basic_sal.sendKeys(basic_sal);
        select_payment_method.click();
        select_bank_country.click();
        enter_bank_country.sendKeys(bank_country);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_bank_name);
        enter_bank_name.sendKeys(bank_name);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        enter_iban.sendKeys(iban);

    }

    public void Earned_Leave_Attendance_Policy() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(select_Earned_leave_Attendance_Policy));
        select_Earned_leave_Attendance_Policy.click();
        select_leave_type.click();
        select_shift.click();




    }
    public void Employee_creation_confirmation() throws InterruptedException {
        add_emp.click();
        wait.until(ExpectedConditions.visibilityOf(alerTxt));
        String Actual = alerTxt.getText();
        System.out.println(""+ Actual +"");
        Request_workflow.click();
        String expected ="Successfully Created";
        Assert.assertEquals(Actual, expected);
        System.out.println("assert_employee creation done successfully");

    }
    //Apply Filter
    public boolean filtered() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(homeMnu));
        js.executeScript("arguments[0].click()", homeMnu);
        wait.until(ExpectedConditions.visibilityOf(empMnu));
        js.executeScript("arguments[0].click()", empMnu);
        wait.until(ExpectedConditions.visibilityOf(Filter));
        js.executeScript("arguments[0].click()", Filter);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(dropdown1));
        js.executeScript("arguments[0].click()", dropdown1);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", Allemp);
        System.out.println("All employees are selected");
        wait.until(ExpectedConditions.visibilityOf(locationdropdown));
        js.executeScript("arguments[0].click()", locationdropdown);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", India);
        System.out.println("India option  is selected");
        js.executeScript("arguments[0].click()", AutTestEng);
        System.out.println("Automation Test Engineer  is selected");
        js.executeScript("arguments[0].click()", Indian);
        System.out.println("India option  is selected");
        js.executeScript("arguments[0].click()", contract);
        System.out.println("Contract option  is selected");
        js.executeScript("arguments[0].click()", Apply);

        String text = "";
        ArrayList<String> actValues = new ArrayList<String>();

        ArrayList <String> expValues=new ArrayList<String>();
        expValues.add("Associate Test Engineer");

        for (int i = 0; i < elements.size(); i++)
        {
            elements.get(i).getText();
            actValues.add(text);

        }
        boolean flag = true;
        for (int i = 0; i < expValues.size(); i++)
        {
            if (flag == false)
            {

                break;
            }
        }
        if(flag==true)


        {

            System.out.println("Fiter is as Expected");
        }
        else

        {
            System.out.println("Filter is Not as  Expected");
        }
        return flag;
    }




}
