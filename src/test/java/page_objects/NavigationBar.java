package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RateButton = By.linkText("Rates");
    private final By RealAprButton = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;

    public NavigationBar(WebDriver driver)
    {
        this.driver = driver;
    }
    public NavigationBar mouseHoverToRate()
    {
        LOGGER.debug("Mouse Hovering to Rate Link");
        ActOn.element(driver, RateButton).mouseHover();
        return this;
    }
    public RealApr navigateToRealApr()
    {
        LOGGER.debug("Clicking on the Real Apr link from the navigation Bar:");
        ActOn.element(driver,RealAprButton).click();
        return new RealApr(driver);
    }
    public Home navigateToHome()
    {
        LOGGER.debug("Navigating to the Home Page");
        ActOn.element(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}
