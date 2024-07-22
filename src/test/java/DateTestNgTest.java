import org.testng.annotations.*;

import static org.testng.AssertJUnit.*;

public class DateTestNgTest {

    @Test
    public void testInvalidDay() {
        assertEquals("Test is not passed", "Invalid day number. Please provide a number between 1 and 7.", DayOfWeekUtility.getDayOfWeek(0));
    }

    @Test
    public void testMonday() {
        assertEquals("Test is not passed", "Monday", DayOfWeekUtility.getDayOfWeek(1));
    }

    @Test
    public void testTuesday() {
        assertEquals("Test is not passed", "Tuesday", DayOfWeekUtility.getDayOfWeek(2));
    }

    @Test
    public void testWednesday() {
        assertEquals("Test is not passed", "Wednesday", DayOfWeekUtility.getDayOfWeek(3));
    }

    @Test
    public void testThursday() {
        assertEquals("Test is not passed", "Thursday", DayOfWeekUtility.getDayOfWeek(4));
    }

    @Test
    public void testFriday() {
        assertEquals("Test is not passed", "Friday", DayOfWeekUtility.getDayOfWeek(5));
    }

    @Test
    public void testSaturday() {
        assertEquals("Test is not passed", "Saturday", DayOfWeekUtility.getDayOfWeek(6));
    }

    @Test
    public void testSunday() {
        assertEquals("Test is not passed", "Sunday", DayOfWeekUtility.getDayOfWeek(7));
    }
}
