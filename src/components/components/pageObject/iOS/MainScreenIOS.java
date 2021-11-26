package components.pageObject.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Getter
public class MainScreenIOS {

    AppiumDriver driver;

    public MainScreenIOS(WebDriver driver) {
        this.driver = (IOSDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]")
    /** 1. Najszybszy Czas: 341ms */
    @iOSXCUITFindBy(accessibility = "Alert Views")
    /** 3. Czas: 349 ms*/
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Alert Views\"")
    /** 2. Czas: 345ms */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Alert Views\"]")
    /** 4. Czas: 629ms */
    public MobileElement alertView;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Buttons\"")
    public IOSElement btnButtons;

    public AlertViews clickOnAlertView() {

        alertView.click();

        System.out.println("liknąłem AlertView");
        return new AlertViews(driver);
    }




}