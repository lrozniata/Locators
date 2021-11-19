package components.pageObject.Android;

import com.android.uiautomator.stub.UiSelector;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

@Getter
public class WifiPage {

    AppiumDriver driver;


    public WifiPage(AppiumDriver driver) {

        this.driver =(AndroidDriver)driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }



//    @AndroidFindBy(uiAutomator = "new UiSelector().checkable(true)")

    @AndroidFindBy(className = "android.widget.CheckBox")
     private AndroidElement checkButtonWifi;









}
