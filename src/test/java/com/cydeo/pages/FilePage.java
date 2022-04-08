package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage {
    public FilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void option(String string){
        Driver.getDriver().findElement(By.xpath("(//span[.='"+string+"'])[1]")).click();
    }

    @FindBy(xpath = "//label[contains (@for, 'select-files')]")
    public WebElement fileName;

    @FindBy(xpath = "//span[@class='icon icon-more']")
    public WebElement actionIcon;

    public void clickSubModule(String subModuleName){
        Driver.getDriver().findElement(By.xpath("//a[.='"+subModuleName+"']")).click();
    }

}
