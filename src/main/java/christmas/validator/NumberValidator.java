package christmas.validator;

import java.util.regex.Pattern;

public class NumberValidator {

	private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");
	private static final Pattern QUANTITY_PATTERN = Pattern.compile("^[1-9][0-9]*$");

	public static boolean isNumeric(String date) {
		if (date == null) {
			return false;
		}

		return NUMERIC_PATTERN.matcher(date).matches();
	}

	public static boolean isValidQuantity(String quantity) {
		if (quantity == null) {
			return false;
		}

		return QUANTITY_PATTERN.matcher(quantity).matches();
	}
}