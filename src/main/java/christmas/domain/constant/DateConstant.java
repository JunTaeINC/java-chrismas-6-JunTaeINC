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
import java.util.regex.Pattern;

public class DateConstant {

	public static final int YEARS = 2023;
	public static final int MONTH = 12;
	// TODO : 조금더 나은 방법 있을듯(리펙토링 필요)
	public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])");
	public static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
	public static final List<DayOfWeek> WEEKDAYS = List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, SUNDAY);
	public static final List<DayOfWeek> WEEKEND = List.of(FRIDAY, SATURDAY);
}