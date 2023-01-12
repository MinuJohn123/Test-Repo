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



}
