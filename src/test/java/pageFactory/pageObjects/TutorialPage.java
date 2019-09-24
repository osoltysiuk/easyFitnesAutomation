package pageFactory.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.PageObject;


public class TutorialPage extends PageObject {

    public TutorialPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    //ELEMENTS
    @FindBy(id = "com.easyfitness:id/mi_button_next")
    private WebElement nextButton;


    //ACTIONS
    public void next() {
        this.nextButton.click();
    }

    public CreateProfilePage passAllTutorialPages() {
        for (int i = 0; i < 4; i++) {
            this.next();
        }
        return new CreateProfilePage(driver);
    }
}
