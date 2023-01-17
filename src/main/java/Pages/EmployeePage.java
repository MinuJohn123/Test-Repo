package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EmployeePage {

    public WebDriverWait wait;
    JavascriptExecutor js;
    private Actions actions;

    //@FindBy(xpath = "//i[@class=\"mdi mdi-menu\"]")

    //@FindBy(xpath="//*[@class=\"sideMenuToggle\"]")
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
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-personal-info[1]/div[1]/div[2]/div[1]/div[10]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_nationality;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/span[1]/input[1]")
    private WebElement enter_nationality;
    @FindBy(xpath = "//input[@placeholder='Email ID']")
    private WebElement enter_email_id;
    //-------------add_org----------------------------------//
    @FindBy(xpath = "//a[normalize-space()='Organization & Contract']")
    private WebElement select_Organization_Contract;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[1]/fox-datepicker[1]/div[1]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]")
    private WebElement select_joining_date;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[3]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_emp_type;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[5]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_department;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/span[1]/input[1]")
    private WebElement enter_department;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[6]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_work_location;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/span[1]/input[1]")
    private WebElement enter_work_location;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[8]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_line_manager;

    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_line_manager;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[1]/div[1]/div[9]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_access;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/span[1]/input[1]")
    private WebElement enter_access;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-organd-contract[1]/div[3]/div[1]/div[2]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_contract_type;
    //-------------add_finance------------------------------//

    @FindBy(xpath = "//a[normalize-space()='Finances & Insurance']")
    private WebElement select_Finances_Insurance;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-finance[1]/div[1]/div[1]/div[1]/fox-numerictextbox[1]/div[1]/kendo-numerictextbox[1]/span[1]/input[1]")
    private WebElement enter_basic_sal;
    @FindBy(xpath = "//input[@id='paymentMethod1']")
    private WebElement select_payment_method;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-finance[1]/div[2]/div[2]/div[1]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_bank_country;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/span[1]/input[1]")
    private WebElement enter_bank_country;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-new-emp-content[1]/app-new-employee-tab-menu[1]/div[2]/div[2]/app-new-emp-finance[1]/div[2]/div[2]/div[2]/fox-dropdown[1]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
    private WebElement select_bank_name;
    @FindBy(xpath = "//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")
    private WebElement enter_bank_name;
    @FindBy(xpath = "//input[@placeholder='IBAN']")
    private WebElement enter_iban;
    //--------------add_attendance--------------------------//
    @FindBy(xpath = "//a[normalize-space()='Annual Leave & Attendance Policy']")
    private WebElement select_Annual_leave_Attendance_Policy;
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
    //--------------confirmation---------------------------//

    @FindBy(xpath = "//i[@class='mdi mdi-menu']")
    private WebElement select_options;
    @FindBy(xpath = "//input[@placeholder='Search by employee name or ID']")
    private WebElement enter_emp_detail;
    @FindBy(xpath = "//td[@data-kendo-grid-column-index='0']")
    private WebElement select_emp_detail;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-employee[1]/div[1]/div[3]/app-grid-view-search-employee[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]")
    private WebElement select_emp_record_availability;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-employee[1]/div[1]/div[3]/app-grid-view-search-employee[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement select_profile_emp_id;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-content[1]/div[1]/div[1]/app-employee[1]/div[1]/div[3]/app-grid-view-search-employee[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/span[1]")
    private WebElement select_profile_emp_name;

    public EmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public String SearchByName(String strSearh) {
        wait.until(ExpectedConditions.visibilityOf(homeMnu));
        js.executeScript("arguments[0].click()", homeMnu);
        js.executeScript("arguments[0].click()", empMnu);
        js.executeScript("arguments[0].click()", searchTxt);
        searchTxt.sendKeys(strSearh);
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
        Thread.sleep(2000);
        enter_emp_id.sendKeys(emp_id);
        enter_national_id.sendKeys(national_id);
        js.executeScript("arguments[0].click();", select_nationality);
        enter_nationality.sendKeys(nationality);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        enter_email_id.sendKeys(email_id);
        System.out.println("Entered employee details:"+emp_id+" "+first_name);

    }

    public void add_organization(String joining_date,String emp_type,String department,String work_location,
                                 String line_manager,String access,String contract_type) throws  InterruptedException {

        select_Organization_Contract.click();
        select_joining_date.click();
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
        select_work_location.click();
        enter_work_location.sendKeys(work_location);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        select_line_manager.click();
        enter_line_manager.sendKeys(line_manager);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        select_access.click();
        enter_access.sendKeys(access);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", select_contract_type);
        actions.sendKeys(Keys.chord(Keys.SHIFT+contract_type)).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();


    }


    public void Finances_Insurance(String basic_sal,String bank_country,String bank_name,String iban) throws  InterruptedException {

        select_Finances_Insurance.click();
        enter_basic_sal.sendKeys(basic_sal);
        select_payment_method.click();
        select_bank_country.click();
        enter_bank_country.sendKeys(bank_country);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        select_bank_name.click();
        enter_bank_name.sendKeys(bank_name);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        enter_iban.sendKeys(iban);

    }

    public void Annual_Leave_Attendance_Policy() throws InterruptedException {

        select_Annual_leave_Attendance_Policy.click();
        select_leave_type.click();
        select_shift.click();
        add_emp.click();
        String message=alerTxt.getText();
        System.out.println(""+message);
        Thread.sleep(2000);
        Request_workflow.click();

    }


}
