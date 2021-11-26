
import Devices.AndroidDevice;
import Devices.IOSDevice;
import components.pageObject.iOS.Buttons;
import components.pageObject.iOS.MainScreenIOS;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Test;

public class iOSTest {

    IOSDriver driver;

    @Test
    public void iODTest() {
//        StopWatch watch = new StopWatch();
//        long sum = 0;
//
//        for (int i = 0; i <= 10; i++) {
//
//            MainScreenIOS mainScreenIOS = new MainScreenIOS(DriverProvider.crateiOSDriver(Devices.SYMULATOR12PROMAX));
//            watch.start();
//            mainScreenIOS.alertView.click();
//            watch.stop();
//
//            long result = watch.getTime(TimeUnit.MILLISECONDS);
//            watch.reset();
//            sum = sum + result;
//            System.out.println(i + " Klikniecie AlertView w czasie:  " + result + "ms");
//
//        }
//
//        System.out.println("Srednio: " + sum / 10 + "ms");

        driver =DriverProvider.crateiOSDriver(Appiums.REMOTE_APPIUM,Caps.getiOSCapWitchAppPath(IOSDevice.SYMULATOR12PROMAX));

        MainScreenIOS mainScreenIOS = new MainScreenIOS(driver);

       mainScreenIOS.btnButtons.click();



        Buttons buttons = new Buttons(driver);

        System.out.println("X:    "+ buttons.getBtnButtonFirst().getLocation().x + " Y:    "+ buttons.getBtnButtonFirst().getLocation().y);


        System.out.println("X:    "+ buttons.getBtnButtonMiddle().getLocation().x + " Y:    "+ buttons.getBtnButtonMiddle().getLocation().y);


        System.out.println("X:    "+ buttons.getBtnButtonLast().getLocation().x + " Y:    "+ buttons.getBtnButtonLast().getLocation().y);






//        System.out.println("Do zmiennej btnConfCancel przypisało się zmiennych: " + alertView.btnConfCancel.size() +
//                "\nPierwsza przypisany button to:  " + alertView.btnConfCancel.get(0).getText() +
//                "\nDruga przypisana kontrolka to: "+alertView.btnConfCancel.get(1).getText());




//         AlertViewWindow alertViewWindow= alertView.clickTextEntry();
//         alertViewWindow.txtTextEntry.sendKeys("Duupsko");
//         alertViewWindow.btnOK.click();
//         alertView.btnConfCancel.click();
//        Assert.assertEquals("Sprdz czy komunikat zgodny","A message should be a short, complete sentence.",alertView.txtDialogMessage.getText());
//         alertView.btnConfirmDialog.click();

    }

}


