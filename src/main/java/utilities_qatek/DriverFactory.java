package utilities_qatek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    //Do not allow to initialize this class from outside.
    private DriverFactory()
    {
        //Do nothing -- Empty Constructor
    }
    private static final DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance()
    {
        return instance;
    }
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() ->
    {
        new ChromeDriver();
        return new ChromeDriver();
    });
    //call this method to get the driver object and launch the browser
    public WebDriver getDriver()
    {
        return driver.get();
    }
    //Quits the driver and closes the browser
    public void removeDriver()
    {
        getDriver().quit();
        driver.remove();
    }
}
