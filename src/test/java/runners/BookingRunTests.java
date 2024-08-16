package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"steps.booking"},
        features = {"src/test/resources/features/outlines/RatesTests.feature",
                "src/test/resources/features/scenarios/TooltipTests.feature"}
)

public class BookingRunTests {
}
