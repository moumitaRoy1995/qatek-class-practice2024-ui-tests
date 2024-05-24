package youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*test cases
1)Launch browser (chrome)
2)Open URL http://demo.opencart.com/
3)Validate title should be "Your Store"
4) close browser
 */
public class FirstTestCase {
    public static void main(String[] args)
    {
        //1)Launch browser (chrome)
        //ChromeDriver driver2 = new ChromeDriver();
        //WebDriver driver2 = new ChromeDriver();
        //WebDriver driver2 = new EdgeDriver();
        WebDriver driver2 = new FirefoxDriver();

        //2)Open URL http://demo.opencart.com/
        driver2.get("http://demo.opencart.com/");

        //3)Validate title should be "Your Store"
        String act_title = driver2.getTitle();
        if(act_title.equals("Your Store"))
        {
            System.out.println("Test Pass");
        }
        else
        {
            System.out.println("Test Fail");
        }

        //4) close browser
        //driver2.close();
        //driver2.quit();
    }
}