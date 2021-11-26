package components.pageObject.Android.dragdrop;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
@Getter
public class BasicUsage {


    AndroidDriver androidDriver;

    public BasicUsage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy (id = "com.mobeta.android.demodslv:id/drag_handle")
    List<AndroidElement> controlsToDrag;

}
