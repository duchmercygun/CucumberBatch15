package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtils;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {


    @When("user click on PIM option")
    public void user_click_on_pim_option() {
       // WebElement pimTab = driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmpPage.pimTab);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        //WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmpPage.addEmployee);
    }

    @When("user enters firstname, middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        //WebElement firstNameBox = driver.findElement(By.id("firstName"));
        sendText(addEmpPage.firstNameBox, ConfigReader.getPropertyValue("firstname"));

       // WebElement middleNameBox = driver.findElement(By.id("middleName"));
        sendText(addEmpPage.middleNameBox, ConfigReader.getPropertyValue("middlename"));

       // WebElement lastNameBox = driver.findElement(By.id("lastName"));
        sendText(addEmpPage.lastNameBox, ConfigReader.getPropertyValue("lastname"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       // WebElement saveButton = driver.findElement(By.id("btnSave"));
        Assert.assertTrue(addEmpPage.saveButton.isDisplayed());
        System.out.println("My assertion is returning true");
        doClick(addEmpPage.saveButton);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
       sendText(addEmpPage.firstNameBox, fname);
       sendText(addEmpPage.middleNameBox, mname);
       sendText(addEmpPage.lastNameBox, lname);
    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id = addEmpPage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: " + GlobalVariables.emp_id);
    }
    @When("user click on the save button")
    public void user_click_on_the_save_button() {
        doClick(addEmpPage.saveButton);
    }
    @When("query information in backend")
    public void query_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"
                + GlobalVariables.emp_id+"'"; //to store the table coming from db, we used global variable
        GlobalVariables.tableData = DBUtils.getListOfMapsFromRset(query);
    }
    @Then("verify the results from front end and backend")
    public void verify_the_results_from_front_end_and_backend() {
        //now, from all these values we need to compare one by one value
        String firstNameFromDB = GlobalVariables.tableData.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB = GlobalVariables.tableData.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);

        //adding assertions
        Assert.assertEquals(firstNameFromDB, "nesha");
        Assert.assertEquals(lastNameFromDB, "standard");
        System.out.println("My assertion has passed my test case");

    }


}