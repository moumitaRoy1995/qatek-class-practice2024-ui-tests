package page_objects;

import command_providers.ActOn;
import command_providers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealApr extends NavigationBar{
    private final By HomePriceInputValue = By.name("HomeValue");
    private final By DownPaymentInputValue = By.name("DownPayment");
    private final By RadioButtonSelect = By.id("DownPaymentSel0");
    private final By InterestInputValue = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By AprRateValuePath = By.xpath("//strong[text()='Actual APR:']/parent::td/following-sibling::td/strong");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);
    public RealApr(WebDriver driver)
    {
        super(driver);
    }
    public RealApr waitForPageToLoad()
    {
        LOGGER.debug("Waiting for Real APR page to load");
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealApr typeHomePrice(String value){
        //Enter home price
        LOGGER.debug("Typing Home Value: " + value);
        ActOn.element(driver,HomePriceInputValue).setValue(value);
        return this;
    }
    public RealApr typeDownPayment(String value)
    {
        LOGGER.debug("Typing Down Payment Value: " + value);
        //Enter value for Down Payment "15000"
        ActOn.element(driver,DownPaymentInputValue ).setValue(value);
        return this;
    }
    public RealApr clickDownPaymentInDollar()
    {
        LOGGER.debug("Click on the $ for Down Payment");
        ActOn.element(driver, RadioButtonSelect).click();
        return this;
    }
    public RealApr typeInterestRate(String value)
    {
        LOGGER.debug("Typing InterestRate Value: " + value);
        ActOn.element(driver,InterestInputValue).setValue(value);
        return this;
    }
    public RealApr clickOnCalculateButton()
    {
        //Click on calculate Button
        LOGGER.debug("Clicking on Calculate Button");
        ActOn.element(driver,CalculateButton).click();
        return this;
    }
    public RealApr validateRealAprRate(String expectedValue)
    {
        LOGGER.debug("Validate the Real Apr rate is: " + expectedValue);
        String actualAprRate = ActOn.element(driver,AprRateValuePath).getTextValue();
        Assert.assertEquals(actualAprRate,expectedValue);
        return this;
    }
}
