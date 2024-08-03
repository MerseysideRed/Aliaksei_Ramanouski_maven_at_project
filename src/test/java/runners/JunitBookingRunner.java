package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.junit.BookingClassTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingClassTest.class})
public class JunitBookingRunner {


}
