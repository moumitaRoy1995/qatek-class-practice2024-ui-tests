package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home extends NavigationBar{
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By RadioButtonField = By.xpath("//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmountField = By.id("loanamt");
    private final By InterestRateInputField = By.name("param[interest_rate]");
    private final By LoanTermInputField =By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HoiInputField = By.id("hoi");
    private final By HoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By BuyOrRefinanceDropDown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    private final By TotalMonthlyPayment = By.xpath("//div[@class='repayment-block']/div/div[contains(., 'Total Monthly Payment')]//following-sibling::h3");
    private static final Logger LOGGER = LogManager.getLogger(Home.class);
    public Home(WebDriver driver)
    {
        super(driver);
    }
    public Home typeHomePrice(String value)
    {
        LOGGER.debug("Type Home Value: " + value);
        //Enter home value "300000"
        ActOn.element(driver,HomeValueInputField).setValue(value);
        return this;
    }
    public Home clickDownPaymentInDollar()
    {
        LOGGER.debug("Clicking on the $ Radio Button");
        //Click on the radio button $
        ActOn.element(driver,RadioButtonField).click();
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug("Type Down Payment value: " + value);
        //Enter downPayment "60000"
        ActOn.element(driver,DownPaymentInputField).setValue(value);
        return this;
    }
    public Home typeLoanAmount(String value)
    {
        LOGGER.debug("Type Loan Amount Value: " + value);
        //Enter Loan amount "240000.00"
        ActOn.element(driver,LoanAmountField).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value)
    {
        LOGGER.debug("Typing the Interest Rate: " + value);
        //Enter interest Rate "3.0%"
        ActOn.element(driver,InterestRateInputField).setValue(value);
        return this;
    }
    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Typing the Loan Team Years: " + value);
        //Enter Loan term "30" years
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }
    public Home selectStartMonth(String month)
    {
        LOGGER.debug("Selecting the Start date Month: ");
        ActOn.element(driver,StartMonthDropDown).selectValue(month);
        return this;
    }
    public Home typeYear(String year)
    {
        LOGGER.debug("Typing the Loan start year: " + year);
        ActOn.element(driver, StartYearInputField).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value)
    {
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver,PropertyTaxInputField).setValue(value);
        return this;
    }
    public Home typePmi(String value)
    {
        LOGGER.debug("Typing Pmi: " + value);
        ActOn.element(driver,PmiInputField).setValue(value);
        return this;
    }
    public Home typeHomeOwnerInsurance(String value)
    {
        LOGGER.debug("Typing home owner insurance: " + value);
        ActOn.element(driver,HoiInputField).setValue(value);
        return this;
    }
    public Home typeMonthlyHOA(String value)
    {
        LOGGER.debug("Typing Hoa: " + value);
        ActOn.element(driver,HoaInputField).setValue(value);
        return this;
    }
    public Home selectLoanType(String value)
    {
        LOGGER.debug("Selecting Loan Type: " + value);
        ActOn.element(driver,LoanTypeDropDown).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefinance(String value)
    {
        LOGGER.debug("Selecting Buy or Refinance: " + value);
        ActOn.element(driver,BuyOrRefinanceDropDown).selectValue(value);
        return this;
    }
    public Home validateTitle(String expectedTitle)
    {
        LOGGER.debug("Validate the page title");
        String actualTitle = ActOn.browser(driver).captureTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "The title is failed to match");
        return this;
    }
    public Home clickOnCalculateButton()
    {
        LOGGER.debug("Clicking on Calculate Button");
        //Click on the Calculate Button
        ActOn.element(driver, CalculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment( String expectedMonthlyPayment )
    {
        LOGGER.debug("Validating Total Monthly payment is: " + expectedMonthlyPayment);
        ActOn.wait(driver,TotalMonthlyPayment).waitForElementToBeVisible();
        String actualMonthlyPayment = ActOn.element(driver,TotalMonthlyPayment).getTextValue();

        Assert.assertEquals(actualMonthlyPayment, expectedMonthlyPayment, "Total Monthly payment is failed to match");
        return this;
    }
}
