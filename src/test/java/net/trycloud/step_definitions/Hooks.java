package net.trycloud.step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import net.trycloud.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before



    @After
    public void teardownScenario(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", scenario.getName());
        }


        Driver.closeDriver();
        //System.out.println("===Closing browser using cucumber @After");
        //System.out.println("===Scenario ended/ Take screenshot if failed");
    }

    //@BeforeStep

    //@AfterStep

}
