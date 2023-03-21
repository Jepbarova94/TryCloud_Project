package net.trycloud.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.LoginPage;
import net.trycloud.pages.LogoutPage;
import net.trycloud.utilities.ConfigurationReader;
import net.trycloud.utilities.Driver;
import org.junit.Assert;

public class Logout_StepDefinition {

    LogoutPage logoutPage = new LogoutPage();
    LoginPage loginPage = new LoginPage();


    @When("user is on dashboard")
    public void userIsOnDashboard() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        loginPage.usernameInputbox.sendKeys("Employee85");
        loginPage.pswInputbox.sendKeys("Employee123");
        loginPage.loginBtn.click();
    }

    @When("user clicks profile dropdown")
    public void userClicksProfileDropdown() {

        logoutPage.dropDown.click();
        
    }

    @And("user clicks logout button")
    public void userClicksLogoutButton() {

        logoutPage.logOutBtn.click();
        
    }

    @Then("user is on login page")
    public void userIsOnLoginPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigurationReader.getProperty("web.url")));
    }

    @And("user clicks step back button")
    public void userClicksStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to dashboard page")
    public void userCanNotGoToDashboardPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigurationReader.getProperty("web.url")));
    }
}
