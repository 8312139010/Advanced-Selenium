package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

public class ActionsTest {

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
    public void actionsTest(){
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        //moves to some specific element e.g to text field write hello in capital
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        // this will right click on specific element.
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();

    }
}
