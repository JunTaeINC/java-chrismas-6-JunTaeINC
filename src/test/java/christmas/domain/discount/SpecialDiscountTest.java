package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountTest {

	private final SpecialDiscount specialDiscount = new SpecialDiscount();

	@DisplayName("방문날짜가 특별할인 날짜면 true를 반환한다")
	@ParameterizedTest
	@ValueSource(ints = {3,10,17})
	void isApplicable_true(int date) {
		assertThat(specialDiscount.isApplicable(date)).isTrue();
	}

	@DisplayName("방문날짜가 특별할인 날짜가 아닐 경우 false를 반환한다")
	@ParameterizedTest
	@ValueSource(ints = {1,2,28})
	void isApplicable_false(int date) {
		assertThat(specialDiscount.isApplicable(date)).isFalse();
	}
}