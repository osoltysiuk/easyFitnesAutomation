package pageFactory.pageObjects;

import StaticDataProvider.StaticDataProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageFactory.PageObject;

import java.util.Date;


public class CreateProfilePage extends PageObject {

    public CreateProfilePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    //ELEMENTS
    @FindBy(xpath = "//*[@resource-id=\"com.easyfitness:id/mi_pager\"]/android.widget.ScrollView/" +
            "android.widget.LinearLayout/android.widget.TextView")
    private WebElement createProfileHeader;

    @FindBy(id = "com.easyfitness:id/profileName")
    private WebElement nameField;

    @FindBy(id = "com.easyfitness:id/radioButtonMale")
    private WebElement maleButton;

    @FindBy(id = "com.easyfitness:id/radioButtonFemale")
    private WebElement femaleButton;

    @FindBy(id = "com.easyfitness:id/radioButtonOtherGender")
    private WebElement otherButton;

    @FindBy(id = "com.easyfitness:id/profileBirthday")
    private WebElement birthdayField;

    @FindBy(id = "com.easyfitness:id/profileSize")
    private WebElement sizeField;

    @FindBy(id = "com.easyfitness:id/create_newprofil")
    private WebElement createButton;

    @FindBy(id = "com.easyfitness:id/mi_button_next")
    private WebElement acceptButton;


    //ACTIONS
    public ProfileCreatedPage createProfileSuccess(String name) {
        this.nameField.sendKeys(name);
        this.acceptButton.click();
        return new ProfileCreatedPage(driver);
        }

    public void createProfileFail() {
        this.acceptButton.click();
    }

    public void selectMale() {
        this.maleButton.click();
    }

    public void selectFemale() {
        this.femaleButton.click();
    }

    public void selectOther() {
        this.otherButton.click();
    }

    public void fillBirthday(Date date) {
        this.birthdayField.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        driver.navigate().back();
        this.birthdayField.sendKeys(date.getDate() + "/" + date.getMonth() + "/" + date.getYear());
    }

    public void fillSize(int size) {
        this.sizeField.sendKeys(Integer.toString(size));
    }


    //VALIDATORS
    public void validateCreateProfilePagePresence() {
        Assert.assertTrue(this.createProfileHeader.isDisplayed(),
                "Create profile page is not present on the screen");
    }

    public void validateCreateProfileLabelsText() {
        Assert.assertEquals(this.createProfileHeader.getText(), StaticDataProvider.CREATE_PROFILE_TEXT,
                "Create profile page header text is wrong");
        Assert.assertEquals(this.maleButton.getText(), StaticDataProvider.MALE_BUTTON_TEXT,
                "Create profile page Male button text is wrong");
        Assert.assertEquals(this.femaleButton.getText(), StaticDataProvider.FEMALE_BUTTON_TEXT,
                "Create profile page Female button text is wrong");
        Assert.assertEquals(this.otherButton.getText(), StaticDataProvider.OTHER_BUTTON_TEXT,
                "Create profile page Other button text is wrong");
        Assert.assertEquals(this.nameField.getText(), StaticDataProvider.NAME_FIELD_TEXT,
                "Create profile page Name field text is wrong");
        Assert.assertEquals(this.birthdayField.getText(), StaticDataProvider.BIRTHDAY_FIELD_TEXT,
                "Create profile page Birthday field text is wrong");
        Assert.assertEquals(this.sizeField.getText(), StaticDataProvider.SIZE_FIELD_TEXT,
                "Create profile page Size field text is wrong");
        Assert.assertEquals(this.createButton.getText(), StaticDataProvider.CREATE_BUTTON_TEXT,
                "Create profile page Create button text is wrong");
    }

}
