package java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "txtUsername")
    public WebElement usernameInputFiled;

    @FindBy(id = "txtPassword")
    public WebElement passwordInputFiled;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    public void loginToApp(String username,String password){
        usernameInputFiled.sendKeys(username);
        passwordInputFiled.sendKeys(password);
        loginButton.click();
    }

}
