package java.test_pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.pages.DashboardPage;
import java.pages.LeavePage;
import java.pages.LoginPage;
import java.utilities.ConfigsReader;
import java.utilities.Driver;


public class TestLoginToApp {


    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void testLogin(){
        Driver.getDriver().navigate().to(ConfigsReader.getProperty("baseUrl"));

        LoginPage loginPage = new LoginPage();
//        loginPage.usernameInputFiled.sendKeys(ConfigsReader.getProperty("username"));
//        loginPage.passwordInputFiled.sendKeys(ConfigsReader.getProperty("password"));
//        loginPage.loginButton.click();
        loginPage.loginToApp(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
        DashboardPage dashboard = new DashboardPage();
        Assert.assertTrue(dashboard.welcomeText.getText().contains(ConfigsReader.getProperty("username")));

        dashboard.assignLeaveButton.click();

        LeavePage leavePage = new LeavePage();
        leavePage.employeeNameInputField.sendKeys("Fiona Grace");
    }
    
}
