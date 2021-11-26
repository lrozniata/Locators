package components.pageObject.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
@Getter
public class Buttons {

    AppiumDriver driver;

    public Buttons(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`][1]")   /** CAŁYM DRZEWIE SZUKAJ  1SZEGO BUTTONA O LABELCE "BUTTON"*/
    private IOSElement btnButtonFirst;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`][2]")   /** CAŁYM DRZEWIE SZUKAJ  2 GO BUTTONA O LABELCE "BUTTON"*/
    private IOSElement btnButtonMiddle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`][-1]")  /** CAŁYM DRZEWIE SZUKAJ  1SZEGO OD KOŃCA  BUTTONA O LABELCE "BUTTON"*/
    private IOSElement btnButtonLast;
}
