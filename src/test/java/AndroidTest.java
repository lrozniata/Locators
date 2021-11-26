import Devices.AndroidDevice;
import components.pageObject.Android.MainScreen;
import components.pageObject.Android.Views.Buttons;
import components.pageObject.Android.WifiPage;
import components.pageObject.Android.dragdrop.BasicUsage;
import components.pageObject.Android.dragdrop.DrragDropMainScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.java.Log;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.TestResult;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Log
public class AndroidTest {

    @Test
    public void waity() throws InterruptedException {
        StopWatch watch = new StopWatch();
        MainScreen mainScreen = new MainScreen(DriverProvider.crateAndroidDriver(Appiums.LOCAL_APPIUM, Caps.getAndroidCapWithAppPath(AndroidDevice.HUAWEI20)));
        mainScreen.getDriver().manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

        WifiPage wifiPage = mainScreen.clickPreferences().clickPreferencesDependecies();
        AndroidDriver driver = (AndroidDriver) mainScreen.getDriver();

        AndroidElement checkBox = wifiPage.getCheckButtonWifi();

        WebDriverWait wait = new WebDriverWait(driver, 7);

        try {
            wait.until(ExpectedConditions.attributeToBe(checkBox, "checked", "true"));

        } catch (TimeoutException t) {
            wifiPage.getCheckButtonWifi().click();

        }

        driver.closeApp();

//        System.out.println("Re you there? " + until);
    }

    @Test
    public void wspolrzedne() {

        AndroidDriver androidDriver = DriverProvider.crateAndroidDriver(Appiums.LOCAL_APPIUM, Caps.getAndroidCapWithActivity(AndroidDevice.HUAWEI20));
        Buttons buttons = new Buttons(androidDriver);

//
        Point point = buttons.btnNormal.getLocation();   /** Zwraca punkt lewego górnego rogu kontrolki*/

        System.out.println(point);
        point.x = 13;
        System.out.println(point);
        point.move(200, 300);  //nadpisze współżedne punktu
        point.moveBy(20, 45);  // zwróci nowy punkt

//
//
////
//
//        Coordinates coordinates=buttons.btnNormal.getCoordinates();
//
//
//        System.out.println(coordinates.onPage());
//        System.out.println(coordinates.inViewPort());
//
        Rectangle rectangle = buttons.btnNormal.getRect();

        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

        rectangle.getDimension();
        rectangle.getWidth();
        rectangle.getHeight();

        rectangle.setX(5);
        rectangle.setY(100);
        rectangle.setWidth(400);
        rectangle.setHeight(500);

        Point point1 = buttons.btnNormal.getCenter();

        String deviceScreenSizeFromCapabilities = (String) androidDriver.getCapabilities().getCapability("deviceScreenSize");

        Dimension deviceDimension = androidDriver.manage().window().getSize();

        System.out.println("deviceScreenSizeFromCapabilities " + deviceScreenSizeFromCapabilities);
        System.out.println("deviceDimension" + deviceDimension);

//        androidDriver.openNotifications();
//        androidDriver.closeApp();
//        androidDriver.close();

//

//        Dimension dimension = buttons.btnNormal.getSize();
//
//        System.out.println(dimension.width+" x "+ dimension.height);
//
//
//        System.out.println(dimension);

    }

    @Test
    public void touchActions() throws InterruptedException {

        AndroidDriver androidDriver = DriverProvider.crateAndroidDriver(Appiums.LOCAL_APPIUM, Caps.getAndroidCapWithActivity(AndroidDevice.HUAWEI20));
        Buttons buttons = new Buttons(androidDriver);

        Point buttonCenter = buttons.btnNormal.getCenter();
        Point buttonCorner = buttons.btnNormal.getLocation();

        TouchAction touchAction = new TouchAction(androidDriver);

//        for(int i=0;i<5;i++){
//            System.out.print("----------------------\n");
//
//            touchAction.press(PointOption.point(buttonCenter)).perform().moveTo(PointOption.point(buttonCorner)).release();
//
//            Thread.sleep(500);
//        }
//

/**NIE USUWAJ TO PONIZEJ FAJNIE DZIELI BUTTONA NA OBSZARY DO KLIKANIA*/
        AndroidElement btn = buttons.btnNormal;
        Rectangle btnRectangle = btn.getRect();
        int sektor = btnRectangle.getWidth() / 5;
        System.out.println(btnRectangle.getX());

        btnRectangle.setY((btnRectangle.y) + ((btnRectangle.height) / 2));

        for (int i = 1; i <= 5; i++) {
            btnRectangle.setX(btn.getLocation().x);
            btnRectangle.setX(btnRectangle.x + (i * sektor));
            System.out.println(btnRectangle.getX());

            Point npoint = new Point(btnRectangle.x - (sektor / 2), btnRectangle.y);

            touchAction.press(PointOption.point(npoint)).perform();
            Thread.sleep(1000);
        }
    }

    @Test
    public void dragDrop() throws InterruptedException {

        /**Start Appium z kodu*/

//        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
//                new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//                        .withAppiumJS(new File("C:\\Users\\wulff\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
//                        .withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
//                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE).usingPort(4723));
//
//        service.start();
//        service.stop();

        AndroidDriver androidDriver = DriverProvider.crateAndroidDriver(Appiums.LOCAL_APPIUM, Caps.getAndroidCapWithAppPath(AndroidDevice.REALME));
        androidDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        DrragDropMainScreen drragDropMainScreen = new DrragDropMainScreen(androidDriver);

        drragDropMainScreen.getGoToDragDrop().click();

        BasicUsage basicUsage = new BasicUsage(androidDriver);

        AndroidElement controlToDrag1 = basicUsage.getControlsToDrag().get(0);
        AndroidElement controlToDrag2 = basicUsage.getControlsToDrag().get(3);

        TouchAction touchAction = new TouchAction(androidDriver);

        /** To jest drag&drop ale też jest to SWIPE*/

        /** SWIPE po elemenrach*/
        touchAction.press(ElementOption.element(controlToDrag1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.element(controlToDrag2)).release().perform();


        /** SWIPE po punktach elementów*/
        touchAction.press(PointOption.point(controlToDrag1.getCenter())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).moveTo(ElementOption.element(controlToDrag2)).release().perform();

    }

}
