package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath="//*[@placeholder=\"User Name\"]")
    private WebElement userNameTxt;
    @FindBy(xpath="//*[@placeholder=\"Password\"]")
    private WebElement passWordTxt;
    @FindBy(xpath = "//*[@class=\"loginBtn\"]")
    private WebElement loginBtn;
    @FindBy (xpath = "//*[@class=\"btn btn-primary mx-1\"]")
    private  WebElement cookyBtn;


    private WebDriverWait wait;


    public  LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 40);
    }

    public void Login(String username, String password) {

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(userNameTxt),
                ExpectedConditions.visibilityOf(passWordTxt),
                ExpectedConditions.visibilityOf(loginBtn)));


        this.userNameTxt.sendKeys(username);
        this.passWordTxt.sendKeys(password);
        this.cookyBtn.click();
        this.loginBtn.click();
    }

}
