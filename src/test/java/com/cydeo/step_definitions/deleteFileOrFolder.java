package com.cydeo.step_definitions;

import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.DeletedFilePage;
import com.cydeo.pages.FilePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class deleteFileOrFolder {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    FilePage filePage=new FilePage();
    DeletedFilePage deletedFilePage=new DeletedFilePage();
    String textOfFile="";

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
    loginPage.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {

    dashBoardPage.clickModule(module); // Files

    }

    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {

        textOfFile=filePage.fileName.getText();
        BrowserUtils.sleep(3);
        filePage.fileName.click();
        BrowserUtils.sleep(4);
        filePage.actionIcon.click();
    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        BrowserUtils.sleep(4);
    filePage.option(string);
    }
    @When("the user clicks the {string} sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side(String string) {
        BrowserUtils.sleep(4);
    filePage.clickSubModule(string);
    }
    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {

        List<WebElement> eachText=deletedFilePage.eachDeleted;
        for (WebElement each : eachText) {
            Assert.assertEquals(each.getText(),textOfFile);

        }

    }
}

//step1 added
