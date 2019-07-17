package se.iths.selenium.SeleniumAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.iths.selenium.assignment2OnlineStoreTest.WebDriverHelper;

public class TestSeleniumAutomation {

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
    public void testStaticDropDownBySelectClass() {

        driver.get("http://spicejet.com/");
       SeleniumAutomation sc = new SeleniumAutomation(driver);
        sc.currencySelection();
    }

    @Test
    public void testDynamicDropDown() throws InterruptedException {
        SeleniumAutomation sc = new SeleniumAutomation(driver);
        driver.get("https://www.skyscanner.se/");
        sc.passengersSelection();
    }

    @Test
    public void testDynamicdropDown() throws InterruptedException {
        SeleniumAutomation sc = new SeleniumAutomation(driver);
        sc.citySelectionByParentChildTechnique();
    }

    @Test
    public void testParentChildXpathTechnique(){
        SeleniumAutomation sc = new SeleniumAutomation(driver);
        sc.citySelectionByParentChildTechnique();
    }

    @Test
    public void testAutoSuggestiveDropDown() throws InterruptedException {
        SeleniumAutomation sc = new SeleniumAutomation(driver);
        sc.autoSuggestiveDropDown();
    }

    @Test
    public void testRadioButton(){
        new SeleniumAutomation(driver).radioButton();
    }

    @Test
    public void testRadioButtonWithIndexInSkyScannerWebSite(){
        new SeleniumAutomation(driver).radioButtonCheck();
    }

    // If there is no id given and there is common attribute value among radio buttons
    // then we can spy the radio buttons with following way.

    @Test
    public void testRadioButtonWithIndexInEchoEchoWebSite(){
        new SeleniumAutomation(driver).radioButtonEchoEchoWebSite();
    }

    @Test
    public void testAlertInMomondoWebSite() throws InterruptedException {
        new SeleniumAutomation(driver).momondoWebsiteAlert();
    }

    @Test
    public void testAlertHandeling(){
        new SeleniumAutomation(driver).javaAlertHandeling();
    }

    @Test
    //End to End testing of spicejet.com
    public void testCheckBoxHandelingAndEndToEndTesting() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        new SeleniumAutomation(driver).EndToEndTesting();
    }
}
