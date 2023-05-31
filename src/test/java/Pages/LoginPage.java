package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage(){
        PageFactory.initElements(driver,this); //Initializing the web elements of the current page
    }

    //Page factory model approach by Selenium
    @FindBy(id="txtUsername")
     public WebElement userName;
    @FindBy(id="txtPassword")
     public WebElement passWord;

    @FindBy(id="btnLogin")
     public WebElement loginBtn;

    @FindBy(id="welcome")
     public WebElement welcomeIcon;

    @FindBy (xpath = "//a[text()='Logout']")
    public WebElement logOutLink;

}
