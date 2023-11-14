package christmas.domain.constant;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.time.DayOfWeek;
import java.util.List;

public class DateConstant {

	public static final int YEARS = 2023;
	public static final int MONTH = 12;
	public static final int CHRISTMAS_D_DAY_DISCOUNT_START_DATE = 1;
	public static final int CHRISTMAS_D_DAY_DISCOUNT_END_DATE = 25;
	public static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
	public static final List<DayOfWeek> WEEKDAYS = List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, SUNDAY);
	public static final List<DayOfWeek> WEEKEND = List.of(FRIDAY, SATURDAY);
}