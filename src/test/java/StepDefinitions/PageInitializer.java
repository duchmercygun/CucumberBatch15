package StepDefinitions;

import Pages.AddEmpPage;
import Pages.EmpSearchPage;
import Pages.LoginPage;

public class PageInitializer {

    //This class will manage the object creation of different page objects in our framework
    //Instead of calling the page objects again, this class will take good care of the step.

    public static LoginPage login;
    public static AddEmpPage addEmpPage;
    public static EmpSearchPage empSearchPage;
    public static void initializePageObject(){

        login =new LoginPage();
        addEmpPage = new AddEmpPage();
        empSearchPage = new EmpSearchPage();


    }
}
