package christmas.domain.event.discount.list;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasDdayDiscountTest {

	private final ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount();

	@DisplayName("크리스마스 디데이 할인 기간일 경우 true를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "3", "24", "25"})
	void isApplicable_true(String visitDate) {
		assertThat(christmasDdayDiscount.isApplicable(new Order("티본스테이크-1"), new VisitDate(visitDate))).isTrue();
	}

	@DisplayName("크리스마스 디데이 할인 기간이 아닐 경우 false를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"26", "30", "31"})
	void isApplicable_false(String visitDate) {
		assertThat(christmasDdayDiscount.isApplicable(new Order("티본스테이크-1"), new VisitDate(visitDate))).isFalse();
	}

	@Test
	@DisplayName("방문날짜가 25일일 경우 할인금액은 3,400원 이다.")
	void getDiscountAmount() {
		assertThat(christmasDdayDiscount.getDiscountAmount
			(new Order("제로콜라-1,티본스테이크-1"), new VisitDate("25"))).isEqualTo(3400);
	}
}