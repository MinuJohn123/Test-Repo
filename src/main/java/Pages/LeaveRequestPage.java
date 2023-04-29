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

public class LeaveRequestPage {

    public WebDriverWait wait;
    JavascriptExecutor js;
    @FindBy(xpath = "//*[@class=\"mdi mdi-menu\"]")
    WebElement menuBtn;
    @FindBy(xpath = "//*[@routerlink=\"request\"]")
    WebElement requestsMenuItem;
   // @FindBy(xpath = "//*[@class=\"leave-travels-add-button ng-star-inserted\"]")
   @FindBy(xpath = "//a[@class='leave-travels-add-button ng-star-inserted']")
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
    @FindBy(xpath = "//*[@placeholder=\"Leave End Date\"]")
    private WebElement leaveEndDate;


    public LeaveRequestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public String createRequest(String year, String day, String month) {

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
        System.out.println("Actual Result  is " + actualTxt);

        return actualTxt;
    }
}
