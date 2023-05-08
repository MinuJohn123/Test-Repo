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
import org.testng.Assert;

import java.util.Calendar;

public class LeaveRequestPage {

    public WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//*[@class=\"mdi mdi-menu\"]")
    WebElement menuBtn;
    @FindBy(xpath = "//*[@routerlink=\"request\"]")
    WebElement requestsMenuItem;

 //@FindBy(xpath = "//a[@class='leave-travels-add-button ng-star-inserted']")
// WebElement addLeaveReqBtn;
//@FindBy(xpath ="//a[@routerlink='LeaveRequest' and @class='leave-travels-add-button']")
//WebElement addLeaveReqBtn;
    @FindBy(xpath ="//a[@routerlink='LeaveRequest']//span")
    WebElement addLeaveReqBtn;



    @FindBy(xpath = "//input[@class=\"k-input k-formatted-value\"]")
    WebElement noDaysBtn;
    @FindBy(xpath = "//*[contains(text(),'Select')]")
    WebElement selectOptionDdl;
    @FindBy(xpath = "//button[@class=\"saveBtn ml-2 mr-2\"]")
    WebElement saveReqBtn;
    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    WebElement alerTxt;
    private Actions actions;
    @FindBy(xpath = "//*[contains(text(),'Sick Leave')]")
    private WebElement selectItemDdl;
    @FindBy(xpath = "//*[@placeholder=\"Leave Start Date\"]")
    private WebElement leaveStartDate;
    //*[@placeholder="Leave Start Date"]
    @FindBy(xpath = "//*[@placeholder=\"Leave End Date\"]")
    private WebElement leaveEndDate;


    public LeaveRequestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;


    }
/*
    public String createRequest(String month, String day, String year) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        js.executeScript("arguments[0].click()", menuBtn);

        wait.until(ExpectedConditions.elementToBeClickable(requestsMenuItem));
        js.executeScript("arguments[0].click()", requestsMenuItem);

        wait.until(ExpectedConditions.elementToBeClickable(addLeaveReqBtn));
        js.executeScript("arguments[0].click()", addLeaveReqBtn);

        wait.until(ExpectedConditions.elementToBeClickable(leaveStartDate));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", leaveStartDate);


        actions.sendKeys(month).build().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        actions.sendKeys(day).build().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        actions.sendKeys(year).build().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
       //
        //actions.sendKeys(year).build().perform();
       // leaveStartDate.sendKeys(Keys.ARROW_LEFT);
       //actions.sendKeys(day).build().perform();
       // leaveStartDate.sendKeys(Keys.ARROW_LEFT);
       //leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        //System.out.println("leaveStartDate is " + leaveStartDate);
        //System.out.println("leaveEndDate is" + leaveEndDate);


        System.out.println("month is " +month);
        System.out.println("day is " +day);
        System.out.println("year is " +year);


        wait.until(ExpectedConditions.elementToBeClickable(selectOptionDdl));
        js.executeScript("arguments[0].click()", selectOptionDdl);
        js.executeScript("arguments[0].click()", selectItemDdl);

        js.executeScript("arguments[0].click()", saveReqBtn);
        Thread.sleep(4000);
        String actualTxt = alerTxt.getText();
        System.out.println("Actual Result  is " + actualTxt);

        return actualTxt;
    }*/
public void createRequest(String month, String day, String year) throws InterruptedException {

    wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
    js.executeScript("arguments[0].click()", menuBtn);

    wait.until(ExpectedConditions.elementToBeClickable(requestsMenuItem));
    js.executeScript("arguments[0].click()", requestsMenuItem);

    wait.until(ExpectedConditions.elementToBeClickable(addLeaveReqBtn));
    js.executeScript("arguments[0].click()", addLeaveReqBtn);

    wait.until(ExpectedConditions.elementToBeClickable(leaveStartDate));
    js.executeScript("arguments[0].click()", leaveStartDate);

    leaveStartDate.sendKeys(Keys.ARROW_LEFT);
    actions.sendKeys(year).build().perform();
    leaveStartDate.sendKeys(Keys.ARROW_LEFT);
    actions.sendKeys(day).build().perform();
    leaveStartDate.sendKeys(Keys.ARROW_LEFT);
    leaveStartDate.sendKeys(Keys.ARROW_LEFT);


    actions.sendKeys(month).build().perform();
    wait.until(ExpectedConditions.elementToBeClickable(selectOptionDdl));
    js.executeScript("arguments[0].click()", selectOptionDdl);
    js.executeScript("arguments[0].click()", selectItemDdl);

    js.executeScript("arguments[0].click()", saveReqBtn);

    String actualTxt = alerTxt.getText();
    String expectedTxt = "Successfully Created";
    System.out.println("Actual Result  is " + actualTxt);
    Assert.assertEquals(expectedTxt, actualTxt);

}}
