package components.pageObject.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

@Getter
public class AlertViews {
    AppiumDriver driver;

    public AlertViews(WebDriver driver) {
        this.driver = (IOSDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }

    @iOSXCUITFindBy(accessibility = "Text Entry")
    public IOSElement btnTextEntry;

    @iOSXCUITFindBy(iOSNsPredicate = "label ENDSWITH  'Cancel'")
    public List <IOSElement> btnConfCancel;


    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Confirm\"")
    public IOSElement btnConfirmDialog;


    @iOSXCUITFindBy(iOSNsPredicate = "label == \"A message should be a short, complete sentence.\"")
    public IOSElement txtDialogMessage;





    public AlertViewWindow clickTextEntry() {

        btnTextEntry.click();
        System.out.println("Kliknąłem TESXT ENTRY");
        return new AlertViewWindow(driver);

    }

}
