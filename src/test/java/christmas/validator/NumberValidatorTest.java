package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Nested
class NumberValidatorTest {

	@DisplayName("입력한 값이 정수이면 true를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2000", "12", "25"})
	void isNumeric_true(String number) {
		assertThat(NumberValidator.isNumeric(number)).isTrue();
	}

	@DisplayName("입력한 값이 정수가 아니면 false를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"일", "이", "하늘", "천"})
	void isNumeric_false(String number) {
		assertThat(NumberValidator.isNumeric(number)).isFalse();
	}
}