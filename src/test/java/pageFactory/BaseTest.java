package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AndroidDriver<MobileElement> driver;

    @BeforeTest
    public static void setup() {

        try {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            desiredCapabilities.setCapability(MobileCapabilityType.APP,
                    "D:\\Projects\\EasyFitnesAuto\\src\\main\\resources\\apps\\com.easyfitness_38.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"FA78R1A00144");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
//            desiredCapabilities.setCapability(MobileCapabilityType.APP, "PORTRAIT");
            desiredCapabilities.setCapability("intentCategory", "android.intent.category.LAUNCHER");
            desiredCapabilities.setCapability("intentAction", "android.intent.action.MAIN");
            desiredCapabilities.setCapability("appWaitActivity", "com.easyfitness.*");

            URL hub = new URL("http:\\\\127.0.0.1:4723\\wd\\hub");

            driver = new AndroidDriver<MobileElement>(hub, desiredCapabilities);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Exception reason:" + e.getCause());
            System.out.println("Exception message:" + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
//        driver.closeApp();
//        driver.close();
        driver.quit();
    }
}
