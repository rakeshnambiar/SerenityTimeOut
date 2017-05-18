package net.thucydides.ebi.cucumber.framework.hooks;

import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;



/**
 * Created by rakeshnbr on 02/05/2017.
 */
public class CustomChromeDriver implements DriverSource {
    public static String downLoadDirectory;
    private static WebDriver webDriver;

    //@Override
    public WebDriver newDriver(){
        try{
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

                //chromePrefs.put("download.default_directory", downLoadDirectory);
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
                chromePrefs.put("download.prompt_for_download", false);
                chromePrefs.put("pdfjs.disabled", true);
                chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--disable-extensions");
                options.addArguments("--test-type");


                options.setExperimentalOption("prefs", chromePrefs);

                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);

                webDriver = new ChromeDriver(ChromeDriverService.createDefaultService(), cap);
        }catch (Exception e){
            throw new Error(e);
        }
        return webDriver;
    }

    //@Override
    public boolean takesScreenshots() {
        return true;
    }

}
