package pageFactory.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageFactory.PageObject;


public class HomePage extends PageObject {

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
