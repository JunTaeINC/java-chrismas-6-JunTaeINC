package christmas.domain;

import static christmas.config.message.ErrorMessage.INVALID_DATE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

	private Exception exception;
	private VisitDate visitDate;

	@DisplayName("방문 날짜 객체가 올바르게 생성되는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "4", "6", "31"})
	void testValidate_WhenValid(String date) {
		assertDoesNotThrow(() -> new VisitDate(date));
	}

	@Test
	@DisplayName("방문 날짜 입력시 공백을 입력할 경우 예외 발생")
	void testValidate_WhenBlank() {
		String blank = "";

		exception = assertThrows(IllegalArgumentException.class, () -> new VisitDate(blank));

		assertEquals(exception.getMessage(), INVALID_DATE.getMessage());
	}

	@Test
	@DisplayName("방문 날짜 입력시 문자를 입력할 경우 예외 발생")
	void testValidate_WhenString() {
		String letter = "십일일";

		exception = assertThrows(IllegalArgumentException.class, () -> new VisitDate(letter));

		assertEquals(exception.getMessage(), INVALID_DATE.getMessage());
	}

	@Test
	@DisplayName("방문 날짜 입력시 문자를 입력할 경우 예외 발생")
	void testValidate_WhenInvalidDateRange() {
		String over_range = "32";

		exception = assertThrows(IllegalArgumentException.class, () -> new VisitDate(over_range));

		assertEquals(exception.getMessage(), INVALID_DATE.getMessage());
	}

	@DisplayName("방문 날짜가 평일일 경우 true 반환")
	@ParameterizedTest
	@ValueSource(strings = {"4","12","27"})
	void isWeekday_true(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isWeekday();

		assertThat(result).isTrue();
	}

	@DisplayName("방문 날짜가 평일이 아닐 경우 false 반환")
	@ParameterizedTest
	@ValueSource(strings = {"8","16","23"})
	void isWeekday_false(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isWeekday();

		assertThat(result).isFalse();
	}

	@DisplayName("방문 날짜가 주말일 경우 true 반환")
	@ParameterizedTest
	@ValueSource(strings = {"8","16","23"})
	void isWeekend_true(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isWeekend();

		assertThat(result).isTrue();
	}

	@DisplayName("방문 날짜가 주말이 아닌 경우 false 반환")
	@ParameterizedTest
	@ValueSource(strings = {"4","12","27"})
	void isWeekend_false(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isWeekend();

		assertThat(result).isFalse();
	}

	@DisplayName("방문 날짜가 특별 할인 적용날일 경우 true 반환")
	@ParameterizedTest
	@ValueSource(strings = {"3","10","17"})
	void isSpecialDate_true(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isSpecialDate();

		assertThat(result).isTrue();
	}

	@DisplayName("방문 날짜가 특별 할인 적용날이 아닐 경우 false 반환")
	@ParameterizedTest
	@ValueSource(strings = {"18","20","27"})
	void isSpecialDate_false(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isSpecialDate();

		assertThat(result).isFalse();
	}

	@DisplayName("방문 날짜가 크리스마스 디데이 할인 적용날일 경우 true 반환")
	@ParameterizedTest
	@ValueSource(strings = {"3","10","17"})
	void isChristmasDdayPeriod_true(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isChristmasDdayPeriod();

		assertThat(result).isTrue();
	}

	@DisplayName("방문 날짜가 크리스마스 디데이 할인 적용날이 아닐 경우 false 반환")
	@ParameterizedTest
	@ValueSource(strings = {"28","29","31"})
	void isChristmasDdayPeriod_false(String date) {
		visitDate = new VisitDate(date);

		boolean result = visitDate.isChristmasDdayPeriod();

		assertThat(result).isFalse();
	}
}