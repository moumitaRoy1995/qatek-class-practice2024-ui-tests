package automation_test.org.mortgage_calculator.parameterized;

import command_providers.ActOn;
import data.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities_qatek.ReadConfigFiles;


public class CalculateRealAprRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRealAprRateParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        driver = new ChromeDriver();
        LOGGER.info("---------Test Name: Calculate Real Apr---------");
        String browserUr = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUr);
    }

    @Test(dataProvider = "RealAprRates" , dataProviderClass = DataStore.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr) {
        new NavigationBar(driver)
                .mouseHoverToRate()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton()
                .validateRealAprRate(expectedApr);
    }

    @AfterMethod
    public void browserCleanup() {
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("---------End Test: Calculate Real Apr---------");
    }
}