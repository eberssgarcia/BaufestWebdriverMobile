package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MobileDriverManager {

    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void setDriver(AppiumDriver<MobileElement> driver) {
        MobileDriverManager.driver = driver;
    }

    public static void setMobileDriver() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "Galaxy S9");
        desiredCapabilities.setCapability("app", "C:/Android/BaufestChallengeAndroid/app/Android-NativeDemoApp-0.4.0.apk");
        desiredCapabilities.setCapability("udid", "514d563532593398");

        try {
            String os = desiredCapabilities.getCapability("platformName").toString();

            switch (os.toUpperCase(Locale.ROOT)) {
                case "ANDROID":
                    desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
                    desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
                    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub/"), desiredCapabilities);
                    break;
                case "IOS":
                    driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub/"), desiredCapabilities);
                    break;
                default:
                    Logger.getLogger(MobileDriverManager.class.getName()).log(Level.WARNING, "Sistema operativo mobile no soportado >>> {0}", os);
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            setDriver(driver);
        } catch (MalformedURLException malformedURLException) {
            Logger.getLogger(MobileDriverManager.class.getName()).log(Level.WARNING, "Ocurrio un error con la URL del servidor de Appium");
        }
    }

    public static void quitDriver() {
        driver.quit();
    }


}
