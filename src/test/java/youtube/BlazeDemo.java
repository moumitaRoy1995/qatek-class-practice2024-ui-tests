package youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BlazeDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Total number of links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links is: " + links.size());
        Thread.sleep(6000);

        //total number of images
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images: " + images.size());
        Thread.sleep(5000);

        //Click product link
        driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
        Thread.sleep(5000);
    }
}
