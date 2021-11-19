package components.pageObject.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Getter
@Setter
public class Preferences {

    AppiumDriver driver;

    public Preferences(WebDriver driver) {
        this.driver = (AppiumDriver)driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }

    @AndroidFindBy(accessibility = "3. Preference dependencies")
    private MobileElement preferencesDependencies;

    public WifiPage clickPreferencesDependecies() {
        System.out.println("I am going to click: " + preferencesDependencies.getText());
        preferencesDependencies.click();
        return new WifiPage(driver);

    }

}
