package pageFactory.pageObjects;

import StaticDataProvider.StaticDataProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageFactory.PageObject;

public class ProfileCreatedPage extends PageObject {

    public ProfileCreatedPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    //ELEMENTS
    @FindBy(id = "com.easyfitness:id/content_text")
    private WebElement profileCreatedLabel;

    @FindBy(id = "com.easyfitness:id/title_text")
    private WebElement profileNameLabel;

    @FindBy(id = "com.easyfitness:id/confirm_button")
    private WebElement okButton;


    //VALIDATORS
    public void validateProfileCreatedLabel() {
        Assert.assertEquals(this.profileCreatedLabel.getText(), StaticDataProvider.PROFILE_CREATED_TEXT,
                "Wrong confirmation message on profile creation");
    }

    public void validateProfileName(String name) {
        Assert.assertEquals(this.profileNameLabel.getText(), name,
                "Wrong confirmation message on profile creation");
    }


}
