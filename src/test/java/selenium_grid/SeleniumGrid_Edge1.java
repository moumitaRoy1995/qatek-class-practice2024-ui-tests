package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGrid_Edge1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Edge1.class);
    WebDriver driver;
    URL gridUrl;
    @Test
    public void executeInAwsDocker()
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        try
        {
            gridUrl = new URL("http://3.89.160.177:4444/wd/hub");
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        //firefoxOptions.addArguments("--remote-allow-origins=*");
        driver = new RemoteWebDriver(gridUrl, edgeOptions);
        driver.get("https://www.amazon.com/");
        LOGGER.info(driver.getTitle());
        driver.quit();
    }
}
