package steps.booking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.booking.MainPage;
import pages.booking.PropertyPage;
import pages.booking.SearchResultsPage;
import tests.booking.junit.BaseTest;

import java.time.Duration;

public class Steps extends BaseTest {

    private BaseTest baseTest = new BaseTest();
    private MainPage bookingMainPage = new MainPage();
    private SearchResultsPage bookingSearchResultsPage = new SearchResultsPage();
    private PropertyPage propertyPage = new PropertyPage();

    @Given("I open booking main page")
    public void openMainPage() {
       baseTest.initDriver();
    }

    @When("I close Sign-in window")
    public void closeSignInWindow() {
        bookingMainPage.closeSignInWindow();
    }

    @When("I fill search {string} field")
    public void fillSearchCityField(String city) {
        bookingMainPage.setSearchCityField(city);
    }

    @And("set first date plus {int} days and second date plus {int} days")
    public void setTimeRange(int plusDaysFromFirstDate, int plusDaysFromSecondDate) {
        bookingMainPage.setTimeRangeField(plusDaysFromFirstDate, plusDaysFromSecondDate);
    }

    @And("set quantity adults with value {string} and quantity rooms with value {string}")
    public void setQuantityParametersOfPeopleAndRooms(String quantityOfAdults, String quantityOfRooms) {
        bookingMainPage.setQuantityParametersOfPeopleAndRooms(quantityOfAdults, quantityOfRooms);
    }

    @And("click to search button")
    public void clickSearchButton() {
        bookingMainPage.clickSearchButton();
    }

    @And("select {string} as type of property")
    public void selectPropertyTypeCheckbox(String propertyType) {
        bookingSearchResultsPage.selectPropertyTypeCheckbox(propertyType);
    }

    @And("choose property with {string} stars")
    public void selectPropertyRatingCheckbox(String propertyRateInStars) {
        bookingSearchResultsPage.selectPropertyRatingCheckbox(propertyRateInStars);
    }

    @And("wait until {int} rate label will be displayed")
    public void explicitWaitOfDisplayedLabelOfRate(int propertyRate) {
        bookingSearchResultsPage.explicitWaitOfDisplayedLabelOfRate(propertyRate);
    }

    @And("click to dropdown sorting list")
    public void clickToDropdownSortingList() {
        bookingSearchResultsPage.clickToDropdownSortingList();
    }

    @And("click to low to high option of dropdown sorting list")
    public void clickToPropertyRatingLowToHighOptionOfDropdownSortingList() {
        bookingSearchResultsPage.clickToPropertyRatingLowToHighOptionOfDropdownSortingList();
    }

    @Then("see correct rate of {int} property card order number")
    public void doAssert(int propertyCardOrderNumber) {
        Assert.assertEquals("5 out of 5", bookingSearchResultsPage.getRateFromPropertyCard(propertyCardOrderNumber));
        baseTest.closeDriver();
    }

    @When("I navigate to {string} tooltip")
    public void navigateToTooltip(String indicatorType) {
        bookingMainPage.navigateToIndicator(indicatorType);
    }

    @Then("I see correct value of {string} tooltip")
    public void assertTooltipValue(String indicatorType) {
        Assert.assertEquals(String.format("Select your %s", indicatorType), bookingMainPage.getTooltipValue(indicatorType));
        baseTest.closeDriver();
    }

    @And("activate score rate checkbox with value {string}")
    public void selectScoreRateCheckbox(String scoreRateText) {
        bookingSearchResultsPage.selectScoreRateCheckbox(scoreRateText);
    }

    @And("wait until score rate label {string} will be displayed")
    public void waitDisplayedScoreRateLabel(String scoreRateLabelClass) {
        bookingSearchResultsPage.explicitWaitOfDisplayedLabelOfScoreRate(scoreRateLabelClass);
    }

    @And("click to image of {int} property card")
    public void clickToPropertyCardImage(int propertyCardOrderNumber) {
        bookingSearchResultsPage.clickToPropertyCardImage(propertyCardOrderNumber);
    }

    @And("switch to {int} tab")
    public void switchToTab(int orderTabNumber) {
        bookingSearchResultsPage.switchToTab(orderTabNumber);
    }

    @Then("I see correct value equal or more than {int} of score property rate")
    public void assertPropertyScoreRate(int scoreRateValue) {
        Assert.assertTrue(propertyPage.getPropertyRate() >= scoreRateValue);
    }
}
