package tests.booking.junit;

import org.junit.Test;
import org.testng.Assert;
import pages.booking.MainPage;
import pages.booking.SearchResultsPage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class BookingClassTest extends BaseTest {

    private MainPage bookingMainPage = new MainPage();
    private SearchResultsPage bookingSearchResultsPage = new SearchResultsPage();

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
        bookingSearchResultsPage.takeScreenshot();
    }

    @Test
    public void testCurrencyTooltipValue() {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.navigateToIndicator("currency");

        Assert.assertEquals(bookingMainPage.getTooltipValue("currency"), "Select your currency");
    }

    @Test
    public void testLanguageTooltipValue() {

        bookingMainPage.closeSignInWindow();
        bookingMainPage.navigateToIndicator("language");

        Assert.assertEquals(bookingMainPage.getTooltipValue("language"), "Select your language");
    }
}
