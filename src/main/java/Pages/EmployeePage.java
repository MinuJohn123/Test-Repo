package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {

    public WebDriverWait wait;
    JavascriptExecutor js;
    private Actions actions;

    @FindBy(xpath = "//*[@class=\"mdi mdi-menu\"]")
    private WebElement homeMnu;

    @FindBy(xpath = "//*[@class=\"input-style ng-pristine ng-valid ng-touched\"]")
    private WebElement searchTxt;



    public EmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public void Search()
    {
        searchTxt.sendKeys("noha");
        wait.until(ExpectedConditions.elementToBeClickable(homeMnu));
        homeMnu.click();
    }



}
