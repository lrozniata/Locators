import components.pageObject.iOS.MainScreenIOS;
import org.junit.Test;


public class iOSTest {


    @Test
    public void iODTest(){

        MainScreenIOS mainScreenIOS = new MainScreenIOS(DriverProvider.crateiOSDriver(Devices.SYMULATOR12PROMAX));

        System.out.println("takTylko");




    }


}


