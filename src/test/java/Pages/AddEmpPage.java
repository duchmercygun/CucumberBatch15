package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmpPage extends CommonMethods {


    @FindBy(id="menu_pim_viewPimModule")
     public WebElement pimTab;
    @FindBy(id="menu_pim_addEmployee")
     public WebElement addEmployee;
    @FindBy(id="firstName")
     public WebElement firstNameBox;
    @FindBy(id="middleName")
   public WebElement middleNameBox;
    @FindBy(id="lastName")
     public WebElement lastNameBox;
    @FindBy(id="btnSave")
     public WebElement saveButton;
    @FindBy (id= "employeeId")
    public WebElement empIdLocator;

    public AddEmpPage(){
        PageFactory.initElements(driver,this);
    }

}
