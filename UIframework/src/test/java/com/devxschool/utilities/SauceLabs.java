package com.devxschool.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabs {



    public static final String URL = "https://nutaQA:84491158bfba4e1692a9fbca9cbb201e@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    public static WebDriver loadSauceLabs(){

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.15");

        WebDriver driver = null;
        try {
             driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }
}
