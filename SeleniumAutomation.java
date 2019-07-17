package se.iths.selenium.SeleniumAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAutomation {

    WebDriver driver;

    public SeleniumAutomation(WebDriver driver) {

        this.driver = driver;

    }

    public void currencySelection() {
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        s.selectByValue("USD");
        s.selectByIndex(1);
        s.selectByVisibleText("INR");

    }

    public void passengersSelection() {
        driver.findElement(By.xpath
                ("//*[@id=\"CabinClassTravellersSelector_fsc-class-travellers-trigger__18yAY\"]/span")).click();
        int i = 1;
        while (i < 6) {
            driver.findElement(By.cssSelector
                    ("#cabin-class-travellers-popover > div > div > div:nth-child(4) > div > " +
                            "button:nth-child(3) > span > svg")).click();
            i++;
        }
        driver.findElement(By.cssSelector
                ("#cabin-class-travellers-popover > footer > button")).click(); //klar button
        String testText = driver.findElement(By.xpath
                ("//*[@id=\"CabinClassTravellersSelector_fsc-class-travellers-trigger__18yAY\"]/span"))
                .getText();

        Assert.assertEquals("6 resenärer, Economy", testText);
    }

    public void citySelectionByDynamicDropDownTechnique() throws InterruptedException {
        //driver.get("https://www.spicejet.com/");
        // City selection
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='ATQ']")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        Thread.sleep(2000);
        // Date selection
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[1]/td[3]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date2\"]")).click();//second date field
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[1]/a")).click();
    }

    public void citySelectionByParentChildTechnique(){
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //parent child xPath
        driver.findElement(By.xpath
                ("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='ATQ']")).click();
        driver.findElement(By.xpath
                ("(//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'])")).click();
    }

    public void autoSuggestiveDropDown() throws InterruptedException {

        driver.get("https://www.skyscanner.se/");
        WebElement source = driver.findElement(By.id("fsc-origin-search"));
        source.clear();
        source.sendKeys("STO");
        //This time wait is for testing purposes, otherwise can use implicit and explicit wait.
        Thread.sleep(2000);
        int i = 1;
        while(i<5){
            source.sendKeys(Keys.ARROW_DOWN);
            i++;
        }
        source.sendKeys(Keys.ENTER);

        WebElement destination = driver.findElement(By.id("fsc-destination-search"));
        destination.clear();
        destination.sendKeys("ISL");
        Thread.sleep(2000);
        int j = 1;
        while(j<5){
            destination.sendKeys(Keys.ARROW_DOWN);
            j++;
        }
        destination.sendKeys(Keys.ENTER);
    }

    public void radioButton(){
        driver.get("https://www.skyscanner.se/");
        driver.findElement(By.xpath("//input[@id='fsc-trip-type-selector-one-way']")).click();
    }

    public void radioButtonCheck(){
        driver.get("https://www.skyscanner.se/");
        System.out.println(driver.findElements(By.xpath("//input[@name='trip-type-selector']")).size());
      int count = driver.findElements(By.xpath("//input[@name='trip-type-selector']")).size();

        for (int i = 0; i < count ; i++) {
            driver.findElements(By.xpath("//input[@name='trip-type-selector']")).get(1).click();
        }
    }

    // If there is no id given and there is common attribute value among radio buttons
    // then we can spy the radio buttons with following way.

    public void radioButtonEchoEchoWebSite(){
        driver.get("http://www.echoecho.com/htmlforms10.htm");
        int count = driver.findElements(By.xpath("//input[@name='group1']")).size(); // return how many radio buttons are in the section.
        for (int i = 0; i < count ; i++) {
            driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
        }
        for (int j = 0; j < count ; j++) {
            System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(j).getAttribute("value"));
           String text = driver.findElements(By.xpath("//input[@name='group1']")).get(j).getAttribute("value");
           if (text.equalsIgnoreCase("cheese")){
               driver.findElements(By.xpath("//input[@name='group1']")).get(j).click();
           }
        }
    }

    public void momondoWebsiteAlert() throws InterruptedException {
        driver.get("https://www.momondo.se/");
        driver.manage().window().maximize();
        driver.switchTo().alert();
        driver.switchTo().alert().accept();

       WebElement source = driver.findElement(By.xpath("//input[@id='HqD9-origin']"));
       source.clear();
       Thread.sleep(2000);
       source.sendKeys("sto");
       source.sendKeys(Keys.ARROW_DOWN);
       source.sendKeys(Keys.ENTER);
    }

    public void javaAlertHandeling(){
        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input")).click();
        System.out.println(driver.switchTo().alert().getText()); // return text mentioned on alert window.
        //driver.switchTo().alert().sendKeys("edit message"); if you want to send or edit message on alert window.
        driver.switchTo().alert().accept(); //if there are ok accept etc. buttons then use accept() and dismiss() for others.
    }

    public void testCheckBoxes(){
        System.out.println("Total no of checkboxes are "+
                driver.findElements(By.cssSelector("input[type='checkbox']")).size()); // will check how many checkboxes are present.
        int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

        Assert.assertEquals(6, count);

        //Following while loop will click on every checkbox
        int i = 1;
        while (i<count){
            driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
            i++;
        }
        //following code will return True or False, if student checkbox is selected or not.
        System.out.println("checkbox is not selected "+
                driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

        System.out.println("Following are the names of checkboxes");
        //Following for loop will click on specified checkbox only.
        for (int j = 0; j <count ; j++) {
            System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).getAttribute("name"));
            String text = driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).getAttribute("name");
            // this will click on student checkbox
            if(text.equalsIgnoreCase("ctl00$mainContent$chk_StudentDiscount")){
                driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).click();
            }
        }
        //following code will return True or False, if student checkbox is selected or not.
        System.out.println("checkbox is selected "+
                driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

        boolean test = driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected();

        Assert.assertTrue(test);
    }

    //End to end testing
    public void EndToEndTesting() throws InterruptedException {

        driver.manage().window().maximize();
        citySelectionByDynamicDropDownTechnique();
        //passengersSelection(); // Website has changed the passenger selection dynamic dropdown.
        currencySelection();
        testCheckBoxes();

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

    }

}
