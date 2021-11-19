package components.pageObject.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Getter
@Setter
public class MainScreen {

    AppiumDriver driver;

    public MainScreen(WebDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
       /**Pole media zostało zainicjowane przez PageFactor*/
        setMedia("Media");
        /**Nadpisałem lokator PageFactora swoim w którym mogę już kombinować kodem */
    }

    public void setMedia (String text){
        AndroidDriver and = (AndroidDriver)this.driver;
        media = (MobileElement) and.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")");
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Media\")")
    private MobileElement media;


    public void setMedia (){
        AndroidDriver and = (AndroidDriver)this.driver;
        media = (MobileElement) and.findElementByAndroidUIAutomator("new UiSelector().text(\"Media\")");
    }



    @AndroidFindBy(accessibility = "Preference")
    private MobileElement preferences;



    private String wb;

    public Preferences clickPreferences() {
        System.out.println("I am going to click: " + preferences.getText());
        preferences.click();
        return new Preferences(driver);

    }

}