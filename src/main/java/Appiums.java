import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Appiums {

    static final String MAC_APPIUM_SERVER_URL = "http://192.168.1.92:4724/wd/hub";
    static final String LOCAL_APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";


     static URL LOCAL_APPIUM;

    static {
        try {
            LOCAL_APPIUM = new URL(LOCAL_APPIUM_SERVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    static URL REMOTE_APPIUM;

    static {
        try {
            REMOTE_APPIUM = new URL(MAC_APPIUM_SERVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
