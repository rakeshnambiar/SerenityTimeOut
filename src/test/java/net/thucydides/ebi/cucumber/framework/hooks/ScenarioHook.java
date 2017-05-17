package net.thucydides.ebi.cucumber.framework.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by rakeshnbr on 04/01/2017.
 */
public class ScenarioHook {

    public static Scenario scenario;
    EnvironmentVariables environmentVariables;

    @Before(order = 1)
    public void KeepSceario(Scenario scenario) throws Exception {
        try {
            ScenarioHook.scenario = scenario;
            this.setScenario(scenario);
        }catch (Exception e){}
    }


    public void setScenario(Scenario scenario) {
        ScenarioHook.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }


}
