package automation_test.com.php_travel;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities_qatek.ScreenCapture;

public class PhpTravel {
    WebDriver driver;
    @BeforeMethod
    public void browserInitialization()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        ActOn.browser(driver).openBrowser("https://phptravels.com/");
    }

    @Test
    public void verifyHomePageTitle() {

        String expectedTitle = "PHPTRAVELS Best Open Source PHP Booking Software";
        String actualTitle = ActOn.browser(driver).captureTitle();
        Assert.assertEquals(actualTitle, expectedTitle);



    }
    @AfterMethod
      public void browserCleanup(ITestResult result)
        {
            if( result.getStatus() == ITestResult.FAILURE){
                //Screenshot
                ScreenCapture.getScreenShot(driver);
            }
         ActOn.browser(driver).closeBrowser();
        }
}