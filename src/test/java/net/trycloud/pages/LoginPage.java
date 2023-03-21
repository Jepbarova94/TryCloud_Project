package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "user")
    public WebElement usernameInputbox;

    @FindBy(id = "password")
    public WebElement pswInputbox;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text() = '\n\t\t\tWrong username or password.\n\t\t']")
    public WebElement wrongUsernamePassword;



    @FindBy(xpath = "//img[@src=\"/core/img/actions/toggle.svg\"]")
    public WebElement showPassword;

    @FindBy(id = "lost-password")
    public WebElement forgotPswdBtn;

    @FindBy(id = "reset-password-submit")
    public WebElement resetPswdBtn;




}
