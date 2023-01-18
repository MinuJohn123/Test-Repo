package Pages;

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
    @FindBy(xpath = "//*[@class=\"mdi mdi-menu\"]")
    WebElement menuBtn;
    @FindBy(xpath = "//*[@routerlink=\"request\"]")
    WebElement requestsMenuItem;
    @FindBy(xpath = "//*[@class=\"leave-travels-add-button ng-star-inserted\"]")
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
    }

    public String createRequest(String year, String day, String month) {

        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menuBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(requestsMenuItem));
        requestsMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(addLeaveReqBtn));
        addLeaveReqBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(leaveStartDate));
        actions.moveToElement(leaveStartDate).click().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        actions.sendKeys(year).build().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        actions.sendKeys(day).build().perform();
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        leaveStartDate.sendKeys(Keys.ARROW_LEFT);
        actions.sendKeys(month).build().perform();


        wait.until(ExpectedConditions.elementToBeClickable(selectOptionDdl));
        selectOptionDdl.click();
        selectItemDdl.click();

        saveReqBtn.click();

        String actualTxt = alerTxt.getText();
        System.out.println("Actual Result is " + actualTxt);

        return actualTxt;
    }
}
