import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverProvider {
        private static final String APPIUM_SERVER_URL = "http://192.168.1.92:4723/wd/hub";
//    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        /**
         * Ustawienie adresu Appium
         */

        /**
         * Tworzenie i ustawianie Capabilitisów
         * */

//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);            /**  Musi być bo inaczej krzyczy:"Appium's IosDriver does not support Xcode version 13.1. Apple has deprecated UIAutomation. Use the "XCUITest" automationName capability instead."*/
//
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");                                 /**Dla Real devices yu może być cokolwiek ale musi być, dla symulatora już musi być podane konkretna nazwa symulatora*/
//
//       desiredCapabilities.setCapability(MobileCapabilityType.UDID, "f2542fa89aa1844d1e31f6973a119db0737c4f2c");   /**  Dla RealDevicea MUSI być ustawione, bo bez appium szuka symulatora*/
//
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/UIKitCatalog.app");
////        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/IdeaProjects/ios-uicatalog/UIKitCatalog/UIKitCatalog.app");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
//
////        desiredCapabilities.setCapability("useNewWDA", "false");
////        desiredCapabilities.setCapability("usePrebuiltWDA", "true");
//
//        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120000");
//
//        AppiumDriver iosDriver = new IOSDriver(appiumUrl,desiredCapabilities);
//
//
//
//        Thread.sleep(50000);
//        System.out.println("End");




/*
 desiredCapabilities.setCapability("useNewWDA", "false");
        desiredCapabilities.setCapability("usePrebuiltWDA", "true");
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "f2542fa89aa1844d1e31f6973a119db0737c4f2c");
//        desiredCapabilities.setCapability("autoAcceptAlerts", true);
//        desiredCapabilities.setCapability("autoDismissAlerts", true);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "12000");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
        desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, "50000");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/Millennium-QUA-DEV-4.61.0-RC2.ipa");



*/

//     desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/ApiDemos-debug.apk");

    }

    public static URL getAppiumURL() {
        try {
            URL appiumUrl = new URL(APPIUM_SERVER_URL);
            return appiumUrl;

        } catch (MalformedURLException ml) {

            System.out.println("Adress appium nieprawidłowy");

        }
        return null;
    }

    public static WebDriver crateAndroidDriver(String deviceName)  {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceName);

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Programowanie\\Locators\\ApiDemos-debug.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/ApiDemos-debug.apk");
        desiredCapabilities.setCapability("noSign", true);
        desiredCapabilities.setCapability("skipDeviceInitialization", true);
        desiredCapabilities.setCapability("skipServerInstallation", true);
        desiredCapabilities.setCapability("skipUnlock", true);


        AppiumDriver <MobileElement> androidDriver = new AndroidDriver<>(getAppiumURL(), desiredCapabilities);
        System.out.println("Driver created for device : " + deviceName);

        return androidDriver;

    }

    public static WebDriver crateiOSDriver(String deviceName)  {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);            /**  Musi być bo inaczej krzyczy:"Appium's IosDriver does not support Xcode version 13.1. Apple has deprecated UIAutomation. Use the "XCUITest" automationName capability instead."*/
//
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);                                 /**Dla Real devices yu może być cokolwiek ale musi być, dla symulatora już musi być podane konkretna nazwa symulatora*/

//       desiredCapabilities.setCapability(MobileCapabilityType.UDID, "f2542fa89aa1844d1e31f6973a119db0737c4f2c");   /**  Dla RealDevicea MUSI być ustawione, bo bez appium szuka symulatora*/

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/UIKitCatalog.app");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/IdeaProjects/ios-uicatalog/UIKitCatalog/UIKitCatalog.app");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");

//        desiredCapabilities.setCapability("useNewWDA", "false");
        desiredCapabilities.setCapability("usePrebuiltWDA", "true");
//        desiredCapabilities.setCapability("WDALocalPort", "8101");

        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");

        AppiumDriver iosDriver = new IOSDriver(getAppiumURL(), desiredCapabilities);
        System.out.println("Driver created for device : " + deviceName);

        return iosDriver;

    }

}