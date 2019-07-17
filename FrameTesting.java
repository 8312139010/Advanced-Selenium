package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

public class FrameTesting {

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
    public void frameDragAndDropFunctionalities(){
        driver.get("http://jqueryui.com/droppable/");
        //following will switch to frame by WebElement
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        // following will help us to find, how many frames are present on this web page.
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //following will switch to frame by index
        driver.switchTo().frame(0);

        // As we know to use the drag and drop functionality we use Actions class
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        //following code will switch out of frame
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/ul/li[2]/a")).click();
        WebElement confirmText = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        System.out.println(confirmText.getText());

        Assert.assertEquals("Create targets for draggable elements.", confirmText.getText());

    }
}
