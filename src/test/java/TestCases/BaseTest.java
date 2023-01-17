package TestCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

public static WebDriver webDriver;
public static WebDriverWait webDriverWait;
    @BeforeSuite
    public  static void lunchApplication()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // initialize explicit wait
        webDriverWait = new WebDriverWait(webDriver, 60);
        loadPropertiesFile();

    }

       protected static void loadPropertiesFile() {
        // load property file (test.properties)
        Properties props = System.getProperties();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/test.properties"));
            props.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @AfterMethod
    public void takeScreenshotForFailingTests(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                //save current time
                String strDate=LocalDate.now().toString() +" " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm"));
                //initialize take screenshot class
                TakesScreenshot screenshot = (TakesScreenshot) webDriver;
                // select output file
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // create file in a specified directory
                FileUtils.copyFile(src, new File(System.getProperty("path.FailingScreenshots") + "/" + result.getName() +"_"+strDate+ ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot" + e.getMessage());
            }
        }
    }

    @AfterClass
    public static void closeBrowser() {
        // after each test class finish running quit the browser
        //webDriver.quit();
    }


}
