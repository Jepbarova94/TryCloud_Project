package net.trycloud.step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.LoginPage;
import net.trycloud.utilities.ConfigurationReader;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    @When("user enters valid username {string} into username inputbox")
    public void userEntersValidUsernameIntoUsernameInputbox(String username) {

        loginPage.usernameInputbox.sendKeys(username);
    }

    @And("user enters valid password {string} into password inputbox")
    public void userEntersValidPasswordIntoPasswordInputbox(String password) {

        loginPage.pswInputbox.sendKeys(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {

        loginPage.loginBtn.click();

    }

    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        Assert.assertTrue(ConfigurationReader.getProperty("dashboard.url").equals(Driver.getDriver().getCurrentUrl()));
    }

    @And("user hits ENTER key from the keyboard")
    public void userHitsENTERKeyFromTheKeyboard() {
        loginPage.pswInputbox.sendKeys(Keys.ENTER);
    }


    @When("user enters {string} into username inputbox")
    public void userEntersIntoUsernameInputbox(String invldUsrnm) {
        loginPage.usernameInputbox.sendKeys(invldUsrnm);
    }

    @And("user enters {string} into password inputbox")
    public void userEntersIntoPasswordInputbox(String invlPswd) {
        loginPage.pswInputbox.sendKeys(invlPswd);
    }


    @Then("user should see {string} message")
    public void userShouldSeeMessage(String message) {
        Assert.assertTrue(loginPage.wrongUsernamePassword.getText().equals(message));
    }


    @Then("user should see required message")
    public void userShouldSeeRequiredMessage() {
        if (loginPage.usernameInputbox.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.usernameInputbox.getAttribute("validationMessage"), "Please fill out this field.");
        }

        if (loginPage.pswInputbox.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.pswInputbox.getAttribute("validationMessage"), "Please fill out this field.");
        }

    }

    @Then("user sees password in a form of dots")
    public void userSeesPasswordInAFormOfDots() {
        Assert.assertTrue(loginPage.pswInputbox.getAttribute("type").equals("password"));
    }

    @And("user clicks show password button")
    public void userClicksShowPasswordButton() {
        loginPage.showPassword.click();
    }

    @Then("user sees password explicitly")
    public void userSeesPasswordExplicitly() {
        Assert.assertTrue(loginPage.pswInputbox.getAttribute("type").equals("text"));
    }

    @When("user clicks forgot password link")
    public void userClicksForgotPasswordLink() {
        loginPage.forgotPswdBtn.click();
    }

    @Then("user should see Reset password button")
    public void userShouldSeeResetPasswordButton() {
        loginPage.resetPswdBtn.isDisplayed();
    }

    @Then("user should see {string} on username placeholder")
    public void userShouldSeeOnUsernamePlaceholder(String pl1) {
        Assert.assertTrue(loginPage.usernameInputbox.getAttribute("placeholder").contains(pl1));
    }

    @Then("user should see {string} on password placeholder")
    public void userShouldSeeOnPasswordPlaceholder(String pl2) {
        Assert.assertTrue(loginPage.pswInputbox.getAttribute("placeholder").equals(pl2));
    }

    @When("user enters valid username {string} with empty spaces into username inputbox")
    public void userEntersValidUsernameWithEmptySpacesIntoUsernameInputbox(String usrnm) {
        loginPage.usernameInputbox.sendKeys(usrnm);
    }


}
