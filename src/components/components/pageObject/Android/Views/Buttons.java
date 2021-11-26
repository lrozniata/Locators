package components.pageObject.Android.Views;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Buttons extends Views {
    public Buttons(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "io.appium.android.apis:id/button_normal")
    public AndroidElement btnNormal;


}
