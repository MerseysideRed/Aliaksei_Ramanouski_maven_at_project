package tests.booking.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.booking.MainPage;
import pages.booking.PropertyPage;
import pages.booking.SearchResultsPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BookingClassTest extends BaseTest {

    private MainPage bookingMainPage;
    private SearchResultsPage bookingSearchResultsPage;
    private PropertyPage propertyPage;
    private static final Logger LOGGER = LogManager.getLogger(tests.booking.junit.BookingClassTest.class);

    @BeforeMethod
    public void setupPages() {
        bookingMainPage = new MainPage();
        bookingSearchResultsPage = new SearchResultsPage();
        propertyPage = new PropertyPage();
    };

    @Test
    public void testCorrectPropertyRate() {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.setSearchCityField("Paris");
        bookingMainPage.setTimeRangeField(3, 10);
        bookingMainPage.setQuantityParametersOfPeopleAndRooms("4", "2");
        bookingMainPage.clickSearchButton();
        bookingSearchResultsPage.selectPropertyTypeCheckbox("Hotels");
        bookingSearchResultsPage.selectPropertyRatingCheckbox("5 stars");
        bookingSearchResultsPage.explicitWaitOfDisplayedLabelOfRate(5);
        bookingSearchResultsPage.clickToDropdownSortingList();
        bookingSearchResultsPage.clickToPropertyRatingLowToHighOptionOfDropdownSortingList();

        assertEquals("5 out of 5", bookingSearchResultsPage.getRateFromPropertyCard(1));

        LOGGER.debug("Test testCorrectPropertyRate is completed");
    }

    @Test
    public void testChangeColorOfBackgroundPropertyCard() throws IOException {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.setSearchCityField("London");
        bookingMainPage.setTimeRangeField(1, 2);
        bookingMainPage.clickSearchButton();
        bookingSearchResultsPage.selectPropertyTypeCheckbox("Hotels");
        bookingSearchResultsPage.scrollToPropertyCard(10);
        bookingSearchResultsPage.changePropertyCardBackgroundColor(10);
        bookingSearchResultsPage.takeScreenshot("src/test/screenshots", "pic.png");

        LOGGER.debug("Test without assert testChangeColorOfBackgroundPropertyCard is completed");
    }

    @Test
    public void testCurrencyTooltipValue() {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.navigateToIndicator("currency");

        Assert.assertEquals(bookingMainPage.getTooltipValue("currency"), "Select your currency");

        LOGGER.debug("Test testCurrencyTooltipValue is completed");
    }

    @Test
    public void testLanguageTooltipValue() {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.navigateToIndicator("language");

        Assert.assertEquals(bookingMainPage.getTooltipValue("language"), "Select your language");

        LOGGER.debug("Test testLanguageTooltipValue is completed");
    }

    @Test public void testCorrectPropertyScoreRate() {
        bookingMainPage.closeSignInWindow();
        bookingMainPage.setSearchCityField("Прага");
        bookingMainPage.setTimeRangeField(3, 10);
        bookingMainPage.setQuantityParametersOfPeopleAndRooms("2", "1");
        bookingMainPage.clickSearchButton();
        bookingSearchResultsPage.selectPropertyTypeCheckbox("Hotels");
        bookingSearchResultsPage.selectScoreRateCheckbox("Wonderful: 9+");
        bookingSearchResultsPage.explicitWaitOfDisplayedLabelOfScoreRate("review_score=90");
        bookingSearchResultsPage.clickToPropertyCardImage(1);
        bookingSearchResultsPage.switchToTab(1);

        assertTrue(propertyPage.getPropertyRate() >= 9);

        LOGGER.debug("Test testCorrectPropertyScoreRate is completed");
    }
}
