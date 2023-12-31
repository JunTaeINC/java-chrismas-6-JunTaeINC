package christmas.domain.event.discount.list;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDiscountableTest {

	private final SpecialDiscount specialDiscount = new SpecialDiscount();

	@DisplayName("방문날짜가 특별할인 날짜면 true를 반환한다")
	@ParameterizedTest
	@ValueSource(strings = {"3", "10", "17"})
	void isApplicable_true(String visitDate) {
		assertThat(specialDiscount.isApplicable(new Order("티본스테이크-1"), new VisitDate(visitDate))).isTrue();
	}

	@DisplayName("방문날짜가 특별할인 날짜가 아닐 경우 false를 반환한다")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "28"})
	void isApplicable_false(String visitDate) {
		assertThat(specialDiscount.isApplicable(new Order("티본스테이크-1"), new VisitDate(visitDate))).isFalse();
	}
}