package java.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.concurrent.TimeUnit;

public class SafariWebDriver {

    public static WebDriver loadSafariDriver(boolean headless) {

        SafariOptions options = new SafariOptions();
        SafariDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        return driver;
    }
}
