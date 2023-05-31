package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        //WebElement empIdTextBox = driver.findElement(By.id("empsearch_id"));
        sendText(empSearchPage.empIdTextBox, ConfigReader.getPropertyValue("empId"));
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
       // WebElement searchButton = driver.findElement(By.id("searchBtn"));
        doClick(empSearchPage.searchButton);

    }

    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");

    }

    @When("user select Job title")
    public void user_select_job_title() {

      // WebElement jobTitleDropDown = driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(empSearchPage.jobTitleDropDown, "Singer");

        // WebElement empStatus = driver.findElement(By.id("empsearch_employee_status"));
        //selectByOptions(empStatus, "Active");

        // WebElement includeDdl = driver.findElement(By.id("empsearch_termination"));
        // selectByOptions(includeDdl, "Current and Past Employees");

    }
    //@When("Close the browser")
   // public void close_the_browser() {
       // closeBrowser();
   // }

}