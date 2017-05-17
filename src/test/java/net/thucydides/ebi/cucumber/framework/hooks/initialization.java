package net.thucydides.ebi.cucumber.framework.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

/**
 * Created by rakeshnbr on 05/12/2016.
 */
public class initialization extends PageObject{
    public static String downLoadDirectory;
    public static ScenarioHook scenarioHook;
    EnvironmentVariables environmentVariables;


    @Managed
    public WebDriver webdriver = getDriver();

    @Before("~@NoBrowser")
    public void prepareTest() throws Exception {
        try{
            getDriver().manage().window().setSize(new Dimension(1920,1080));
        }catch (Exception e){
            throw new Exception("ERROR: While Preparing for the Test");
        }
    }
}
