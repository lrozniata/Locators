import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

@Getter
public class Caps {

    public static DesiredCapabilities getAndroidCapWithAppPath(String deviceName) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceName);

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");

//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Programowanie\\Locators\\ApiDemos-debug.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Programowanie\\Locators\\com.mobeta.android.demodslv.apk");
//    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/ApiDemos-debug.apk");
        desiredCapabilities.setCapability("noSign", true);
        desiredCapabilities.setCapability("skipDeviceInitialization", true);
        desiredCapabilities.setCapability("skipServerInstallation", true);
        desiredCapabilities.setCapability("skipUnlock", true);
        return desiredCapabilities;

    }




   public static DesiredCapabilities getAndroidCapWithActivity(String deviceName) {

      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceName);
      desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

      desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

      desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

      desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

      desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

      desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
      desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
      desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.view.Buttons1");



//      desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Programowanie\\Locators\\ApiDemos-debug.apk");
//    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/ApiDemos-debug.apk");
      desiredCapabilities.setCapability("noSign", true);
      desiredCapabilities.setCapability("skipDeviceInitialization", true);
      desiredCapabilities.setCapability("skipServerInstallation", true);
      desiredCapabilities.setCapability("skipUnlock", true);
      return desiredCapabilities;

   }

    public static DesiredCapabilities getiOSCapWitchAppPath(String deviceName){

       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);            /**  Musi być bo inaczej krzyczy:"Appium's IosDriver does not support Xcode version 13.1. Apple has deprecated UIAutomation. Use the "XCUITest" automationName capability instead."*/
//
       desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);                                 /**Dla Real devices yu może być cokolwiek ale musi być, dla symulatora już musi być podane konkretna nazwa symulatora*/

//       desiredCapabilities.setCapability(MobileCapabilityType.UDID, "f2542fa89aa1844d1e31f6973a119db0737c4f2c");   /**  Dla RealDevicea MUSI być ustawione, bo bez appium szuka symulatora*/

       desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/UIKitCatalog.app");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/x355302/TestApp/Millennium.app");
//        desiredCapabilities.setCapability(MobilpeCapabilityType.APP, "/Users/x355302/IdeaProjects/ios-uicatalog/UIKitCatalog/UIKitCatalog.app");
       desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");

//        desiredCapabilities.setCapability("useNewWDA", "true");
       desiredCapabilities.setCapability("useNewWDA", "false");

//        desiredCapabilities.setCapability("usePrebuiltWDA", "false");
       desiredCapabilities.setCapability("usePrebuiltWDA", "true");

       desiredCapabilities.setCapability("WDALocalPort", "8101");

       desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");
       desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, "300000");
       return desiredCapabilities;
    }



}
