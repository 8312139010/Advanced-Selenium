package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

import java.util.Iterator;
import java.util.Set;

public class ParentChildWindowsHandeling {

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
    public void testParentChildWindows(){
        driver.get("https://accounts.google.com/ServiceLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com" +
                "%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        driver.findElement(By.xpath("//*[@id=\"initialView\"]/footer/ul/li[3]/a")).click();

        System.out.println("Before Switching");

        System.out.println(driver.getTitle());
        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        System.out.println("After Switching to Child Window");

        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/div[3]/c-wiz/div/div/p[1]/a")).click();

        System.out.println("Switching backk to Parent Window");

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
    }

    @Test
    public void assignmentTestWindows(){

        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parentId = it.next();
        String childId = it.next();

        System.out.println("Switch to Child Window");

        driver.switchTo().window(childId);
        Assert.assertEquals("New Window", driver.findElement(By.xpath("/html/body/div/h3")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div/h3")).getText());
        System.out.println("Title of Child Window is "+driver.getTitle());

        System.out.println("Switch back to Parent window");

        driver.switchTo().window(parentId);
        Assert.assertEquals("Opening a new window", driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
        System.out.println("Title of parent Window is "+driver.getTitle());

    }
}
