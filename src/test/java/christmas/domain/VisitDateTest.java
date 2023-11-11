package christmas.domain;

import static christmas.config.message.ErrorMessage.INVALID_DATE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

	private Exception exception;

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
}