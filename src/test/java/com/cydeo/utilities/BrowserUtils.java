package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }


    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver ,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }
    public static void verifyUrlContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedTitle));
    }
    public static List<String> dropdownOptionsAsAstring(WebElement dropdownWebElement){
        Select select=new Select(dropdownWebElement);

        List<WebElement> actualOptionsAsWebelement=select.getOptions();
        List<String> actualStringOptions=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebelement) {
            actualStringOptions.add(each.getText());
        }
        return actualStringOptions;
    }
}
