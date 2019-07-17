package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

import java.util.concurrent.TimeUnit;

public class Synchronization {

    WebDriver driver;

    @Before
    public void setUpBrowser() {
        driver = WebDriverHelper.createWebDriver();
    }

    @After
    public void closeBrowser() {
        //driver.close();
    }

    @Test
    public void implicitAndExplicitWaitTesting() {

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");

        driver.findElement(By.xpath("//a[@class='change-lob']")).click();
        driver.findElement(By.id("A-destination")).sendKeys("new");
        driver.findElement(By.id("A-destination")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("A-destination")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='A-fromDate']")).click();
        driver.findElement(By.xpath("//input[@id='A-fromDate']")).sendKeys(Keys.ENTER);

        // Explicit wait
        WebDriverWait d = new WebDriverWait(driver, 20);
        d.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"activity183589\"]/a")));
        driver.findElement(By.xpath("//*[@id=\"activity183589\"]/a")).click();

    }

    @Test
    public void waitAssignment(){
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        WebElement link = driver.findElement(By.xpath("//*[@id=\"content\"]/a[2]"));
        link.click();

        // Explicit wait

        WebDriverWait d = new WebDriverWait(driver, 10);
        d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/a[2]")));

        System.out.println(driver.findElement(By.id("results")).getText());

    }
}
