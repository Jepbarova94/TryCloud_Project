package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//img[@width=\"32\"]")
    public WebElement dropDown;

    @FindBy(xpath = "//a[contains(@href, \"w\")]")
    public WebElement logOutBtn;


}
