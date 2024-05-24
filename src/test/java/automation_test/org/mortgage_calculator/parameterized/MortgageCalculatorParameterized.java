package automation_test.org.mortgage_calculator.parameterized;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;
import utilities_qatek.ReadConfigFiles;
import utilities_qatek.SqlConnector;

import java.sql.ResultSet;

public class MortgageCalculatorParameterized {
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        driver = new ChromeDriver();
        LOGGER.info("---------Test name: Calculate Monthly Payment----------");
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateMonthlyPayment() throws Exception {
        String[] date = DateUtils.returnNextMonth();
        //String month = date[0];
        //String year = date[1];
        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
        while (rs.next()) {
            new Home(driver)
                    .typeHomePrice(rs.getString("homevalue"))
                    .clickDownPaymentInDollar()
                    .typeDownPayment(rs.getString("downpayment"))
                    .typeLoanAmount(rs.getString("loanamount"))
                    .typeInterestRate(rs.getString("interestrate"))
                    .typeLoanTermYears(rs.getString("loanterm"))
                    .selectStartMonth(date[0])
                    .typeYear(date[1])
                    .typePropertyTax(rs.getString("propertytax"))
                    .typePmi(rs.getString("pmi"))
                    .typeHomeOwnerInsurance(rs.getString("homeownwerinsurance"))
                    .typeMonthlyHOA(rs.getString("monthlyhoa"))
                    .selectLoanType(rs.getString("loantype"))
                    .selectBuyOrRefinance(rs.getString("buyorrefi"))
                    .clickOnCalculateButton()
                    .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
        }

    }
        @AfterMethod
        public void browserCleanup ()
        {
            ActOn.browser(driver).closeBrowser();
            LOGGER.info("------------End Test: Calculate Monthly Payment------------");
        }
    }

