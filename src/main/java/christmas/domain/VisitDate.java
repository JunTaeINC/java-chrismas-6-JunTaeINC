package christmas.domain;

import static christmas.config.message.ErrorMessage.INVALID_DATE;

import christmas.domain.constant.DateConstant;
import christmas.validator.InputValidator;
import christmas.validator.NumberValidator;

public class VisitDate {

	private final int date;

	public VisitDate(String date) {
		validate(date);

		this.date = convertToInt(date);
	}

	private void validate(String date) {
		if (!NumberValidator.isNumeric(date)) {
			throw new IllegalArgumentException(INVALID_DATE.getMessage());
		}

		if (InputValidator.isBlank(date)) {
			throw new IllegalArgumentException(INVALID_DATE.getMessage());
		}

		if (!isValidDay(date)) {
			throw new IllegalArgumentException(INVALID_DATE.getMessage());
		}
	}

	private static boolean isValidDay(String date) {
		return date.matches(DateConstant.DAY_OF_MONTH_PATTERN.pattern());
	}

	private int convertToInt(String date) {
		return Integer.parseInt(date);
	}
}