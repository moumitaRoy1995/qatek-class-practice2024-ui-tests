package youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        //name locator
        driver.findElement(By.name("search")).sendKeys("Mac");

        //id
        boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
        System.out.println(logoDisplayStatus);



        //link_text and partial_link_text
        //driver.findElement(By.linkText("Tablets")).click();
        //driver.navigate().back();

        //driver.findElement(By.linkText("Software")).click();
        //driver.findElement(By.partialLinkText("Soft")).click();
        //driver.navigate().back();
        //together both is not working?

        //multiple web element using class name
        List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
        System.out.println("Total number of header links: " + headerLinks.size());

        //find all link of a webpage using Tag name <a>
       List<WebElement> links = driver.findElements(By.tagName("a"));
       System.out.println("Total number of links: " + links.size());

        //total number of images using tag name
       List<WebElement> images = driver.findElements(By.tagName("img"));
       System.out.println("Total number of images: " + images.size());





    }
}
