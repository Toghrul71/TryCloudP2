package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    public void clickModule(String module){
        WebElement moduleName=Driver.getDriver().findElement(By.xpath("//a[@aria-label='"+module+"']"));
        BrowserUtils.sleep(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(moduleName).perform();
         moduleName.click();

    }
}
