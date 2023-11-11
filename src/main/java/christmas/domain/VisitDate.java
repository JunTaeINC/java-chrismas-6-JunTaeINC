package christmas.domain;

import static christmas.config.message.ErrorMessage.INVALID_DATE;
import static christmas.domain.constant.DateConstant.CHRISTMAS_D_DAY_DISCOUNT_END_DATE;
import static christmas.domain.constant.DateConstant.CHRISTMAS_D_DAY_DISCOUNT_START_DATE;
import static christmas.domain.constant.DateConstant.MONTH;
import static christmas.domain.constant.DateConstant.SPECIAL_DAYS;
import static christmas.domain.constant.DateConstant.WEEKDAYS;
import static christmas.domain.constant.DateConstant.WEEKEND;
import static christmas.domain.constant.DateConstant.YEARS;

import christmas.domain.constant.DateConstant;
import christmas.validator.InputValidator;
import christmas.validator.NumberValidator;
import java.time.LocalDate;

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

	public boolean isWeekday() {
		LocalDate day = LocalDate.of(YEARS, MONTH, date);
		return WEEKDAYS.contains(day.getDayOfWeek());
	}

	public boolean isWeekend() {
		LocalDate day = LocalDate.of(YEARS, MONTH, date);
		return WEEKEND.contains(day.getDayOfWeek());
	}

	public boolean isSpecialDate() {
		return SPECIAL_DAYS.contains(date);
	}

	public boolean isChristmasDdayPeriod() {
		return CHRISTMAS_D_DAY_DISCOUNT_START_DATE <= date && date <= CHRISTMAS_D_DAY_DISCOUNT_END_DATE;
	}

	public int getChristmasDiscountAccrueDate() {
		return date - 1;
	}
}