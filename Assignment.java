package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

import java.util.concurrent.TimeUnit;

public class Assignment {

    WebDriver driver;

    @Before
    public void setUpBrowser(){
        driver = WebDriverHelper.createWebDriver();
    }

    @After
    public void closeBrowser(){
        //driver.close();
    }

    @Test
    public void testCheckBox() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        boolean testCheckBoxIsChecked = driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
        Assert.assertEquals(true, testCheckBoxIsChecked);
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        boolean testCheckBoxIsUnChecked = driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
        Assert.assertFalse(testCheckBoxIsUnChecked);

        System.out.println("Total no of checkboxes are "+driver.findElements(By.xpath("//input[@type='checkbox']")).size());

    }
}
