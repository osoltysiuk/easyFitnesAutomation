package tests;

import org.testng.annotations.Test;
import pageFactory.BaseTest;
import pageFactory.pageObjects.CreateProfilePage;
import pageFactory.pageObjects.ProfileCreatedPage;
import pageFactory.pageObjects.TutorialPage;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CreatingProfileSuite extends BaseTest {

    @Test
    public void createProfileViaCreateProfilePageOnlyNameFilledInFemale() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        CreateProfilePage createProfilePage = tutorialPage.passAllTutorialPages();
        createProfilePage.selectFemale();
        final String PROFILE_NAME = "AnyName";
        ProfileCreatedPage profileCreatedPage = createProfilePage.createProfileSuccess(PROFILE_NAME);
        profileCreatedPage.validateProfileCreatedLabel();
        profileCreatedPage.validateProfileName(PROFILE_NAME);
    }

    @Test
    public void createProfileViaCreateProfilePageNameAndDateOfBirthAreFilledInMale() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        CreateProfilePage createProfilePage = tutorialPage.passAllTutorialPages();
        createProfilePage.selectMale();
        createProfilePage.fillBirthday(new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime());
        final String PROFILE_NAME = "AnyName";
        ProfileCreatedPage profileCreatedPage = createProfilePage.createProfileSuccess(PROFILE_NAME);
        profileCreatedPage.validateProfileCreatedLabel();
        profileCreatedPage.validateProfileName(PROFILE_NAME);
    }

    @Test
    public void createProfileViaCreateProfilePageNameDateOfBirthAndSizeAreFilledInOther() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        CreateProfilePage createProfilePage = tutorialPage.passAllTutorialPages();
        createProfilePage.selectOther();
        createProfilePage.fillBirthday(new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime());
        createProfilePage.fillSize(80);
        final String PROFILE_NAME = "AnyName";
        ProfileCreatedPage profileCreatedPage = createProfilePage.createProfileSuccess(PROFILE_NAME);
        profileCreatedPage.validateProfileCreatedLabel();
        profileCreatedPage.validateProfileName(PROFILE_NAME);
    }

    @Test
    public void createProfilePageNegativeTestNameIsNotFilledIn() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        CreateProfilePage createProfilePage = tutorialPage.passAllTutorialPages();
        createProfilePage.createProfileFail();
        createProfilePage.validateCreateProfilePagePresence();
    }

    @Test
    public void createProfilePageCheckElementsText() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        CreateProfilePage createProfilePage = tutorialPage.passAllTutorialPages();
        createProfilePage.validateCreateProfileLabelsText();
    }

}
