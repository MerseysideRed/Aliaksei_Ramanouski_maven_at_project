package tests.w3schools.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.w3schools.GooglePage;
import pages.w3schools.MainPage;

public class W3SchoolClassTest extends BaseTest{

    MainPage mainPage = new MainPage();
    GooglePage googlePage = new GooglePage();

    @Test
    public void testSearchWordFromW3Schools() {

       mainPage.copyTutorialWord();
       mainPage.goToGooglePage();
       googlePage.pasteTutorialWord();
       googlePage.pressEnterKey();

       Assert.assertTrue(googlePage.verifyPresenceTutorialWordInSearchResultSet());
    }
}
