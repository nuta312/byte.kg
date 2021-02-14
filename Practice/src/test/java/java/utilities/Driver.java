package java.utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    // controller class for our driver
    // the goal is to make sure that there is a SINGLE driver instance running
    //SINGLETON pattern --> this means creating a class that ensure that
    // only one instance of the object can be created can exist at a time

    private Driver(){}; // will not allow anyone to create a driver directly

    private static WebDriver driver;

    // 1st method - creating a driver depending on the browser specified in config.properties
    public static WebDriver getDriver(){
        if (driver ==null){
            //we will create a new driver instance here and assign it to our driver variable

            switch (ConfigsReader.getProperty("browser").toLowerCase()){
//                case "chrome":
//                 driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
//                    break;
                case "firefox":
                   driver = FireFoxWebDriver.loadFireFoxDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                case "safari":
                    driver = SafariWebDriver.loadSafariDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                default:
                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
            }
        }
        return driver;
    }
    //2nd method -- will close the driver if it is running
    public static void closeDriver(){
        if (driver == null) return;

        try {
            driver.close();
            driver.quit();
            driver= null;
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
