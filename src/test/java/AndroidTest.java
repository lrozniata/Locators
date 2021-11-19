import components.pageObject.Android.MainScreen;
import components.pageObject.Android.WifiPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AndroidTest {

    @Test
    public void test1() throws InterruptedException {
        StopWatch watch = new StopWatch();
        MainScreen mainScreen = new MainScreen(DriverProvider.crateAndroidDriver(Devices.REALME));
        mainScreen.getDriver().manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

        WifiPage wifiPage = mainScreen.clickPreferences().clickPreferencesDependecies();
        AndroidDriver driver = (AndroidDriver)mainScreen.getDriver();


        AndroidElement checkBox = wifiPage.getCheckButtonWifi();

        WebDriverWait wait = new WebDriverWait(driver, 7);


        try {
            wait.until(ExpectedConditions.attributeToBe(checkBox, "checked", "true"));

        } catch (TimeoutException t) {
            wifiPage.getCheckButtonWifi().click();

        }

//        System.out.println("Re you there? " + until);
    }

}
