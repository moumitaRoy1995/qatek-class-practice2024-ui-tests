package automation_test;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities_qatek.DriverFactory;
import utilities_qatek.ReadConfigFiles;

public class BaseClass {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    String testCaseName = String.format("------Test: %s------", this.getClass().getName());
    String endTestCaseName = String.format("----End Test %s-----", this.getClass().getName());

    @BeforeClass
    public void addThread()
    {
        ThreadContext.put("threadName", this.getClass().getName());
        driver = DriverFactory.getInstance().getDriver();

    }
    @BeforeMethod
    public void browserInitialization()
    {
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        LOGGER.info(testCaseName);
        LOGGER.debug("Opening the URL: " + browserUrl);
        ActOn.browser(driver).openBrowser(browserUrl);
    }
    @AfterMethod
    public void browserCleanup()
    {
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(endTestCaseName);
    }
}
