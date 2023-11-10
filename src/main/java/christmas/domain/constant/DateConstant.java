package christmas.domain.constant;

import java.util.List;
import java.util.regex.Pattern;

public class DateConstant {

	public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])");
	public static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
}