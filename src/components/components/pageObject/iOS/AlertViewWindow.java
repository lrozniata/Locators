package components.pageObject.iOS;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;

public class AlertViewWindow extends AlertViews {

    public AlertViewWindow(WebDriver driver) {
        super(driver);
    }



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    public IOSElement txtTextEntry;


    @iOSXCUITFindBy(accessibility = "OK")
    public IOSElement btnOK;


}
