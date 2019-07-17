package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Assignment2 {

    WebDriver driver;

    @Before
    public void setUpBrowser(){
        //driver = WebDriverHelper.createWebDriver();
    }

    @After
    public void closeBrowser(){
        //driver.close();
    }

    @Test
    public void assignment2Testing() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.cleartrip.com/");
        //driver.manage().window().maximize();

        System.out.println(driver.findElements(By.xpath("//input[@class='tripType']")).size());

        //This following code will click on RoundTrip radio button

        int count = driver.findElements(By.xpath("//input[@class='tripType']")).size();//use attribute value which is common in all radio buttons
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.xpath("//input[@class='tripType']")).get(i).getAttribute("value");
            if (text.equals("RoundTrip"))
            driver.findElements(By.xpath("//input[@class='tripType']")).get(i).click();
        }

       /* WebElement source = driver.findElement(By.id("FromTag"));
        source.clear();
        source.sendKeys("sto");

        int i=1;
        while (i<2){
            source.sendKeys(Keys.ARROW_DOWN);
            i++;
        }
        source.sendKeys(Keys.ENTER);

        WebElement destination = driver.findElement(By.id("ToTag"));
        destination.clear();
        destination.sendKeys("isl");

        for (int j = 1; j <2 ; j++) {
            destination.sendKeys(Keys.ARROW_DOWN);
        }
        destination.sendKeys(Keys.ENTER);*/

       driver.findElement(By.id("DepartDate")).click();

        driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]"));

        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[4]/a")).click();

        Select s = new Select(driver.findElement(By.xpath("//select[@id='Adults']")));
        s.selectByVisibleText("2");

        Select ss = new Select(driver.findElement(By.xpath("//select[@id='Childrens']")));
        ss.selectByIndex(2);

        Select sss = new Select(driver.findElement(By.cssSelector("#Infants")));
        sss.selectByValue("1");

        //driver.findElement(By.cssSelector("#SearchBtn")).click();
    }
}
