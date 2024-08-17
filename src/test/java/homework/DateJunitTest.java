package homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateJunitTest extends DayOfWeekUtility{

    @Test
    public void testInvalidDay() {
        Assert.assertEquals("Test is not passed", "Invalid day number. Please provide a number between 1 and 7.", DayOfWeekUtility.getDayOfWeek(0));
    }

    @Test
    public void testMonday() {
        Assert.assertEquals("Test is not passed", "Monday", DayOfWeekUtility.getDayOfWeek(1));
    }

    @Test
    public void testTuesday() {
        Assert.assertEquals("Test is not passed", "Tuesday", DayOfWeekUtility.getDayOfWeek(2));
    }

    @Test
    public void testWednesday() {
        Assert.assertEquals("Test is not passed", "Wednesday", DayOfWeekUtility.getDayOfWeek(3));
    }

    @Test
    public void testThursday() {
        Assert.assertEquals("Test is not passed", "Thursday", DayOfWeekUtility.getDayOfWeek(4));
    }

    @Test
    public void testFriday() {
        Assert.assertEquals("Test is not passed", "Friday", DayOfWeekUtility.getDayOfWeek(5));
    }

    @Test
    public void testSaturday() {
        Assert.assertEquals("Test is not passed", "Saturday", DayOfWeekUtility.getDayOfWeek(6));
    }

    @Test
    public void testSunday() {
        Assert.assertEquals("Test is not passed", "Sunday", DayOfWeekUtility.getDayOfWeek(7));
    }
}
