import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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

    public static AndroidDriver crateAndroidDriver(URL url, DesiredCapabilities capabilities) {

        AndroidDriver<MobileElement> androidDriver = new AndroidDriver<>(url, capabilities);
        System.out.println("Driver created for device : " + capabilities.getCapability("deviceName"));

        return androidDriver;

    }

    public static IOSDriver crateiOSDriver(URL url, DesiredCapabilities capabilities) {

        IOSDriver iosDriver = new IOSDriver(url, capabilities);
        System.out.println("Driver created for device : " + capabilities.getCapability("deviceName"));

        return iosDriver;

    }

}